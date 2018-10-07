public class Message {

    String startGameS;
    String playersTurnS;
    String playerHasWonS;
    Player player1;
    Player player2;
    Player theVictor;

    public Message(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public String startGame(){

        startGameS = "Welcome to the game! Please enter the name of player 1.";

        return startGameS;
    }

    public String player1sTurn(){

        playersTurnS = "Its " + player1.name + "'s turn! Pres enter to roll!";

        return playersTurnS;
    }
    public String player2sTurn(){

        playersTurnS = "Its " + player2.name + "'s turn! Pres enter to roll!";

        return playersTurnS;
    }

    public String playerHasWon(){
        if (player1.won)
            theVictor = player1;
        else
            theVictor = player2;

        playerHasWonS = "Tillykke " + theVictor + "! You are victorius!";
        return playerHasWonS;
    }
}
