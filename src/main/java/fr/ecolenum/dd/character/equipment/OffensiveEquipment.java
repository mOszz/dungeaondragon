package fr.ecolenum.dd.character.equipment;
/**
 * A class representing offensive equipment that characters can use in the game.
 */
public class OffensiveEquipment {
    private String name;
    private int power;

    /**
     * Constructor for creating offensive equipment with a specified name and power value.
     *
     * @param name  The name of the offensive equipment.
     * @param power The power value of the equipment.
     */
    public OffensiveEquipment(String name, int power) {
        this.name = name;
        this.power = power;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String toString() {
        return "name='" + name + '\'' +
                ", power=" + power;
    }
}
