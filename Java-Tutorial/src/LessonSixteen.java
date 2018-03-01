/**
 * Created on 24/01/2017.
 */
public class LessonSixteen {

    public static void main(String[] args) {
        Object superCar = new Vehicle();
        System.out.println(((Vehicle)superCar).getSpeed());
        Vehicle superTruck = new Vehicle();
        System.out.println(superCar.equals(superTruck));
        System.out.println(superCar.hashCode());
        System.out.println(superCar.getClass());
        System.out.println(superCar.getClass().getName());

        if (superCar.getClass() == superTruck.getClass()) {
            System.out.println("the same class!");
        }

        System.out.println(superCar.getClass().getSuperclass());
        System.out.println(superCar);

        superTruck.setWheels(6);

        Vehicle superTruck2 = (Vehicle) superTruck.clone();

        System.out.println(superTruck.getWheel());
        System.out.println(superTruck2.getWheel());

        System.out.println(superTruck.hashCode());
        System.out.println(superTruck2.hashCode());



    }
}
