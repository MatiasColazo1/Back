package com.portfolio.matias.Controller;

import com.portfolio.matias.Dto.dtoProyecto;
import com.portfolio.matias.Entity.Proyecto;
import com.portfolio.matias.Security.Controller.Mensaje;
import com.portfolio.matias.Service.SProyecto;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el id
        if(!sProyecto.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro){
        if(StringUtils.isBlank(dtopro.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyecto.existsByNombreP(dtopro.getNombreP()))
            return new ResponseEntity(new Mensaje("Este proyecto ya existe"), HttpStatus.BAD_REQUEST);
            
        Proyecto proyecto = new Proyecto(
                dtopro.getNombreP(), dtopro.getDescripcionP(),
                dtopro.getImagenP(), dtopro.getLinkP());
        
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("proyecto agregado"), HttpStatus.OK);
    }
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro){
        //Validamos si existe el id
        if(!sProyecto.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencia
        if(sProyecto.existsByNombreP(dtopro.getNombreP()) && sProyecto.getByNombreP(dtopro.getNombreP()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Este proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopro.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreP(dtopro.getNombreP());
        proyecto.setDescripcionP(dtopro.getDescripcionP());
        proyecto.setImagenP(dtopro.getImagenP());
        proyecto.setLinkP(dtopro.getLinkP());
                
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
