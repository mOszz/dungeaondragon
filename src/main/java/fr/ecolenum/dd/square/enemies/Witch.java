package fr.ecolenum.dd.square.enemies;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.engine.CharacterDeadException;

public class Witch extends EnemySquare{
    public Witch() {
        super();
        this.type = "Witch";
        this.hp = 12;
        this.attack_power = 2;
    }

    public void interaction(Character player) throws CharacterDeadException {
        System.out.println("A witch come front of you !\nWitch health points : "+ this.hp+ "\n");
        fight(player);
    }

    public String toString() {
        return "Witch{}";
    }
}
