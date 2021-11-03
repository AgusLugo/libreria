/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.repositorios;

import egg.edu.spring.boot.entidades.Autor;
import egg.edu.spring.boot.entidades.Editorial;
import egg.edu.spring.boot.entidades.Libro;
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
public interface LibroRepositorio extends JpaRepository<Libro, String>{
    
    
    @Modifying
    @Query("Update Libro l SET  l.ejemplares= :ejemplares, l.autor= :autor, l.editorial= :editorial WHERE l.id= :id")

        void modificarLibro(@Param("id") String id,@Param("ejemplares") Integer ejemplares, @Param("autor") Autor autor, @Param("editorial") Editorial editorial );
                

    @Modifying
    @Query("Update Libro l SET  l.alta= :alta  WHERE l.id= :id")

        void darDeBajaLibro(@Param("id") String id,@Param("alta") Boolean alta);
                }