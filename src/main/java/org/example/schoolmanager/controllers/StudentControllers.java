package org.example.schoolmanager.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.schoolmanager.models.Student;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class StudentControllers {
    private final Student student = new Student();


    @FXML
    private DatePicker datepiker;

    @FXML
    private TextField firstfield;


    @FXML
    private TextField lastfield;

    @FXML
    private TextField placefield;

    @FXML
    private TextField myState;


    @FXML
    private void onsubmitetudiante() throws SQLException, ParseException {
        System.out.println("OK");
        String firstname = firstfield.getText().trim();
        String lastname = lastfield.getText().trim();
        LocalDate dateOfBirthtext = datepiker.getValue();
        String placeOfBirth = placefield.getText().trim();
        int state = Integer.parseInt(myState.getText().trim());

        /*if (!firstname.isEmpty() && !lastname.isEmpty() &&
                !dateOfBirthtext.isEmpty() && !placeOfBirth.isEmpty()) {


        }*/
            try {
                LocalDate dateOfBirth = dateOfBirthtext;

                student.setFirstname(firstname);
                student.setLastname(lastname);

                student.setDateOfBirth(dateOfBirth);
                student.setPlaceOfBirth(placeOfBirth);
                student.setState(state);
                /*if (student.getId() == 0) {
                    student.create(student);
                } else {
                    student.update(student);
                }*/
                student.create(student);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }