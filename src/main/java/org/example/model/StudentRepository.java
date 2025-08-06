package org.example.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class StudentRepository {

    public void save(Student student, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        System.out.println("Student "+student+" successfully added!");
        session.close();
    }

    public Student findById(Long id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public List<Student> findAll(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Student"; // Replace YourEntityClassName with the actual class name
        Query<Student> query = session.createQuery(hql, Student.class);
        List<Student> results = query.list();
        session.close();
        return results;
    }

    public void update(Student student, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Load the entity
            Student student1 = session.get(Student.class, student.getId());

            student1.setAge(student.getAge());
            student1.setEmail(student.getEmail());
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            tx.commit();// Changes are flushed to the database
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            System.out.println("Student "+ student + " successfully updated!");
            session.close();
        }
    }

    public void delete(Long id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.find(Student.class, id);
        if (student != null) {
            session.remove(student);
            System.out.println("Студет " + student + " удален!");
        }
        session.close();
    }
}
