public class Message {

    String startGameS;
    String playersTurnS;
    String playerHasWonS;
    String playerHaveAnExtraTurnString;
    String playerRollSumString;

    Player player1;
    Player player2;
    Player theVictor;

    public Message(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame(){

        startGameS = "Welcome to the game! Please enter the name of player 1.";
        System.out.println(startGameS);

    }

    public void player1sTurn(){

        playersTurnS = "Its " + player1.name + "'s turn! Pres enter to roll!";
        System.out.println(playersTurnS);
    }
    public void player2sTurn(){

        playersTurnS = "Its " + player2.name + "'s turn! Pres enter to roll!";
        System.out.println(playersTurnS);
    }
    public void playerRoll(){
       // playerRollSumString = name + " har slået " + playerRollSum + " Din score er nu " + playerSumSoFar;
        System.out.println(playerRollSumString);
    }
    public void playerHasWon(){
        if (player1.won)
            theVictor = player1;
        else
            theVictor = player2;

        playerHasWonS = "Tillykke " + theVictor.name + "! You are victorius!";
        System.out.println(playerHasWonS);
    }

    public void playerHaveAnExtraTurn(){

        playerHaveAnExtraTurnString = "You got two of equal number! Roll again!";

        System.out.println(playerHaveAnExtraTurnString);
    }

    public void playerHaveAnExtraTurnButLosePoints(){
        //Hvis du læser dette så HAHAHAHA for et navn!
        playerHaveAnExtraTurnString = "You got two 1's and lose all your point! "+ "\n" + "But you can Roll again!";

        System.out.println(playerHaveAnExtraTurnString);
    }
}
