/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.logginconangular;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class LogginUsuario implements ServicioLogin{

    public void guardarUsuario(Usuario usuario) {
        DAOUsuario dao = new DAOUsuario();
        try {
            dao.guardar(usuario);
        } catch (Exception ex) {
            Logger.getLogger(LogginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Usuario guardado");
    }

    @Override
    public Usuario buscarUsuario(String email,String password) {
         DAOUsuario dao = new DAOUsuario();
         Usuario up = new Usuario();
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            up = dao.obtenerUsuario(email,password);
        } catch (Exception ex) {
            Logger.getLogger(LogginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return up;
    }
    
}
