package com.portfolio.matias.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreD;
    @NotBlank
    private String descripcionD;
    @NotBlank
    private String fechaD;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreD, String descripcionD, String fechaD) {
        this.nombreD = nombreD;
        this.descripcionD = descripcionD;
        this.fechaD = fechaD;
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
