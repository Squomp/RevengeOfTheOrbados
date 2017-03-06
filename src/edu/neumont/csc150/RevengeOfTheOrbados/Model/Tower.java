package edu.neumont.csc150.RevengeOfTheOrbados.Model;

public class Tower {

	private int health, price, dmg, upgradePrice, sellPrice, attackSpeed, xPos, yPos;

	/**
	 * new default instance of parent class Tower
	 */
	public Tower(){}

	/**
	 * @return the price of the tower
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the dmg of the tower
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
	 * @return the upgradePrice of the tower
	 */
	public int getUpgradePrice() {
		return upgradePrice;
	}

	/**
	 * @param upgradePrice the upgradePrice to set
	 */
	public void setUpgradePrice(int upgradePrice) {
		this.upgradePrice = upgradePrice;
	}

	/**
	 * @return the attackSpeed of the tower
	 */
	public int getAttackSpeed() {
		return attackSpeed;
	}

	/**
	 * @param attackSpeed the attackSpeed to set
	 */
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	/**
	 * @return the xPos of the tower
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos of the tower
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	/**
	 * Give string of basic values for a tower
	 * @return String 
	 */
	@Override
	public String toString(){
		return "damage: " + this.getDmg() + ", price: " + this.getPrice();
	}
	
	/**
	 * Check two towers for equality
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Tower)){
			return false;
		}
		else {
			Tower other = (Tower)obj;
			if(this.getPrice() == other.getPrice() && this.getDmg() == other.getDmg()){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
}
