import java.awt.event.KeyListener;

class GameHandler extends Thread {
	int speed = 75; // Quanto menor, mais rapido.

	Window  gameWindow;
	Entities ent;

	public GameHandler() {
		gameWindow = new Window(); // Gera uma nova partida
		ent = new Entities();

		gameWindow.addKeyListener((KeyListener) new KBListener());
	}

	private void moveSnake() {
		while(true){

			Coord tail = ent.getTail();


			for(int i = 0; i < Window.width; i++) {
				for(int j = 0; j < Window.height; j++) {
					if(ent.isSnake(i,j)) {
						gameWindow.add(new Pixel("green"));
					}
					else if(ent.isFood(i,j)) {
						gameWindow.add(new Pixel("red"));
					}
					else {
						gameWindow.add(new Pixel("black"));
					}
				}
			}


			ent.updateSnakeArray();
			try {
				sleep(speed);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
