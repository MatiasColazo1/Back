package com.portfolio.matias.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String img;
    @NotBlank
    private String titulo;
    @NotBlank
    private String gitLink;
    @NotBlank
    private String linLink;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String titulo, String gitLink, String linLink) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.gitLink = gitLink;
        this.linLink = linLink;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    public String getLinLink() {
        return linLink;
    }

    public void setLinLink(String linLink) {
        this.linLink = linLink;
    }
    
    
}
