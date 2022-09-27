package com.portfolio.matias.Interface;

import com.portfolio.matias.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer una lista de persona
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un usuario lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}
