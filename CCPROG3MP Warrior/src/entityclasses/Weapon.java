package entityclasses;
public class Weapon {
	
	private String type;
	private int attack;
	private int speedPenalty;
	
	// setter
		public Weapon(String type) {
			
			this.type = type;
			
			if(type == "DAGGER") {
				attack = 20;
				speedPenalty = 0;
			} else if (type == "SWORD") {
				attack = 30;
				speedPenalty = -10;
			} else if (type == "BATTLE AXE") {
				attack = 40;
				speedPenalty = -20;
			} 	
		}

		public void setWeapon(String type) {
			this.type = type;
			
			if(type.equals("DAGGER")) {
				attack = 20;
				speedPenalty = 0;
			} else if (type.equals("SWORD")) {
				attack = 30;
				speedPenalty = -10;
			} else if (type.equals("BATTLE AXE")) {
				attack = 40;
				speedPenalty = -20;
			} else {
				type = "N/A"; // reset to N/A if no valid weapon is selected
				attack = 0;
				speedPenalty = 0;
			}
		}
		
	// getters
		
		// get rid of (?)
		public String getWeapon() {
			return type;
		}
		
		public int getAttack() {
			return attack;
		}
		
		public int getSpeedPenalty() {
			return speedPenalty;
		}
	
	// actions

}
