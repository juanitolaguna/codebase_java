//superclass
public class Animals {

    private String name = "Animal"; // - ainimals class itself only has acces
    public String favFood = "Food"; // everybody has acces

    // protected - permit the subclasses to acces the method of the given superclass
    // final -  indicates that method can't be overridden by subclasses

    protected final void changeName(String newName) {
        this.name = newName;
    }

    protected final String getName() {
        return this.name;
    }

    public void eatStuff() {
        System.out.println("Yum" + favFood);
    }

    public void walkAround() {
        System.out.println(this.name + "walks around!");
    }

    //constructor
    public Animals() {

    }

    public Animals(String name, String favFood) {
        this.changeName(name);
        this.favFood = favFood;
    }


}
