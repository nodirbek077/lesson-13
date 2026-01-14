import java.util.Scanner;

public class Main {
    //global variables
    static Contact[] contactArray = new Contact[2];//[null, null, null, null]
    static int currentIndex = 0;

    public static void main(String[] args) {
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
        System.out.println("The End");
    }

    public static Contact addContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter surname: ");
        String surname = scanner.next();

        System.out.print("Enter phone: ");
        String phone = scanner.next();

        Contact contact = new Contact();
        contact.name = name;
        contact.surname = surname;
        contact.phone = phone;

        return contact;
    }

    public static boolean isValidContact(Contact contact) {
        if (contact.name == null || contact.name.trim().length() < 3) {
            System.out.println("Contact name is wrong!");
            return false;
        }

        if (contact.surname == null || contact.surname.trim().length() < 3) {
            System.out.println("Contact surname is wrong!");
            return false;
        }

        //998945283534 => length = 12
        if (contact.phone == null || contact.phone.trim().length() != 12 ||
                !contact.phone.startsWith("998")) {
            System.out.println("Contact phone is wrong!");
            return false;
        }

        //check phone for digits not alphabet
        char[] phoneArr = contact.phone.toCharArray();//[9,9,8,9,4,5,2,8,3,5,3,4]
        for (char c : phoneArr) {
            if (!Character.isDigit(c)) {
                System.out.println("Contact phone is wrong!");
                return false;
            }
        }//c < '0' || c > '9'

        return true;

    }

    public static void addToArray(Contact contact) {
        if (!isValidContact(contact)) {
            return;
        }

        if (isPhoneExist(contact.phone)) {
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

    public static void printContactList() {
        for (Contact c : contactArray) {
            if (c != null) {
                System.out.println(c.name + " " + c.surname + " " + c.phone);
            }
        }
    }

    public static String getQuery() {
        System.out.print("Enter query: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void search(String query) {
        query = query.toLowerCase();
        for (Contact contact : contactArray) {
            if (contact == null) {
                continue;
            }

            if (contact.name.toLowerCase().contains(query) || contact.surname.toLowerCase().contains(query) || contact.phone.contains(query)) {
                System.out.println(contact.name + " " + contact.surname + " " + contact.phone);
            } else {
                System.out.println("Hech narsa topilmadi!");
                break;
            }
        }
    }

    public static boolean isPhoneExist(String phone) {
        for (Contact contact : contactArray) {
            if (contact != null && contact.phone.equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public static String deleteContact() {
        System.out.print("Enter phone: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void deleteContactFromArray(String phone) {
        for (int i = 0; i < contactArray.length; i++) {
            Contact contact = contactArray[i];
            if (contact != null && contact.phone.equals(phone)) {
                contactArray[i] = null;
                System.out.println("Contact deleted.");
                break;
            }
        }

        System.out.println("Contact not deleted.");
    }

    public static void menu() {
        System.out.println("** Menu **");
        System.out.println("1-Add Contact");
        System.out.println("2-Contact List");
        System.out.println("3-Search");
        System.out.println("4-Delete Contact");
        System.out.println("0-Exit");
    }

    public static int getMenuNumber() {
        System.out.print("Choose menu: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
