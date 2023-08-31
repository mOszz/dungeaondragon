package fr.ecolenum.dd.square.enemies;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.engine.CharacterDeadException;

public class Dragon extends EnemySquare{
    public Dragon() {
        super();
        this.type = "Dragon";
        this.hp = 15;
        this.attack_power = 4;
    }
    public void interaction(Character player) throws CharacterDeadException {
        System.out.println("The terrible dragon is here !\nDragon health points : "+ this.hp+ "\n");
        fight(player);
    }

    public String toString() {
        return "Dragon{}";
    }
}
