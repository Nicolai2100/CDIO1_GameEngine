package test;

import game.Dice;
import game.DiceCup;
import game.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DiceCup diceCup = new DiceCup(die1, die2);
    Player player1 = new Player(0, diceCup);
    Player player2 = new Player(0, diceCup);

    @Test(timeout = 333) //let the test fail after 333 ms.
    public void playerRoll() {
        diceCup.rollSum();
        System.out.println("Die 1 rolls: " + diceCup.getFaceValueDie1());
        System.out.println("Die 2 rolls: " + diceCup.getFaceValueDie2());
    }

    /*
    @Test
    public void playerWon() {
        player1.getWon();
        player1.setPlayerSumSoFar(40);
        player1.diceCup.setFaceValueDie1(2);
        player1.diceCup.setFaceValueDie2(4);
        //player1.playerWon();
        assertEquals(false, player1.getWon());
        player1.diceCup.setFaceValueDie1(4);
        //player1.playerWon();
        assertEquals(true, player1.getWon());
    }*/

    @Test
    public void playerWonBydoubleSix() {
        player1.getWon();
        assertEquals(player1.getWon(), false);
        player1.setPlayerRollSum(12);
        player1.setLastRollSum(12);
        player1.playerWonByDoubleSix();
        assertEquals(player1.getWon(), true);
    }
}