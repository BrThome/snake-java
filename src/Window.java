package src;

import java.awt.GridLayout;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class Window extends JFrame {

	private static final long serialVersionUID = 347L; // "random"

	public Window() {
		this.getContentPane().setLayout(new GridLayout(GameHandler.width, GameHandler.height,0,0));  // seta o layout da janela
		this.getContentPane().setBackground(Color.black); // 
		this.setTitle("Snake"); // Seta o titulo da janela como Snake
		this.setSize(GameHandler.height * 20, GameHandler.width * 20); // seta o tamanhop da janela
		this.setVisible(true); // deixa a janela visivel
		this.setResizable(false); //não deixa que a janela seja redimensionada
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Modificado para Hide on close p/ chamar o componentHidden do listener abaixo

		// Ao fechar janela
		this.addComponentListener(new ComponentAdapter() { 
            @Override
            public void componentHidden(ComponentEvent e) { // quando a janela for escondida
				FileHandler.saveFile(GameHandler.ent); // salva a aplicação
				kill(); // se livra da janela
				System.exit(0); // e fecha a aplicação, 0 indica que foi sem nenhum problema. No caso se fosse outro numero esse numero seria uma referencia para o problema em questão
            }
        });
	}

	public void kill() {
		this.dispose(); // libera todos os recursos sendo usados por essa janela.
	}
}
