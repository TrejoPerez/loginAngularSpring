/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.borrarp;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;



/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author root
 */
public class HibernateUtilidadesBootstrap {
    private static  SessionFactory sessionFactory = buidlSessionFactory();
    
    private static SessionFactory buidlSessionFactory(){   
        final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
       try{
           Metadata metadata = new MetadataSources( serviceRegistry )
            .addAnnotatedClass( Usuario.class )
            .addAnnotatedClassName("org.springframework.borrarp.Usuario")
            .getMetadataBuilder()
            .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
            .build();
        
         sessionFactory = metadata.getSessionFactoryBuilder().build();
           
       }catch(Throwable ex){
           StandardServiceRegistryBuilder.destroy(serviceRegistry);
           System.err.println("Initial SesisonFactory failed at " + ex );
           throw new ExceptionInInitializerError(ex);
       }
        return sessionFactory;
    }
   
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
