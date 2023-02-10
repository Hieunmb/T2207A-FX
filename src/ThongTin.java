import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class ThongTin implements Initializable {

    public TextField txtFullName;
    public TextField txtEmail;
    public static TextField stFullName;
    public static TextField stEmail;
    public Text txtInfo;
    public ObservableList<Student> listStudent = FXCollections.observableArrayList();

    public static Student editStudent;
    public TableView<Student> tbview;
    public TableColumn<Student, String> cfullname;
    public TableColumn<Student, String> cemail;
    public TableColumn<Student, Button> cAction;

    public void submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String el = txtEmail.getText();

        if (editStudent == null) {
            Student s = new Student(fn, el);
            listStudent.add(s);
        } else {
            //editStudent.setFullName(fn);
            //editStudent.setEmail(el);
            for (Student s: listStudent) {
                if (s.email.equals(editStudent.email) && s.fullName.equals(editStudent.fullName)) {
                    s.setFullName(fn);
                    s.setEmail(el);
                }
            }
        }
        tbview.setItems(listStudent);// hiển thị giao diện
        tbview.refresh();
        editStudent = null;
        clearInPut();
    }
    void clearInPut() {
        txtFullName.clear();
        txtEmail.clear();
    }

    public void editSV(MouseEvent mouseEvent) {
        // nhấn vào thì hiển thị sang input
//        editStudent = tbview.getSelectionModel().getSelectedItem();
        txtFullName.setText(editStudent.getFullName());
        txtEmail.setText(editStudent.getEmail());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cfullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));// lấy dữ liệu từ lớp student
        cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stFullName = txtFullName;
        stEmail = txtEmail;
    }
}