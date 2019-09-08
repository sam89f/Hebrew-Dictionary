
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

public class DrawPanel extends JPanel
{
	public DrawPanel(int sx, int sy, String[][] my_2Darray, int m, int n, int x, int y)
	{
		 
		RECT_WIDTH = PANEL_WIDTH;
 		RECT_HEIGHT = PANEL_HEIGHT;
		W = PANEL_WIDTH = sx;
  	   H = PANEL_HEIGHT = sy;
		ROW = n;
		COLLOM = m;
		X = x;
		Y = y;
		click = false;
	
		Wr = new String[100][100];
		Wr = my_2Darray;
		// Sets panel size
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		//COLOR = new Color(1.0F, 1.0F, 1.0F);
		 COLORED = Color.blue;
		 COLOR = new Color(1.0F, 0.725F, 0.0F);
	
		//The rectangle that the pain method draws
		rected = new Rectangle(15, 15);
		rect = new Rectangle(RECT_WIDTH, RECT_HEIGHT);
		rect.setLocation(RECT_X, RECT_Y);
	}
	public void paintComponent(Graphics g)
	{
		//Call contructer of super class
		super.paintComponent(g);
		int x = 0;
		int y = 0;
		base = 0;
		Graphics2D g1 = (Graphics2D)g;
		Graphics2D g2 = (Graphics2D)g;
		Graphics2D g3 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(4.0F));
		g3.setStroke(new BasicStroke(6.5F));
		rected.setSize(15,15);
		rect.setSize(getWidth()-7,getHeight()-7);
		rect.setLocation(7/2, 2/2);
		g1.setColor(COLOR);
		g1.draw(rect);
		g3.setColor(COLOR);
		if(click)
		{
			g3.draw(rected);
		}
		g2.setColor(COLORED);
		for(int j = 1; j < ROW; j++)
		{
			y = base + Y*j;
			for(int i = 1; i < COLLOM; i++)
			{
				x = base + X*i;
				if(Wr[i][j] == null)
				{
					g2.drawString("--", x, y);
				}
				else
				{
					g2.drawString(Wr[i][j], x, y);
				}
			}
			
		}
	}
	//Changes the default color of COLOR object.
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
		rected.setSize(10, 10);
		repaint();
	}
	public void place(int x, int y)
	{
		rect.setLocation(RECT_X, RECT_Y);
		repaint();
	}
	public static void main(String args[])
	throws java.io.IOException
	{
		String[][] Data = new String[20][20];
		for(int j = 0; j < 20; j++)
		{
			for(int i = 0; i < 20; i++)
			{
				Data [i][j] = "R" + i + " " + "C" + j;
			}
		}
	}
	protected int PANEL_HEIGHT = 400;
	protected int PANEL_WIDTH = 400;
	protected int RECT_WIDTH;
	protected int RECT_HEIGHT;
	protected int RECT_X = 100;
	protected int RECT_Y = 100;
	protected int W;
	protected int I;
	protected int base;
	protected int H;
	protected int ROW;
	protected int COLLOM;
	protected int X =  7;
	protected int Y =  7;
	protected boolean click;
	protected Color COLORED;
	protected Color COLOR;
	protected String[] Months = new String[20];
	protected String[][] Wr;
	protected Rectangle rected;
	protected Rectangle rect;
}
	
