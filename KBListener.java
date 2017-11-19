import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KBListener extends KeyAdapter {

	private int playPause = 0;

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case 39: // Muda a direcao da Snake para a direita.
				System.out.println("Direita!");
				// if(ent.getHead().getDx() != -1) {
				// 	ent.setSnakeHeading(1, 0);
				// }
				break;
			case 38: // Muda a direcao da Snake para cima.
				System.out.println("Cima!");
				// if(ent.getHead().getDy() != 1) {
				// 	ent.setSnakeHeading(0, -1);
				// }
				break;
			case 37: // Muda a direcao da Snake para a esquerda;
				System.out.println("Esquerda!");
				// if(ent.getHead().getDx() != 1) {
				// 	ent.setSnakeHeading(-1, 0);
				// }
				break;
			case 40: // Muda a direcao da Snake para baixo.
				System.out.println("Baixo!");
				// if(ent.getHead().getDy() != -1) {
				// 	ent.setSnakeHeading(0, 1);
				// }
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
