import java.util.Scanner;

public class GameEngine {

    public GameEngine(){
    }

    public void playGame(){
        //Objects
        Scanner scan = new Scanner(System.in);
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        DiceCup diceCup1 = new DiceCup(die1, die2);
        Player player1 = new Player( 0, diceCup1);
        Player player2 = new Player( 0, diceCup1);
        Message message = new Message(player1, player2);

        message.startGame();

        //Get player 1 name
        player1.setName(scan.next());
        message.startGame2();
        //Get player 2 name
        player2.setName(scan.next());

        //Start the main game
        do {
            message.player1sTurn();
            player1.playerRoll();

            if (player1.getWon())
                break;

            message.player2sTurn();
            player2.playerRoll();

            if (player2.getWon())
                break;
        }
        //End the game when one of the players get 40 and get a double - or to double 6.
        while(!player1.getWon() || !player2.getWon());

        message.playerHasWon();
    }
}
