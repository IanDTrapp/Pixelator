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
import javax.swing.ImageIcon;

public class GUI extends JPanel implements ActionListener {
    JRadioButton small, medium, large;
    ButtonGroup pixelSize;
    JButton openButton;
    JLabel jLabelImg;
    File file;
    BufferedImage img;
    JFileChooser chooser;
    JButton pixelate;
    

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
	
	pixelate = new JButton("Pixelate!");
	pixelate.addActionListener(this);

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
	jLabelImg = new JLabel();
	// Handle open button action
	if(e.getSource() == openButton) {
	    int returnVal = chooser.showOpenDialog(GUI.this);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
		File file = chooser.getSelectedFile();
		BufferedImage bi;
		try {
		    bi = ImageIO.read(file);
		    img = bi;
		    jLabelImg.setIcon(new ImageIcon(bi));
		    add(jLabelImg);
		} catch (IOException ex)
		    {
		    }
	    } 
	}
	Pixelize pix = new Pixelize();
	if (e.getSource() == pixelate) {
	    if (small.isSelected()){
		File file = chooser.getSelectedFile();
		BufferedImage bi;
		try {
		    bi = ImageIO.read(file);
		    pix.pixelize("small", bi);
		} catch (IOException ex) {}
	    }
	    if (medium.isSelected()){
		File file  = chooser.getSelectedFile();
		BufferedImage bi;
		try {
		    bi = ImageIO.read(file);
		    pix.pixelize("medium", bi);
		} catch (IOException ex) {}
            }
	    if (large.isSelected()){
		File file = chooser.getSelectedFile();
		BufferedImage bi;
		try {
		    bi = ImageIO.read(file);
		   pix.pixelize("large", bi);
		} catch (IOException ex) {}
	    }
	 
	}
    }

}







    

