import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean b = true;
        while (b) {
            menu();
            int n = getMenuNumber();

            switch (n) {
                case 1:
                    Contact contact = addContact();
                    if (!isValidContact(contact)) {
                        //
                    }
                    System.out.println(contact.name + " " + contact.surname);
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //
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
