package fr.ecolenum.dd.engine;

public class CharacterOutOfBoardException extends Exception {
    public CharacterOutOfBoardException(String message) {
        super(message);
    }
}