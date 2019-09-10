import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
//package events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PolyFrame extends JFrame implements WindowListener
{
	public PolyFrame(JPanel p)
	{
		//the panel that draws the rectangle
		recpanel = (PolyPanel)p;
		recpanel.setLayout(new GridLayout(4, 4));
		setSize(new Dimension(100, 100));
		addWindowListener(this);
		getContentPane().add(recpanel);
	}
	public PolyFrame()
	{
		recpanel = new PolyPanel();
		//the panel that draws the rectangle
		recpanel.setLayout(new GridLayout(4, 4));
		setSize(new Dimension(100, 100));
		addWindowListener(this);
		getContentPane().add(recpanel);
	}
   public void windowClosed(WindowEvent e)
	{
		  recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       //This will only be seen on standard output.
       System.out.println("WindowListener method called: windowClosed.");
		 recpanel.repaint();
   }

   public void windowOpened(WindowEvent e) 
	{
	     setSize(new Dimension(300, 300));
		  recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
        System.out.println("WindowListener method called: windowOpened.");
		  recpanel.repaint();
   }

   public void windowIconified(WindowEvent e) 
	{
		  recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
        System.out.println("WindowListener method called: windowIconified.");
		  recpanel.repaint();
   }

   public void windowDeiconified(WindowEvent e)
	{
		   recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
        System.out.println("WindowListener method called: windowDeiconified.");
		  recpanel.repaint();
   }
   public void windowActivated(WindowEvent e)
	{
		 recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       //System.out.println("WindowListener method called: windowActivated.");
		 recpanel.repaint();
   }

   public void windowDeactivated(WindowEvent e)
	{
		 recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       System.out.println("WindowListener method called: windowDeactivated.");
		 recpanel.repaint();
   }
   public void windowClosing(WindowEvent e)
	{
		 recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       //This will only be seen on standard output.
       System.out.println("WindowListener method called: windowClosing.");
		 recpanel.repaint();
   }

   public void windowOpening(WindowEvent e) 
	{
		 recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       //System.out.println("WindowListener method called: windowOpening.");
		 recpanel.repaint();
   }

   public void windowIconifing(WindowEvent e) 
	{
		 recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       System.out.println("WindowListener method called: windowIconifiing.");
		 recpanel.repaint();
   }

   public void windowDeiconifiing(WindowEvent e)
	{
		 recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       System.out.println("WindowListener method called: windowDeiconifiing.");
		 recpanel.repaint();
   }
   public void windowActivating(WindowEvent e)
	{
		 recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       System.out.println("WindowListener method called: windowActivating.");
		 recpanel.repaint();
   }

   public void windowDeactivating(WindowEvent e)
	{
		 recpanel.set_size(recpanel.getWidth(), recpanel.getHeight());
       System.out.println("WindowListener method called: windowDeactivating.");
		 recpanel.repaint();
   }
	public static void main(String args[])
	throws java.io.IOException
	{
		PolyFrame frame = new PolyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.show();
	}
protected PolyPanel recpanel;

}
