import static org.junit.Assert.*;

public class DiceTest {
    Dice die = new Dice();

    @org.junit.Test
    public void roll() {
        for (int i = 1; i<=1000; i++){
            int faceValue = die.roll();
            assertTrue(1<= faceValue && faceValue <= 6);
        }
    }
}