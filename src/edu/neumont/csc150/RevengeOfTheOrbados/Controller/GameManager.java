package edu.neumont.csc150.RevengeOfTheOrbados.Controller;



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
	
	public void wave(){
	}
	
	public void gameOver(){
		
	}
	
}