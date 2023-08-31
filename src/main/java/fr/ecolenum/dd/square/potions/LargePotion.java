package fr.ecolenum.dd.square.potions;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.equipment.Potion;

public class LargePotion extends PotionSquare{
    public LargePotion() {
    }


    public void interaction(Character player) {
        System.out.println("You found large potion\n");
        player.addPotion(new Potion("Large potion", 5));
    }

    public String toString() {
        return "LargePotion{}";
    }
}
