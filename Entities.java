import java.util.Random;
import javax.swing.JPanel;

class Entities {

	private Coord[] snake;
	private int size;
	private Coord food;

	public Entities() {
		snake = new Coord [Window.height * Window.width];
		size = 3;
<<<<<<< HEAD
		Random rand = new Random();
		//food = new Coord(rand.nextInt(Window.width), rand.nextInt(Window.height));
		food = new Coord(1,1);
		for (int i = 0; i < size; i++) {
=======

		setFood();

		for(int i = 0; i < size; i++){
>>>>>>> ca6f7ea71b852252a62f9b38fc8feaaad6b53623
			snake[i] = new Coord(5 - i, 5, 1, 0);
		}
	}

	public Entities(Coord[] snake, int size, Coord food) {
		this.snake = snake;
		this.size = size;
		this.food = food;
	}

	public Coord getHead() {
		return snake[0];
	}

	public void setSnakeHeading(int dX, int dY) {
		snake[0].setDx(dX);
		snake[0].setDy(dY);
	}

	public Coord getTail() {
		return snake[size - 1];
	}

	public void updateSnakeArray() {
		for(int i = size - 1; i > 0; i--) {
			snake[i] = snake[i - 1];
		}
		snake[0].setX(snake[1].getX() + snake[1].getDx());
		snake[0].setY(snake[1].getY() + snake[1].getDy());
	}

	public Coord getFood() {
		return food;
	}

	public void setFood() {
		Random rand = new Random();
		int x, y, limit = 0;
		do {
			x = rand.nextInt(Window.width);
			y = rand.nextInt(Window.height);
		} while(isSnake(x, y) && limit++ < 500);

		if(limit == 500) {
			for(x = 0; x < Window.width; x++){
				for(y = 0; y < Window.width; y++){
					if(!isSnake(x, y)) break;
				}
			}
		}

		food.setX(x);
		food.setY(y);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
