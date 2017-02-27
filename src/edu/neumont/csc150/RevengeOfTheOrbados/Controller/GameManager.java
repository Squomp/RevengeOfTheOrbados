package edu.neumont.csc150.RevengeOfTheOrbados.Controller;

import edu.neumont.csc150.RevengeOfTheOrbados.Model.Orbo;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.Tower;
import edu.neumont.csc150.RevengeOfTheOrbados.View.Display;

public class GameManager {
	private Display display;
	private boolean gameOver;
	
	/**
	 * creates default instance of GameManager
	 */
	public GameManager(){
		display = new Display(this);
	}
	
	/**
	 * starts building the game and runs the program
	 */
	public void run(){
		display.initComponents();
	}

	public void orboLoseHealth(){
		
	}
	
	public void towerLoseHealth(){
		
	}
	
	public void towerUpgrade(){
		
	}
	
	public Tower towerBuy(int whichTower){
		
		return null;
	}
	
	public void towerSell(Tower tower){
		
	}
	
	public void newGame(){
		
	}
	
	public Orbo wave(){
		Orbo o1 = new Orbo(1, 1, 50, 30);
		o1.setyPos(100);
		o1.setxPos(100);
		return o1;
	}
	
	public void gameOver(){
		
	}
	
}