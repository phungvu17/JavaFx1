import javafx.scene.control.Button;

public class Phone {
    String Name;
    String Telephone;
    Button edit;

    public Phone(String name, String telephone) {
        Name = name;
        Telephone = telephone;
        this.edit = new Button("edit");
        this.edit.setOnAction((event )-> {
            TelePhone.EditPhone = this;
            TelePhone.stName.setText(this.Name);
            TelePhone.stTelephone.setText(this.Telephone);

        });
    }

    public String getName() {
        return Name;
    }



    public String getTelephone() {
        return Telephone;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String toString(){
        return this.Name;
    }
    public void setOnAction(Object o) {


    }
}
