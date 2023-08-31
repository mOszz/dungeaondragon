package fr.ecolenum.dd.character;

import fr.ecolenum.dd.character.equipment.Potion;

import java.util.ArrayList;
/**
 * An abstract class representing a character in the game.
 */
public abstract class Character {
    protected String name;
    protected int hp;
    protected int max_hp;
    protected int attack_strength;
    protected ArrayList<Potion> potions;

    private boolean is_flee;
    /**
     * Constructor with default values.
     */
    public Character() {
        this.name = "default name";
        this.hp = 10;
        this.attack_strength = 3;
        this.potions = new ArrayList<>();
        this.is_flee = false;
    }
    /**
     * Constructor for a character with a specified name.
     *
     * @param name The name of the character.
     */
    public Character(String name) {
        this();
        this.name = name;
    }
    /**
     * Constructor for a character with specified attributes.
     *
     * @param name           The name of the character.
     * @param hp             The health points of the character.
     * @param attack_strength The attack strength of the character.
     */
    public Character(String name, int hp, int attack_strength) {
        this.name = name;
        this.hp = hp;
        this.attack_strength = attack_strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack_strength() {
        return attack_strength;
    }

    public void setAttack_strength(int attack_strength) {
        this.attack_strength = attack_strength;
    }

    /**
     * Adds a potion to the character's list of potions.
     */
    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public void addPotion(Potion potion) {
        this.potions.add(potion);
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public boolean isIs_flee() {
        return is_flee;
    }

    public void setIs_flee(boolean is_flee) {
        this.is_flee = is_flee;
    }

    public String toString() {
        return getClass().getSimpleName() +" name=" + name + ", health point=" + hp + ", attack strength=" + attack_strength;
    }
}
