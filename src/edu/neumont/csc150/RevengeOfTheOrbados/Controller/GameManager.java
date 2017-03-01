package edu.neumont.csc150.RevengeOfTheOrbados.Controller;


import java.io.IOException;

import java.util.Random;


import edu.neumont.csc150.RevengeOfTheOrbados.Model.Orbo;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.Tower;
import edu.neumont.csc150.RevengeOfTheOrbados.View.Display;

public class GameManager {

	private Display display;
	private boolean gameOver;
	
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
	
	public Orbo newOrbo(){
		Orbo o = new Orbo(1, 1, 50, 30);
		Random r = new Random();
		int x = r.nextInt(-90);
		int y = r.nextInt(815);
		o.setxPos(x);
		o.setyPos(y);
		return o;
	}
	
	public void gameOver(){
		
	}
	
}