/**
 * This file contains methods that help with the smooth execution and flow of the game
 *  ex. selecting weapon/armor/etc.
 */

import java.util.Scanner;
import entityclasses.*;

public class Helper {

    /**
     * Prompts the user to press Enter to continue.
     * This method is used to pause the program and wait for user input before proceeding.
     * @param Scanner scanner - the Scanner object used to read user input
     */
    public static void pressEnterToContinue(Scanner scanner) {
        System.out.println("Press Enter to continue...");
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // discard any leftover input
        }
        scanner.nextLine(); // wait for user to press Enter
    }

    /**
     * Prompts the user to select a weapon for their warrior.
     * The user can choose from three types of weapons: Dagger, Sword, and Battle
     * @param Scanner scanner - Scanner object to read user input
     * @param Warrior warrior - the warrior for whom the weapon is being selected
     * @param Weapon weapon - the weapon object to be equipped
     * @return int - returns 1 if a weapon is selected, -1 if the user chooses to go back
     */
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

    /**
     * Prompts the user to select an armor for their warrior.
     * The user can choose from three types of armor: Light, Medium, and Heavy.
     * @param Scanner scanner - the Scanner object used to read user input
     * @param Warrior warrior - the warrior for whom the armor is being selected
     * @param Armor armor - the armor object to be equipped
     * @param Weapon weapon - the weapon currently equipped by the warrior
     * @return int - returns 1 if an armor is selected, -1 if the user chooses to go back
     */
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

    /**
     * Prompts the user to select an opponent for the warrior.
     * The user can choose from three types of opponents: Thief, Viking, and Minotaur.
     * @param Scanner scanner - the Scanner object used to read user input
     * @param Warrior warrior - the warrior for whom the opponent is being selected
     * @param Opponent opponent - the opponent object to be set
     * @param Armor armor - the armor currently equipped by the warrior
     * @return int - returns 1 if an opponent is selected, -1 if the user chooses to go back
     */
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

    /**
     * Prompts the user to select an environment for the battle.
     * The user can choose from three types of environments: Arena, Swamp, and Colosseum.
     * @param Scanner scanner - the Scanner object used to read user input
     * @param Environment environment - the environment object to be set
     * @param Opponent opponent - the opponent object to be set
     * @return int - returns 1 if an environment is selected, -1 if the user chooses to go back
     */
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

    /**
     * Prompts the user to confirm their selections before starting the game.
     * Displays the current selections and asks if the user is ready to start the game.
     * @param Scanner scanner - the Scanner object used to read user input
     * @param Environment environment - the environment object currently selected
     * @return int - returns 1 if the user is ready to start the game, -1 if the user chooses to go back
     */
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

    /**
     * Compares the speed of the warrior and opponent to determine who attacks first.
     * Returns 1 if the warrior attacks first, 2 if the opponent attacks first,
     * or randomly determines who attacks first if both have the same speed.
     * @param Warrior warrior - the warrior object
     * @param Opponent opponent - the opponent object
     */
    public static int compareSpeed(Warrior warrior, Opponent opponent) {
        int result;
        if (warrior.getSpeed() > opponent.getSpeed()) {
            result = 1; // warrior attacks first
        } else if (warrior.getSpeed() < opponent.getSpeed()) {
            result = 2; // opponent attacks first
        } else {
            result = (Math.random() < 0.5) ? 1 : 2; // randomly determine who attacks first
        }
        return result;
    }

    /**
     * Asks the user to choose an action for their warrior.
     * The user can choose to attack, defend, or charge.
     * * @param Scanner scanner - the Scanner object used to read user input
     * @return String - the action chosen by the user
     */
    public static String getPlayerAction(Scanner sc) {
        int input;
        String playerAction = "";
        do {
            System.out.println("Choose your action:");
            System.out.println("[1] Attack");
            System.out.println("[2] Defend");
            System.out.println("[3] Charge");
            System.out.print("Enter your action: ");
            
            input = sc.nextInt(); 
            switch (input) {
                case 1:
                    playerAction = "attack";
                    System.out.println("You chose to attack!");
                    break;
                case 2:
                    playerAction = "defend";
                    System.out.println("You chose to defend!");
                    break;
                case 3:
                    playerAction = "charge";
                    System.out.println("You chose to charge!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (input != 1 && input != 2 && input != 3); // loop until a valid action is chosen
        return playerAction; // return the chosen action
    }

    /**
     * Gets opponent's action.
     * The opponent can randomly choose to attack, defend, or charge.
     * @return String - the action chosen by the opponent
     */
    public static String getOpponentAction() {
        /*String[] actions = {"attack", "defend", "charge"};
        int randomIndex = (int) (Math.random() * actions.length);
        return actions[randomIndex]; */

        return "attack"; // for now, the opponent always attacks
    }

    /**
     * Handles the warrior's attack logic.
     * @param Warrior warrior - the warrior attacking the opponent
     * @param Opponent opponent - the opponent being attacked
     */
    public static void WarriorAttack(Warrior warrior, Opponent opponent) {
            if (opponent.isDefending()) { // check if opponent is defending
                System.out.println("Opponent is defending. Attack will be halved.");
                opponent.setDefending(false); // reset opponent defending state
                opponent.defend(warrior.getAttack() + (warrior.getEquippedWeapon() != null ? warrior.getEquippedWeapon().getAttack() : 0)); // attack with halved damage
            } else if (warrior.isCharged()) { // check if warrior is charged
                System.out.println("You are charged. Your attack is tripled!");
                warrior.setChargeCounter(3);
                warrior.setCharged(false);
                warrior.charge(opponent);
            } else{
                System.out.println("You attack the opponent!");
                warrior.attack(opponent);
            }
    }

    /**
     * Handles the opponent's attack logic.
     * @param Warrior warrior - the warrior being attacked
     * @param Opponent opponent - the opponent attacking the warrior
     */
    public static void OpponentAttack(Warrior warrior, Opponent opponent) {
        if (warrior.isDefending()) {
            System.out.println("You are defending. Attack will be halved.");
            warrior.setDefending(false); // reset warrior defending state
            warrior.defend(opponent.getAttack());
        } else if (opponent.isCharged()) { // check if opponent is charged
            System.out.println("Opponent is charged! Opponent's attack will be tripled.");
            opponent.setChargeCounter(3);
            opponent.setCharged(false);
            opponent.charge(warrior);
        } else{
            System.out.println("Opponent attacks you!");
            opponent.attack(warrior);
        }
    }

}
