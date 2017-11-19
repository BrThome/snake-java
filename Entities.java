import java.util.Random;
import javax.swing.JPanel;

class Entities {

	private Coord[] snake;
	private int size;
	private Coord food;

	private Random rand = new Random();

	public Entities(Coord[] snake, int size, Coord food) {
		this.snake = snake;
		this.size = size;
		this.food = food;
	}

	public Entities() {
		snake = new Coord [GameHandler.height * GameHandler.width];
		size = 3;

		for(int i = 0; i < size; i++){
			snake[i] = new Coord(5 - i, 5, 1, 0);
		}

		food = new Coord(33, 33);
		setFood();
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

		snake[0].setX((snake[1].getX() + snake[1].getDx()) % GameHandler.width);
		if(snake[0].getX() < 0) {
			snake[0].setX(GameHandler.width - 1);
		}

		snake[0].setY((snake[1].getY() + snake[1].getDy()) % GameHandler.height);
		if(snake[0].getY() < 0) {
			snake[0].setY(GameHandler.width - 1);
		}
	}

	public Coord getFood() {
		return food;
	}

	public void setFood() {
		int x, y, limit = 0;
		do {
			x = rand.nextInt(GameHandler.width);
			y = rand.nextInt(GameHandler.height);
		} while(isSnake(x, y) && limit++ < 500);

		if(limit == 500) {
			for(x = 0; x < GameHandler.width; x++){
				for(y = 0; y < GameHandler.width; y++){
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
