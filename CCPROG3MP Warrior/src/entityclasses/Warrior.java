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

		public String[] getStatsArray() {
			return new String[] {
				"HP: " + this.hitPoints,
				"ATK: " + (this.attack + (equippedWeapon != null ? equippedWeapon.getAttack() : 0)),
				"DEF: " + (this.defense + (equippedArmor != null ? equippedArmor.getDefense() : 0)),
				"SPD: " + (this.speed + (equippedWeapon != null ? equippedWeapon.getSpeedPenalty() : 0) + (equippedArmor != null ? equippedArmor.getSpeedPenalty() : 0))
			};
		}
		
	// actions
		public void equipWeapon(Weapon equippedWeapon) {
			this.equippedWeapon = equippedWeapon;
		}
		
		public void equipArmor(Armor equippedArmor) {
			this.equippedArmor = equippedArmor;
		}

		//////// baka lang kailangan
		public void resetWeapon() {
			this.equippedWeapon = null;
		}

		public void resetArmor() {
			this.equippedArmor = null;
		}
		
		public void attack(Opponent opponent) {
			int damage = this.attack + (equippedWeapon != null ? equippedWeapon.getAttack() : 0);
			opponent.takeDamage(damage);
		}

		public void takeDamage(int damage) {
			hitPoints -= damage - (equippedArmor != null ? equippedArmor.getDefense() : 0);
			if (hitPoints < 0) {
				hitPoints = 0; // prevent negative hit points
			}
		}
		
		public void defend(int attack) {
			hitPoints -= attack/2;
		}
		
		public int charge() {
			return attack *= 3;
		}
	
}
