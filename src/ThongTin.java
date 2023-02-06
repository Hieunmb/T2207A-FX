import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ThongTin {
    public TextField txtFullName;
    public TextField txtFullEmail;
    public Text txtInfor;
    public ObservableList<Student> listStudent = FXCollections.observableArrayList();
    public ListView<Student> lv;
    public Student editStudent;

    public void submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String fe = txtFullEmail.getText();
        if(editStudent==null){
            Student s= new Student(fn,fe);
            listStudent.add(s);
        }else {
//            editStudent.setEmail(fe);
//            editStudent.setFullName(fn);
            for(Student s:listStudent){
                if (s.getEmail().equals(editStudent.email) && s.fullName.equals(editStudent.fullName)) {
                    s.setEmail(fe);
                    s.setFullName(fn);
                }
            }
        }
//        Student s = new Student(fn, fe);
//        listStudent.add(s);
        lv.setItems(listStudent);
        lv.refresh();
        editStudent=null;
        clearInput();
    }
    void clearInput(){
        txtFullName.clear();
        txtFullEmail.clear();
    }

    public void edit(MouseEvent mouseEvent) {
        editStudent = lv.getSelectionModel().getSelectedItem();
        txtFullEmail.setText(editStudent.getEmail());
        txtFullName.setText(editStudent.getFullName());
    }
//        IStudent s= new IStudent() { //anonymous class
//            @Override
//            public void learn(int a) {
//
//            }
//        };
//
//        //lambda expression
//        IStudent s1 =(a) ->{
//
//        };
//        s1.learn(5);
//        ArrayList<String> arrs = new ArrayList<>();
//        arrs.add("Hello");
//        arrs.add("world");
//        arrs.stream().filter(s->!s.equals("a")).forEach(s->{
//            System.out.println(s);
//        });
}