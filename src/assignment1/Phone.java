package assignment1;

import javafx.scene.control.Button;

public class Phone {
    String name;
    String telephone;
    Button edit;

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Phone(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event -> {
            PhoneNumber.editNumber=this;
            PhoneNumber.stName.setText(this.name);
            PhoneNumber.stTelephone.setText(this.telephone);
        }));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String toString(){
        return this.name+ "--"+this.telephone;
    }
}
