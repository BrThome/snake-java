import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KBListener extends KeyAdapter {

	private int playPause = 0;

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case 39: // Muda a direcao da Snake para a direita.
				System.out.print("Direita!");
				if(GameHandler.dx != -1) {
					GameHandler.dx = 1;
					GameHandler.dy = 0;
				}
				break;
			case 38: // Muda a direcao da Snake para cima.
				System.out.print("Cima!");
				if(GameHandler.dy != 1) {
					GameHandler.dx = 0;
					GameHandler.dy = -1;
				}
				break;
			case 37: // Muda a direcao da Snake para a esquerda;
				System.out.print("Esquerda!");
				if(GameHandler.dx != 1) {
					GameHandler.dx = -1;
					GameHandler.dy = 0;
				}
				break;
			case 40: // Muda a direcao da Snake para baixo.
				System.out.print("Baixo!");
				if(GameHandler.dy != -1) {
					GameHandler.dx = 0;
					GameHandler.dy = 1;
				}
				break;
			case 32:
				System.out.println("Saved!!");
				break;
			case 8:
				System.out.println("Loaded!!");
				break;
			case 80:
				if (playPause % 2 == 0) {
					System.out.println("Pause!");
				} else {
					System.out.println("Play!");
				}
				playPause++;
				break;
			default:
				break;
		}
	}
}
