package com.portfolio.matias.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Back {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreB;
    private int porcentajeB;

    public Back() {
    }

    public Back(String nombreB, int porcentajeB) {
        this.nombreB = nombreB;
        this.porcentajeB = porcentajeB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreB() {
        return nombreB;
    }

    public void setNombreB(String nombreB) {
        this.nombreB = nombreB;
    }

    public int getPorcentajeB() {
        return porcentajeB;
    }

    public void setPorcentajeB(int porcentajeB) {
        this.porcentajeB = porcentajeB;
    }
    
    
}
