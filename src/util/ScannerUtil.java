package util;

import java.util.Scanner;

public class ScannerUtil {

    public static int getMenuNumber() {
        System.out.print("Choose menu: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
