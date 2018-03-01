/**
 * Created on 29/01/2017.
 */
public class LessonSeventeen {

    public static void main(String[] args) {
        Thread getTime = new GetTime20();
        long minPrime;
        Runnable getMail = new GetTheMail(10);
        Runnable getMailAgain = new GetTheMail(20);

        getTime.start();
        new Thread(getMail).start();
        new Thread(getMailAgain).start();
    }

}
