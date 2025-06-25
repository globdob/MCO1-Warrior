package entityclasses;
/*
 * CCPROG3 - S13A
 * Name: Andrea Neli M. Bayos
 * 
 */



public class Warrior {
	
	private int hitPoints = 100;
	private int attack = 1;
	private int defense = 1;
	private int speed = 50;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	
	// constructor
		public Warrior() {
			this.equippedWeapon = null; // no weapon equipped by default
			this.equippedArmor = null; // no armor equipped by default
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
			hitPoints -= damage - (equippedArmor != null ? equippedArmor.getDefense() : 0);
			if (hitPoints < 0) {
				hitPoints = 0; // prevent negative hit points
			}
		}
		
		/**
		 * Defends against an attack.
		 * Damage is halved and reduced by the equipped armor's defense stat.
		 * @param int attack - the attack value to be defended against
		 */
		public void defend(int attack) {
			hitPoints -= attack/2;
		}
		
		/**
		 * Charges the warrior's attack stat and triples it
		 * @return int - the new attack value after charging
		 */
		public int charge() {
			return attack *= 3;
		}
	
}
