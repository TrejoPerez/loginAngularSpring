/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.borrarp;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public interface ServicioLogin {
    public void guardarUsuario(Usuario usuario);
    public ArrayList<Usuario> buscarUsuario(String email,String password);
    public Usuario buscarId(Integer Id);
    
}
