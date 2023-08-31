package fr.ecolenum.dd.square;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.engine.CharacterDeadException;

public abstract class Square {
    private int id;

    public Square() {
    }

    public abstract void interaction(Character player) throws CharacterDeadException;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Square{" +
                "id=" + id +
                '}';
    }
}
