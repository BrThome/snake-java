import java.awt.GridLayout;
import javax.swing.JFrame;

class Window extends JFrame {

	private static final long serialVersionUID = 347L; //"random"
	public static int width = 40;
	public static int height = 40;

	public Window(){

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(new GridLayout(height, width, 0, 0));

		
	}
}
