package entities;

import javafx.scene.control.Button;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

public class Student {
    Integer id;
    String name;
    String email;
    Date birthday;
    String gender;
    Integer class_id;
    Button edits;

    public Student(Integer id, String name, String email, Date birthday, String gender, Integer class_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.class_id = class_id;

    }

    public Button getEdits() {
        return edits;
    }

    public void setEdits(Button edits) {
        this.edits = edits;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

}
