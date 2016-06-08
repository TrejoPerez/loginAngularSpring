/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.logginconangular;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.criterion.Restrictions;

/**
 *
 * @author root
 */
public class DAOUsuario {
     public Session session;
    
    public DAOUsuario() {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            HibernateUtil.buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //session = sessionFactory.getCurrentSession();
            //transaction = session.beginTransaction();
        
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
    public Usuario obtenerUsuario(String email,String password) throws Exception{
        Usuario up= new Usuario();
        
        //ArrayList<Usuario> usuario= new ArrayList();
       try{
           /*usuario = (ArrayList<Usuario>) session.createCriteria(Usuario.class)
                .add(Restrictions.like("email", up.getEmail()))
                .add(Restrictions.like("password", up.getPassword()))
                .list();
            */    
            up = (Usuario) session.createCriteria(Usuario.class)
                    .add(Restrictions.like("email", email))
                    .add(Restrictions.like("password",password)).uniqueResult();
            
            
                    
           
       }finally{
           HibernateUtil.closeSessionAndUnbindFromThread();
       }
        HibernateUtil.closeSessionFactory();
        return up;
                
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
