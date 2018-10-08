public class Dice {

    private final int MAX = 6;
    private int faceValue;

    public Dice(){
        faceValue = 1;
    }

    //The method generates an integer between 1 and 6.
    public int roll(){
        faceValue = (int) (Math.random() * MAX + 1);
        return faceValue;
    }

    public int getFaceValue() {return faceValue; }
    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }
}
