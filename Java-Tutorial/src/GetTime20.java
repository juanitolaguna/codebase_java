import java.util.*;
import java.text.DateFormat;


public class GetTime20 extends Thread { //exends can do only one class

    public void run() {

        Date rightNow;
        Locale currentLocale;
        DateFormat timeFormatter;
        DateFormat dateFormatter;
        String timeOut;
        String dateOut;

        for(int i = 1; i <= 20; i++) {
            rightNow = new Date();
            currentLocale = new Locale("en");

            timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
            dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);

            timeOut = timeFormatter.format(rightNow);
            dateOut = dateFormatter.format(rightNow);

            System.out.println(timeOut);
            System.out.println(dateOut);
            System.out.println();

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {}
        }
    }
}
