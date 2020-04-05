import java.awt.Rectangle;

public class GameObject {
	double x;
	double y;
	int width;
	int height;
	double speed = 0;
	boolean isActive = true;
	Rectangle collisionBox;
	
	GameObject(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle((int)x, (int)y, width, height);
	}
	
	void update() {
		collisionBox.setBounds((int)x, (int)y, width, height);
	}
}
