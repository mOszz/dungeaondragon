package fr.ecolenum.dd.character;

import fr.ecolenum.dd.character.equipment.DefensiveEquipment;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;

public class Warrior extends Character {
    private OffensiveEquipment weapon;
    private DefensiveEquipment shield;
    public Warrior() {
        super();
        this.hp = 5;
        this.max_hp = 10;
        this.attack_strength = 6;
    }

    public Warrior(String name) {
        this();
        this.name = name;
    }
    public Warrior(String name, int hp, int attack_strength) {
        this();
        this.name = name;
        this.hp = hp;
        this.attack_strength = attack_strength;
    }

    public DefensiveEquipment getShield() {
        return shield;
    }

    public void setShield(DefensiveEquipment shield) {
        this.shield = shield;
    }

    public OffensiveEquipment getWeapon() {
        return weapon;
    }

    public void setWeapon(OffensiveEquipment weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() + ", weapon=" + weapon + ", shield='" + shield;
    }
}
