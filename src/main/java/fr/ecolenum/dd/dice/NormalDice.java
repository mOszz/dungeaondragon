package fr.ecolenum.dd.dice;

public class NormalDice implements Dice {

    public int rolls() {
        return (int) (Math.random() * 6) + 1;
    }
}
