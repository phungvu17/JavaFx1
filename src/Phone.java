public class Phone {
    String Name;
    String Telephone;

    public Phone(String name, String telephone) {
        Name = name;
        Telephone = telephone;
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

    public String toString(){
        return this.Name;
    }
    public void setOnAction(Object o) {


    }
}
