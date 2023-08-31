package fr.ecolenum.dd.engine;

import fr.ecolenum.dd.square.EmptySquare;
import fr.ecolenum.dd.square.Square;
import fr.ecolenum.dd.square.enemies.*;
import fr.ecolenum.dd.square.potions.LargePotion;
import fr.ecolenum.dd.square.potions.StandardPotion;
import fr.ecolenum.dd.square.spells.FireBallSpell;
import fr.ecolenum.dd.square.spells.LightningSpell;
import fr.ecolenum.dd.square.weapons.Mace;
import fr.ecolenum.dd.square.weapons.Sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class representing the game board for Donjon & Dragon game.
 */
public class Board {
    private List<Square> game_board;

    public Board() {
        this.game_board = initialize_game_board();
        //this.game_board = loaded_game_board();
    }

    private List<Square> initialize_game_board() {
        game_board = new ArrayList<>();
        for (int i = 0; i <64; i++) {
            if (i == 45 || i == 52 || i == 56 || i == 62) {
                game_board.add(new Dragon());
            } else if (i == 10 || i == 20 || i == 25 || i == 32 || i == 35 || i == 36 || i == 37 || i == 40 || i == 44 || i == 47) {
                game_board.add(new Witch());
            } else if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21 || i == 24 || i == 27 || i == 30) {
                game_board.add(new Goblin());
            } else if (i == 2 || i == 11 || i == 5 || i == 22 || i == 38) {
                game_board.add(new Mace());
            } else if (i == 19 || i == 26 || i == 42 || i == 53) {
                game_board.add(new Sword());
            } else if (i == 1 || i == 4 || i == 8 || i == 17 || i == 23) {
                game_board.add(new LightningSpell());
            } else if (i == 48 || i == 49) {
                game_board.add(new FireBallSpell());
            } else if (i == 7 || i == 13 || i == 31 || i == 33 || i == 39 || i == 43) {
                game_board.add(new StandardPotion());
            } else if (i == 28 || i == 41) {
                game_board.add(new LargePotion());
            } else {
                game_board.add(new EmptySquare());
            }
        }
        game_board.set(63, new SpiderBoss());
        //initialize_random_game_board(game_board);
        return game_board;
    }

    private List<Square> loaded_game_board() {
        game_board = new ArrayList<>();
        game_board.add(new Sword());
        game_board.add(new StandardPotion());
        game_board.add(new Goblin());
        game_board.add(new Goblin());
        game_board.add(new Goblin());
        game_board.add(new StandardPotion());
        game_board.add(new Goblin());
        game_board.add(new Witch());
        game_board.add(new Dragon());
        return game_board;
    }

    private void initialize_random_game_board(ArrayList<Square> list) {
        Collections.shuffle(list);
    }

    public int getLength() {
        return game_board.size();
    }

    public Square getIndex(int playerPosition) {
        return game_board.get(playerPosition);
    }

    public void check_enemy_dead(int player_pos) {
        Square currentSquare = game_board.get(player_pos);
        if (currentSquare instanceof EnemySquare) {
            if (((EnemySquare) currentSquare).getHp() <= 0) {
                game_board.set(player_pos, new EmptySquare());
            }
        }
    }
}
