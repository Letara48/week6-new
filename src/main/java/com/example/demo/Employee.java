package com.example.demo;

import javax.persistence.*;

@Entity
public class Employee {
    public long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeid;

    private String name;
    private String job_title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Department getDepartment() {
        return department;
    }
}