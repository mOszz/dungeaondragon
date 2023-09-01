package fr.ecolenum.dd.database;

import fr.ecolenum.dd.character.Character;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RequestTest {

    @Test
    public void testGetHeroes() {
        Request request = new Request();
        List<Character> heroes = request.getHeroes();

        Assert.assertNotNull("The list of heroes must not be zero.", heroes);
        Assert.assertFalse("The hero list must not be empty.", heroes.isEmpty());
        System.out.println("Test passed: Retrieving heroes from the database.");
    }
}
