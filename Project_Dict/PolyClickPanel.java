import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;

/*This program displays a panel with a rectangle that a user can see
  along with a frame with an image and a text label*/

public class PolyClickPanel extends PolyPanel
{

	public PolyClickPanel(int w, int h)
	{
		super(w,h);
		Maximized = true;
		class PanelListener extends JFrame implements WindowListener
		{
   		public void windowClosed(WindowEvent e)
			{
				  for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowOpened(WindowEvent e) 
			{
			     for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowIconified(WindowEvent e) 
			{
				 Maximized = false;
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowDeiconified(WindowEvent e)
			{
				 Maximized = true;
				  for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowActivated(WindowEvent e)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowDeactivated(WindowEvent e)
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowClosing(WindowEvent e)
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowOpening(WindowEvent e) 
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowIconifing(WindowEvent e) 
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowDeiconifiing(WindowEvent e)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowActivating(WindowEvent e)
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowDeactivating(WindowEvent e)
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
		}
		class MouseListener2 implements MouseListener
		{
			public void mousePressed(MouseEvent event)
			{
				int x = event.getX();
				int y = event.getY();
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
			}
			public void mouseReleased(MouseEvent event)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
			}
			public void mouseClicked(MouseEvent event)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
			}
			public void mouseEntered(MouseEvent event)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
			}
			public void mouseExited(MouseEvent event)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
			}
		}
		MouseListener listener = new MouseListener2();
		addMouseListener(listener);
	}
	public PolyClickPanel()
	{
		 super();
		 Maximized = true;
		// Sets panel size
  	   PANEL_WIDTH = 100;
  	   PANEL_HEIGHT = 100;
  	   RECT_WIDTH = PANEL_WIDTH;
  	   RECT_HEIGHT = PANEL_HEIGHT;
		// Sets panel size
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		//The rectangle that the pain method draws
		rect = new Rectangle(RECT_WIDTH, RECT_HEIGHT);
		rected = new Rectangle(W, H);
		//rect.setLocation(RECT_X, RECT_Y);
		
		class PanelListener extends JFrame implements WindowListener
		{
   		public void windowClosed(WindowEvent e)
			{
				  for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowOpened(WindowEvent e) 
			{
			     for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowIconified(WindowEvent e) 
			{
				 Maximized = false;
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowDeiconified(WindowEvent e)
			{
				 Maximized = true;
				  for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowActivated(WindowEvent e)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowDeactivated(WindowEvent e)
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowClosing(WindowEvent e)
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowOpening(WindowEvent e) 
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowIconifing(WindowEvent e) 
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowDeiconifiing(WindowEvent e)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowActivating(WindowEvent e)
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
   		public void windowDeactivating(WindowEvent e)
			{
				 for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
   		}
		}
		class MouseListener2 implements MouseListener
		{
			public void mousePressed(MouseEvent event)
			{
				int x = event.getX();
				int y = event.getY();
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
			}
			public void mouseReleased(MouseEvent event)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();						
				}
			}
			public void mouseClicked(MouseEvent event)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
					repaint();		
				}
			}
			public void mouseEntered(MouseEvent event)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
					repaint();
				}				
			}
			public void mouseExited(MouseEvent event)
			{
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
					repaint();
				}	
			}
		}
		MouseListener listener = new MouseListener2();
		addMouseListener(listener);
	}
	public boolean getWinStat()
	{
		return Maximized;
	}
	public static void main(String args[])
	throws java.io.IOException
	{
	   JPanel panels = new PolyClickPanel(20, 20);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panels);
		frame.pack();
		frame.show();
	}
private boolean Maximized;
}
