class Snake {

	private Coord[] snake;
	private int size;

	public Snake(){
		snake = new Coord [Window.height * Window.width];

		size = 3;

		for(int i = 0; i < 3; i++){
			snake[i].setX(5 - i);
			snake[i].setY(5);
			snake[i].setDx(1);
			snake[i].setDy(0);
		}
	}

	public Snake(Coord[] snake, int size){
		this.snake = snake;
		this.size = size;
	}
}
