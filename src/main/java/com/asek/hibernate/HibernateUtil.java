package com.asek.hibernate;

import com.asek.entity.PCGame;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry ssrb;

    public SessionFactory getSession() {
        if(sessionFactory == null) {
            try {
                Configuration config = new Configuration();
                config.configure();

                 ssrb = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties()).build();

                MetadataSources sources = new MetadataSources(ssrb)
                        .addAnnotatedClass(PCGame.class);

                Metadata metadata = sources.getMetadataBuilder().build();

                System.out.println(config.getProperties());

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
            catch(Exception e) {
                System.out.println("SessionFactory creation has failed.");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public void shutdown() {
        if(ssrb != null) {
            StandardServiceRegistryBuilder.destroy(ssrb);
        }
    }
}
