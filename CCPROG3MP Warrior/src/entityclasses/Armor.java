package entityclasses;

public class Armor {

	private String type;
	private int defense;
	private int speedPenalty;
	
	// constructor
		public Armor(String type) {
			
			this.type = type;
			
			if(type.equals("LIGHT")) {
				defense = 20;
				speedPenalty = -5;
			} else if (type.equals("MEDIUM")) {
				defense = 30;
				speedPenalty = -15;
			} else if (type.equals("HEAVY")) {
				defense = 40;
				speedPenalty = -25;
			}
		}

	// setter
		public void setArmor(String type) {
			this.type = type;
			
			if(type.equals("LIGHT")) {
				defense = 20;
				speedPenalty = -5;
			} else if (type.equals("MEDIUM")) {
				defense = 30;
				speedPenalty = -15;
			} else if (type.equals("HEAVY")) {
				defense = 40;
				speedPenalty = -25;
			} else {
				type = "N/A"; // reset to N/A if no valid armor is selected
				defense = 0;
				speedPenalty = 0;
			}
		}
			
	// getters
		public String getArmor() {
			return type;
		}
		
		public int getDefense() {
			return defense;
		}
		
		public int getSpeedPenalty() {
			return speedPenalty;
		}

}
