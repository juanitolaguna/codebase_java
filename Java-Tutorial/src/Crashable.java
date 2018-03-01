/**
 * Created on 24/01/2017.
 */
public abstract class Crashable {
    boolean carDrivable = true;

    public void youCrashed() {
        this.carDrivable = false;
    }

    public abstract void setCarStrength(int carStrength);

    public abstract int getCarSrength();
}
