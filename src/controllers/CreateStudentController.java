package controllers;

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
        ObservableList<String> gt= FXCollections.observableArrayList();
        gt.add("Male");
        gt.add("Female");
        sgender.setItems(gt);
        try{
        Database db=Database.getInstance();
        Statement stt=db.getStatement();
        String sql="select * from lophoc";
            ResultSet rs= stt.executeQuery(sql);
            ObservableList<Classes> list=FXCollections.observableArrayList();
            while (rs.next()){
                Integer id=rs.getInt("id");
                String name= rs.getString("name");
                String room=rs.getString("room");
                Classes c= new Classes(id,name,room);
                list.add(c);
                slophoc.setItems(list);
            }
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void submitStudent(ActionEvent event) {
        try {
            String name = sname.getText();
            String email = semail.getText();
            String birthday = Date.valueOf(sbirhtday.getValue()).toString();
            String gender = sgender.getValue();
            Integer class_id = slophoc.getValue().getId();
            if (name.isEmpty() || email.isEmpty() || birthday.isEmpty() || gender.isEmpty()) {
                throw new Exception("Vui long dien day du thong tin");
            }
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into sinhvien(name,email,birthday,gender,class_id)values('" + name + "','" + email + "','" +birthday+ "','" + gender + "','" + class_id + "')";
            stt.executeUpdate(sql);
            backToListStudent(null);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
