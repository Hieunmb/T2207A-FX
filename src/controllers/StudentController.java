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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TableView<Student> stbview;
    public TableColumn<Student,Integer> sid;
    public TableColumn<Student,String> sname;
    public TableColumn<Student,String> semail;
    public TableColumn<Student, LocalDate> sbirthday;
    public TableColumn<Student,String> sgender;
    public TableColumn<Student,Integer> sclass;
    public TableColumn<Student, Button> saction;

    public void backToHome(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/home.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    public void goToCreate(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/student/createStudent.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sid.setCellValueFactory(new PropertyValueFactory<>("id"));
        sname.setCellValueFactory(new PropertyValueFactory<>("name"));
        semail.setCellValueFactory(new PropertyValueFactory<>("email"));
        sbirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        sgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        sclass.setCellValueFactory(new PropertyValueFactory<>("class_id"));

        ObservableList<Student> listStudent = FXCollections.observableArrayList();
        try{
            Database db=Database.getInstance();
            Statement stt= db.getStatement();
            String sql="select * from sinhvien";
            ResultSet rs= stt.executeQuery(sql);
            while (rs.next()){
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                Date birthday=rs.getDate("birthday");
                String gender=rs.getString("gender");
                Integer class_id=rs.getInt("class_id");
                Student s=new Student(id,name,email,birthday,gender,class_id);
                listStudent.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        stbview.setItems(listStudent);
    }
}
