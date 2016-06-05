/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.logginconangular;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author root
 */
@Configuration
public class ConfiguracionServicio {
    @Bean
    public ServicioLoggin servicioLoggin(){
        return new LogginUsuario();
    }
}
