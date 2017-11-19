public class Main {
	public static void main(String[] args) {
		Window  game = new Window(); // Gera uma nova partida
		Entities ent = new Entities();

		Pixel[][] matrix = new Pixel[Window.width][Window.height];
		//while(true){
			for(int i = 0; i < Window.width; i++) {
				for(int j = 0; j < Window.height; j++) {
					if(ent.isSnake(i,j)) {
						game.add(new Pixel("green"));
					}
					else if(ent.isFood(i,j)) {
						game.add(new Pixel("red"));
					}
					else {
						game.add(new Pixel("black"));
					}
				}
			}
		//}
	}
}
