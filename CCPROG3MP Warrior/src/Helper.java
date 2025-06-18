/**
 * This file contains methods that help with the smooth execution and flow of the game
 *  ex. selecting weapon/armor/etc.
 */

import java.util.Scanner;
import entityclasses.*;

public class Helper {
    
    public static void pressEnterToContinue(Scanner scanner) {
        System.out.println("Press Enter to continue...");
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // discard any leftover input
        }
        scanner.nextLine(); // wait for user to press Enter
    }

    // Method to select a weapon
    public static int selectWeapon (Scanner scanner, Warrior warrior, Weapon weapon) {
        int choice, creationstat = 0;
        do {
            System.out.println("Weapon Selection:");
            System.out.println("[1] Dagger");
            System.out.println("L==> +20 ATK | 0 SPD PENALTY");
            System.out.println("[2] Sword");
            System.out.println("L==> +30 ATK | -10 SPD PENALTY");
            System.out.println("[3] Battle Axe");
            System.out.println("L==> +40 ATK | -20 SPD PENALTY");
            System.out.println("[0] Go back to main menu");
                    
            System.out.println("\nSelect a weapon: ");
            choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        weapon.setWeapon("DAGGER");
                        break;
                    case 2:
                        weapon.setWeapon("SWORD");
                        break;
                    case 3:
                        weapon.setWeapon("BATTLE AXE");
                        break;
                    case 0:
                        System.out.println("Exiting pre-game preparation...");
                        creationstat = -1; // exit pre-game preparation
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                    }
        } while (choice != 0 && choice != 1 && choice != 2 && choice != 3); // loop until weapon selection is complete
            
        if (choice != 0) { // if a weapon was selected
            System.out.println("You selected the " + weapon.getWeapon() + "!");
            warrior.equipWeapon(weapon);
            creationstat = 1;
        }	
        return creationstat; // return the status of weapon selection
    }

    // Method to select armor
    public static int selectArmor(Scanner scanner, Warrior warrior, Armor armor, Weapon weapon) {
        int choice, creationstat = 0;
        do {
            System.out.println("Armor Selection:");
            System.out.println("[1] Light Armor");
            System.out.println("L==> +20 DEF | -5 SPD PENALTY");
            System.out.println("[2] Medium Armor");
            System.out.println("L==> +30 DEF | -15 SPD PENALTY");
            System.out.println("[3] Heavy Armor");
            System.out.println("L==> +40 DEF | -25 SPD PENALTY");
            System.out.println("[0] Back to Weapon Selection");

            System.out.println("\nSelect an armor: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    armor.setArmor("LIGHT");
                    break;
                case 2:
                    armor.setArmor("MEDIUM");
                    break;
                case 3:
                    armor.setArmor("HEAVY");
                    break;
                case 0:
                    System.out.println("Going back to weapon selection...");
                    warrior.resetWeapon(); // revert weapon selection
                    creationstat = -1; // exit pre-game preparation
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0 && choice != 1 && choice != 2 && choice != 3); // loop until armor selection is complete
            
            if (choice != 0) { // if a weapon was selected
                System.out.println("You selected " + armor.getArmor() + " ARMOR!");
                warrior.equipArmor(armor); // equip the selected armor
                creationstat = 1;
            }
        return creationstat;
    }

    // Method to select an opponent
    public static int selectOpponent(Scanner scanner, Warrior warrior, Opponent opponent, Armor armor) {
        int choice, creationstat = 0;
        do {
                System.out.println("Opponent Selection:");
                System.out.println("[1] Thief");
                System.out.println("L==> 150 HP | 20 ATK | 20 DEF | 40 SPD");
                System.out.println("[2] Viking");
                System.out.println("L==> 250 HP | 30 ATK | 30 DEF | 30 SPD");
                System.out.println("[3] Minotaur");
                System.out.println("L==> 350 HP | 40 ATK | 40 DEF | 20 SPD");
                System.out.println("[0] Back to Armor Selection");

                System.out.println("\nSelect an opponent: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        opponent.setOpponent("THIEF");
                        break;
                    case 2:
                        opponent.setOpponent("VIKING")  ;
                        break;
                    case 3:
                        opponent.setOpponent("MINOTAUR");
                        break;
                    case 0:
                        System.out.println("Going back to armor selection...");
                        warrior.resetArmor(); // revert armor selection
                        creationstat = -1; // reset creation status to go back to armor selection
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                    }
            } while (choice != 0 && choice != 1 && choice != 2 && choice != 3); // loop until opponent selection is complete
                
            if (choice != 0) { // if an opponent was selected
                System.out.println("You selected the " + opponent.getOpponentType() + "!");
                creationstat = 1; // set creation status to opponent selection complete
            }
        return creationstat; // return the status of opponent selection
    }

    // Method to select an environment
    public static int selectEnvironment(Scanner scanner, Environment environment, Opponent opponent) {
        int choice, creationstat = 0;
        do {
            System.out.println("Environment Selection:");
            System.out.println("[1] Arena");
            System.out.println("L==> A fair and open battleground with no special effects.");
            System.out.println("L==> NO PENALTIES");
            System.out.println("[2] Swamp");
            System.out.println("L==> A murky swamp that drains the player's health.");
            System.out.println("L==> -1 HP PER TURN FOR PLAYER | +1 ATK PER TURN FOR OPPONENT");
            System.out.println("[3] Colosseum");
            System.out.println("L==> A grand colosseum that boosts the player's attack.");
            System.out.println("L==> +1 ATK PER TURN FOR PLAYER | -1 DEF PER TURN FOR OPPONENT");
            System.out.println("[0] Back to Opponent Selection");

            System.out.println("\nSelect an environment: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    environment.setEnvironment("ARENA");
                    break;
                case 2:
                    environment.setEnvironment("SWAMP");
                    break;
                case 3:
                    environment.setEnvironment("COLOSSEUM");
                    break;
                case 0:
                    System.out.println("Going back to opponent selection...");
                    opponent.revertOpponent(); // revert opponent selection
                    creationstat = -1; // reset creation status to go back to opponent selection
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                }
        } while (choice != 0 && choice != 1 && choice != 2 && choice != 3); // loop until environment selection is complete
            
        if (choice != 0) { // if an environment was selected
            System.out.println("You selected the " + environment.getType() + "!");
            creationstat = 1; // set creation status to environment selection complete
        }
        return creationstat; // return the status of environment selection
    }

    public static int selectConfirmation(Scanner scanner, Environment environment) {
        int choice, creationstat = 0;
        do {
            //// selections made are already displayed in the displayPrepStatus method
            System.out.println("Are you ready to start the game with the following selections?\n");
            System.out.println("[1] Yes, start the game");
            System.out.println("[0] No, go back to environment selection");

            System.out.println("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Starting the game...");
                    creationstat = 1; // set creation status to game start
                    break;
                case 0:
                    System.out.println("Going back to environment selection...");
                    environment.setEnvironment("N/A"); // revert environment selection
                    creationstat = -1; // reset creation status to go back to environment selection
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 1 && choice != 0); // loop until confirmation is complete

        return creationstat;
    }

}
