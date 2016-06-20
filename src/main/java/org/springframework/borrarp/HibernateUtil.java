/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.borrarp;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 *
 * @author root
 */
public class HibernateUtil {
     private static  SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        
            // Create the SessionFactory from hibernate.cfg.xml
           final StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure().build();
        try{    
           sessionFactory = new MetadataSources(standardRegistry).buildMetadata()
                   .buildSessionFactory();
           return sessionFactory;
        } 
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            StandardServiceRegistryBuilder.destroy(standardRegistry);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
