package edu.neumont.csc150.RevengeOfTheOrbados.Model;

public class HeavyTower extends Tower{

	private final int PRICE = 350, DMG = 3, UPGRADE_PRICE = 250, 
			ATTACK_SPEED = 1500,x=0,y=0;
	
	/**
	 * new default instance of level 1 HeavyTower
	 */
	public HeavyTower(){
		super.setPrice(PRICE);
		super.setDmg(DMG);
		super.setUpgradePrice(UPGRADE_PRICE);
		super.setAttackSpeed(ATTACK_SPEED);
	}
	
}
