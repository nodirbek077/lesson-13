import java.util.Scanner;

public class ContactManager {
    //global variables
    Contact[] contactArray = new Contact[2];//[null, null, null, null]
    int currentIndex = 0;

    public void start() {
        boolean b = true;
        while (b) {
            menu();
            int n = getMenuNumber();

            switch (n) {
                case 1:
                    Contact contact = addContact();
                    addToArray(contact);
                    break;
                case 2:
                    printContactList();
                    break;
                case 3:
                    String query = getQuery();
                    search(query);
                    break;
                case 4:
                    String phone = deleteContact();
                    deleteContactFromArray(phone);
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    System.out.println("Please choose correct number!");
            }
        }
    }

    public Contact addContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter surname: ");
        String surname = scanner.next();

        System.out.print("Enter phone: ");
        String phone = scanner.next();

//        Contact contact = new Contact(name, surname, phone);
//        contact.name = name;
//        contact.surname = surname;
//        contact.phone = phone;

//        return new Contact(name, surname, phone);

        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        return contact;
    }

    public boolean isValidContact(Contact contact) {
        if (contact.getName() == null || contact.getName().trim().length() < 3) {
            System.out.println("Contact name is wrong!");
            return false;
        }

        if (contact.getSurname() == null || contact.getSurname().trim().length() < 3) {
            System.out.println("Contact surname is wrong!");
            return false;
        }

        //998945283534 => length = 12
        if (contact.getPhone() == null || contact.getPhone().trim().length() != 12 ||
                !contact.getPhone().startsWith("998")) {
            System.out.println("Contact phone is wrong!");
            return false;
        }

        //check phone for digits not alphabet
        char[] phoneArr = contact.getPhone().toCharArray();//[9,9,8,9,4,5,2,8,3,5,3,4]
        for (char c : phoneArr) {
            if (!Character.isDigit(c)) {
                System.out.println("Contact phone is wrong!");
                return false;
            }
        }//c < '0' || c > '9'

        return true;

    }

    public void addToArray(Contact contact) {
        if (!isValidContact(contact)) {
            return;
        }

        if (isPhoneExist(contact.getPhone())) {
            System.out.println("Phone number exists!");
            return;
        }

        if (currentIndex == contactArray.length) {
            Contact[] newArray = new Contact[contactArray.length * 2];

            for (int i = 0; i < contactArray.length; i++) {
                newArray[i] = contactArray[i];
            }
            contactArray = newArray;
        }
        contactArray[currentIndex] = contact;
        currentIndex++;
        System.out.println("Contact added.");
    }

    public void printContactList() {
        for (Contact c : contactArray) {
            if (c != null) {
                System.out.println(c.getName() + " " + c.getSurname() + " " + c.getPhone());
            }
        }
    }

    public String getQuery() {
        System.out.print("Enter query: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void search(String query) {
        query = query.toLowerCase();
        for (Contact contact : contactArray) {
            if (contact == null) {
                continue;
            }

            if (contact.getName().toLowerCase().contains(query) || contact.getSurname().toLowerCase().contains(query) || contact.getPhone().contains(query)) {
                System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhone());
            } else {
                System.out.println("Hech narsa topilmadi!");
                break;
            }
        }
    }

    public boolean isPhoneExist(String phone) {
        for (Contact contact : contactArray) {
            if (contact != null && contact.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public String deleteContact() {
        System.out.print("Enter phone: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void deleteContactFromArray(String phone) {
        for (int i = 0; i < contactArray.length; i++) {
            Contact contact = contactArray[i];
            if (contact != null && contact.getPhone().equals(phone)) {
                contactArray[i] = null;
                System.out.println("Contact deleted.");
                break;
            }
        }

        System.out.println("Contact not deleted.");
    }

    public void menu() {
        System.out.println("** Menu **");
        System.out.println("1-Add Contact");
        System.out.println("2-Contact List");
        System.out.println("3-Search");
        System.out.println("4-Delete Contact");
        System.out.println("0-Exit");
    }

    public int getMenuNumber() {
        System.out.print("Choose menu: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
