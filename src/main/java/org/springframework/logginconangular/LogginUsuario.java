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
public class LogginUsuario implements ServicioLoggin{

    public void guardarUsuario(Usuario usuario) {
        DAOUsuario dao = new DAOUsuario();
        try {
            dao.guardar(usuario);
        } catch (Exception ex) {
            Logger.getLogger(LogginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Usuario guardado");
    }

    public ArrayList<Usuario> buscarUsuario(Usuario usuario) {
         DAOUsuario dao = new DAOUsuario();
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            usuarios = dao.obtenerUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(LogginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
}
