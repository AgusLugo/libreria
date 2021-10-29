/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.repositorios;

import egg.edu.spring.boot.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Agustina
 */
public interface AutorRepositorio extends JpaRepository<Autor, String>{
    @Modifying
    @Query("Update autor a SET  a.nombre= :nombre WHERE a.id= :id")

        void modificarAutor(@Param("id") String id,@Param("nombre") String nombre);
                

@Modifying
    @Query("Update autor a SET  a.alta= :alta WHERE a.id= :id")

        void darDeBajaAutor(@Param("id") String id,@Param("alta") Boolean alta );
}
