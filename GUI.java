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

public class GUI extends JPanel implements ActionListener {
    JRadioButton small, medium, large;
    ButtonGroup pixelSize;
    JButton openButton;
    JLabel jLabelImg;
    File file;
    BufferedImage img;
    JFileChooser chooser;
    JButton pixelate;
    BufferedImage returned;
    JLabel jLabelReturned;
    JPanel finishedImage;
    FileNameExtensionFilter filter;
    

    public GUI() {
	
	openButton = new JButton("Select a file to pixelate!");
	// File Selector
	chooser = new JFileChooser();
	JPanel container = new JPanel();
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
	groupPanel.add(pixelate);

        this.add(chooserPanel);
	this.add(groupPanel);
	

	add(container, BorderLayout.PAGE_START);
	repaint();
    }

    public void actionPerformed(ActionEvent e) {
	jLabelImg = new JLabel();
	P3 p3 = new P3();
	Pixelize pix = new Pixelize();
	JLabel finishedImage;
	filter = new FileNameExtensionFilter("PNG Files", "png");
	chooser.setFileFilter(filter);
	int count = 0;

	// Handle open button action
	if(e.getSource() == openButton) {
	    count++;
	    if (count < 2) {
	    int returnVal = chooser.showOpenDialog(GUI.this);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
		File file = chooser.getSelectedFile();
		BufferedImage bi;
		try {
		    bi = ImageIO.read(file);
		    jLabelImg.setIcon(new ImageIcon(bi));
		    add(jLabelImg, BorderLayout.CENTER);
		    jLabelImg.revalidate();
		    jLabelImg.repaint();
		} catch (IOException ex) {}
	    }
	    }
	    else {
		add(jLabelImg, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(null, "Please restart the program to pixelize a new photo!", "Picture already pixelized", JOptionPane.WARNING_MESSAGE);
	    }
	}
	else if (e.getSource() == pixelate) {
	    count++;
	    if (count < 2) {
		if (small.isSelected()){
		    File file = chooser.getSelectedFile();
		    BufferedImage bi;
		    try {
			bi = ImageIO.read(file);
			String image = pix.pixelize("small", bi);		    
			finishedImage = new JLabel();
			finishedImage.setIcon(new ImageIcon(image));
			add(finishedImage, BorderLayout.CENTER);
			finishedImage.revalidate();
			finishedImage.repaint();
			
		    } catch (IOException ex) {}
		    
		}
		if (medium.isSelected()){
		    File file  = chooser.getSelectedFile();
		    BufferedImage bi;
		    try {
			bi = ImageIO.read(file);
			String image = pix.pixelize("medium", bi);
			finishedImage = new JLabel();
			finishedImage.setIcon(new ImageIcon(image));
			add(finishedImage, BorderLayout.CENTER);
			finishedImage.revalidate();
			finishedImage.repaint();
		    } catch (IOException ex) {}
		}
		if (large.isSelected()){
		    File file = chooser.getSelectedFile();
		    BufferedImage bi;
		    try {
			bi = ImageIO.read(file);
			String image = pix.pixelize("large", bi);
			finishedImage = new JLabel();
			finishedImage.setIcon(new ImageIcon(image));
			add(finishedImage, BorderLayout.CENTER);
			finishedImage.revalidate();
			finishedImage.repaint();
		    } catch (IOException ex) {}
		}
	    
		if ((!small.isSelected()) && (!medium.isSelected()) && (!large.isSelected())) {
		    JOptionPane.showMessageDialog(null, "Please make sure you havea  image file and size selected!", "Image or size not selected", JOptionPane.WARNING_MESSAGE);
		}
	    }
	    else {
		finishedImage = new JLabel();
		add(finishedImage, BorderLayout.CENTER);
		finishedImage.repaint();
		JOptionPane.showMessageDialog(null, "Please restart the program to pixelize a new photo!", "Photo already pixelized", JOptionPane.WARNING_MESSAGE);
	    }
	}
    }
}









    

