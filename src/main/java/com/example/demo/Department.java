package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deptid;
    private String title;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public Set<Employee> employees;

    public Department() {
    }

    public Department(String title, Set<Employee> employees) {
        this.title = title;
        this.employees = employees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getemployees() {
        return employees;
    }

    public void setEmployee(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    public long getDeptid() {
        return deptid;
    }

    public void setDeptid(long deptid) {
        this.deptid = deptid;
    }
}
