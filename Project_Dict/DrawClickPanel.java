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
import java.math.*;

/*This program displays a panel with a rectangle that a user can see
  along with a frame with an image and a text label*/

public class DrawClickPanel extends DrawPanel
{
	public DrawClickPanel(int sx, int sy, String[][] my_2Darray, int m, int n, int x, int y, final Maneger Man, final String dy)
	{
		super(sx, sy, my_2Darray, m, n, x, y);
		class MouseListener2 implements MouseListener
		{
			public void mousePressed(MouseEvent event)
			{
				int x = event.getX(); 
				int y = event.getY();
				click = true;
				rected.setLocation(x-7,y-7);
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
			}
			public void mouseReleased(MouseEvent event)
			{
				click = false;
				for(int i = 0; i < 3; i++)
				{
					set_size(getWidth(),getHeight());
               repaint();		
				}
			}
			public void mouseClicked(MouseEvent event)
			{
				int x = event.getX(); 
				int y = event.getY();
				double yy = Math.round((x - base)/X);
				double xx = Math.round((y + Y/2.5 - base)/Y);
				int s = (int)xx;
				int k = (int)yy;
				rected.setLocation(x-7,y-7);
				
				if(((Wr[k][s] != null)&&(Wr[k][s] != "void"))&&((s>1)&&(s<COLLOM))&&((k>0)&&(yy<ROW+1)))
				{
					System.out.println(Wr[k][s]);
					System.out.println(event.getButton());
				
					boolean busy = Man.check(Wr[k][s] + " " + dy);
					
					if(event.getButton() == 3)
					{
						if(busy)
						{
							Man.findDay(Wr[k][s] + " " + dy).Menu(Man);
						}
					}
					else
					{
							if(event.getClickCount() > 1)
							{
									if(busy)
									{
										Man.findDay(Wr[k][s] + " " + dy).new_task(Man);
									}
									else
									{
										Man.NewTask(Wr[k][s] + " " + dy);
									}
							}
							else
							{
								Man.display(Wr[k][s] + " " + dy);
							}
					}
				}
				set_size(getWidth(),getHeight());
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
	public static void main(String args[])
	throws java.io.IOException
	{
		/*SCalendar Draw = new SCalendar("now");
		String[][] Data = new String[40][40];
		int i = 12;
		int j = 1;
		for(int j2 = 1; j2 < 8; j2++)
		{
			//Data [i][27] = Draw.Months[i][28];
			for(int i2 = 1; i2 < 5; i2++)
			{
				if(Draw.Months[i][j] == null)
				{
					Data[j2][i2] = "void";
				}
				else
				{	
					Data [j2][i2] = Draw.Months[i][j];
				}
				j++;
			}
		}
			j = 28;
			for(int j2 = 1; j2 < 5; j2 ++)
			{
				int i2 = 5;
				if(Draw.Months[i][j] == null)
				{
					Data[j2][i2] = "void";
				}
				else
				{	
					Data [j2][i2] = Draw.Months[i][j];
				}
				j++;
			}
	   JFrame frame = new JFrame();
		frame.setSize(new Dimension(1000, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	   DrawPanel Dpanel = new DrawClickPanel(700, 700, Data, 8, 6, 90, 20);
		Dpanel.setLayout(new GridLayout(1,1));
		frame.setContentPane(Dpanel);
		frame.pack();
		frame.show();*/
	}
private boolean Maximized;
protected  String year;

}
