package fr.ecolenum.dd.square.potions;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.equipment.Potion;

public class StandardPotion extends PotionSquare{
    public StandardPotion() {

    }

    public void interaction(Character player) {
        System.out.println("You found a standard potion\n");
        player.addPotion(new Potion("Standard potion", 2));
    }

    public String toString() {
        return "StandardPotion{}";
    }
}
