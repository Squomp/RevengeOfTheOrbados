package edu.neumont.csc150.RevengeOfTheOrbados.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import edu.neumont.csc150.RevengeOfTheOrbados.Controller.GameManager;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.Bullets;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.FastTower;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.HeavyTower;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.LightTower;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.Orbo;
import edu.neumont.csc150.RevengeOfTheOrbados.Model.Tower;

public class Display extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	private GameManager game;
	private boolean pause = false;
	private Timer orboMoveTimer, orboSpawnTimer, buyTimer, lightTowerShooting, heavyTowerShooting, fastTowerShooting;
	private BufferedImage lightTower, heavyTower, fastTower;
	private ArrayList<Orbo> orbados = new ArrayList<>();
	private ArrayList<Tower> towersPlaced = new ArrayList<>();
	private List<Bullets> bullet = new ArrayList<>();
	private Bullets bulletShooting = new Bullets();
	private boolean fastTowerBulletFired = false;
	private Random r = new Random();
	private boolean isLightTowerSelected, isFastTowerSelected, isHeavyTowerSelected, isHeavyTowerPlaced,
			isLightTowerPlaced, isFastTowerPlaced, isHeavyTowerClicked, isFastTowerClicked, inRange,
			isLightTowerClicked = false;
	private boolean isMouseInGame = false;
	private String isMouseInGameString = " ";
	private int towerHealth = 100;
	private int roundNumber = 0;
	private int money = 500;
	Tower selectedTower = null;

	Point xLocation = MouseInfo.getPointerInfo().getLocation();
	Point yLocation = MouseInfo.getPointerInfo().getLocation();

	private int height = 200, width = 200, x, y;
	private int mouseX, mouseY, mousePlacedX, mousePlacedY, mouseClickedX, mouseClickedY;

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JFrame window;

	private BufferedImage levelBackground;

	private int buyTimeCounter = 5;
	private int orboSpawnCounter = 0;

	private int numOfOrbados = 20;

	/**
	 * create new Display instance
	 * 
	 * @throws IOException
	 */
	public Display(GameManager game) throws IOException {
		this.game = game;
		levelBackground = ImageIO.read(new File("images/LevelBackground.png"));
		lightTower = ImageIO.read(new File("images/LightTowerIcon.png"));
		fastTower = ImageIO.read(new File("images/FastIcon.png"));
		heavyTower = ImageIO.read(new File("images/HeavyTowerIcon.png"));
		isMouseInGameString.equals(isMouseInGame);
	}

	/**
	 * create the start menu
	 * 
	 * @param window
	 */
	public void initializeStartMenu(JFrame window) {
		Object options[] = { "Start", "Exit" };
		int choice = JOptionPane.showOptionDialog(window, "Are you ready to start?", "Menu", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (choice == JOptionPane.CLOSED_OPTION || choice == 1) {
			System.exit(1);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	public void initComponents() {

		jPanel1 = this;
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();

		window = new JFrame();
		// initializeStartMenu(window);

		window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.addKeyListener(this);
		window.setTitle("Revenge of the Orbados");
		setBounds(new java.awt.Rectangle(0, 0, 2560, 1440));
		setPreferredSize(new java.awt.Dimension(1920, 1080));
		setSize(new java.awt.Dimension(2560, 1440));

		jButton1.addMouseListener(this);
		jButton2.addMouseListener(this);
		jButton3.addMouseListener(this);
		jButton4.addActionListener(this);

		jPanel1.addMouseListener(this);
		jPanel1.addMouseMotionListener(this);
		jPanel2.addMouseListener(this);
		jPanel2.addMouseMotionListener(this);

		jPanel1.setBackground(new java.awt.Color(0, 0, 204));
		jPanel1.addMouseMotionListener(this);
		jPanel2.addMouseMotionListener(this);
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

				.addGap(500, 2003, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

				.addGap(500, 1710, Short.MAX_VALUE));

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
		jLabel2.setText("Current Round: ");

		jButton1.setIcon(new javax.swing.ImageIcon("images\\FastTowerBTN.png")); // NOI18N

		jButton2.setIcon(new javax.swing.ImageIcon("images\\LightTowerBTN.png")); // NOI18N

		jButton3.setIcon(new javax.swing.ImageIcon("images\\HeavyTowerBTN.png")); // NOI18N

		jButton4.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
		jButton4.setText("Upgrade Tower");
		jButton4.setEnabled(false);

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
		jLabel3.setText("Money:");
		jLabel3.setToolTipText(" ");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(200, 200, 200)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(200, 200, 200))
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(42, 42, 42)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout.createSequentialGroup()
												.addComponent(jLabel2).addGap(133, 133, 133).addComponent(jLabel3))
										.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
								.addGap(125, 125, 125))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(25, 25, 25)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(25, 25, 25))));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(24, 24, 24)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jLabel3))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(25, 25, 25)
						.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25).addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25)));

		jLabel1.getAccessibleContext().setAccessibleName("roundProgressLBL");
		jLabel2.getAccessibleContext().setAccessibleName("currentRoundLBL");
		jButton1.getAccessibleContext().setAccessibleName("fastTowerBTN");
		jButton2.getAccessibleContext().setAccessibleName("lightTowerBTN");
		jButton3.getAccessibleContext().setAccessibleName("heavyTowerBTN");
		jButton4.getAccessibleContext().setAccessibleName("upgradeTowerBTN");
		jLabel3.getAccessibleContext().setAccessibleName("moneyLBL");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(window.getContentPane());
		window.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(15, 15, 15).addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(25, 25, 25)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(15, 15, 15)));

		jPanel1.getAccessibleContext().setAccessibleName("gamePanel");
		jPanel2.getAccessibleContext().setAccessibleName("menuPanel");

		window.getContentPane().add(jPanel1);
		window.pack();
		window.setVisible(true);

		this.buyTimer = new Timer(1000, this);
		this.orboSpawnTimer = new Timer(1000, this);
		this.orboMoveTimer = new Timer(1, this);
		this.fastTowerShooting = new Timer(300, this);
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public void GUImain() {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		long startPart = System.currentTimeMillis();
		// square width = 90 height = 74
		g.drawImage(levelBackground, (jPanel1.getX() + 5), (jPanel2.getY() + 3), 1800, 1258, this);

		for (Orbo orbo : orbados) {
			g.setColor(orbo.getColor());
			g.fillOval(orbo.getxPos(), orbo.getyPos(), orbo.getWidth(), orbo.getHeight());
		}
		String roundNumberString = Integer.toString(roundNumber);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		g.setColor(Color.YELLOW);
		g.drawString("Tower Health: " + towerHealth, jPanel1.getWidth() - 300, jPanel1.getHeight() - 100);
		g.drawString(isMouseInGameString, jPanel1.getWidth() - 350, jPanel1.getHeight() - 100);
		String buyTimeCounterString = Integer.toString(buyTimeCounter);
		g.drawString("Buy Time: " + buyTimeCounterString, jPanel1.getWidth() - 300, 1250);
		jLabel2.setText("Round Number: " + roundNumberString);
		jLabel3.setText("Money: " + money);

		if (orbados.isEmpty() && !this.orboSpawnTimer.isRunning() && !this.buyTimer.isRunning()) {
			startRound();
		}

		if (buyTimeCounter == 0) {
			orboSpawnTimer.start();
			this.buyTimer.stop();
			orboMoveTimer.start();
		}

		if (orboSpawnCounter == numOfOrbados) {
			orboSpawnCounter = 0;
			buyTimeCounter = 5;
			this.orboSpawnTimer.stop();
			numOfOrbados = numOfOrbados + 10;
			if (orboSpawnTimer.getDelay() > 300) {
				orboSpawnTimer.setDelay(orboSpawnTimer.getDelay() - 100);
			}
		}

		/*
		 * try { checkForLoss(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace();
		 */

		/*
		 * try { checkForLoss(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		if (isFastTowerSelected == true && isLightTowerSelected != true && isHeavyTowerSelected != true) {
			if (isMouseInGame == true) {
				g.drawImage(fastTower, (mouseX - (fastTower.getWidth() / 2)), (mouseY - (fastTower.getHeight() / 2)),
						this);
			}

		}

		if (isLightTowerSelected == true && isHeavyTowerSelected != true && isFastTowerSelected != true) {
			if (isMouseInGame == true) {
				g.drawImage(lightTower, (mouseX - (lightTower.getWidth() / 2)), (mouseY - (lightTower.getHeight() / 2)),
						this);
			}

		}
		if (isHeavyTowerSelected == true && isLightTowerSelected != true && isFastTowerSelected != true) {
			if (isMouseInGame == true) {
				g.drawImage(heavyTower, (mouseX - (heavyTower.getWidth() / 2)), (mouseY - (heavyTower.getHeight() / 2)),
						this);
			}

		}
		if (isHeavyTowerClicked == true) {
			isHeavyTowerPlaced = false;
			if (checkTowerPos() == true) {
				g.drawImage(heavyTower, (mouseClickedX - (heavyTower.getWidth() / 2)),
						(mouseClickedY - (heavyTower.getHeight() / 2)), this);
				mousePlacedX = (mouseClickedX - (heavyTower.getWidth() / 2));
				mousePlacedY = (mouseClickedY - (heavyTower.getHeight() / 2));
				isHeavyTowerPlaced = true;
			}
		}
		if (isHeavyTowerPlaced) {
			Tower ht = createHeavyTower(mousePlacedX, mousePlacedY);
			if (ht.getPrice() < money) {
				towersPlaced.add(ht);
				money = money - ht.getPrice();
				mousePlacedX = 0;
				mousePlacedX = 0;
			} else {
				isHeavyTowerSelected = false;
				isHeavyTowerClicked = false;
				isHeavyTowerPlaced = false;
			}

		}
		if (isLightTowerClicked == true) {
			isLightTowerPlaced = false;
			if (checkTowerPos() == true) {
				g.drawImage(lightTower, (mouseClickedX - (lightTower.getWidth() / 2)),
						(mouseClickedY - (lightTower.getHeight() / 2)), this);
				mousePlacedX = (mouseClickedX - (lightTower.getWidth() / 2));
				mousePlacedY = (mouseClickedY - (lightTower.getHeight() / 2));
				isLightTowerPlaced = true;
			}
		}
		if (isLightTowerPlaced) {
			Tower lt = createNewLightTower(mousePlacedX, mousePlacedY);
			if (lt.getPrice() < money) {
				towersPlaced.add(lt);
				money = money - lt.getPrice();
				mousePlacedX = 0;
				mousePlacedX = 0;
			} else {
				isLightTowerSelected = false;
				isLightTowerClicked = false;
				isLightTowerPlaced = false;
			}

		}
		if (isFastTowerClicked == true) {
			isFastTowerPlaced = false;
			if (checkTowerPos() == true) {
				g.drawImage(fastTower, (mouseClickedX - (fastTower.getWidth() / 2)),
						(mouseClickedY - (fastTower.getHeight() / 2)), this);
				mousePlacedX = (mouseClickedX - (fastTower.getWidth() / 2));
				mousePlacedY = (mouseClickedY - (fastTower.getHeight() / 2));
				isFastTowerPlaced = true;
			}

		}
		if (isFastTowerPlaced) {
			towersPlaced.add(createNewFastTower(mousePlacedX, mousePlacedY));
			isFastTowerPlaced = false;
			isFastTowerClicked = false;
			isFastTowerSelected = false;
			// if(checkTowerPos()){
			Tower ft = createNewFastTower(mousePlacedX, mousePlacedY);
			if (ft.getPrice() < money) {
				towersPlaced.add(ft);
				// }
				money = money - ft.getPrice();
				mousePlacedX = 0;
				mousePlacedX = 0;
			} else {
				isFastTowerSelected = false;
				isFastTowerClicked = false;
				isFastTowerPlaced = false;
			}
			mousePlacedX = 0;
			mousePlacedX = 0;

		}

		for (Tower tower : towersPlaced) {
			if (tower instanceof HeavyTower) {
				g.drawImage(heavyTower, tower.getxPos(), tower.getyPos(), this);
			}
			if (tower instanceof LightTower) {
				g.drawImage(lightTower, tower.getxPos(), tower.getyPos(), this);
			}
			if (tower instanceof FastTower) {
				g.drawImage(fastTower, tower.getxPos(), tower.getyPos(), this);
			}
			for(Orbo orbo : orbados){
				if (orbo.getxPos() <= (tower.getxPos()+(fastTower.getWidth()/2))+300&&
					orbo.getyPos() <= (tower.getyPos()+(fastTower.getHeight()/2))+300&&
					orbo.getxPos() >= (tower.getxPos()+(fastTower.getWidth()/2))-300 &&
					orbo.getyPos() >= (tower.getyPos()+(fastTower.getHeight()/2))-300)
					
				 {
					inRange = true;
					if (inRange == true) {
						fastTowerShooting.start();
						int xv = 0;

						for (Bullets bullet : bullet) {
							
							if(bullet.isJustFired() == true){
								bullet.setBulletX(tower.getxPos() + 40);
								bullet.setBulletY(tower.getyPos() + 40);
								bullet.setJustFired(false);
							}
							if(bullet.isJustFired() == false){
								bullet.setBulletX(bullet.getBulletX() + bullet.getBulletXVelocity());
								bullet.setBulletY(bullet.getBulletY() + bullet.getBulletYVelocity());
							}
							if (fastTowerBulletFired) {
								g.drawRect(bullet.getBulletX(), bullet.getBulletY(), 30, 30);
								g.fillRect(bullet.getBulletX(), bullet.getBulletY(), 30, 30);
								fastTowerBulletFired = false;
							}
								
								bullet.setBulletX(tower.getxPos() + fastTower.getWidth());
			                    bullet.setBulletY(tower.getyPos() + fastTower.getHeight());
								if(orbo.getxPos() < tower.getxPos()){
			                        xv = -5;
			                    }
			                    else if(orbo.getxPos() > tower.getxPos()){
			                        xv = 5;
			                    }
			                    else if(orbo.getxPos() == tower.getxPos()){
			                        xv = 0;
			                    }
			                    bullet.setBulletX(bullet.getBulletX() + xv);
			                    double m = (orbo.getyPos() - tower.getyPos())/(orbo.getxPos() - tower.getxPos());
			                    int yv = (int) (m * xv);
			                    bullet.setBulletY(bullet.getBulletX() + yv);
							// if(g.drawRect(tower.getxPos(), tower.getyPos(),
							// 30, 30);
						}
					}
				}
			}

		}
		long endPaint = System.currentTimeMillis();
		// System.out.println("Run of paint took " + (endPaint - startPart) + "
		// milliseconds");
		this.repaint();
	}

	/**
	 * method that checks if the Tower has lost all health and prompts user with
	 * endgame menu
	 * 
	 * @throws IOException
	 */
	public void checkForLoss() throws IOException {
		if (towerHealth == 0) {
			orbados.clear();
			this.orboSpawnTimer.stop();
			this.orboMoveTimer.stop();
			Object options[] = { "Play Again", "Exit" };
			int choice = JOptionPane.showOptionDialog(window, "Would you like to try again?", "Game Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (choice == JOptionPane.CLOSED_OPTION || choice == 1) {
				System.exit(1);
			} else if (choice == 0) {
				window.setVisible(false);
				GameManager newGame = new GameManager();
				newGame.run();
			}
		}
	}

	/**
	 * Starts the buyTimer
	 */
	public void startRound() {
		this.buyTimer.start();
		roundNumber++;
	}

	/**
	 * creates new place-able heavy tower
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private HeavyTower createHeavyTower(int x, int y) {
		HeavyTower HeavyTowerPlaced = new HeavyTower();
		HeavyTowerPlaced.setxPos(x);
		HeavyTowerPlaced.setyPos(y);
		return HeavyTowerPlaced;
	}

	/**
	 * creates new place-able light tower
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private LightTower createNewLightTower(int x, int y) {
		LightTower LightTowerPlaced = new LightTower();
		LightTowerPlaced.setxPos(x);
		LightTowerPlaced.setyPos(y);
		return LightTowerPlaced;
	}

	/**
	 * creates new place-able fast tower
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private FastTower createNewFastTower(int x, int y) {
		FastTower fastTowerPlaced = new FastTower();
		fastTowerPlaced.setxPos(x);
		fastTowerPlaced.setyPos(y);
		return fastTowerPlaced;
		// if(isFastTowerPlaced){
		// repaint();
		// }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jButton4)) {
			game.towerUpgrade(selectedTower);
			money = money - selectedTower.getUpgradePrice();
			jButton4.setEnabled(false);
			selectedTower = null;
		}
		if (e.getSource() == this.buyTimer) {
			buyTimeCounter--;
		}
		if (e.getSource() == this.orboSpawnTimer) {
			orboSpawnCounter++;
			orbados.add(game.newOrbo());
		}
		int orboSpeed = 3;
		if (e.getSource() == this.orboMoveTimer) {
			for (int i = 0; i < orbados.size(); i++) {
				if (orbados.get(i).getxPos() > 24 && orbados.get(i).getxPos() < 205 && orbados.get(i).getyPos() > 614
						&& orbados.get(i).getyPos() < 690) {
					orbados.get(i).setxPos(orbados.get(i).getxPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() >= 205 && orbados.get(i).getxPos() <= 215
						&& orbados.get(i).getyPos() > 102 && orbados.get(i).getyPos() < 690) {
					orbados.get(i).setyPos(orbados.get(i).getyPos() - orboSpeed);
				} else if (orbados.get(i).getxPos() >= 205 && orbados.get(i).getxPos() < 480
						&& orbados.get(i).getyPos() < 180) {
					orbados.get(i).setxPos(orbados.get(i).getxPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() >= 480 && orbados.get(i).getxPos() < 490
						&& orbados.get(i).getyPos() < 833) {
					orbados.get(i).setyPos(orbados.get(i).getyPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() > 120 && orbados.get(i).getxPos() < 490
						&& orbados.get(i).getyPos() < 840 && orbados.get(i).getyPos() > 830) {
					orbados.get(i).setxPos(orbados.get(i).getxPos() - orboSpeed);
				} else if (orbados.get(i).getxPos() > 95 && orbados.get(i).getxPos() < 205
						&& orbados.get(i).getyPos() < 1130) {
					orbados.get(i).setyPos(orbados.get(i).getyPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() < 745 && orbados.get(i).getyPos() > 1128) {
					orbados.get(i).setxPos(orbados.get(i).getxPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() >= 745 && orbados.get(i).getxPos() < 755
						&& orbados.get(i).getyPos() > 97) {
					orbados.get(i).setyPos(orbados.get(i).getyPos() - orboSpeed);
				} else if (orbados.get(i).getxPos() >= 745 && orbados.get(i).getxPos() < 1020) {
					orbados.get(i).setxPos(orbados.get(i).getxPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() > 1020 && orbados.get(i).getxPos() < 1030
						&& orbados.get(i).getyPos() < 1128) {
					orbados.get(i).setyPos(orbados.get(i).getyPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() > 1020 && orbados.get(i).getxPos() < 1285) {
					orbados.get(i).setxPos(orbados.get(i).getxPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() >= 1285 && orbados.get(i).getxPos() < 1290
						&& orbados.get(i).getyPos() > 100) {
					orbados.get(i).setyPos(orbados.get(i).getyPos() - orboSpeed);
				} else if (orbados.get(i).getxPos() >= 1285 && orbados.get(i).getxPos() <= 1555) {
					orbados.get(i).setxPos(orbados.get(i).getxPos() + orboSpeed);
				} else if (orbados.get(i).getxPos() >= 1555 && orbados.get(i).getyPos() < 1000) {
					orbados.get(i).setyPos(orbados.get(i).getyPos() + orboSpeed);
				}

				if (orbados.get(i).getxPos() >= 1555 && orbados.get(i).getyPos() < 990
						&& orbados.get(i).getyPos() > 980) {
					orbados.remove(i);
					towerHealth -= 5;
				}
			}
		}
		if (e.getSource().equals(fastTowerShooting)) {
			if (inRange = true) {
				bullet.add(bulletShooting);
			}
			fastTowerBulletFired = true;
			for (Bullets bullet : bullet) {
				bullet.setJustFired(true);
				bullet.setBulletX(bullet.getBulletX() + bullet.getBulletXVelocity());
				bullet.setBulletY(bullet.getBulletY() + bullet.getBulletYVelocity());
			}

		}
		this.repaint();
	}

	// change for push
	@Override
	public void mouseClicked(MouseEvent e) {
		for (Tower tower : towersPlaced) {
			if (e.getX() > tower.getxPos() && e.getX() < tower.getxPos() + lightTower.getWidth()
					&& e.getY() > tower.getyPos() && e.getY() < tower.getyPos() + lightTower.getHeight()) {
				selectedTower = tower;
				if (selectedTower.getPrice() < money) {
					jButton4.setEnabled(true);
				} else {
					jButton4.setEnabled(false);
					selectedTower = null;
				}
			} else {
				jButton4.setEnabled(false);
			}
		}

		if (e.getSource().equals(jButton4)) {
			game.towerUpgrade(selectedTower);
		}

		if (e.getSource().equals(jButton2)) {
			isLightTowerSelected = true;
		}
		if (e.getSource().equals(jButton1)) {
			isFastTowerSelected = true;
		}
		if (e.getSource().equals(jButton3)) {
			isHeavyTowerSelected = true;
		}

		if (e.getSource().equals(jButton1) && isLightTowerSelected == true) {
			isLightTowerSelected = false;
			isFastTowerSelected = true;
		}
		if (e.getSource().equals(jButton1) && isHeavyTowerSelected == true) {
			isHeavyTowerSelected = false;
			isFastTowerSelected = true;
		}

		if (e.getSource().equals(jButton2) && isHeavyTowerSelected == true) {
			isHeavyTowerSelected = false;
			isLightTowerSelected = true;
		}
		if (e.getSource().equals(jButton2) && isFastTowerSelected == true) {
			isFastTowerSelected = false;
			isLightTowerSelected = true;
		}

		if (e.getSource().equals(jButton3) && isFastTowerSelected == true) {
			isFastTowerSelected = false;
			isHeavyTowerSelected = true;
		}
		if (e.getSource().equals(jButton3) && isLightTowerSelected == true) {
			isLightTowerSelected = false;
			isHeavyTowerSelected = true;
		}

		if (e.getSource().equals(jPanel1) && isLightTowerSelected == true) {
			isLightTowerClicked = true;
			if (isLightTowerClicked && isFastTowerClicked || isLightTowerClicked && isHeavyTowerClicked) {
				isFastTowerClicked = false;
				isHeavyTowerClicked = false;
				mouseClickedX = e.getX();
				mouseClickedY = e.getY();
			} else {
				mouseClickedX = e.getX();
				mouseClickedY = e.getY();
			}
		}
		if (e.getSource().equals(jPanel1) && isFastTowerSelected == true) {
			isFastTowerClicked = true;
			if (isFastTowerClicked && isLightTowerClicked || isFastTowerClicked && isHeavyTowerClicked) {
				isHeavyTowerClicked = false;
				isLightTowerClicked = false;
				mouseClickedX = e.getX();
				mouseClickedY = e.getY();
			} else {
				mouseClickedX = e.getX();
				mouseClickedY = e.getY();
			}
		}
		if (e.getSource().equals(jPanel1) && isHeavyTowerSelected == true) {
			isHeavyTowerClicked = true;
			if (isHeavyTowerClicked && isFastTowerClicked || isHeavyTowerClicked && isLightTowerClicked) {
				isLightTowerClicked = false;
				isFastTowerClicked = false;
				mouseClickedX = e.getX();
				mouseClickedY = e.getY();
			} else {
				mouseClickedX = e.getX();
				mouseClickedY = e.getY();

			}
		}
		if (e.getSource().equals(jPanel1) && isFastTowerSelected == true) {
			isFastTowerPlaced = true;
			mouseX = e.getX();
			mouseY = e.getY();
		}
	}

	public boolean checkTowerPos() {
		boolean canSpawn = false;
		
		if (mouseClickedX >= 295 && mouseClickedY >= 162) {
			if (mouseClickedX <= 467 && mouseClickedY <= 840) {
				System.out.println(mouseClickedX + " " + mouseClickedY);
				canSpawn = true;
				System.out.println("1");
			}
		}
		if (mouseClickedX >= 550 && mouseClickedY >= 70) {
			System.out.println(mouseClickedX + " " + mouseClickedY);
			System.out.println("2");
			if (mouseClickedX <= 730 && mouseClickedY <= 890) {
				
				canSpawn = true;
				
			}
		}
		if (mouseClickedX >= 200 && mouseClickedY >= 900) {
			System.out.println(mouseClickedX + " " + mouseClickedY);
			System.out.println("3");
			if (mouseClickedX <= 780 && mouseClickedY <= 1130) {
				canSpawn = true;
			}
		}
		if (mouseClickedX >= 870 && mouseClickedY >= 180) {
			if (mouseClickedX <= 1010 && mouseClickedY <= 1310) {
				System.out.println(mouseClickedX + " " + mouseClickedY);
				canSpawn = true;
				System.out.println("4");
			}
		}
		if (mouseClickedX >= 1100 && mouseClickedY >= 90) {
			if (mouseClickedX <= 1240 && mouseClickedY <= 1310) {
				System.out.println(mouseClickedX + " " + mouseClickedY);
				canSpawn = true;
				System.out.println("5");
			}
		}
		if (mouseClickedX >= 1380 && mouseClickedY >= 0) {
			if (mouseClickedX <= 1450 && mouseClickedY <= 1480) {
				System.out.println(mouseClickedX + " " + mouseClickedY);
				canSpawn = true;
				System.out.println("6");
			}
		}
		if (mouseClickedX >= 1370 && mouseClickedY >= 140) {
			if (mouseClickedX <= 1580 && mouseClickedY <= 980) {
				System.out.println(mouseClickedX + " " + mouseClickedY);
				canSpawn = true;
				System.out.println("7");
			}
		}
		return canSpawn;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// if(lightTowerClicked){
		// x = arg0.getX() - (width / 2);
		// y = arg0.getY() - (height / 2);
		// this.repaint();
		// }
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(jPanel1)) {
			isMouseInGame = true;
			// repaint();

			this.repaint();

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == jPanel2) {
			isMouseInGame = false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// if(e.getX() > x && e.getX() < (x + width) && e.getY() > y && e.getY()
		// < (y + height)){
		// lightTowerClicked = true;
		// }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
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
		if (e.getKeyCode() == 80) { // p
			if (!pause) {
				try {
					Thread.currentThread().wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} else if (pause) {
				Thread.currentThread().notify();
			}
		}
	}

}