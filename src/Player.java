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
            playerLosePointsString = name + " rolled two 1's and have lost all points! Current score: "+ playerSumSoFar;
            System.out.println(playerLosePointsString);
        }

        if (diceCup.die1.getFaceValue() != 1 && diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue()) {

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

        if (playerSumSoFar == 40 || playerSumSoFar > 40 && diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue()) {
            won = true;
        }
    }

    //to enere og spiller mister point
    public void playerLosePoints() {

        playerSumSoFar = 0;
        playerGotTwoOfEqualValue();
                    }

    public void playerGotTwoOfEqualValue(){
        if (diceCup.die1.getFaceValue() == diceCup.die2.getFaceValue());
        {
            message.playerHaveAnExtraTurn();
            if (playerSumSoFar < 40)
            playerRoll();

            else
            won = true;
        }
    }

    public boolean playerWonBydoubleSix(){
            if (diceCup.rollSum() == 12 && lastRollSum == 12)
            doubleSixBool = true;
            return doubleSixBool;
    }




    /*Spilleren mister alle sine point hvis spilleren slår to 1'ere.
2. Spilleren får en ekstra tur hvis spilleren slår to ens.
3. Spilleren kan vinde spillet ved at slå to 6'ere, hvis spilleren også i forrige kast slog to 6'ere
uanset om det er på ekstrakast eller i forrige tur.
4. Spilleren skal slå to ens for at vinde spillet, efter at man har opnået 40 point.
Vi*/


}
