import org.junit.Test;

import static org.junit.Assert.*;

public class DiceCupTest {
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DiceCup diceCup1 = new DiceCup(die1, die2);
    @Test
    public void rollSum() {
        int sum = diceCup1.rollSum();
        assertEquals((die1.getFaceValue() + die2.getFaceValue()),sum);
    }
}