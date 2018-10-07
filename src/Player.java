public class Player {

    String name;
    String playerRollSumString;
    String playerLosePointsString;
    static Player ref1;
    static Player ref2;

    int playerRollSum;
    int playerSumSoFar;
    boolean won = false;
    //Objekter
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DiceCup diceCup = new DiceCup(die1, die2);
    Message message = new Message(ref1, ref2);

    public Player(String aName, int aPlayerSumSofar , DiceCup diceCup){

        name = aName;
        playerSumSoFar = aPlayerSumSofar;

    }

    public void playerRoll(){
            diceCup.rollSum();
        if (die1.getFaceValue() == 1 && die2.getFaceValue() == 1){
            playerLosePoints();
            playerLosePointsString = name + " rolled two 1's and have lost all points! Current score: "+ playerSumSoFar;
            System.out.println(playerLosePointsString);
        }

        if (die1.getFaceValue() != 1 && die1.getFaceValue() == die2.getFaceValue()) {
            playerGotTwoOfEqualValue();
        } else{
            playerRollSum = diceCup.sum;
            playerSumSoFar = playerSumSoFar + playerRollSum;

        playerRollSumString = name + " har slået " + playerRollSum + " Din score er nu " + playerSumSoFar + "\n";
            System.out.println(playerRollSumString);
        playerWon();
        }

    }

    public void playerWon(){

        if (playerSumSoFar == 40 || playerSumSoFar > 40){
            won = true;
        }
    }

    //to enere og spiller mister point
    public void playerLosePoints() {

        playerSumSoFar = 0;
        playerGotTwoOfEqualValue();
                    }

    public void playerGotTwoOfEqualValue(){
        if (die1.getFaceValue() == die2.getFaceValue());
        {
            message.playerHaveAnExtraTurn();
            playerRoll();
        }


    }
    /*Spilleren mister alle sine point hvis spilleren slår to 1'ere.
2. Spilleren får en ekstra tur hvis spilleren slår to ens.
3. Spilleren kan vinde spillet ved at slå to 6'ere, hvis spilleren også i forrige kast slog to 6'ere
uanset om det er på ekstrakast eller i forrige tur.
4. Spilleren skal slå to ens for at vinde spillet, efter at man har opnået 40 point.
Vi*/


}
