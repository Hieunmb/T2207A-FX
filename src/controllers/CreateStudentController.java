package controllers;

import daopattern.ClassesDAO;
import database.Database;
import entities.Classes;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateStudentController implements Initializable {

    public TextField sname;
    public TextField semail;
    public DatePicker sbirhtday;
    public ComboBox<String > sgender;
    public ComboBox<Classes> slophoc;

    public void backToListStudent(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/student/listStudent.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> gt = FXCollections.observableArrayList();
        gt.add("Male");
        gt.add("Female");
        sgender.setItems(gt);
        try {
            ClassesDAO cd = ClassesDAO.getInstance();
            ArrayList<Classes> ls = cd.getAll();
            slophoc.getItems().addAll(ls);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

        public void submitStudent(ActionEvent event) {
        String name = sname.getText();
        String email =semail.getText();
        String birthday = Date.valueOf(sbirhtday.getValue()).toString();
        String gender = sgender.getValue();
        Integer class_id = slophoc.getValue().getId();
    }
}
