package fr.ecolenum.dd.dice;

import org.junit.Assert;
import org.junit.Test;

public class LoadedDiceTest {
    @Test
    public void loadedDiceTest() {
        LoadedDice dice = new LoadedDice();
        int dice_result =dice.rolls();
        Assert.assertEquals("The loaded dice result must be 1 ", 2, dice_result);
        System.out.println("Test passed: loaded dice value is correct");
    }
}