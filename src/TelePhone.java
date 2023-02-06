import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TelePhone {

    public TextField tdtName;

    public TextField tdtTelephone;

    public Text tdtInfo;

    public ObservableList<Phone> ListPhone = FXCollections.observableArrayList();
    public ListView<Phone> lv;
    public Phone EditPhone;
    public void submit(ActionEvent actionEvent) {
        String na = tdtName.getText();
        String ph = tdtTelephone.getText();
        if (EditPhone == null){
            Phone p = new Phone(na,ph);
            ListPhone.add(p);
        }else {
            EditPhone.setName(na);
            EditPhone.setTelephone(ph);
            for ( Phone p:ListPhone){
                if (p.Telephone.equals(EditPhone.Telephone) && p.Name.equals(EditPhone.Name)){
                    p.setName(na);
                    p.setTelephone(ph);
                }
            }
        }
        lv.setItems(ListPhone);
        lv.refresh();
        EditPhone = null;
        clearInput();

    }
    void clearInput(){
        tdtName.clear();
        tdtTelephone.clear();
    }






    public void edit(MouseEvent mouseEvent) {
        EditPhone = lv.getSelectionModel().getSelectedItem();
        tdtName.setText(EditPhone.getName());
        tdtTelephone.setText(EditPhone.getTelephone());

    }

    private boolean ascending = true;
    public void sout(ActionEvent actionEvent) {
        ascending = !ascending;
        Collections.sort(ListPhone, new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                if (ascending) {
                    return o1.Name.compareTo(o2.Name);
                } else {
                    return o2.Name.compareTo(o1.Name);
                }
            }
        });



    }
}
