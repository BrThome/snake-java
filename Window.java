import java.awt.GridLayout;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyListener;

class Window extends JFrame {

	private static final long serialVersionUID = 347L; // "random"
	public static int width = 40;
	public static int height = 40;

	public Window() {

		getContentPane().setLayout(new GridLayout(height, width, 0, 0));

		this.getContentPane().setBackground(Color.black);

		this.setTitle("Snake");
		this.setSize(height * 20, width * 20);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addKeyListener((KeyListener) new KBListener());
	}
}
