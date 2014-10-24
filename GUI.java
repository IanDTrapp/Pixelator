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
import java.awt.BorderLayout;
import javax.swing.filechooser.*;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import java.awt.event.*;

public class GUI extends JPanel implements ActionListener {
    // Declares components to be used
    JRadioButton small, medium, large;
    ButtonGroup pixelSize;
    JButton openButton, reset, pixelate;
    File file;
    BufferedImage img;
    JFileChooser chooser;
    BufferedImage returned;
    JLabel jLabelImg, finishedImage;
    FileNameExtensionFilter filter;
    JPanel container; 

    public GUI() {
		
	openButton = new JButton("Select a file to pixelate!");
	// File Selector
	chooser = new JFileChooser();
	container = new JPanel();
	openButton.addActionListener(this);
	 

	// Creates the radio buttons
	small = new JRadioButton("Small Pixels");
	small.setActionCommand(null);
	medium = new JRadioButton("Medium Pixels");
	medium.setActionCommand(null);
	large = new JRadioButton("Large Pixels");
	large.setActionCommand(null);
	
	pixelate = new JButton("Pixelate!");
	pixelate.addActionListener(this);
	reset = new JButton("Reset");
	reset.addActionListener(this);

	// Adds the radio buttons to the radio button group
	ButtonGroup pixelSize = new ButtonGroup();
	pixelSize.add(small);
	pixelSize.add(medium);
	pixelSize.add(large);

    
	Panel chooserPanel = new Panel();
	Panel groupPanel = new Panel();
	
	// Adds panels to the frame
	chooserPanel.add(openButton);
	groupPanel.add(small);
	groupPanel.add(medium);
	groupPanel.add(large);
	groupPanel.add(pixelate);
	groupPanel.add(reset);

	jLabelImg = new JLabel();
	jLabelImg.setIcon(null);
	finishedImage = new JLabel();
	finishedImage.setIcon(null);

        this.add(chooserPanel);
	this.add(groupPanel);
	this.container.add(jLabelImg);
	this.add(finishedImage);
	

	add(container, BorderLayout.PAGE_START);
	
    }
    
    @Override 
    public void actionPerformed(ActionEvent e) {
	
	P3 p3 = new P3();
	Pixelize pix = new Pixelize();
	filter = new FileNameExtensionFilter("PNG Files", "png");
	chooser.setFileFilter(filter);
	int count = 0;
	

	// Handle open button action
	if(e.getSource() == openButton) {
	    count++;
	    if (count < 2) {
		// Opens the file chooser
		int returnVal = chooser.showOpenDialog(GUI.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    File file = chooser.getSelectedFile();
		    BufferedImage bi;
		    try {
			bi = ImageIO.read(file);
			// Sets the image icon and repaints the frame
			jLabelImg.setIcon(new ImageIcon(bi));
			//container.add(jLabelImg, BorderLayout.CENTER);
			jLabelImg.revalidate();
			jLabelImg.repaint();
		    } catch (IOException ex) {}
		}
	    }
	    // Returns an error if size or picture is not selected
	    else {
		add(jLabelImg, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(null, "Please restart the program to pixelize a new photo!", "Picture already pixelized", JOptionPane.WARNING_MESSAGE);
	    }
	}
	// Pixelates the photo based on the selected size
	else if (e.getSource() == pixelate) {
	    count++;
	    if (count < 2) {
		// Function for if size "small" was selected
		if (small.isSelected()){
		    File file = chooser.getSelectedFile();
		    BufferedImage bi;
		    try {
			// Pixelaizes photo, replaints and displays the image
			bi = ImageIO.read(file);
			String image = pix.pixelize("small", bi);		    
			finishedImage.setIcon(new ImageIcon(image));
			finishedImage.revalidate();
			finishedImage.repaint();
			
		    } catch (IOException ex) {}
		}
		// Function for if "medium" was selected
		if (medium.isSelected()){
		    File file  = chooser.getSelectedFile();
		    BufferedImage bi;
		    try {
			// Pixelizes photo, repaints and displays the image
			bi = ImageIO.read(file);
			String image = pix.pixelize("medium", bi);
			finishedImage.setIcon(new ImageIcon(image));
			finishedImage.revalidate();
			finishedImage.repaint();
		    } catch (IOException ex) {}
		}
		// Function for if "large" was selected
		if (large.isSelected()){
		    File file = chooser.getSelectedFile();
		    BufferedImage bi;
		    try {
			bi = ImageIO.read(file);
			String image = pix.pixelize("large", bi);
			//finishedImage = new JLabel();
			finishedImage.setIcon(new ImageIcon(image));
			finishedImage.revalidate();
			finishedImage.repaint();
		    } catch (IOException ex) {}
		}
	
		// Displays a dialog box if you didn't select a size
		if ((!small.isSelected()) && (!medium.isSelected()) && (!large.isSelected())) {
		    JOptionPane.showMessageDialog(null, "Please make sure you have a  image file and size selected!", "Image or size not selected", JOptionPane.WARNING_MESSAGE);
		}
	    }
	    else {
		JOptionPane.showMessageDialog(null, "Please restart the program to pixelize a new photo!", "Photo already pixelized", JOptionPane.WARNING_MESSAGE);
	    }
	}
	// Quits program
	if (e.getSource() == p3.quit) {
	    System.exit(0);
	}
	// Pop up window for help
	if (e.getSource() == p3.help) {
	    JOptionPane.showMessageDialog(null, "Author: Ian Trapp \n Created on October 24th, 2014", "About",JOptionPane.INFORMATION_MESSAGE);
	}
	// Pop up window for getting started
	if (e.getSource() == p3.gettingStarted) {
	    JOptionPane.showMessageDialog(null, "Please select an image and a pixel size. Pressing \"pixelate!\" will show your pixelized picture!");
	}
	// Resets image
	if (e.getSource() == reset) {
	    finishedImage.setIcon(null);
	    jLabelImg.setIcon(null);
	    jLabelImg.revalidate();
	    jLabelImg.repaint();
	    finishedImage.revalidate();
	    finishedImage.repaint();
	    container.revalidate();
	    container.repaint();
	}
    }
}









    

