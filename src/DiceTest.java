import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class DiceTest {
    Dice die = new Dice();

    @org.junit.Test
    public void roll() {
        // we test if the die can roll facevalues smaller than 1 or
        // bigger than 6.
        for (int i = 1; i <= 1000; i++){
            int faceValue = die.roll();
            assertTrue(1 <= faceValue && faceValue <= 6);
        }

        // we test if the die over 60000 rolls is according to the theoretical
        // probability. We accept if the facevalue is evenly spread - (10000 each)
        //  - among 1 to 6, plus/minus 400.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 1; j <= 60000; j++){
            list.add(die.roll());
        }

        for (int j = 1; j<=6; j++){
            int test = Collections.frequency(list, j);
            assertTrue(9600 <= test && test <= 10400);
        }
    }
}