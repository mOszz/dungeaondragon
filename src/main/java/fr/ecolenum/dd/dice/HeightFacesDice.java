package fr.ecolenum.dd.dice;

public class HeightFacesDice implements Dice{

    public int rolls() {
        return (int) (Math.random() * 8) + 1;
    }
}
