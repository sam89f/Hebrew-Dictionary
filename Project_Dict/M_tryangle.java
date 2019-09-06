import java.awt.Graphics2D;
import java.awt.geom.*;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import java.io.Console.*;
import java.math.*;
import javax.swing.*;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.Calendar; 
import java.text.ParseException;
import java.util.Date.*;
import java.awt.Dimension;

public class M_tryangle 
{
	private int A;
	
	/*constructer with specified measers of the cube*/
	public M_tryangle()
	{
		
	}
	public int start(int A)
	{
		Console console = System.console();
		int R = math(A);
		/*
		System.out.print("The Tryangle of ");
		System.out.print(A);
		System.out.print(" = ");
		System.out.println(R);
		*/
		return R;
	}
	public int egypt(int A)
	{
		Double D = new Double(A); 
		if(A == 1)
		{
			return A;
		}
		int temp = (int)(Math.pow(Math.sqrt(D) -1, 2));
	   return A + egypt(temp);
	}
	public int math(int Num)
	{
		int B = 0;
		if(Num == 1)
		{
			return Num;	
		}
		B = Num + math(Num - 1);
		return B;
	}
	public static void main(String args[])
	throws java.io.IOException
	{
		int i = 1;
		int c = 0;
	   String Continue;
	   String print;
	   c = Integer.parseInt(args[0]);
		System.out.println("***************RESAULTS***************\n");
		 M_tryangle M = new M_tryangle();
		while(i < c + 1)
		{
		 M.start(i);
		 i++;
		}
		System.out.println("\n***************PYRIMID RESAULTS***************");
	   System.out.println("\n(((((((((((((((((((((( " + M.egypt(c) + " ))))))))))))))))))))))))\n");
	}
}
