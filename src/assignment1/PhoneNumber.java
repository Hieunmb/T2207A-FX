package assignment1;

import assignment1.Phone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class PhoneNumber implements Initializable {

    public TextField txtName;
    public TextField txtTelephone;
    public static TextField stName;
    public static TextField stTelephone;
    public ObservableList<Phone> listNumber = FXCollections.observableArrayList();
    public static Phone editNumber;
    public TableView<Phone> tbview;
    public TableColumn<Phone,String>  pname;
    public TableColumn<Phone,String> ptelephone;
    public TableColumn<Phone, Button> paction;

    public void submit(ActionEvent actionEvent) {
        String n=txtName.getText();
        String t=txtTelephone.getText();
        if(editNumber==null){
            Phone p= new Phone(n,t);
            listNumber.add(p);
        }else {
            for(Phone p:listNumber){
                if (p.getName().equals(editNumber.name) && p.telephone.equals(editNumber.telephone)) {
                    p.setName(n);
                    p.setTelephone(t);
                }
            }
        }
        tbview.setItems(listNumber);
        tbview.refresh();
        editNumber=null;
        clearInput();
    }
    void clearInput(){
        txtName.clear();
        txtTelephone.clear();
    }

    public void editnb(MouseEvent mouseEvent) {
//        editNumber=nb.getSelectionModel().getSelectedItem();
        txtName.setText(editNumber.getName());
        txtTelephone.setText(editNumber.getTelephone());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pname.setCellValueFactory(new PropertyValueFactory<>("name"));// lấy dữ liệu từ lớp student
        ptelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        paction.setCellValueFactory(new PropertyValueFactory<>("edit"));
        stName=txtName;
        stTelephone=txtTelephone;
    }
}
