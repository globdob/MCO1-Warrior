import entityclasses.*;

public class Display {

    public static void displayMenu() {
        System.out.println("=========================================================\n");
        System.out.println("Welcome to Warrior!");
        System.out.println("Menu:");
        System.out.println("[1] Start Game");
        System.out.println("[2] How to Play");
        System.out.println("[0] Exit Game");
        System.out.println("\n=========================================================\n");
    }
    
    public static void displayInstructions() {
        System.out.println("=========================================================\n");
        System.out.println("How to Play:");
        System.out.println("1. Create your character by selecting a weapon and armor.");
        System.out.println("2. Choose your opponent and the environment for the battle.");
        System.out.println("3. Engage in combat until one warrior is defeated.");
        System.out.println("4. Enjoy the game!");
        System.out.println("\n=========================================================\n");
    }

    public static void displayEquipped(Armor armor, Weapon weapon, Warrior warrior) {
        System.out.printf("WEAPON: %s\n", warrior.getWeaponName());
        System.out.printf("ARMOR: %s\n", warrior.getArmorName());
    }

    public static void displayPrepStatus(int creationstat, Warrior warrior, Weapon weapon, Armor armor, Opponent opponent, Environment environment) {
        System.out.println("=========================================================\n");
        System.out.println("Pre-Game Preparation:");
        System.out.println(creationstat >= 0 ? "[/] Weapon Selection" : "[X] Weapon Selection");
        System.out.println(creationstat >= 1 ? "[/] Armor Selection" : "[X] Armor Selection");
        System.out.println(creationstat >= 2 ? "[/] Select Opponent" : "[X] Select Opponent");
        System.out.println(creationstat >= 3 ? "[/] Select Environment" : "[X] Select Environment");
        System.out.println("\n=========================================================");
                // Get stats as arrays of strings (implement these methods in Warrior and Opponent)
        String[] warriorStats = warrior.getStatsArray();
        String[] opponentStats = opponent.getStatsArray();

        System.out.printf("%-30s%-30s%n", "WARRIOR", "OPPONENT : " + opponent.getOpponentType());
        for (int i = 0; i < 4; i++) {
            String wStat = i < warriorStats.length ? warriorStats[i] : "N/A";
            String oStat = i < opponentStats.length ? opponentStats[i] : "N/A";
            System.out.printf("%-30s%-30s%n", wStat, oStat);
        }
        displayEquipped(armor, weapon, warrior);
        System.out.println("=========================================================");
            // display environment and opponent
        environment.displayEnvironment(1);
        System.out.println("=========================================================");
    }

}
