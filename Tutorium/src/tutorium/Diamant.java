package tutorium;

/**
 * Created on 28/03/2017.
 */
public class Diamant {
    public static void main(String[] args) {
        zeichneDiamant(5);
        System.out.println();
        zeichneDiamant(7);
        System.out.println();
        zeichneDiamant(11);
        zeichneDiamant(101);
    }

    public static void zeichneDiamant(int i, int z) {

        for (int n = 0; n < (i - z) / 2; n++) {
            System.out.print(".");
        }
        for (int n = 0; n < z; n++) {
            System.out.print("*");
        }
        for (int n = 0; n < (i - z) / 2; n++) {
            System.out.print(".");
        }
        System.out.println();

        if (i != z) {
            zeichneDiamant(i, z + 2);
        }
        if (z != i) {
            for (int n = 0; n < (i - z) / 2; n++) {
                System.out.print(".");
            }
            for (int n = 0; n < z; n++) {
                System.out.print("*");
            }
            for (int n = 0; n < (i - z) / 2; n++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }


    //overload mit 1 Parameter
    public static void zeichneDiamant(int i) {
        if (i % 2 != 0 && i > 0) {
            zeichneDiamant(i, 1);
        } else {
            System.out.println("Bitte eine Zahl % 2 = 1 und Zahl > 0 eingeben!!!");
        }
    }
}
