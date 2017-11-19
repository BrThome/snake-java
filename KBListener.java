import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KBListener extends KeyAdapter {
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT: // Muda a direcao da Snake para a direita.
			if (GameHandler.dx != -1) {
				GameHandler.dx = 1;
				GameHandler.dy = 0;
			}
			break;
		case KeyEvent.VK_UP: // Muda a direcao da Snake para cima.
			if (GameHandler.dy != 1) {
				GameHandler.dx = 0;
				GameHandler.dy = -1;
			}
			break;
		case KeyEvent.VK_LEFT: // Muda a direcao da Snake para a esquerda;
			if (GameHandler.dx != 1) {
				GameHandler.dx = -1;
				GameHandler.dy = 0;
			}
		break;
		case KeyEvent.VK_DOWN: // Muda a direcao da Snake para baixo.
			if (GameHandler.dy != -1) {
				GameHandler.dx = 0;
				GameHandler.dy = 1;
			}
			break;
		case KeyEvent.VK_F1:
			FileHandler.saveFile(GameHandler.ent);
			System.out.println("Saved!!"); // Apagar depois
			break;
		case KeyEvent.VK_F5:
			GameHandler.ent = FileHandler.loadFile();
			GameHandler.dx = GameHandler.ent.getHead().getDx();
			GameHandler.dy = GameHandler.ent.getHead().getDy();
			System.out.println("Loaded!!"); // Apagar depois
			break;
		case KeyEvent.VK_SPACE:
			GameHandler.paused = !GameHandler.paused;
			if(GameHandler.paused) System.out.println("Pause!");
			else System.out.println("Play");
			break;
		default:
			break;
		}
	}
}
