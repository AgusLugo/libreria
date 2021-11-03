/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;


/**
 *
 * @author Agustina
 */

@Entity
@SQLDelete(sql = "UPDATE libro SET alta=false WHERE id = ?")
@Data @AllArgsConstructor @NoArgsConstructor
public class Libro {
    
    @Id
    @GeneratedValue(generator = "uuid")    
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id; 
    private Long isbn; 
    @Column( nullable = false)
    private String titulo; 
    @Column( nullable = false)
    private Integer anio; 
    @Column( nullable = false)
    private Integer ejemplares;
     @Column( nullable = false)
    private Integer ejemplaresPrestados;
    @Column( nullable = false) 
    private Integer ejemplaresRestantes; 
    private Boolean alta;
    @ManyToOne
    private Autor autor; 
    @ManyToOne
    private Editorial editorial; 

    
}
