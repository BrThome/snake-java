import java.util.Random;
import javax.swing.JPanel;

class Entities {

	private Coord[] snake;
	private int size;
	private Coord food;

	public Entities() {
		snake = new Coord [Window.height * Window.width];
		size = 3;
		Random rand = new Random();
		//food = new Coord(rand.nextInt(Window.width), rand.nextInt(Window.height));
		food = new Coord(1,1);
		for (int i = 0; i < size; i++) {
			snake[i] = new Coord(5 - i, 5, 1, 0);
		}
	}

	public Entities(Coord[] snake, int size, Coord food) {
		this.snake = snake;
		this.size = size;
		this.food = food;
	}

	public boolean isSnake(int x, int y) {
		int i = 0;
		while (i < size){
			if (snake[i].getX() == x && snake[i].getY() == y) {
				return true;
			}
			i++;
		}
		return false;
	}

	public boolean isFood(int x, int y) {
		if (food.getX() == x && food.getY() == y) {
			return true;
		}
		return false;
	}
}
