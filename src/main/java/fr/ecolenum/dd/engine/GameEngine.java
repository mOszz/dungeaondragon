package fr.ecolenum.dd.engine;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.equipment.Potion;
import fr.ecolenum.dd.dice.Dice;
import fr.ecolenum.dd.dice.LoadedDice;
import fr.ecolenum.dd.dice.NormalDice;
import fr.ecolenum.dd.menu.Menu;
import fr.ecolenum.dd.square.*;
import fr.ecolenum.dd.square.enemies.EnemySquare;

import java.util.ArrayList;

/**
 * A class representing the game engine for the Donjon & Dragon game.
 */
public class GameEngine {
    private final Dice dice;
    private final Board game_board;
    private Character player;
    private int player_position;
    private GameStatus game_status;
    /**
     * Enum representing the different possible game statuses.
     */
    private enum GameStatus {
        IN_PROGRESS,
        PLAYER_DEAD,
        GAME_OVER
    }
    /**
     * Constructor for creating a game engine instance.
     */
    public GameEngine() {
        this.dice = new NormalDice();
        this.player_position = 0;
        this.game_board = new Board();
        this.game_status = GameStatus.IN_PROGRESS;
    }
    /**
     * Starts the main menu of the game.
     */
    public void start_menu() {
        Menu menu = new Menu();
        menu.start();
    }
    /**
     * Initiates the game loop and gameplay.
     */
    public void game() {
        //System.out.println(player);
        while (game_status == GameStatus.IN_PROGRESS) {
            try {
                play_a_round();
                if (player_position >= 64) {
                    player_position = 64;
                }
            } catch (CharacterOutOfBoardException | CharacterDeadException e) {
                System.out.println(e.getMessage());
                this.game_status = GameStatus.GAME_OVER;
            }
            start_new_game_menu();
        }
    }

    private void roll_dice() throws CharacterOutOfBoardException, CharacterDeadException {
        while (true) {
            System.out.println("1: Roll dice\n2: Display character\n3: Heal player\n4: Quit");
            int answer = new Menu().user_input_int();
            switch (answer) {
                case 1:
                    play_a_round();
                    break;
                case 2:
                    System.out.println(player);
                    break;
                case 3:
                    player_healing();
                    break;
                case 4:
                    System.out.println("Thank you for playing our game");
                    System.exit(0);
                default:
                    System.out.println("Select valid choice");
                    break;
            }
        }
    }

    private void player_healing() {
        ArrayList<Potion> player_potions = player.getPotions();
        if (!player_potions.isEmpty()) {
            Potion potion = player_potions.get(0);
            potion.heal_player(player);
            player_potions.remove(0);
            System.out.println("You used a potion and healed for " + potion.getHealed_stat() + " points.");
        } else {
            System.out.println("No more potions in inventory");
        }
    }

    private void play_a_round() throws CharacterOutOfBoardException, CharacterDeadException {
        System.out.println("-------------------------------------------");
        System.out.println("Starting a new turn\n");

        int roll_result = dice.rolls();
        System.out.println("You rolled: " + roll_result +"\n");

        move_player(roll_result);
        System.out.println("Current square: "+ player_position +"\n");
        game_interaction();
        while (player.isIs_flee()) {
            move_back(1);
            game_interaction();
        }

        System.out.println("End of turn\n");
        System.out.println("-------------------------------------------");
        roll_dice();
    }

    private void game_interaction() throws CharacterDeadException {
        Square currentSquare = game_board.getIndex(player_position -1);
        currentSquare.interaction(player);
        game_board.check_enemy_dead(player_position -1);
    }

    public void move_player(int steps) throws CharacterOutOfBoardException {
        player_position += steps;
        if (player_position > (game_board.getLength() - 1))  {
            throw new CharacterOutOfBoardException("Out of game board !");
        }
    }

    public void move_back(int steps) {
        player_position -= steps;
        if (player_position < 0) {
            player_position = 0;
        }
        player.setIs_flee(false);
    }


    private void start_new_game_menu() {
        System.out.println("1: Start new game\n2: Quit");
        int answer = new Menu().user_input_int();
        switch (answer) {
            case 1:
                game();
                break;
            case 2:
                System.out.println("Thank you for playing our game");
                System.exit(0);
            default:
                System.out.println("Select valid choice");
                break;
        }

    }

    private void reset_game() {
        this.game_status = GameStatus.IN_PROGRESS;
        this.player_position = 0;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }
}
