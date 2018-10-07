import java.util.Scanner;

public class GameEngine {

    public GameEngine(){
    }

    public void playGame(){

        Scanner scan = new Scanner(System.in);

        Dice die1 = new Dice();
        Dice die2 = new Dice();

        DiceCup diceCup1 = new DiceCup(die1, die2);

        Player player1 = new Player("Nicolai", 0, diceCup1);
        Player player2 = new Player("Sofie", 0, diceCup1);

        Message message = new Message(player1, player2);

        message.startGame();

        //Get player 1 name

        //Get player 2 name

        //Start the main game
        do {

            message.player1sTurn();
            String key1 = scan.nextLine();
            player1.playerRoll();

            if (player1.won)
                break;
//commit
            message.player2sTurn();
            key1 = scan.nextLine();
            player2.playerRoll();

            if (player2.won)
                break;

        }
        //End the game when one of the players get 40.

        while(!player1.won || !player2.won);

        message.playerHasWon();

    }

}
