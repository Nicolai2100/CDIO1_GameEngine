import java.util.Random;

public class Dice {

    private final int MAX = 6;
    public int faceValue;

    public Dice(){
        faceValue = 1;

    }

    public int roll(){

        faceValue = (int) (Math.random() * MAX + 1);

        return faceValue;
    }
}
