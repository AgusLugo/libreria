/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Agustina
 */

@Controller
public class PrincipalController {
    
    @GetMapping //no es necesario que tenga url el local host entra por defecto aca y retorna una vista
    public ModelAndView inicio(){
    
        return new ModelAndView("index");
    }
}
