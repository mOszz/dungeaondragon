package fr.ecolenum.dd.square.enemies;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.engine.CharacterDeadException;

public class SpiderBoss extends EnemySquare{
    public SpiderBoss() {
        super();
        this.type = "Spider Boss";
        this.hp = 50;
        this.attack_power = 2;
    }
    public void interaction(Character player) throws CharacterDeadException {
        System.out.println("The Spider boss enter the square !!\n");
        fight(player);
    }

    public String toString() {
        return "Spider Boss{}";
    }
}
