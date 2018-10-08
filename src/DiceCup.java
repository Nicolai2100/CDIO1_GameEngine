public class DiceCup {
Dice die1 = new Dice();
Dice die2 = new Dice();
int sum;

public DiceCup(Dice dice1, Dice dice2 ){
    die1 = dice1;
    die2 = dice2;

}
// Development
    public boolean ens(){
    boolean ensTerninger = false;
    if (die1.getFaceValue() == die2.getFaceValue())
        ensTerninger = true;
    return true;
    }
    // Test under Development

    public int rollSum(){
//    die1.setFaceValue();
  //  die2.setFaceValue(die2.roll());
    //sum = die1.getFaceValue() + die2.getFaceValue();
    return sum = die1.roll() + die2.roll();
    }

    public int getDie1() {
        return die1.getFaceValue();
    }

    public int getDie2() {
        return die2.getFaceValue();
    }
}
