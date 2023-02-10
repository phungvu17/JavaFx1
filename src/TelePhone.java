import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.*;

public class TelePhone implements Initializable {

    public TextField tdtName;

    public TextField tdtTelephone;
    public static TextField stName ;

    public static TextField stTelephone;

    public Text tdtInfo;

    public ObservableList<Phone> ListPhone = FXCollections.observableArrayList();

    public static Phone EditPhone;
    public TableView<Phone> tbview;
    public TableColumn<Phone,String> cName;
    public TableColumn<Phone,String> cTelephone;
    public TableColumn<Phone, Button> cAction;

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
        tbview.setItems(ListPhone);
        tbview.refresh();
        EditPhone = null;
        clearInput();

    }
    void clearInput(){
        tdtName.clear();
        tdtTelephone.clear();
    }






    public void edit(MouseEvent mouseEvent) {
       // EditPhone = lv.getSelectionModel().getSelectedItem();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cTelephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stTelephone = tdtTelephone;
        stName = tdtName;
    }
}
