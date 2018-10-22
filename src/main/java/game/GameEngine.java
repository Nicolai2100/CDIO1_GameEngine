package game;

import gui_main.GUI;

import java.util.Scanner;

public class GameEngine {

    public GameEngine(){ }

    //The method from where the game runs.
    public void playGame(){
        GUI gui = new GUI();

        //Objects are created
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        DiceCup diceCup1 = new DiceCup(die1, die2);
        Player player1 = new Player( 0, diceCup1, gui);
        Player player2 = new Player( 0, diceCup1, gui);
        Message message = new Message(player1, player2, gui);

        //Method that gives an introduction to the game. Rules, etc.
        message.startGame();

        //Set player 1 name
        message.startGame1();
        player1.setName(gui.getUserString("Indtast player 1's navn: "));
        //Set player 2 name
        message.startGame2();
        player2.setName(gui.getUserString("Indtast player 2's navn: "));

        //Start the main game
        do {
            message.player1sTurn();
            player1.playerRoll();
            //gui.setDice(diceCup1.getFaceValueDie1(), diceCup1.getFaceValueDie2());

            if (player1.getWon()){
                break;
            }
            message.player2sTurn();
            player2.playerRoll();
            //gui.setDice(diceCup1.getFaceValueDie1(), diceCup1.getFaceValueDie2());

            if (player2.getWon()){
                break;
            }
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while(!player1.getWon() || !player2.getWon());

        //Give a message about who won the game
        message.playerHasWon();


        String svar = gui.getUserString("Vil du spille igen? tast ja/nej");
        if (svar.equals("ja"))
            playGame();

        else
            gui.showMessage("Farvel");


    }
}