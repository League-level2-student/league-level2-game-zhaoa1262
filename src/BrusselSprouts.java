import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class BrusselSprouts extends GameObject {

	public static BufferedImage sprout;
	public static boolean needImageSprout = true;
	public static boolean gotImageSprout = false;

	BrusselSprouts(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 2;
		if (needImageSprout) {
			loadSprout("brusselSprout.png");
		}
	}

	void update() {
		super.update();
		y += speed;
		if(y>=500 || y<=0) {
			speed=-speed;
			if(y<=75) {
				speed=speed;
			}
		}
		
		
		
	}

	void draw(Graphics g) {

		if (gotImageSprout) {
			g.drawImage(sprout, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
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
}
