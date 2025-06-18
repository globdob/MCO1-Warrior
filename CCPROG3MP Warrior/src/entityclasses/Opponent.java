package entityclasses;

public class Opponent {
	
	private String type;
	private int hitPoints;
	private int attack;
	private int defense;
	private int speed;
	
	// setter
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
		
	// getter
		
		// get rid of (?)
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
		
		public String[] getStatsArray() {
			return new String[] {
				"HP: " + this.hitPoints,
				"ATK: " + this.attack,
				"DEF: " + this.defense,
				"SPD: " + this.speed
			};
		}

	// actions
		public void revertOpponent() {
			type = "N/A";
			hitPoints = 0;
			attack = 0;
			defense = 0;
			speed = 0;
		}

		public void attack(Warrior warrior) {
			warrior.takeDamage(this.attack);
		}
		
		public void defend(int attack) {
			hitPoints -= attack/2;
		}
		
		public void takeDamage(int damage) {
			hitPoints -= damage - defense;
			if (hitPoints < 0) {
				hitPoints = 0; // prevent negative hit points
			}
		}

		public int charge() {
			return attack *= 3;
		}
}
