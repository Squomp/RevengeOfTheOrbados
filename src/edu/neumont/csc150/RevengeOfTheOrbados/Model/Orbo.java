package edu.neumont.csc150.RevengeOfTheOrbados.Model;

public class Orbo {

	private int level, speed, dmg, moneyPerKill;
	
	public Orbo(int level, int speed, int dmg, int moneyPerKill){
		this.setLevel(level);
		this.setSpeed(speed);
		this.setDmg(dmg);
		this.setMoneyPerKill(moneyPerKill);
	}

	/**
	 * @return the level of the orbo
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		if(level >= 1 && level <= 3){
			this.level = level;
		}
	}

	/**
	 * @return the speed of the orbo
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the dmg of the orbo
	 */
	public int getDmg() {
		return dmg;
	}

	/**
	 * @param dmg the dmg to set
	 */
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	/**
	 * @return the moneyPerKill of the orbo
	 */
	public int getMoneyPerKill() {
		return moneyPerKill;
	}

	/**
	 * @param moneyPerKill the moneyPerKill to set
	 */
	public void setMoneyPerKill(int moneyPerKill) {
		this.moneyPerKill = moneyPerKill;
	}
	
	/**
	 * Give string of basic values for an orbo
	 * @return String 
	 */
	public String toString(){
		return "level: " + this.getLevel() + ", damage: " + this.getDmg() + ", speed: " + this.getSpeed();
	}
	
	/**
	 * Check two orbados for equality
	 * @param obj
	 * @return boolean
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof Orbo)){
			return false;
		}
		else {
			Orbo other = (Orbo)obj;
			if(this.getLevel() == other.getLevel() && this.getSpeed() == other.getSpeed()){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
}
