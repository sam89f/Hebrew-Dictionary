import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;

/*This program displays a panel with a rectangle that a user can see
  along with a frame with an image and a text label*/

public class PolyPanel extends JPanel
{

	public PolyPanel()
	{
 		  RECT_WIDTH = PANEL_WIDTH;
 		  RECT_HEIGHT = PANEL_HEIGHT;
		  W = PANEL_WIDTH;
  	     H = PANEL_HEIGHT;
		// Sets panel size
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		 COLORED = Color.black;
		 COLOR = new Color(1.0F, 0.725F, 0.0F);
		//The rectangle that the pain method draws
		rect = new Rectangle(RECT_WIDTH, RECT_HEIGHT);
		rected = new Rectangle(10, 10);
		rect.setLocation(RECT_X, RECT_Y);
	}
	public PolyPanel(int w, int h)
	{
		  PANEL_WIDTH = w;
		  PANEL_HEIGHT = h;
 		  RECT_WIDTH = PANEL_WIDTH;
 		  RECT_HEIGHT = PANEL_HEIGHT;
		  W = PANEL_WIDTH;
  	     H = PANEL_HEIGHT;
		// Sets panel size
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		 COLORED = Color.black;
		 COLOR = new Color(1.0F, 0.725F, 0.0F);
		//The rectangle that the pain method draws
		rect = new Rectangle(RECT_WIDTH, RECT_HEIGHT);
		rected = new Rectangle(10, 10);
		rect.setLocation(RECT_X, RECT_Y);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		Graphics2D g1 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(6.5F));
		g2.setStroke(new BasicStroke(6.5F));
		rect.setSize(getWidth()-X,getHeight()-Y);
		g2.setColor(COLOR);
		g2.draw(rect);
		g1.setColor(COLORED);
		rect.setLocation(X/2, Y/2);
		g1.fill(rect);
	}
	public void set_color(Color c)
   {
	    COLOR = c;	
	}
	public void set_size(int w, int h)
	{
		PANEL_WIDTH = w;
		PANEL_HEIGHT = h;
		RECT_WIDTH = w; 
		RECT_HEIGHT = h;
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		rect.setSize(RECT_WIDTH, RECT_HEIGHT);
		//rected.setSize(RECT_WIDTH -X, RECT_HEIGHT - Y);
		repaint();
	}
	public void place(int x, int y)
	{
		rect.setLocation(RECT_X, RECT_Y);
		rected.setLocation(X, Y);
		repaint();
	}
	protected int PANEL_HEIGHT = 200;
	protected int PANEL_WIDTH = 200;
	protected int RECT_WIDTH;
	protected int RECT_HEIGHT;
	protected int RECT_X = 100;
	protected int RECT_Y = 100;
	protected int W;
	protected int I;
	protected int H;
	protected int X =  7;
	protected int Y =  7;
	protected Color COLORED;
	protected Color COLOR;
	protected Rectangle rected;
	protected Rectangle rect;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
