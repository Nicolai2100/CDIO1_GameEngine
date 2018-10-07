public class DiceCup {
Dice die1 = new Dice();
Dice die2 = new Dice();
int sum;

public DiceCup(Dice dice1, Dice dice2 ){
    die1 = dice1;
    die2 = dice2;

}

    public boolean ens(){
    boolean ensTerninger = false;
    if (die1.faceValue == die2.faceValue)
        ensTerninger = true;
    return true;
    }

    public int rollSum(){
    die1.roll();
    die2.roll();
    sum = die1.faceValue + die2.faceValue;
    return sum;
    }
}
