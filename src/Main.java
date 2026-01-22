import util.Menu;
import contact.ContactManager;
import task.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        ContactManager contactManager = new ContactManager();
        boolean b = true;
        while (b) {
            menu();
            int n = Menu.getMenuNumber();
            switch (n) {
                case 1:
                    contactManager.start();
                    break;
                case 2:

                    taskManager.start();
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    System.out.println("Please choose correct number!");
            }
        }
    }

    public static void menu() {
        System.out.println("** common.Menu **");
        System.out.println("1. Contact Manager");
        System.out.println("2. Task Manager");
        System.out.println("0. Exit");
    }
}
