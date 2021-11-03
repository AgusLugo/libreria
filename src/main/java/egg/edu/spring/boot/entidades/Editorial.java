/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.edu.spring.boot.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@SQLDelete(sql = "UPDATE editorial SET alta=false WHERE id = ?")
@Data @AllArgsConstructor @NoArgsConstructor
public class Editorial {
    @Id
    @GeneratedValue(generator = "uuid")    
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id; 
    @Column( nullable = false)
    private String nombre;
    private Boolean alta; 
}
