package entityclasses;

public class Opponent {
	
	private String type;
	private int hitPoints;
	private int attack;
	private int defense;
	private int speed;

	private int chargeCounter; // counter for charge action
	private boolean isCharged; // flag to check if warrior is charged
	private boolean ChargedLastTurn; // flag to check if warrior was charged last turn
	private boolean isDefending; // flag to check if warrior is defending
	
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

			this.chargeCounter = 0;
			this.isCharged = false;
			this.isDefending = false;
			this.ChargedLastTurn = false;
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
		
		public void setAttack(int attack) {
			this.attack = attack;
		}

		public void setDefense(int defense) {
			this.defense = defense;
		}
		
		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public void setHitPoints(int hitPoints) {
			this.hitPoints = hitPoints;
		}

		public void setChargeCounter(int chargeCounter) {
			this.chargeCounter = chargeCounter;
		}

		public void setCharged(boolean isCharged) {
			this.isCharged = isCharged;
		}

		public void setChargedLastTurn(boolean ChargedLastTurn) {
			this.ChargedLastTurn = ChargedLastTurn;
		}

		public void setDefending(boolean isDefending) {
			this.isDefending = isDefending;
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

		public int getChargeCounter() {
			return chargeCounter;
		}
		public boolean isCharged() {
			return isCharged;
		}
		public boolean isChargedLastTurn() {
			return ChargedLastTurn;
		}
		public boolean isDefending() {
			return isDefending;
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
		 * Takes damage and applies defense reduction
		 * @param int damage - damage to be taken
		 */
		public void takeDamage(int damage) {
			int damageTaken = damage - defense; // reduce damage by defense
			hitPoints -= damageTaken;
			System.out.println(damage + " DMG - " + defense + " DEF = " + damageTaken + " DMG TAKEN");
			System.out.printf("Opponent takes %d damage. Remaining HP: %d%n", damageTaken, hitPoints);
			if (hitPoints < 0) {
				hitPoints = 0; // prevent negative hit points
			}
		}

		/**
		 * Deflects warrior's attack and halves the damage to be taken
		 * @param int attack - attack stat to be deflected
		 */
		public void defend(int attack) {
			int halvedAttack = attack / 2;
			takeDamage(halvedAttack);
		}
		
		/**
		 * Triples the opponent's attack stat
		 * This action can only be performed if the opponent is charged.
		 * @param Warrior warrior - the warrior to be attacked
		 */
		public void charge(Warrior warrior) {
			int damage = this.attack * 3; // triple the attack
			warrior.takeDamage(damage);
		}
}
