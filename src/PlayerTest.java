import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DiceCup diceCup = new DiceCup(die1, die2);
    Player player1 = new Player(0, diceCup);
    Player player2 = new Player(0, diceCup);

    @Test
    public void playerRoll() {
    }

    @Test
    public void playerWon() {
        System.out.println(player1.getWon());
        System.out.println(diceCup.getFaceValueDie1());
        System.out.println(diceCup.getFaceValueDie2());
        diceCup.setFaceValueDie1(4);
        diceCup.setFaceValueDie2(2);
        player1.setPlayerSumSoFar(40);

        player1.playerWon();
        System.out.println(diceCup.getFaceValueDie1());
        System.out.println(diceCup.getFaceValueDie2());

        //assertEquals(false, player1.getWon());
        diceCup.setFaceValueDie2(4);
        player1.playerWon();
        assertEquals(true, player1.getWon());


    }

    @Test
    public void playerGotTwoOfEqualValue() {
    }

    @Test
    public void playerWonBydoubleSix() {
    }

    @Test
    public void decider() {
    }
}