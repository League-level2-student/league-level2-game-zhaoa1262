import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class BrusselSprouts extends GameObject {

	public static BufferedImage sprout;
	public static boolean needImageSprout = true;
	public static boolean gotImageSprout = false;
	
	static int whichSprout = 3;
	float gravity = 1f;
	float velocityX = 4f;
	float velocityY = 4f;
	
	
	BrusselSprouts(double x, double y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed=2;
		pickSprout(whichSprout);
	}

	void update(float time) {
		super.update();
		velocityY += gravity * time;        
	    x += velocityX * time;      
	    y += velocityY * time;
	
		
		if (y >= 500 ) {
			velocityY=-velocityY;
			
		}
		
		
			
			
	    

	}

	void draw(Graphics g) {

		if (gotImageSprout) {
			g.drawImage(sprout, (int)x, (int)y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect((int)x, (int)y, width, height);
		}
	}

	void loadSprout(String sproutImage) {
		if (needImageSprout) {
			try {
				sprout = ImageIO.read(this.getClass().getResourceAsStream(sproutImage));
				gotImageSprout = true;
			} catch (Exception e) {

			}
			needImageSprout = false;
		}
	}

	void pickSprout(int n) {
		if (needImageSprout) {
			if (n == 3) {
				loadSprout("brusselSprout.png");
				whichSprout=3;
			}
			if (n == 1) {
				loadSprout("smallSprout.png");
				whichSprout=1;
				
			}
			if (n == 2) {
				loadSprout("richSprout.png");
				whichSprout=2;
			}
		}

	}
}
