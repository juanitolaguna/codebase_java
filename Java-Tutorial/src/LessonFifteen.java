/**
 * Created on 24/01/2017.
 */
public class LessonFifteen {
    public static void main(String[] args) {

        Vehicle car = new Vehicle(4, 100.00);
        System.out.println("Cars Max Speed " + car.getSpeed());
        System.out.println("Num of Wheels " + car.getWheel());

        car.setCarStrength(10);
        System.out.println("Car Strength " + car.getCarSrength());
    }
}
