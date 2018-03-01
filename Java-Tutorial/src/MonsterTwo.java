import java.util.Arrays;

public class MonsterTwo {


    static char[][] battleBoard = new char[10][10];

    public static void buildbattleBoard() {
        for (char[] row : battleBoard) {
            Arrays.fill(row, '*');
        }
    }

    public static void redrawBoard() {
        //draw a line
        int k = 1;
        while (k <= 30) {
            System.out.print('-');
            k++;
        }
        System.out.println();

        //make the board
        for (int i = 0; i < battleBoard.length; i++) {

            for (int j = 0; j < battleBoard[i].length; j++) {
                System.out.print("|" + battleBoard[i][j] + "|");
            }
            System.out.println();
        }

        //draw another line
        k = 1;
        while (k <= 30) {
            System.out.print('-');
            k++;
        }
        System.out.println();
    }


    // Class Variables or Fields


    // You declare constants with final
    public final String TOMBSTONE = "Here Lies a Dead monster";


    // private fields are not visible outside of the class
    private int health = 500;
    private int attack = 20;
    private int movement = 2;
    private boolean alive = true;


    // public variables are visible outside of the class
    // You should have as few as possible public fields
    public String name = "Big Monster";
    public char nameChar1 = 'B';
    public int xPosition = 0;
    public int yPosition = 0;
    public static int numOfMonsters = 0;


    //getter
    public int getAttack() {
        return attack;
    }

    public int getMovement() {
        return movement;
    }

    public int getHealth() {
        return health;
    }

    public boolean getAlive() {
        return alive;
    }

    public void moveMonster(MonsterTwo[] monster, int arrayItemIndex) {

        boolean isSpaceOpen = true;
        int maxXBoardSpace = battleBoard.length - 1;
        int maxYBoardSpace = battleBoard[0].length - 1;

        while (isSpaceOpen) {

            int randMoveDirection = (int) (Math.random() * 4);
            int randMoveDistance = (int) (Math.random() * this.getMovement() + 1);

            System.out.println(randMoveDistance + " " + randMoveDirection);
            battleBoard[this.yPosition][this.xPosition] = '*';

            if (randMoveDirection == 0) {
                if ((this.yPosition - randMoveDistance) < 0) {
                    this.yPosition == 0;
                } else {
                    this.yPosition = this.yPosition - randMoveDistance;
                }
            } else if (randMoveDirection == 1) {
                if ((this.yPosition - randMoveDistance) < 0) {
                    this.yPosition == 0;
                } else {
                    this.yPosition = this.yPosition - randMoveDistance;
                }
            }
        }


    }


    public void setHealth(int decreaseHealth) {
        health = health - decreaseHealth;
        if (health < 0) {
            alive = false;
        }
    }

    public void setHealth(double decreaseHealth) {
        int intDecreaseHealth = (int) decreaseHealth;
        health = health - intDecreaseHealth;
        if (health < 0) {
            alive = false;
        }
    }


    //        Constructor
    public MonsterTwo(int health, int attack, int movement, String name) {
        this.health = health;
        this.attack = attack;
        this.movement = movement;
        this.name = name;

        int maxXBoardSpace = battleBoard.length - 1;
        int maxYBoardSpace = battleBoard[0].length - 1;


        int randNumX, randNumY;

        do {
            randNumX = (int) (Math.random() * maxXBoardSpace);
            randNumY = (int) (Math.random() * maxYBoardSpace);

        } while (battleBoard[randNumX][randNumY] != '*');

        this.xPosition = randNumX;
        this.yPosition = randNumY;

        this.nameChar1 = this.name.charAt(0);

        battleBoard[this.yPosition][this.xPosition] = this.nameChar1;

        numOfMonsters++;


    }

    public MonsterTwo() {
        numOfMonsters++;
    }


}


