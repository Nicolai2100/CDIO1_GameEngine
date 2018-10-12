package game;

import game.Dice;

public class DiceCup {

    private int sum;
    private int faceValue1;
    private int faceValue2;
    Dice die1, die2;

    //Constructor
    public DiceCup(Dice dice1, Dice dice2){
        die1 = dice1;
        die2 = dice2;
    }

    //The method rolls two dice and returns their value as an integer.
    public int rollSum(){
        faceValue1 = die1.roll();
        faceValue2 = die2.roll();
        return sum = faceValue1 + faceValue2;
    }

    public int getFaceValueDie1() {
        return faceValue1;
    }

    public void setFaceValueDie1(int faceValue) {
        this.faceValue1 = faceValue;
    }

    public int getFaceValueDie2() {
        return faceValue2;
    }

    public void setFaceValueDie2(int faceValue) {
        this.faceValue2 = faceValue;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
