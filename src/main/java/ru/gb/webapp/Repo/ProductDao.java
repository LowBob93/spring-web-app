package ru.gb.webapp.Repo;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.gb.webapp.Models.Product;
import ru.gb.webapp.crud.FactorySession;

import java.util.List;


@Repository

public class ProductDao {


        private FactorySession factorySession;

        public ProductDao(FactorySession factorySession) {
            this.factorySession = factorySession;
        }

        public Product findById(Long id){
            try(Session session = factorySession.getSession()){
                session.beginTransaction();
                Product product = session.get(Product.class, id);
                session.getTransaction().commit();
                return product;
            }
        }

        public List<Product> findAll(){
            try(Session session = factorySession.getSession()){
                session.beginTransaction();
                List<Product> products = session.createQuery("from Product").getResultList();
                session.getTransaction().commit();
                return products;
            }
        }

        public void deleteById(Long id){
            try(Session session = factorySession.getSession()){
                session.beginTransaction();
                Product product = session.get(Product.class, id);
                session.delete(product);
                session.getTransaction().commit();
            }
        }
        public Product saveOrUpdate(Product product){
            try(Session session = factorySession.getSession()){
                session.beginTransaction();
                session.saveOrUpdate(product);
                session.getTransaction().commit();
                return product;
            }
        }
    public void priceUp(Product product) {
        try (Session session = factorySession.getSession()) {
            session.beginTransaction();
            product.setCost(product.getCost() + 1.0);
            session.getTransaction().commit();
        }
    }
    public void priceDown(Product product) {
        try (Session session = factorySession.getSession()) {
            session.beginTransaction();
            product.setCost(product.getCost() - 1.0);
            session.getTransaction().commit();
        }
    }
}

