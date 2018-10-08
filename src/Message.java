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
        startGameS = "Welcome to the Dice Game! \n" +
                "The Dice Game is a game played with two persens. Each player takes turns in throwing two dices in a dice cup.\n" +
                "The sum of the dices is added as points to the players total sum.\n"+
                "The one who gets 40 points and a roll with two dices of equal value wins!\n" +
                "Special rules: If a player rolls two dices with the value of 1 each, the player looses all points.\n" +
                "If a player roll two dices of equal value, he gets an extra turn.\n" +
                "If a player two times in a row rolls dices with the value of 6, he wins.\n" +
                "\nTo decide who begins the youngest person will roll a dice first, then the other will roll.\n"+
                "The player with the highest number will enter their name first. If the numbers are the same, the youngest person, must enter first.\n";

        System.out.println(startGameS);
    }
    public void startGame1(){
        startGameS = "\nPlease enter the name of player 1.";
        System.out.println(startGameS);
    }

    public void startGame2(){
        startGameS = "Please enter the name of player 2.";
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

        playerHasWonS = "Congratulations " + theVictor.name + "! You are victorius!";
        System.out.println(playerHasWonS);
    }

    public void playerHaveAnExtraTurn(){

        playerHaveAnExtraTurnString = "You got two of equal number! Roll again!";

        System.out.println(playerHaveAnExtraTurnString);
    }

    public void playerExtraTurnButLosePoints(){
        //Hvis du læser dette så HAHAHAHA for et navn!
        playerHaveAnExtraTurnString = "You got two 1's and lose all your point! "+ "\n" + "But you can Roll again!";

        System.out.println(playerHaveAnExtraTurnString);
    }
}
