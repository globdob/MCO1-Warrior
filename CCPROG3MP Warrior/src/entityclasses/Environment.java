package entityclasses;

public class Environment {

	private String type;
	private String desc;
	private String penaltyDesc;
	private int playerPenalty;
	private int opponentPenalty;
	
	// constructor
		public Environment(String type) {
			
			this.type = type;
			
			if (type.equals("N/A") || type == null){
				playerPenalty = 0;
				opponentPenalty = 0;
				desc = "N/A";
				penaltyDesc = "N/A";
			} else if (type.equals("ARENA")) {
				playerPenalty = 0;
				opponentPenalty = 0;
				desc = "A fair and open battleground with no special effects.";
				penaltyDesc = "NO PENALTIES";
			} else if (type.equals("SWAMP")) {
				playerPenalty = -1; // hp penalty every turn
				opponentPenalty = 1; // atk gain every turn
				desc = "A murky swamp that drains the player's health.";
				penaltyDesc = "-1 HP PER TURN FOR PLAYER | +1 ATK PER TURN FOR OPPONENT";
			} else if (type.equals("COLOSSEUM")) {
				playerPenalty = 1; // atk gain every turn
				opponentPenalty = -1; // def penalty every turn
				desc = "A grand colosseum that boosts the player's attack.";
				penaltyDesc = "+1 ATK PER TURN FOR PLAYER | -1 DEF PER TURN FOR OPPONENT";
			} else{
				playerPenalty = 0;
				opponentPenalty = 0;
				desc = "N/A";
				penaltyDesc = "N/A";
			}
		}
	
	// setter
		public void setEnvironment(String type) {
			this.type = type;
			
			if (type.equals("N/A")){
				playerPenalty = 0;
				opponentPenalty = 0;
				desc = "N/A";
				penaltyDesc = "N/A";
			} else if (type.equals("ARENA")) {
				playerPenalty = 0;
				opponentPenalty = 0;
				desc = "A fair and open battleground with no special effects.";
				penaltyDesc = "NO PENALTIES";
			} else if (type.equals("SWAMP")) {
				playerPenalty = -1; // hp penalty every turn
				opponentPenalty = 1; // atk gain every turn
				desc = "A murky swamp that drains the player's health.";
				penaltyDesc = "-1 HP PER TURN FOR PLAYER | +1 ATK PER TURN FOR OPPONENT";
			} else if (type.equals("COLOSSEUM")) {
				playerPenalty = 1; // atk gain every turn
				opponentPenalty = -1; // def penalty every turn
				desc = "A grand colosseum that boosts the player's attack.";
				penaltyDesc = "+1 ATK PER TURN FOR PLAYER | -1 DEF PER TURN FOR OPPONENT";
			} else{
				playerPenalty = 0;
				opponentPenalty = 0;
				desc = "N/A";
				penaltyDesc = "N/A";
			}
		}
		
	// getters
		public String getType() {
			return type;
		}
		
		public int getPlayerPenalty() {
			return playerPenalty;
		}
		
		public int getOpponentPenalty() {
			return opponentPenalty;
		}

		public String getDesc() {
			return desc;
		}

		public String getPenaltyDesc() {
			return penaltyDesc;
		}
		
	// actions
		/**
		 * Displays details about the current environment
		 * Takes in a boolean that determines if the long description should be displayed
		 * true displays type, description, and penalty description. false doesn't display the description
		 * @param boolean descboolean - determines if description should be displayed
		 */
		public void displayEnvironment(boolean descboolean) {
			System.out.printf("%-30s%-30s\n", "ENVIRONMENT", getType());
			if (descboolean == true) {
				System.out.printf("%-30s%-30s\n", "DESC: ", getDesc());
			}
			System.out.printf("%-30s%-30s\n", "PEN: ", getPenaltyDesc());
		}

		// will penalties be applied at the start of every turn or will it be a constant 
		/**
		 * this is based on main game loop kung pano aapply penalties
		 * 
		 * @param int attackWarrior
		 * @param int attackOpponent
		 */
		public void applyPenalties(int attackWarrior, int attackOpponent) {
			attackWarrior -= playerPenalty;
			attackOpponent -= opponentPenalty;
		}
}
