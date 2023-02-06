import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Collections;
import java.util.Comparator;

public class PhoneNumber {

    public TextField txtName;
    public TextField txtTelephone;
    public ListView<Phone> nb;
    public ObservableList<Phone> listNumber = FXCollections.observableArrayList();
    public Phone editNumber;
    public boolean ascending=true;

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
        nb.setItems(listNumber);
        nb.refresh();
        editNumber=null;
        clearInput();
    }
    void clearInput(){
        txtName.clear();
        txtTelephone.clear();
    }

    public void editnb(MouseEvent mouseEvent) {
        editNumber=nb.getSelectionModel().getSelectedItem();
        txtName.setText(editNumber.getName());
        txtTelephone.setText(editNumber.getTelephone());
    }

    public void sout(ActionEvent actionEvent) {
        if(ascending){
            Collections.sort(listNumber, new Comparator<Phone>() {
                @Override
                public int compare(Phone o1, Phone o2) {
                    return o1.name.compareTo(o2.name);
                }
            });
        }else {
            Collections.sort(listNumber, new Comparator<Phone>() {
                @Override
                public int compare(Phone o1, Phone o2) {
                    return o2.name.compareTo(o1.name);
                }
            });
        }
        ascending=!ascending;
    }
}
