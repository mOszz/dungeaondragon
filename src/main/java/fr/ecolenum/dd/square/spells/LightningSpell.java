package fr.ecolenum.dd.square.spells;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;

public class LightningSpell extends SpellSquare {
    public LightningSpell() {
    }

    public void interaction(Character player) {
        if (player instanceof Magician) {
            System.out.println("You found a lightning spell!\n");
            super.assign_weapon((Magician) player, "Lightning Spell");
        } else if (player instanceof Warrior) {
            System.out.println("You can't read. Shame\n");
        }
    }

    public String toString() {
        return "Lightning{}";
    }
}
