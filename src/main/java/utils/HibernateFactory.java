package utils;

import entity.hibirnated.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Transactional
public class HibernateFactory {
    private static SessionFactory sessionFactory;

    private HibernateFactory() {
    }

    public static SessionFactory getSessionFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();

        Session session = entityManager.unwrap(org.hibernate.Session.class);
        return session.getSessionFactory();
    }
}
