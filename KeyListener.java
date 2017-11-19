import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	public void directions(KeyEvent e) {
		switch(e.getKeyCode()) {
			case 39: // Muda a direçao da Snake para a direita.
				System.out.print("Direita!");
				break;
			case 38: // Muda a direçao da Snake para cima.
				System.out.print("Cima!");
				break;
			case 37: // Muda a direçao da Skane para a esquerda;
				System.out.print("Esquerda!");
				break;
			case 40: // Muda a direçao da Snake para baixo.
				System.out.print("Baixo!");
				break;
			default:
				break;
		}
	}
}