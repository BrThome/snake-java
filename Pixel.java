import java.awt.Color;
import javax.swing.JPanel;

public class Pixel extends JPanel{

	private static final long serialVersionUID = 147L;

	public Pixel(String color){
		switch(color){
			case "green": this.setBackground(Color.green); break;
			case "red": this.setBackground(Color.red); break;
			case "black":
			default: this.setBackground(Color.black); break;
		}
	}
}
