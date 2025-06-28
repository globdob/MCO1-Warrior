/**
 * This is the main program
 *
 **/

import java.util.Scanner;
import entityclasses.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int creationstat = 0; // variable to track character creation status
        int menuchoice; // variable to track menu choice

        // variables for game loop ===== modify if needed
        String playerAction = ""; 
        String opponentAction = "";
        int turn;

        Warrior warrior = new Warrior();
        Weapon weapon = new Weapon("N/A");            
        Armor armor = new Armor("N/A");
        Opponent opponent = new Opponent("N/A");
        Environment environment = new Environment("N/A");

    // menu
    do {
        Display.displayMenu();
        System.out.print("Enter your choice: ");
        menuchoice = sc.nextInt();
        
        switch (menuchoice) {
            case 1:
                System.out.println("Starting game...");
                break;
            case 2:
                System.out.println("Preparing Instructions..."); // display instructions
                System.out.println("=========================================================\n");
                Display.displayInstructions();
                Helper.pressEnterToContinue(sc);
                break;
            case 0:
                System.out.println("Exiting game...");
                return; // exit the program
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
       if (menuchoice == 1) { /////////////////////// game start
            // pregame character creation / selection
            creationstat = 0; // reset creation status
            do {
                Display.displayPrepStatus(creationstat, warrior, weapon, armor, opponent, environment); // display warrior stats

                switch(creationstat){
                    case 0: /////////// weapon selection
                        creationstat += Helper.selectWeapon(sc, warrior, weapon); // select weapon 
                        break;

                    case 1: //////// armor selection
                        creationstat += Helper.selectArmor(sc, warrior, armor, weapon); // select armor
                        break;

                    case 2: ///////// opponent selection
                        creationstat += Helper.selectOpponent(sc, warrior, opponent, armor); // select opponent
                        break;

                    case 3: ////////// environment selection
                        creationstat += Helper.selectEnvironment(sc, environment, opponent); // select environment
                        break;

                    case 4: ///////// confirmation
                        creationstat += Helper.selectConfirmation(sc, environment); // confirm selections
                        break;
                    }
            } while (creationstat != 5 && creationstat != -1); // loop until pregame creation / selection is complete

            // game loop proper
            if (creationstat == 5) {
                System.out.println("=========================================================\n");
                Display.displayAllStats(warrior, opponent); // display warrior and opponent stats
                environment.displayEnvironment(false); // display environment details
                System.out.println("\nGame Start!\n");
                Helper.pressEnterToContinue(sc);//press enter to continue function in helper
            
                System.out.println("=========================================================\n");
                // start the game loop
                do {    
                    environment.applyPenalties(warrior, opponent); // add environment penalties to warrior and opponent
                    System.out.println("=========================================================\n");
                    // basic player / opp data (name, hp) / environment effects
                    Display.displayAllStats(warrior, opponent);
                    environment.displayEnvironment(false); 
                    System.out.println("=========================================================\n");
                    
                    if (warrior.getHitPoints() <= 0 || opponent.getHitPoints() <= 0) { // check hp
                        turn = 0; // end the game loop
                    
                    } else{
                        // check charge counter for warrior and opponent
                        if (warrior.getChargeCounter() > 0) {
                            System.out.println(warrior.getChargeCounter() + " turns left for charge.");
                            warrior.setChargeCounter(warrior.getChargeCounter() - 1); // decrement charge counter
                        }
                        if (opponent.getChargeCounter() > 0) {
                            System.out.println(opponent.getChargeCounter() + " turns left for opponent charge.");
                            opponent.setChargeCounter(opponent.getChargeCounter() - 1); // decrement opponent charge counter
                        }

                        // check if warrior is charged and if they did not attack last turn
                        if (warrior.isCharged() && !playerAction.equals("attack") && !warrior.isChargedLastTurn()) {
                            System.out.println("You lost your charged status because you did not attack!");
                            warrior.setCharged(false);
                        } else if (warrior.isCharged()) {
                            System.out.println("You are charged. Next attack will be tripled.");
                            warrior.setChargedLastTurn(false); // reset charged last turn status
                        }

                        // check if opponent is charged and if they did not attack last turn
                        if (opponent.isCharged() && !opponentAction.equals("attack") && !opponent.isChargedLastTurn()) {
                            System.out.println("Opponent lost their charged status because they did not attack!");
                            opponent.setCharged(false);
                        } else if (opponent.isCharged()) {
                            System.out.println("Opponent is charged. Next attack will be tripled.");
                            opponent.setChargedLastTurn(false); // reset opponent charged last turn status
                        }

                        // save actions for player and opponent
                        playerAction = Helper.getPlayerAction(sc, warrior.isCharged()); // prompt player for action
                        opponentAction = Helper.getOpponentAction(); // determine opponent action

                        // player action : check defend and charge
                        switch (playerAction) {
                            case "defend":
                                warrior.setDefending(true); // set warrior to defending
                                System.out.println("You are defending this turn.");
                                break;
                            case "charge":
                                warrior.setCharged(true);
                                warrior.setChargedLastTurn(true); // set charged last turn status
                                System.out.println("You are charging this turn. Next attack will be tripled.");
                                break;
                        }

                        // opponent action : check defend and charge
                        switch (opponentAction) {
                            case "defend":
                                opponent.setDefending(true); // set opponent to defending
                                System.out.println("Opponent is defending this turn.");
                                break;
                            case "charge":
                                opponent.setCharged(true);
                                opponent.setChargedLastTurn(true); // set opponent charged last turn status
                                System.out.println("Opponent is charging this turn. Next attack will be tripled.");
                                break;
                        }

                        turn = Helper.compareSpeed(warrior, opponent); // turn = 1 if player goes first, 2 if opponent goes first
                        //// check speed to determine whose action will initiate first (turn 1 or 2)
                        
                        // attack actions
                        if (turn == 1) {
                            // player's turn
                            if (playerAction.equals("attack")){
                                Helper.WarriorAttack(warrior, opponent);
                            }

                            // opponent's turn
                            if (opponent.getHitPoints() > 0 && opponentAction.equals("attack")) { // check if opponent is defeated
                                Helper.OpponentAttack(warrior, opponent); // opponent attacks warrior
                            } else if (opponent.getHitPoints() <= 0){
                                turn = 0; // end the game loop if opponent is defeated
                            }
                            
                        } else if (turn == 2) {
                            // opponent's turn
                            if (opponentAction.equals("attack")){
                                Helper.OpponentAttack(warrior, opponent);
                            }

                            // player's turn
                            if (warrior.getHitPoints() > 0 && playerAction.equals("attack")) { // check if opponent is defeated
                                Helper.WarriorAttack(warrior, opponent); // warrior attacks opponent
                            } else if (warrior.getHitPoints() <= 0){
                                turn = 0; // end the game loop if opponent is defeated
                            }
                        }

                        warrior.setDefending(false); // reset warrior defending state
                        opponent.setDefending(false); // reset opponent defending state

                    } // end of turn actions

                } while (turn != 0);

                System.out.println(warrior.getHitPoints() <= 0 ? "GAME OVER: You have been defeated!" :
                             "CONGRATULATIONS: You have defeated your opponent!");
                // ask if player wants to continue playing or exit
                do 
                {
                    Display.displayGameOverMessage();
                    System.out.println("Enter your choice: ");
                    menuchoice = sc.nextInt();
                } while (menuchoice != 0 && menuchoice != 1); // loop until player chooses to exit or continue
                
            } // end of game start (creationstat == 5)

        } // end of game start (menuchoice == 1)

        System.out.println("=========================================================\n");

    // go back to menu if choice is not 0
    } while (menuchoice != 0); 
    System.out.println("Thank you for playing!");
        sc.close(); // close the scanner
    
    }
}
