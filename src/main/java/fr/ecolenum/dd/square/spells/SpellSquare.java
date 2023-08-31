package fr.ecolenum.dd.square.spells;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;
import fr.ecolenum.dd.square.Square;

import java.util.Random;

abstract public class SpellSquare extends Square {

    public SpellSquare() {}

    public void interaction(Character player) {
    }

    protected int random_spell_damage() {
        Random random = new Random();
        int minValue = 2;
        int maxValue = 7;
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    protected void assign_weapon(Magician player, String spell_name) {
        OffensiveEquipment square_weapon = new OffensiveEquipment(spell_name, random_spell_damage());

        if (player.getSpell() !=null) {
            OffensiveEquipment current_weapon = player.getSpell();
            if (square_weapon.getPower() > current_weapon.getPower()) {
                player.setSpell(square_weapon);
            } else {
                System.out.println("Spell less powerful than current spell\n");
            }
        } else {
            player.setSpell(square_weapon);
        }
    }

    public String toString() {
        return "Spell{}";
    }
}
