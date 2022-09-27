package com.portfolio.matias.Repository;

import com.portfolio.matias.Entity.Back;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RBack extends JpaRepository<Back, Integer>{
    public Optional<Back> findByNombreB(String nombreB);
    public boolean existsByNombreB(String nombreB);
}
