import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Launcher launcher;
	ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	ArrayList<BrusselSprouts> sprouts = new ArrayList<BrusselSprouts>();
	Random random = new Random();

	ObjectManager(Launcher launcher) {
		this.launcher = launcher;
	}

	void addBullet(Bullets object) {
		bullets.add(object);
	}

	void addSprout() {
		sprouts.add(new BrusselSprouts(random.nextInt(ShootTheBrusselSprout.WIDTH), 0, 125, 125));
		System.out.println("bob");
	}

	void update() {
		for (int i = 0; i < sprouts.size(); i++) {
			BrusselSprouts brusselSprouts = sprouts.get(i);
			brusselSprouts.update();
			checkCollision();
			purgeObjects();

			if (brusselSprouts.y > 800 || brusselSprouts.x < 0) {
				brusselSprouts.isActive = false;
			}
		}
		for (int i = 0; i < bullets.size(); i++) {
			Bullets bullet = bullets.get(i);
			bullet.update();
			if (launcher.isActive == false) {
				checkCollision();
				purgeObjects();
			}

		}

	}

	void draw(Graphics g) {
		launcher.draw(g);
		for (int i = 0; i < sprouts.size(); i++) {
			BrusselSprouts sprout = sprouts.get(i);
			sprout.draw(g);
		}
		for (int x = 0; x < bullets.size(); x++) {
			Bullets bullet = bullets.get(x);
			bullet.draw(g);

		}
	}
	void checkCollision() {
		for (BrusselSprouts sprout : sprouts) {
			
			if (launcher.collisionBox.intersects(sprout.collisionBox)) {
				launcher.isActive = false;
				sprout.isActive = false;

			}

		}

		for (Bullets bullet : bullets) {

			for (BrusselSprouts sprout : sprouts) {
				
				if (bullet.collisionBox.intersects(sprout.collisionBox)) {
					sprout.isActive = false;
					bullet.isActive = false;
					

				}
			}
		}

	}
	void purgeObjects() {
		for (int i = 0; i < sprouts.size(); i++) {
			BrusselSprouts sprout = sprouts.get(i);
			if (sprout.isActive == false) {
				sprouts.remove(i);
			}
		}
		for (int x = 0; x < bullets.size(); x++) {
			Bullets bullet = bullets.get(x);
			if (bullet.isActive == false) {
				bullets.remove(x);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addSprout();
	}

}
