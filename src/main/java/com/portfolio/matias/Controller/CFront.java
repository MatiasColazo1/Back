package com.portfolio.matias.Controller;


import com.portfolio.matias.Dto.dtoFront;
import com.portfolio.matias.Entity.Front;
import com.portfolio.matias.Security.Controller.Mensaje;
import com.portfolio.matias.Service.SFront;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/front")
@CrossOrigin(origins = "https://frontendmatias.web.app")
public class CFront {
    @Autowired
    SFront sFront;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Front>> list(){
        List<Front> list = sFront.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Front> getById(@PathVariable("id") int id){
        if(!sFront.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Front front = sFront.getOne(id).get();
        return new ResponseEntity(front, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el id
        if(!sFront.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sFront.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFront dtofro){
        if(StringUtils.isBlank(dtofro.getNombreF()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sFront.existsByNombreF(dtofro.getNombreF()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
            
        Front front = new Front(dtofro.getNombreF(), dtofro.getPorcentajeF());
        sFront.save(front);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoFront dtofro){
        //Validamos si existe el id
        if(!sFront.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencia
        if(sFront.existsByNombreF(dtofro.getNombreF()) && sFront.getByNombreF(dtofro.getNombreF()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtofro.getNombreF()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Front front = sFront.getOne(id).get();
        front.setNombreF(dtofro.getNombreF());
        front.setPorcentajeF(dtofro.getPorcentajeF());
        
        sFront.save(front);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}
