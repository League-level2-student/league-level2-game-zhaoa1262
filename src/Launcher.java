import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Launcher extends GameObject{
	public static BufferedImage launcher;
	public static boolean needImageLauncher = true;
	public static boolean gotImageLauncher = false;	
	
	
	
	Launcher(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 30;
		if (needImageLauncher) {
			loadLauncher("launcher.png");
		}
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		if (gotImageLauncher) {
			g.drawImage(launcher, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void right() {
		x += speed;
		super.update();
	}
	
	public void left() {
		x -= speed;
		super.update();
	}
	
	void loadLauncher(String imageFile) {
	    if (needImageLauncher) {
	        try {
	            launcher = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImageLauncher = true;
	        } catch (Exception e) {
	            
	        }
	        needImageLauncher = false;
	    }
	}
	public Bullets getBullet() {
        return new Bullets(x+width/3, y, 30, 30);
} 
}
	