package entityclasses;

public class Environment {

	private String type;
	private String desc;
	private String penaltyDesc;
	private int playerPenalty;
	private int opponentPenalty;
	
	// setter
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
	// get rid of(?)
		
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
		// display environment details
		public void displayEnvironment(int descboolean) {
			System.out.printf("%-30s%-30s\n", "ENVIRONMENT", getType());
			if (descboolean == 1) {
				System.out.printf("%-30s%-30s\n", "DESC: ", getDesc());
			}
			System.out.printf("%-30s%-30s\n", "PEN: ", getPenaltyDesc());
		}

		// will penalties be applied at the start of every turn or will it be a constant 
		public void applyPenalties(int attackWarrior, int attackOpponent) {
			attackWarrior -= playerPenalty;
			attackOpponent -= opponentPenalty;
		}
}
