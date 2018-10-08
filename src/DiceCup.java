public class DiceCup {

    Dice die1, die2;

    private int sum;

    public DiceCup(Dice dice1, Dice dice2 ){
        die1 = dice1;
        die2 = dice2;
}

    public int rollSum(){
        return sum = die1.roll() + die2.roll();
    }

    public int getDie1() {
        return die1.getFaceValue();
    }

    public int getDie2() {
        return die2.getFaceValue();
    }

    public int getSum() {
        return sum;
    }
}
