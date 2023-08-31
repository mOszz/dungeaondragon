package fr.ecolenum.dd.character.equipment;

/**
 * A class representing defensive equipment that characters can use in the game.
 */
public class DefensiveEquipment {
    private String name;
    private int protection;

    /**
     * Constructor for creating defensive equipment with a specified name and protection value.
     *
     * @param name       The name of the defensive equipment.
     * @param protection The protection value provided by the equipment.
     */
    public DefensiveEquipment(String name, int protection) {
        this.name = name;
        this.protection = protection;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return protection;
    }

    public void setPower(int protection) {
        this.protection = protection;
    }

    public String toString() {
        return "name='" + name + '\'' +
                ", protection=" + protection;
    }
}
