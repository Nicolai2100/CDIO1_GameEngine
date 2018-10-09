import java.util.Scanner;

public class GameEngine {

    public GameEngine(){ }

    //The method from where the game runs.
    public void playGame(){

        //Objects are created
        Scanner scan = new Scanner(System.in);
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        DiceCup diceCup1 = new DiceCup(die1, die2);
        Player player1 = new Player( 0, diceCup1);
        Player player2 = new Player( 0, diceCup1);
        Message message = new Message(player1, player2);

        //Method that gives an introduction to the game. Rules, etc.
        message.startGame();

        //Method that decides who will start
        player1.decider();

        //Set player 1 name
        message.startGame1();
        player1.setName(scan.next());

        //Set player 2 name
        message.startGame2();
        player2.setName(scan.next());

        //Start the main game
        do {
            message.player1sTurn();
            player1.setKey1(scan.next());
            player1.playerRoll();

            if (player1.getWon()){
                break;
            }

            message.player2sTurn();
            player2.setKey1(scan.next());
            player2.playerRoll();

            if (player2.getWon()){
                break;
            }
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while(!player1.getWon() || !player2.getWon());

        //Give a message about who won the game
        message.playerHasWon();
    }
}