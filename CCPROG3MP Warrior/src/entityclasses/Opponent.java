package entityclasses;

public class Opponent {
	
	private String type;
	private int hitPoints;
	private int attack;
	private int defense;
	private int speed;
	
	// constructor
		public Opponent(String type) {
			
			this.type = type;
			
			if(type == "N/A"){
				hitPoints = 0;
				attack = 0;
				defense = 0;
				speed = 0;
			} else if(type == "THIEF") {
				hitPoints = 150;
				attack = 20;
				defense = 20;
				speed = 40;
			} else if (type == "VIKING") {
				hitPoints = 250;
				attack = 30;
				defense = 30;
				speed = 30;
			} else if (type == "MINOTAUR") {
				hitPoints = 350;
				attack = 40;
				defense = 40;
				speed = 20;
			} else{
				hitPoints = 0;
				attack = 0;
				defense = 0;
				speed = 0;
			}
		}

	// setter
		public void setOpponent(String type) {
			this.type = type;
			
			if(type.equals("N/A")){
				hitPoints = 0;
				attack = 0;
				defense = 0;
				speed = 0;
			} else if(type.equals("THIEF")) {
				hitPoints = 150;
				attack = 20;
				defense = 20;
				speed = 40;
			} else if (type.equals("VIKING")) {
				hitPoints = 250;
				attack = 30;
				defense = 30;
				speed = 30;
			} else if (type.equals("MINOTAUR")) {
				hitPoints = 350;
				attack = 40;
				defense = 40;
				speed = 20;
			} else{
				type = "N/A"; // reset to N/A if no valid opponent is selected
				hitPoints = 0;
				attack = 0;
				defense = 0;
				speed = 0;
			}
		}
		
	// getters
		public String getOpponentType() {
			return type;
		}
		
		public int getHitPoints() {
			return hitPoints;
		}
		
		public int getAttack() {
			return attack;
		}
		
		public int getDefense() {
			return defense;
		}
		 
		public int getSpeed() {
			return speed;
		}
		
		// returns a String array with the opponent's stats
		public String[] getStatsArray() { 
			return new String[] {
				"HP: " + this.hitPoints,
				"ATK: " + this.attack,
				"DEF: " + this.defense,
				"SPD: " + this.speed
			};
		}

	// actions
		/**
		 * Reverts opponent's stats to 0 and clears out its type to "N/A"
		 * @param void
		 */
		public void revertOpponent() {
			this.type = "N/A";
			this.hitPoints = 0;
			this.attack = 0;
			this.defense = 0;
			this.speed = 0;
		}

		/**
		 * Attacks the warrior and applies damage based on the opponent's attack stat
		 * @param Warrior warrior - target to be attacked
		 */
		public void attack(Warrior warrior) {
			warrior.takeDamage(this.attack);
		}
		
		/**
		 * Deflects warrior's attack and halves the damage to be taken
		 * @param int attack - attack stat to be deflected
		 */
		public void defend(int attack) {
			hitPoints -= attack/2;
		}
		
		/**
		 * Takes damage and applies defense reduction
		 * @param int damage - damage to be taken
		 */
		public void takeDamage(int damage) {
			hitPoints -= damage - defense;
			if (hitPoints < 0) {
				hitPoints = 0; // prevent negative hit points
			}
		}

		/**
		 * Charges the opponent's attack, tripling its attack stat
		 * @return int - new attack value after charging
		 */
		public int charge() {
			return attack *= 3;
		}
}
