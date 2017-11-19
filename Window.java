import java.awt.GridLayout;
import javax.swing.JFrame;
import java.awt.Color;

class Window extends JFrame {

	private static final long serialVersionUID = 347L; // "random"

	public Window() {
		this.getContentPane().setLayout(new GridLayout(GameHandler.width, GameHandler.height,0,0));
		this.getContentPane().setBackground(Color.black);
		this.setTitle("Snake");
		this.setSize(GameHandler.height * 20, GameHandler.width * 20);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
