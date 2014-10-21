/* GUI Class
 */

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.io.File;
import javax.swing.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener {
    JRadioButton small, medium, large;
    ButtonGroup pixelSize;
    JButton openButton;
    JLabel label;
    File file;
    BufferedImage img;
    JFileChooser chooser;

    public GUI() {
	
	openButton = new JButton("Select a file to pixelate!");
	// File Selector
	chooser = new JFileChooser();
	JPanel container = new JPanel();
	openButton.addActionListener(this);
	

	// Creates the radio buttons
	JRadioButton small = new JRadioButton("Small Pixels");
	small.setActionCommand(null);
	JRadioButton medium = new JRadioButton("Medium Pixels");
	medium.setActionCommand(null);
	JRadioButton large = new JRadioButton("Large Pixels");
	large.setActionCommand(null);
	
	// Adds the radio buttons to the radio button group
	ButtonGroup pixelSize = new ButtonGroup();
	pixelSize.add(small);
	pixelSize.add(medium);
	pixelSize.add(large);

	Panel chooserPanel = new Panel();
	Panel groupPanel = new Panel();

	chooserPanel.add(openButton);
	groupPanel.add(small);
	groupPanel.add(medium);
	groupPanel.add(large);
	
        this.add(chooserPanel);
	this.add(groupPanel);

	add(container);
	
    }

    public void actionPerformed(ActionEvent e) {
	// Handle open button action
	if(e.getSource() == openButton) {
	    int returnVal = chooser.showOpenDialog(GUI.this);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
		File file = chooser.getSelectedFile();
	    } 
	}
    }
}







    

