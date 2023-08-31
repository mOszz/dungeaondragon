package fr.ecolenum.dd.square.spells;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;

public class FireBallSpell extends SpellSquare {
    public FireBallSpell() {
    }

    public void interaction(Character player) {
        if (player instanceof Magician) {
            System.out.println("You found a fire ball spell!\n");
            super.assign_weapon((Magician) player, "FireBall Spell");
        } else if (player instanceof Warrior) {
            System.out.println("You can't read. Shame\n");
        }
    }

    public String toString() {
        return "Fire ball{}";
    }
}
