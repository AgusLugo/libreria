/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.controladores;

import egg.edu.spring.boot.entidades.Autor;
import egg.edu.spring.boot.entidades.Editorial;
import egg.edu.spring.boot.entidades.Libro;
import egg.edu.spring.boot.servicios.LibroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Agustina
 * 
 */

@Controller
@RequestMapping("/libros") // url raiz

public class LibroControlador {
    
    @Autowired
    private LibroServicio servicio;
    
    
    @GetMapping("/todos")
    public ModelAndView mostrarLibros(){
    
        ModelAndView mav=new ModelAndView("libros-lista"); // se pasa por parametro el html
       /* List<Libro> libros=servicio.obtenerLibros(); 
        mav.addObject("libros", libros);
        
        return mav;*/
       
       mav.addObject("libros", servicio.obtenerLibros());
        
       return mav;
       
    
    }
    
        @GetMapping("/crear")
    public ModelAndView crearLibro(){
    
        ModelAndView mav=new ModelAndView("libros-formulario"); // se pasa por parametro el html
       /* List<Libro> libros=servicio.obtenerLibros(); 
        mav.addObject("libros", libros);
        
        return mav;*/
       
       mav.addObject("libro", new Libro());
       mav.addObject("title", "Crear Libro");
       mav.addObject("action", "Guardar");
        
       return mav;
       
    
    }
    
    @GetMapping("/editar/(id)")
    public ModelAndView editarLibro(@PathVariable String id){
    
        ModelAndView mav=new ModelAndView("libros-formulario"); // se pasa por parametro el html
       /* List<Libro> libros=servicio.obtenerLibros(); 
        mav.addObject("libros", libros);
        
        return mav;*/
       
       mav.addObject("libro", new Libro());
       mav.addObject("title", "Editar Libro");
       mav.addObject("action", "Modificar");
        
       return mav;
       
    
    }
    
    
         @PostMapping("/guardar")
    public RedirectView guardarLibro(@RequestParam Long isbn, @RequestParam String titulo,@RequestParam Integer anio, @RequestParam Integer ejemplares,
            @RequestParam Autor autor, @RequestParam Editorial editorial){
    
       servicio.crearLibro(isbn, titulo, anio, ejemplares, autor, editorial);
        
      
       
    return new RedirectView("/libros");
    }
    
    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id,@RequestParam Long isbn,  @RequestParam Integer ejemplares,
            @RequestParam Autor autor, @RequestParam Editorial editorial){
            servicio.modificarLibro(id, ejemplares, autor, editorial);
      
            return new RedirectView("/libros");
       
    
    }
    
    
    @PostMapping("/eliminar/(id)")  
    public RedirectView eliminar(@PathVariable String id){
            servicio.darDeBajaLibro(id);
            return new RedirectView("/libros");
       
    
    }
}
