/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.controladores;

import egg.edu.spring.boot.entidades.Editorial;
import egg.edu.spring.boot.servicios.EditorialServicio;
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
@RequestMapping("/editoriales") // url raiz
public class EditorialController {
    
    
    @Autowired
    private EditorialServicio servicio;
     
      @GetMapping("/todas")
    public ModelAndView mostrarEditoriales(){
    
        ModelAndView mav=new ModelAndView("editoriales"); // se pasa por parametro el html

       mav.addObject("editoriales", servicio.obtenerEditoriales());
        
       return mav;
    
    }
    
     @GetMapping("/crear")
    public ModelAndView creareditorial(){
    
        ModelAndView mav=new ModelAndView("editoriales-formulario"); // se pasa por parametro el html

       mav.addObject("editorial", new Editorial());
       mav.addObject("title", "Crear editorial");
       mav.addObject("action", "Guardar");
        
       return mav;
       
    
    }
    
     @GetMapping("/editar/{id}")
    public ModelAndView editarEditorial(@PathVariable String id){
    
        ModelAndView mav=new ModelAndView("editoriales-formulario"); // se pasa por parametro el html
      
       
     mav.addObject("editorial", servicio.obtenerEditorialPorId(id));
       mav.addObject("title", "Editar editorial");
       mav.addObject("action", "modificar");
        
       return mav;
       
    
    }
    
         @PostMapping("/Guardar")
    public RedirectView guardarEditorial(@RequestParam String nombre){
    
       servicio.crearEditorial(nombre);

    return new RedirectView("/editoriales/todas");
    }
    
    @PostMapping("/modificar")
    public RedirectView modificarEditorial(@RequestParam String id,@RequestParam String nombre){
            servicio.modificarEditorial(id, nombre);
      
            return new RedirectView("/editoriales/todas");
       
    
    }
    
    
    @PostMapping("/eliminar/{id}")  
    public RedirectView eliminarEditorial(@PathVariable String id){
            servicio.darDeBajaEditorial(id);
            return new RedirectView("/editoriales/todas");
       
    
    }
}
