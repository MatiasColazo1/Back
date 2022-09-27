package com.portfolio.matias.Service;

import com.portfolio.matias.Entity.Front;
import com.portfolio.matias.Repository.RFront;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SFront {
    @Autowired
    RFront rFront;
    
    public List<Front> list(){
        return rFront.findAll();
    }
    public Optional<Front> getOne(int id){
        return rFront.findById(id);
    }
     public Optional<Front> getByNombreF(String nombreF){
        return rFront.findByNombreF(nombreF);
    }
     public void save(Front front){
        rFront.save(front);
    }
     public void delete(int id){
        rFront.deleteById(id);
    }
     public boolean existById(int id){
        return rFront.existsById(id);
    }
     public boolean existsByNombreF(String nombreF){
        return rFront.existsByNombreF(nombreF);
    }
}