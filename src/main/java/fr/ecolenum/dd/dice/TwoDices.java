package fr.ecolenum.dd.dice;

public class TwoDices implements Dice{

    public int rolls() {
        int first_dice = (int) (Math.random() * 6) + 1;
        int second_dice = (int) (Math.random() * 6) + 1;
        return first_dice + second_dice;
    }
}
