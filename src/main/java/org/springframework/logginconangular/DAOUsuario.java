/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.logginconangular;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author root
 */
public class DAOUsuario {
     public Session session;
    public Transaction transaction;
    public DAOUsuario() {
        HibernateUtil.buildSessionFactory();
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             transaction = session.beginTransaction();
        
    }
    
    public String guardar(Usuario usuario)throws Exception{
        try{
            session.save(usuario);
        }finally{
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
        HibernateUtil.closeSessionFactory();
        return "Usuario guardado con exito";
    }
    public ArrayList<Usuario> obtenerUsuario(Usuario user) throws Exception{
        ArrayList<Usuario> usuario= new ArrayList();
       try{
           usuario = (ArrayList<Usuario>) session.createCriteria(Usuario.class)
                .add(Restrictions.like("email", user.getEmail()))
                .add(Restrictions.like("password", user.getPassword()))
                .list();
           
       }finally{
           HibernateUtil.closeSessionAndUnbindFromThread();
       }
        HibernateUtil.closeSessionFactory();
        return usuario;
                
    }
    public Usuario buscarPorId(Integer Id) throws Exception{
        Usuario u = new Usuario();
        try{
            u = (Usuario)session.createCriteria(Usuario.class).add(Restrictions.idEq(Id)).uniqueResult();
        }finally{
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
        HibernateUtil.closeSessionFactory();
        return u;
    }
}
