package src;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KBListener extends KeyAdapter {
	private long lastPressProcessed = 0;
	private long timer = 50;
	
	public void keyPressed(KeyEvent e) {
		long calculatedTime = Math.subtractExact(System.currentTimeMillis(), lastPressProcessed);
		System.out.println(calculatedTime);
		if(calculatedTime > timer) { // verifica ultimo input
			lastPressProcessed = System.currentTimeMillis(); // Guarda o tempo do ultimo input
			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT: // Se a tecla SETA DIREITA for pressionada, move a cobra pra a direita
				if (GameHandler.dx != -1) {
					GameHandler.dx = 1;
					GameHandler.dy = 0;
				}
				return;
			case KeyEvent.VK_UP: // Se a tecla SETA PARA CIMA for pressionada, move a cobra pra cima
				if (GameHandler.dy != 1) {
					GameHandler.dx = 0;
					GameHandler.dy = -1;
				}
				return;
			case KeyEvent.VK_LEFT: // Se a tecla SETA ESQUERDA for pressionada, move a cobra pra esquerda
				if (GameHandler.dx != 1) {
					GameHandler.dx = -1;
					GameHandler.dy = 0;
				}
				return;
			case KeyEvent.VK_DOWN: // Se a tecla SETA PARA BAIXO for pressionada, move a cobra pra cima
				if (GameHandler.dy != -1) {
					GameHandler.dx = 0;
					GameHandler.dy = 1;
				}
				return;
			case KeyEvent.VK_F1: // Salva o jogo ao apertar F1 
				FileHandler.saveFile(GameHandler.ent);
				return;
			case KeyEvent.VK_F5: // Carrega o jogo ao apertar F5
				GameHandler.ent = FileHandler.loadFile();
				//System.out.println("Loaded!!");
				return;
			case KeyEvent.VK_SPACE: // Ao apertar espaço pausa o jogo
				GameHandler.paused = !GameHandler.paused;
				//if(GameHandler.paused) System.out.println("Pause!");
				//else System.out.println("Play");
				return;
			default:
				break;
			}
        } 
	}
}
