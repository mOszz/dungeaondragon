package fr.ecolenum.dd.menu;

import java.util.Scanner;

public class InteractionMenu {

    public InteractionMenu() {}

    public boolean interaction_fight() {
        System.out.println("Fight or go back ?\n1: Fight\n2: Back");
        switch (user_input_int()) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                break;
        }
        return false;
    }

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
