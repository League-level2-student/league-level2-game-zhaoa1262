import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bullets extends GameObject {
	public static BufferedImage bullet;
	public static boolean needImageBullet = true;
	public static boolean gotImageBullet = false;
	
	Bullets(int x, int y, int width, int height) {
		super(x, y, width, height);
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
			g.drawImage(bullet, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
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