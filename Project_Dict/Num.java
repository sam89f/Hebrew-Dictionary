public class Num
{
	 private double a;
	 private double b;
	 private double c;
	 private double ai;
	 private double bi;
	 private double ci;
	 private int count;
	 private boolean ready;
	 private int index;
	 private Num [] Mem;
	public Num()
	{
		ready = false;
		count = 20;
		ai = 1000;
		bi = 10;
		ci = 9;
		a = ai;
		b = bi;
		c = ci;
		
	}
	public void IN(double x, double y, double z)
	{
		Mem =  new Num[count];
		ready = false;
		index = 0;
		ai = x;
		bi = y;
		ci = z;
		a = x;
		b = y;
		c = z;
		Mem[index] = new Num();
		 update();
	}
	public void update()
	{
		Mem[index] = new Num();
		Mem[index].a = delA();
		Mem[index].b = delB();
		Mem[index].c = delC();
		
		if(index == count-1)
		{
			index = 0;
			Mem[index] = new Num();
			ready = true;
		}
		else{
			index ++;
		}
	}
	public double getAvrg()
	{
		double acc = 0;
		if(ready)
		{
			int start = index;
			int end = index - 1;
			if(index == 0)
			{
				end = count-1;
			}
			acc = (Mem[end].b - Mem[start].b)/count;
			return acc;
		}
		acc = (Mem[index  - 1].b - Mem[0].b)/index;
		return acc;
	}
	public double getTimes()
	{
		double acc = 0;
		if(ready)
		{
			int start = index;
			int end = index - 1;
			if(index == 0)
			{
				end = count-1;
			}
			acc = Mem[end].c;
			return acc;
		}
		return acc;
	}
	public double Ai()
	{
		return(ai);
	}
	public double delA()
	{
		return(a-ai);
	}
	public double delB()
	{
		return(b-bi);
	}
	public double delC()
	{
		return(c-ci);
	}
	public double getA()
	{
		return(a);
	}
	public double getB()
	{
		return(b);
	}
	public double getC()
	{
		return(c);
	}
	public void setA(double s)
	{
		a = s;
	}
	public void setB(double s)
	{
		b= s;
	}
	public void setC(double s)
	{
		c = s;
		update();
	}
	public double ratio()
	{
		if(c == ci)
		{
			return 1;	
		}
		double r = (b-bi)/(c-ci);
		return r;
	}
}