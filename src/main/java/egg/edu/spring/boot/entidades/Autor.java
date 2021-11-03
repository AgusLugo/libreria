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
import javax.persistence.OneToMany;
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
@SQLDelete(sql = "UPDATE autor SET alta=false WHERE id = ?")
//Data @AllArgsConstructor @NoArgsConstructor
 public class Autor {
    
    @Id
    @GeneratedValue(generator = "uuid")    
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id; 
    @Column( nullable = false)
    private String nombre;
    private Boolean alta; 

    public Autor(String id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }
    
    public Autor() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
}
