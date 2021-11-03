/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.servicios;
import egg.edu.spring.boot.entidades.Autor;
import egg.edu.spring.boot.entidades.Editorial;
import egg.edu.spring.boot.entidades.Libro;
import egg.edu.spring.boot.entidades.Libro;
import egg.edu.spring.boot.repositorios.LibroRepositorio;
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
public class LibroServicio {
    
    @Autowired/*buscar bien el significado */
    private LibroRepositorio repositorio;

    public LibroServicio() {
    }
    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares,
            Autor autor, Editorial editorial){
    
    Libro libro=new Libro();
    libro.setTitulo(titulo);
    libro.setIsbn(isbn);
    libro.setAnio(anio);
    libro.setAutor(autor);
    libro.setEjemplares(ejemplares);
    libro.setAutor(autor);
    libro.setEditorial(editorial);
    
    repositorio.save(libro);
    
    }
    
    @Transactional
    public void modificarLibro(String id, Integer ejemplares,
            Autor autor, Editorial editorial){
    
       /* Libro libro=repositorio.findById(id);
        libro.setEjemplares(ejemplares);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
    
        repositorio.save(libro); */
       
       repositorio.modificarLibro(id, ejemplares, autor, editorial);
           
    
    }
    
    @Transactional /* falta el readOnly*/ 
    public List<Libro> obtenerLibros(){
    
       
    
      return  repositorio.findAll(); 
           
    
    }
    
    @Transactional /* falta el readOnly*/ 
    public Libro obtenerLibroPorId(String id){
        
        Optional<Libro> libro=repositorio.findById(id);
        // optional es para ver si viene o no el objeto y si no esta presente desues retorno null.-
       
    
      return libro.orElse(null) ; 
    }
      
    @Transactional /* falta el readOnly*/ 
    public void darDeBajaLibro(String id){
             
       repositorio.darDeBajaLibro(id,false);
       
    }
            
        
            
            
           
}
