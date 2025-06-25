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
        int turn, currEnvPlayerPenalty, currEnvOppPenalty;

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
                System.out.println("Preparing Instructions...");
                break;
            case 0:
                System.out.println("Exiting game...");
                return; // exit the program
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
        if (menuchoice == 2) { ////////////////// instructions
            Display.displayInstructions();
            Helper.pressEnterToContinue(sc);

        } else if (menuchoice == 1) { /////////////////////// game start
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
                System.out.println("Game Start!");
                
                //warrior vs opponent start screen
                //// check speed to determine whose first (turn 1 or 2)
                //press enter to continue function in helper
                
                // start the game loop
                do {    
                    //// add to currEnvPenalty yung environment penalty
                    // basic player / opp data (name, hp) / environment effects
                    // text art??

                    // actions: attack, defend, charge
                    // turn switch from 1 to 2 ; 2 to 1
                    break;
                } while (true); // while turn != 0
            } 

        }

        System.out.println("=========================================================\n");

    // go back to menu if choice is not 0
    } while (menuchoice != 0); 
    System.out.println("Thank you for playing!");
        sc.close(); // close the scanner
    
    }
}
