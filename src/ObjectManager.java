import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
Launcher launcher;
ArrayList<Bullets> bullets = new ArrayList<Bullets>();
Random random = new Random();


ObjectManager(Launcher launcher) {
	this.launcher = launcher;
}

void addBullet(Bullets object) {
	bullets.add(object);
}

void update() {

	for (int i = 0; i < bullets.size(); i++) {
		Bullets projectile = bullets.get(i);
		projectile.update();
		if (launcher.isActive == false) {
			
			purgeObjects();
		}
		
	}

}

void draw(Graphics g) {
	launcher.draw(g);
	
	for (int x = 0; x < bullets.size(); x++) {
		Bullets projectile = bullets.get(x);
		projectile.draw(g);
		
	}
}

void purgeObjects() {
	for (int x = 0; x < bullets.size(); x++) {
		Bullets projectile = bullets.get(x);
		if (projectile.isActive == false) {
			bullets.remove(x);
		}
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

}
