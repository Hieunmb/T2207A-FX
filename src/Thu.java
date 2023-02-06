import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Thu {

    public TextField txtNguoiNhan;
    public TextField txtTieuDe;
    public TextArea txtNoiDung;
    public Text txtInfor;

    public void submit(ActionEvent actionEvent) {
        String fn = txtNguoiNhan.getText();
        String fe = txtTieuDe.getText();
        String txt =txtNoiDung.getText();
        String inf=txtInfor.getText();
        inf +="\n\n\nNguoi Nhan:" +fn+"\n"+"Tieu De: "+fe+"\n"+"Noi Dung:"+txt;
        txtInfor.setText(inf);
    }
}
