import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KBListener extends KeyAdapter {

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 39: // Muda a direcao da Snake para a direita.
			System.out.print("Direita!");
			break;
		case 38: // Muda a direcao da Snake para cima.
			System.out.print("Cima!");
			break;
		case 37: // Muda a direcao da Skane para a esquerda;
			System.out.print("Esquerda!");
			break;
		case 40: // Muda a direcao da Snake para baixo.
			System.out.print("Baixo!");
			break;
		default:
			break;
		}
	}
}
