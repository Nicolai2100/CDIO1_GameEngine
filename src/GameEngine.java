import java.util.Scanner;

public class GameEngine {

    public GameEngine(){
    }
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
        // Hvem starter?

            System.out.println("To find out who begins");
            System.out.println("The youngest person will roll the dice:");
            die1.roll();
            System.out.println("The youngest person got " + die1.getFaceValue()+".");
            System.out.println("Then the oldest person:");
            die2.roll();
            System.out.println("The oldest person got " + die2.getFaceValue()+".");
            if (die1.getFaceValue() > die2.getFaceValue()) {
                System.out.println("The youngest person will enter their name first.");
            } else if (die1.getFaceValue() < die2.getFaceValue()) {
                System.out.println("The oldest person will enter their name first.");
            }
            else if (die1.getFaceValue() == die2.getFaceValue()){
                System.out.println("You got the same value, therefore the youngest person enters their name first.");
            }

        //Set player 1 name
        message.startGame1();
        player1.setName(scan.next());
        message.startGame2();

        //Set player 2 name
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

        //Give a message about who won the game
        message.playerHasWon();
    }
}
