/* Driver Class
*/
import java.awt.*;
import javax.swing.*;

public class P3 {
    public static void main(String[] args) {
	
	JFrame frame = new JFrame("Pixelator");
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);

	frame.getContentPane().add(new GUI());
	
	frame.pack();
	frame.setVisible(true);

    }
}