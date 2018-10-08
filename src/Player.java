import java.util.Scanner;

public class Player {

    String name;
    String playerRollSumString;
    String playerLosePointsString;

    static Player ref1;
    static Player ref2;

    int playerRollSum;
    int playerSumSoFar;
    int lastRollSum;
    boolean doubleSixBool = false;
    boolean won = false;

    //Objekter
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DiceCup diceCup = new DiceCup(die1, die2);
    Message message = new Message(ref1, ref2);
    Scanner scan = new Scanner(System.in);

    public Player(String aName, int aPlayerSumSofar , DiceCup diceCup){

        name = aName;
        playerSumSoFar = aPlayerSumSofar;

    }

    public void playerRoll(){
        String key1 = scan.nextLine();
        diceCup.rollSum();
        System.out.println("Die 1 rolls: " + diceCup.die1.getFaceValue());
        System.out.println("Die 2 rolls: " + diceCup.die2.getFaceValue());

        if (diceCup.die1.getFaceValue() == 1 && diceCup.die2.getFaceValue() == 1){
            playerLosePoints();
            playerGotTwoOfEqualValue();
        }


        else if (diceCup.die1.getFaceValue() != 1 && diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue()) {

            playerRollSum = diceCup.sum;
            playerSumSoFar = playerSumSoFar + playerRollSum;

            if (diceCup.die1.getFaceValue() == 6 && diceCup.die2.getFaceValue() == 6)
            playerWonBydoubleSix();

            else
            playerGotTwoOfEqualValue();

        } else{
            playerRollSum = diceCup.sum;
            playerSumSoFar = playerSumSoFar + playerRollSum;
            lastRollSum = playerRollSum;

            playerRollSumString = name + "'s sum is " + playerRollSum + ". Current score: " + playerSumSoFar + "\n";
            System.out.println(playerRollSumString);
        playerWon();
        }
    }

    public void playerWon(){

        if (playerSumSoFar >= 40
        && (diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue())) {
            won = true;
            System.out.println("You win because you have 40 points and got a double!");
        }
    }
    //to enere og spiller mister point
    public void playerLosePoints() {
        playerSumSoFar = 0;
        }

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
            if (diceCup.rollSum() == 12 && lastRollSum == 12)
            {doubleSixBool = true;
                System.out.println("You win because you got a double, double six!!!");
            }
            else
            playerGotTwoOfEqualValue();

            return doubleSixBool;
    }
}
