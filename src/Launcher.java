import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Launcher extends GameObject{
	public static BufferedImage image;
	public static boolean needImageLauncher = true;
	public static boolean gotImageLauncher = false;	
	
	void loadLauncher(String imageFile) {
	    if (needImageLauncher) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImageLauncher = true;
	        } catch (Exception e) {
	            
	        }
	        needImageLauncher = false;
	    }
	}
	
	Launcher(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 30;
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
	public void right() {
		x += speed;
		super.update();
	}
	
	public void left() {
		x -= speed;
		super.update();
	}
	
}
