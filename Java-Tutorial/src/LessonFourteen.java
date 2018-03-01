
public class LessonFourteen {

    public static void main(String[] args) {

        Animals genericAnimal = new Animals();
        System.out.println(genericAnimal.getName());
        System.out.println(genericAnimal.favFood);

        Cats morris = new Cats("Morris", "Tuna", "Rubber Mouse");
        System.out.println(morris.getName());
        System.out.println(morris.favFood);
        System.out.println(morris.getFavToy());

        Animals tabby = new Cats("Tabby", "Salmon", "Ball");
        acceptAnimal(tabby);

    }

    public static void acceptAnimal(Animals randAnimal) {

        System.out.println();
        System.out.println(randAnimal.getName());
        System.out.println(randAnimal.favFood);
        System.out.println();

        randAnimal.walkAround();

        // error - System.out.println(randAnimal.favToy);

        // to solve problem you can cast it
        Cats tempCat = (Cats) randAnimal;
        System.out.println(tempCat.getFavToy());

        // or like that in one line
        System.out.println(((Cats) randAnimal).getFavToy());

        if (randAnimal instanceof Cats) {
            System.out.println(randAnimal.getName() + " is a Cat!");
        }

    }

}
