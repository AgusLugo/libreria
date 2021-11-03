/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.servicios;

import egg.edu.spring.boot.entidades.Editorial;
import egg.edu.spring.boot.repositorios.EditorialRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustina
 */

@Service
public class EditorialServicio {
    @Autowired/*buscar bien el significado */
    private EditorialRepositorio repositorio;

   
    @Transactional
    public void crearEditorial(String nombre){
    
    Editorial editorial=new Editorial();
    editorial.setNombre(nombre);
    editorial.setAlta(true);
    
    repositorio.save(editorial);
    
    }
    
    @Transactional
    public void modificarEditorial(String id, String nombre){
    

       repositorio.modificarEditorial(id, nombre);
           
    
    }
    
    @Transactional /* falta el readOnly*/ 
    public List<Editorial> obtenerEditoriales(){

      return  repositorio.findAll(); 
           
    
    }
    
    @Transactional /* falta el readOnly*/ 
    public Editorial obtenerEditorialPorId(String id){
        
        Optional<Editorial> editorial=repositorio.findById(id);
       
      return editorial.orElse(null) ; 
    }
      
    @Transactional /* falta el readOnly*/ 
    public void darDeBajaEditorial(String id){
             
       repositorio.darDeBajaEditorial(id,false);
       
    }
}
