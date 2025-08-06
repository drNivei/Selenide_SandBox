package org.example.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class StudentRepository {

    public void save(Student student, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
    }

    public Student findById(Long id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = (Student) session.createQuery("SELECT * FROM Student WHERE id="+ id, Student.class);
        session.close();
        return student;
    }

    public List<Student> findAll(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Student> student = Collections.singletonList((Student) session.createQuery("SELECT * FROM Student", Student.class));
        session.close();
        return student;
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
            System.out.println("Студет " + student + " удален!");
            session.remove(student);
        }
        session.close();
    }
}
