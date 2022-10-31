package util;


import com.sun.tools.javac.Main;

import java.util.Scanner;

import static DB.DB.APP_PASSWORD;
import static DB.DB.APP_USERNAME;


public final class ApplicationUtil {
    public static void printError(String errorMessage) {
        System.err.println("Error=>\n" + errorMessage);
    }

    public static int validateAndReturnNumberInput(String stringValue) {
        try {
            return Integer.parseInt(stringValue);
        } catch (NumberFormatException ex) {
            ApplicationUtil.printError("Emeliyyatin nomresini daxil edin !!!");
            return -1;
        }
    }

    public static void isStopped(String[] args, Scanner input) throws Exception {
        System.out.println("Proqram davam etsin?  Y/N");
        String off = input.next();
        if (off.equals("Y")) {
            Main.main(new String[]{"true"});
        } else {
            System.out.println("Proqram ugurla yerine yetirildi");
        }
    }



    public static boolean login(String username, String password){
        return username.equals(APP_USERNAME) && password.equals(APP_PASSWORD);
    }


}

