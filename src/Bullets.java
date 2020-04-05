import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bullets extends GameObject {
	public static BufferedImage bullet;
	public static boolean needImageBullet = true;
	public static boolean gotImageBullet = false;
	
	Bullets(double x, double y, double width, double height) {
		super((int)x, (int)y, (int)width, (int)height);
		speed = 15;
		if (needImageBullet) {
			loadBullet("bullet.png");
		}
	}

	void update() {
		y -= speed;
		 super.update();
	}

	void draw(Graphics g) {
		
		
		if (gotImageBullet) {
			g.drawImage(bullet, (int)x, (int)y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect((int)x, (int)y, width, height);
		}
	}
	
	void loadBullet(String imageFile) {
		if (needImageBullet) {
			try {
				bullet = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
				gotImageBullet = true;
			} catch (Exception e) {

			}
			needImageBullet = false;
		}

	}
}