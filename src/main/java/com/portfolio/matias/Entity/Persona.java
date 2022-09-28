package com.portfolio.matias.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;
    
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String apellido;
    
    @Size(min = 1, max = 500, message = "No cumple con la longitud")
    private String img;
    
    @Size(min=1, max=50, message="no cumple con la longitud")
    private String titulo;
    
    @Size(min=1, max=250, message="no cumple con la longitud")
    private String gitLink;
    
    @Size(min=1, max=250, message="no cumple con la longitud")
    private String linLink;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String titulo, String gitLink, String linLink) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.gitLink = gitLink;
        this.linLink = linLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
