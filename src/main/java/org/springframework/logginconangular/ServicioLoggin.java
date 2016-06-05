/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.logginconangular;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public interface ServicioLoggin {
    public void guardarUsuario(Usuario usuario);
    public ArrayList<Usuario> buscarUsuario(Usuario usuario);
    
}
