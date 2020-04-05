import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;

	int currentState = MENU;
	Font titleFont;
	Timer frameDraw;

	public static BufferedImage background;

	Launcher launcher = new Launcher(300, 400, 100, 150);
	ObjectManager objectManager = new ObjectManager(launcher);

	Timer sproutSpawn;

	GamePanel() {
		titleFont = new Font("Font", Font.BOLD, 48);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

		try {
			background = ImageIO.read(this.getClass().getResourceAsStream("Background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.update();
		if (launcher.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(new Color(134, 209, 35));
		g.fillRect(0, 0, ShootTheBrusselSprout.WIDTH, ShootTheBrusselSprout.HEIGHT);

		g.setFont(titleFont);
		g.setColor(new Color(80, 46, 61));
		g.drawString("Shoot the ", 275, 200);
		g.drawString("Brussels Sprout", 200, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(new Color(120, 212, 222));
		g.drawImage(background, 0, 0, ShootTheBrusselSprout.WIDTH, ShootTheBrusselSprout.HEIGHT, null);
		objectManager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(new Color(222, 120, 120));
		g.fillRect(0, 0, ShootTheBrusselSprout.WIDTH, ShootTheBrusselSprout.HEIGHT);

		g.setFont(titleFont);
		g.setColor(new Color(80, 46, 61));
		g.drawString("You died.", 130, 400);

	}

	void startGame() {
		sproutSpawn = new Timer(4500, objectManager);
		sproutSpawn.start();

	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU) {
			drawMenuState(g);
		}

		else if (currentState == GAME) {
			drawGameState(g);
		}

		else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (currentState == END) {
					sproutSpawn.stop();
					launcher = new Launcher(300, 500, 50, 50);
					objectManager = new ObjectManager(launcher);

					currentState = MENU;
				}

				else {
					currentState++;

				}
				if (currentState == GAME) {
					startGame();
				}
			}
			

			if (currentState == GAME) {

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					objectManager.addBullet(launcher.getBullet());

				}
			}


		if (currentState == GAME) {

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				objectManager.addBullet(launcher.getBullet());

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (launcher.x >= 0) {

				launcher.left();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (launcher.x <= 700) {

				launcher.right();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
	}
}
