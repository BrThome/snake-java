import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KBListener extends KeyAdapter {
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case 39: // Muda a direcao da Snake para a direita.
				System.out.print("Direita!");
				// if(ent.getHead().getDx() != -1) {
				// 	ent.setSnakeHeading(1, 0);
				// }
				break;
			case 38: // Muda a direcao da Snake para cima.
				System.out.print("Cima!");
				// if(ent.getHead().getDy() != 1) {
				// 	ent.setSnakeHeading(0, -1);
				// }
				break;
			case 37: // Muda a direcao da Snake para a esquerda;
				System.out.print("Esquerda!");
				// if(ent.getHead().getDx() != 1) {
				// 	ent.setSnakeHeading(-1, 0);
				// }
				break;
			case 40: // Muda a direcao da Snake para baixo.
				System.out.print("Baixo!");
				// if(ent.getHead().getDy() != -1) {
				// 	ent.setSnakeHeading(0, 1);
				// }
				break;
			default:
				break;
		}
	}
}
