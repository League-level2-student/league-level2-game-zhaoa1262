import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	int currentState = MENU;
	
	Font titleFont;
	
	Timer frameDraw;

	GamePanel() {
		titleFont = new Font("Font", Font.BOLD, 48);
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();

	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(new Color(134, 209, 35));
		g.fillRect(0, 0, ShootTheBrusselSprout.WIDTH, ShootTheBrusselSprout.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(new Color(80, 46, 61));
		g.drawString("Shoot the ", 125, 300);
		g.drawString("Brussels Sprout", 55, 500);
	}

	void drawGameState(Graphics g) {
		g.setColor(new Color(120, 212, 222));
		g.fillRect(0, 0, ShootTheBrusselSprout.WIDTH, ShootTheBrusselSprout.HEIGHT);
	}

	void drawEndState(Graphics g) {
		g.setColor(new Color(222, 120, 120));
		g.fillRect(0, 0, ShootTheBrusselSprout.WIDTH, ShootTheBrusselSprout.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(new Color(80, 46, 61));
		g.drawString("You died.", 130, 400);
		
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
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        
		    } 
		    else {
		        currentState++;
		    }
		}   		
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			   System.out.println("right");
		}
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("left");
			   
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}
		else if(currentState == GAME){
		    updateGameState();
		}
		else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
}
