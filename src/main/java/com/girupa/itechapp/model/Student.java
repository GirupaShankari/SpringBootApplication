package com.girupa.itechapp.model;

import java.util.List;
import java.util.Objects;

public class Student {

    Integer id;
    String name;
    String college;
    String city;
    Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(college, student.college) &&
                Objects.equals(city, student.city) &&
                Objects.equals(role, student.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, college, city, role);
    }
}
