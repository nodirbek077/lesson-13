package common;

import java.util.Scanner;

public class Menu {

    public static int getMenuNumber() {
        System.out.print("Choose menu: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
