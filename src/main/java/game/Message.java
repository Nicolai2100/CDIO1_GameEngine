package game;

public class Message {

    String startGameS;
    String playersTurnS;
    String playerHasWonS;
    String playerHaveAnExtraTurnString;
    String playerRollSumString;

    private Player player1, player2;
    private Player theVictor;

    public Message(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public String startGame(){
        startGameS = "Welcome to the game.Dice Game! \n" +
                "The game.Dice Game is a game between two persons. Each player takes turns throwing two dice in a dice cup.\n" +
                "The sum of the dice is added as points to the players total sum.\n"+
                "The one who gets 40 points and a roll with two dice of equal value wins!\n" +
                "Special rules: If a player rolls two dice with the value of 1, the player looses all points.\n" +
                "If a player roll two dice of equal value, he gets an extra turn.\n" +
                "If a player two times in a row rolls both dice with the value of 6, he wins.\n"+
                "\nTo decide who begins, the players must roll the dice, the youngest person rolls first, then"+
                "\nthe other person rolls. The person with the highest number enters their name first."+
                "\nIf the players get the same number, the youngest person enters their name first.\n";

        return startGameS;
    }

    public String startGame1 (){
        startGameS = "\nPlease enter the name of player 1.";
        return startGameS;
    }

    public String startGame2(){
        startGameS = "Please enter the name of player 2.";
        return startGameS;
    }

    public String player1sTurn(){
        playersTurnS = "It's " + player1.getName() + "'s turn! Press Enter to roll!";
        return playersTurnS;
    }

    public String player2sTurn(){
        playersTurnS = "It's " + player2.getName() + "'s turn! Press enter to roll!";
        return playersTurnS;
    }
    public String playerWon()
    {
        return "You win because you have 40 points and got a double!";
    }

    public String playerHasWon(){
        if (player1.getWon()){
            theVictor = player1;
        } else {
            theVictor = player2;
        }
        playerHasWonS = "Congratulations " + theVictor.getName() + "! You are victorious!";
        return playerHasWonS;
    }

    public String playerHaveAnExtraTurn(){
        playerHaveAnExtraTurnString = "You got two of equals! Roll again!";
        return playerHaveAnExtraTurnString;
    }

    public String playerExtraTurnButLosePoints(){
        playerHaveAnExtraTurnString = "You got two 1's and lose all your points!"+ "\n" + "But you can Roll again!";
        return playerHaveAnExtraTurnString;
    }
}