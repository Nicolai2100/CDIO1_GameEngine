import java.util.Scanner;

public class Player {

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

    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DiceCup diceCup = new DiceCup(die1, die2);
    Message message = new Message(ref1, ref2);
    Scanner scan = new Scanner(System.in);

    //Construktor
    public Player(int aPlayerSumSofar , DiceCup diceCup){
        playerSumSoFar = aPlayerSumSofar;
    }

    //The method of the game that helps control the game flow.
    public void playerRoll(){
        //The method call the method diceCup.rollSum() to roll the dice after the player pushes the return key.
        //The values of each die is printed and the rest of the method is valuating this result.
        String key1 = scan.nextLine();
        diceCup.rollSum();
        System.out.println("Die 1 rolls: " + diceCup.die1.getFaceValue());
        System.out.println("Die 2 rolls: " + diceCup.die2.getFaceValue());

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
            playerWon();
        }
    }

    //Valuates whether the player have won or not.
    public void playerWon(){
        if (playerSumSoFar >= 40 && (diceCup.getFaceValueDie1() == diceCup.getFaceValueDie2())) {
            won = true;
            System.out.println("You win because you have 40 points and got a double!");
        }
    }

    //Valuates what to do if the player rolls two dice of equal value.
    public void playerGotTwoOfEqualValue(){
        if (diceCup.getFaceValueDie1() == 1 && 1 == diceCup.getFaceValueDie2()) {
            playerSumSoFar = 0;
            playerRollSumString = name + "'s sum is " + "0" + ". Current score: " + "0" + "\n";
            System.out.println(playerRollSumString);
            message.playerExtraTurnButLosePoints();
            playerRoll();
        }
        else{

            if (diceCup.die1.getFaceValue() == 6 && diceCup.die2.getFaceValue() == 6){
                playerRollSum = diceCup.getSum();
                playerSumSoFar = playerSumSoFar + playerRollSum;
                lastRollSum = playerRollSum;
                playerRollSumString = name + "'s sum is " + playerRollSum + ". Current score: " + playerSumSoFar + "\n";
                System.out.println(playerRollSumString);
                playerWonBydoubleSix();
            }
            else if (playerSumSoFar < 40){
                playerRollSum = diceCup.getSum();
                playerSumSoFar = playerSumSoFar + playerRollSum;
                lastRollSum = playerRollSum;
                playerRollSumString = name + "'s sum is " + playerRollSum + ". Current score: " + playerSumSoFar + "\n";
                System.out.println(playerRollSumString);
                message.playerHaveAnExtraTurn();
                playerRoll();
            }
            else {
                playerRollSum = diceCup.getSum();
                playerSumSoFar = playerSumSoFar + playerRollSum;
                lastRollSum = playerRollSum;
                playerRollSumString = name + "'s sum is " + playerRollSum + ". Current score: " + playerSumSoFar + "\n";
                System.out.println(playerRollSumString);
                won = true;
                System.out.println("You win because you have 40 points and got a double!");
            }
        }
    }

    //If the player rolled 12 last turn and this turn, he wins!
    public boolean playerWonBydoubleSix(){
        if (playerRollSum == 12 && lastRollSum == 12){
            won = true;
            System.out.println("You win because you got two double sixes in a row!!!");
        }
        else{
            message.playerHaveAnExtraTurn();
            playerRoll();
        }
        return won;
    }

    // Decides who has the first roll of the game
    public void decider(){
        System.out.println("To find out who begins\nThe youngest person will roll the dice:");
        die1.roll();
        System.out.println("The youngest person got " + die1.getFaceValue()+ ".\nThen the other person:");
        die2.roll();
        System.out.println("The other person got " + die2.getFaceValue()+".");

        if (die1.getFaceValue() > die2.getFaceValue()) {
            System.out.println("The youngest person will enter their name first.");
        }
        else if (die1.getFaceValue() < die2.getFaceValue()) {
            System.out.println("The other person will enter their name first.");
        }
        else {
            System.out.println("You got the same value, therefore the youngest person must enter their name first");
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

    public void setLastRollSum(int lastRollSum) {
        this.lastRollSum = lastRollSum;
    }

    public int getLastRollSum() {
        return lastRollSum;
    }

    public void setPlayerRollSum(int playerRollSum) {
        this.playerRollSum = playerRollSum;
    }

    public int getPlayerRollSum() {
        return playerRollSum;
    }

    public boolean getDoubleSixBool(){
        return doubleSixBool;
    }
}
