package edu.neumont.csc150.RevengeOfTheOrbados.View;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import edu.neumont.csc150.RevengeOfTheOrbados.Controller.GameManager;

public class Display extends JPanel implements ActionListener, KeyListener, MouseListener {

	private GameManager game;
	private boolean pause = false;
	
	/**
	 * create new Display instance
	 */
	public Display(GameManager game){
		this.game = game;
	}
	
	@Override
	public void paint(Graphics g){
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == 80){ //p
			if (!pause) {
				try {
					Thread.currentThread().wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			else if(pause){
				Thread.currentThread().notify();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
