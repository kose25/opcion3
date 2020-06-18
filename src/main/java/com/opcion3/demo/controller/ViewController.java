/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opcion3.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kose_
 */

@Controller
public class ViewController {
    
    @GetMapping("/login")
    public String login(){
        
        return "login";
    }
    
    
    @GetMapping("/admin")
    public String Admin(){
        
        return "admin";
    }
    
    @GetMapping("/guest")
    public String Guest(){
        
        return "guest";
    }
}
