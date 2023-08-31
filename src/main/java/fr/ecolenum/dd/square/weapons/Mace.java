package fr.ecolenum.dd.square.weapons;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;

public class Mace extends WeaponSquare{
    public Mace() {}

    public void interaction(Character player) {
        if (player instanceof Warrior) {
            System.out.println("You found a mace!\n");
            super.assign_weapon((Warrior) player, "Mace");
        } else if (player instanceof Magician) {
            System.out.println("Too heavy for you!\n");
        }
    }

    public String toString() {
        return "Mace{}";
    }
}