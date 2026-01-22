package util;

import java.util.Scanner;

public class ScannerUtil {
    public static Scanner scanner;
    public static Scanner scannerLine;
    public static Scanner scannerInt;

    static {
        scanner = new Scanner(System.in);
        scannerLine = new Scanner(System.in);
        scannerInt = new Scanner(System.in);
    }

    public static int getMenuNumber() {
        System.out.print("Choose menu: ");
        return ScannerUtil.scanner.nextInt();
    }
}
