/**
 * Created on 24/01/2017.
 */
public class Vehicle extends Crashable implements Drivable, Cloneable {

    int numOfWheels = 2;
    double theSpeed = 0;
    int carStrength = 0;

    public int getWheel() {
        return this.numOfWheels;
    }

    public void setWheels(int numWheels) {
        this.numOfWheels = numWheels;
    }

    public double getSpeed() {
        return this.theSpeed;
    }

    public void setSpeed(double speed) {
        this.theSpeed = speed;
    }

    //constructor
    public Vehicle() {

    }

    public Vehicle(int wheels, double speed) {
        this.numOfWheels = wheels;
        this.theSpeed = speed;
    }


    public void setCarStrength(int carStrength) {
        this.carStrength = carStrength;
    }

    public int getCarSrength() {
        return this.carStrength;
    }


    public String toString() {
        return "num of wheels: " + this.numOfWheels;
    }

    //clone not supported exception
    public Object clone() {
        Vehicle car;
        try {
            car = (Vehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        } return car;
    }

}
