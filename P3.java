/* Driver Class
*/
import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.*;
import javax.swing.JMenuBar;


public class P3 {
    static JMenuItem quit, gettingStarted, help;
    public static void main(String[] args) {

	// Displays a message if user enters command line arguments
	if (args.length > 0) {
	    System.out.println("Please run the program with no arguments");
	    System.exit(0);
	}
	// Creates the new JFrame and Menu Bar
	JFrame frame = new JFrame("Pixelator");
	JMenuBar bar = new JMenuBar();
	GUI gui = new GUI();
	JMenu file, helpMenu;
        file = new JMenu ("File");
        file.setMnemonic(KeyEvent.VK_F);
        file.getAccessibleContext().setAccessibleDescription("This menu contains a quit command");
	quit = new JMenuItem("Quit");
	file.add(quit);
        quit.addActionListener(gui);
	bar.add(file);
	helpMenu = new JMenu ("Help");
	helpMenu.setMnemonic(KeyEvent.VK_H);
	file.getAccessibleContext().setAccessibleDescription("This menu contains information about the program");
	gettingStarted = new JMenuItem("Get Started");
	gettingStarted.addActionListener(gui);
	helpMenu.add(gettingStarted);
	help = new JMenuItem("Help");
	help.addActionListener(gui);
	helpMenu.add(help);
	bar.add(helpMenu);
	
	
	
	frame.setJMenuBar(bar);

	// Sets default operations for the program
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	
	frame.getContentPane().add(new GUI());

	// Sets the size and sets it to visable
	frame.setSize(700,700);
	frame.setVisible(true);
	
	
    }
    
}