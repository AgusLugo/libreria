/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.repositorios;

import egg.edu.spring.boot.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Agustina
 */
public interface EditorialRepositorio extends JpaRepository<Editorial, String>{
    
}
