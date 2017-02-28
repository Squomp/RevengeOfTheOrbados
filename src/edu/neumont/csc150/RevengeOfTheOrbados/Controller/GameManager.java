package edu.neumont.csc150.RevengeOfTheOrbados.Controller;

import java.io.IOException;
import java.util.Random;

import edu.neumont.csc150.RevengeOfTheOrbados.Model.FastTower;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.HeavyTower;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.LightTower;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.Orbo;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.Tower;
import edu.neumont.csc150.RevengeOfTheOrbados.View.Display;

public class GameManager {

	private Display display;
	private boolean gameOver;
	private Random r = new Random();
	
	/**
	 * creates default instance of GameManager
	 * @throws IOException 
	 */
	public GameManager() throws IOException{
		display = new Display(this);
	}
	
	/**
	 * starts building the game and runs the program
	 */
	public void run(){
		display.initComponents();
	}

	/**
	 * method to take helath away from orbo when hit
	 * @param orbo
	 * @param dmgDone
	 */
	public void orboLoseHealth(Orbo orbo, int dmgDone){
		orbo.setLevel(orbo.getLevel() - dmgDone);
	}
	
	
	public void towerLoseHealth(Orbo orbo){
		//TO DO check where main tower is
		if(orbo.getxPos() > 1000 && orbo.getyPos() > 1000){
			
		}
	}
	
	/**
	 * increases the damage of selected tower
	 * @param tower
	 */
	public void towerUpgrade(Tower tower){
		if(tower instanceof LightTower){
			tower.setDmg(3);
		}
		else if(tower instanceof FastTower){
			tower.setDmg(2);
		}
		else if(tower instanceof HeavyTower){
			tower.setDmg(4);
		}
	}
	
	public Tower towerBuy(int whichTower){
		
		return null;
	}
	
	public void towerSell(Tower tower){
		
	}
	
	public void newGame(){
		
	}
	
	/**
	 * creates a new orbo enemy
	 * @param level
	 * @return the orbo
	 */
	public Orbo newOrbo(int level){
			Orbo o = new Orbo(level, 1, 5, 30);
			o.setxPos(25);
			o.setyPos(615);
			return o;
	}
	
	public void gameOver(){
		
	}
	
}