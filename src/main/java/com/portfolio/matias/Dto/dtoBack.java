package com.portfolio.matias.Dto;

import javax.validation.constraints.NotBlank;

public class dtoBack {
    @NotBlank
    private String nombreB;
    @NotBlank
    private int porcentajeB;

    public dtoBack() {
    }

    public dtoBack(String nombreB, int porcentajeB) {
        this.nombreB = nombreB;
        this.porcentajeB = porcentajeB;
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
