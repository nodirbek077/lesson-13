package sms;

import contact.ContactManager;
import util.ScannerUtil;

import java.time.LocalDateTime;

public class SmsManager {
    public Sms[] smsArray = new Sms[10];
    public Integer currentIndex = 0;
    public Integer generalId = 1;
    private final ContactManager contactManager;

    public SmsManager(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    public void start() {
        Boolean b = true;
        while (b) {
            menu();
            int n = ScannerUtil.getMenuNumber();

            switch (n) {
                case 1:
                    Sms sms = sendSms();
                    addToArray(sms);
                    break;
                case 2:
                    String phone = getPhoneNumber();
                    printSmsHistory(phone);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    System.out.println("Please choose correct number!");
            }
        }
    }

    public Sms sendSms() {
        System.out.print("Enter phone: ");
        String phone = ScannerUtil.scanner.next();

        System.out.print("Enter text: ");
        String text = ScannerUtil.scannerLine.next();

        Sms sms = new Sms();
        sms.setPhone(phone);
        sms.setText(text);
        return sms;
    }

    public void addToArray(Sms sms) {
        //check phone number
        boolean isPhoneExist = contactManager.isPhoneExist(sms.getPhone());
        if (!isPhoneExist) {
            System.out.println("Phone not found!");
            return;
        }

        sms.setCreatedDate(LocalDateTime.now());
        sms.setId(generalId++);

        if (smsArray.length == currentIndex) {
            Sms[] newArr = new Sms[currentIndex * 2];
            for (int i = 0; i < currentIndex; i++) {
                newArr[i] = smsArray[i];
            }
            smsArray = newArr;
        }
        smsArray[currentIndex] = sms;
        currentIndex++;
    }

    public void printSmsHistory(String phone) {
        System.out.printf("--------------------------------------------------------------------------------------------------%n");
        System.out.printf("|                                        SMS HISTORY                                             |%n");
        System.out.printf("--------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-15s | %-36s | %-6s |%n", "Id", "Phone", "Text", "Created date");
        System.out.printf("--------------------------------------------------------------------------------------------------%n");
        for (Sms sms : smsArray) {
            if (sms != null && sms.getPhone().equals(phone)) {
                System.out.printf("| %-3s | %-15s | %-36s | %-6s |%n",
                        sms.getId(),
                        sms.getPhone(),
                        sms.getText(),
                        sms.getCreatedDate());
            }
        }                  //23T17:32:02.695473400 |
        System.out.printf("-------------------------------------------------------------------------%n");
    }

    public String getPhoneNumber(){
        System.out.print("Enter phone: ");
        return ScannerUtil.scanner.nextLine();
    }

    public void allSmsHistory(){

    }


    public void menu() {
        System.out.println("** Sms Manager Menu **");
        System.out.println("1. Send sms");
        System.out.println("2. Sms History");
        System.out.println("3. All sms history");
        System.out.println("4. Delete sms history");
        System.out.println("0. Exit");
    }
}
