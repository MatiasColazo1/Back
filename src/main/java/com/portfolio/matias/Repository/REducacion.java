package com.portfolio.matias.Repository;

import com.portfolio.matias.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreD(String nombreD);
    public boolean existsByNombreD(String nombreD);
}
