/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.borrarp;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import org.hibernate.criterion.Restrictions;


/**
 *
 * @author root
 */
public class DAOUsuario {
     public Session session;
     public SessionFactory sessionFactory;
     public Transaction transaction;
     
    public DAOUsuario() {
            sessionFactory=HibernateUtilidadesBootstrap.getSessionFactory();
            session = sessionFactory.openSession();
            transaction=session.beginTransaction();
            //fullTextSession = Search.getFullTextSession(session);
    }
    public void cerrar(){
        transaction.commit();
        session.close();
    }
    public String guardar(Usuario usuario)throws Exception{
        
            session.save(usuario);
            cerrar();
        
        return "Usuario guardado con exito";
    }
    public ArrayList<Usuario> obtenerUsuario(String email,String password) throws Exception{
        //Usuario up= new Usuario();
        //ArrayList<Usuario> usuario= new ArrayList();
           /*
        up = (Usuario) session.createCriteria(Usuario.class)
                    .add(Restrictions.like("email", email))
                    .add(Restrictions.like("password",password)).uniqueResult();
            */    
            
            ArrayList<Usuario> usuario = (ArrayList<Usuario>) session.createCriteria(Usuario.class)
                .add(Restrictions.like("email", email))
                .add(Restrictions.like("password", password))
                .list();
            cerrar();        
        return usuario;
                
    }
    public Usuario buscarPorId(Integer Id) throws Exception{
        Usuario usuario = session.get(Usuario.class, Id);
        cerrar();
        return usuario;
                
        
    }
}
