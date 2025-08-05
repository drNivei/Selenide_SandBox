package org.example.model;

import jakarta.persistence.*;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @ManyToOne
    @JoinColumn (name = "department_id")
    private Department department = new Department();

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}