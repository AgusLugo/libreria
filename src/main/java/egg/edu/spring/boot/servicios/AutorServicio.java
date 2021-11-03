/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.servicios;

import egg.edu.spring.boot.entidades.Autor;
import egg.edu.spring.boot.repositorios.AutorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agustina
 */
@Service
public class AutorServicio {
    
    
     @Autowired/*buscar bien el significado */
    private AutorRepositorio repositorio;

   
    @Transactional
    public void crearAutor(String nombre){
    
    Autor autor=new Autor();
    autor.setNombre(nombre);
    autor.setAlta(true);
    
    repositorio.save(autor);
    
    }
    
    @Transactional
    public void modificarAutor(String id, String nombre){
    

       repositorio.modificarAutor(id, nombre);
           
    
    }
    
    @Transactional /* falta el readOnly*/ 
    public List<Autor> obtenerAutoresHabilitados(){

     // return  repositorio.findAll(); 
      return repositorio.buscarAutoresHabilitados();
    
    }
    
    @Transactional /* falta el readOnly*/ 
    public List<Autor> obtenerAutoresDeshabilitados(){

     // return  repositorio.findAll(); 
      return repositorio.buscarAutoresDeshabilitados();
    
    }
    
    @Transactional (readOnly = true)
    public Autor obtenerAutorPorId(String id){
        
        Optional<Autor> autor=repositorio.findById(id);
       
      return autor.orElse(null) ; 
    }
      
    @Transactional /* falta el readOnly*/ 
    public void darDeBajaAutor(String id){
             
       repositorio.darDeBajaAutor(id,false);
       
    }
    
    @Transactional /* falta el readOnly*/ 
    public void darDeAltaAutor(String id){
             
       repositorio.darDeAltaAutor(id);
       
    }
}
