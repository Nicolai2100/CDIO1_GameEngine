package game;

import gui_main.GUI;

public class Player {
    private GUI gui;
    private String name;
    private String playerRollSumString;

    private int playerRollSum;
    private int playerSumSoFar;
    private int lastRollSum;
    private boolean doubleSixBool = false;
    private boolean won = false;

    private static Player ref1;
    private static Player ref2;

    //Objects
    private DiceCup diceCup;
    private Message message;

    //Construktor
    public Player(int aPlayerSumSofar , DiceCup diceCup, GUI gui){
        playerSumSoFar = aPlayerSumSofar;
        this.diceCup = diceCup;
        this.gui = gui;
        message = new Message(ref1, ref2, gui);
    }

    //The method of the game that helps control the game flow.
    public void playerRoll(){
        //The method call the method diceCup.rollSum() to roll the dice after the player pushes the return key.
        //The values of each die is printed and the rest of the method is valuating this result.
        diceCup.rollSum();
        gui.setDice(diceCup.die1.getFaceValue(), diceCup.die2.getFaceValue());
        gui.showMessage(name +"'s nuværende score: "+(playerSumSoFar+diceCup.getSum()));

        if (diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue()){
            playerGotTwoOfEqualValue();
            }
        //If the player doesn't roll two dice of equal value, the sum of the dice will be saved in the playerSumSoFar.
        else {
            playerRollSum = diceCup.getSum();
            playerSumSoFar = playerSumSoFar + playerRollSum;
            lastRollSum = playerRollSum;
            //Prints out the output of the turn.
            playerRollSumString = name + "'s sum is " + playerRollSum + ". Current score: " + playerSumSoFar + "\n";
            System.out.println(playerRollSumString);
        }
    }
   //Valuates what to do if the player rolls two dice of equal value.
    public void playerGotTwoOfEqualValue(){
        if (playerSumSoFar >= 40){
            won = true;
            playerRollSum = diceCup.getSum();
            playerSumSoFar = playerSumSoFar + playerRollSum;
            lastRollSum = playerRollSum;
            playerRollSumString = name + "'s sum is " + playerRollSum + ". Current score: " + playerSumSoFar + "\n";
            System.out.println(playerRollSumString);
            message.playerWon();}

        else if (diceCup.getFaceValueDie1() == 1 && 1 == diceCup.getFaceValueDie2()) {
            playerSumSoFar = 0;
            message.playerExtraTurnButLosePoints();
            playerRollSumString = name + "'s" + ". Current score: " + "0";
            System.out.println(playerRollSumString);
            playerRoll();
        }
        else if (diceCup.die1.getFaceValue() == 6 && diceCup.die2.getFaceValue() == 6){
                playerRollSum = diceCup.getSum();
                playerSumSoFar = playerSumSoFar + playerRollSum;
                playerRollSumString = name + "'s sum is " + playerRollSum + ". Current score: " + playerSumSoFar + "\n";
                System.out.println(playerRollSumString);
                playerWonByDoubleSix();
                lastRollSum = playerRollSum;
        }
        //(playerSumSoFar < 40)
        else{
                playerRollSum = diceCup.getSum();
                playerSumSoFar = playerSumSoFar + playerRollSum;
                lastRollSum = playerRollSum;
                playerRollSumString = name + "'s sum is " + playerRollSum + ". Current score: " + playerSumSoFar + "\n";
                System.out.println(playerRollSumString);
                message.playerHaveAnExtraTurn();
                playerRoll();
            }
    }
    //If the player rolled 12 last turn and this turn, he wins!
    public void playerWonByDoubleSix(){
        if (playerRollSum == 12 && lastRollSum == 12){
            won = true;
            System.out.println("You win because you got two double sixes in a row!!!");
        }
        else{
            message.playerHaveAnExtraTurn();
            playerRoll();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getWon(){
        return won;
    }

    public int getPlayerSumSoFar() {
        return playerSumSoFar;
    }

    public void setPlayerSumSoFar(int playerSumSoFar) {
        this.playerSumSoFar = playerSumSoFar;
    }

    public int getLastRollSum() {
        return lastRollSum;
    }

    public void setLastRollSum(int lastRollSum) {
        this.lastRollSum = lastRollSum;
    }

    public int getPlayerRollSum() {
        return playerRollSum;
    }

    public void setPlayerRollSum(int playerRollSum) {
        this.playerRollSum = playerRollSum;
    }

    public boolean getDoubleSixBool(){
        return doubleSixBool;
    }
}
