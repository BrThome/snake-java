import java.awt.event.KeyListener;

import java.awt.Color;

class GameHandler extends Thread {

	private int speed = 50; // Quanto menor, mais rapido.

	public static int width = 25;
	public static int height = 25;

	public static int dx = 1, dy = 0;
	public static boolean paused = false;

	public static Color snakeColor = Color.green, foodColor = Color.red, backgroundColor = Color.black;
	public static Entities ent;

	private Window  gameWindow;

	public GameHandler() {
		gameWindow = new Window(); // Gera uma nova partida


		Entities load = FileHandler.loadFile();
		if(load != null) {
			ent = load;
			if(dx == ent.getHead().getDx() * -1) dx *= -1;
			else if(dy == ent.getHead().getDy() * -1) dy *= -1;
		} else {
			ent = new Entities();
		}
		gameWindow.addKeyListener((KeyListener) new KBListener());

		game();
	}

	private void game() {
		while(true) {

			if(!paused)
				if(checkCollisionAndMove()) break;

			ent.setSnakeHeading(dx, dy);

			redraw();

			//System.out.print("HEAD x = " + ent.getHead().getX() + ", y = " + ent.getHead().getY() + "\nSIZE = " + ent.getSize() + "\nFOOD x = " + ent.getFood().getX() + ", y = " + ent.getFood().getY() + "\n");

			wait(speed);

			gameWindow.getContentPane().removeAll();
			//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		System.out.println("GAME OVER");
		ent = new Entities();
		//FileHandler.saveFile(ent);
		FileHandler.delSave();
		//new GameHandler();
		gameWindow.kill();
	}

	private boolean checkCollisionAndMove() {
		int x = ent.getHead().getX() % GameHandler.width;
		int y = ent.getHead().getY() % GameHandler.height;

		if(ent.isSnake(
			((x >= 0)? x : (GameHandler.width - 1)),
			((y >= 0)? y : (GameHandler.height - 1)), 1)){
				return true;
		}
		if(ent.isFood(
			((x >= 0)? x : (GameHandler.width - 1)),
			((y >= 0)? y : (GameHandler.height - 1)))){
				ent.setFood();
				ent.updateSnakeArray(true);
		}
		else {
			ent.updateSnakeArray();
		}

		return false;
	}

	private void redraw() {
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
				Pixel gfx;
                if (ent.isSnake(i,j)) {
                    gfx = new Pixel(snakeColor);
                    //System.out.print("~");
                }
                else if (ent.isFood(i,j)) {
                    gfx = new Pixel(foodColor);
                    //System.out.print("@");
                }
                else {
                    gfx = new Pixel(backgroundColor);
                    //System.out.print(" ");
                }
                gameWindow.add(gfx); // desenha
            }
            //System.out.print("|\n");
        }
        gameWindow.revalidate(); // diz para o gerenciador de layout resetar com base na nova lista de componentes
        gameWindow.repaint(); // diz pro  componente se desenhar
    }

	private void wait(int t) {
		try {
			sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
