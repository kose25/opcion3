/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opcion3.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author kose_
 */
@Entity
@Data
public class Usuario {
    
    @Id
    private String usuario;
    
    private String password;
    
    private String email;
    
    private String empresa;
    
    
}
