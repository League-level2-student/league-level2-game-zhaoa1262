import javax.swing.JFrame;

/*
 * 
 * menu, game, end
 * launcher
 * brussel sprouts
 * bullets (tbd)
 * GameObject
 * ObjectManager
 * game play:
 * - new ball comes in every few seconds
 * - launcher is grounded
 * - use left and right arrow key to move launcher
 * - each ball splits into a random number of more balls
 * - launcher shoots bullets automatically
 */
public class ShootTheBrusselSprout {
	JFrame frame;
	GamePanel GamePanel;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	
	ShootTheBrusselSprout() {
		frame = new JFrame();
		GamePanel = new GamePanel();
	}

	void setup() {
		frame.add(GamePanel);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.addKeyListener(GamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ShootTheBrusselSprout thing = new ShootTheBrusselSprout();
		thing.setup();
		
	}
}
