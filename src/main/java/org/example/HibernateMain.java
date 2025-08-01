package org.example;

import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure().buildSessionFactory();
        }catch (Throwable trow){
            throw new ExceptionInInitializerError(trow);
        }
    }

    public SessionFactory getSessionFactory(){return sessionFactory;}

    public void createUser(){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User("Petr","1234@mail.ru","2314511");
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        HibernateMain hibernateMain = new HibernateMain();
        hibernateMain.createUser();
    }
}
