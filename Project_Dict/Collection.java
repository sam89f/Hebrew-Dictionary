import java.awt.Graphics2D;
import java.awt.geom.*;

public class Collection implements Image
{
	private static final double PI = 3.14159;
	
	/*constructer with specified measers of the cube*/
	public Collection(Image aimage)
	{
		
		if(aimage instanceof Cube)
		{
			Cube c = (Cube)aimage;
	      images[0] = c;
	      a = c.a;
	      t = c.t;
			x = c.left;
			y = c.top;
			z = c.front;
		}
		if(aimage instanceof Car3d)
		{
			Car3d c = (Car3d)aimage;
	      images[0] = c;
	      a = c.a;
	      t = c.t;
			x = c.left;
			y = c.top;
			z = c.front;
		}
		if(aimage instanceof Cylinder)
		{
			Cylinder c = (Cylinder)aimage;
	      images[0] = c;
	      a = c.a;
	      t = c.t;
			x = c.left;
			y = c.top;
			z = c.front;
		}
		if(aimage instanceof Prisem)
		{
			Prisem c = (Prisem)aimage;
	      images[0] = c;
	      a = c.a;
	      t = c.t;
			x = c.left;
			y = c.top;
			z = c.front;
		}
		if(aimage instanceof Rectangle2D)
		{
			Rectangle2D c = (Rectangle2D)aimage;
	      images[0] = (Image)c;
		}
		index = 1;
	}
	
	public void add(Image next_image)
	{
		double L;
		double H;
	   if(next_image instanceof Cube)
		{
			Cube c = (Cube)next_image;
	      c.a = a;
		   c.t = t;
			c.left = (transform(300,0, c.left, c.top,c.front,  0));
		   c.top = (transform(300,0, c.left, c.top, c.front, 1));
			images[index] = c;
		}
		if(next_image instanceof Car3d)
		{
			Car3d c = (Car3d)next_image;
	      c.a = a;
		   c.t = t;
			c.left = (transform(300,0, c.left, c.top, c.front, 0));
		   c.top = (transform(300,0, c.left, c.top, c.front, 1));
			images[index] = c;
		}
		if(next_image instanceof Cylinder)
		{
			Cylinder c = (Cylinder)next_image;
	      c.a = a;
		   c.t = t;
			c.left = (transform(300,0, c.left, c.top, c.front, 0));
		   c.top = (transform(300,0, c.left, c.top, c.front, 1));
			images[index] = c;
		}
		if(next_image instanceof Prisem)
		{
			Prisem c = (Prisem)next_image;
	      c.a = a;
		   c.t = t;
			c.left = (transform(300,0, c.left, c.top, c.front, 0));
		   c.top = (transform(300,0, c.left, c.top, c.front ,1));
			images[index] = c;
		}
		if(next_image instanceof Rectangle2D)
		{
			Rectangle2D c = (Rectangle2D)next_image;
			images[index] = (Image)c;
		}
		index++;
	}

   public void draw(Image imagen, Graphics2D gg, int q)
	{
		for(int i = 0; i < index; i++)
		{
			if(images[i] instanceof Cube)
			{
				Cube c = (Cube)images[i];
				c.draw_transparent(images[i],gg,q);
			}
			if(images[i] instanceof Car3d)
			{
				Car3d c = (Car3d)images[i];
				c.draw(images[i],gg,q);
			}
			if(images[i] instanceof Cylinder)
			{
				Cylinder c = (Cylinder)images[i];
				c.draw(images[i],gg,q);
			}
			if(images[i] instanceof Prisem)
			{
				Prisem c = (Prisem)images[i];
				c.draw(images[i],gg,q);
			}
			if(images[i] instanceof Rectangle2D)
			{
				gg.draw((Rectangle2D.Double)images[i]);
			}
		}
	}
	public double toPrimeXtransform(double x_c, double y_c, double a)
	{
	   double x_prime;
		
		x_prime = x_c*Math.cos(a) + y_c*Math.sin(a);
		
		return x_prime;
	}
	public double toPrimeYtransform(double x_c, double y_c, double a)
	{
		double y_prime;
		
		y_prime = y_c*Math.cos(a) - x_c*Math.sin(a);
		
		return y_prime;
	}
	public double toCordXtransform(double x_prime, double y_prime, double a)
	{
	   double x_c;
		
		x_c = x_prime*Math.cos(a) - y_prime*Math.sin(a);
		
		return x_c;
	}
	public double toCordYtransform(double x_prime, double y_prime, double a)
	{
		double y_c;
	
		y_c = y_prime*Math.cos(a) + x_prime*Math.sin(a);
		
		return y_c;
	}
	public double toX_PrimeZtransform(double x_c, double z_c, double T)
	{
	   double x_prime;
		
		x_prime = x_c*Math.cos(T) - z_c*Math.sin(T);
		
		return x_prime;
	}
	public double toZ_PrimeZtransform(double x_c, double z_c, double T)
	{
		double z_prime;
		
		z_prime = z_c*Math.cos(T) - x_c*Math.sin(T);
		
		return z_prime;
	}
	public double transform(double x, double y,double xr, double yr, double z, int coord)
	{
		//double xx = xs[r] - x_mid;
		
		double x_mid_pp = toPrimeXtransform(xr, y-yr, a);
		double x_p = toX_PrimeZtransform(x, z, t);
		
		
			
		double x_pp = toPrimeXtransform(x_p, y-yr, a);
	
	  
	   double y_p = toPrimeYtransform(x-xr, y, a);
	
		switch(coord)
		{
		case 0: return x_pp;
		case 1: return y_p;
		}
		return -1;
	}
	private double a;
	private double t;
	private double x;
	private double y;
	private double z;
	private Shapes shape = new Shapes();
	private int capacity = 10;
	private int index = 0;
	private Image[] images = new Image[capacity];
}
