package src;

import java.awt.GridLayout;
import javax.swing.JFrame;
import java.awt.Color;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class Window extends JFrame {

	private static final long serialVersionUID = 347L; // "random"

	public Window() {
		this.getContentPane().setLayout(new GridLayout(GameHandler.width, GameHandler.height,0,0));
		this.getContentPane().setBackground(Color.black);
		this.setTitle("Snake");
		this.setSize(GameHandler.height * 20, GameHandler.width * 20);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Modificado para Hide on close p/ chamar o componentHidden do listener abaixo

		// Ao fechar janela
		this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
				FileHandler.saveFile(GameHandler.ent);
				kill();
				System.exit(0);
            }
        });
	}

	public void kill() {
		this.dispose();
	}
}
