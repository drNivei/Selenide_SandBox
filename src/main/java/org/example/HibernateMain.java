package org.example;

import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;

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

    public void createDepartmentWithUser () {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Department department = new Department();
        department.setName("IT Department");
        session.persist(department);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setName("John");
        session.persist(employee);

        session.getTransaction().commit();
        session.close();

    }

    public void getAllEmployees() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        List<Department> department = Collections.singletonList((Department) session.createQuery("SELECT * FROM Department", Department.class));
        for(int i=0; i<department.size()-1; i++){
            List<Employee> employees = department.get(i).getEmployees();
            System.out.println(employees);
        }

        session.close();

    }

    public static void main(String[] args) {
        HibernateMain hibernateMain = new HibernateMain();
       //hibernateMain.createUser();
       //hibernateMain.createDepartmentWithUser();
       // hibernateMain.getAllEmployees();
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Sasha","Alexeev", 34, "123@mail.ru");
        Student student1 = new Student("Sasha1","Alexeev1", 34, "1231@mail1.ru");
        student1.setId(1);
        long id = 1;

        studentRepository.save(student, sessionFactory);
        System.out.println();

        System.out.println("Student with ID = `1: " + studentRepository.findById(id, sessionFactory));
        System.out.println();

        System.out.println("Students are: " + studentRepository.findAll(sessionFactory));
        System.out.println();

        studentRepository.update(student1,sessionFactory);
        System.out.println();

        studentRepository.delete(id,sessionFactory);

    }
}
