/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.borrarp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 *
 * @author root
 */


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MainSpring{
    public static void main(String[] args) {
        SpringApplication.run(MainSpring.class,args);   
    }
   
}
