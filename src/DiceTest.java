import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class DiceTest {
    Dice die = new Dice();

    @org.junit.Test
    public void roll() {
        for (int i = 1; i<=1000; i++){
            int faceValue = die.roll();
            assertTrue(1<= faceValue && faceValue <= 6);
        }

        // Vi tester om terningen over 60000 kast fordeler sig statistisk repræsentativt.
        // Det vil sige at alle øjne skal have været vist 10000 gange plus/minus 400.
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