package src;

import java.awt.event.KeyListener;

import javax.swing.JLabel;

import java.awt.Color;

class GameHandler extends Thread {

	private int speed = 50; // Quanto menor, mais rapido.

	public static int width = 25; // Tamanho da Janela (Largura)
	public static int height = 25; // Tamanho da Janela (Altura)

	public static int dx = 1, dy = 0; // Direção na qual a cobra está indo
	public static boolean paused = false; // Booleana que verifica se o jogo está pausado ou nao

	public static Color snakeColor = Color.green, foodColor = Color.red, backgroundColor = Color.black; // Cores utilizadas no jogo
	public static Entities ent; // Classe que gerencia entidades, posições, basicamente gerencia tudo rolando no background

	private Window  gameWindow; // Uma Janela do Sistema

	public GameHandler() {
		gameWindow = new Window(); // Gera nova janela a qual o jogo sera executado em
		
		Entities load = FileHandler.loadFile(); // Tenta carregar um save em uma variável entidades
		if(load != null) {
			ent = load; // se a entidade buscada do arquivo for valida, as entidades do jogo se tornam aquelas
		} else {
			ent = new Entities(); // caso contrario é gerado uma nova "entidades", um jogo limpo
		}
		
		gameWindow.addKeyListener((KeyListener) new KBListener()); // Adiciona à janela de jogo controles de teclado, estes são lidados com no KBListener.java

		game(); // inicia jogo
	}

	private void game() {
		while(true) { // roda em loop até que este seja terminado
			if(!paused) // se não estiver pausado
				if(checkCollisionAndMove()) break; // checa colisões e move a cobrinha
			
			ent.setSnakeHeading(dx, dy); // muda a direção a qual a cobrinha se move para

			redraw(); // chama método quedesenha os graficos do jogo

			//System.out.print("HEAD x = " + ent.getHead().getX() + ", y = " + ent.getHead().getY() + "\nSIZE = " + ent.getSize() + "\nFOOD x = " + ent.getFood().getX() + ", y = " + ent.getFood().getY() + "\n");

			wait(speed); // O thread na qual este objeto está sendo lidado com aguardado 'speed' millisegundos, basicamente, ele para de operar por esse tempo

			gameWindow.getContentPane().removeAll(); // limpa a janela de jogo
			//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		System.out.println("GAME OVER");

		FileHandler.saveFile(new Entities());
		//FileHandler.delSave();
		//new GameHandler();
		gameWindow.kill();
	}

	private boolean checkCollisionAndMove() { // checa colisões da cobra e a movimenta
		int x = ent.getHead().getX() % GameHandler.width;
		int y = ent.getHead().getY() % GameHandler.height;

		if(ent.isSnake(
			((x >= 0)? x : (GameHandler.width - 1)),
			((y >= 0)? y : (GameHandler.height - 1)), 1)){
				return true;
		}
		if(ent.isFood(
			((x >= 0)? x : (GameHandler.width - 1)),
			((y >= 0)? y : (GameHandler.height - 1)))){
				ent.setFood();
				ent.updateSnakeArray(true);
		}
		else {
			ent.updateSnakeArray();
		}

		return false;
	}

	private void redraw() { // desenha a tela do jogo 
        for (int j = 0; j < width; j++) { // para cada pixel altura por largura desenha os objetos conforme lidados no atributo ent (entidades do jogo)
            for (int i = 0; i < height; i++) {
				Pixel gfx;
                if (ent.isSnake(i,j)) { // se for a cobra, adiciona ela
                    gfx = new Pixel(snakeColor);
                    //System.out.print("~");
                }
                else if (ent.isFood(i,j)) { // se for  comida, adiciona ela
                    gfx = new Pixel(foodColor);
                    //System.out.print("@");
                }
                else { // se nao houver nada, pinta de preto para que seja o fundo
                    gfx = new Pixel(backgroundColor);
                    //System.out.print(" ");
                }
                gameWindow.add(gfx); // adiciona esses graficos à janela
            }
            //System.out.print("|\n");
        }
        gameWindow.revalidate(); // diz para o gerenciador de layout resetar com base na nova lista de componentes
        gameWindow.repaint(); // diz pro  componente se desenhar
    }

	private void wait(int t) {
		try {
			sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
