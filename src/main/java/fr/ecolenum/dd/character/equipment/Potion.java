package fr.ecolenum.dd.character.equipment;

import fr.ecolenum.dd.character.Character;
/**
 * A class representing a healing potion that characters can use in the game.
 */
public class Potion {
    String type;
    int healed_stat;

    /**
     * Constructor for creating a healing potion with a specified type and healed stat value.
     *
     * @param type        The type of the healing potion.
     * @param healed_stat The amount by which the potion heals the character's health.
     */
    public Potion(String type, int healed_stat) {
        this.type = type;
        this.healed_stat = healed_stat;
    }

    /**
     * Heals the character using the potion.
     *
     * @param player The character to be healed.
     */
    public void heal_player(Character player) {
        if (player.getHp() < player.getMax_hp()) {
            int player_hp = player.getHp();
            player.setHp(player_hp + healed_stat);
            if (player.getHp() > player.getMax_hp()) {
                player.setHp(player.getMax_hp());
            }
        } else {
            System.out.println("You are full life");
        }
    }

    public int getHealed_stat() {
        return healed_stat;
    }

    public void setHealed_stat(int healed_stat) {
        this.healed_stat = healed_stat;
    }

    public String toString() {
        return "Potion{" +
                "type='" + type + '\'' +
                ", healed_stat=" + healed_stat +
                '}';
    }
}
