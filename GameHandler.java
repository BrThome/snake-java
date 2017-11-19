import java.awt.event.KeyListener;
import java.awt.Color;

class GameHandler extends Thread {

	private int speed = 500; // Quanto menor, mais rapido.

	public static int width = 40;
	public static int height = 40;
	public static int dx = 1, dy = 0;
	public static Color snakeColor = Color.green, foodColor = Color.red, backgroundColor = Color.black;

	private Window  gameWindow;
	private Entities ent;

	public GameHandler() {
		gameWindow = new Window(); // Gera uma nova partida
		ent = new Entities();

		gameWindow.addKeyListener((KeyListener) new KBListener());

		game();
	}

	private void game() {
		while(true) {
			ent.setSnakeHeading(dx, dy);

			if(checkCollisionAndMove()) break;

			redraw();

			System.out.print("HEAD x = " + ent.getHead().getX() + ", y = " + ent.getHead().getY() + "\nSIZE = " + ent.getSize() + "\nFOOD x = " + ent.getFood().getX() + ", y = " + ent.getFood().getY() + "\n");

			wait(speed);

			gameWindow.getContentPane().removeAll();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}

		System.out.println("GAME OVER");
	}

	private boolean checkCollisionAndMove() {
		if(ent.isSnake(
			ent.getHead().getX() + ent.getHead().getDx(),
			ent.getHead().getY() + ent.getHead().getDy())) {
				return true;
		}
		if(ent.getHead().getX() +
			ent.getHead().getDx() ==
			ent.getFood().getX() &&
			ent.getHead().getY() +
			ent.getHead().getDy() ==
			ent.getFood().getY()){
				ent.updateSnakeArray(true);
		}
		else {
			ent.updateSnakeArray();
		}

		return false;
	}

	private void redraw() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (ent.isSnake(i,j)) {
					//gameWindow.add(new Pixel(snakeColor));
				}
				else if (ent.isFood(i,j)) {
					//gameWindow.add(new Pixel(foodColor));
				}
				else {
					//gameWindow.add(new Pixel(backgroundColor));
				}
			}
		}
	}

	private void wait(int t) {
		try {
			sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
