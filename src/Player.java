public class Player {

    String name;
    String playerRollSumString;
    int playerRollSum;
    int playerSumSoFar;
    boolean won = false;

    Dice die1 = new Dice();
    Dice die2 = new Dice();

    DiceCup diceCup = new DiceCup(die1, die2);

    public Player(String aName, int aPlayerSumSofar , DiceCup diceCup){

        name = aName;
        playerSumSoFar = aPlayerSumSofar;

    }

    public String playerRoll(){
            diceCup.rollSum();
            playerRollSum = diceCup.sum;
            playerSumSoFar = playerSumSoFar + playerRollSum;
        playerRollSumString = name + " har slået " + playerRollSum + " Din score er nu " + playerSumSoFar;

        playerWon();

        return playerRollSumString;
    }

    public void playerWon(){

        if (playerSumSoFar == 40 || playerSumSoFar > 40){
            won = true;

        }
    }


}
