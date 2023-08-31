package fr.ecolenum.dd.square.weapons;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;
import fr.ecolenum.dd.square.Square;

import java.util.Random;

public abstract class WeaponSquare extends Square {

    public WeaponSquare(){}

    public void interaction(Character player) {
    }

    protected int random_weapon_damage() {
        Random random = new Random();
        int minValue = 2;
        int maxValue = 4;
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    protected void assign_weapon(Warrior player, String weapon_name) {
        OffensiveEquipment square_weapon = new OffensiveEquipment(weapon_name, random_weapon_damage());

        if (player.getWeapon() !=null) {
            OffensiveEquipment current_weapon = player.getWeapon();
            if (square_weapon.getPower() > current_weapon.getPower()) {
                player.setWeapon(square_weapon);
            } else {
                System.out.println("Weapon less powerful than current weapon\n");
            }
        } else {
            player.setWeapon(square_weapon);
        }
    }

    public String toString() {
        return "Weapon{}";
    }
}
