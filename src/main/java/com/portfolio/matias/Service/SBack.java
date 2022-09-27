package com.portfolio.matias.Service;

import com.portfolio.matias.Entity.Back;
import com.portfolio.matias.Repository.RBack;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SBack {
    @Autowired
    RBack rBack;
    
    public List<Back> list(){
        return rBack.findAll();
    }
     public Optional<Back> getOne(int id){
        return rBack.findById(id);
    }
     public Optional<Back> getByNombreB(String nombreB){
        return rBack.findByNombreB(nombreB);
    }
     public void save(Back back){
        rBack.save(back);
    }
     public void delete(int id){
        rBack.deleteById(id);
    }
     public boolean existById(int id){
        return rBack.existsById(id);
    }
     public boolean existsByNombreB(String nombreB){
        return rBack.existsByNombreB(nombreB);
    }
}
