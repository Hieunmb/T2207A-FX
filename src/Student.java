import javafx.scene.control.Button;

public class Student {// không nói gì thì là lớp con của lớp obj
    String fullName;
    String email;

    Button edit;

    public Student(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            ThongTin.editStudent = this;
            ThongTin.stFullName.setText(this.fullName);
            ThongTin.stEmail.setText(this.email);
        });
    }

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public Button getEdit() {
        return edit;
    }

    public Student setEdit(Button edit) {
        this.edit = edit;
        return this;
    }

    public String toString() {
        return this.fullName + " -- " + this.email;
    }

}