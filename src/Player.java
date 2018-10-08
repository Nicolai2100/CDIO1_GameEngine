import java.util.Scanner;

public class Player {

    private String name;
    private String playerRollSumString;

    private static Player ref1;
    private static Player ref2;

    private int playerRollSum;
    private int playerSumSoFar;
    private int lastRollSum;
    private boolean doubleSixBool = false;
    private boolean won = false;

    //Objekter
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DiceCup diceCup = new DiceCup(die1, die2);
    Message message = new Message(ref1, ref2);
    Scanner scan = new Scanner(System.in);

    //Construktor
    public Player(int aPlayerSumSofar , DiceCup diceCup){
        playerSumSoFar = aPlayerSumSofar;
    }

    //The main method of the game that help control the game flow.
    public void playerRoll(){
        //The method call the method diceCup.rollSum() to roll the dice after the player pushes the return key.
        //The values of each die is printed and the rest of the method is valuating this result.
        String key1 = scan.nextLine();
        diceCup.rollSum();
        System.out.println("Die 1 rolls: " + diceCup.die1.getFaceValue());
        System.out.println("Die 2 rolls: " + diceCup.die2.getFaceValue());

        //If the value of each die is 1 then the player should loose all points but still get an extra turn.
        if (diceCup.die1.getFaceValue() == 1 && diceCup.die2.getFaceValue() == 1){
            playerSumSoFar = 0;
            playerGotTwoOfEqualValue();
        }
        else if (diceCup.die1.getFaceValue() != 1 && diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue()) {
            //else if the player rolls two dice of similar value - which is not one, then he should get an extra turn.
            playerRollSum = diceCup.getSum();
            playerSumSoFar = playerSumSoFar + playerRollSum;
            //If the player rolls two dice of equal value and is 6, then another method is called to valuate whether
            //the player rolled two dice with the value of 6 each, which would make him an instant winner.
            if (diceCup.die1.getFaceValue() == 6 && diceCup.die2.getFaceValue() == 6)
            playerWonBydoubleSix();

            else
            playerGotTwoOfEqualValue();
            //If the player doesn't roll two dice of equal value, the sum of the dice will be saved in the playerSumSoFar.
        } else{
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
        if (playerSumSoFar >= 40
        && (diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue())) {
            won = true;
            System.out.println("You win because you have 40 points and got a double!");
        }
    }
    //Valuates what to do if the player rolls two dice of equal value.
    public void playerGotTwoOfEqualValue(){
        if (diceCup.die1.getFaceValue() == 1 && 1 == diceCup.die2.getFaceValue()) {
            message.playerExtraTurnButLosePoints();
        }
        else if (diceCup.die1.getFaceValue() != 1 &&
                diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue());
        {
            if (playerSumSoFar < 40){
                message.playerHaveAnExtraTurn();
                playerRoll();
            }
            else{
                won = true;
                System.out.println("You win because you have 40 points and got a double!");
            }
        }
    }
    public boolean playerWonBydoubleSix(){
        if (diceCup.rollSum() == 12 && lastRollSum == 12){
            doubleSixBool = true;
            System.out.println("You win because you got a double, double six!!!");
        }
        else
            playerGotTwoOfEqualValue();
        return doubleSixBool;
    }
    public void decider(){
        System.out.println("To find out who begins");
        System.out.println("The youngest person will roll the dice:");
        die1.roll();
        System.out.println("The youngest person got " + die1.getFaceValue()+".");
        System.out.println("Then the oldest person:");
        die2.roll();
        System.out.println("The oldest person got " + die2.getFaceValue()+".");
        if (die1.getFaceValue() > die2.getFaceValue()) {
                System.out.println("The youngest person will enter their name first.");
        }else if (die1.getFaceValue() < die2.getFaceValue()) {
            System.out.println("The oldest person will enter their name first.");
            }
        else if (die1.getFaceValue() == die2.getFaceValue()){
            System.out.println("You got the same value, therefore the youngest person enters their name first");
        }
    }

    public String getName() {
        return name;
    }
    public boolean getWon(){
        return won;
    }
    public void setName(String name) {
        this.name = name;
    }
}
