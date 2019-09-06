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
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
import java.awt.Graphics2D;
import javax.swing.Timer;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.Calendar; 
import java.text.ParseException;
import java.util.Date.*;

/**
	This class enables data to be stored, orgenized, and retrieved to the specifications of
	the user, using the functions of the class.
*/

public class DataBase2
{
	/*containers to hold all data.*/
	private PrintWriter out_put;
	private FileWriter to_file;
	
	private FileReader from_file;
	private BufferedReader b_in;
                  private int line_num;
	private String fn;
	private String message;
	private String[] data;
	private String[] buffer;

	public DataBase2()
	throws java.io.IOException
	{
		line_num = 0;
		buffer = new String[50000];
		JFileChooser chooser = new JFileChooser();
		from_file = null;
		to_file = null;
		
		if(chooser.showOpenDialog(null) != chooser.APPROVE_OPTION)
		{
			System.exit(0);
		}
		
		File selectedFile = chooser.getSelectedFile();
		fn = selectedFile.toString();
		from_file = new FileReader(fn);
		b_in = new BufferedReader(from_file);
	}

/**
	Takes data from one of the array locations and sores it for andy type of processing
	@return number of input lines
*/
	public int obtain_data()
	throws java.io.IOException
  	 {
		int i = 0;
		int c= 0;
		int num = 0;
	       String inputLine;
	       
		while(c == 0)
		{
			inputLine = b_in.readLine();
			if(inputLine == null)break;
			
			buffer[i] = inputLine;
			i++;
			num++;
			line_num++;
		}
		b_in.close();
		buffsort(num);
		return num;
	}
	/**
		Sorts the data in the array
		@param the highet index of the array area to be sorted
	*/
	public void buffsort(int to)
	{
	  
		int p;
		int pivot;
		String temp;
		int q;
		for(q = 0; q < to -1; q++)
		{
			for(p=q+1; p < to; p++)
			{
				if(buffer[q].compareToIgnoreCase(buffer[p]) == 1 )
				{
					temp = buffer[p];
					buffer[p] = buffer[q];
					buffer[q] = temp;
				}
			}
		}
	}
	/**
		Swaps the values of two variables.
		@param a first value to be swaped
		@param secand value to be swaped
	*/
	public void swap(String a, String b)
	{
		String temp = a;
		 a = b;
		 b = temp;
	}
	
	/**
		Searches for a string with in the array called buffer.
		@param w string to be found in the array
		@param from lowest index of search area within the array
		@param highest index of search area within the array
		@return the mid point of the array search area
	*/
	public int search(String w, int from, int to)
	{
		int i = from;
		int j = to;
		int mid = (i + j)/2;
	    String pivate = buffer[from];
		String temp;
	
		if(buffer[mid].equalsIgnoreCase(w))
		{
			return mid;
		}
		 if(buffer[mid].compareToIgnoreCase(w) <= 0)
		{
			to++;
			from = mid + 1;
			if( from > to)
			{
		   		return mid;
		   	}
		}
		if(buffer[mid].compareToIgnoreCase(w) >0)
		{
			to = mid;
			if( from >= to)
			{
			      return mid;
			}
		}
		return search(w, from, to);
	}
	
	/**
		Returns the value of a given index of the array named buffer.
		@param the index of the array value to be returned
		@return the value of the given index of the array
	*/
	public String get_Item(int I)
	{
		return buffer[I];
	}
	/**
		Copies the contents of the array called buffer to a second array with corresponding indexes.
		@param s_recv array to be hold the contents of buffer
		@param len the last and highest index to be copied to the second array
	*/
	public void sync(String[] s_recv, int len)
	{
		int i;
		for(i= 0; i< len;i++)
		{
			s_recv[i] = buffer[i];
		}
	}
	public void get_data(String mess)
	 {
		 message = mess;
	 }
	 
	 /**
	 	Sends data from Vector to a text file
	 	@param Word a vector to be printed to text file
	 */
	   public void send_data(Vector<Word> m)
		throws java.io.IOException
	 {
			int count;
			from_file = new FileReader(fn);
		    b_in = new BufferedReader(from_file);
		//	int total = obtain_data();
			int k;
			
			//buffsort(total);
			if(m.size() > 0)
			{	
				Collections.sort(m);
			}
			to_file = new FileWriter(fn);
			out_put = new PrintWriter(to_file);
			for(count = 0; count < m.size(); count++)
			{
				set_message(m.get(count).get_val() + "            " + m.get(count).get_def());
				buffer[count] = message;
				//total++;
			}
			int n = 0;
			for(n = 0; n < m.size(); n++)
			{
				out_put.println(buffer[n]);
			}
			out_put.close();
			System.out.println(m.size()+ " lines\n");
		 }
		
		 /**
		 	Sets the String called message to a given String.
		 	@param the String wich message is to be set to
		 */
		public void set_message(String r)
		{
			message = r;
		}
/*This fuction goes to a location of the data array specified by the parameter, to veiew its contents*/
	public String  view_data(int ref)
	{
		//not implemented yet
		
		return null;
	}

/*The function removes the string from file with a string vaule of the parameter.*/
	public void delet(String d)
	{	
		//not implented yet
	}

}
 