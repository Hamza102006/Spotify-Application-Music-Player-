import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author S. Thanush
 * Date: Oct. 2023
 * Description: A class that defines a component - ImagePicture 
 * 				Inherits from Picture
 *
 *Method List: 
 *public ImagePicture(ImageIcon img) - Default Constructor
 *public ImagePicture(ImageIcon img, int x , int y) - Overloaded constructor
 *public void paint (Graphics g) - Overrides the Picture class paint method
 *public void setImage(ImageIcon image) - Sets image
 *public static void main(String[] args) - Self-Testing main method
 *
 */
public class ImagePicture extends Picture  {

	/**
	 * Private instance Variables
	 */
	private ImageIcon image; //for storing icons


	/*
	 * Constructor for showing an image
	 */
	public ImagePicture(ImageIcon img) {
		// call our superclass
		super();
		this.image = img;
		setMyWidth(img.getIconWidth());
		setMyHeight(img.getIconHeight());
		repaint();
	}

	/*
	 * Overloaded constructor
	 */
	public ImagePicture(ImageIcon img, int x , int y) { 
		//call the parent constructor 
		super(x, y, img.getIconWidth(),img.getIconHeight());
		this.image = img;
	}


	/*
	 * Override the paint from Picture
	 */
	public void paint (Graphics g) { 
		//paint the image
		this.image.paintIcon(this, g, getxPos(), getyPos());
	}


	/**
	 * @param image the image to set
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
	}

	/**
	 * Self-Testing main method
	 */
	public static void main(String[] args) {

		//Create a JFrame, sets the size of the frame, creates the ImagePicture object with 
		//minion image, adds the object to the frame, and sets the visibility to true
		JFrame f = new JFrame("Testing Only");
		f.setSize(400,350);
		ImagePicture p = new ImagePicture (new ImageIcon("minion.png"));
		f.add(p);
		f.setVisible(true);	

		//Changes the x positioning of object and repaints using delay
		JOptionPane.showMessageDialog(null, "Wait");		
		p.setxPos(200);
		f.repaint();
		
		//Tests the overloaded constructor by creating delay, adding new imagePicture object
		//adding the object to frame, and setting the visibility to true
		JOptionPane.showMessageDialog(null, "Wait");
		ImagePicture p1 = new ImagePicture(new ImageIcon("gru.png"),100,100);
		f.add(p1);
		f.setVisible(true);

		// test the set image method by creating delay,setting image object to gru image
		//and repainting the frame
		JOptionPane.showMessageDialog(null, "Wait");
		p.setImage(new ImageIcon("gru.png"));
		p.repaint();
	}
}
