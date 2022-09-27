package com.portfolio.matias.Repository;

import com.portfolio.matias.Entity.Front;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RFront extends JpaRepository<Front, Integer>{
    public Optional<Front> findByNombreF(String nombreF);
    public boolean existsByNombreF(String nombreF);
}