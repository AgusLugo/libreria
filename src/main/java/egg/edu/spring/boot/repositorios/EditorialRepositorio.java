/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.repositorios;

import egg.edu.spring.boot.entidades.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustina
 */

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String>{
 
    @Modifying
    @Query("Update Editorial e SET  e.nombre= :nombre WHERE e.id= :id")

        void modificarEditorial(@Param("id") String id,@Param("nombre") String nombre);
                

    @Modifying
    @Query("Update Editorial e SET  e.alta= :alta WHERE e.id= :id")

        void darDeBajaEditorial(@Param("id") String id,@Param("alta") Boolean alta);
        
    @Override
    @Query("FROM Editorial e WHERE e.alta=true")
    List<Editorial> findAll(); 
}
