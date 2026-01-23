import sms.SmsManager;
import util.ScannerUtil;
import contact.ContactManager;
import task.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        ContactManager contactManager = new ContactManager();
        SmsManager smsManager = new SmsManager(contactManager);
        boolean b = true;
        while (b) {
            menu();
            int n = ScannerUtil.getMenuNumber();
            switch (n) {
                case 1:
                    contactManager.start();
                    break;
                case 2:
                    taskManager.start();
                    break;
                case 3:
                    smsManager.start();
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
        System.out.println("** Main Menu **");
        System.out.println("1. Contact Manager");
        System.out.println("2. Task Manager");
        System.out.println("3. SMS Manager");
        System.out.println("0. Exit");
    }
}
