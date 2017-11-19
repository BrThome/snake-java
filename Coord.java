class Coord {
	private int x;
	private int y;
	private int dx;
	private int dy;

	public Coord(int x, int y, int dx, int dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}

	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return this.x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return this.y;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getDx(){
		return this.dx;
	}

	public void setDx(int dx){
		this.dx = dx;
	}

	public int getDy(){
		return this.dy;
	}

	public void setDy(int dy){
		this.dy = dy;
	}
}
