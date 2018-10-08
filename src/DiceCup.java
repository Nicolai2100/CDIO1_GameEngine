public class DiceCup {

    Dice die1, die2;
    private int sum;
    private int faceValue1;
    private int faceValue2;

    //Constructor
    public DiceCup(Dice dice1, Dice dice2 ){
        die1 = dice1;
        die2 = dice2;
    }
    //The method rolls two dice and returns their value as an integer.
    public int rollSum(){
        faceValue1 = die1.roll();
        faceValue2= die2.roll();
        return sum = faceValue1 + faceValue2;
    }

    public int getDie1() {
        return die1.getFaceValue();
    }

    public int getDie2() {
        return die2.getFaceValue();
    }
    public void setFaceValue1(int faceValue) {
        this.faceValue1 = faceValue;
    }
    public void setFaceValue2(int faceValue) {
        this.faceValue1 = faceValue;
    }


    public int getSum() { return sum; }
}
