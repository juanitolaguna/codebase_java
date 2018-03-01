// Basic class definition
// public means this class can be used by other classes
// Class names should begin with a capital letter
// A file can't contain two public classes. It can contain classes that are not public
// If you place class files in the same folder the java compiler will be able to find them

/* The Goal of this tutorial is to make a game like this
------------------------------
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||M||F||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|P||*||*||*||*||*||*||*||*||*|
|*||*||*||*||D||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
------------------------------
[9,9]

 */

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class LessonEight {

    public static void main(String[] args) {
        MonsterTwo.buildbattleBoard(); // -> fill the board with '*'
        char[][] tempBattleBoard = new char[10][10]; // -> make a temporary board

        // ObjectName[] ArrayName = new ObjectName[4]
        // -> init ArrayObject(?) give it a name - make the new Object with the length of 4
        // Make an Array to store MonsterTwo class Objects in it,  limit the size to 4 MonsterTwo Objects

        MonsterTwo[] Monsters = new MonsterTwo[4]; // Array with all of the Monsters inside it.
        // load Monsters inside
        Monsters[0] = new MonsterTwo(1000, 20, 1, "Frank");
        Monsters[1] = new MonsterTwo(1000, 40, 2, "Drac");
        Monsters[2] = new MonsterTwo(1000, 20, 1, "Paul");
        Monsters[3] = new MonsterTwo(1000, 20, 1, "George");

        MonsterTwo.redrawBoard();

    }


    for(MonsterTwo m : Monsters){
        if (m.getAlive()){
            int arrayItemIndex = ArrayUtils.indexOf(Monsters, m);
            m.moveMonster(Monsters, arrayItemIndex)
        }
    }

    MonsterTwo.redrawBoard();



}