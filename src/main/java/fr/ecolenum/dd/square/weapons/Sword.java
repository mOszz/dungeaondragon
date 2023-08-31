package fr.ecolenum.dd.square.weapons;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;

import java.util.Random;

public class Sword extends WeaponSquare{
    public Sword() {}

    public void interaction(Character player) {
        if (player instanceof Warrior) {
            System.out.println("You found a Sword!\n");
            super.assign_weapon((Warrior) player, "Sword");
        } else if (player instanceof Magician) {
            System.out.println("Too heavy for you!\n");
        }
    }

    public String toString() {
        return "Sword{}";
    }
}
