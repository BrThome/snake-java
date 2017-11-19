import java.awt.event.KeyListener;

import java.awt.Color;

class GameHandler extends Thread {

	private int speed = 75; // Quanto menor, mais rapido.

	public static int width = 20;
	public static int height = 20;

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
			dx = ent.getHead().getDx();
			dy = ent.getHead().getDy();
		} else {
			ent = new Entities();
		}
		gameWindow.addKeyListener((KeyListener) new KBListener());
		
		game();
	}

	private void game() {
		while(true) {
			ent.setSnakeHeading(dx, dy);

			if(!paused)
				if(checkCollisionAndMove()) break;

			redraw();

			//System.out.print("HEAD x = " + ent.getHead().getX() + ", y = " + ent.getHead().getY() + "\nSIZE = " + ent.getSize() + "\nFOOD x = " + ent.getFood().getX() + ", y = " + ent.getFood().getY() + "\n");

			wait(speed);

			gameWindow.getContentPane().removeAll();
			//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		System.out.println("GAME OVER");
		ent = new Entities();
		FileHandler.saveFile(ent);
		//new GameHandler();
		gameWindow.kill();
	}

	private boolean checkCollisionAndMove() {
		int x = ent.getHead().getX() + ent.getHead().getDx() % GameHandler.width;
		int y = ent.getHead().getY() + ent.getHead().getDy()  % GameHandler.height;

		if(ent.isSnake(
			((x >= 0)? x : (GameHandler.width - 1)),
			((y >= 0)? y : (GameHandler.height - 1)))){
				return true;
		}
		if(ent.getHead().getX() +
			ent.getHead().getDx() ==
			ent.getFood().getX() &&
			ent.getHead().getY() +
			ent.getHead().getDy() ==
			ent.getFood().getY()){
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
