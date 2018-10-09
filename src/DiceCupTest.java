import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class DiceCupTest {
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DiceCup diceCup1 = new DiceCup(die1, die2);
    @Test
    public void rollSum() {
        int sum = diceCup1.rollSum();
        assertEquals((die1.getFaceValue() + die2.getFaceValue()), sum);

        for (int j = 1; j<=1000; j++) {
            int faceValue1 = die1.roll();
            int faceValue2 = die2.roll();
            int faceValueSum = faceValue1 + faceValue2;
            assertTrue(2 <= faceValueSum && faceValueSum <= 12);
        }

        // we test if the sum of two die is according
        // to the theoretical probability over 10000 rolls. Deviation less than 2%
        // is accepted.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 10000; i++) {
            list.add(die1.roll() + die2.roll());
        }

        // Source: https://wizardofodds.com/gambling/dice/
        double[] theoreticalProbability = {
                                            2.78, 5.56, 8.33, 11.11, 13.89, 16.67,
                                            13.89, 11.11, 8.33, 5.56, 2.78
                                          };

        int index = 0;
        for (int i = 2; i <= 12; i++) {
            double faceValueInstance = Collections.frequency(list, i);
            double instanceInPercent = (faceValueInstance / 10000) * 100;
            double deviation = Math.abs(instanceInPercent - theoreticalProbability[index++]);
            assertTrue( deviation <= 2.0);
        }
    }
}