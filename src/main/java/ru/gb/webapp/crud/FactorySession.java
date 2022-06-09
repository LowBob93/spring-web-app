package ru.gb.webapp.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class FactorySession {

    private SessionFactory sessionFactory;

    private FactorySession() {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}