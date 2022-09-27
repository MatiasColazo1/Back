package com.portfolio.matias.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Front {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreF;
    private int porcentajeF;

    public Front() {
    }

    public Front(String nombreF, int porcentajeF) {
        this.nombreF = nombreF;
        this.porcentajeF = porcentajeF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreF() {
        return nombreF;
    }

    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }

    public int getPorcentajeF() {
        return porcentajeF;
    }

    public void setPorcentajeF(int porcentajeF) {
        this.porcentajeF = porcentajeF;
    }

    
}