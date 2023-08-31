package fr.ecolenum.dd.menu;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.database.Request;
import fr.ecolenum.dd.engine.GameEngine;

import java.util.List;
import java.util.Scanner;
/**
 * A class representing the game menu for Donjon & Dragon game.
 */
public class Menu {
    /**
     * Starts the game menu.
     */
    public void start() {
        character_choice();
    }

    private void start_game(Character character) {
        GameEngine game = new GameEngine();
        game.setPlayer(character);
        game.game();
    }

    public void character_choice() {

        Request conn = new Request();
        List<Character> heroes = conn.getHeroes();

        System.out.println("Select a character type for the game :\n1: Display characters\n2: Quit");
        int choice = this.user_input_int();
        switch (choice) {
            case 1:
                System.out.println("Select a character :");
                for (int i = 0; i < heroes.size(); i ++) {
                    System.out.println(i + " : " +heroes.get(i));
                }
                choice = this.user_input_int();
                character_sub_menu(heroes.get(choice));
                break;
            case 2:
                System.out.println("Thank you for playing our game");
                System.exit(0);
                //return;
            default:
                System.out.println("Select valid choice");
                break;
        }
    }

    private void character_sub_menu(Character character) {
        System.out.println(character);
        System.out.println("Choose an option:\n1: Start game\n2: Quit");
        int choose_option = this.user_input_int();
        switch (choose_option) {
            case 1:
                start_game(character);
                return;
            case 2:
                System.out.println("Thank you for playing our game");
                System.exit(0);
            default:
                System.out.println("Select valid choice");
                break;
        }
    }

    /*
    private void character_menu(int choice) {
        System.out.println("New character creation :");
        System.out.println("Name :");
        String name = user_input();
        switch (choice) {
            case 1:
                fr.ecolenum.dd.character.Character warrior = new Warrior(name);
                System.out.println("Character created:");
                while (true) {
                    if (character_sub_menu(warrior)) return;
                }
            case 2:
                fr.ecolenum.dd.character.Character magician = new Magician(name);
                System.out.println("Character created:");
                while (true) {
                    if (character_sub_menu(magician)) return;
                }
        }
    }

    private boolean character_sub_menu(fr.ecolenum.dd.character.Character character) {
        System.out.println("Choose an option:\n1: Display character infos\n2: Modify current character stats\n3: Start game\n4: Quit");
        int choose_option = this.user_input_int();
        switch (choose_option) {
            case 1:
                System.out.println(character.toString());
                break;
            case 2:
                character_update_menu(character);
                break;
            case 3:
                start_game(character);
                return true;
            case 4:
                System.out.println("Thank you for playing our game");
                System.exit(0);
            default:
                System.out.println("Select valid choice");
                break;
        }
        return false;
    }

    private void character_update_menu(fr.ecolenum.dd.character.Character character) {
        System.out.println("Character update menu :\nNew name :");
        String new_name = user_input();
        System.out.println("New health-point value :");
        int new_hp = user_input_int();
        System.out.println("New attack strength value :");
        int new_as = user_input_int();
        update_character(character, new_name, new_hp, new_as);
    }

    private static void update_character(fr.ecolenum.dd.character.Character character, String new_name, int new_hp, int new_as) {
        character.setName(new_name);
        character.setHp(new_hp);
        character.setAttack_strength(new_as);
    }
*/
    public int user_input_int() {
        while (true) {
            try {
                return Integer.parseInt(user_input());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer. :"+ e);
            }
        }
    }

    private String user_input() {
        Scanner user_input = new Scanner(System.in);
        return user_input.nextLine();
    }
}