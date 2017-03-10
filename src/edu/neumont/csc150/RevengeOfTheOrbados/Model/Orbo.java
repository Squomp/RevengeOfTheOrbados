package edu.neumont.csc150.RevengeOfTheOrbados.Model;

import java.awt.Color;

public class Orbo {

	private int level, speed, dmg, moneyPerKill, xPos, yPos, width = 70, height = 65;
	private Color color;
	
	/**
	 * 
	 * @param level must be 2, 4, or 6
	 * @param speed at which the orbo moves
	 * @param dmg the orbo does to main tower
	 * @param moneyPerKill how much money is awarded to player when the orbo is destroyed
	 */
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
		this.level = level;
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
	 * @return the xPos
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
	 * @return the yPos
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
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Give string of basic values for an orbo
	 * @return String 
	 */
	@Override
	public String toString(){
		return "level: " + this.getLevel() + ", damage: " + this.getDmg() + ", speed: " + this.getSpeed();
	}
	
	/**
	 * Check two orbados for equality
	 * @param obj
	 * @return boolean
	 */
	@Override
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
