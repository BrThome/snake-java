import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Window  game = new Window(); // Gera uma nova partida

		game.setTitle("Snake");
		game.setSize(Window.height * 20, Window.width * 20);
		game.setVisible(true);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
