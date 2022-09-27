package com.portfolio.matias.Controller;

import com.portfolio.matias.Dto.dtoBack;
import com.portfolio.matias.Entity.Back;
import com.portfolio.matias.Security.Controller.Mensaje;
import com.portfolio.matias.Service.SBack;
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
@RequestMapping("/back")
@CrossOrigin(origins = "http://localhost:4200")
public class CBack {
    @Autowired
    SBack sBack;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Back>> list(){
        List<Back> list = sBack.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Back> getById(@PathVariable("id") int id){
        if(!sBack.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Back back = sBack.getOne(id).get();
        return new ResponseEntity(back, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el id
        if(!sBack.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sBack.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoBack dtoback){
        if(StringUtils.isBlank(dtoback.getNombreB()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sBack.existsByNombreB(dtoback.getNombreB()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
            
        Back back = new Back(dtoback.getNombreB(), dtoback.getPorcentajeB());
        sBack.save(back);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBack dtoback){
        //Validamos si existe el id
        if(!sBack.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencia
        if(sBack.existsByNombreB(dtoback.getNombreB()) && sBack.getByNombreB(dtoback.getNombreB()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoback.getNombreB()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Back back = sBack.getOne(id).get();
        back.setNombreB(dtoback.getNombreB());
        back.setPorcentajeB(dtoback.getPorcentajeB());
        
        sBack.save(back);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}
