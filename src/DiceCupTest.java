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
        assertEquals((die1.getFaceValue() + die2.getFaceValue()),sum);

        for (int j = 1; j<=1000; j++) {
            int øjneTerning1 = die1.roll();
            int øjneTerning2 = die2.roll();
            int øjneSum = øjneTerning1 + øjneTerning2;
            assertTrue(2 <= øjneSum && øjneSum <= 12);
        }

        // tester om sum af 2 terninger fordeler sig ud fra
        // den teoretiske sandsynlighed. Afvigelse mindre end 2 %
        // accepteres. På 10000 kast svarer det til +- 200 kast.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 10000; i++) {
            list.add(die1.roll() + die2.roll());
        }

        // https://wizardofodds.com/gambling/dice/
        // &&
        // http://alumnus.caltech.edu/~leif/FRP/probability.html
        double[] teoretiskSandsynlighed = {2.78, 5.56, 8.33, 11.11, 13.89, 16.67,
                13.89, 11.11, 8.33, 5.56, 2.78};
        int index = 0;
        for (int i = 2; i <= 12; i++) {
            double tilfældeAfØjne = Collections.frequency(list, i);
            double tilfældeIProcent = (tilfældeAfØjne / 10000) * 100;
            double afvigelse = Math.abs(tilfældeIProcent - teoretiskSandsynlighed[index++]);
            assertTrue( afvigelse <= 2.0);
        }
    }


}