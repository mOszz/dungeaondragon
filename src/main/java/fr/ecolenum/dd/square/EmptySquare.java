package fr.ecolenum.dd.square;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;

public class EmptySquare extends Square{

    public EmptySquare() {

    }

    public void interaction(Character player) {
        if (player instanceof Warrior) {
            System.out.println("Empty square !\n");
        } else if (player instanceof Magician) {
            System.out.println("Empty square !\n");
        }
    }

    public String toString() {
        return "EmptySquare{}";
    }
}
