package fr.ecolenum.dd.square.potions;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.square.Square;

abstract public class PotionSquare extends Square {

    public PotionSquare(){}

    public void interaction(Character player) {
        System.out.println("You found a potion");
    }

    public String toString() {
        return "PotionSquare{}";
    }
}
