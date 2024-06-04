package org.example.schoolmanager.models;

import org.example.schoolmanager.interfaces.ClassroomInterfaces;

import java.sql.SQLException;
import java.util.List;

public class Classroom implements ClassroomInterfaces {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void create(Student student) throws SQLException {

    }

    @Override
    public void read(int id) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Student> list() throws SQLException {
        return null;
    }
}
