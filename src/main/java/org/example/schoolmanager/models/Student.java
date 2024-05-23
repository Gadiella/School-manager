package org.example.schoolmanager.models;

import org.example.schoolmanager.dbconfig.IDBConfig;
import org.example.schoolmanager.interfaces.StudentInterfaces;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Student  implements StudentInterfaces {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private int state =0;
    private Connection connection;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Student student) throws SQLException {

        connection = IDBConfig.getConnection();

        String req = "INSERT INTO students (lastname, firstname, dateOfBirth, placeOfBirth, state, id_classroom) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement = this.connection.prepareStatement(req);
        prepareStatement.setString(1, getFirstname());
        prepareStatement.setString(2, getLastname());
        prepareStatement.setDate(3, Date.valueOf(getDateOfBirth()));
        prepareStatement.setString(4, getPlaceOfBirth());
        prepareStatement.setInt(5, getState());
        prepareStatement.setInt(6, 1);


        prepareStatement.executeUpdate();
        prepareStatement.close();
        this.connection.close();

        System.out.println("Etudiant ajouté avec succès !");

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
            List<Student> students = new ArrayList<>();

            connection = IDBConfig.getConnection();

            if (connection!=null){

                String req = "SELECT * FROM students";
                PreparedStatement prepareStatement = this.connection.prepareStatement(req);

                ResultSet resultSet =  prepareStatement.executeQuery();

                while (resultSet.next()){
                   Student student = new Student();

                    student.setId(resultSet.getInt("id"));
                    student.setFirstname(resultSet.getString("firstname"));
                    student.setLastname(resultSet.getString("lastname"));
                    student.setDateOfBirth(resultSet.getDate("dateOfBirth").toLocalDate());
                    student.setPlaceOfBirth(resultSet.getString("placeOfBirth"));
                    student.setState(resultSet.getInt("state"));

                   students.add(student);

                }
                prepareStatement.close();
                this.connection.close();


            }
            return students;
        }
}

