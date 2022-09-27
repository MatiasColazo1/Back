package com.portfolio.matias.Dto;

import javax.validation.constraints.NotBlank;


public class dtoFront {
    @NotBlank
    private String nombreF;
    @NotBlank
    private int porcentajeF;

    public dtoFront() {
    }

    public dtoFront(String nombreF, int porcentajeF) {
        this.nombreF = nombreF;
        this.porcentajeF = porcentajeF;
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