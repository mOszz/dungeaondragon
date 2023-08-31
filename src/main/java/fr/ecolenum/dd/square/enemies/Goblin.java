package fr.ecolenum.dd.square.enemies;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.engine.CharacterDeadException;

public class Goblin extends EnemySquare{
    public Goblin() {
        super();
        this.type = "Goblin";
        this.hp = 9;
        this.attack_power = 1;
    }
    public void interaction(Character player) throws CharacterDeadException {
        System.out.println("A goblin appear !\nGoblin health points : "+ this.hp+ "\n");
        fight(player);
    }

    public String toString() {
        return "Goblin{}";
    }
}
