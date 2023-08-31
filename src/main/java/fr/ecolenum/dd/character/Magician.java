package fr.ecolenum.dd.character;

import fr.ecolenum.dd.character.equipment.DefensiveEquipment;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;

public class Magician extends Character {
    private OffensiveEquipment spell;
    private DefensiveEquipment philtre;

    public Magician() {}

    public Magician(String name) {
        this.name = name;
        this.hp = 3;
        this.max_hp = 6;
        this.attack_strength = 6;
    }
    public Magician(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.attack_strength = power;
    }

    public DefensiveEquipment getPhiltre() {
        return philtre;
    }

    public void setPhiltre(DefensiveEquipment philtre) {
        this.philtre = philtre;
    }

    public OffensiveEquipment getSpell() {
        return spell;
    }

    public void setSpell(OffensiveEquipment spell) {
        this.spell = spell;
    }

    @Override
    public String toString() {
        return super.toString() + ", spell=" + spell + ", philtre='" + philtre;
    }
}
