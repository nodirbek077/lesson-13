package contact;

public class Contact {
    private String name;
    private String surname;
    private String phone;

//    public Contact(String name, String surname, String phone) {
//        this.name = name;
//        this.surname = surname;
//        this.phone = phone;
//    }
//

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
