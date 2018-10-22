package game;//import static com.sun.tools.doclint.Entity.or;

import gui_main.GUI;

public class Main {
    public static void main(String[] args) {

       // GUI gui = new GUI();

        GameEngine gameEngine = new GameEngine();
        gameEngine.playGame();

    }
}