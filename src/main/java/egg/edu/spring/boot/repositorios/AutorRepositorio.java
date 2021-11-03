/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.repositorios;

import egg.edu.spring.boot.entidades.Autor;
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
public interface AutorRepositorio extends JpaRepository<Autor, String>{
    @Modifying
    @Query("Update Autor a SET  a.nombre= :nombre WHERE a.id= :id")

        void modificarAutor(@Param("id") String id,@Param("nombre") String nombre);
                

    @Modifying
    @Query("Update Autor a SET  a.alta=:alta WHERE a.id= :id")

        void darDeBajaAutor(@Param("id") String id,@Param("alta") Boolean alta);
        
   /* @Override
    @Query("FROM Autor a WHERE a.alta=true")
    List<Autor> findAll(); 
*/
    @Query("FROM Autor a WHERE a.alta=true")
    List<Autor> buscarAutoresHabilitados(); 
    
    @Query("FROM Autor a WHERE a.alta=false")
    List<Autor> buscarAutoresDeshabilitados(); 
    
    
    
     @Modifying
    @Query("Update Autor a SET  a.alta= true WHERE a.id= :id")
    public void darDeAltaAutor(@Param("id") String id);
    
    
}
