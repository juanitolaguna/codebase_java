package tutorium; /**
 * Created on 11/04/2017.
 */

import java.util.Scanner;

public class Flusskontrolle {
    public static void spaceship() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte 2 Zahlen eingeben!");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x < y) {
            System.out.println("-1: Erste zahl ist kleiner!");
        } else if (x > y) {
            System.out.println("1: Erste zahl ist größer!");
        } else {
            System.out.println("0: Beide Zahlen sind gleichgroß!");
        }

        sc.close();
    }

    public static void passwortKontrolle() {

        Scanner sc = new Scanner(System.in);
        String pw = "haw123";
        System.out.println("Bitte PW eingeben!");
        String x = sc.nextLine();
        int i = 0;
        int z = 3;

        while (i < 3) {
            if (x.equals(pw)) {
                System.out.println("Das Passwort war richtig!");
                i = 3;
            } else {
                System.out.println("Bitte richtiges passwort eingeben! Verbleibende Versuche: " + --z);
                if (z > 0) {
                    pw = sc.nextLine();
                }
                i++;
            }
        }
        sc.close();
    }

    public static void zweierPotenz() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Zahl eingeben!");
        int x = sc.nextInt();
        for (double i = 0; i <= x; i++) {
            System.out.println("2 hoch " + i + " = " + ((int) Math.pow(2, i)));
        }
    }


}
