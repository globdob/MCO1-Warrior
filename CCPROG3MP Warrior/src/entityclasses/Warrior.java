package entityclasses;
/*
 * CCPROG3 - S13A
 * Name: Andrea Neli M. Bayos
 * 
 */



public class Warrior {
	
	private int hitPoints;
	private int attack;
	private int defense;
	private int speed;
	private Weapon equippedWeapon;
	private Armor equippedArmor;

	private int chargeCounter; // counter for charge action
	private boolean isCharged; // flag to check if warrior is charged
	private boolean chargedLastTurn; // flag to check if warrior was charged last turn
	private boolean isDefending; // flag to check if warrior is defending
	
	// constructor
		public Warrior() {
			this.hitPoints = 100; // default hit points
			this.attack = 1; // default attack
			this.defense = 1; // default defense
			this.speed = 50; // default speed
			this.equippedWeapon = null; // no weapon equipped by default
			this.equippedArmor = null; // no armor equipped by default
			this.chargeCounter = 0;
			this.isCharged = false;
			this.isDefending = false;
			this.chargedLastTurn = false;
		}

	// setters
		public void setHitPoints(int hitPoints) {
			this.hitPoints = hitPoints;
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

		public void setChargeCounter(int chargeCounter) {
			this.chargeCounter = chargeCounter;
		}

		public void setCharged(boolean isCharged) {
			this.isCharged = isCharged;
		}

		public void setChargedLastTurn(boolean chargedLastTurn) {
			this.chargedLastTurn = chargedLastTurn;
		}

		public void setDefending(boolean isDefending) {
			this.isDefending = isDefending;
		}

	// getters
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

		public Weapon getEquippedWeapon() {
			return equippedWeapon;
		}

		public Armor getEquippedArmor() {
			return equippedArmor;
		}

		public String getWeaponName() {
			return equippedWeapon != null ? equippedWeapon.getWeapon() : "N/A";
		}

		public String getArmorName() {
			return equippedArmor != null ? equippedArmor.getArmor() : "N/A";
		}

		public String[] getStatsArray() { // returns a String array with the warrior's stats
			return new String[] {
				"HP: " + this.hitPoints,
				"ATK: " + (this.attack + (equippedWeapon != null ? equippedWeapon.getAttack() : 0)),
				"DEF: " + (this.defense + (equippedArmor != null ? equippedArmor.getDefense() : 0)),
				"SPD: " + (this.speed + (equippedWeapon != null ? equippedWeapon.getSpeedPenalty() : 0) + (equippedArmor != null ? equippedArmor.getSpeedPenalty() : 0))
			};
		}

		public int getChargeCounter() {
			return chargeCounter;
		}
		public boolean isCharged() {
			return isCharged;
		}
		public boolean isChargedLastTurn() {
			return chargedLastTurn;
		}
		public boolean isDefending() {
			return isDefending;
		}
		
	// actions
		/**
		 * Equips a weapon to the warrior.
		 * If a weapon is already equipped, it will be replaced.
		 * @param Weapon equippedWeapon - the weapon to be equipped
		 */
		public void equipWeapon(Weapon equippedWeapon) {
			this.equippedWeapon = equippedWeapon;
		}
		
		/**
		 * Equips an armor to the warrior.
		 * If an armor is already equipped, it will be replaced.
		 * @param Armor equippedArmor - the armor to be equipped
		 */
		public void equipArmor(Armor equippedArmor) {
			this.equippedArmor = equippedArmor;
		}

		//////// baka lang kailangan - delete if not needed
		public void resetWeapon() {
			this.equippedWeapon = null;
		}

		public void resetArmor() {
			this.equippedArmor = null;
		}

		/**
		 * Resets the warrior's stats to default values.
		 * This is useful for starting a new game or resetting the warrior.
		 */
		public void resetStats() {
			this.hitPoints = 100; // default hit points
			this.attack = 1; // default attack
			this.defense = 1; // default defense
			this.speed = 50; // default speed
			this.equippedWeapon = null; // no weapon equipped by default
			this.equippedArmor = null; // no armor equipped by default
			this.chargeCounter = 0;
			this.isCharged = false;
			this.isDefending = false;
			this.chargedLastTurn = false;
		}
		///////////////

		/**
		 * Attacks the opponent and applies damage based on the warrior's attack stat
		 * Equipped weapon's attack is added to the warrior's attack stat.
		 * @param Opponent opponent - the opponent to be attacked
		 */
		public void attack(Opponent opponent) {
			int damage = this.attack + (equippedWeapon != null ? equippedWeapon.getAttack() : 0);
			opponent.takeDamage(damage);
		}

		/**
		 * Takes damage from an attack.
		 * Damage is reduced by the equipped armor's defense stat.
		 * Hit points cannot go below 0.
		 * @param int damage - the amount of damage taken
		 */
		public void takeDamage(int damage) {
			int damageTaken = damage - (defense + (equippedArmor != null ? equippedArmor.getDefense() : 0));
			if (damageTaken < 0) {
				damageTaken = 0; // no damage taken if defense is higher than damage
			}
			hitPoints -= damageTaken;
			if (hitPoints < 0) {
				hitPoints = 0; // prevent negative hit points
			}
			System.out.println("----------------------------------------------------------");
			System.out.println(damage + " DMG - " + (defense + (equippedArmor != null ? equippedArmor.getDefense() : 0)) + " DEF = " + damageTaken + " DMG TAKEN");
			System.out.printf("Warrior takes %d damage. Remaining HP: %d%n", damageTaken, hitPoints);
		System.out.println("----------------------------------------------------------");
		}
		
		/**
		 * Defends against an attack.
		 * Damage is taken halved and reduced by the equipped armor's defense stat.
		 * @param int attack - the attack value to be defended against
		 */
		public void defend(int attack) {
			int halvedAttack = attack / 2;
			System.out.println("DEFEND --- " + attack + " DMG => " + halvedAttack + " DMG (HALVED)");
			takeDamage(halvedAttack);
		}

		/**
		 * Triples the warrior's attack stat also considering its equipped weapon's attack.
		 * This action can only be performed if the warrior is charged.
		 * @param Opponent opponent - the opponent to be attacked
		 */
		public void charge(Opponent opponent) {
			int damage = (this.attack + (equippedWeapon != null ? equippedWeapon.getAttack() : 0)) * 3;
			System.out.println("CHARGE --- " + (this.attack + (equippedWeapon != null ? equippedWeapon.getAttack() : 0)) + " DMG => " + damage + " DMG (TRIPLED)");
			opponent.takeDamage(damage);
		}
	
}
