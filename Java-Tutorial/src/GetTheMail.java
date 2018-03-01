/**
 * Created on 29/01/2017.
 */
public class GetTheMail implements Runnable { // Interfaces allows multiple class extention

    private int startTime;

    //constructor
    public GetTheMail(int startTime) {
        this.startTime = startTime;
    }

    public void run() {
        try {
            Thread.sleep(startTime * 1000);
        } catch (InterruptedException e) {
        }

        System.out.println("CheckingMail");

    }
}
