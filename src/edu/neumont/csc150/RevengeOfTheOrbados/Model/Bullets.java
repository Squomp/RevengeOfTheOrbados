package edu.neumont.csc150.RevengeOfTheOrbados.Model;



public class Bullets {

	private int bulletX,bulletY,bulletXVelocity=5,bulletYVelocity=5;
	private boolean justFired = false;

	public Bullets() {
	}
	/**
	 * @return the bulletX
	 */
	public int getBulletX() {
		return bulletX;
	}

	/**
	 * @param bulletX the bulletX to set
	 */
	public void setBulletX(int bulletX) {
		this.bulletX = bulletX;
	}

	/**
	 * @return the bulletY
	 */
	public int getBulletY() {
		return bulletY;
	}

	/**
	 * @param bulletY the bulletY to set
	 */
	public void setBulletY(int bulletY) {
		this.bulletY = bulletY;
	}

	/**
	 * @return the bulletXVelocity
	 */
	public int getBulletXVelocity() {
		return bulletXVelocity;
	}


	/**
	 * @return the bulletYVelocity
	 */
	public int getBulletYVelocity() {
		return bulletYVelocity;
	}
	/**
	 * @return the justFired
	 */
	public boolean isJustFired() {
		return justFired;
	}
	/**
	 * @param justFired the justFired to set
	 */
	public void setJustFired(boolean justFired) {
		this.justFired = justFired;
	}

	
}
