import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author S. Thanush
 * Date: Oct. 2023
 * Description: A class that defines a component - Picture 
 * 				Inherits from JComponent
 * Method List: 
 * public Picture() - Default constructor
 * public Picture(int x, int y,int w, int h) - Overloaded constructor
 * public void setColor (Color color) - Sets color
 * public void setColor(int r, int g, int b) - Sets color through r,g,b
 * public void getColor (Color color) - Gets color
 * public void setxPos (int xPos) - Sets x position
 * public void getxPos (int xPos) - Gets x position
 * public void setyPos (int yPos) - Sets y position
 * public void getyPos(int yPos) - Gets y position
 * public void setMyWidth(int myWidth) - sets width
 * public void getMyWidth(int myWidth) - gets width
 * public void setMyHeight(int myHeight) - sets height
 * public void getMyHeight(int myHeight) - gets height
 * public void paint (Graphics g) - created our own overrided paint method
 * public static void main(String[] args) throws InterruptedException - Self testing main method that 
 * 																		tests newly created methods
 */
public class Picture extends JComponent {

	/*
	 * Instance data 
	 */
	private Color color;
	private int xPos, yPos, myWidth, myHeight;

	/**
	 * Default constructor
	 */
	public Picture() {

		//Initialize color, xPos, yPos, myWidth, myHeight
		this.color = color.RED;
		this.xPos = 0; 
		this.yPos = 0;
		this.myWidth = 50; 
		this.myHeight = 50; 

	}

	/*
	 * Overloaded constructor
	 */
	public Picture (int x, int y, int w, int h) { 
		this.color = color.RED;
		this.xPos = x;
		this.yPos = y; 
		this.myWidth = w;
		this.myHeight = h;
		repaint();
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/*
	 * Set color based on r,g,b
	 */
	public void setColor(int r, int g, int b) { 
		this.color = new Color(r,g,b);
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	/**
	 * @param myWidth the myWidth to set
	 */
	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
	}
	/**
	 * @param myHeight the myHeight to set
	 */
	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	/*
	 * our own paint method - Overrides JComponent's paint
	 */
	public void paint (Graphics g) { 
		g.setColor(this.color);	//sets my color
		g.drawRect(this.xPos, this.yPos, this.myWidth, this.myHeight); //draws the shape
		g.drawOval(xPos, yPos, myWidth, myHeight);
		g.fillOval(xPos+myWidth/3,yPos, myWidth/3, myHeight);

	}


	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @return the myWidth
	 */
	public int getMyWidth() {
		return myWidth;
	}

	/**
	 * @return the myHeight
	 */
	public int getMyHeight() {
		return myHeight;
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Self-testing main
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// create a frame and a picture object
		JFrame f = new JFrame("Testing");

		Picture p = new Picture();

		f.setSize(400,350);

		f.add(p);	// add my object to the frame

		f.setVisible(true); // paint the JFrame

		//wait!
		JOptionPane.showMessageDialog(null, "Wait");

		//change the color
		p.setColor(Color.BLUE);

		// repaint the frame 
		f.repaint();

		//wait!
		JOptionPane.showMessageDialog(null, "Wait");

		// test the setters for position and size
		p.setxPos(10);
		p.setyPos(250);
		p.setMyHeight(40);
		p.setMyWidth(25);

		//call p's paint
		p.repaint();

		//wait!
		JOptionPane.showMessageDialog(null, "Wait");

		//create another object
		Picture p1 = new Picture(200,50,100,50);

		f.add(p1);

		f.setVisible(true);

		//wait!
		JOptionPane.showMessageDialog(null, "Change color and Wait");

		p.setColor(255,200,0);

		f.repaint(); //repaint picture

		JOptionPane.showMessageDialog(null, "Wait");
		p1.setMyWidth(p1.getWidth()/2);
		p1.setMyHeight(p1.getHeight()*2);
		p1.repaint();

				
		JOptionPane.showMessageDialog(null, "Wait");

		// make object p move from left to right
		for (int  i = 0; i < 5; i++) { 
			p1.setxPos(p1.getxPos() + 10);
			Thread.sleep(50);
			p1.repaint();	
		}

	}

}
