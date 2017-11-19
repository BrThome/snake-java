import java.awt.event.KeyListener;
import java.awt.Color;

class GameHandler extends Thread {

	private int speed = 500; // Quanto menor, mais rapido.

	public static int width = 40;
	public static int height = 40;
	public static int dx = 1, dy = 0;
	public static Color snakeColor = Color.green, foodColor = Color.red, backgroundColor = Color.black;
	public static Entities ent;

	private Window  gameWindow;

	public GameHandler() {
		gameWindow = new Window(); // Gera uma nova partida
		ent = new Entities();

		gameWindow.addKeyListener((KeyListener) new KBListener());

		moveSnake();
	}

	private void moveSnake() {
		while(true) {
			ent.setSnakeHeading(dx, dy);
			ent.updateSnakeArray();

			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (ent.isSnake(i,j)) {
						//gameWindow.add(new Pixel(snakeColor));
						System.out.print("x = " + i + ", y = " + j + "\n");
					}
					else if (ent.isFood(i,j)) {
						//gameWindow.add(new Pixel(foodColor));
					}
					else {
						//gameWindow.add(new Pixel(backgroundColor));
					}
				}
			}


			try {
				sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gameWindow.getContentPane().removeAll();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
	}
}
