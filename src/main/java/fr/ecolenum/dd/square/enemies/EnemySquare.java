package fr.ecolenum.dd.square.enemies;

import fr.ecolenum.dd.character.Character;
import fr.ecolenum.dd.character.Magician;
import fr.ecolenum.dd.character.Warrior;
import fr.ecolenum.dd.character.equipment.OffensiveEquipment;
import fr.ecolenum.dd.engine.CharacterDeadException;
import fr.ecolenum.dd.menu.InteractionMenu;
import fr.ecolenum.dd.square.EmptySquare;
import fr.ecolenum.dd.square.Square;

abstract public class EnemySquare extends Square {
    protected String type;
    protected int hp;
    protected int attack_power;
    protected boolean defeated;

    public void interaction(Character player) throws CharacterDeadException {
    }

//    protected void fight(Character player) throws CharacterDeadException {
//        int player_power = getPlayerPower(player);
//        int player_hp = player.getHp();
//        System.out.println("You attack the "+ type +" with a strength of: " + player_power);
//
//        while (this.hp > 0 && player_hp > 0) {
//            this.hp -= player_power;
//            if (this.hp <= 0) {
//                System.out.println( type +" is dead, good job!\n");
//                this.defeated = true;
//            } else {
//                System.out.println("The "+ type +" counterattacks with a strength of: " + this.attack_power);
//                player_hp -= this.attack_power;
//                if (player_hp <= 0) {
//                    throw new CharacterDeadException("You have been defeated !!\n");
//                }
//            }
//        }
//
//        System.out.println("Player health points: " + player_hp);
//    }

    protected void fight(Character player) throws CharacterDeadException {
        int player_power = getPlayerPower(player);
        int player_hp = player.getHp();
        InteractionMenu menu = new InteractionMenu();
        player_hp =  fight_logic(player_power, player_hp);
        while (this.hp > 0 && player_hp > 0) {
            if (menu.interaction_fight()) {
                player_hp = fight_logic(player_power, player_hp);
                player.setHp(player_hp);
            } else {
                System.out.println("You chose to flee. You move back ");
                player.setIs_flee(true);
                break;
            }
        }
    }

    private int fight_logic(int player_power, int player_hp) throws CharacterDeadException {
        System.out.println("You attack the "+ type +" with a strength of: " + player_power);
        this.hp -= player_power;
        if (this.hp <= 0) {
            System.out.println( type +" is dead, good job!\n");
            this.defeated = true;
        } else {
            System.out.println("The "+ type +" counterattacks with a strength of: " + this.attack_power+"\n");
            player_hp -= this.attack_power;
            if (player_hp <= 0) {
                throw new CharacterDeadException("You have been defeated !!\n");
            }
        }
        System.out.println("Player health points: " + player_hp);
        return player_hp;
    }

    protected int getPlayerPower(Character player) {
        int player_power = player.getAttack_strength();
        OffensiveEquipment player_offensive_equipment = getPlayerOffensiveEquipment(player);

        if (player_offensive_equipment != null) {
            player_power += player_offensive_equipment.getPower();
        }
        return player_power;
    }

    protected OffensiveEquipment getPlayerOffensiveEquipment(Character player) {
        if (player instanceof Warrior) {
            return ((Warrior) player).getWeapon();
        } else if (player instanceof Magician) {
            return ((Magician) player).getSpell();
        }
        return null;
    }

    public int getHp() {
        return hp;
    }

    public String toString() {
        return "EnemySquare{}";
    }
}
