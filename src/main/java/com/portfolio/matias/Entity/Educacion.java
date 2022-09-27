package com.portfolio.matias.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreD;
    private String descripcionD;
    private String fechaD;

    public Educacion() {
    }

    public Educacion(String nombreD, String descripcionD, String fechaD) {
        this.nombreD = nombreD;
        this.descripcionD = descripcionD;
        this.fechaD = fechaD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getDescripcionD() {
        return descripcionD;
    }

    public void setDescripcionD(String descripcionD) {
        this.descripcionD = descripcionD;
    }

    public String getFechaD() {
        return fechaD;
    }

    public void setFechaD(String fechaD) {
        this.fechaD = fechaD;
    }
}
