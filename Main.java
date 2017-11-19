public class Main {

	public static void main(String[] args) {
		Window  gameWindow = new Window(); // Gera uma nova partida
		Entities ent = new Entities();

		GameHandler game = new GameHandler();
		//while(true){
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
		//}
	}
}
