/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.controladores;

import egg.edu.spring.boot.entidades.Autor;
import egg.edu.spring.boot.servicios.AutorServicio;
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
 */

@Controller
@RequestMapping("/autores") // url raiz

public class AutorController {
    
    @Autowired
    private AutorServicio servicio;
     
    @GetMapping("/todos")
    public ModelAndView mostrarAutores(){
    
        ModelAndView mav=new ModelAndView("autores"); // se pasa por parametro el html

       mav.addObject("autoresHabilitados", servicio.obtenerAutoresHabilitados());
       mav.addObject("autoresDeshabilitados", servicio.obtenerAutoresDeshabilitados());
       return mav;
    
    }
    
     @GetMapping("/crear")
    public ModelAndView crearAutor(){
    
        ModelAndView mav=new ModelAndView("autores-formulario"); // se pasa por parametro el html

       mav.addObject("autor", new Autor());
       mav.addObject("title", "Crear Autor");
       mav.addObject("action", "Guardar");
        
       return mav;
       
    
    }
    
     @GetMapping("/editar/{id}")
    public ModelAndView editarAutor(@PathVariable String id){
    
        ModelAndView mav=new ModelAndView("autores-formulario"); // se pasa por parametro el html
        mav.addObject("autor", servicio.obtenerAutorPorId(id));
        mav.addObject("title", "Editar Autor");
        mav.addObject("action", "modificar");
        
       return mav;
       
    
    }
    
         @PostMapping("/Guardar")
    public RedirectView guardarAutor(@RequestParam String nombre){
    
       servicio.crearAutor(nombre);

    return new RedirectView("/autores/todos");
    }
    
    @PostMapping("/modificar")
    public RedirectView modificarAutor(@RequestParam String id,@RequestParam String nombre){
            servicio.modificarAutor(id, nombre);
      
            return new RedirectView("/autores/todos");
       
    
    }
    
    
    @PostMapping("/eliminar/{id}")  
    public RedirectView eliminarAutor(@PathVariable String id){
            servicio.darDeBajaAutor(id);
            return new RedirectView("/autores/todos");
       
    
    }
    
    @PostMapping("/habilitar/{id}")  
    public RedirectView habilitarAutor(@PathVariable String id){
            servicio.darDeAltaAutor(id);
            return new RedirectView("/autores/todos");
       
    
    }
    
    
    
    
}
