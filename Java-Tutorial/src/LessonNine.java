import java.util.Arrays;

public class LessonNine {

    public static void main(String[] args) {

        int[] randomArray;
        int[] numberArray = new int[10];

        randomArray = new int[20];
        randomArray[1] = 2;

        // ich dachte man kann nur eins nacheins reinpushen, das ist besser so.
        String[] stringArray = {"just", "random", "words"};

        //iterate over Array
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = i;
        }
        int k = 1;
        while (k <= 41) {
            System.out.print('-');
            k++;
        }
        System.out.println();

        for (int j = 0; j < numberArray.length; j++) {
            System.out.print("| " + j + " ");
        }
        System.out.println("|");

        String[][] multiArray = new String[10][10];
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {

                multiArray[i][j] = i + " " + j;

            }
        }

        k = 1;
        while (k <= 41) {
            System.out.print('-');
            k++;
        }
        System.out.println();

        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {

                System.out.print("|" + multiArray[i][j] + " ");

            }
            System.out.println("|");
        }

        k = 1;
        while (k <= 41) {
            System.out.print('-');
            k++;
        }
        System.out.println();


        //enhanced loop
        for (int row : numberArray){
            System.out.print(row);
        }
        System.out.println("\n");

        //on multiArray
        for (String[] rows : multiArray){
            for (String cols : rows){
                System.out.print("|" + cols + " ");
            }
            System.out.println("|");
        }

        int[] numberCopy = Arrays.copyOf(numberArray, 5);
        for (int row : numberCopy){
            System.out.print(row);
        }
        System.out.println("\n");

        int[] rangeCopy = Arrays.copyOfRange(numberArray, 3, 6);
        for (int row : rangeCopy){
            System.out.print(row);
        }
        System.out.println("\n");
        System.out.println(Arrays.toString(rangeCopy));

        int[] moreNumbers = new int[100];
        Arrays.fill(moreNumbers, 2);


        char[][] boardGame = new char[10][10];
        for(char[] row : boardGame){
             Arrays.fill(row, '*');
        }

        int[] numToSort = new int[10];
        for(int i = 0;  i<10; i++){
            numToSort[i] = (int) (Math.random() * 100);

        }
        Arrays.sort(numToSort);
        System.out.println(Arrays.toString(numToSort));

        int whereIs50 = Arrays.binarySearch(numToSort, 50);
        System.out.println(whereIs50);
    }
}
