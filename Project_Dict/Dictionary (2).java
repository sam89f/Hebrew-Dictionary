import java.io.IOException;
import java.io.*;import java.util.*;
import java.awt.*;
import java.awt.Graphics2D;
import javax.swing.*;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
import java.text.*;
import java.util.Calendar; 
import java.text.ParseException;
import java.util.Date.*;
import java.io.Console.*;
import java.math.*;

public class Dictionary
{
	private String vowels;
	private String cantillation;
	private boolean Aramaic;
	private double infinity;
	private DataBase2 test;
	private int tot;
	private int spr_size;
	private int T_Capacity = 200;
	private int[] Sefar;
	private double WALL;
	private double [] Cpys;
	private double [] Hits;
	private JFrame frame;
	private String[] ABet;
	private static final Weight W = new Weight();
	private JLabel in_label;
	private M_triangle Try = new M_triangle();
	private PolyClickPanel bPanel;
	private PolyClickPanel keyPanel;
	private JFrame sFrame;
	private JFrame bFrame;
	private JFrame keyFrame;
	private JTextField textField;
	private JFrame inpt_frame;
	private JLabel bLabel;
	private JScrollPane scrollBar;
	private JLabel sLabel;
	private JLabel aLabel;
	private JTextArea textArea;
   	private AlefBet Alef;
	private PolyClickPanel panel;
	protected static Vector<Word> data_map = new Vector<Word>();
   	public Dictionary()
	throws java.io.IOException
	{           
		infinity =  2120000000;
		vowels = "ֽׁ  ֱ ׂ ַ  ֲ [ ] ַ  ָ    ( )  ֳ ";
		cantillation = " ׀  ֽ ׃";
		Aramaic = false;
		W.Int();
		WALL = 1/(Math.exp(8));
		System.out.println("W.MEM = " + W.Mem.getA() + "\n");
	
		Sefar = new int[T_Capacity];
		Hits = new double[(200)];
		Cpys = new double[(200)];
		spr_size = 0;
		ABet = new String[28];
		 
		 ABet [0] = " 0";
		 ABet[1] = "א";
		 ABet [2] = "ב";
		 ABet[3] = "ג";
		 ABet [4] = "ד";
		 ABet[5] = "ה";
		 ABet [6] = "ו";
		 ABet[7] = "ז";
		 ABet [8] = "ח";
		 ABet[9] = "ט";
		 ABet [10] = "י";
		 ABet[11] = "כ";
		 ABet [12] = "ל";
		 ABet[13] = "מ";
		 ABet [14] = "נ";
		 ABet[15] = "ס";
		 ABet [16] = "ע";
		 ABet[17] = "פ";
		 ABet [18] = "צ";
		 ABet[19] = "ק";
		 ABet [20] = "ר";
		 ABet[21] = "ש";
		 ABet [22] = "ת";
		 ABet[23] = "ך";
		 ABet [24] = "ם";
		 ABet[25] = "ן";
		 ABet [26] = "ף";
		 ABet[27] = "ץ";
		 
		 keyPanel = new PolyClickPanel();
		 keyPanel.setLayout(new GridLayout(4, 10));
		 panel = new PolyClickPanel();
		 keyPanel.setFont(new Font("Cardo", Font.PLAIN, 17));
		 textField = new JTextField(12);
		 textField.setFont(new Font("Serif", Font.BOLD, 18));
		 keyFrame = new JFrame();
		 keyFrame.setTitle( "Hebrew Dictionary Keypad");
		 inpt_frame = new JFrame();
	    	 inpt_frame.setTitle( "Enter Word");
		 panel.add(textField);
		 in_label = new JLabel("Enter Word");
		 inpt_frame.add(in_label);
		 inpt_frame.setContentPane(panel);
		 bPanel = new PolyClickPanel();
		 bFrame = new JFrame();
		 bFrame.setTitle( "Hebrew Dictionary Menu");
		 sFrame = new JFrame();
		 frame = new JFrame();
		 textArea = new JTextArea(15,75);
		 textArea.setFont(new Font("Cardo", Font.PLAIN, 17));
		 textArea.setEditable(false);
		 JLabel label =  new JLabel("Dictionary");
		 JLabel f_label = new JLabel("Hebrew Dictionary");
		 scrollBar = new JScrollPane(textArea);
		 
		 JLabel klabel = new JLabel("Key Board");
		 keyPanel.add(keyboardButton("ק", "ק"));
		 keyPanel.add(keyboardButton("ש", "ש"));
		 keyPanel.add(keyboardButton("ר", "ר"));
		 keyPanel.add(keyboardButton("ט", "ט"));
		 keyPanel.add(keyboardButton("י", "י"));
		 keyPanel.add(keyboardButton("ע", "ע"));
		 keyPanel.add(keyboardButton("ם", "ם"));
		 keyPanel.add(keyboardButton("פ", "פ"));
		 keyPanel.add(keyboardButton("ים", "ים"));
		 keyPanel.add(keyboardButton("צ", "צ"));
		  
		 
		 keyPanel.add(keyboardButton("א", "א"));
		 keyPanel.add(keyboardButton("ס", "ס"));
		 keyPanel.add(keyboardButton("ד", "ד"));
		 keyPanel.add(keyboardButton("ג", "ג"));
		 keyPanel.add(keyboardButton("ה", "ה"));
		 keyPanel.add(keyboardButton("ת", "ת"));
		 keyPanel.add(keyboardButton("ל", "ל"));
		 keyPanel.add(keyboardButton("ך", "ך"));
		 keyPanel.add(keyboardButton("ף", "ף"));
		 keyPanel.add(keyboardButton("\"", "\""));
		
		  
		 keyPanel.add(keyboardButton("ז", "ז"));
		 keyPanel.add(keyboardButton("ח", "ח"));
		 keyPanel.add(keyboardButton("כ", "כ"));
		 keyPanel.add(keyboardButton("ו", "ו"));
		 keyPanel.add(keyboardButton("ב", "ב"));
		 keyPanel.add(keyboardButton("נ", "נ"));
		 keyPanel.add(keyboardButton("מ", "מ"));
		 keyPanel.add(keyboardButton("ן", "ן"));
		 keyPanel.add(keyboardButton("ות", "ות"));
		 keyPanel.add(keyboardButton("ץ", "ץ"));
		  
		  keyPanel.add(keyboardButton("BkSp", "0BkSp"));
		  keyPanel.add(keyboardButton("BkWd", "0BkWd"));
		  keyPanel.add(keyboardButton("Clear", "0clear"));
		  keyPanel.add(keyboardButton( "RevWd", "0rev"));
		  keyPanel.add(keyboardButton( "^", "0U"));
		  keyPanel.add(keyboardButton("RevChr", "0RevChr"));
		  keyPanel.add(keyboardButton("Space", " "));
		  keyPanel.add(keyboardButton("-- ...", "0--"));
		  keyPanel.add(keyboardButton("-", "-"));
		  keyPanel.add(keyboardButton("\'", "\'"));
		  
		 keyFrame.setContentPane(keyPanel);
		 keyFrame.pack();
		 keyFrame.show();
		test = new DataBase2();
		get_book();
   	}
   	
   	/**
   		Returns the total number of lines in the text file holding the data.
   		@return the total number of lines in the test file
   	*/
	public int get_total()
	{
		return tot;
	}
	
	/**
		Returns the DataBase2 object called test
		@return the DataBase2 object test to be returned
	*/
	public DataBase2 get_dat()
	{
		return test;
	}
	
	/**
		Uploads data from a text file and stores it in the Vector called data_map.
	*/
	public void get_book()
	throws java.io.IOException
	{
		tot = test.obtain_data();
		String[] buff = new String[tot+1];
		test.sync(buff, tot);
		int lines;
		for(lines = 0; lines < tot; lines++)
		{
			int i;
			String S = null;
			String G = null;
			String ts = null;
			String cs = null;
			char prvs =' ';
			char prv = ' ';
			for(i = 0; i < buff[lines].length(); i++)
			{
			   	char c = buff[lines].charAt(i);
				if(c == ' ')break;
			  	ts = S;
			  	if(i == 1)
			  	{
                    if(prv == ' ')
			        {
				     	S = ("" + c);
					}
					else{
				     	S = ("" + prv + c); 
					}
			  	}
			  	if(i>1)
			  	{
					S = (ts + c).toString(); 
			  	}
			  	prv = c;
		 	}
		 	int next;
	    		for(next = (i + 11); next < buff[lines].length(); next++)
	    		{
	       			char t = buff[lines].charAt(next);
	    	 		cs = G;
	    	 		if(next == (i + 11 +  1))
	    	 		{
					if(prvs == ' ')
					{
			    			G = ("" + t).toString();
			 		}
					else{
	    	 	   			G = ("" + prvs + t).toString();
					}
	    	 		}
	    	 		if(next > (i + 11 + 1))
	    	 		{
	    	 			G = ("" + cs + t).toString();
	    	 		}
	    		}
	    		data_map.add(new Word(S, G));
	    }
		if(data_map.size() > 0)
		{
			Collections.sort(data_map);
	   	}
	}
	public String no_space(String def)
	throws java.io.IOException
	{
	   int s = 0;
	   int n = 0;
	   String ndef = "";
	   while((s < 3)&&(n<def.length()))
	   {
	      if(def.substring(n, n + 1) == " ")
	      {
	        s++; 
	      }
	      else{
	         s = 0;
	      }
	      n++;
	   }
	     ndef = def.substring(0,n-s);
                      return ndef;
	}
	public void edit_word()
	throws java.io.IOException
	{
		String mess = null;
		JButton editButton = new JButton("Edit");
		   class EditButtonListener implements ActionListener
		   {
		   	   public void actionPerformed(ActionEvent event)
		   	   {
		   	   	   try{
		   	   	   	    String input = textField.getText();
		   	   	   	   input = PointHandler(input);
		   	   	   	   int pos = test.search(input, 0, tot);
		   	   	   	   if((input.equals(""))||(!(data_map.get(pos).get_val().equalsIgnoreCase(input))))
		   	   	   	   {
		   	   	   	   	   return;
		   	   	   	   }
		   	   	   	   String input_def = "";
		   	   	   	   while(input_def.equals(""))
		   	   	   	   {
							input_def = JOptionPane.showInputDialog("Enter definition of word.:");
							if(input_def == null)
							{
									return;
							}
		   	   	  	   }
		   	   	   	   
		   	   	   	   String value = data_map.get(pos).get_val();
		   	   	   	   data_map.remove(pos);
		   	   	   	   if((input_def !="null")&&(input_def!=""))
		   	   	   	   {
		   	   	   	   	   StringTokenizer tokens = new StringTokenizer(input_def, "  ");
		   	   	   	   	   String [] temps;
		   	   	   	   	   temps = new String[500];
		   	   	   	   	   int k = 0;
		   	   	   	   	   while(tokens.hasMoreTokens())
		   	   	   	   	   {
		   	   	   	   	   	   String token = tokens.nextToken();
		   	   	   	   	   	   temps[k] = token;
		   	   	   	   	   	   k++;
		   	   	   	   	   }
		   	   	   	   	   input_def = "";
		   	   	   	   	   for(int i = 0; i < k-1; i++)
		   	   	   	   	   {
		   	   	   	   	   	input_def = input_def + temps[i] + " ";	   
		   	   	   	   	   }
		   	   	   	   	   input_def = input_def + temps[k-1];
		   	   	   	   	   Word thing = new Word(value, input_def);
		   	   	   	   	   data_map.add(thing);
		   	   	   	   	   Collections.sort(data_map);
		   	   	   	   }
		   	   	   	   test.send_data(data_map);
		   	   	   }
		   	   	   catch(IOException e)
		   	   	   {
		   	   	   	   System.out.println("Error occurred while trying to edit word.");
		   	   	   }
		   	   }
		   };
			ActionListener editlistener = new EditButtonListener();
			editButton .addActionListener(editlistener);
		
			JButton closeButton =new JButton("Close");
			class CloseButtonListener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{
					inpt_frame.dispose();
					inpt_frame = new JFrame();
					inpt_frame.add(in_label);
					panel = new PolyClickPanel();
					panel.add(textField);
					inpt_frame.setContentPane(panel);
					inpt_frame.add(in_label);
				}
		   };
		   ActionListener closelistener = new CloseButtonListener();
		   closeButton.addActionListener(closelistener);
		  
		   inpt_frame.add(editButton);
		   inpt_frame.pack();
		   inpt_frame.show();
		   return;
	}
	public void delete_word()
	throws java.io.IOException
	{
		String mess = null;
		JButton deleteButton = new JButton("Delete");
		class DeleteButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				try{
					String input = textField.getText();
				        input = PointHandler(input);
					int pos = test.search(input, 0, tot);
					int i = pos;
 					if((input.equals(""))||(!(data_map.get(pos).get_val().equalsIgnoreCase(input))))
					{
						return;
					}
					String value = data_map.get(pos).get_val();
					 data_map.remove(pos);
				         test.send_data(data_map);
				}
				catch(IOException e)
				{
					System.out.println("Error occurred while trying to delete word.");
				}
			}
		};
		ActionListener deletelistener = new DeleteButtonListener();
		deleteButton .addActionListener(deletelistener);
		inpt_frame.add(deleteButton);
		inpt_frame.pack();
		inpt_frame.show();
		return;
	}
	public void add_words()
	throws java.io.IOException
	{
	     String mess = null;
	     JButton putwButton = new JButton("Add");
	     class PutwButtonListener implements ActionListener
	     {
				public void actionPerformed(ActionEvent event)
				{
				try{
				String input = textField.getText();
				input = PointHandler(input);
				int pos = test.search(input, 0, tot);
				if((input.equals(""))||((data_map.get(pos).get_val().equals(input)))||(input.length()<= 1))
				{
						return;
				}
				String input_def = "";
				
				while(input_def.equals(""))
				{	
					input_def = JOptionPane.showInputDialog("Enter definition of word.:");
					if(input_def == null)
					{
						return;
					}
				}
		
				StringTokenizer tokens = new StringTokenizer(input_def, "  ");
				String [] temps;
				temps = new String[500];
				int k = 0;
				while(tokens.hasMoreTokens())
				{
					String token = tokens.nextToken();
					temps[k] = token;
					k++;
				}
				input_def = "";
				for(int i = 0; i < k-1; i++)
				{
					input_def = input_def + temps[i] + " ";	   
				}
				input_def = input_def + temps[k-1];
				Word thing = new Word(input, input_def);
				data_map.add(thing);	
				test.send_data(data_map);
				} 
				catch(IOException e)
				{
				System.out.println("Error occurred while trying to add new word.");
			     }
		     }
	     };
	     ActionListener putwlistener = new PutwButtonListener();
	     putwButton .addActionListener(putwlistener);
		 
	     JButton closeButton =new JButton("Close");
 	     class CloseButtonListener implements ActionListener
	     {
	         public void actionPerformed(ActionEvent event)
	         {
	             inpt_frame.dispose();
	             inpt_frame = new JFrame();
	             panel = new PolyClickPanel();
	             panel.add(textField);
                               inpt_frame.setContentPane(panel);
	             inpt_frame.add(in_label);
	         }
	      };
	      ActionListener closelistener = new CloseButtonListener();
	      closeButton.addActionListener(closelistener);  
	     inpt_frame.add(putwButton);
                       inpt_frame.pack();
	     inpt_frame.show();
	     return;
	}
	public int rank(String c)
	{
		int l = c.length();
		int g = 0;
		g = new_gematria(c);
		
		if(g >= 100)
		{
			return 3;
		}
		if(g >= 10)
		{
			return 2;
		}
		return 1;
	}
	
	/**
		Removes any character not useful to the program which may be with in a word.
		@param the word to be checked for un-useful characters
		@return the word without the un-useful characters
	*/
	public String gCut(String quote)
	{
		int B = quote.length();
		if(B < 1)
		{
			return "";	
		}
		int l = quote.length();
		int r = 0;
		int y = 1;
		while(r < l)
		{ 
			if((quote.charAt(r) == '״')||(quote.charAt(r) == '\"')||(quote.charAt(r) == '׳')||(quote.charAt(r) == ':')||(quote.charAt(r) == '\'')||(quote.charAt(r) == '”')||(quote.charAt(r) == '’')||(quote.charAt(r) == ',')||(quote.charAt(r) == ';')||(quote.charAt(r) == '*')||(quote.charAt(r) == '!')||(quote.charAt(r) == '?')||(quote.charAt(r) == '.'))
			{
				if(quote.charAt(r) == '”')
				{
					y = 2;
				}
				quote = quote.substring(0, r) + quote.substring(r+1, l);
				l--;
			}
			r++;
		}
		return quote;
	}
	
	/**
		Check to see if a String is a number in Hebrew
		@param the String to be determined to be a number or not
		@return negative one if it is not a number, and the prefix of the number if it is a number
	*/
	public int IsNumber(String num)
	{
		int l = num.length();
		int r = 0;
		int y = 1;
		if(l > 3)
		{	
			if((num.substring(0, 2).equals("ד'"))||num.substring(0, 2).equals("ה'")||(num.substring(0, 2).equals("ג'")))
			{
				if(num.substring(0, 2).equals("ג'"))
				{
					y = 3;
				}
				if(num.substring(0, 2).equals("ד'"))
				{
					y = 4;
				}
				if(num.substring(0, 2).equals("ה'"))
				{
					y = 5;
				}
				num = num.substring(2);
			}
			else
			{
				if((num.substring(1, 2).equals("'"))||num.substring(1, 2).equals("'"))
				{
					num = num.substring(2);
					return 6;
				}
				if(l > 3)
				{
					if((num.substring(0, 1).equals("ה"))||num.substring(0, 1).equals("ו"))
					{
						num = num.substring(1);	
					}
				}
			}
		}
		l = num.length();
		if(num.equals("טו")||num.equals("טז"))
		{
			return y;
		}
		while(r < l)
		{ 
			if(r < l-1)
			{
				if((num.substring(r, r+1).equals("י"))&&(num.substring(r+1, r+2).equals("ה")||num.substring(r+1, r+2).equals("ו")))
				{
					return -1;
				}
			}
			if((num.charAt(r) == 'ך')||(num.charAt(r) == 'ם')||(num.charAt(r) == 'ן')||(num.charAt(r) == 'ף')||(num.charAt(r) == 'ץ'))
			{
				return - 1;	
			}
			if((num.charAt(r) == '״')||(num.charAt(r) == '\"')||(num.charAt(r) == '׳')||(num.charAt(r) == '”')||(num.charAt(r) == '\''))
			{
				if(num.charAt(r) == '”')
				{
					y = 2;
				}
				num = num.substring(0, r) + num.substring(r+1, l);
				l--;
			}
			r++;
		}
		if(num.equals("טו")||num.equals("טז"))
		{
			return y;
		}
		for(int i = l-1; i > 0; i--)
		{ 
			if(new_gematria(num.substring(i, i+1)) > new_gematria(num.substring(i-1, i)))
			{
				return -1;
			}
			if(rank(num.substring(i, i+1)) > rank(num.substring(i-1, i)))
			{
				return -1;
			}
		    if(rank(num.substring(i, i+1)) < 3)
		    {
		        if(i >= 2)
		        {
		         	if((num.substring(i-1, i+1).equals("טו")||num.substring(i-1, i+1).equals("טז"))&&(rank(num.substring(i-2,i-1)) < 3))
		         	{
		         		return -1;
		         	}
		        }
		        if(rank(num.substring(i, i+1)) >= rank(num.substring(i-1,i))&&(!num.substring(i-1, i+1).equals("טו")&&!num.substring(i-1, i+1).equals("טז"))) 
		        {
		         	return -1;
		        }
		    }
		}
		return y;
	}
	public void sTok(String input, int in)
	{
		String [] temps; //array to hold tokens from input string
		temps = new String[500]; //while loop below must thus limit the number of tokes to no more the 500 (the size of this array)
		int end = input.length();
		int gen = end -1;
		int sing = gen -1;
		int k = 0; //sets the initial number of tokens to zero
		boolean q = true;
		int old_end = end;
		input = gCut(input);
		end = input.length();
		if(end < old_end)
		{
			q = false;
		}
		//input  = gTok(input, num, " # ");
		StringTokenizer tokens = new StringTokenizer(input, "-  "); //defines tokens
		//add parshed tokens to temps array until there are no more tokens
		while ((tokens.hasMoreTokens())&&(k<500))
		{
			String token = tokens.nextToken(); //gets the next token
			temps[k] = token; //sores the token in the kth (actually the k+1th) index of the temps array
			k++; //keeps track of successive array indexes, and size of the array which is equal to the total number of tokens (produced from this loop)
		}
		
		if((k < 2)&&(q))
		{
			return;	//if number ot tokes is less then two and q is true (end >= old_end) then function is of no use and thus terminates
		}
		textArea.append( "\n"); //formats textArea
		String temp2;
		if(k>1) //if multible tokens, then proceed
		{
			for(int i =  0; i < k; i++)
			{
				String link = temps[i]; //initializes link to the ith token before entering next loop
				String buff = link;
				String rbuff = temps[i];
				int m = 0;
				for(int j = 1; j < k - i; j++)
				{
					int e = link.length();
					boolean c = false;
					int Tm = 0;
					if((e>1)&&(temps[i+j].length()> 0)) //gaurds against potential buffer over flows
					{
						if((link + "-" + temps[i+j]).length() < input.length())
						{
							if(checkW(link + "-" + temps[i+j]) == 1) //checks to see if phrase is found
							{
								c = true;
								link = link + "-" + temps[i+j]; //if so, then set link to phrase
							}
							else
							{ 	
								if((e>1)&&(temps[i+j].length()>1))
								{
									if((checkW(link + "-" + temps[i+j].substring(0, 1)) == 1)&&(checkW(temps[i+j]) == 0))
									{
										c = true;
										m ++;
										Tm ++;
										link = link + "-" + temps[i+j].substring(0, 1);				
									}
								}
								if(c == false)
								{
									if(link.substring(0,1).equals("ו"))
									{
										if(checkW(link.substring(1) + "-" + temps[i+j].substring(0, 1)) == 1)
										{
											c = true;
											m ++;
											Tm ++;
											link = link + "-" + temps[i+j].substring(0, 1);
										}	
									}	
								}
								if((e>2)&&(temps[i+j].length()>1))
								{
									if((checkW(link.substring(1) + "-" + temps[i+j])==1)&&(gutteral2(link) == 1))
									{
										c = true;
										link = link + "-" + temps[i+j];
									}
								}
								if((e>2)&&(temps[i+j].length()>2))
								{
									if((checkW(link.substring(1) + "-" + temps[i+j].substring(1))==1)&&(gutteral2(link) == 1)&&(gutteral2_c(temps[i+j]) == 1))
									{
										c = true;
										link = link + "-" + temps[i+j].substring(1);
									}
								}
								if((e>1)&&(temps[i+j].length()>2))
								{
									if((checkW(link + "-" + temps[i+j].substring(1))==1)&&(gutteral2_c(temps[i+j]) == 1))
									{
										c = true;
										link= link + "-" + temps[i+j].substring(1);
									}
								}
								if((e>2)&&(temps[i+j].length()>2))
								{
									if((checkW(finalf(link.substring(0, e-1))  + "-" + finalf(temps[i+j].substring(0,temps[i+j].length()-1)))==1)&&(gutteral_b(link) > 1)&&(gutteral_c(temps[i+j]) > 1))
									{
										c = true;
										link = finalf(link.substring(0, e-1))   + "-" + temps[i+j];
									}
									if((checkW(finalf(link.substring(0, e-1))  + "-" + finalf(temps[i+j].substring(1,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral_b(link) > 1)&&(gutteral_c(temps[i+j]) == 3))
									{
										c = true;
										link = finalf(link.substring(0, e-1))  + "-" + temps[i+j].substring(1);
									}
									if((checkW(finalf(link.substring(1, e-1))  + "-" + finalf(temps[i+j].substring(0,temps[i+j].length()-1)))==1)&&(gutteral_b(link) == 3)&&(gutteral_c(temps[i+j]) > 1))
									{
										c = true;
										link = finalf(link.substring(0, e-1))  + "-" + temps[i+j];
									}
									if((checkW(finalf(link.substring(1, e-1))  + "-" + finalf(temps[i+j].substring(1,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral_b(link) == 3)&&(gutteral_c(temps[i+j]) == 3))
									{
										c = true;
										link = finalf(link.substring(0, e-1))  + "-" + temps[i+j].substring(1);
									}
									if((checkW(finalf(link.substring(0, e-1))  + "-" + temps[i+j].substring(1))==1)&&(gutteral_b(link) > 1)&&(gutteral2_c(temps[i+j]) == 1))
									{
										c = true;
										link = finalf(link.substring(0, e-1))  + "-" +temps[i+j].substring(1);
									}
									if((checkW(link.substring(1)  + "-" + finalf(temps[i+j].substring(0,temps[i+j].length()-1)))==1)&&(gutteral2(link) == 1)&&(gutteral_c(temps[i+j]) > 1))
									{
										c = true;
										link = link  + "-" + temps[i+j];
									}
									if((checkW(finalf(link.substring(1, e-1)) + "-" + temps[i+j].substring(1))==1)&&(c == false)&&(gutteral_b(link) == 3)&&(gutteral2_c(temps[i+j]) == 1))
									{
										c = true;
										link= finalf(link.substring(0, e-1)) + "-" + temps[i+j].substring(1);
									}
									if((checkW(link.substring(1) + "-" + finalf(temps[i+j].substring(1,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral2(link) == 1)&&(gutteral_c(temps[i+j]) == 3))
									{
										c = true;
										link = link + "-" + temps[i+j].substring(1);
									}
								}
								if((e>1)&&(temps[i+j].length()>2))
								{
									if((checkW(link + "-" + finalf(temps[i+j].substring(1,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral_c(temps[i+j]) == 3))
									{
										c = true;
										link= link + "-" + temps[i+j].substring(1);
									}
								}
								if((e>2)&&(temps[i+j].length()>1))
								{
									if((checkW(finalf(link.substring(1, e-1)) + "-" + temps[i+j])==1)&&(c == false)&&(gutteral_b(link) == 3))
									{
										c = true;
										link= finalf(link.substring(0, e-1)) + "-" + temps[i+j];
									}
								}
								if((e>1)&&(temps[i+j].length()>2))
								{
									if((checkW(link + "-" + finalf(temps[i+j].substring(0,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral_c(temps[i+j]) > 1))
									{
										c = true;
										link= link + "-" + temps[i+j];
									}
								}
								if((e>2)&&(temps[i+j].length()>1))
								{
									if((checkW(finalf(link.substring(0, e-1)) + "-" + temps[i+j])==1)&&(c == false)&&(gutteral_b(link) > 1))
									{
										c = true;
										link= finalf(link.substring(0, e-1)) + "-" + temps[i+j];
									}
									if((checkW(finalf(link.substring(1, e-1)) + "-" + temps[i+j])==1)&&(c == false)&&(gutteral_b(link) == 3))
									{
										c = true;
										link= finalf(link.substring(0, e-1)) + "-" + temps[i+j];
									}
								}
							}
						}
					} 
					//**************************************************************************************
					
					if(c == false) //if there is no match
					{
						buff = link + "-" + temps[i+j].substring(0, 1); //save to buff for potential construct
						rbuff = temps[i + j];
						link = link + "-" + temps[i+j]; //add current temps index (i + j) to link, to check for larger phrases
					}
					else  //if there is a match,
					{
						buff = link; //just set buff to link again
						if(m  >  0) //if there are constructs found
						{
							if(((checkW(link)==1)||(checkW(link.substring(1))==1)||(checkW(finalf(link.substring(0, link.length()-1)))==1)||(checkW(finalf(link.substring(1,link.length()-1)))==1))&&((link).length() < input.length()))
							{
								temps[i] = link; //stores the whole phrase in current array index, i;
								for(int t = i + 1; t < k - (j - m); t++)
								{
									temps[t] = temps[t + (j - m)];
								}
								k = k - (j - m); //thus the array is only reduced by (j - m)
								j = m;
							}	
						}
						else
						{
							if(((checkW(link)==1)||(checkW(link.substring(1))==1)||(checkW(finalf(link.substring(0, link.length()-1)))==1)||(checkW(finalf(link.substring(1,link.length()-1)))==1))&&((link).length() < input.length()))
							{
								temps[i] = link; //stores the whole phrase in current array index, i;
								for(int t = i + 1;t < k - j; t++) //shifts the remaining entries up (closer to i), to close the gap
								{
									temps[t] = temps[t+j];
								}
								k = k - j; //thus the array is reduced by j
								j = 0; //and thus the reference is brought down to one, because of of the subtraction from temps
							}
						}
					}
				} 
			}//******************************************************* end of k loop
		}
		
		for(int n = 0; n < k; n++)
		{
			temp2 = temps[n];
			spr_size = 0;
			Sefar = new int[T_Capacity];
			Hits = new double[(200)];
			Cpys = new double[(200)];
			temp2 = finalf(temps[n]);
			if(tablew(temp2)==1)
			{
				Hits[0] += 2120000000;
			}
			if(temp2.length() > 1)
			{
			 	find_root(temp2);
			}
			System.out.println("   " +  spr_size + " words found \n");	
			
			order();
			for(int w = 0; w < in; w++)
			{
				textArea.append("           ");
			}
			textArea.append("           - " +temp2 + "\n");
			
			for(int i = 0; i < spr_size; i++)
			{
			input = temp2;
			int pos = Sefar[i];
			int g = gematria(pos);
			int tri = Try.start(g);                   
			for(int w = 0; w < in; w++)
			{
				textArea.append("           ");
			}
			textArea.append(test.get_Item(pos)+ "; " +  "  gemetria: " + g + ",   triangle: " + tri + "\n");
			}
			spr_size = 0;
			sTok(temp2, in + 1);
		}	 
	}
	public boolean Cosnt(String c)
	{
	
		return false;
	}
	public int nTok(String input)
	{
		String [] temps;
		temps = new String[500];
		StringTokenizer tokens = new StringTokenizer(input, ", : ; . ( ) ? ! [ ]  ּ  ׳ ` / { } ־ - — ");
		int k = 0;
		while ((tokens.hasMoreTokens())&&(k<500))
		{
			String token = tokens.nextToken();
			temps[k] = token;
			k++;
		}
		return k;	
	}
	public String PointHandler(String token)
	{
		String fwd = "";
		String vaw = "ֹ ֻ  ֹ ֹ  ֹ ";
		String yod = "ִ";
		String sgl = "ְ ֶ ֵ";
		String hey = "ָ";
		String degish = "ּ";
		String col = "’"; 
		String com = "'"; 
		String col2 = "״\"\'”";
		String num = "0123456789";
		int end2 = token.length();
		int gen2 = end2 -1;
		int sing2 = gen2 -1;
		token = VwTok(token, vowels, ""); 
		token = gTok(token, "״", "\"");
		token = gTok(token, col, com);
		token = gTok(token, vaw, "ו");
		token = gTok(token,"װ", "ו");
		token  = gTok(token, yod, "י");
		token  = gTok(token, degish, "");
		token  = gTok(token, sgl, "");
		if(token.length() > 2)
		{
			if(token .substring(0, 2).equals("וו"))
			{
				token = token .substring(1);	
			}
		}	
		return token;
	}
	public boolean DTok(String input)
	{
		String [] temps;
		temps = new String[500];
		StringTokenizer tokens = new StringTokenizer(input, " ");
		int k = 0;
		while ((tokens.hasMoreTokens())&&(k<500))
		{
			String token = tokens.nextToken();
			temps[k] = token;
			k++;
		}	
	//**********
		temps = new String[500];
		tokens = new StringTokenizer(input, " -");
		int k2 = 0;
		while ((tokens.hasMoreTokens())&&(k2<500))
		{
			String token = tokens.nextToken();
			temps[k2] = token;
			k2++;
		}	
		if(k2 > k)
		{
			return true;	
		}
		return false;
		
	}
	public String GTok(String input, String s)
	{
		
		 String [] temps;
		 String [] fwds;
		 temps = new String[500];
		 fwds = new String[500];
		 String fwd = "";
		 StringTokenizer tokens = new StringTokenizer(input, "  ־ - — ");
		 int k = 0;
		 while ((tokens.hasMoreTokens())&&(k<500))
		 {
			 String token = tokens.nextToken();
			 temps[k] = token;
			 k++;
		 }
		 int j = 0;
		 System.out.println( "  k = " + k + "\n");
		 while (j < k)
		 {
			fwds[j] = temps[j];
			j++;
		 }
		 for(int i = 0; i < j; i++)
		 {
			if(i < j-1)
			fwd = fwd + fwds[i] + s;
			else
				fwd = fwd +fwds[j-1];
		 }
		 return fwd;
	}
	public String VwTok(String input, String v, String s)
	{
		 
		 String [] temps;
		 String [] fwds;
		 temps = new String[500];
		 fwds = new String[500];
		 String fwd = "";
		 String vaw = "ֹ ֻ  ֹ ֹ  ֹ ";
		 String yod = "ִ";
		 String sgl = "ְ ֶ ֵ";
		 String hey = "ָ";
		 String degish = "ּ";
		 String col = "״\"”";
		 String col2 = "״\"\'”";
		 String num = "0123456789";
		 int end = input.length();
		 int gen = end -1;
		 int sing = gen -1;
		
		 if(input.length()>2)
		 {
			if(input.substring(gen, end).equals("י"))
			{
				if((input.substring(sing,gen).equals(hey))||(input.substring(sing,gen).equals("ַ")))
		 		{
		 			input = input+ "י";	 
		 		}	 
		 	}
		 }
		 StringTokenizer tokens = new StringTokenizer(input, v);
		 int k = 0;
		 while ((tokens.hasMoreTokens())&&(k<500))
		 {
			String token = tokens.nextToken();
			temps[k] = token; 
			k++;
		 }
		 int j = 0;
		 System.out.println( "  k = " + k + "\n");
		 while (j < k)
		 {
			fwds[j] = temps[j];
			j++;
		 }
		 for(int i = 0; i < j; i++)
		 {
			if(i < j-1)
			fwd = fwd + fwds[i] + s;
			else
				fwd = fwd +fwds[j-1];
		 }
		 return fwd;
	}
	public String gTok(String input, String v, String g)
	{
		if(input.length() < 1)
		{
			return input;	
		}
		
		String [] temps;
		String [] fwds;
		String fwd = "";
		String vaw = "ֹ ֻ  ֹ ֹ  ֹ ";
		String yod = "ִ";
		String sgl = "ְ ֶ ֵ";
		String hey = "ָ";
		String degish = "ּ";
		String col = "״\"”";
		String col2 = "״\"\'”";
		String num = "0123456789";
		temps = new String[500];
		fwds = new String[500];
		 boolean W = false;
		 boolean T = false;
		int end = input.length();
		int gen = end -1;
		int sing = gen -1;
		 
		if((input.substring(gen, end).equals(hey))&&(v.equals(sgl)))
		{
		input = unfinalf(input.substring(0, gen)) + "ה";	 
		}
		if(input.length()>2)
		{
			if(input.substring(0,3).equals("וְּ")||input.substring(0,3).equals("וֶּ")||input.substring(0,3).equals("ּוִ"))
			{
				// input = "ו" + input.substring(3);
				// W = true;
			}
		}
		if(input.length()>1)
		{
			if(input.substring(0,2).equals("וּ")||input.substring(0,2).equals("וְ")||input.substring(0,2).equals("וֶ")||input.substring(0,2).equals("וִ"))
		 	{
		 		 //input = "ו" + input.substring(2);
		 		// W = true;
		 	}
		}
		if(input.length()>3)
		{
			if(input.substring(0,2).equals("תּ")||(input.substring(0,1).equals("ת")&&input.substring(2,3).equals("ּ")))
			{
				//T = true;
			}
		}
		if(input.length()>2)
		{        
			if(input.substring(0,2).equals("תּ"))
			{
				//T = true;
			}
		}
		StringTokenizer tokens = new StringTokenizer(input, v);
		int k = 0;
	
		while ((tokens.hasMoreTokens())&&(k<500))
		{
			String token = tokens.nextToken();
			if(v.equals(degish)==false)
			{
				if(token.substring(0,1).equals(degish))
				{
					token = token.substring(1);
					temps[k-1] = temps[k-1] + degish;
				}
			}
			temps[k] = token;
			k++;
		}
		int j = 0;
		while (j < k)
		{
			end = temps[j].length();
			gen = end -1;
			String V = temps[j].substring(gen, end);
			if((v.equals("ּ")&&(V.equals("ת")))||(V.equals("ו")))
			{
				if(j < k-1)
				{
					if((V.equals("ת")&&(j<1)&&(T==true))||((V.equals("ו"))&&v.equals(sgl)))
					{
						temps[j] = temps[j] + temps[j].substring(gen, end);
					}
				}
			}
			fwds[j] = temps[j];
			j++;
		}
		for(int i = 0; i < j; i++)
		{
			if(i < j-1)
			{
				end = fwds[i].length();                         
				gen = end -1;
				if(fwds[i+ 1].length() < 2)
				{
					if(((fwds[i].substring(gen, end).equals("ו"))&&(g.equals("ו")))||((fwds[i+1].substring(0,1).equals("י"))&&(v.equals(yod)))||((i==0)&&(v.equals(yod))))
						{
							if(fwds[i+1].substring(0,1).equals("י")&&(fwds[i].substring(gen, end).equals("ו")&&(v.equals(yod))))
							{
								fwd = fwd + fwds[i] + "ו";
							}
							else{
								fwd = fwd + fwds[i];
							}
						}
						else{
							fwd = fwd + fwds[i] + g;
					}
				}
				else{
						if(((fwds[i].substring(gen, end).equals("ו"))&&(g.equals("ו")))||((fwds[i+1].substring(0,1).equals("י"))&&(v.equals(yod)))||(!(fwds[i+1].substring(1,2).equals(degish))&&(v.equals(yod))))
						{
							if(fwds[i+1].substring(0,1).equals("י")&&(fwds[i].substring(gen, end).equals("ו")&&(v.equals(yod))))
							{
								fwd = fwd + fwds[i] + "ו";
							}
							else{
								fwd = fwd + fwds[i];
							}
						}
						else{
							fwd = fwd + fwds[i] + g;
					}
				}
			}
			else{
				fwd = fwd +fwds[j-1];
			}
		}
		return fwd;
	}
	public String fTok(String ffw)
	{
		String [] temps;
		String [] fwds;
		temps = new String[500];
		fwds = new String[500];
		String fwd = "";
		StringTokenizer tokens = new StringTokenizer(ffw, ", - ");
		int k = 0;
		while ((tokens.hasMoreTokens())&&(k<500))
		{
			String token = tokens.nextToken();
			temps[k] = token;
			k++;
		}
		int j = 0;
		System.out.println( "  k = " + k + "\n");
		while (j < k)
		{
			fwds[j] = finalf(temps[j]);
			j++;
		}
		for(int i = 0; i < j; i++)
		{
			if(i < j-1)
		fwd = fwd + fwds[i] + "-";
		else
			fwd = fwd +fwds[j-1];
		}
		return fwd;
	}
	public String rTok(String rvv)
	{
		String [] temps;
		String [] revs;
		temps = new String[500];
		revs = new String[500];
		String rev = "";
		StringTokenizer tokens = new StringTokenizer(rvv, ",  ");
		int k = 0;
		while ((tokens.hasMoreTokens())&&(k<500))
		{
			String token = tokens.nextToken();
			temps[k] = token;
			k++;
		}
		k = k - 1;
		int j = 0;
		while (j <= k)
		{
			revs[j] = temps[k - j];
			j++;
		}
		for(int i = 0; i < j; i++)
		{
			if(i < j-1)
				rev = rev + revs[i] + "-";
			else
				rev = rev + revs[j-1];
		}
		return rev;
	}
	
	public void search_words(final int m)
	throws java.io.IOException
	{
		String sign;
		if(m == 0)
		{
			sign = "Find";	
		}
		else{
			sign = "Perm.";
		}
		JButton findButton = new JButton(sign);
		class FdButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				//spr_size = 0;
				String input = textField.getText();
				if(input.equals(""))
				{
					return;
				}
				String input2 = (input);
				String title = "words found" + "                     " + input;
				frame.getLayeredPane().setFont( new Font("Georgia", Font.PLAIN, 14));
				frame.setTitle(title);
				JLabel label =  new JLabel("Dictionary"); 
				JLabel f_label = new JLabel("Hebrew Dictionary");
				frame.setContentPane(scrollBar);
				frame.pack();		
				textArea.setText("");
				String [] temps;
				String [] copy;
				temps = new String[500];
				copy = new String[500];
				int ntok = nTok(input);
				StringTokenizer tokens = new StringTokenizer(input, " ( )  , -  < > ־  ^  •  ׃  [ ] .  :. ; . ? *  !  |  \\  / { } – —  ");
				int k = 0;
				while ((tokens.hasMoreTokens())&&(k<500))
				{
					temps[k] = PointHandler(tokens.nextToken());
					copy[k] = temps[k]; //stores the token in the kth (actually the k+1th) index of the temps array
					k++; //keeps track of successive array indexes, and size of the array which is equal to the total number of tokens (produced from this loop)
				}
				String temp2;
				if(k > 1)  //if multible tokens, then proceed
				{
					for(int i = 0; i < k; i++)
					{
						//temps[i] =  gCut(temps[i]);
						String link = temps[i]; //initializes link to the ith token before entering next loop
						String lk = gCut(link);
						String buff = link; 
						String bf = lk;
						String rbuff = temps[i]; 
						String rbf = temps[i];
						int m = 0;
						int fm = 0;
						for(int j = 1;j < k - i; j++)
						{
							int ce = lk.length();
							int e = link.length();
							String tps = gCut(temps[i+j]);
							boolean c = false;
							boolean fc = false;
							
							int Tm = 0;
							int Tfm = 0;
							if(((ce>1)&&(tps.length()> 0))) //gaurds against potential buffer over flows
							{
								//if lk plus the next token produces a phrase found in the Vecter, then combine lk and tps (the next token) in to one token lk
								if(checkW(lk + "-" + tps)==1)
								{
									fc = true;
									lk = lk + "-" + tps;
								}
								else
								{ 	
									if((ce>1)&&(tps.length()>1))
									{
										if((checkW(lk + "-" + tps.substring(0, 1)) == 1)&&(checkW(tps) == 0))
										{
											fc = true;
											fm ++;
											Tfm ++;
											String TLS = tps;
											lk = lk + "-" + tps.substring(0, 1);
										}
									}
									if(fc == false)
									{
										if(lk.substring(0,1).equals("ו")== true)
										{
											if(checkW(lk.substring(1) + "-" + tps.substring(0, 1)) == 1)
											{
												fc = true;
												fm ++;
												Tfm ++;
												String TLS = tps;
												lk = lk + "-" + tps.substring(0, 1);
											}	
										}	
									}
									if((ce>2)&&(tps.length()>1))
									{
										if((checkW(lk.substring(1) + "-" + tps) == 1)&&(gutteral2(lk) == 1))
										{
											fc = true;
											lk = lk + "-" + tps;
										}
									}
									if((ce>2)&&(tps.length()>2))
									{
										if((checkW(lk.substring(1) + "-" + tps.substring(1)) == 1)&&(gutteral2(lk) == 1)&&(gutteral2_c(tps) == 1))
										{
											fc = true;
											lk = lk + "-" + tps.substring(1);
										}
									}
									if((ce>1)&&(tps.length()>2))
									{
										if((checkW(lk + "-" + tps.substring(1))==1)&&(gutteral2_c(tps) == 1))
										{
											fc = true;
											lk = lk + "-" + tps.substring(1);
										} 
									}
									if((ce>2)&&(tps.length()>2))
									{
										if((checkW(finalf(lk.substring(0, ce-1))  + "-" + finalf(tps.substring(0,tps.length()-1)))==1)&&(gutteral_b(lk) > 1)&&(gutteral_c(tps) > 1))
										{
											fc = true;
											lk = finalf(lk.substring(0, ce-1))  + "-" + tps;
										}
										if((checkW(finalf(lk.substring(0, ce-1))  + "-" + finalf(tps.substring(1,tps.length()-1)))==1)&&(fc == false)&&(gutteral_b(lk) > 1)&&(gutteral_c(tps) == 3))
										{
											fc = true;
											lk = finalf(lk.substring(0, ce-1))  + "-" + tps.substring(1);
										}
										if((checkW(finalf(lk.substring(1, ce-1))  + "-" + finalf(tps.substring(0,tps.length()-1)))==1)&&(fc == false)&&(gutteral_b(lk) == 3)&&(gutteral_c(tps) > 1))
										{
											fc = true;
											lk = finalf(lk.substring(0, ce-1))  + "-" + tps;
										}
										if((checkW(finalf(lk.substring(1, ce-1))  + "-" + finalf(tps.substring(1,tps.length()-1)))==1)&&(fc == false)&&(gutteral_b(lk) == 3)&&(gutteral_c(tps) == 3 ))
										{
											fc = true;
											lk = finalf(lk.substring(0, ce-1))  + "-" + tps.substring(1);
										}
										if((checkW(finalf(lk.substring(0, ce-1))  + "-" + tps.substring(1))==1)&&(gutteral_b(lk) > 1)&&(gutteral2_c(tps) == 1))
										{
											fc = true;
											lk = finalf(lk.substring(0, ce-1))  + "-" +tps.substring(1);
										}
										if((checkW(lk.substring(1)  + "-" + finalf(tps.substring(0, tps.length()-1)))==1)&&(gutteral2(lk) == 1)&&(gutteral_c(tps) > 1))
										{
											fc = true;
											lk = lk + "-" + tps;
										}
										if((checkW(finalf(lk.substring(0, ce-1)) + "-" + tps.substring(1))==1)&&(fc == false)&&(gutteral_b(lk) == 3)&&(gutteral2_c(tps) == 1))
										{
											fc = true;
											lk = finalf(lk.substring(0, ce-1)) + "-" + tps.substring(1);
										}
										if((checkW(lk.substring(1) + "-" + finalf(tps.substring(1,tps.length()-1)))==1)&&(fc == false)&&(gutteral2(lk) == 1)&&(gutteral_c(tps) == 3))
										{
											fc = true;
											lk= lk + "-" + tps.substring(1);
										}
									}
									if((ce>1)&&(tps.length()>2))
									{
										if((checkW(lk + "-" + finalf(tps.substring(1,tps.length()-1)))==1)&&(fc == false)&&(gutteral_c(tps) == 3))
										{
											fc = true;
											lk= lk + "-" + tps.substring(1);
										}
									}
									if((ce>2)&&(tps.length()>1))
									{
										if((checkW(finalf(lk.substring(1, ce-1)) + "-" + tps)==1)&&(fc == false)&&(gutteral_b(lk) == 3))
										{
											fc = true;
											lk= finalf(lk.substring(0, ce-1)) + "-" + tps;
										}
									}
									if((ce>1)&&(tps.length()>2))
									{
										if((checkW(lk + "-" + finalf(tps.substring(0,tps.length()-1)))==1)&&(fc == false)&&(gutteral_c(tps) > 1))
										{
											fc = true;
											lk= lk + "-" + tps;
										}
									}
									if((ce>2)&&(tps.length()>1))
									{
										if((checkW(finalf(lk.substring(0, ce-1)) + "-" + tps)==1)&&(fc == false)&&(gutteral_b(lk) > 1))
										{
											fc = true;
											lk= finalf(lk.substring(0, ce-1)) + "-" + tps;
										}
										if((checkW(finalf(lk.substring(1, ce-1)) + "-" + tps)==1)&&(fc == false)&&(gutteral_b(lk) == 3))
										{
											fc = true;
											lk= finalf(lk.substring(0, ce-1)) + "-" + tps;
										}
									}
								}
							}
							
							//*   *   *
							//*   *   *
							//*   *   *
							//if link plus the next token produces a phrase found in the Vecter, then combine link and temps[i +j] (the next token) into one token link
							if((e>1)&&(temps[i+j].length()> 0)&&(fc == false)) //gaurds against potential buffer over flows
							{
								if(checkW(link + "-" + temps[i+j]) == 1) //checks to see if phrase is found
								{
									c = true;
									link = link + "-" + temps[i+j]; //if so, then set link to phrase
								}
								else
								{ 	
									if((e>1)&&(temps[i+j].length()>1))
									{
										//checks to see if link plus the first letter of the next token (for it may be a prefix) is part of a phrase
										if((checkW(link + "-" + temps[i+j].substring(0, 1)) == 1)&&(checkW(temps[i+j]) == 0))
										{
											c = true;
											m ++;
											Tm ++;
											link = link + "-" + temps[i+j].substring(0, 1);				
										}
									}
									if(c == false)
									{
										if(link.substring(0, 1).equals("ו"))
										{
											if(checkW(link.substring(1) + "-" + temps[i+j].substring(0, 1)) == 1)
											{
												c = true;
												m ++;
												Tm ++;
												link = link + "-" + temps[i+j].substring(0, 1);
											}	
										}	
									}
									if((e>2)&&(temps[i+j].length()>1))
									{
										if((checkW(link.substring(1) + "-" + temps[i+j])==1)&&(gutteral2(link) == 1))
										{
											c = true;
											link = link + "-" + temps[i+j];
										}
									}
									if((e>2)&&(temps[i+j].length()>2))
									{
										//if link (current token) has any potential prefixes, check if link without potential prefix plus the next token produces a phrase found in the Vecter, then combine link (without prefix) and temps[i +j] (the next token) into one token link
										if((checkW(link.substring(1) + "-" + temps[i+j].substring(1))==1)&&(gutteral2(link) == 1)&&(gutteral2_c(temps[i+j]) == 1))
										{
											c = true;
											link = link + "-" + temps[i+j].substring(1);
										}
									}
									if((e>1)&&(temps[i+j].length()>2))
									{
										//if temps[i+j] (next token) has certain potential prefixes, check if link plus the next token without potential prefix produces a phrase found in the Vecter, then combine link and temps[i +j]  (without prefix) into one token link
										if((checkW(link + "-" + temps[i+j].substring(1))==1)&&(gutteral2_c(temps[i+j]) == 1))
										{
											c = true;
											link= link + "-" + temps[i+j].substring(1);
										}
									}
									if((e>2)&&(temps[i+j].length()>2))
									{
										if((checkW(finalf(link.substring(0, e-1))  + "-" + finalf(temps[i+j].substring(0,temps[i+j].length()-1)))==1)&&(gutteral_b(link) > 1)&&(gutteral_c(temps[i+j]) > 1))
										{
											c = true;
											link = finalf(link.substring(0, e-1))   + "-" + temps[i+j];
										}
										if((checkW(finalf(link.substring(0, e-1))  + "-" + finalf(temps[i+j].substring(1,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral_b(link) > 1)&&(gutteral_c(temps[i+j]) == 3))
										{
											c = true;
											link = finalf(link.substring(0, e-1))  + "-" + temps[i+j].substring(1);
										}
										if((checkW(finalf(link.substring(1, e-1))  + "-" + finalf(temps[i+j].substring(0,temps[i+j].length()-1)))==1)&&(gutteral_b(link) == 3)&&(gutteral_c(temps[i+j]) > 1))
										{
											c = true;
											link = finalf(link.substring(0, e-1))  + "-" + temps[i+j];
										}
										if((checkW(finalf(link.substring(1, e-1))  + "-" + finalf(temps[i+j].substring(1,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral_b(link) == 3)&&(gutteral_c(temps[i+j]) == 3))
										{
											c = true;
											link = finalf(link.substring(0, e-1))  + "-" + temps[i+j].substring(1);
										}
										if((checkW(finalf(link.substring(0, e-1))  + "-" + temps[i+j].substring(1))==1)&&(gutteral_b(link) > 1)&&(gutteral2_c(temps[i+j]) == 1))
										{
											c = true;
											link = finalf(link.substring(0, e-1))  + "-" +temps[i+j].substring(1);
										}
										if((checkW(link.substring(1)  + "-" + finalf(temps[i+j].substring(0,temps[i+j].length()-1)))==1)&&(gutteral2(link) == 1)&&(gutteral_c(temps[i+j]) > 1))
										{
											c = true;
											link = link  + "-" + temps[i+j];
										}
										if((checkW(finalf(link.substring(1, e-1)) + "-" + temps[i+j].substring(1))==1)&&(c == false)&&(gutteral_b(link) == 3)&&(gutteral2_c(temps[i+j]) == 1))
										{
											c = true;
											link= finalf(link.substring(0, e-1)) + "-" + temps[i+j].substring(1);
										}
										if((checkW(link.substring(1) + "-" + finalf(temps[i+j].substring(1,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral2(link) == 1)&&(gutteral_c(temps[i+j]) == 3))
										{
											c = true;
											link = link + "-" + temps[i+j].substring(1);
										}
									}
									if((e>1)&&(temps[i+j].length()>2))
									{
										if((checkW(link + "-" + finalf(temps[i+j].substring(1,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral_c(temps[i+j]) == 3))
										{
											c = true;
											link= link + "-" + temps[i+j].substring(1);
										}
									}
									if((e>2)&&(temps[i+j].length()>1))
									{
										if((checkW(finalf(link.substring(1, e-1)) + "-" + temps[i+j])==1)&&(c == false)&&(gutteral_b(link) == 3))
										{
											c = true;
											link= finalf(link.substring(0, e-1)) + "-" + temps[i+j];
										}
									}
									if((e>1)&&(temps[i+j].length()>2))
									{
										if((checkW(link + "-" + finalf(temps[i+j].substring(0,temps[i+j].length()-1)))==1)&&(c == false)&&(gutteral_c(temps[i+j]) > 1))
										{
											c = true;
											link= link + "-" + temps[i+j];
										}
									}
									if((e>2)&&(temps[i+j].length()>1))
									{
										if((checkW(finalf(link.substring(0, e-1)) + "-" + temps[i+j])==1)&&(c == false)&&(gutteral_b(link) > 1))
										{
											c = true;
											link= finalf(link.substring(0, e-1)) + "-" + temps[i+j];
										}
										if((checkW(finalf(link.substring(1, e-1)) + "-" + temps[i+j])==1)&&(c == false)&&(gutteral_b(link) == 3))
										{
											c = true;
											link= finalf(link.substring(0, e-1)) + "-" + temps[i+j];
										}
									}
								}
							} 
							
							//******************************************************************************************************************************
							if(fc == false) //if there is no match
							{
								bf = lk + "-" + tps.substring(0, 1); //save to bf for potential construct
								rbf = tps;
								lk = lk + "-" + tps; //add current tps index (i + j) to lk, to check for larger phrases
							}
							else //if there is a match
							{
								bf = lk ; //just set bf to lk again
								if(fm >  0) //if there are constructs found
								{
									if((checkW(lk)==1)||(checkW(lk.substring(1))==1)||(checkW(finalf(lk.substring(0, lk.length()-1)))==1)||(checkW(finalf(lk.substring(1,lk.length()-1)))==1))
									{
										temps[i] = lk; //stores the whole phrase in current array index, i;
										for(int t = i + 1; t < k - (j - fm); t++) //shifts the remaining entries up (closer to i), to close the gap
										{
											temps[t] = temps[t+(j - fm)];
										}
										fc = true;
										k = k - (j - fm); //thus the array is reduced by j
										j = fm; //and thus the reference is brought down to one, because of of the subtraction from temps
									}
								}
								else
								{
									if((checkW(lk)==1)||(checkW(lk.substring(1))==1)||(checkW(finalf(lk.substring(0, lk.length()-1)))==1)||(checkW(finalf(lk.substring(1,lk.length()-1)))==1))
									{
										temps[i] = lk; //stores the whole phrase in current array index, i;
										for(int t = i + 1; t < k - j; t++) //shifts the remaining entries up (closer to i), to close the gap
										{
											temps[t] = temps[t+j];
										}
										fc = true;
										k = k - j; //thus the array is reduced by j
										j =  0; //and thus the reference is brought down to one, because of of the subtraction from temps
									}
								}
								link = lk;
							}
							//******************************************************************************************************************************
							
							//*   *   *
							//*   *   *
							//*   *   *
							
							if(fc == false)
							{
								if(c == false) //if there is no match
								{
									buff = link + "-" + temps[i+j].substring(0, 1); //save to buff for potential construct
									rbuff = temps[i + j];
									link = link + "-" + temps[i+j]; //add current temps index (i + j) to link, to check for larger phrases
								}
								else  //if there is a match,
								{
									buff = link; //just set buff to link again
									if(m  >  0) //if there are constructs found
									{
										if((checkW(link)==1)||(checkW(link.substring(1))==1)||(checkW(finalf(link.substring(0, link.length()-1)))==1)||(checkW(finalf(link.substring(1,link.length()-1)))==1))
										{
											temps[i] = link; //stores the whole phrase in current array index, i;
											for(int t = i + 1; t < k - (j - m); t++)
											{
												temps[t] = temps[t + (j - m)];
											}
											c = true;
											k = k - (j - m); //thus the array is only reduced by (j - m)
											j = m;
										}	
									}
									else
									{
										if((checkW(link)==1)||(checkW(link.substring(1))==1)||(checkW(finalf(link.substring(0, link.length()-1)))==1)||(checkW(finalf(link.substring(1,link.length()-1)))==1))
										{
											temps[i] = link; //stores the whole phrase in current array index, i;
											for(int t = i + 1;t < k - j; t++) //shifts the remaining entries up (closer to i), to close the gap
											{
												temps[t] = temps[t+j];
											}
											c = true;
											k = k - j; //thus the array is reduced by j
											j = 0; //and thus the reference is brought down to one, because of of the subtraction from temps
										}
									}
									lk = link;
								} 
							}
						} //******************************************************* end of j loop
					} //******************************************************* end of k loop
				}
				for(int n = 0; n < k; n++)
				{
					temp2 = temps[n];
					int is_n = IsNumber(temp2);
					int B = temp2.length();
					
					if((is_n > 0)&&(B > 0))
					{
						if(n > 0)
						{
							textArea.append("\n");	
						}
						textArea.append("                 - " +temp2 + "\n");
						int l = temp2.length();
						String tempt = temp2;
						
						if(tempt.length() > 3)
						{
							if((tempt.substring(1, 2).equals("'"))||tempt.substring(1, 2).equals("'"))
							{
								tempt = tempt.substring(2);	
							}
							else
							{
								if(tempt.length() > 3)
								{
									if((tempt.substring(0, 1).equals("ה"))||tempt.substring(0, 1).equals("ו"))
									{
										tempt = tempt.substring(1);	
									}
								}
							}
						}
						int g = -1;

						g = new_gematria(unfinalf(tempt));
						
						int tri = 0;
						if(g > 0)
						{
							tri = Try.start(g);
						}
						if((is_n == 3)||(is_n == 4)||(is_n == 5)||(is_n == 6))
						{
							if(is_n == 6)
							{
								String epoch = " C.E.";
								int py = g - 760;
								if(py < 0)
								{
									epoch = " B.C.E.";
									int ay = (py)*(-1) + 2;
									textArea.append("                            Year = "  + ay + epoch + " -");	
								}
								else
								{
									textArea.append("                            Year = "  + (g - 760) + " C.E. -");	
								}
								textArea.append(" Hebrew = "  + (g + 2000) + ";");
							}
							if(is_n == 3)
							{
								String gepoch = " C.E.";
								int gyear = g - 760;
								if(gyear < 0)
								{
									gepoch = " B.C.E.";
									gyear = gyear*(-1) + 2;
								}
								textArea.append("                            #" +  "  " + g +  ",   triangle: " + tri);
								textArea.append("   (Year = "  + (gyear) + gepoch + " -");	
								textArea.append(" Hebrew = "  + (3000 + g) + ");");	
							}
							if(is_n == 4)
							{
								String depoch = " C.E.";
								int dyear = 240 + g;
								if(dyear  < 0)
								{
									depoch = " B.C.E.";
									dyear = dyear*(-1) + 2;
								}
								textArea.append("                            #" +  "  " + g +  ",   triangle: " + tri);
								textArea.append("   (Year = "  + (dyear) + depoch + " -");	
								textArea.append(" Hebrew = "  + (4000 + g) + ");");	
							}
							if(is_n == 5)
							{
								String hepoch = " C.E.";
								int hyear = 1240 + g;
								if(hyear  < 0)
								{
									hepoch = " B.C.E.";
									hyear = hyear*(-1) + 2;
								}
								textArea.append("                            #" +  "  " + g +  ",   triangle: " + tri);
								textArea.append("   (Year = "  + (hyear) + hepoch + " -");	
								textArea.append(" Hebrew = "  + (5000 + g) + ");");	
							}
						}
						else
						{
							textArea.append("                            #" +  "  " + g +  ",   triangle: " + tri);
							if(g > 200)
							{
								textArea.append("   (Year = "  + (1240 + g) + " C.E. -");	
								textArea.append(" Hebrew = "  + (5000 + g) + ");");	
							}
								
						}
						textArea.append("\n");
					}
						
					Sefar = new int[T_Capacity];
					Hits = new double[(200)];
					Cpys = new double[(200)];
					spr_size = 0;
					
					temp2 = (temps[n]);
					
					boolean MaduA = daat(temp2, n);
					if(temp2.equals(null) == false)
					{
						if((tablew2(temp2)==1)&&(temp2 != null))
						{
							Hits[0] +=  10*infinity;
						}
					}
					if(temp2.length() > 1)
					{
						if(nTok(temp2) <= 1)
						{
							int t2end = temp2.length();
							if(t2end >= 8)
							{
								WALL = 1/(Math.exp(t2end/100));
							}
							else{
								WALL =  1/(Math.exp(t2end/50));
							}
						}
						find_root(temp2);
					}
					
					int equal = 0;
					System.out.println("   " +  spr_size + " words found \n");	
					
					order();
					if((k>1)&&(is_n < 0))
					{	
						if(n > 0)
						{
							textArea.append("\n");	
						}
						textArea.append("           - " +temp2 + "\n");
					}
					for(int i = 0; i < spr_size; i++)
					{
						int pos = Sefar[i];
						int g = gematria(pos);
						int tri = Try.start(g);                      
						textArea.append(test.get_Item(pos)+ "; " +  "  gemetria: " + g + ",   triangle: " + tri + "\n");
					}
					sTok(temp2, 1);
				}
				textArea.setCaretPosition( 0 );

				System.out.println("\n");
				System.out.println("\nTimes of Delet = " +W. Delet.getTimes() + "\n");
				System.out.println("Times of Alf = " +W. Alf.getTimes() + "\n");
				System.out.println("Times of Hey = " + W.Hey.getTimes() + "\n");
				System.out.println("\nAverage Delet = " +W. Delet.getAvrg() + "\n");
				System.out.println("Avrg Alf = " +W. Alf.getAvrg() + "\n");
				
				if(Aramaic == true)
				{
					System.out.println("\nAramaic is true:");
				}
				System.out.println("\nDeletb = " +W. Delet.getB() + "\n");
				System.out.println("Alfb = " +W. Alf.getB() + "\n");
				System.out.println("Deletc = " +W. Delet.getC() + "\n");
				System.out.println("Alfc = " +W. Alf.getC() + "\n");
				
				System.out.println("Mema = " +W. Mem.getA() + "\n");
				System.out.println("MemOldRaio = " +W. Mem.getB()/W.Mem.getC() + "\n");
				System.out.println("MemAi = " +W. Mem.Ai() + "\n");
				System.out.println("MemAvrg = " +W. Mem.getAvrg() + "\n");
				System.out.println("Memb = " +W. Mem.getB() + "\n");
				System.out.println("Lamedb = " + W.Lamed.getB() + "\n");
				System.out.println("Heyb = " + W.Hey.getB() + "\n");
				System.out.println("HollowVb = " + W.HollowV.getB() + "\n");
				System.out.println("Kalfa = " + W.Kalf.getA() + "\n");
				System.out.println("Sinb = " + W.Sin.getB() + "\n");
				System.out.println("Vavb = " + W.Vav.getB() + "\n");
				System.out.println("Betb = " + W.Bet.getB() + "\n");                              
				
				System.out.println("Memc = " +W. Mem.getC() + "\n");
				System.out.println("Lamedc = " + W.Lamed.getC() + "\n");
				System.out.println("Heyc = " + W.Hey.getC() + "\n");
				System.out.println("HollowVc = " + W.HollowV.getC() + "\n");
				System.out.println("Kalfc = " + W.Kalf.getC() + "\n");
				System.out.println("Sinc = " + W.Sin.getC() + "\n");
				System.out.println("Vavc = " + W.Vav.getC() + "\n");
				System.out.println("Betc = " + W.Bet.getC() + "\n");
				
				System.out.println("Mem2c = " + W.Mem2.getC() + "\n");
				System.out.println("P_HIMc = " + W.P_HIM.getC() + "\n");
				System.out.println("Hey_2c = " + W.Hey_2.getC() + "\n");
				System.out.println("Suff = " + W.Suff.getC() + "\n");
				System.out.println("Kalf2c = " + W.Kalf2.getC() + "\n");
				System.out.println("P_Hc = " + W.P_H.getC() + "\n");
				System.out.println("P_NVc = " + W.P_NV.getC() + "\n");
				System.out.println("P_Ic = " + W.P_I.getC() + "\n");
				frame.show();
	    		}
	    	};
	    	ActionListener findlistener = new FdButtonListener();
	    	findButton.addActionListener(findlistener);
	 
	    	JButton closeButton =new JButton("Close");
	    	class CloseButtonListener implements ActionListener
	    	{
	    		public void actionPerformed(ActionEvent event)
	    		{
	    			inpt_frame.dispose();
	    			inpt_frame = new JFrame();
	    			inpt_frame.setTitle( "Enter Word");
	    			panel = new PolyClickPanel();
	    			panel.add(textField);
	    			inpt_frame.setContentPane(panel);
	    			inpt_frame.add(in_label);
	    		}
	    	};
	    	ActionListener closelistener = new CloseButtonListener();
	    	closeButton.addActionListener(closelistener);
	    	int g;
	    	int tri;
	    	inpt_frame.add(findButton);
	    	inpt_frame.add(closeButton);
	    	inpt_frame.pack();
	    	inpt_frame.show();
	    	spr_size = 0;
	    	return;
 	}
 	public boolean daat(String tem, int i)
 	{
 		int end = tem.length();
		int gen = end -1;
		int sing = gen -1;   
		boolean t_aramaic = Aramaic;
		if(i == 0)
		{
 			if(Aramaic == false)
 			{
 				if((W. Delet.getAvrg() > 0.5)||(W.Alf.getAvrg() > 0.5))
				{
					Aramaic = true;
					return true;
				}
			}
			if((W. Delet.getAvrg() +  W.Alf.getAvrg()) >= 0.8)
			{
				Aramaic = true;
			}
			if((W. Delet.getAvrg() < 0.3)||(W.Alf.getAvrg() < 0.3))
			{
				Aramaic = false;
			}
			
			if((W. Delet.getAvrg() < 0.4)&&(W.Alf.getAvrg() < 0.45))
			{
				Aramaic = false;
			}
			if((W. Delet.getAvrg() +  W.Alf.getAvrg()) < 0.6)
			{
				Aramaic = false;
			}
		}
		if(end > 2)
		{
			if(tem.substring(sing,end).equals("יא"))
			{
				Aramaic = true;	
			}
			if(end > 3)
			{
				 if(tem.substring(0, 3).equals("דיל"))
				 {
				 	 Aramaic = true;	
				 }
			}
		}
		if(tem.equals("גם'"))
		{
			Aramaic = false;
		}
		if(tem.equals("ד'")||tem.equals("ית"))
		{
			Aramaic = true;
		}
		t_aramaic = Aramaic;
		return t_aramaic;
 	}
 	public void PermutateW(final int m)
	throws java.io.IOException
	{
		String sign;
		if(m == 0)
		{
			sign = "Find";	
		}
		else{
			sign = "Perm.";
		}
		JButton permButton = new JButton(sign);
		class PmButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				String input = textField.getText();
				if(input.equals(""))
				{
					return;
				}        
				String input2 = finalf(input);
				String title = "words found" + "                                                                                        " + input2;
				frame.setTitle(title);
				JLabel label =  new JLabel("Dictionary");
				JLabel f_label = new JLabel("Hebrew Dictionary");
				frame.setContentPane(scrollBar);
				frame.pack();		
				textArea.setText("");
				String [] temps;
				temps = new String[15];
				StringTokenizer tokens = new StringTokenizer(input, ",   ");
				int k = 0;
				while ((tokens.hasMoreTokens())&&(k<15))
				{
					String token = tokens.nextToken();
					temps[k] = VwTok(token, vowels, "");
					k++;
				}
				String temp2;
				for(int n = 0; n < k; n++)
				{
					Sefar = new int[T_Capacity];
					Hits = new double[(200)];
					Cpys = new double[(200)];
					spr_size = 0;
					temp2 = finalf(temps[n]);
					if(tablew2(temp2)==1)
					{
						Hits[0] += infinity;
					}
					if(m == 0)
					{
						find_root(temp2);
					}
					else{
					Kabbalah(unfinalf(temp2), 0);
					System.out.println(K_Count(temp2) + " permutations! \n");
				
					}
					int equal = 0;
					System.out.println("   " +  spr_size + " words found \n");	
					
					order();
					if(k>1)
					{	
						if(n > 0)
						{
							textArea.append("\n");	
						}
						textArea.append("                 - " +temp2 + "\n");
					}
						
					for(int i = 0; i < spr_size; i++)
					{
						input = temp2;
						int pos = Sefar[i];
						int g = gematria(pos);
						int tri = Try.start(g);                      
						textArea.append(test.get_Item(pos)+ "; " +  "  gemetria: " + g + ",   triangle: " + tri + "\n");
					}
				}
				frame.show();
				try
	    			{
	    				Collections.sort(data_map);
	    				test.send_data(data_map);
	    			}
	    			catch(IOException e)
	    			{
	    				System.out.println("Error occurred while trying to find word.");
	    			}
	    		}
	    	};
	    	ActionListener permlistener = new PmButtonListener();
	    	permButton.addActionListener(permlistener);
	 
	    	int g;
	    	int tri;
	    	inpt_frame.add(permButton);
	    	inpt_frame.pack();
	    	inpt_frame.show();
	    	spr_size = 0;
	    	return;
 	}
 	public void order()
 	{
 		order2();
 		return;
 	}
 	public void order2()
 	{
 		int i;
 		int s;
 		for(s = 0; s < spr_size -1; s++)
		{
			for(i=s + 1; i < spr_size; i++)
			{
				if(Hits[s]     <    Hits[i])
				{
				   swap(s, i);
				}
			}
		}
 		return;
 	}
 	public void swap(int a, int b)
 	{
 		int temp = Sefar[a];
 		double h_temp = Hits[a];          
 		
 		Sefar[a] = Sefar[b];
 		Hits[a] = Hits[b];
 		
 		Sefar[b] = temp;
 		Hits[b] = h_temp;
 		return;
	}
	public int checkCpy(int cpy)
	{
		int n = 0;
		for(int i = 0; i < spr_size; i++)
		{
			if(Sefar[i] == cpy)
			{
				n++;
				return i;
			}
		}
		return -1;
	}
	public int get_spr_size()
	{
		return spr_size;
	}
	public void add_spr2(int mspr)
	{
		int p = checkCpy(mspr);
		String wd = data_map.get(mspr).get_val();
		int w = wd.length();
		int we = 1;
		int wf = 1;
		if(w == 1)
		{
			Sefar[spr_size] = 1;
			spr_size ++;
			return;
		}
		if(p == -1)
		{
			Sefar[spr_size] = mspr;
			Hits[spr_size] = infinity;
			Cpys[spr_size] = 1;
			spr_size ++;
			return;
		}
		double c = Cpys[p] + 1;
		Cpys[p] =  c;
		Cpys[p] =  c;
		double m = Hits[p];
		Hits[p] += infinity/(c*c*5+ c*c*c*(5/3)+ c*c*c*c*(5/9));
		if(w < 3)
		{
			Hits[p] = (m)*(0.75)+ (Hits[p])*(0.25);	
		}
		return;
	}
	public void add_spr(int mspr)
	{
		int p = checkCpy(mspr);
		String wd = data_map.get(mspr).get_val();
		int we = 1;
		int wf = 1;
		int w = wd.length();
		if(w == 1)
		{
			Sefar[spr_size] = 1;
			spr_size ++;
			return;
		}
		if(wd.substring(w - 1, w).equals("ם")||(wd.substring(w-1,w).equals("ה")))
		{
			we = 40;
		}
		if(wd.substring(w-1,w).equals("ה"))
		{
			we = 15;
		}
		if(wd.substring(w-1,w).equals("ת"))
		{
			we = 10;
		}
		if(wd.substring(w - 2, w).equals("ים"))
		{
			we = 50;
		}
		if((wd.substring(0, 1).equals("מ"))||(wd.substring(0, 1).equals("י"))||(wd.substring(0, 1).equals("ב"))||(wd.substring(0, 1).equals("ש"))||(wd.substring(0, 1).equals("א"))||(wd.substring(0, 1).equals("ל")))
		{
			wf = 10;
		}
		if(wd.substring(0, 1).equals("ה"))
		{
			wf = 50;
		}
		if(p == -1)
		{
			Sefar[spr_size] = mspr;
			Cpys[spr_size] = 1;
			Hits[spr_size] = 1; 
			spr_size ++;
			return;
		}
		double m = Hits[p];
		double c = Cpys[p] + 1;
		Cpys[p] =  c;
		Hits[p] = m + (w)/(c*c*5+ c*c*c*(5/3)+ c*c*c*c*(5/9));
		if(w < 3)
		{
			Hits[p] = (m)*(0.75)+ (Hits[p])*(0.25);	
		}
		return;
	}
	public void add_sprn(int mspr, double n)
	{
		int p = checkCpy(mspr);
		String wd = data_map.get(mspr).get_val();
		int w2 = wd.length();
		if(p == -1)
		{
			Sefar[spr_size] = mspr;
			double w = Hits[spr_size];
			double c = Cpys[spr_size];
			Hits[spr_size] = w+ n;
			Cpys[spr_size] = c+ 1;
			spr_size ++;
			return;
		}
		double m = Hits[p];
		double c = Cpys[p] + 1;
		Cpys[p] =  c;
		Hits[p] =  m + n/(c*c*5+ c*c*c*(5/3)+ c*c*c*c*(5/9));
		if(w2 < 3)
		{
			Hits[p] = (m)*(0.75)+ (Hits[p])*(0.25);
		}
		return;
	}
	public void add_sprne(int mspr, double n, double e)
	{
		int p = checkCpy(mspr);
		String wd = data_map.get(mspr).get_val();
		int w2 = wd.length();
		if(p == -1)
		{	
			double w = Hits[spr_size];
			double c = Cpys[spr_size];
			Sefar[spr_size] = mspr;
			Hits[spr_size] = w + n*e;
			Cpys[spr_size] = c+ 1;
			spr_size ++;
			return;
		}
		double m = Hits[p];
		double c = Cpys[p] + 1;
		Cpys[p] =  c;
		Hits[p] = m + (n*e)/(c*c*5+ c*c*c*(5/3)+ c*c*c*c*(5/9));
		if(w2 < 3)
		{
			Hits[p] = (m)*(0.75)+ (Hits[p])*(0.25);
		}
		
		return;
	}
	public Num TW(String word, Num n, double e)
	{
		int w = word.length();
		if(w < 1)
		{
			return n;
		}
		int pos = test.search(word, 0, tot);
		if(data_map.get(pos).get_val().equalsIgnoreCase(word))
		{    
			double N = (n.getA())*(n.getB()/n.getC());
			add_sprne(pos, N/10, e);
			double b = n.getB() + 1;	
			n.setB(b);
		}
		double k = n.getC() + 1;
		n.setC(k);
		double Av = n.getAvrg();
		if(n.getAvrg() <= 0)
		{
			Av = 1;
		}
		double R =  ((Av)*(n.Ai()) + 3*(n.Ai())*(n.getB()/n.getC()))/4;
		if(w > 2)
		{
			n.setA(R);
		}
		return n;
	}
	public double TW3(String word, double n, double e)
	{
		int w = word.length();
		if(w < 1)
		{
			return n;
		}
		int pos = test.search(word, 0, tot);
		if(data_map.get(pos).get_val().equalsIgnoreCase(word))
		{    
			add_sprne(pos, n/2, e);
			return n;
		}
		if(n > 1)
		{
			n-= n/10;	
		}
		return n;
	}
	public double TW(String word, double n, double e)
	{
		TW3(unfinalf(word), n, e);
		word = finalf(word);
		int w = word.length();
		if(w < 1)
		{
			return n;
		}
		int pos = test.search(word, 0, tot);
		if(data_map.get(pos).get_val().equalsIgnoreCase(word))
		{    
			add_sprne(pos, n/2, e);
			return n;
		}
		if(n > 1)
		{
			n-= n/10;	
		}
		return n;
	}
	public double tableWN(String word, double n)
	{
		word = finalf(word);
		int w = word.length();
		if(w  < 1)
		{
			return n;
		}
		int pos = test.search(word, 0, tot);
		if(data_map.get(pos).get_val().equalsIgnoreCase(word))
		{    
			add_sprn(pos, n/10);
		}
		
		return n;
	}
	public double tablew(String word)
	{       
		int w = word.length();
		if(w  < 1)
		{
			return 0;
		}
		int pos = test.search(word, 0, tot);
		if(data_map.get(pos).get_val().equalsIgnoreCase(word))
		{    
			add_spr(pos);		        
			return 1;
		}
		return 0;
	}
	public double tablew2(String word)
	{
		int w = word.length();
		if(w  < 1)
		{
			return 0;
		}
		int pos = test.search(word, 0, tot);
		if(data_map.get(pos).get_val().equalsIgnoreCase(word))
		{    
			add_spr2(pos);		        
			return 1;
		}
		return 0;
	}
	public double tableW(String word)
	{
		int w = word.length();
		if(w  < 1)
		{
			return 0;
		}
		int pos = test.search(word, 0, tot);
		if(data_map.get(pos).get_val().equalsIgnoreCase(word))
		{    
			add_spr(pos);		        
			return 1;
		}
		return 0;
	}
	public double checkW(String word)
	{
		return tableW(word);
	}
	public String covAfa(String cov)
	{
		int end = cov.length();
		if(end < 1)
			return "צצצצצצ";
		
		for(int i = 0; i < end; i++)
		{
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "א" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
			if((cov.charAt(i) == 'ך'))
			{
				cov= cov.substring(0,i) + "ך" +cov.substring(i+1,end) ;
			}
		}
		return cov;
	}
	public String finalf(String flw)
	{
		int end = flw.length();
		if(end < 1)
			return "צצצצצצ";

		if(flw.substring(end -1, end).equals("כ"))
		{
			flw = flw.substring(0,end-1) + "ך";
			return flw;
		}
		if(flw.substring(end -1, end).equals("מ"))
		{
			flw = flw.substring(0,end-1) + "ם";
			return flw;
		}
		if(flw.substring(end -1, end).equals("נ"))
		{
			flw = flw.substring(0,end-1) + "ן";
			return flw;
		}
		if(flw.substring(end -1, end).equals("פ"))
		{
			flw = flw.substring(0,end-1) + "ף";
			return flw;
		}
		if(flw.substring(end -1, end).equals("צ"))
		{
			flw = flw.substring(0,end-1) + "ץ";
			return flw;
		}
		return flw;
	}
	public String unfinalf(String unflw)
	{
		int end = unflw.length();
		if(end < 1)
			return "צצצצצצ";

		if(unflw.substring(end -1, end).equals("ך"))
		{
			unflw = unflw.substring(0,end-1) + "כ";
			return unflw;
		}
		if(unflw.substring(end -1, end).equals("ם"))
		{
			unflw = unflw.substring(0,end-1) + "מ";
			return unflw;
		}
		if(unflw.substring(end -1, end).equals("ן"))
		{
			unflw = unflw.substring(0,end-1) + "נ";
			return unflw;
		}
		if(unflw.substring(end -1, end).equals("ף"))
		{
			unflw = unflw.substring(0,end-1) + "פ";
			return unflw;
		}
		if(unflw.substring(end -1, end).equals("ץ"))
		{
			unflw = unflw.substring(0,end-1) + "צ";
			return unflw;
		}
		return unflw;
	}
	public W_Path Polel(W_Path poll, double e)
	{
		e = e/9;
		W_Path pol = new W_Path(poll);
		int end = pol.get_word().length();
		if((e < WALL)||(end<4))
		{
			return Irrg( new W_Path(poll), e);
		}
		int sing = end -2;
		int gen = end -1;
		if(((pol.get_word().substring(1, 2).equals("ו"))||(pol.get_word().substring(1, 2).equals("י")))&&(pol.get_word().substring(2, 3).equals(pol.get_word().substring(3, 4))))
		{
			pol.set_word(pol.get_word().substring(0, 1) + pol.get_word().substring(2));
		}
		
		TW(pol.get_word(), 1000, e);
		
		return pol;
	}
	public void Pilpel(W_Path polpol, double e)
	{
		e = e/13;
		W_Path ppl = new W_Path(polpol);
		if(e < WALL)
		{
			Irrg(new W_Path(ppl), e);
			return;
		}
		int end = ppl.get_word().length();
		int gen = end -1;
		int sing = gen -1;
		double er = e/100;
		double f = e/50;
		
		if(end >=3)
		{
			if(unfinalf(ppl.get_word().substring(gen, end)).equals(ppl.get_word().substring(gen-1, end-1)))
			{
				W_Path ppll = new W_Path(ppl);
				ppll.set_word(finalf(ppl.get_word().substring(0, gen)));
				if(ppl.get_word().substring(0, gen).length() < 3)
				{
					permutate(ppl.get_word().substring(0, gen), 1,  1000, f/10, ppl.get_word().length() - 1);
					Irrg( new W_Path(ppll), er);
					return;
				}
				Pilpel(new W_Path(ppll), er);
				form(new W_Path(ppll), f);
			}
			if(unfinalf(ppl.get_word().substring(sing, gen)).equals(ppl.get_word().substring(sing-1, sing)))
			{
				W_Path tppl = new W_Path(ppl);
				tppl.set_word(ppl.get_word().substring(0, sing) + ppl.get_word().substring(gen, end)); 
				if(tppl.get_word().length() < 3)
				{
					permutate(tppl.get_word(), 1,  1000, f/10, tppl.get_word().length());
					Irrg(new W_Path(tppl), er);
					return;
				}
				Pilpel(new W_Path(tppl), er);
				form(new W_Path(tppl), f);
			}
			if((ppl.get_word().substring(gen, end).equals("ה"))||(ppl.get_word().substring(gen, end).equals("ם"))||(ppl.get_word().substring(gen, end).equals("ך"))||(ppl.get_word().substring(gen, end).equals("ו"))||(ppl.get_word().substring(gen, end).equals("י"))||(ppl.get_word().substring(gen, end).equals("ן"))||(ppl.get_word().substring(gen, end).equals("ת")))
			{
				if(ppl.get_word().substring(gen, end).equals("ה"))
				{
					TW(ppl.get_word(), 1250, e);	
				}
				if(ppl.get_word().substring(gen-1, end-1).equals(ppl.get_word().substring(gen-2,end-2)))
				{
					W_Path ppl2 = new W_Path(ppl);
					ppl2.set_word(ppl.get_word().substring(0, gen -1) + ppl.get_word().substring(gen , end));  
					TW(ppl2.get_word(), 1300, e);
					permutate(ppl2.get_word(), 1,  1000, f/10, ppl2.get_word().length());
				}
				W_Path ppl3 = new W_Path(ppl);
				ppl3.set_word(finalf(ppl.get_word().substring(0, gen)));  
				Pilpel(ppl3, er);
			}
			if((ppl.get_word().substring(0, 1).equals("ה"))||(ppl.get_word().substring(0, 1).equals("ו"))||(ppl.get_word().substring(0, 1).equals("ש"))||(ppl.get_word().substring(0, 1).equals("ב"))||(ppl.get_word().substring(0, 1).equals("ת")||(ppl.get_word().substring(0, 1).equals("י")))||(ppl.get_word().substring(0, 1).equals("ל"))||(ppl.get_word().substring(0, 1).equals("נ"))||(ppl.get_word().substring(0, 1).equals("מ")))
			{
				TW(ppl.get_word(), 5, e);
				if(ppl.get_word().substring(0, 1).equals("י"))
				{
					TW(ppl.get_word(), 1125, e);
					if(ppl.get_word().substring(gen, end).equals("ה"))
					{
						TW(ppl.get_word(), 1300, e);	
					}
				}
				if(unfinalf(ppl.get_word().substring(gen, end)).equals(ppl.get_word().substring(gen-1,end-1)))
				{
					W_Path ppl1 = new W_Path(ppl);
					ppl1.set_word(finalf(ppl.get_word().substring(0, gen)));
					TW(ppl1.get_word(), 300, e);
					permutate(ppl1.get_word(), 1,  1000, f/10, ppl1.get_word().length());
				}
				if((ppl.get_word().substring(0, 1).equals("ה"))||(ppl.get_word().substring(0, 1).equals("ת"))||(ppl.get_word().substring(0, 1).equals("י"))||(ppl.get_word().substring(0, 1).equals("נ")))
				{
					W_Path nppl = new W_Path(ppl);
					nppl.set_word(ppl.get_word().substring(1));
					if(ppl.get_word().substring(0, 1).equals("ה"))
					{
						nppl.set_h(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("ת"))
					{
						nppl.set_t(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("י"))
					{
						nppl.set_i(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("נ"))
					{
						nppl.set_n(true); 	
					}
					affix(nppl, er);
				}
				else{
					W_Path nppl = new W_Path(ppl);
					nppl.set_word(ppl.get_word().substring(1));
					if(ppl.get_word().substring(0, 1).equals("ה"))
					{
						nppl.set_h(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("ת"))
					{
						nppl.set_t(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("י"))
					{
						nppl.set_i(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("נ"))
					{
						nppl.set_n(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("ו"))
					{
						nppl.set_v(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("ש"))
					{
						if((ppl.get_i() == true)||(ppl.get_a() == true)||(ppl.get_t() == true))
						{
							return;
						}
						nppl.set_s(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("ב"))
					{
						if((ppl.get_i() == true)||(ppl.get_l() == true)||(ppl.get_t() == true)||(ppl.get_a() == true)||(ppl.get_d() == true)||(ppl.get_n() == true))
						{
							return;
						}
						nppl.set_b(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("ל"))
					{
						if((ppl.get_i() == true)||(ppl.get_l() == true)||(ppl.get_t() == true)||(ppl.get_b() == true)||(ppl.get_h() == true)||(ppl.get_a() == true)||(ppl.get_d() == true)||(ppl.get_n() == true)||(ppl.get_m() == true))
						{
							return;
						}
						nppl.set_l(true); 	
					}
					if(ppl.get_word().substring(0, 1).equals("מ"))
					{
						if((ppl.get_i() == true)||(ppl.get_l() == true)||(ppl.get_m() == true)||(ppl.get_n() == true))
						{
							return;
						}
						nppl.set_m(true); 	
					}
					Pilpel(nppl, er);
				}
			}
		}
		if(end >=4)
		{
			if(unfinalf(ppl.get_word().substring(sing, end)).equals(ppl.get_word().substring(sing-2,end-2)))
			{
				W_Path nppl = new W_Path(ppl);
				nppl.set_word(finalf(ppl.get_word().substring(0, sing)));
				TW(finalf(ppl.get_word().substring(0, sing)), 1125, e);
				if(finalf(ppl.get_word().substring(0, sing)).length() < 3)
				{
					permutate(finalf(ppl.get_word().substring(0, sing)), 1,  1000, f/10, ppl.get_word().length() - 2);
					Irrg(new W_Path(nppl), er);
					return;
				}
				Pilpel(new W_Path(nppl), er);
				form(new W_Path(nppl), f);
			}
			if((ppl.get_word().substring(gen, end).equals("ה"))||(ppl.get_word().substring(gen, end).equals("ם"))||(ppl.get_word().substring(gen, end).equals("ך"))||(ppl.get_word().substring(gen, end).equals("ו"))||(ppl.get_word().substring(gen, end).equals("י"))||(ppl.get_word().substring(gen, end).equals("ן"))||(ppl.get_word().substring(gen, end).equals("ת")))
			{
				if(ppl.get_word().substring(gen, end).equals("ה"))
				{
					TW(ppl.get_word(), 1250, e);	
				}
				if(ppl.get_word().substring(gen-1, end-1).equals(ppl.get_word().substring(gen-2,end-2)))
				{
					W_Path ppl2 = new W_Path(ppl);
					ppl2.set_word(ppl.get_word().substring(0, gen -1) + ppl.get_word().substring(gen , end));
					TW(ppl2.get_word(), 1125, e);
					permutate(ppl2.get_word(), 1,  1000, f/10, ppl2.get_word().length());
				}
				W_Path nppl = new W_Path(ppl);
				nppl.set_word(finalf(ppl.get_word().substring(0, gen))); 
				Pilpel(nppl, er);
			}
			if((ppl.get_word().substring(0, 1).equals("ה"))||(ppl.get_word().substring(0, 1).equals("ש"))||(ppl.get_word().substring(0, 1).equals("ו"))||(ppl.get_word().substring(0, 1).equals("ב"))||(ppl.get_word().substring(0, 1).equals("ת")||(ppl.get_word().substring(0, 1).equals("י")))||(ppl.get_word().substring(0, 1).equals("ל"))||(ppl.get_word().substring(0, 1).equals("נ"))||(ppl.get_word().substring(0, 1).equals("מ")))
			{
				TW(ppl.get_word(), 5, e);
				W_Path nppl = new W_Path(ppl);
				nppl.set_word(ppl.get_word().substring(1));
				if(ppl.get_word().substring(0, 1).equals("ה"))
				{
					nppl.set_h(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("ת"))
				{
					nppl.set_t(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("י"))
				{
					nppl.set_i(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("נ"))
				{
					nppl.set_n(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("ש"))
				{
					if((ppl.get_i() == true)||(ppl.get_a() == true)||(ppl.get_t()))
					{
						return;
					}
					nppl.set_s(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("ו"))
				{
					nppl.set_v(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("ב"))
				{
					if((ppl.get_i() == true)||(ppl.get_l() == true)||(ppl.get_t() == true)||(ppl.get_a() == true)||(ppl.get_d() == true)||(ppl.get_n() == true))
					{
						return;
					}
					nppl.set_b(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("ל"))
				{
					if((ppl.get_i() == true)||(ppl.get_l() == true)||(ppl.get_t() == true)||(ppl.get_b() == true)||(ppl.get_h() == true)||(ppl.get_a() == true)||(ppl.get_d() == true)||(ppl.get_n() == true)||(ppl.get_m() == true))
					{
						return;
					}
					nppl.set_l(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("מ"))
				{
					nppl.set_m(true); 	
				}
				if(ppl.get_word().substring(0, 1).equals("י"))
				{
					TW(ppl.get_word(), 25, e);
					if(ppl.get_word().substring(gen, end).equals("ה"))
					{
						TW(ppl.get_word(), 1300, e);	
					}
				}
				if(unfinalf(ppl.get_word().substring(gen, end)).equals(ppl.get_word().substring(gen-1,end-1)))
				{
					W_Path ppl1 = new W_Path(ppl);
					ppl1.set_word(finalf(ppl.get_word().substring(0, gen)));
					TW(ppl1.get_word(), 1250, e);
					permutate(ppl1.get_word(), 1,  1000, f/10, ppl1.get_word().length());
				}
				if((ppl.get_word().substring(0, 1).equals("ה"))||(ppl.get_word().substring(0, 1).equals("ת"))||(ppl.get_word().substring(0, 1).equals("י"))||(ppl.get_word().substring(0, 1).equals("נ")))
				{
					affix(nppl, er);
				}
				else{
					Pilpel(nppl, er);
				}
			}
		}
		if(end >= 4)
		{
			if(unfinalf(ppl.get_word().substring(sing, end)).equals(ppl.get_word().substring(0, 2)))
			{
				W_Path ppl1 = new W_Path(ppl);
				ppl1.set_word(finalf(ppl.get_word().substring(0, sing)));
				if(ppl.get_word().substring(0, sing).length() < 4)
				{
					form(new W_Path(ppl1), f);
					return;
				}
				permutate(finalf(ppl.get_word().substring(0, sing)), 1,  1000, f/10, ppl.get_word().length() - 2);
				Pilpel(new W_Path(ppl1), er);
			}
			if((ppl.get_word().substring(gen, end).equals("ה"))||(ppl.get_word().substring(gen, end).equals("ך"))||(ppl.get_word().substring(gen, end).equals("ם"))||(ppl.get_word().substring(gen, end).equals("ו"))||(ppl.get_word().substring(gen, end).equals("י"))||(ppl.get_word().substring(gen, end).equals("ן"))||(ppl.get_word().substring(gen, end).equals("ת")))
			{
				if(ppl.get_word().substring(gen, end).equals("ה"))
				{
					TW(ppl.get_word(), 25, e);	
				}
				if(ppl.get_word().substring(sing-1, end-1).equals(ppl.get_word().substring(0, 2)))
				{
					W_Path ppl2 = new W_Path(ppl);
					ppl2.set_word(ppl.get_word().substring(0, sing -1) + ppl.get_word().substring(gen, end));
					TW(ppl2.get_word(), 300, e);
					permutate(ppl2.get_word(), 1,  1000, f/10, ppl2.get_word().length());
				}
				W_Path nppl = new W_Path(ppl);
				nppl.set_word(finalf(ppl.get_word().substring(0, gen)));
				Pilpel(nppl, er);
			}
			if((ppl.get_word().substring(0, 1).equals("ה"))||(ppl.get_word().substring(0, 1).equals("ו"))||(ppl.get_word().substring(0, 1).equals("ש"))||(ppl.get_word().substring(0, 1).equals("ב"))||(ppl.get_word().substring(0, 1).equals("ת")||(ppl.get_word().substring(0, 1).equals("י")))||(ppl.get_word().substring(0, 1).equals("ל"))||(ppl.get_word().substring(0, 1).equals("נ"))||(ppl.get_word().substring(0, 1).equals("מ")))
			{
				TW(ppl.get_word() ,5, e);
				W_Path nppl = new W_Path(ppl);
				nppl.set_word(ppl.get_word().substring(1));
				if(ppl.get_word().substring(0, 1).equals("ה"))
				{
					nppl.set_h(true);	
				}
				if(ppl.get_word().substring(0, 1).equals("י"))
				{
					nppl.set_i(true);	
				}
				if(ppl.get_word().substring(0, 1).equals("ש"))
				{
					if((ppl.get_i() == true)||(ppl.get_a() == true)||(ppl.get_t() == true))
					{
						return;	
					}
					nppl.set_s(true);	
				}
				if(ppl.get_word().substring(0, 1).equals("ו"))
				{
					nppl.set_v(true);	
				}
				if(ppl.get_word().substring(0, 1).equals("ב"))
				{
					if((ppl.get_i() == true)||(ppl.get_l() == true)||(ppl.get_t() == true)||(ppl.get_a() == true)||(ppl.get_d() == true)||(ppl.get_n() == true))
					{
						return;
					}
					nppl.set_b(true);	
				}    
				if(ppl.get_word().substring(0, 1).equals("ת"))
				{
					nppl.set_t(true);	
				}
				if(ppl.get_word().substring(0, 1).equals("ל"))
				{
					if((ppl.get_i() == true)||(ppl.get_l() == true)||(ppl.get_t() == true)||(ppl.get_a() == true)||(ppl.get_b() == true)||(ppl.get_d() == true)||(ppl.get_n() == true)||(ppl.get_m() == true))
					{
						return;
					}
					nppl.set_l(true);	
				}
				if(ppl.get_word().substring(0, 1).equals("נ"))
				{
					nppl.set_n(true);	
				}
				if(ppl.get_word().substring(0, 1).equals("מ"))
				{
					nppl.set_m(true);	
				}    
				if(ppl.get_word().substring(0, 1).equals("י"))
				{
					TW(ppl.get_word(), 25, e);
					if(ppl.get_word().substring(gen, end).equals("ה"))
					{
						TW(ppl.get_word(), 300, e);	
					}
				}
				if(unfinalf(ppl.get_word().substring(sing, end)).equals(ppl.get_word().substring(1, 3)))
				{
					W_Path ppl1 = new W_Path(ppl);
					ppl1.set_word(finalf(ppl.get_word().substring(0, sing)));
					TW(ppl1.get_word(), 300, e);
					permutate(ppl1.get_word(), 1,  1000, f/10, ppl1.get_word().length());
				}
				if((ppl.get_word().substring(0, 1).equals("ה"))||(ppl.get_word().substring(0, 1).equals("ת"))||(ppl.get_word().substring(0, 1).equals("י"))||(ppl.get_word().substring(0, 1).equals("נ")))
				{
					affix(new W_Path(nppl), er);
				}
				else{
					Pilpel(new W_Path(nppl), er);
				}
				Pilpel(new W_Path(nppl), er);
			}
		}
		if(ppl.get_word().length() < 3)
		{     
			Irrg( new W_Path(ppl), er/30);
			return;
		}
		return;
	}
	public W_Path modern(W_Path mdrn, double e)
	{
		if(e < WALL)
		{
			return Irrg(new W_Path(mdrn), e);
		}
		double er = e/100;
		double f = e/50;
		int mend = mdrn.get_word().length();
		int mgen = mend -1;
		int msing = mgen -1;
		int mtring = msing -1;
		
		W_Path plw = new W_Path(mdrn);
		
		int end = plw.get_word().length();
		int gen = end -1;
		int sing = gen -1;
		int tring = sing -1;
		f = e;
		
		if(end < 4)
		{
			return Irrg(new W_Path(plw), er);
		}  	
		if(mdrn.get_word().substring(mgen, mend).equals("י"))
		{    
			plw.set_word(mdrn.get_word() + "ת");
			end = plw.get_word().length();
			gen = end -1;
			sing =gen -1;
			tring = sing -1;
			
			W.yt_M = TW(plw.get_word(), W.yt_M, e);
			if(W.yt_M.delB()>=3.0)
			{
				f = e*Math.pow(2, W.yt_M.ratio());
			}
			form(new W_Path(plw), f);
		}
		if(mdrn.get_word().substring(0, 2).equals("תת"))
		{
			plw = new W_Path(mdrn);
			plw.set_word(finalf(mdrn.get_word().substring(2)));
			plw.set_t(true);
			end = plw.get_word().length();
			gen = end -1;
			sing =gen -1;
			tring = sing -1;
			
			W.tt_M = TW(plw.get_word(), W.tt_M, e);
			if(W.tt_M.delB()>=3.0)
			{
				f = e*Math.pow(2, W.tt_M.ratio());
			}
			form(new W_Path(plw), f);
		}
		if((mdrn.get_word().substring(msing, mend).equals("ית"))||(mdrn.get_word().substring(msing, mend).equals("זה"))||(mdrn.get_word().substring(msing, mend).equals("לי"))||(mdrn.get_word().substring(msing, mend).equals("אי")))
		{
			plw = new W_Path(mdrn);
			plw.set_word(finalf(mdrn.get_word().substring(0, msing)));
			end = plw.get_word().length();
			gen = end -1;
			sing =gen -1;
			tring = sing -1;
			
			if(mdrn.get_word().substring(msing, mend).equals("ית"))
			{
				W.M_it = TW(plw.get_word(), W.M_it, e);
				if(W.M_it.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_it.ratio());
				}
				TW(unfinalf(plw.get_word()) + "ה", W.M_it, f);
			}
			if(mdrn.get_word().substring(msing, mend).equals("זה"))
			{
				W.M_sis = TW(plw.get_word(), W.M_sis, e);
				if(W.M_sis.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_sis.ratio());
				}
			}
			if(mdrn.get_word().substring(msing, mend).equals("לי"))
			{
				W.M_al = TW(plw.get_word(), W.M_al, e);
				if(W.M_al.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_al.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י",W.M_al, f);
			}
			if(mdrn.get_word().substring(msing, mend).equals("אי"))
			{
				W.M_ai = TW(plw.get_word(), W.M_ai, e);
				if(W.M_ai.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_ai.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י",W.M_ai, f);
				TW(unfinalf(plw.get_word()) + "יה",W.M_ai, f);
			}
			if(end >3)
			{
				form(new W_Path(plw), f);
			}
			else{
				return Irrg(new W_Path(plw), f/50);
			}  	      
		}
		if(mend <5)
		{
			return Irrg(new W_Path(plw), er);
		}  	      
		if((mdrn.get_word().substring(mtring, mend).equals("יסט"))||(mdrn.get_word().substring(mtring, mend).equals("יזם"))||(mdrn.get_word().substring(mtring, mend).equals("יות"))||(mdrn.get_word().substring(mtring, mend).equals("יקה"))||(mdrn.get_word().substring(mtring, mend).equals("יקן"))||(mdrn.get_word().substring(mtring, mend).equals("ציה")))
		{
			plw = new W_Path(mdrn);
			plw.set_word(finalf(mdrn.get_word().substring(0, mtring)));
			end = plw.get_word().length();
			gen = end -1;
			sing =gen -1;
			tring = sing -1;
			
			if(mdrn.get_word().substring(mtring, mend).equals("יסט"))
			{
				W.M_ist = TW(plw.get_word(), W.M_ist, e);
				if(W.M_ist.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_ist.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י", W.M_ist, f);
			}
			if(mdrn.get_word().substring(mtring, mend).equals("יזם"))
			{
				W.M_ism = TW(plw.get_word(), W.M_ism, e);
				if(W.M_ism.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_ism.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י",W.M_ism, f);
			}            
			if(mdrn.get_word().substring(mtring, mend).equals("יות"))
			{
				W.M_iot = TW(plw.get_word(), W.M_iot, e);
				if(W.M_iot.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_iot.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י", W.M_iot, f);
				TW(unfinalf(plw.get_word()) + "ה", W.M_iot, f);
			}
			if(mdrn.get_word().substring(mtring, mend).equals("יקה"))
			{
				W.M_iqa = TW(plw.get_word(), W.M_iqa, e);
				if(W.M_iqa.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_iqa.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י",W.M_iqa, f);
			}
			if(mdrn.get_word().substring(mtring, mend).equals("יקן"))
			{
				W.M_iqn = TW(plw.get_word(), W.M_iqn, e);
				if(W.M_iqn.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_iqn.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י",W.M_iqn, f);
			}            
			if(mdrn.get_word().substring(mtring, mend).equals("ציה"))
			{
				W.M_tion = TW(plw.get_word(), W.M_tion, e);
				if(W.M_tion.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_tion.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י",W.M_tion, f);
			}            
			if(end >3)
			{
				form(new W_Path(plw), f);
			}
			else{
				return Irrg(new W_Path(plw), f/50);
			}  	       
		}
		if(mend < 6)
		{
			return Irrg(new W_Path(plw), er);
		}  	      
		if(mdrn.get_word().substring(mtring-1, mend).equals("יסטי")||(mdrn.get_word().substring(mtring-1, mend).equals("לוגי"))||(mdrn.get_word().substring(mtring-1, mend).equals("מטר")))
		{
			plw = new W_Path(mdrn);
			plw.set_word(finalf(mdrn.get_word().substring(0, mtring-1)));
			end = plw.get_word().length();
			gen = end -1;
			sing =gen -1;
			tring = sing -1;
			if(mdrn.get_word().substring(mtring-1 , mend).equals("יסטי"))
			{
				W.M_isti = TW(plw.get_word(), W.M_isti, e);
				if(W.M_isti.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_isti.ratio());
				}
			}
			if(mdrn.get_word().substring(mtring-1, mend).equals("לוגי"))
			{
				W.M_logi = TW(plw.get_word(), W.M_logi, e);
				if(W.M_logi.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_logi.ratio());
				}
			}
			if(mdrn.get_word().substring(mtring-1, mend).equals("מטר"))
			{
				W.M_meter = TW(plw.get_word(), W.M_meter, e);
				if(W.M_meter.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_meter.ratio());
				}
			}
			if(end >3)
			{
				form(new W_Path(plw), f);
			}
			else{
				return Irrg(new W_Path(plw), f/50);
			}  	 
		}
		if(mend < 7)
		{
			return Irrg(new W_Path(plw), er);
		}  	      
		if((mdrn.get_word().substring(mtring-2 , mend).equals("יזציה"))||(mdrn.get_word().substring(mtring-2, mend).equals("לוגיה"))||(mdrn.get_word().substring(mtring-2, mend).equals("מטריה")))
		{
			plw = new W_Path(mdrn);
			plw.set_word(finalf(mdrn.get_word().substring(0, mtring-2)));
			end = plw.get_word().length();
			gen = end -1;
			sing =gen -1;
			tring = sing -1;
			if(mdrn.get_word().substring(mtring-2 , mend).equals("יזציה"))
			{
				W.M_iszih = TW(plw.get_word(), W.M_iszih, e);
				if(W.M_iszih.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_iszih.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י", W.M_iszih, f);
			}
			if(mdrn.get_word().substring(mtring-2 , mend).equals("לוגיה"))
			{
				W.M_logy = TW(plw.get_word(), W.M_logy, e);
				if(W.M_logy.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_logy.ratio());
				}
			}
			if(mdrn.get_word().substring(mtring-2 , mend).equals("מטריה"))
			{
				W.M_metry = TW(plw.get_word(), W.M_metry, e);
				if(W.M_metry.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_metry.ratio());
				}
			}
		}
		if(end >3)
		{
			return form(new W_Path(plw), f);
		}
		if(mend < 8)
		{
			return Irrg(new W_Path(plw), er);
		}  	
		if((mdrn.get_word().substring(mtring-3 , mend).equals("יסטיקן")))
		{
			plw = new W_Path(mdrn);
			plw.set_word(finalf(mdrn.get_word().substring(0, mtring-3)));
			end = plw.get_word().length();
			gen = end -1;
			sing =gen -1;
			tring = sing -1;
			if(mdrn.get_word().substring(mtring-3 , mend).equals("יסטיקן"))
			{
				W.M_istiqn = TW(plw.get_word(), W.M_istiqn, e);
				if(W.M_istiqn.delB()>=3.0)
				{
					f = e*Math.pow(2, W.M_istiqn.ratio());
				}
				TW(unfinalf(plw.get_word()) + "י",W.M_istiqn, f);
			}
			if(end >3)
			{
				form(new W_Path(plw), f);
			}
			else{
				return Irrg(new W_Path(plw), f/50);
			}  	       
		}
		return plw;
	}
	public W_Path Prep(W_Path prs, double e)
	{
		e = e/4;
		if(e < WALL)
		{
			//return Irrg(new W_Path(prs), e);
		}
		int end = prs.get_word().length();
		int sing = end -2;
		int gen = end -1;
		W_Path stem = new W_Path(prs);
		W_Path stem2 =  new W_Path(prs);
		double f = e;
		double er = e/10;
		if(end < 2)
		{
			TW(prs.get_word(), 100, e);
			return Irrg(new W_Path(prs), er);
		}
		if((end > 2)&&((prs.get_word().substring(0, 1).equals("ה"))||(prs.get_word().substring(0, 1).equals("י"))||(prs.get_word().substring(0, 1).equals("נ"))||(prs.get_word().substring(0, 1).equals("ד"))||(prs.get_word().substring(0, 1).equals("ו"))||(prs.get_word().substring(0, 1).equals("מ"))||(prs.get_word().substring(0, 1).equals("ב"))||(prs.get_word().substring(0, 1).equals("ל"))||(prs.get_word().substring(0, 1).equals("ת"))||(prs.get_word().substring(0, 1).equals("ש"))||(prs.get_word().substring(0, 1).equals("כ"))))
		{
			 
			if(prs.get_word().substring(0, 1).equals("י"))
			{
				stem.set_word(prs.get_word().substring(1));
				stem.set_i(true);
				W.Yod = TW(stem.get_word(), W.Yod, e);
				if(W.Yod.delB()>=3.0)
				{
					f = e*Math.pow(2, W.Yod.ratio());
				}
				else{
					 f= e/60;
				}
				form(new W_Path(stem), f);
			}
			if(prs.get_word().substring(0, 1).equals("ו"))
			{
				stem.set_word(prs.get_word().substring(1));
				stem.set_v(true);
				W.Vav = TW(stem.get_word(), W.Vav, e);
				if(W.Vav.delB()>=3.0)
				{
					f = e*Math.pow(2, W.Vav.ratio());
				}
				else{
					f= e/10;
				}
				form(new W_Path(stem), f);
			}
			if(prs.get_word().substring(0, 1).equals("ת"))
			{
				stem.set_word(prs.get_word().substring(1));
				stem.set_t(true);
				W.Tav = TW(stem.get_word(), W.Tav, e);
				if(W.Tav.delB()>=3.0)
				{
					f = e*Math.pow(2, W.Tav.ratio());
				}  
				else{
					 f= e/70;
				}
				form(new W_Path(stem), f);
			}
			if(prs.get_word().substring(0, 1).equals("נ"))
			{
				stem.set_word(prs.get_word().substring(1));
				stem.set_n(true);
				W.Nun = TW(stem.get_word(), W.Nun, e);
				if(W.Nun.delB()>=3.0)
				{
					f = e*Math.pow(2, W.Nun.ratio());
				}
				else{
					f= e/10;
				}
				form(new W_Path(stem), f);
			}
			if((prs.get_i() == false)&&(prs.get_a() == false))
			{
				if(prs.get_word().substring(0, 1).equals("ה"))
				{
					stem.set_word(prs.get_word().substring(1));
					stem.set_h(true);
					W.Hey = TW(stem.get_word(), W.Hey, e);    
					if(W.Hey.delB()>=3.0)
					{
						f = e*Math.pow(2, W.Hey.ratio());
					}
					else{
						f= e/2;
					}
					form(new W_Path(stem), f);
				}
				if(prs.get_t() == false)
				{
					if(prs.get_word().substring(0, 1).equals("כ"))
					{
						stem.set_word(prs.get_word().substring(1));
						stem.set_c(true);
						W.Kalf = TW(stem.get_word(), W.Kalf, e);
						if(W.Kalf.delB()>=3.0)
						{
							f = e*Math.pow(2, W.Kalf.ratio());
						}
						else{
							 f= e/80;
						}
						form(new W_Path(stem), f);
					}
					if(prs.get_word().substring(0, 1).equals("ש"))
					{
						stem.set_word(prs.get_word().substring(1));
						stem.set_s(true);
						W.Sin = TW(stem.get_word(), W.Sin, e);
						if(W.Sin.delB()>=3.0)
						{
							f = e*Math.pow(2, W.Sin.ratio());
						}  
						else{
							f= e/70;
						}
						form(new W_Path(stem), f);
					}
					if(prs.get_word().substring(0, 1).equals("ב"))
					{
						stem.set_word(prs.get_word().substring(1));
						stem.set_b(true);
						W.Bet = TW(stem.get_word(), W.Bet, e);
						if(W.Bet.delB()>=3.0)
						{
							f = e*Math.pow(2, W.Bet.ratio());
						}
						else{
							 f= e/30;
						}
						form(new W_Path(stem), f);
					}
					TW(stem.get_word(), 12, e);
					if((prs.get_m() == false)&&(prs.get_h() == false)&&(prs.get_b() == false)&&(prs.get_l() == false))
					{
						if(prs.get_word().substring(0, 1).equals("ל"))
						{
							stem.set_word(prs.get_word().substring(1));
							stem.set_l(true);
							W.Lamed = TW(stem.get_word(), W.Lamed, e);
							if(W.Lamed.delB()>=3.0)
							{
								f = e*Math.pow(2, W.Lamed.ratio());
							}
							else{
								f= e/40;
							}
							form(new W_Path(stem), f);
						}
					}
					if(prs.get_word().substring(0, 1).equals("מ"))
					{
						stem.set_word(prs.get_word().substring(1));
						stem.set_m(true);
						W.Mem = TW(stem.get_word(), W.Mem, e);
						if(W.Mem.delB()>=3.0)
						{
							f = e*Math.pow(2, W.Mem.ratio());	
						}
						else{
							 f= e/60;
						}
						form(new W_Path(stem), f);
					}
					if(prs.get_word().substring(0, 1).equals("ד"))
					{
						stem.set_word(prs.get_word().substring(1));
						stem.set_d(true);
						if(Aramaic == true)
						{
							W.Delet.setA(500);
						}
						W.Delet = TW(stem.get_word(), W.Delet, e);
						if(!Aramaic == true)
						{
							//stem = new W_Path(prs);
						}
						if(W.Delet.delB()>=3.0)
						{
							f = e*Math.pow(2, W.Delet.ratio());
						}
						else{
							 f= e/14;
						}
						form(new W_Path(stem), f);
					}
				}
			}
			if(stem.get_word().length() >2)
			{
				stem(new W_Path(stem), f);
			}
		}
		if(prs.get_word().substring(gen, end).equals("א"))
		{
			if(Aramaic == true)
			{
				W.Alf.setA(10000);
			}
			if(prs.get_word().substring(0, 1).equals("ד"))
			{
				W.Alf = TW(finalf(stem.get_word().substring(0, gen-1)), W.Alf, e);
			}
			else{
				W.Alf = TW(finalf(prs.get_word().substring(0, gen)), W.Alf, e);
			}
			if(Aramaic == true)
			{
				if(prs.get_word().substring(0, 1).equals("ד"))
				{
					stem2 = new W_Path(stem);
					stem2.set_word(finalf(stem.get_word().substring(0, gen-1)));
				}
				else{
					stem2 = new W_Path(prs);
					stem2.set_word(finalf(prs.get_word().substring(0, gen)));
				}
			}
			if(Aramaic == true)
			{
				if(W.Alf.delB()>=3.0)
				{
					f = e*Math.pow(2, W.Alf.ratio());
				}
				else{
					 f= e/20;
				}
			}
		}
		if(Aramaic == true)
		{	
			Aramaic(new W_Path(prs), e);
		}
		return stem;
	}
	public W_Path Aramaic(W_Path arm, double e)
	{
		if(e < WALL)
		{
			return Irrg(new W_Path(arm), e);
		}
		int end = arm.get_word().length();
		int gen = end -1;
		int sing = gen -1;
		int tri = sing - 1;
		double er = e/100;
		double f = e/50;
		W_Path farm =  new W_Path(arm);
		if(end < 3)
		{
			tableW(finalf(arm.get_word()));
			if(((arm.get_word().substring(gen, end).equals("א")) == false)&&(end > 1))
			{
				farm.set_word(unfinalf(arm.get_word()) + "א");
				TW(farm.get_word(), 200, e);
				permutate(farm.get_word(), 1, 1200, f/300, farm.get_word().length());
			}
			arm.set_word(finalf(arm.get_word()));
			return arm;  
		}
		f = e;
		if(arm.get_word().substring(0, 3).equals("דיל"))
	         {
	         	farm.set_word(arm.get_word().substring(3));
	         	farm.set_d(true);
	         	farm.set_i(true);
	         	farm.set_d(true);
	          	TW(farm.get_word(), 2000, e);
	           	permutate(farm.get_word(), 1, 1000, f/30, farm.get_word().length());
	          	form(new W_Path(farm), f);
	          	return farm;
	         }
		if((arm.get_word().substring(0, 1).equals("ו"))||(arm.get_word().substring(0, 1).equals("א"))||(arm.get_word().substring(0, 1).equals("ד"))||(arm.get_word().substring(0, 1).equals("ת"))||(arm.get_word().substring(0, 1).equals("ל"))||(arm.get_word().substring(0, 1).equals("ב"))||(arm.get_word().substring(0, 1).equals("מ")))
	         {
	         	farm = new W_Path(arm);
			if(arm.get_word().substring(0, 1).equals("ד"))
			{
				farm.set_d(true);	
			}
			if(arm.get_word().substring(0, 1).equals("ו"))
			{
				farm.set_v(true);	
			}
			if(arm.get_word().substring(0, 1).equals("א"))
			{
				if((arm.get_i() == true)||(arm.get_l() == true)||(arm.get_h() == true)||(arm.get_t() == true)||(arm.get_a() == true)||(arm.get_m() == true))
				{
					return farm;
				}
				farm.set_a(true);	
			}
			if(arm.get_word().substring(0, 1).equals("ת"))
			{
				farm.set_t(true);	
			}
			if(arm.get_word().substring(0, 1).equals("ל"))
			{
				if((arm.get_i() == true)||(arm.get_l() == true)||(arm.get_t() == true)||(arm.get_a() == true)||(arm.get_b() == true)||(arm.get_h() == true)||(arm.get_d() == true)||(arm.get_m() == true)||(arm.get_n() == true))
				{
					return farm;
				}
				farm.set_l(true);	
			}
			if(arm.get_word().substring(0, 1).equals("ב"))
			{
				if((arm.get_i() == true)||(arm.get_l() == true)||(arm.get_a() == true)||(arm.get_d() == true)||(arm.get_h() == true)||(arm.get_t() == true))
				{
					return farm;
				}
				farm.set_b(true);	
			}
			if(arm.get_word().substring(0, 1).equals("מ"))
			{
				if((arm.get_i() == true)||(arm.get_l() == true)||(arm.get_a() == true))
				{
					return farm;
				}
				farm.set_m(true);	
			}
			if(arm.get_word().substring(0, 1).equals("ד"))
			{
				W.Delet = TW(farm.get_word(), W.Delet, e);
				if(W.Delet.delB()>=3.0)
				{
					f = e*Math.pow(2, W.Delet.ratio());
				}
				else{
					f= e/100;
				}
				permutate(farm.get_word(), 1, W.Delet.getA(), f/300, farm.get_word().length());
			}
			farm.set_word(arm.get_word().substring(1));
			if((arm.get_word().substring(0, 1).equals("ת"))||(arm.get_word().substring(0, 1).equals("י"))||(arm.get_word().substring(0, 1).equals("נ"))||(arm.get_word().substring(0, 1).equals("א"))||(arm.get_word().substring(0, 1).equals("ד")))
			{
				return affix(new W_Path(farm), f);
			}	
			form(new W_Path(farm),  f);
		}
		if((arm.get_word().substring(tri, end).equals("כון"))||(arm.get_word().substring(tri, end).equals("התא"))||(arm.get_word().substring(tri, end).equals("הון"))||(arm.get_word().substring(tri, end).equals("תאי"))||(arm.get_word().substring(tri, end).equals("ינא"))||(arm.get_word().substring(tri,end).equals("תיה"))||(arm.get_word().substring(tri, end).equals("תאה")))
		{
			farm = new W_Path(arm);
			farm.set_word(finalf(arm.get_word().substring(0, tri)));
			TW(farm.get_word(), 1200, e);
			permutate(farm.get_word(), 1, 1200, f/300, farm.get_word().length());
			Aramaic(new W_Path(farm), er);
		}
		if((arm.get_word().substring(sing, end).equals("יא"))||(arm.get_word().substring(sing,end).equals("ון"))||(arm.get_word().substring(sing,end).equals("יה"))||(arm.get_word().substring(sing,end).equals("נא"))||(arm.get_word().substring(sing,end).equals("ין"))||(arm.get_word().substring(sing,end).equals("תא")))
		{
			farm = new W_Path(arm);
			farm.set_word(finalf(arm.get_word().substring(0, sing)));
			TW(farm.get_word(), 1200, e);
			permutate(farm.get_word(), 1, 1200, f/300, farm.get_word().length());
			form(new W_Path(farm), f);
		}
		if((arm.get_word().substring(gen, end).equals("א"))||(arm.get_word().substring(gen, end).equals("ן"))||(arm.get_word().substring(gen,end).equals("י"))||(arm.get_word().substring(gen,end).equals("ת"))||(arm.get_word().substring(sing,end).equals("ו"))||(arm.get_word().substring(gen,end).equals("ה")))
		{
			farm = new W_Path(arm);
			farm.set_word(finalf(arm.get_word().substring(0, gen)));
			TW(farm.get_word(), 2000, e);
			permutate(farm.get_word(), 1, 1500, f/300, farm.get_word().length());
			
			W.Alf  = TW(farm.get_word(), W.Alf, e);
			if(W.Alf.delB()>=3.0)
			{
				f = e*Math.pow(2, W.Alf.ratio());
			}
			else{
				 f= e/100;
			}
			form(new W_Path(farm), f);
			permutate(farm.get_word(),  1, W.Alf.getA(), f/300, farm.get_word().length());
			
			if(arm.get_word().substring(gen, end).equals("א"))
			{
				W.Alf_Hey  = TW(unfinalf(farm.get_word()) + "ה", W.Alf_Hey, e);
				if(W.Alf_Hey.delB()>=3.0)
				{
					f = e*Math.pow(2, W.Alf_Hey.ratio());
				}
				else{
					 f= e/100;
				}
				W_Path n_farm = new W_Path(farm);
				n_farm.set_word(unfinalf(farm.get_word()) + "ה");
				form(new W_Path(n_farm),  f);
				permutate(n_farm.get_word(),  1, W.Alf_Hey.getA(), f/300, n_farm.get_word().length());
			}
		}
		if((arm.get_word().substring(gen, end).equals("א"))==false)
		{
			farm = new W_Path(arm);
			farm.set_word(unfinalf(arm.get_word()) + "א");
			TW(farm.get_word(), 200, e);
			permutate(farm.get_word(), 1, 1200, f/300, farm.get_word().length());
		}
		return arm;
	}
	
	/**
		Checks if a word has  any potential Hebrew prefixes.
		@param the word to be checked for prefixes
		@return if a prefix is found in the word then the integer one is returned otherwise the integer zero is returned
	*/
	public int gutteral2(String g)
	{
		int end = g.length();
		if(end < 2)
		{
			return 0;  
		}
		int sing = end -2;
		int gen = end -1;
		if((g.substring(0, 1).equals("ה"))||(g.substring(0, 1).equals("ל")||(g.substring(0, 1).equals("מ"))||(g.substring(0, 1).equals("ב")))||(g.substring(0, 1).equals("ש"))||(g.substring(0, 1).equals("ו"))||(g.substring(0, 1).equals("י"))||(g.substring(0, 1).equals("ת"))||(g.substring(0, 1).equals("כ")))
		{
			return 1;	
		}
		return 0;
	}
	
	/**
		Checks if a word has certain potential Hebrew prefixes.
		@param the word to be checked for certain prefixes
		@return if a prefix is found in the word then the integer one is returned otherwise the integer zero is returned
	*/
	public int gutteral2_c(String g)
	{
		int end = g.length();
		if(end < 2)
		{
			return 0;  
		}
		int sing = end -2;
		int gen = end -1;
		if((g.substring(0, 1).equals("ה"))||(g.substring(0, 1).equals("ל")||(g.substring(0, 1).equals("מ"))||(g.substring(0, 1).equals("ב")))||(g.substring(0, 1).equals("ש"))||(g.substring(0, 1).equals("י"))||(g.substring(0, 1).equals("ת"))||(g.substring(0, 1).equals("כ")))
		{
			return 1;	
		}
		return 0;
	}
	
	/**
		Checks if a word has any potential Hebrew prefixes or postfixes.
		@param the word to be checked for prefixes or postfixes
		@return if a prefix and a postfix is found in the word then three is returned otherwise the integer zero is returned, if a postfix is found (but no prefix) two is returned, if a prefix is found (but no postfix one is returned, otherwise zero is returned
	*/
	public int gutteral(String g)
	{
		int end = g.length();
		int y = 0;
		int z = 0;
		if(end < 2)
		{
			return 0;  
		}
		int sing = end -2;
		int gen = end -1;
		if((g.substring(gen, end).equals("ה"))||(g.substring(gen, end).equals("ו"))||(g.substring(gen, end).equals("י"))||(g.substring(gen, end).equals("ת"))||(g.substring(gen, end).equals("ם"))||(g.substring(gen, end).equals("ך")))	
		{
			z = 1;	
		}
		if((g.substring(0, 1).equals("ה"))||(g.substring(0, 1).equals("ל")||(g.substring(0, 1).equals("מ"))||(g.substring(0, 1).equals("ב")))||(g.substring(0, 1).equals("ש"))||(g.substring(0, 1).equals("ו"))||(g.substring(0, 1).equals("י"))||(g.substring(0, 1).equals("ת"))||(g.substring(0, 1).equals("כ")))	
		{
			y = 1;	
		}
		if((y ==1)&&(z ==1))
		{
			return 3;	
		}
		if(y ==1)
		{
			return 1;	
		}
		if(z ==1)
		{
			return 2;	
		}
		return 0;
	}
	
	/**
		Checks if a word has any potential Hebrew prefixes or certain postfixes.
		@param the word to be checked for prefixes or certain postfixes
		@return if a prefix and a postfix is found in the word then three is returned, if a postfix is found (but no prefix) two is returned, if a prefix is found (but no postfix) one is returned, otherwise zero is returned
	*/
	public int gutteral_b(String g)
	{
		int end = g.length();
		int y = 0;
		int z = 0;
		if(end < 2)
		{
			return 0;  
		}
		int sing = end -2;
		int gen = end -1;
		if((g.substring(gen, end).equals("ה"))||(g.substring(gen, end).equals("ת"))||(g.substring(gen, end).equals("י")))
		{
			z = 1;	
		}
		if((g.substring(0, 1).equals("ה"))||(g.substring(0, 1).equals("ל")||(g.substring(0, 1).equals("מ"))||(g.substring(0, 1).equals("ב")))||(g.substring(0, 1).equals("ש"))||(g.substring(0, 1).equals("ו"))||(g.substring(0, 1).equals("י"))||(g.substring(0, 1).equals("ת"))||(g.substring(0, 1).equals("כ")))	
		{
			y = 1;	
		}
		if((y ==1)&&(z ==1))
		{
			return 3;	
		}
		if(y ==1)
		{
			return 1;	
		}
		if(z ==1)
		{
			return 2;	
		}
		return 0;
	}
	
	/**
		Checks if a word has any potential Hebrew postfixes or certain prefixes .
		@param the word to be checked for postfixes or certain  prefixes
		@return if a prefix and a postfix is found in the word then three is returned, if a postfix is found (but no prefix) two is returned, if a prefix is found (but no postfix) one is returned, otherwise zero is returned
	*/
	public int gutteral_c(String g)
	{
		int end = g.length();
		int y = 0;
		int z = 0;
		if(end < 2)
		{
			return 0;  
		}
		int sing = end -2;
		int gen = end -1;
		if((g.substring(gen, end).equals("ה"))||(g.substring(gen, end).equals("ו"))||(g.substring(gen, end).equals("י"))||(g.substring(gen, end).equals("ת"))||(g.substring(gen, end).equals("ם"))||(g.substring(gen, end).equals("ך")))	
		{
			z = 1;	
		}
		if((g.substring(0, 1).equals("ה"))||(g.substring(0, 1).equals("ל")||(g.substring(0, 1).equals("מ"))||(g.substring(0, 1).equals("ב")))||(g.substring(0, 1).equals("ש"))||(g.substring(0, 1).equals("י"))||(g.substring(0, 1).equals("ת"))||(g.substring(0, 1).equals("כ")))	
		{
			y = 1;	
		}
		if((y ==1)&&(z ==1))
		{
			return 3;	
		}
		if(y ==1)
		{
			return 1;	
		}
		if(z ==1)
		{
			return 2;	
		}
		return 0;
	}
	public W_Path Paricp(W_Path prtcpl, double e)
	{
		e = e/6;
		W_Path ptp = new W_Path(prtcpl);
		if(e < WALL)
		{
			return Irrg(new W_Path(ptp), e);
		}
		double f = e/50;
		double er = e/100;
		int end = ptp.get_word().length();
		int sing = end -2;
		int gen = end -1;
		if(end < 3)
		{
			tableW(finalf(ptp.get_word()));
			ptp.set_word(finalf(ptp.get_word()));
			return ptp;  
		}
		if(ptp.get_word().substring(0, 1).equals("ו"))
		{
			f = e/50;
			ptp.set_word(ptp.get_word().substring(1));
			ptp.set_v(true);
			TW(ptp.get_word(), 70000, e);
			end = ptp.get_word().length();
			sing = end -2;
			gen = end -1;
		}
		TW(ptp.get_word(), 10000, e);
		permutate(finalf(ptp.get_word()), 2, 10000, f/10, ptp.get_word().length());
		if(end < 3)
		{
			tableW(finalf(ptp.get_word()));
			ptp.set_word(finalf(ptp.get_word()));
			return ptp;    
		}
		if(end < 3)
		{
			if(ptp.get_word().substring(sing, gen).equals("ו"))
			{
				f = e/20;
				ptp.set_word(ptp.get_word().substring(0, sing) + ptp.get_word().substring(gen, end));
				ptp.set_word(finalf(ptp.get_word()));
				Noun(new W_Path(ptp), e/20);
				permutate(ptp.get_word(), 2, 1000, f/20, ptp.get_word().length());
				TW(ptp.get_word(), 3000, e);
			}
			end = ptp.get_word().length();
			sing = end -2;
			gen = end -1;
			if(end > 3)
			{
				form(new W_Path(ptp), f);
				return ptp;
			}
			f = e/50;
			if(ptp.get_word().substring(1, 2).equals("ו"))
			{
				ptp.set_word(ptp.get_word().substring(0,1) + ptp.get_word().substring(2));
				ptp.set_word(finalf(ptp.get_word()));
				permutate(ptp.get_word(), 2, 1000, f/10, ptp.get_word().length());
				TW(ptp.get_word(), 13000, e);
			}
			end = ptp.get_word().length();
			sing = end -2;
			gen = end -1;
			if(end > 3)
			{
				return form(new W_Path(ptp), f);
			}
			permutate(ptp.get_word(), 2, 1000, f/10, ptp.get_word().length());
			tableW(ptp.get_word());
		}
		if(end >= 4)
		{
			if(ptp.get_word().substring(sing, end).equals("ים"))
			{
				ptp.set_word(finalf(ptp.get_word().substring(0, sing)));
				end = ptp.get_word().length();
				sing = end -2;
				gen = end -1;
				W.PP_mp = TW(ptp.get_word(), W.PP_mp, e);
				if(W.PP_mp.delB()>=3.0)
				{
					f = e*Math.pow(2, W.PP_mp.ratio());
				}
				else{
					f = e/20;
				}
				permutate(ptp.get_word(), 2, 1000, f/10, ptp.get_word().length());
				if(ptp.get_word().substring(gen, end).equals("י"))
				{
					ptp.set_word(finalf(ptp.get_word().substring(0, gen)));
					W.PPI_mp = TW(ptp.get_word(), W.PPI_mp, e);
					if(W.PPI_mp.delB()>=3.0)
					{
						f = e*Math.pow(2, W.PPI_mp.ratio());
					}
					else{
						f = e/20;
					}
				}
				return Paricp(new W_Path(ptp), f/50);
			}
			if(ptp.get_word().substring(sing, end).equals("ות"))
			{
				TW(ptp.get_word().substring(0, sing) + "ה", 25000, e);
				TW(ptp.get_word().substring(0, sing) + "ת", 13000, e);
				TW(finalf(ptp.get_word().substring(0, sing)), 10000, e);
				W_Path pttp = new W_Path(ptp);
				pttp.set_word(ptp.get_word().substring(0, sing) + "ה");
				return Paricp(pttp, er);
			}
		}
		if(end >= 4)
		{
			if((ptp.get_word().substring(gen, end).equals("ה"))||(ptp.get_word().substring(gen, end).equals("ו"))||(ptp.get_word().substring(gen, end).equals("י"))||(ptp.get_word().substring(gen, end).equals("ך"))||(ptp.get_word().substring(gen, end).equals("נ"))||(ptp.get_word().substring(gen, end).equals("ת")))
			{
				f = e/10;
				if(ptp.get_word().substring(gen, end).equals("ה"))
				{
					TW(ptp.get_word(), 12500, e);	
				}
				TW(finalf(ptp.get_word().substring(0, gen)), 10000, e);
				permutate(finalf(ptp.get_word().substring(0, gen)), 1, 1000, f/10, ptp.get_word().length());
				W_Path pttp = new W_Path(ptp);
				pttp.set_word(finalf(ptp.get_word().substring(0, gen)));
				return Paricp(pttp, er);
			}
			if((ptp.get_word().substring(0, 1).equals("ה"))||(ptp.get_word().substring(0, 1).equals("ת"))||(ptp.get_word().substring(0, 1).equals("נ"))||(ptp.get_word().substring(0, 1).equals("מ")))
			{
				W_Path pttp = new W_Path(ptp);
				pttp.set_word(ptp.get_word().substring(1)); 
				if(ptp.get_word().substring(0, 1).equals("ה"))
				{
					pttp.set_h(true);
				}
				if(ptp.get_word().substring(0, 1).equals("ת"))
				{
					pttp.set_t(true);
				}
				if(ptp.get_word().substring(0, 1).equals("נ"))
				{
					pttp.set_n(true);
				}
				if(ptp.get_word().substring(0, 1).equals("ה"))
				{
					 TW(ptp.get_word().substring(1), 70000, e);
				}
				if((ptp.get_word().substring(0, 1).equals("מ")))
				{
					if((ptp.get_i() == true)||(ptp.get_t() == true)||(ptp.get_a() == true))
					{
						return ptp;	
					}
					pttp.set_m(true);
					TW(pttp.get_word(), 7000, e);
					permutate(pttp.get_word(), 1, 700, f/10, ptp.get_word().length());
					return Paricp(pttp, er);
				}
				TW(ptp.get_word().substring(1), 1300, e);
				if((ptp.get_word().substring(0, 1).equals("ה"))|(ptp.get_word().substring(0, 1).equals("ת"))||(ptp.get_word().substring(0, 1).equals("י"))||(ptp.get_word().substring(0, 1).equals("נ"))||(ptp.get_word().substring(gen, end).equals("ו")))
				{
					pttp = new W_Path(ptp);
					pttp.set_word(ptp.get_word().substring(1));
					
					if(ptp.get_word().substring(0, 1).equals("ה"))
					{
						pttp.set_h(true);
					}
					if(ptp.get_word().substring(0, 1).equals("ת"))
					{
						pttp.set_t(true);
					}
					if(ptp.get_word().substring(0, 1).equals("י"))
					{
						pttp.set_i(true);
					}
					if(ptp.get_word().substring(0, 1).equals("נ"))
					{
						pttp.set_n(true);
					}
					if(ptp.get_word().substring(0, 1).equals("ו"))
					{
						pttp.set_v(true);
					}
					return affix(pttp, er);
				}
				pttp = new W_Path(ptp);
				pttp.set_word(ptp.get_word().substring(1));
				
				if(ptp.get_word().substring(0, 1).equals("ה"))
				{
					pttp.set_h(true);
				}
				if(ptp.get_word().substring(0, 1).equals("ת"))
				{
					pttp.set_t(true);
				}
				if(ptp.get_word().substring(0, 1).equals("נ"))
				{
					pttp.set_n(true);
				}
				if(ptp.get_word().substring(0, 1).equals("מ"))
				{
					if((ptp.get_i() == true)||(ptp.get_t() == true)||(ptp.get_a() == true))
					{
						return ptp;	
					}
					pttp.set_m(true);
				}
				return Paricp(pttp, er);
			}
		}
		ptp.set_word(finalf(ptp.get_word()));
		return ptp;
	}
	public W_Path Metathesis(W_Path mths)
	{
		W_Path mtrm = new W_Path(mths);
		int end = mths.get_word().length();
		int gen = end -1;
		int sing = gen -1;     
		if(end < 3)
		{
			return mths;
		}
		if(mths.get_word().substring(1, 3).equals("צט"))
		{
			mths.set_word(mths.get_word().substring(0, 1) + "צת" +  mths.get_word().substring(3));
		}
		if(mths.get_word().substring(1, 3).equals("זד"))
		{
			W_Path mths2 = new W_Path(mths);
			mths2.set_word(mths.get_word().substring(0, 1) + "תז" +  mths.get_word().substring(3));
			return mths2;
		}
		if((mths.get_word().substring(1, 2).equals("צ"))||(mths.get_word().substring(1, 2).equals("ז"))||(mths.get_word().substring(1, 2).equals("ש"))||(mths.get_word().substring(1, 2).equals("ס")))
		{
			if(mths.get_word().substring(2, 3).equals("ת"))
			{
				mths.set_word(mths.get_word().substring(0, 1) + "ת" + mths.get_word().substring(1, 2) + mths.get_word().substring(3));
			}
		}
		return mths;
	}
	public W_Path Hishtafel(W_Path histfl, double e)
	{
		e = e/4;
		W_Path hstfl = new W_Path(histfl);
		W_Path htrm = new W_Path(hstfl);
		int end = hstfl.get_word().length();
		int gen = end -1;
		int sing = gen -1;  
		double er = e/100;
		double f = e/50;
		if(e < WALL)
		{
			return Irrg(new W_Path(hstfl), e);
		}
		if(end < 4)
		{
			TW(hstfl.get_word(), 700, e);
			return hstfl;
		}
		TW(hstfl.get_word(), 1000, e);
		if(hstfl.get_word().substring(0, 3).equals("השת"))
		{
			TW(hstfl.get_word().substring(3), 5000, e);
		}
		else{
			return hstfl;
		}
		if((hstfl.get_word().substring(sing, end).equals("נה"))||(hstfl.get_word().substring(sing, end).equals("נו"))||(hstfl.get_word().substring(sing, end).equals("תי"))||(hstfl.get_word().substring(sing, end).equals("תם"))||(hstfl.get_word().substring(sing, end).equals("תן")))
		{
			hstfl.set_word(finalf(hstfl.get_word().substring(0, sing)));   
			TW(hstfl.get_word(), 1000, e);
			form(new W_Path(hstfl), er);
			return  Hishtafel(new W_Path(hstfl), er);
		}
		end = hstfl.get_word().length();
		gen = end -1;
		sing = gen -1;  
		if(end < 4)
		{
			TW(hstfl.get_word(), 10000, e);
			return hstfl;
		}
		if((hstfl.get_word().substring(gen, end).equals("ה"))||(hstfl.get_word().substring(gen, end).equals("ו"))||(hstfl.get_word().substring(gen, end).equals("ך"))||(hstfl.get_word().substring(gen, end).equals("ת"))||(hstfl.get_word().substring(gen, end).equals("י")))
		{
			if(hstfl.get_word().substring(gen, end).equals("ה"))
			{
				TW(hstfl.get_word(), 2500, e);	
			}
			hstfl.set_word(finalf(hstfl.get_word().substring(0, gen)));   
			TW(hstfl.get_word(), 2500, e);
			form(new W_Path(hstfl), er);
			return  Hishtafel(new W_Path(hstfl), er);
		}
		return hstfl;
	}
	public W_Path Hitpael(W_Path htpl, double e)
	{
		e = e/6;
		if(e < WALL)
		{
			return Irrg(new W_Path(htpl), e);
		}
		W_Path htrm = new W_Path(htpl);
		int end = htpl.get_word().length();
		int gen = end -1;
		int sing = gen -1;     
		double er = e/100;
		double f = e/50;
		if(end < 3)
		{
			TW(htpl.get_word(), 50, e);
			Noun(new W_Path(htpl), f/30);
			return htpl;
		}
		htpl = new W_Path(Metathesis(htpl));
		if((htpl.get_word().substring(1, 2).equals("ט"))||(htpl.get_word().substring(1, 2).equals("ד")))
		{
			htpl.set_word(htpl.get_word().substring(0, 1) + "ת" + htrm.get_word().substring(1));
		}
		 end = htpl.get_word().length();
		 gen = end -1;
		 sing = gen -1;     
		 if(end < 4)
		{
			TW(htpl.get_word(), 25, e);
			Noun(new W_Path(htpl), er);
			permutate(htpl.get_word(), 1, 25, f, htpl.get_word().length());
			return htpl;
		}
		TW(htpl.get_word(), 100, e);                                                                                  
		if((htpl.get_word().substring(0, 2).equals("תת"))||(htpl.get_word().substring(0, 2).equals("ית"))||(htpl.get_word().substring(0, 2).equals("הת"))||(htpl.get_word().substring(0, 2).equals("מת"))||(htpl.get_word().substring(0, 2).equals("נת")))
		{
			Hitpael(new W_Path(htpl), f);
			if(htpl.get_word().substring(0, 2).equals("תת"))
			{
				htpl.set_t(true);
			}
			if(htpl.get_word().substring(0, 2).equals("ית"))
			{
				htpl.set_t(true);
				htpl.set_i(true);
			}
			if(htpl.get_word().substring(0, 2).equals("הת"))
			{
				htpl.set_t(true);
				htpl.set_h(true);
			}
			if(htpl.get_word().substring(0, 2).equals("מת"))
			{
				htpl.set_t(true);
				htpl.set_m(true);
			}
			if(htpl.get_word().substring(0, 2).equals("נת"))
			{
				htpl.set_t(true);
				htpl.set_n(true);
			}
			htpl.set_word(htpl.get_word().substring(2));
			TW(htpl.get_word(), 1500, e);
			affix(new W_Path(htpl), f);
			Polel(new W_Path(htpl), f);
		}
		else{
			return htpl;
		}
		 end = htpl.get_word().length();
		 gen = end -1;
		 sing = gen -1;     
		 if(end < 4)
		{
			TW(htpl.get_word(), 2050, e);
			Noun(new W_Path(htpl), f);
			return htpl;
		}
		if((htpl.get_word().substring(sing, end).equals("נה"))||(htpl.get_word().substring(sing, end).equals("נו"))||(htpl.get_word().substring(sing, end).equals("תי"))||(htpl.get_word().substring(sing, end).equals("תם"))||(htpl.get_word().substring(sing, end).equals("תן")))
		{
			htpl.set_word(finalf(htpl.get_word().substring(0, sing)));   
			TW(htpl.get_word(), 6000, f);
			Hitpael(new W_Path(htpl), f);
			Polel(new W_Path(htpl), f);
			permutate(htpl.get_word(), 1, 6000, f, htpl.get_word().length());
		}
		end = htpl.get_word().length();
		gen = end -1;
		sing = gen -1;  
		if(end < 4)
		{
			TW(htpl.get_word(), 1000, e);
			Noun(new W_Path(htpl), f);
			return htpl;
		}
		if((htpl.get_word().substring(gen, end).equals("ה"))||(htpl.get_word().substring(gen, end).equals("ו"))||(htpl.get_word().substring(gen, end).equals("ך"))||(htpl.get_word().substring(gen, end).equals("ת"))||(htpl.get_word().substring(gen, end).equals("י")))
		{
			if(htpl.get_word().substring(gen, end).equals("ה"))
			{
				TW(htpl.get_word(), 2500, e);	
			}
			htpl.set_word(finalf(htpl.get_word().substring(0, gen)));   
			TW(htpl.get_word(), 3000, e);
			Hitpael(new W_Path(htpl), f);
			Polel(new W_Path(htpl), f);
			permutate(htpl.get_word(), 1, 1300, f/10, htpl.get_word().length());
		}
		TW(htpl.get_word(), 200, e);
		return htpl;
	}
	public W_Path Hifil(W_Path hfl1, W_Path hfl2, double e)
	{
		e = e/7;
		W_Path hfl = new W_Path(hfl1);
		if(e < WALL)
		{
			return Irrg( new W_Path(hfl), e);
		}
		double er = e/100;
		double f = e/50;
		int begain = 0;
		if(hfl.get_word().equals(hfl2.get_word()) == false)
		{
			begain = 1;
		}
		int end = hfl.get_word().length();
		int sing = end -2;
		int gen = end -1;
		if(begain == 1);
		{
			if((hfl.get_word().substring(0, 1).equals("ו"))&&(begain == 1))
			{
				hfl.set_word( "י" + hfl.get_word().substring(1));
				hfl.set_v(true);
			}
		 }
		 end = hfl.get_word().length();
 		 sing = end -2;
 		 gen = end -1;
		if(end < 3)
		{
			TW(finalf(hfl.get_word()), 10,e);
			Noun(new W_Path(hfl), er/50);
			hfl.set_word(finalf(hfl.get_word()));
			return hfl;  
		}
		if((end == 5)&&(hfl.get_word().substring(gen, end).equals("ה")))
		{
			if(hfl.get_word().substring(sing -1, gen -1).equals("י"))
			{
				W_Path fs = new W_Path(hfl);
				fs.set_word(hfl.get_word().substring(0, sing -1) + hfl.get_word().substring(gen -1, end));
				if(checkW(fs.get_word()) == 1)
				{
					TW(fs.get_word(), 3500, e);
					return fs;
				}
			}
			else{
				TW(hfl.get_word(), 500, e);
			}
		}
		if(end >= 3)
		{
			if(hfl.get_word().substring(sing, gen).equals("י"))
			{
				hfl.set_word(hfl.get_word().substring(0, sing) + hfl.get_word().substring(gen, end));
				TW(hfl.get_word(), 5000, e);
				return affix(new W_Path(hfl), e);
			}
			if((hfl.get_word().substring(0, 1).equals("ה")))
			{
				hfl.set_word(hfl.get_word().substring(1));
				hfl.set_h(true);
				TW(hfl.get_word(), 2500, e);
				Hifil(new W_Path(hfl), new W_Path(hfl2), er);
				end = hfl.get_word().length();
				sing = end -2;
				gen = end -1;
				if(end >= 1)
				{
					Noun(new W_Path(hfl), er);
				}
				if(end < 2)
				{
					return Irrg(new W_Path(hfl), er);
				}
			}
			if((hfl.get_word().substring(gen, end).equals("י"))||(hfl.get_word().substring(gen, end).equals("ה"))||(hfl.get_word().substring(gen, end).equals("ך"))||(hfl.get_word().substring(gen, end).equals("ו"))||(hfl.get_word().substring(gen, end).equals("נ"))||(hfl.get_word().substring(gen, end).equals("ת"))||(hfl.get_word().substring(gen, end).equals("מ"))||(hfl.get_word().substring(gen, end).equals("ן"))||(hfl.get_word().substring(gen, end).equals("ם"))&&(end > 2))
			{
				if(hfl.get_word().substring(gen, end).equals("ה"))
				{
					TW(hfl.get_word(), 2500, e);	
				}
				permutate(finalf(hfl.get_word().substring(0, gen)), 1, 500, f/10, hfl.get_word().length());
				 W_Path thfl = new W_Path(hfl);
				thfl.set_word(finalf(hfl.get_word().substring(0, gen)));
				if((hfl.get_word().substring(gen, end).equals("ת"))&&(hfl.get_word().substring(sing, gen).equals("ה") == false))
				{
					thfl.set_word(unfinalf(thfl.get_word()) + "ה");     
				}
				TW(thfl.get_word(), 5000, e);
				hfl.set_word(finalf(hfl.get_word()));
				Hifil(new W_Path(thfl), new W_Path(hfl1), er);
			}
			if((hfl2.get_word().substring(0, 1).equals("ת") == false)&&(hfl2.get_word().substring(0, 1).equals("י") == false)&&(hfl2.get_word().substring(0, 1).equals("א") == false))
			{
				if((hfl.get_word().substring(0, 1).equals("ו"))||(hfl.get_word().substring(0, 1).equals("י"))||(hfl.get_word().substring(0, 1).equals("ה"))||(hfl.get_word().substring(0, 1).equals("ת"))||(hfl.get_word().substring(0, 1).equals("נ"))||(hfl.get_word().substring(0, 1).equals("מ"))&&(end > 2))
				{
					if(hfl.get_word().substring(0, 1).equals("ה")||(hfl.get_word().substring(0, 1).equals("ו")))
					{
						TW(hfl.get_word().substring(1), 70000, e);
					}
					if(hfl.get_word().substring(0, 1).equals("מ"))
					{
						TW(hfl.get_word(), 1000, e);
					}
					if(hfl.get_word().substring(0, 1).equals("י"))
					{
						TW(hfl.get_word(), 2500, e);	
						if(hfl.get_word().substring(gen, end).equals("ה"))
						{
							TW(hfl.get_word(), 3000, e);
						}
					}
					if(hfl.get_word().substring(0, 1).equals("ה"))
					{
						TW(hfl.get_word().substring(1), 5000, e);	
					}
					W_Path nhfl =  new W_Path(hfl);
					nhfl.set_word(hfl.get_word().substring(1));
					if(hfl.get_word().substring(0, 1).equals("ו"))
					{
					 	nhfl.set_v(true);	
					}
					if(hfl.get_word().substring(0, 1).equals("י"))
					{
					 	nhfl.set_i(true);	
					}
					if(hfl.get_word().substring(0, 1).equals("ה"))
					{
					 	nhfl.set_h(true);	
					}
					if(hfl.get_word().substring(0, 1).equals("ת"))
					{
					 	nhfl.set_t(true);	
					}
					if(hfl.get_word().substring(0, 1).equals("נ"))
					{
					 	nhfl.set_n(true);	
					}
					if(hfl.get_word().substring(0, 1).equals("מ"))
					{
					 	nhfl.set_m(true);	
					}
					
					return Hifil(new W_Path(nhfl), new W_Path(hfl), er);
				}
			}
		}
		hfl.set_word(finalf(hfl.get_word()));
		TW(hfl.get_word(), 100,e);
		return hfl;
	}
	public W_Path piel(W_Path pielw, double e)
	{
		e = e/3;
		if(e < WALL)
		{
			return Irrg(new W_Path(pielw), e);
		}
		W_Path plw = new W_Path(pielw);
		
		int end = plw.get_word().length();
		int gen = end -1;
		int sing =gen -1;
		double er = e/100;
		double f = e/50;
		if(end < 3)
		{
			       return plw;
		}  	      
		if((plw.get_word().substring(gen, end).equals("י"))||(plw.get_word().substring(gen, end).equals("ה"))||(plw.get_word().substring(gen, end).equals("ו"))||(plw.get_word().substring(gen, end).equals("ך"))||(plw.get_word().substring(gen, end).equals("ת"))||(plw.get_word().substring(gen, end).equals("מ"))||(plw.get_word().substring(gen, end).equals("ן"))||(plw.get_word().substring(gen, end).equals("ם"))&&(end > 3))
		{
			f = e/20;
			permutate(finalf(plw.get_word().substring(0, gen)), 1, 1000, f/10, plw.get_word().length());
			TW(finalf(plw.get_word().substring(0, gen)), 500000, e);
			W_Path plow = new W_Path(plw);
			plow.set_word(finalf(plw.get_word().substring(0, gen)));
			piel(new W_Path(plow), f);
		}
		f= e/70;
		if(plw.get_word().substring(1, 2).equals("י"))
		{
			plw.set_word(plw.get_word().substring(0, 1) + plw.get_word().substring(2));
			end = plw.get_word().length();
			gen = end -1;
			sing =gen -1;
			
			W.PIL = TW(plw.get_word(), W.PIL, e);
			if(W.PIL.delB()>=3.0)
			{
				f = e*Math.pow(2, W.PIL.ratio());
			}
			stem(new W_Path(plw), f);
			return Hifil(new W_Path(plw), new W_Path(pielw), f/50);
		}
		return plw;
	}
	public W_Path suffix(W_Path sfplw, double e)
	{
		e = e/2;
		if(e < WALL)
		{
			//return Irrg(new W_Path(sfplw), e);
		}
		int sfend = sfplw.get_word().length();
		int sfgen = sfend -1;
		int sfsing = sfgen -1;
		
		String plw = sfplw.get_word();
		W_Path plow = new W_Path(sfplw);
		if(plw.length() < 3)
		{
			return Irrg(new W_Path(plow), e/50);
		}  	      
		int end = plw.length();
		int gen = end -1;
		int sing = gen -1;
		double er = e/100;
		double f = e/50;
		int mult = 0;
		if(sfplw.get_word().substring(sfsing-1,sfend).equals("נהו"))
		{
			 String enr = finalf(sfplw.get_word().substring(0,sfsing-1));
			 W_Path ennr = new W_Path(sfplw);
			 ennr.set_word(enr);
			 Polel(ennr, er);
			 permutate(enr, 2, 10000, f/30, plw.length());
		}
		if((sfplw.get_word().substring(sfsing, sfend).equals("ית"))||(sfplw.get_word().substring(sfsing, sfend).equals("תי"))||(sfplw.get_word().substring(sfsing, sfend).equals("ני"))||(sfplw.get_word().substring(sfsing, sfend).equals("תה"))||(sfplw.get_word().substring(sfsing,sfend).equals("הו"))||(sfplw.get_word().substring(sfsing, sfend).equals("נו"))||(sfplw.get_word().substring(sfsing, sfend).equals("כם"))||(sfplw.get_word().substring(sfsing, sfend).equals("יו"))||(sfplw.get_word().substring(sfsing, sfend).equals("כן"))||(sfplw.get_word().substring(sfsing, sfend).equals("כה"))||(sfplw.get_word().substring(sfsing, sfend).equals("הם"))||(sfplw.get_word().substring(sfsing, sfend).equals("הן"))&&(sfend > 3))
		{	
			mult = 1;
			plw = finalf(sfplw.get_word().substring(0, sfsing));
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
		        	sing = gen -1;
		        
			sfend = sfplw.get_word().length();
 			sfgen = sfend -1;
 			sfsing = sfgen -1;
 			f= e/70;
 			 if(sfplw.get_word().substring(sfsing, sfend).equals("ית"))
			 {
			 	W.IT = TW(plw, W.IT, e);
			 	if(W.IT.delB()>=3.0)
			 	{
			 		f = e*Math.pow(2, W.IT.ratio());
			 	}
			 	TW(unfinalf(plw) + "ה", W.IT, f);
			 }
			 if(sfplw.get_word().substring(sfsing, sfend).equals("תי"))
			{
				W.TI = TW(plw, W.TI, e);
				if(W.TI.delB()>=3.0)
				{
					f = e*Math.pow(2, W.TI.ratio());
				}
			}
			if(sfplw.get_word().substring(sfsing, sfend).equals("תה"))
			{
				W.TH = TW(plw, W.TH, e);
				if(W.TH.delB()>=3.0)
				{
					f = e*Math.pow(2, W.TH.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("ני"))
			{
				W.NI =TW(plw, W.NI, e);
				if(W.NI.delB()>=3.0)
				{
					f = e*Math.pow(2, W.NI.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("הו"))
			{
				W.HV = TW(plw, W.HV, e);
				if(W.HV.delB()>=3.0)
				{
					f = e*Math.pow(2, W.HV.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("נו"))
			{
				W.NV = TW(plw, W.NV, e);
				if(W.NV.delB()>=3.0)
				{
					f = e*Math.pow(2, W.NV.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("כם"))
			{
				W.CM = TW(plw, W.CM, e);
				if(W.CM.delB()>=3.0)
				{					
					f = e*Math.pow(2, W.CM.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("יו"))
			{
				W.IV = TW(plw, W.IV, e);
				if(W.IV.delB()>=3.0)
				{
					f = e*Math.pow(2, W.IV.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("כן"))
			{
				W.CN = TW(plw, W.CN, e);  
				if(W.CN.delB()>=3.0)
				{
					f = e*Math.pow(2, W.CN.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("כה"))
			{
				W.CH = TW(plw, W.CH, e);
				if(W.CH.delB()>=3.0)
				{
					f = e*Math.pow(2, W.CH.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("הם"))
			{
				W.HM = TW(plw, W.HM, e);  
				if(W.HM.delB()>=3.0)
				{
					f = e*Math.pow(2, W.HM.ratio());
				}
			}
			 if(sfplw.get_word().substring(sfsing, sfend).equals("הן"))
			{
				W.HN = TW(plw, W.HN, e);  
				if(W.HN.delB()>=3.0)
				{
					f = e*Math.pow(2, W.HN.ratio());
				}
			}

			 permutate(plw, 2, 1000, f/30, plw.length());
			 if(plw.length() >= 3)
			 {	               
				if((plw.substring(1,2).equals("ו"))&&((plw.substring(0,1).equals("י"))||(plw.substring(0,1).equals("נ"))))
				{
					String temph =  "ה" +  plw.substring(1);
					W_Path temphh = new W_Path(plow);
					temphh.set_word(temph);
					if(plw.substring(0,1).equals("י"))
					{
						temphh.set_i(true);
					}
					else{
						temphh.set_n(true);
					}
					TW(temph, 5000, e);
					temph = plw.substring(1);
					affix(temphh, er);
				}
				plow.set_word(plw);
				if(plw.length() >= 3)
				{
					TW(plw, 5000, f);
				
					end = plw.length();
					gen = end -1; 
					sing = end -2; 
					mult = 1;
					f = e/50;
					form(new W_Path(plow), f);
				}
			}
		}
		permutate(plw, 2, 1000, f/30, plw.length());
		plow.set_word(plw);
		if(plw.length() < 3)
		{
			Irrg(new W_Path(plow), f/50);
		} 
		plw = sfplw.get_word();
		end = plw.length();
		gen = end -1;
		sing = gen -1;
		if(plw.length() >1)
		{
			if((sfplw.get_word().substring(sfgen, sfend).equals("ו"))||(sfplw.get_word().substring(sfgen, sfend).equals("ם"))||(sfplw.get_word().substring(sfgen, sfend).equals("ן"))||(sfplw.get_word().substring(sfgen, sfend).equals("ך"))||(sfplw.get_word().substring(sfgen, sfend).equals("ה"))&&(sfend > 2))
			{	
				 plw = finalf(sfplw.get_word().substring(0, sfgen));
				 plow.set_word(plw);
				 end = plw.length();
				gen = end -1;
				sing = gen -1;
				if(sfplw.get_word().substring(sfgen, sfend).equals("ה"))
				{
					W.Hey2 = TW(plw, W.Hey2, e);  
					if(W.Hey2.delB()>=3.0)
					{
						f = e*Math.pow(2, W.Hey2.ratio());
					}
					else{
						f = e/90;
					}
				}
				if(sfplw.get_word().substring(sfgen, sfend).equals("ו"))
				{
					W.Vav2 = TW(plw, W.Vav2, e);
					if(W.Vav2.delB()>=3.0)
					{

						f = e*Math.pow(2, W.Vav2.ratio());
					}
					else{
						f = e/20;
					}

				}
				if(sfplw.get_word().substring(sfgen, sfend).equals("ם"))
				{
					W.Mem2 = TW(plw, W.Mem2, e);
					if(W.Mem2.delB()>=3.0)
					{
						f = e*Math.pow(2, W.Mem2.ratio());
					}
					else{
						f = e/70;

					}
				}
				if(sfplw.get_word().substring(sfgen, sfend).equals("ן"))
				{
					W.Nun2 = TW(plw, W.Nun2, e);
					if(W.Nun2.delB()>=3.0)
					{
						f = e*Math.pow(2, W.Nun2.ratio());
					}
					else{
						f = e/50;
					}
				}
				if(sfplw.get_word().substring(sfgen, sfend).equals("ך"))
				{
					W.Kalf2 = TW(plw, W.Kalf2, e);
					if(W.Kalf2.delB()>=3.0)
					{
						f = e*Math.pow(2, W.Kalf2.ratio());
					}
					else{
						f = e/40;
					}
				}
				if((plw.substring(1, 2).equals("ו"))&&((plw.substring(0, 1).equals("א"))||(plw.substring(0, 1).equals("י"))||(plw.substring(0, 1).equals("נ"))))
				{
					String temph =  "ה" +  plw.substring(1);
					W.Vav2_Hay = TW(temph,W.Vav2_Hay, e);
					temph = plw.substring(1);
					W_Path temphh = new W_Path(plow);
					temphh.set_word(temph);
					if(plw.substring(0,1).equals("י"))
					{
						temphh.set_i(true);
					}
					if(plw.substring(0,1).equals("א"))
					{
						if((plow.get_i() == true)||(plow.get_l() == true)||(plow.get_h() == true)||(plow.get_t() == true)||(plow.get_a() == true)||(plow.get_m() == true))
						temphh.set_a(true);
					}
					if(plw.substring(0,1).equals("נ"))
					{
						temphh.set_n(true);
					}
					posses(new W_Path(temphh), f);	
					W.Vav_2 = TW(temph,W.Vav_2, e);
					form(new W_Path(plow), f);
				}
				plow.set_word(plw);
				end = plw.length();
				gen = end -1;
				sing = gen -1;
				if(sfplw.get_word().substring(sfgen, sfend).equals("ה"))
				{
					W.Hey_2 = TW(plw, W.Hey_2, e);
					if(W.Hey_2.delB()>=3.0)
					{
						f = e*Math.pow(2, W.Hey_2.ratio());
					}
				}
				W.Suff = TW(plw, W.Suff, e);	
				permutate(plw, 2, 1000, f/30, plw.length());
				if(plw.length() >1)
				{
					end = plw.length();
					gen = end -1; 
					sing = end -2;
					if(plw.length() < 3)
					{
						return Irrg(new W_Path(plow), f/50);
					}   
				}
			}
		}
		return plow;
	}
	public W_Path form(W_Path frm, double e)
	{
		double new_e = e/1000;
		double er = e/31;
		String rm = frm.get_word();
		if(e < WALL)
		{
			//return Irrg(new W_Path(frm), new_e);
		}
		if(rm.length() <2)
		{
			return Irrg(new W_Path(frm), er);
		}
		call_form(new W_Path(frm), new_e);
		return frm;
	}
	public W_Path call_form(W_Path form, double e)
	{
		 double f = e;
		 double f2 = e/10;
		 double f8 = e/80;
		 double f10 = e/1000;
		W_Path frm = new W_Path(form);
		W_Path m_wd = new W_Path(form);
		 double P = infinity/10;
		 double Psdoinf = infinity/2;
		 double Inf = Psdoinf*(e/P);
		
		f = e;
		double g = e;
		double g1 = g; 
		double g2 = g;
		double g3 = g;
		double g4 = g;
		double g5 = g;
		double g6 = g;
		double g7 = g;
		double g8 = g;
		double g9 = g;
		double g10 = g;
		double g11 = g;
		double g12 = g;
		double g13 = g;
		
		double h = f2;
		double h1 = h;
		double h2 = h;
		double h3 = h;
		double h4 = h;
		double h5 = h;
		double h6 = h;
		double h7 = h;
		
		if((form.get_i() == false)&&(form.get_a() == false)&&(form.get_t() == false))
		{
			Prep(new W_Path(form), g2);
		}
		affix(new W_Path(form), g9);
		naun(new W_Path(form), g3);
		Polel(new W_Path(form), g5);
		posses(new W_Path(form), g6);
		suffix(new W_Path(form), g7);
		if((form.get_l() == false))
		{
			prefix(new W_Path(form), g8);
		}
		Noun(new W_Path(form), g10);
		if((form.get_i() == false)&&(form.get_a() == false)&&(form.get_d() == false)&&(form.get_h() == false)&&(form.get_n() == false)&&(form.get_l() == false)&&(form.get_t() == false))
		{
			Inft(new W_Path(form), g11);
		}
		modern(new W_Path(form), g12);
		Paricp(new W_Path(form), g13);
		
		return form;
	}
	public W_Path stem(W_Path stem, double e)
	{
		double new_e = e/4;
		double f = e/100;
		String stm = stem.get_word();
		if(e < WALL)
		{
			return Irrg(new W_Path(stem), new_e);
		}
		if(stm.length() < 2)
		{
			return Irrg(new W_Path(stem), f);
		}
		call_stem(new W_Path(stem), new_e);
		return stem;
	}
	public W_Path call_stem(W_Path stem, double e)
	{
		 double f = e/10;
		String stm = stem.get_word();
		
		double g = e;
		double g1 = g; 
		double g2 = g;
		double g3 = g;
		double g4 = g;
		double g5 = g;
		double g6 = g;
		
		double h = f;
		double h1 = h;
		double h2 = h;
		double h3 = h;
		double h4 = h;
		double h5 = h;
		double h6 = h;
		
		stem.set_word(stm);
		Hitpael(new W_Path(stem), g5);
		piel(new W_Path(stem), g1);    
		Hishtafel(new W_Path(stem) ,g2);
		Hifil(new W_Path(stem), new W_Path(stm), g3);
		nifal(new W_Path(stem),new W_Path(stm), g4);
		Pilpel(new W_Path(stem), g6);
		
		return stem;
	}
	public W_Path affix(W_Path affx, double e)
	{
		e = e/46;
		if(e < WALL)
		{
			//return affx;
		}
		int end = affx.get_word().length();
		int gen = end -1;
		int sing = gen -1;
		if(end < 3)
		{	
			return Irrg(new W_Path(affx), e/50);
		}
		W_Path taffx = new W_Path(affx);
		int tend = taffx.get_word().length();
		int tgen = tend -1;
		int tsing = tgen -1;  
		double f = e/50;
		double er = e/100;
		if(affx.get_word().substring(0, 2).equals("וי"))
		{
			TW(finalf(affx.get_word().substring(2)), 10000, e);
			TW(unfinalf(affx.get_word().substring(2)) + "ה", 25000, e);	
		}
		if((affx.get_word().substring(sing, end).equals("תי"))||(affx.get_word().substring(sing, end).equals("תה"))||(affx.get_word().substring(sing, end).equals("תם"))||(affx.get_word().substring(sing, end).equals("תן"))||(affx.get_word().substring(sing, end).equals("נו"))&&(end > 2))
		{	
			taffx.set_word(finalf(affx.get_word().substring(0, sing)));
			tend = taffx.get_word().length();
			tgen = tend -1;
			tsing = tgen -1;  
			f = e/50;
			if(affx.get_word().substring(sing, end).equals("תה"))
			{
				TW(unfinalf(taffx.get_word()) + "ה", 45500, e);
				f = e/20;
			}
			TW(taffx.get_word(), 20000, e);
			permutate(taffx.get_word(), 1, 1000, f/10, tend);
			if(tend >= 3)
			{
				if(taffx.get_word().substring(0, 2).equals("וי"))
				{
					TW(unfinalf(taffx.get_word().substring(2)) + "ה", 25000, e);
				}
				if(taffx.get_word().substring(tgen, tend).equals("י"))
				{
					String hey = finalf(taffx.get_word().substring(0, tgen));
					TW(hey, 20000, e);
					permutate(hey, 2, 1200, f/10, hey.length());
					hey = unfinalf(taffx.get_word().substring(0, tgen)) + "ת";
					permutate(hey, 2, 1200, f/10, hey.length());
					TW(hey, 18000, e);
				}
				form(new W_Path(taffx), f);
			}
		}
		if((affx.get_word().substring(gen, end).equals("ה"))||(affx.get_word().substring(gen, end).equals("ך"))||(affx.get_word().substring(gen, end).equals("ם"))||(affx.get_word().substring(gen, end).equals("ת"))||(affx.get_word().substring(gen, end).equals("ו")))
		{	
			taffx = new W_Path(affx);
			taffx.set_word(finalf(affx.get_word().substring(0, gen)));
			tend = taffx.get_word().length();
			tgen = tend -1;
			tsing = tgen -1;  
			f = e/90;
			if(affx.get_word().substring(gen, end).equals("ה"))
			{
				if(affx.get_word().substring(sing, end).equals("תה"))
				{
					TW(unfinalf(affx.get_word().substring(0, sing)) + "ה", 10, e);
					f = e/20;
				}
				TW(taffx.get_word(), 25000, e);	
				permutate(taffx.get_word(), 1, 1000, f/10, tend);
				TW(unfinalf(taffx.get_word()) + "ת", 8000, e);    
			}  
			tend = taffx.get_word().length();
			tgen = tend -1;
			tsing = tgen -1;
			if(taffx.get_word().substring(tgen, tend).equals("ת"))
			{
				taffx.set_word("י" + finalf(taffx.get_word().substring(0, tgen)));
				TW(taffx.get_word(), 1000, e);
				TW(unfinalf(taffx.get_word()) + "ה", 10000, e);
				f = e/20;
			}
			tend = taffx.get_word().length();
			tgen = tend -1;
			tsing = tgen -1; 
			if(tend >= 3)
			{
				if(taffx.get_word().substring(0, 2).equals("וי"))
				{
					taffx.set_word(taffx.get_word().substring(2));
					TW(unfinalf(taffx.get_word()) + "ה", 25000, e);
				}
				else{
					TW(taffx.get_word(), 1000, e);
				}
				permutate(taffx.get_word(), 2, 1000, f/10, tend);
				if(tend >= 3)
				{
					tend = taffx.get_word().length();
					tgen = tend -1;
					tsing = tgen -1;     
					if((taffx.get_word().substring(tgen, tend).equals("י"))||(taffx.get_word().substring(tgen, tend).equals("ו")))
					{
						String hey = finalf(taffx.get_word().substring(0, tgen));
						TW(hey, 10000, e);
					}
					form(new W_Path(taffx), f);
				}
			}		
		}
		return affx;
	}      
	public W_Path prefix(W_Path plow, double e)
	{
		e = e/3;
		String plw = plow.get_word();
		if(e < WALL)
		{
			return Irrg(new W_Path(plow), e);
		}
		int end = plw.length();
		if(end < 3)
		{	
			Noun(new W_Path(plow), e/50);
		}
		int sing = end -2;
		int gen = end -1;
		double f = e/50;
		double er = e/100;
		String tempw = plw;
		W_Path tempow = new W_Path(plow);
		int pre = 0;
		/*************************Handling of Prefix Forms ***************************/
		if(((plw.charAt(0)==('י'))||(plw.charAt(0)==('ת'))||(plw.charAt(0)==('ו'))||(plw.charAt(0)==('נ'))||(plw.charAt(0)==('א')))&&(end > 2))
		{
			pre = 1;
			tempw = finalf(plw.substring(1));
			tempow.set_word(tempw);
			
			permutate(tempw, 2, 1000, f/10, tempw.length());
			int tend = tempw.length();
			int tgen = tend -1;
			int tsing = tgen -1;
			if(tend < 3)
			{
				return Irrg(new W_Path(plow), er);
			}
			if((tend >= 2)&&(tempw.substring(0, 1).equals("ו")))
			{
				tempw = tempw.substring(1);
				tempow.set_word(tempw);
				tempow.set_v(true);
				TW(tempw, 10000, e);
				String temph = tempw;
				String tempws = tempw;
				int tends = tempw.length();
				int tgens = tends -1;
				int tsings = tgens -1;
				if(tends < 2)
				{
					return(Irrg(new W_Path(tempow), e/10));
				}
				temph =    "ה" +  tempw;
				tempow.set_word(tempw);
				TW(temph, 10000, e);
				permutate(temph, 2, 800, e/30, temph.length());
				tempws = "י" +  tempw;
				TW(tempws, 10000, e);
				if(tends < 3)
				{
					permutate(tempw, 1, 800, f/20, tempw.length());
					return(Noun(new W_Path(tempow), er/50));
				}
			} 
			if(plw.substring(0, 1).equals("ו"))
			{
				String temph = tempw;
				String tempw2 = tempw;
				tempow.set_v(true);
				if(tend < 3)
				{
					permutate(tempw, 1, 800, f/20, tempw.length());
					return(affix(new W_Path(tempow), er/50));
				}
				if(tend > 3)
				{
					if(tempw.substring(0, 2).equals("יי"))
					{
						tempw =  tempw.substring(2);
						tempow.set_word(tempw);
						tempow.set_i(true);
						tend = tempw.length();
						tgen = tend -1;
						tsing = tgen -1;
						TW(tempw, 18000, e);
						TW(unfinalf(tempw) + "ה", 10, e);
						
						temph =    "ה" +  tempw;
						TW(temph, 1000, e);
						permutate(temph, 2, 800, e/30, temph.length());
					}
				}
				if(tend < 3)
				{
					permutate(tempw, 1, 800, f/30, tempw.length());
					return(affix(new W_Path(tempow), er/50));
				}
				if(tend > 2)
				{
					if(tempw.substring(0, 1).equals("י"))
					{
						tempw =  tempw.substring(1);
						tempow.set_word(tempw);
						tempow.set_i(true);
						tend = tempw.length();
						tgen = tend -1;
						tsing = tgen -1;
						TW(tempw, 1500, e);
						TW(unfinalf(tempw) + "ה", 10, e);
					}
				}
				temph =    "ה" +  tempw;
				permutate(tempw, 1, 800, f/10, tempw.length());
				TW(temph, 10000, e);

				if(tend < 3)
				{
					permutate(tempw, 1, 800, f/20, tempw.length());
					return(affix(new W_Path(tempow), er/50));
				}
			} 
			tend = tempw.length();
			tgen = tend -1;
			tsing = tgen -1;
			
			if(plw.charAt(0)==('י')) /****************Handling of Prefix ****************/
			{
				tempow.set_i(true);
				
				/************Handling of deffent Stem and Verb cases ************/
				if(end >= 2)
				{
					if(tempw.substring(tgen, tend).equals("ה"))
					{
						TW(tempw, 17000, e);
					}
					else{
						TW(plw, 15000, e);
					}	
				}
				tend = tempw.length();
				tgen = tend -1;
				tsing = tgen -1;
				tempow.set_word(tempw);
				affix(new W_Path(tempow), er);
				
				if(tempw.substring(tgen, tend).equals("ו")) /*********Handling of Prefix complements*********/
				{
					tempw = finalf(tempw.substring(0, tgen)); 
					tempow.set_word(tempw);
					tend = tempw.length();
					tgen = tend -1;
					tsing = tgen -1;
					TW(tempw, 89000, e);
					if(tempw.length() < 2)
					{  
						return affix(new W_Path(tempow), er);
					}
					form(new W_Path(tempow), f);
				}
				tend = tempw.length();
				tgen = tend -1;
				tsing = tgen -1;     
				if(tempw.substring(tgen, tend).equals("י"))
				{
					String hey = finalf(tempw.substring(0, tgen));
					TW(hey, 1000, e);
					permutate(hey, 2, 1800, f/10, hey.length());
					permutate(hey, 2, 1800, f/10, hey.length());
					hey = tempw.substring(0, tgen) + "ת";
					TW(hey, 174, e);
					permutate(hey, 2, 1800, f/10, hey.length());
					if(tempw.length() < 2)
					{  
						tempow.set_word(tempw);
						return affix(new W_Path(tempow), er);
					}
				}
				if(tempw.length() < 2)
				{
					return tempow;
				}
			}
			tend = tempw.length();
			tgen = tend -1;
			tsing = tgen -1;
			if((plw.charAt(0)==('נ'))&&(end < 4)) /****************Handling of Prefix ******************/
			{
				tempow.set_n(true);
				TW(plw, 10, e);
				if((tend >= 3)&&(tempw.substring(0, 1).equals("ו")))
				{
					tempw = tempw.substring(1);
					tempow.set_word(tempw);
					tempow.set_v(true);
					if(tend < 2)
					{
						return affix(new W_Path(tempow), er);
					}
					TW(tempw, 8500, e);
					String temph =  "ה" +  tempw;
					TW(temph, 8000, e);
					tempw =  "י" +  tempw;
					TW(tempw, 1000, e);
					tend = tempw.length();
					tgen = tend -1;
					tsing = tgen -1;
					tempow.set_word(tempw);
				} 
				if(tempw.length() < 2)
				{
					return tempow;
				}
				form(new W_Path(tempow), f);
			}
			tempow.set_word(tempw);
			tend = tempw.length();
			tgen = tend -1;
			tsing = tgen -1;
			if((plw.charAt(0)==('א'))&&(plow.get_i() == false)&&(plow.get_l() == false)&&(plow.get_h() == false)&&(plow.get_t() == false)&&(plow.get_a() == false)&&(plow.get_m() == false)) /****************Handling of Prefix ******************/
			{
				pre = 0;
				TW(plw, 5000, e);
				tempow.set_a(true);
				TW(tempw, 12000, e);
				if(tempw.length() <2)
				{
					return affix(new W_Path(tempow), er);
				}
				
				TW(tempw, 10000, e);
				tend = tempw.length();
				tgen = tend -1;
				tsing = tgen -1;
				if((tempw.substring(tgen, tend).equals("י"))||(tempw.substring(tgen, tend).equals("ו")))
				{
					String hey = finalf(tempw.substring(0, tgen));
					TW(hey, 11200, e);
					permutate(hey, 2, 11200, f/10, hey.length());
					hey = tempw.substring(0, tgen) + "ת";
					TW(hey, 1000, e);
					tempow.set_word(tempw);
					if(tempw.length() < 2)
					{
						return affix(new W_Path(tempow), er);
					}
					
				}
				if(tempw.length() < 2)
				{
					return tempow;
				}
				form(new W_Path(tempow), f);
			}
			tempow.set_word(tempw);
			tend = tempw.length();
			tgen = tend -1;
			tsing = tgen -1;
			if(plw.charAt(0)==('ת')) /****************Handling of Prefix ******************/
			{     
				tempow.set_t(true);
				TW(tempw, 20000, e);
 
				/*********Handling of Prefix complements*********/
				if((tempw.substring(tsing, tend).equals("נו"))||(tempw.substring(tsing, tend).equals("נה"))) /*********Handling of Prefix complements*********/
				{
					if((tempw.substring(tsing, tend).equals("נה"))&&(tend < 5))
					{
						TW(tempw.substring(0, tsing) + permutate(tempw.substring(tsing, tend), 1, 20, f/10, tempw.length()), 2000, f);
					}
					tempw = finalf(tempw.substring(0, tsing));  
					tempow.set_word(tempw);
					permutate(tempw,2, 1000, f/10, tempw.length());
					if(tempw.length() < 2)
					{  
						if(tempw.substring(0, 1).equals("ו"))
						{
							affix(new W_Path(tempow), er);
						}
						affix(new W_Path(tempow), er);
					}
					form(new W_Path(tempow), f);
					tempow.set_word(tempw);
					TW(tempw, 815000, e);
					tend = tempw.length();
					tgen = tend -1;
					tsing = tgen -1;     
					if((tempw.substring(tgen, tend).equals("י"))||(tempw.substring(tgen, tend).equals("ו")))
					{
						String hey = finalf(tempw.substring(0, tgen));
						if(tempw.length() < 2)
						{
							return affix(new W_Path(tempow), er);
						}
						TW(hey, 41420, e);
						permutate(hey, 2, 11420, f/10, hey.length());
						hey = tempw.substring(0, tgen) + "ת";
						permutate(hey, 2, 100, f/10, hey.length());
						TW(hey, 1420, e);
					}
					if(tempw.length() < 3)
					{
						return tempow;
					}
				}
				if((tempw.substring(tgen, tend).equals("ו"))||(tempw.substring(tgen, tend).equals("י"))) /*********Handling of Prefix complements*********/
				{
					tempw = finalf(tempw.substring(0, tgen));
					tempow.set_word(tempw);
					TW(tempw, 51500, e);
					permutate(tempw, 2, 1110, f/10, tempw.length());
					if(tempw.length() < 2)
					{  
						return affix(new W_Path(tempow), er);
					}
					tempow.set_word(tempw);
					tend = tempw.length();
					tgen = tend -1;
					tsing = tgen -1;
					if((tempw.substring(tgen, tend).equals("י"))||(tempw.substring(tgen, tend).equals("ו")))
					{
						String hey = finalf(tempw.substring(0, tgen));
						W_Path heyy2 = new W_Path(tempow);
						heyy2.set_word(hey);
						if(hey.length() < 2)
						{  
							return affix(heyy2, er);
						}
						TW(hey, 512000, e);
						permutate(hey, 2, 1000, f/10, hey.length());
						hey = tempw.substring(0, tgen) + "ת";
						TW(hey, 1000, e);
					}
					if(tempw.length() < 3)
					{
						return tempow;
					}
					form(new W_Path(tempow), f);
				}
				if((tempw.substring(tgen, tend).equals("י"))||(tempw.substring(tgen, tend).equals("ו")))
				{
					String hey = finalf(tempw.substring(0, tgen));
					W_Path heyy3 = new W_Path(tempow);
					heyy3.set_word(hey);
					if(hey.length() < 2)
					{  
						return affix(heyy3, er);
					}
					TW(hey, 112000, e);
					permutate(hey, 2, 11200, f/10, hey.length());
					hey = tempw.substring(0, tgen) + "ת";
					permutate(hey, 2, 1000, f/10, hey.length());
					TW(hey, 120000, e);
				}
			}
		}
		return plow;
	}
	public W_Path nifal(W_Path nfl, W_Path nfl2, double e)
	{
		e = e/3;
		if(e < WALL)
		{
			return Irrg(new W_Path(nfl), e);
		}
		String nffl = nfl.get_word();
		String nffl2 = nfl2.get_word();
		String plw = nffl;
		W_Path plow = new W_Path(nfl);
		double er = e/100;
		if(nffl.length() <3)
		{
			return Irrg(new W_Path(nfl), er);   
		}
		int begain = 0;
		if(nffl.equals(nffl2) == false)
		{
			begain = 1;
		}
		int end = plw.length();
		int sing = end -2;
		int gen = end -1;
		double f = e;
		
		f= e/70;
		if((end > 3)&&(nffl.substring(0, 2).equals("ני")))
		{
			plw = nffl.substring(2);
			plow.set_word(plw);
			plow.set_n(true);
			plow.set_i(true);
			end = plw.length();
			sing = end -2;
			gen = end -1;
			
			W.NIL = TW(plw, W.NIL, e);
			if(W.NIL.delB()>=3.0)
			{
				f = e*Math.pow(2, W.NIL.ratio());
			}
			permutate(plw, 2, 1000, f/30, plw.length());
			if(end > 3)
			{
				affix(new W_Path(plow), e);
			}
			Irrg(new W_Path(plow), er);
		}
		if((end > 3)&&(nffl.substring(0, 2).equals("נו")))
		{
			plw =  "י" + nffl.substring(2);
			plow.set_word(plw);
			plow.set_n(true);
			plow.set_v(true);
			end = plw.length();
			sing = end -2;
			gen = end -1;
			
			W.NVL = TW(plw, W.NVL, e);
			if(W.NVL.delB()>=3.0)
			{
				f = e*Math.pow(2, W.NVL.ratio());
			}
			if(end > 3)
			{
				affix(new W_Path(plow), e);
			}
			permutate(plw, 2,W.NVL.getA(), f/30, plw.length());
			Irrg(new W_Path(plow), er);
		}
		if(nffl.substring(0, 1).equals("נ"))
		{
			plw = nffl.substring(1);
			plow = new W_Path(nfl);
			plow.set_word(plw);
			plow.set_n(true);
			end = plw.length();
			sing = end -2;
			gen = end -1;
			W.NL = TW(plw, W.NL, e);
			if(W.NL.delB()>=3.0)
			{
				f = e*Math.pow(2, W.NL.ratio());
			}
			if(end > 3)
			{
				if(nffl.substring(0, 1).equals("נ") == false)
				{
					return form(new W_Path(plow), f);
				}
				else{
					return affix(new W_Path(nfl), e);
				}
			}
			permutate(plw, 2,W.NL.getA(), f/30, plw.length());
			Irrg(new W_Path(plow), er);
		}
		plw = nffl;
		plow = new W_Path(nfl);
		plow.set_word(plw);
		end = plw.length();
		sing = end -2;
		gen = end -1;
		if((nffl2.substring(0, 1).equals("ת"))||(nffl2.substring(0, 1).equals("י"))||(nffl2.substring(0, 1).equals("נ"))||(nffl2.substring(0, 1).equals("א"))||(nffl2.substring(0, 1).equals("ה")))
		{
			return affix(new W_Path(plow), e);
		}
		if((nffl.substring(0, 1).equals("ו"))||(nffl.substring(0, 1).equals("י"))||(nffl.substring(0, 1).equals("ה"))||(nffl.substring(0, 1).equals("ת"))||(nffl.substring(0, 1).equals("א"))||(nffl.substring(0, 1).equals("נ"))||(nffl.substring(0, 1).equals("מ")))
		{
			
			plw = nffl.substring(1);
			plow = new W_Path(nfl);
			plow.set_word(plw);
			if(nffl.substring(0, 1).equals("ו"))
			{
				plow.set_v(true);
			}
			if(nffl.substring(0, 1).equals("י"))
			{
				plow.set_i(true);
			}
			if(nffl.substring(0, 1).equals("ה"))
			{
				plow.set_h(true);
			}
			if(nffl.substring(0, 1).equals("ת"))
			{
				plow.set_t(true);
			}
			if(nffl.substring(0, 1).equals("א"))
			{
				if((nfl.get_i() == true)||(nfl.get_l() == true)||(nfl.get_h() == true)||(nfl.get_t() == true)||(nfl.get_a() == true)||(nfl.get_m() == true))
				{
					return nfl;
				}
				plow.set_a(true);
			}
			if(nffl.substring(0, 1).equals("נ"))
			{
				plow.set_n(true);
			}
			if(nffl.substring(0, 1).equals("מ"))
			{
				if((nfl.get_i() == true)||(nfl.get_l() == true)||(nfl.get_t() == true)||(nfl.get_a() == true)||(nfl.get_n() == true))
				{
					return nfl;
				}
				plow.set_m(true);
			}
			TW(plw, 15000, e);
			end = plw.length();
			sing = end -2;
			gen = end -1;
			permutate(plw, 2, 5000, f/30, plw.length());
			if((nffl.substring(0, 1).equals("ו"))||(nffl.substring(0, 1).equals("ה")))
			{
				TW(plw, 70000, e);
			}
			if(plw.length() >= 3)
			{
				return stem(new W_Path(plow), e); 	
			}
			return Irrg(new W_Path(plow), er);
		}
		return plow;
	}
	public W_Path naun(W_Path nuw, double e)
	{
		e = e/7;
		String nuuw = nuw.get_word();
		if(e < WALL)
		{
			//return Irrg(new W_Path(nuw), e);
		}
		int tend = nuuw.length();
		int tgen = tend -1;
		int tsing = tgen -1;
		
		double er = e/100;
		double f = e/10;
		if(tend < 2)                            
		{
			return Noun(new W_Path(nuw), er);					
		}
		String plw = nuuw;
		W_Path plow = new W_Path(nuw);
		int end = plw.length();
		int gen = end -1;
		int sing = gen -1;
		if(nuuw.substring(tsing, tend).equals("ים"))
		{
			plw = finalf(nuuw.substring(0, tsing));
			W.NN_mp2 = TW(plw,W.NN_mp2, e);
			if(W.NN_mp2.delB()>=3.0)
			{
				f = e*Math.pow(2, W.NN_mp2.ratio());
			}
			else{
				f = e/20;
			}
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			permutate(plw, 2,W.NN_mp2.getA(), f/15, end);
			if(end >= 2)                            
			{
				if(plw.substring(1, 2).equals("נ"))
				{
					plw = plw.substring(0,1) + finalf(plw.substring(2));
					TW(plw, 5000, e);
					permutate(plw, 2, 100, f/30, plw.length());
					TW(unfinalf(plw) + "ה", 1000, e);
					TW(unfinalf(plw) + "ת", 1000, e);
					plow.set_word(plw);
					end = plw.length();
				 	gen = end -1;
				 	sing = gen -1;
					if(end >= 2)                            
					{
						return form(new W_Path(plow), e);
					}
					return Irrg(new W_Path(plow), er);
				}
				if((plw.substring(gen, end).equals("י")))
				{
					plw = finalf(plw.substring(0, gen));
					plow.set_word(plw);
					W.NN_mpi2 = TW(plw,W.NN_mpi2, e);
					end = plw.length();
					gen = end -1;
					sing = gen -1;
					if(end < 2) 
					{
						Irrg(new W_Path(plow), f);
					}      
					
				}
				permutate(plw, 2, 500, er, plw.length());
			}
			else{
				Irrg(new W_Path(plow), f);
			}
		}
		plow.set_word(plw);
		end = plw.length();
		gen = end -1;
		sing = gen -1;
		if(nuuw.substring(tgen, tend).equals("ו"))
		{
			plw = finalf(nuuw.substring(0, tgen));
			plow = new W_Path(nuw);
			plow.set_word(plw);
			W.NN_pv = TW(plw, W.NN_pv, e);
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			if(end < 2)
			{
				Irrg(new W_Path(plow), f);
			}
			else{
				form(new W_Path(plow), e);
			}
		}
		plow.set_word(plw);
		end = plw.length();
		gen = end -1;
		sing = gen -1;
		permutate(plw, 2, 1000, er, end);
		
		f = e/10;
		if(nuuw.substring(1, 2).equals("נ"))
		{
			plw = nuuw.substring(0, 1) + finalf(nuuw.substring(2));
			plow = new W_Path(nuw);
			plow.set_word(plw);
			TW(plw, 1100, e);
			end = plw.length();
			 gen = end -1;
			 sing = gen -1;
			permutate(plw, 2, 100, f/30, end);
			if(end < 2)                            
			{
				Irrg(new W_Path(plow), f);
			}
			else{
				form(new W_Path(plow), e);
			}
		}
		if(nuuw.substring(tsing, tend).equals("ית"))
		{
			f =e/2;
			plw = finalf(nuuw.substring(0, tsing));
			plow = new W_Path(nuw);
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			
			 W.NN_fp2m = TW(plw, W.NN_fp2m, e);
			 TW(unfinalf(plw) + "ה", W.NN_fp2m, f);
			 permutate(plw, 2, W.NN_fp2m.getA(), er, plw.length());
			if(W.NN_fp2m.delB()>=3.0)
			{
				f = e*Math.pow(2, W.NN_fp2m.ratio());
			}
			else{
				f= e/30;
			}
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			if(end < 2)
			{
				Irrg(new W_Path(plow), er);
			}
			else{
				form(new W_Path(plow), e);
				if(plw.substring(1,2).equals("נ"))
				{
					plw = plw.substring(0,1) + finalf(plw.substring(2));
					TW(plw, 1000, e);
					plow.set_word(plw);
					permutate(plw, 2, 100, f/30, plw.length());
					TW(unfinalf(plw) + "ה", 500, e);
					TW(unfinalf(plw) + "ת", 500, e);
					end = plw.length();
					gen = end -1;
					sing = gen -1;
				}
				if(plw.length() < 2)
				{
					Irrg(new W_Path(plow), er);
				}
				else{
					form(new W_Path(plow), e);
				}
			}
		}   
		if(nuuw.substring(tsing, tend).equals("ות"))
		{
			plw = finalf(nuuw.substring(0, tsing));
			plow = new W_Path(nuw);
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			
			 W.NN_fp2 = TW(plw, W.NN_fp2, e);
			 permutate(plw, 2, W.NN_fp2.getA(), e/10, plw.length());
			 W.NN_fp2vh = TW(unfinalf(plw) + "וה",W.NN_fp2vh, e);
			 W.NN_fp2t = TW(unfinalf(plw) + "ת",W.NN_fp2t, e);
			plw = unfinalf(plw) + "ה";
			W.NN_fp2h = TW(plw, W.NN_fp2h, e);
			if(W.NN_fp2.delB()>=3.0)
			{
				f = e*Math.pow(2, W.NN_fp2.ratio());
			}
			else{
				f= e/30;
			}
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			if(end < 2)
			{
				Irrg(new W_Path(plow), f);
			}
			else{
				form(new W_Path(plow), e);
				if(plw.substring(1,2).equals("נ"))
				{
					plw = plw.substring(0, 1) + finalf(plw.substring(2));
					plow.set_word(plw);
					TW(plw, 2000, e);
					end = plw.length();
					gen = end -1;
					sing = gen -1;
					permutate(plw, 2, 100, f/30, end);
					TW(unfinalf(plw) + "ה", 1700, e);
					TW(unfinalf(plw) + "ת", 1700, e);
				
				}
				if(plw.length() < 2)
				{
					Irrg(new W_Path(plow), e/10);
				}
				else{
					form(new W_Path(plow), e);
				}
			}
		}   
		if(nuuw.substring(tgen, tend).equals("ת"))
		{	
			TW("י" + finalf(nuuw.substring(0, tgen)), 20000, e);
			plw = nuuw.substring(0, tgen) + "ה";
			plow = new W_Path(nuw);
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			 W.NN_th = TW(plw, W.NN_th, e);
			 if(W.NN_th.delB()>=3.0)
			{
				f = e*Math.pow(2, W.NN_th.ratio());
			}
			else{
				f= e/30;
			}
			TW(finalf(plw.substring(0, gen)), 25000, f);
			TW(plw.substring(0, gen) + "ות", 2500, f);
		
		}
		end = plw.length();
		gen = end -1;
		sing = gen -1;
		
		plow.set_word(finalf(plw));
		return plow;
	}
	public  W_Path subfix( W_Path sub_plw, double e)
	{
		String plw = sub_plw.get_word();
		W_Path plow = new W_Path(sub_plw);
		int end = plw.length();
		if(end < 3)
		{
			return Irrg(new W_Path(plow), e/30);
		}
		end = plw.length();
		int sing = end -2;
		int gen = end -1;
		double er = e/100;
		double f = e/20;
		
		if((plw.charAt(0)==('ו'))||(plw.charAt(0)==('ה'))||(plw.charAt(0)==('ל'))||(plw.charAt(0)==('ש'))|(plw.charAt(0)==('מ'))||(plw.charAt(0)==('ב'))||(plw.charAt(0)==('כ')))
		{
			f = e/50;
			if(plw.substring(0,1).equals("ה"))
			{  
				f = e/10;
				plow.set_word(plw.substring(1));
				plow.set_h(true);
				TW(plow.get_word(), 50000, e);
				end = plw.length();
		 		sing = end -2;
		 		gen = end -1;
		 		if(plow.get_word().length() < 3)
				{
					return plow;
				}
				if(plw.substring(0, 1).equals("ו"))
				{
					affix(new W_Path(plow), f);
					plow.set_word(plow.get_word().substring(1));
					plow.set_v(true);
					TW("י" + plow.get_word(), 1000, e);
				}
				return posses(new W_Path(plow), f);
			}
			if(plw.substring(0, 1).equals("כ"))
			{  
				if((plow.get_i() == true)||(plow.get_a() == true)||(plow.get_t() == true))
				{
					return plow;
				}
				f = e/10;
				plow.set_word(plw.substring(1));
				plow.set_c(true);
				TW(plow.get_word(), 5000, e);
			}
			if(plw.substring(0, 1).equals("ש"))
			{  
				if((plow.get_i() == true)||(plow.get_a() == true)||(plow.get_t() == true))
				{
					return plow;
				}
				f = e/10;
				plow.set_word(plw.substring(1));
				plow.set_s(true);
				TW(plow.get_word(), 7000, e);
			}
			if(plw.substring(0,1).equals("ל"))
			{  
				if((plow.get_m() == true)||(plow.get_n() == true)||(plow.get_d() == true)||(plow.get_h() == true)||(plow.get_b() == true)||(plow.get_l() == true)||(plow.get_i() == true)||(plow.get_a() == true)||(plow.get_t() == true))
				{
					return plow;
				}
				f = e/10;
				plow.set_word(plw.substring(1));
				plow.set_s(true);
				TW(plow.get_word(), 10000, e);
			}
			if(plw.substring(0, 1).equals("ו"))
			{
				f = e/10;
				plow.set_word(plw.substring(1));
				plow.set_v(true);
				TW(plow.get_word(), 15000, e);
				end = plw.length();
		 		sing = end -2;
		 		gen = end -1;
		 		permutate(plow.get_word(), 2, 1000, f, plw.length());
		 		if(plow.get_word().length() < 3)
				{
					return plow;
				}
				if(plw.substring(0, 1).equals("ו"))
				{
					affix(new W_Path(plow), f);
					plow.set_word(plw.substring(1));
					plow.set_v(true);
					TW("י" + plow.get_word(), 1000, e);
				 permutate(plow.get_word(), 2, 1000, f, plw.length());
				}
				posses(new W_Path(plow), f);
			}
		}
		return plow;
	}
	public W_Path posses(W_Path pos, double e)
	{
		e = e/5;
		if(e < WALL)
		{
			//return Irrg(new W_Path(pos), e);
		}
		String plw = pos.get_word();
		W_Path plow = new W_Path(pos);
		int mult = 0;
		
		int pend = pos.get_word().length();
		int pgen = pend -1;
		int psing = pgen -1;
		
		int end = plw.length();
		int gen = end -1;
		int sing = gen -1;
		double er = e/100;
		double f = e/50;
		if(end < 3)
		{
			return plow;
		}
		if(plw.substring(gen, end).equals("י"))
		{
			plw = finalf(plw.substring(0, gen));
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			
			 W.PI = TW(plw, W.PI, e);
			if(W.PI.delB()>=3.0)
			{
				f = e*Math.pow(2, W.PI.ratio());
			}
			else{
				f = e/10;	
			}
			double f2 = f;
			
			W.PM = TW((unfinalf(plw) + "ים"), W.PM, e);
			if(W.PM.delB()>=3.0)
			{
				f2 = e*Math.pow(2, W.PM.ratio());
			}
			else{
				f2 = e/10;	
			}
			TW(unfinalf(permutate(plw, 2, 10, e/10, plw.length()))+ "ים", W.PM.getA(), f2/5);
			if(plw.substring(gen, end).equals("ה"))
			{
				W.PHM = TW((unfinalf(plw) + "ים"),W.PHM, e);
				if(W.PHM.delB()>=3.0)
				{
					f2 = e*Math.pow(2, W.PHM.ratio());
				}
				else{
					f2 = e/10;	
				}
				TW(unfinalf(permutate(plw, 2, 10, e/10, plw.length()))+ "ים", W.PHM.getA(), f2/5);
			}
			 W.PTI = TW((unfinalf(plw)+ "ת"),W.PTI, e);
			if(W.PTI.delB()>=3.0)
			{
				f = e*Math.pow(2, W.PTI.ratio());
			}
			else{
				f = e/10;	
			}
			 W.PVTI = TW((unfinalf(plw) + "ות"),W.PVTI, e);
			if(W.PVTI.delB()>=3.0)
			{
				f = e*Math.pow(2, W.PVTI.ratio());
			}
			else{
				f = e*e/10;	
			}
			if(plw.substring(gen, end).equals("ה") == false)
			{
				plw = unfinalf(plw) + "ה";
				plow.set_word(plw);
				 W.PHI = TW((plw ),W.PHI, e);
				if(W.PHI.delB()>=3.0)
				{
					f = e*Math.pow(2, W.PHI.ratio());
				}
				else{
					f = e*e/10;	
				}
				permutate(plw, 2, 1000, f/30, plw.length());
				return affix(new W_Path(plow), f/20);
			}
		}
		plw = pos.get_word();
		plow = new W_Path(pos);
		end = plw.length();
		gen = end -1;
		sing = gen -1;
		
		pend =  pos.get_word().length();
		pgen = pend -1;
		psing = pgen -1;
		
		if(pend < 3)
		{
			return plow;
		}
		if(plw.substring(gen, end).equals("ת"))
		{
			double f2 = f;
			String Iplw = "י" + finalf(plw.substring(0, gen));
			W.IPTH = TW(Iplw, W.IPTH, e);
			if(W.IPTH.delB()>=3.0)
			{
				f2 = e*Math.pow(2, W.IPTH.ratio());
			}
			else{
				f2 = e/10;	
			}
			plw = plw.substring(0, gen) + "ה";
			plow.set_word(plw);
			W.PTH = TW(plw, W.PTH, e);
			if(W.PTH.delB()>=3.0)
			{
				f2 = e*Math.pow(2, W.PTH.ratio());
			}
			else{
				f2 = e/10;	
			}
			permutate(plw, 2, 1000, f/30, plw.length());
		}
		plw = pos.get_word();
		plow = new W_Path(pos);
		end = plw.length();
		gen = end -1;
		sing = gen -1;
		
		pend = pos.get_word().length();
		pgen = pend -1;
		psing = pgen -1;
		
		if(pend < 3)
		{
			f = e/10;
			return affix(new W_Path(plow), f/100);
		}
		
		if((pos.get_word().substring(psing, pend).equals("נה"))||(pos.get_word().substring(psing ,pend).equals("כם"))||(pos.get_word().substring(psing, pend).equals("נו"))||(pos.get_word().substring(psing, pend).equals("יו"))||(pos.get_word().substring(psing, pend).equals("יה"))||(pos.get_word().substring(psing, pend).equals("ין"))||(pos.get_word().substring(psing, pend).equals("הם"))||(pos.get_word().substring(psing, pend).equals("הן"))||(pos.get_word().substring(psing, pend).equals("כן"))||(pos.get_word().substring(psing, pend).equals("כה")))
		{
			plw = finalf(pos.get_word().substring(0, psing));
			plow = new W_Path(pos);
			plow.set_word(plw);
			f = e/30;
			 end = plw.length();
			gen = end -1;
			sing = gen -1;
			 permutate(plw, 1, 1000, f/30, plw.length());
			 prefix(new W_Path(plow), f);
			if(plw.substring(gen, end).equals("י"))
			{
				plw = finalf(plw.substring(0, gen));
				plow.set_word(plw);
				end = plw.length();
				gen = end -1;
				sing = gen -1;
				naun(new W_Path(plow), f);
				
				W.PXI = FPIX2(pos.get_word(), plw, e, f/50);
				if(W.PXI.delB()>=3.0)
				{
					f = e*Math.pow(2, W.PXI.ratio());
				}
				else{
					f = e/90;
				}
				permutate(plw, 2, W.PXI.getA(), f/30, plw.length());
				double f2 = f;
				
				if(plw.substring(gen, end).equals("ה"))
				{
					W.P_HbIM = TW((unfinalf(plw) + "ים"), W.P_HbIM, e);
					if(W.P_HbIM.delB()>=3.0)    
					{
						f2 = e*Math.pow(2, W.P_HbIM.ratio());
					}
					else{
						f2 = e/10;
					} 
				}
				else{
					W.P_IbM = TW((unfinalf(plw) + "ים"), W.P_IbM, e);
					if(W.P_IbM .delB()>=3.0)    
					{
						f2 = e*Math.pow(2, W.P_IbM .ratio());
					}
					else{
						f2 = e/10;
					} 
					TW(unfinalf(permutate(plw, 2, 10, er, plw.length()))+ "ים", W.P_IbM.getA(), f2/5);
				}
				plow.set_word(plw);
				end = plw.length();
				gen = end -1;
				sing = gen -1;
				if(end < 3)
				{
					return naun(new W_Path(plow), er/100);
				}
				if(plw.substring(gen, end).equals("ת"))
				{
					TW(finalf(plw.substring(0, gen)), 10000, e); 
					TW("י" + finalf(plw.substring(0, gen)), 10000, e); 
					TW((plw.substring(0, gen) + "ה"), 20000, e);
					TW((plw.substring(0, gen) + "ות"), 10000, e);
					TW((plw + "ה"), 5000, e);
					plw = plw.substring(0, gen) + "ה";
					plow.set_word(plw);
					end = plw.length();
					gen = end -1;
					sing = gen -1;
				}
				affix(new W_Path(plow), f/20);
			}
			if(pos.get_word().substring(psing, pend).equals("נה"))
			{
				W.P_NH = TW(plw, W.P_NH, e);
				if(W.P_NH.delB()>=3.0)
				{
					f = e*Math.pow(2, W.P_NH.ratio());
				}
				else{
					f = e/90;
				}
			}
			 if(pos.get_word().substring(psing, pend).equals("כם"))
			{
				W.P_CM = TW(plw,W.P_CM, e);
				if(W.P_CM.delB()>=3.0)
				{
					f = e*Math.pow(2, W.P_CM.ratio());
				}
				else{
					f = e/90;
				}
			}
			 if(pos.get_word().substring(psing, pend).equals("נו"))
			{
				W.P_NV = TW(plw, W.P_NV, e);
				if(W.P_NV.delB()>=3.0)    
				{
					f = e*Math.pow(2, W.P_NV.ratio());
				}
				else{
					f = e/90;
				}
			}
			 if(pos.get_word().substring(psing, pend).equals("יו"))
			{
				W.P_IV = TW(plw, W.P_IV, e);
				if(W.P_IV.delB()>=3.0)    
				{
					f = e*Math.pow(2, W.P_IV.ratio());
				}
				else{
					f = e/90;
				}
			}
			if(pos.get_word().substring(psing, pend).equals("יה"))
			{
				W.P_IH2 = TW(plw, W.P_IH2, e);
				if(W.P_IH2.delB()>=3.0)    
				{
					f = e*Math.pow(2, W.P_IH2.ratio());
				}
				else{
					f = e/90;
				}
			}
			 if(pos.get_word().substring(psing, pend).equals("ין"))
			{
				W.P_IN = TW(plw, W.P_IN, e);
				if(W.P_IN.delB()>=3.0)    
				{
					f = e*Math.pow(2, W.P_IN.ratio());
				}
				else{
					f = e/90;
				}
			}
			 if(pos.get_word().substring(psing, pend).equals("כן"))
			{
				W.P_CN = TW(plw, W.P_CN, e);
				if(W.P_CN.delB()>=3.0)    
				{
					f = e*Math.pow(2, W.P_CN.ratio());
				}
				else{
					f = e/90;
				}
			}
			 if(pos.get_word().substring(psing, pend).equals("כה"))
			{
				W.P_CH = TW(plw, W.P_CH, e);
				if(W.P_CH.delB()>=3.0)    
				{
					f = e*Math.pow(2, W.P_CH.ratio());
				}
				else{
					f = e/90;
				}
			}
			 if(pos.get_word().substring(psing, pend).equals("הם"))
			{
				W.P_HM = TW(plw, W.P_HM, e);
				if(W.P_HM.delB()>=3.0)    
				{
					f = e*Math.pow(2, W.P_HM.ratio());
				}
				else{
					f = e/90;
				}
			}
			 if(pos.get_word().substring(psing, pend).equals("הן"))
			{
				W.P_HN = TW(plw,W.P_HN, e);
				if(W.P_HN.delB()>=3.0)    
				{
					f = e*Math.pow(2, W.P_HN.ratio());
				}
				else{
					f = e/90;
				}
			}
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			if(end < 3)
			{
				return plow = affix(new W_Path(plow), f/100);
			}
			if(plw.substring(gen, end).equals("ת"))
			{
				TW("י" + finalf(plw.substring(0, gen)), 10000, e); 
				TW((plw.substring(0, gen) + "ה"), 20000, e);
				TW((plw.substring(0, gen) + "ות"),10000, e);
				plw =  finalf(plw.substring(0, gen));
				plow.set_word(plw);
				TW(plw, 5000, e);
			}
			
			plw = finalf(plw);
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
			sing = gen -1;
			form(new W_Path(plow), f);
		}
		pend = pos.get_word().length();
		pgen = pend -1;
		psing = pgen -1;
		plw = pos.get_word();
		plow = new W_Path(pos);
		end = plw.length();
		gen = end -1;
		sing = gen -1;
		permutate(plw, 2, 1000, f/30, plw.length());
		if(end < 3)
		{
			 Noun(new W_Path(plow), er/100);
			Irrg(new W_Path(plow), er/50);
			return plow;
		}
		 if((pos.get_word().substring(pgen, pend).equals("ך"))||(pos.get_word().substring(pgen, pend).equals("ן"))||(pos.get_word().substring(pgen, pend).equals("ה"))||(pos.get_word().substring(pgen, pend).equals("ם"))||(pos.get_word().substring(pgen, pend).equals("ו"))||(pos.get_word().substring(pgen, pend).equals("י")))
		 {
		 	 f = e/40;
			 plw = finalf(pos.get_word().substring(0, pgen));
			 plow.set_word(plw);
			 permutate(plw, 1, 1000, f/10, plw.length());
			 prefix(new W_Path(plow), f);
			 end = plw.length();
			gen = end -1;
			sing = gen -1;
			
			if(plw.substring(gen, end).equals("י"))
			{
				double f2 = f;
				String tp = finalf(plw.substring(0, gen));
				W_Path tpp = new W_Path(plow);
				tpp.set_word(tp);
				naun( new W_Path(tpp), f2);
				
				if(plw.substring(sing, gen).equals("ה"))
				{
					W.P_HIM = TW((plw + "ם"), W.P_HIM, e);  
					
					TW(unfinalf(permutate(plw, 2, 10, er, plw.length()))+ "ם", W.P_HIM.getA(), f2/5);
				}
				else{
					W.P_IM = TW((unfinalf(plw) + "ם"), W.P_IM, e);
				}
				TW(unfinalf(permutate(plw, 2, 10, er, plw.length()))+ "ם", W.P_IM.getA(), f2/5);
				
				plw = finalf(plw.substring(0, gen));
				plow.set_word(plw);
				W.PXI2 = FPIXI(pos.get_word(), tp, e, f/50);
				if(W.PXI2.delB()>=3.0)
				{
					f = e*Math.pow(2, W.PXI2.ratio());
				}
				else{
					f = e/90;
				}
				plow.set_word(plw);
				end = plw.length();
				sing = end -2;
				gen = end -1;
				 
				if(end < 3)
				{
					 naun(new W_Path(plow), er);
					 return Irrg(new W_Path(plow), f/50);
				}
		     		plw = finalf(plw);
		     		plow.set_word(plw);
				return form(new W_Path(plow), f);
			}
			if(pos.get_word().substring(pgen, pend).equals("ה"))
			{
				W.P_H = TW(plw, W.P_H, e);    
				if(W.P_H.delB()>=3.0)
				{
					f = e*Math.pow(2, W.P_H.ratio());
				}
				else{
					f = e/30;
				}
				permutate(plw, 2, W.P_H.getA(), f/30, plw.length());
		
				end = plw.length();
				sing = end -2;
				gen = end -1;
			}
			if(pos.get_word().substring(pgen, pend).equals("י"))
			{
				W.P_I = TW(plw,W.P_I, e);	  
				if(W.P_I.delB()>=3.0)
				{
					f = e*Math.pow(2, W.P_I.ratio());
				}
				else{
					f = e/20;
				}
			}
			if(pos.get_word().substring(pgen, pend).equals("ו"))
			{
				W.P_V = TW(plw,W.P_V, e);   
				if(W.P_V.delB()>=3.0)
				{
					f = e*Math.pow(2, W.P_V.ratio());
				}
				else{
					f = e/20;
				}
			}
			if(pos.get_word().substring(pgen, pend).equals("ם"))
			{
				W.P_M = TW(plw,W.P_M, e);	  
				if(W.P_M.delB()>=3.0)
				{
					f = e*Math.pow(2, W.P_M.ratio());
				}
				else{
					f = e/60;
				}
			}
			if(pos.get_word().substring(pgen, pend).equals("ן"))
			{
				W.P_N = TW(plw,W.P_N, e);   
				if(W.P_N.delB()>=3.0)
				{
					f = e*Math.pow(2, W.P_N.ratio());
				}
				else{
					f = e/50;
				}
			}
			if(pos.get_word().substring(pgen, pend).equals("ך"))
			{
				W.P_K = TW(plw, W.P_K, e);	  
				if(W.P_K.delB()>=3.0)
				{
					f = e*Math.pow(2, W.P_K.ratio());
				}
				else{
					f = e/30;
				}
			}
			if(end < 3)
			{
				naun(new W_Path(plow), er);
				return Irrg(new W_Path(plow), f/50);
			}
			return form(new W_Path(plow), f);
		 }
		 plw = finalf(plw);
		 plow.set_word(plw);
		 permutate(plw, 2, 1000, f/30, plw.length());
		 return plow;
	}
	public Num FPIX2(String pos, String plw, double e, double f)
	{
		
		int pend = pos.length();
		int pgen = pend -1;
		int psing = pgen -1;
		int end = plw.length();
		int gen = end -1;
		int sing = gen -1;
		double ne = e;
		double f2 = f;
		
		W.PIH = TW(unfinalf(plw) + "ה", W.PIH, e);    
		if(W.PIH.delB()>=3.0)    
		{
			f2 = e*Math.pow(2, W.PIH.ratio());
		}
		else{
			f2 = e/100;	
		}
		permutate(unfinalf(plw) + "ה",  2, W.PIH.getA(), f2/5, plw.length());
		
		W.P_Ib2T = TW(unfinalf(plw) + "ת",W.P_Ib2T, e);
		if(W.P_Ib2T.delB()>=3.0)    
		{
			f2 = e*Math.pow(2, W.P_Ib2T.ratio());
		}
		else{
			f2 = e/100;	
		}
		permutate(unfinalf(plw) + "ת", 2, W.P_Ib2T.getA(), f2/5, plw.length());
		
		W.P_Ib2VT = TW((unfinalf(plw) + "ות"), W.P_Ib2VT, e);
		if(plw.substring(gen, end).equals("ה") == false)
		{
			plw = unfinalf(plw) + "ה";
			W.P_Ib2nHH = TW(plw, W.P_Ib2nHH, e);
			if(W.P_Ib2nHH.delB()>=3.0)    
			{
				f = e*Math.pow(2, W.P_Ib2nHH.ratio());
			}
		}
		TW(unfinalf(permutate(plw, 2, 10, ne/10, plw.length()))+ "ים", W.PM.getA(), f/30);
		
		if(pos.substring(psing, pend).equals("נה"))
		{
			W.P_NH = TW(plw, W.P_NH, e);
			return W.P_NH;
		}
		 if(pos.substring(psing, pend).equals("כם"))
		{
			W.P_CM = TW(plw,W.P_CM, e);
			return W.P_CM;
		}
		 if(pos.substring(psing, pend).equals("נו"))
		{
			W.P_NV = TW(plw, W.P_NV, e);
			return W.P_NV;
		}
		 if(pos.substring(psing, pend).equals("יו"))
		{
			W.P_IV = TW(plw, W.P_IV, e);
			return W.P_IV;
		}
		 if(pos.substring(psing, pend).equals("ין"))
		{
			W.P_IN = TW(plw, W.P_IN, e);
			return W.P_IN;
		}
		 if(pos.substring(psing, pend).equals("כן"))
		{
			W.P_CN = TW(plw, W.P_CN, e);
			return W.P_CN;
		}
		 if(pos.substring(psing, pend).equals("כה"))
		{
			W.P_CH = TW(plw, W.P_CH, e);
			return W.P_CH;
		}
		 if(pos.substring(psing, pend).equals("הם"))
		{
			W.P_HM = TW(plw, W.P_HM, e);
			return W.P_HM;
		}
		 if(pos.substring(psing, pend).equals("הן"))
		{
			W.P_HN = TW(plw,W.P_HN, e);
			return W.P_NH;
		}
		
		W.P0I = TW(plw, W.P0I, e);
		return TW(plw, W.P0I, e);
	}
	public Num FPIXI(String pos, String plw, double e, double f)
	{
		
		int pend = pos.length();
		int pgen = pend -1;
		int psing = pgen -1;
		int end = plw.length();
		int gen = end -1;
		int sing = gen -1;
		double er = e/100;
		double f2 = f;
		
		W.P_IH = TW((unfinalf(plw) + "ה"), W.P_IH, e);
		if(W.P_IH.delB()>=3.0)
		{
			f2 = e*Math.pow(2, W.P_IH.ratio());
		}
		else{
			f2= e/10;
		}
		permutate((unfinalf(plw) +  "ה"), 2, W.P_IH.getA(), f2/5, plw.length() + 1);
		W.P_I2T = TW(unfinalf(plw) + "ת", W.P_I2T, e);
		if(W.P_I2T.delB()>=3.0)
		{
			f2 = e*Math.pow(2, W.P_I2T.ratio());
		}
		else{
			f2 = e/9;
		}
		TW(unfinalf(permutate(plw, 2, 10, er, plw.length()))+ "ת", W.P_I2T.getA(), f2/5);
		W.P_I2VT = TW((unfinalf(plw) + "ות"), W.P_I2VT, e);
		if(W.P_I2VT.delB()>=3.0)
		{
			f2 = e*Math.pow(2, W.P_I2VT.ratio());
		}
		else{
			f2 = e/9;
		}
		TW(unfinalf(permutate(plw, 2, 10, er, plw.length()))+ "ות", W.P_I2VT.getA(), f2/5);

		if(pos.substring(pgen, pend).equals("ת"))
		{
			plw = pos.substring(0, pgen) + "ה";
			W.P_H = TW(plw,W.P_H, e);    
			return W.P_H;
		}
		if(pos.substring(pgen, pend).equals("י"))
		{
			W.P_I = TW(plw, W.P_I, e);	  
			return W.P_I;
		}
		if(pos.substring(pgen, pend).equals("ו"))
		{
			W.P_V = TW(plw, W.P_V, e);   
			return W.P_V;
		}
		if(pos.substring(pgen, pend).equals("ם"))
		{
			W.P_M = TW(plw, W.P_M, e);	  
			return W.P_M;
		}
		if(pos.substring(pgen, pend).equals("ן"))
		{
			W.P_N = TW(plw, W.P_N, e);   
			return W.P_N;
		}
		if(pos.substring(pgen, pend).equals("ך"))
		{
			W.P_K = TW(plw, W.P_K, e);	  
			return W.P_K;
		}
		
		W.P0I2 = TW(plw, W.P0I2, e);
		return TW(plw, W.P0I2, e);
	}
	public W_Path Inft(W_Path inf, double e)
	{
		if(e < WALL)
		{
			//return Irrg(new W_Path(inf), e);
		}
		int in_end = inf.get_word().length();
		int in_gen = in_end -1;
		int in_sing = in_gen - 1;
		String plw = inf.get_word();
		W_Path plow = new W_Path(inf);
		double er = e/100;
		double f = e/50;
		int end = plw.length();
		int gen = end -1;
		int sing = gen - 1;
		if(end < 3)
		{
			plow = Irrg(new W_Path(plow), f/30);
			plw = plow.get_word();
			return plow;
		}
		if((inf.get_word().substring(0, 1).equals("ה"))||(inf.get_word().substring(0, 1).equals("ו"))||(inf.get_word().substring(0, 1).equals("מ"))||(inf.get_word().substring(0, 1).equals("ב"))||(inf.get_word().substring(0, 1).equals("ל"))||(inf.get_word().substring(0, 1).equals("ש"))||(inf.get_word().substring(0, 1).equals("כ")))
		{
 			if(inf.get_word().substring(0, 1).equals("ה"))
			{
				if((inf.get_i() == true)||(inf.get_a() == true))
				{
					nifal(new W_Path(inf), new W_Path(inf), er);
					return inf;
				}
				plow.set_h(true);
			}
			if(inf.get_word().substring(0, 1).equals("מ"))
			{
				if((inf.get_i() == true)||(inf.get_a() == true)||(inf.get_l() == true))
				{
					affix(new W_Path(inf), e);
					return inf;
				}
				plow.set_m(true);
			}
			if(inf.get_word().substring(0, 1).equals("ב"))
			{
				if((inf.get_i() == true)||(inf.get_l() == true)||(inf.get_a() == true)||(inf.get_d() == true)||(inf.get_h() == true)||(inf.get_t() == true))
				{
					affix(new W_Path(inf), e);
					return inf;
				}
				plow.set_b(true);
			}
			if(inf.get_word().substring(0, 1).equals("ל"))
			{
				if((inf.get_i() == true)||(inf.get_l() == true)||(inf.get_a() == true)||(inf.get_t() == true)||(inf.get_b() == true)||(inf.get_h() == true)||(inf.get_m() == true)||(inf.get_n() == true)||(inf.get_d() == true))
				{
					affix(new W_Path(inf), e);
					return inf;
				}
				plow.set_l(true);
			}
			if(inf.get_word().substring(0, 1).equals("ש"))
			{
				if((inf.get_i() == true)||(inf.get_a() == true)||(inf.get_t() == true))
				{
					affix(new W_Path(inf), e);
					return inf;
				}
				plow.set_s(true);
			}
			if(inf.get_word().substring(0, 1).equals("כ"))
			{
				if((inf.get_i() == true)||(inf.get_a() == true)||(inf.get_t() == true))
				{
					affix(new W_Path(inf), e);
					return inf;
				}
				plow.set_c(true);
			}
			plw = inf.get_word().substring(1);
			plow.set_word(plw);
			 end = plw.length();
			gen = end -1;
			sing = gen - 1;
			if(inf.get_word().substring(0, 1).equals("ו"))
			{
				plow.set_v(true);
				if(inf.get_word().substring(0, 3).equals("ויו"))
				{
					TW("י" + plw.substring(2), 1400, e);
					TW("י" + unfinalf(plw.substring(2, end)) + "ה", 1400, e);
				}
				if(inf.get_word().substring(0, 2).equals("וי"))
				{
					TW(unfinalf(plw.substring(1)) + "ה", 1400, e);
				}
				plow.set_word(plw);
				if(plw.length() > 2)
				{
					if(plw.substring(0, 1).equals("ה"))
					{
						return affix(new W_Path(plow), e);
					}
					form(new W_Path(plow), e);
				}
				else{
					return plow;
				}
			}
			plow.set_word(plw);
			Hitpael(new W_Path(plow), f);
			int lem = 0;
			if(inf.get_word().substring(0, 1).equals("ל"))
			{
				f= e;
				plw = inf.get_word().substring(1);
				plow = new W_Path(inf);
				plow.set_word(plw);
				plow.set_l(true);
				W.Lamed2 = TW(plw, W.Lamed2, e);
				if(W.Lamed2.delB()>=3.0)
				{
					f = e*Math.pow(2, W.Lamed2.ratio());
				}
				else{
					f = e/30;
				}
				permutate(plw, 1, W.Lamed2.getA(), f/30, plw.length());
				permutate(plw + "ה", 1, W.Lamed2.getA(), f/40, plw.length() + 1);
				end = plw.length();
				gen = end -1;
				sing = gen - 1;
				lem = 1;
				if(plw.substring(0, 1).equals("ה"))
				{
					W_Path plw1 = new W_Path(plw);
					plw1.set_word(plw.substring(1));
					plw1.set_h(true);
					nifal(new W_Path(plow), new W_Path(inf), er);
					Noun(plw1, f/50);
				}
				permutate(plw, 2, W.Lamed2.getA(), f/30, plw.length());
				plow.set_word(plw);
				Prep(new W_Path(plow), f/50);
				if(plw.length() < 3)
				{
					return plow;
				}
				if(plw.substring(sing, end).equals("ות"))
				{
					plw = finalf(plw.substring(0, sing));
					plow.set_word(plw);
					TW(plw, 2550, e);
					 end = plw.length();
 					gen = end -1;
 					sing = gen - 1;
					if(plw.length() < 3)
					{
						return plow;
					}
					plw = unfinalf(plw) + "ה";
					plow.set_word(plw);
					TW(plw, 5550, e);
					TW("י" + plw, 150, e);
					end = plw.length();
					gen = end -1;
					sing = gen - 1;
					if(plw.length() < 3)
					{
						return plow;
					}
				}
				else
				{
					if(plw.substring(gen, end).equals("ת"))
					{
						plw = finalf(plw.substring(0, gen));
						plow.set_word(plw);
						TW(plw, 2550, e);
						 end = plw.length();
 						gen = end -1;
 						sing = gen - 1;
						if(plw.length() < 3)
						{
							return plow;
						}
						plw = "י" + plw;
						TW(plw, 50000, e);
						TW(unfinalf(plw)+  "ות", 3550, e);
						plw = unfinalf(plw)+  "ה";
						plow.set_word(plw);
						TW(plw, 5550, e);
						end = plw.length();
						gen = end -1;
						sing = gen - 1;
						if(plw.length() < 3)
						{
							return plow;
						}
					}
				}
				permutate(plw, 2, 1000, f/30, plw.length());
				plow.set_word(plw);
				end = plw.length();
				gen = end -1;
				sing = gen - 1;
				if(plw.length() > 2)
				{
					f = e/20;
					Polel(new W_Path(plow), f/100);
					Inft(new W_Path(plow), f/50);
				}
				else{
					return plow;
				}
			}
			if((in_end > 3)&&(inf.get_word().substring(0, 1).equals("ה")))
			{
				permutate(plw + "ה", 2, 800, f/30, plw.length() + 1);
				plw = inf.get_word().substring(1);
				plow = new W_Path(inf);
				plow.set_word(plw);
				plow.set_h(true);
				TW(plw, 1500, f);
				permutate(plw + "ה", 2, 1000, f/30, plw.length() + 1);
				Noun(new W_Path(plow), f);
				if(plw.substring(0, 1).equals("ו"))
				{
					Noun(new W_Path(inf), er);
					plw = plw.substring(1);
					plow.set_word(plw);
					plow.set_v(true);
					TW(plw, 1000, f);
					if((plw.substring(0,1).equals("י") == false)&&(inf.get_word().substring(0,1).equals("י") == false))
					{
						plw = "י" + plw;
						TW(plw, 10000, e);
					}
				}
				plow.set_word(plw);
				
				if(plw.length() > 2)
				{
					f = e/20;
					Polel(new W_Path(plow), f);
					Hifil(new W_Path(plow), inf, f/50);
				}
				else{
					return plow;
				}
			}
			end = plw.length();
			gen = end -1;
			sing = gen - 1;
			if((in_end > 3)&&(inf.get_word().substring(1, 3).equals("תה")))
			{
				plw = inf.get_word().substring(4, in_end);
				plow = new W_Path(inf);
				plow.set_word(plw);
				plow.set_h(true);
				plow.set_t(true);
				if(inf.get_word().substring(0, 1).equals("ה"))
				{
					plow.set_h(true);
				}
				if(inf.get_word().substring(0, 1).equals("מ"))
				{
					if((inf.get_i() == true)||(inf.get_l() == true)||(inf.get_a() == true))
					{
						return inf;
					}
					plow.set_m(true);
				}
				if(inf.get_word().substring(0, 1).equals("ב"))
				{
					if((inf.get_i() == true)||(inf.get_l() == true)||(inf.get_a() == true)||(inf.get_d() == true)||(inf.get_h() == true)||(inf.get_t() == true))
					{
						return inf;
					}
					plow.set_b(true);
				}
				if(inf.get_word().substring(0, 1).equals("ל"))
				{
					if((inf.get_i() == true)||(inf.get_l() == true)||(inf.get_t() == true)||(inf.get_a() == true)||(inf.get_b() == true)||(inf.get_h() == true)||(inf.get_d() == true)||(inf.get_m() == true)||(inf.get_n() == true))
					{
						return inf;
					}
					plow.set_l(true);
				}
				if(inf.get_word().substring(0, 1).equals("ש"))
				{
					if((inf.get_i() == true)||(inf.get_t() == true)||(inf.get_a() == true))
					{
						return inf;
					}
					plow.set_s(true);
				}
				if(inf.get_word().substring(0, 1).equals("כ"))
				{
					if((inf.get_i() == true)||(inf.get_t() == true)||(inf.get_a() == true))
					{
						return inf;
					}
					plow.set_s(true);
					plow.set_c(true);
				}
				if(inf.get_word().substring(0, 1).equals("ו"))
				{
					plow.set_v(true);
				}
		
				TW(inf.get_word().substring(3, in_end), 150, e);
				TW(plw, 150, e);
				
				if(plw.length() > 2)
				{
					f = e/20;
					Polel(new W_Path(plow), f/20);
					if(inf.get_word().substring(0, 1).equals("ה"))
					{
						affix(new W_Path(plow), f/50);
					}
					else{
						prefix(new W_Path(plow), f/50);
					}
				}
				else{
					return plow;
				}
			}
			if((in_end >= 3)&&((inf.get_word().substring(in_gen, in_end).equals("ן"))||(inf.get_word().substring(in_gen, in_end).equals("ך"))||(inf.get_word().substring(in_gen, in_end).equals("ם"))||(inf.get_word().substring(in_gen, in_end).equals("ו"))||(inf.get_word().substring(in_gen, in_end).equals("ה"))))
			{
				plw = finalf(inf.get_word().substring(0, in_gen));
				plow = new W_Path(inf);
				plow.set_word(plw);
				permutate(plw, 2, 1000, f/300, plw.length());
				if(plw.length() > 2)
				{
					Inft(new W_Path(plow), f/50);
				}
				else{
					return Irrg(new W_Path(plow), f/50);
				}
			}
			plow.set_word(plw);
			end = plw.length();
			gen = end -1;
			sing = gen - 1;
			if(end < 4)
			{
				f = e/10;
				return Irrg(new W_Path(plow), f);
			} 
		}
		plow.set_word(finalf(plw));
	       return plow;
	}
	public W_Path Irrg(W_Path I, double e)
	{
		e = e/65;
		if(e < WALL)
		{
			//return irgw;
		}
		String irgw = I.get_word();
		int end = irgw.length();
		int gen = end -1;
		int sing = gen -1;
		String t_irr = irgw;
		W_Path t_iror = new W_Path(I);
		int tend = t_irr.length();
		int tgen = tend -1;
		int tsing = tgen -1;
		double f = e/50;
		double er = e/100;
		TW(unfinalf(t_irr), 10, e);
		permutate(irgw, 1, 100, f/10, irgw.length());
		TW(unfinalf(t_irr) +  "ה", 1, e);
		
		if(end > 3)
		{
			permutate(t_irr, 2, 60, f/10, t_irr.length());
		}
		if(end > 2)
		{
			if(t_irr.substring(0,2).equals("וי"))
			{
				TW(unfinalf(t_irr.substring(2, end)) + "ה", 10, e);	
			}
		}
		if(irgw.length() >1)
		{
			TW((t_irr + "ה"), 25, e);
			Noun(new W_Path(t_iror), er);
			if((irgw.substring(0, 1).equals(irgw.substring(1, 2)))||(irgw.substring(0, 1).equals("א"))||(irgw.substring(0, 1).equals("י"))||(irgw.substring(0, 1).equals("ת")))
			{
				if(irgw.substring(1,2).equals("ו"))
				{
					t_irr = "י" + irgw.substring(2);
					t_iror.set_word(t_irr);
					t_iror.set_v(true);
					if(irgw.substring(0, 1).equals("א"))
					{
						t_iror.set_a(true);
					}
					if(irgw.substring(0, 1).equals("י"))
					{
						t_iror.set_i(true);
					}
					if(irgw.substring(0, 1).equals("ת"))
					{
						t_iror.set_t(true);
					}
				   	TW(unfinalf(t_irr) , 10, e);
				   	TW(unfinalf(t_irr) + "ה",8, e);
				 }
			         if(irgw.substring(0, 1).equals("א") == false)
				{
				 	t_irr = irgw.substring(1);
				 	t_iror = new W_Path(I);
				 	t_iror.set_word(t_irr);
				 	if(irgw.substring(0, 1).equals("י"))
					{
						t_iror.set_i(true);
					}
					if(irgw.substring(0, 1).equals("ת"))
					{
						t_iror.set_t(true);
					}
				}
				TW(unfinalf(t_irr) + "ה", 10, e);
				if(irgw.substring(gen, end).equals("ת")==false)
				{	   
					TW(unfinalf(irgw) + "ת",5,e);
				}
				TW(unfinalf(irgw) + "ן", 5,e);
				TW(unfinalf(irgw) + "א", 5,e);
				
				TW("ה" + irgw.substring(1, end),5, e);
				TW("הו" + irgw.substring(1, end),5, e);
				   
				t_irr = "נ" + irgw.substring(1, end);
				t_iror = new W_Path(I);
				t_iror.set_word(t_irr);
				if(irgw.substring(0, 1).equals("א"))
				{
					t_iror.set_a(true);
				}
				if(irgw.substring(0, 1).equals("י"))
				{
					t_iror.set_i(true);
				}
				if(irgw.substring(0, 1).equals("ת"))
				{
					t_iror.set_t(true);
				}
				if(irgw.substring(gen, end).equals("ת")==false)
				{
					TW(unfinalf(t_irr) + "ת",5, e);
				}
				TW(unfinalf(t_irr) + "ן",5, e);
				TW(unfinalf(t_irr) + "א",5, e);
				TW(t_irr, 1, e);
				if((irgw.substring(0, 1).equals("א"))||(irgw.substring(0, 1).equals("י"))||(irgw.substring(0, 1).equals("ת")))
				{
					t_irr = irgw;
					t_iror = new W_Path(I);
				}
			}	   
			if((irgw.substring(0, 1).equals("נ"))||(irgw.substring(0, 1).equals("ת")))
			{
				t_irr  = "ה" + irgw.substring(1, end);
				t_iror = new W_Path(I);
				t_iror.set_word(t_irr);
				if(irgw.substring(0, 1).equals("נ"))
				{
					t_iror.set_n(true);
				}
				if(irgw.substring(0, 1).equals("ת"))
				{
					t_iror.set_t(true);
				}
				TW(t_irr, 10, e);
				TW(unfinalf(t_irr) + "ה", 5, e);
				
				if(irgw.substring(gen, end).equals("ת")==false)
				{
					TW(unfinalf(t_irr) + "ת",5,e);
				}
				TW(unfinalf(t_irr) + "ן", 5,e);
				TW(unfinalf(t_irr) + "א",5, e);
				TW(finalf(t_irr), 5, e);
				t_irr = irgw;
				t_iror = new W_Path(I);
			}
		
			if((irgw.length() == 2)&&(irgw.substring(0, 1).equals("א")== false))
			{
				TW( finalf(unfinalf(irgw) + irgw.substring(1,2)), 5, e);
			}
		}
		if(irgw.length() == 1)
		{
			
		}
		return t_iror;
	}
	public W_Path Noun(W_Path nnw,  double e)
	{ 
		e = e/22;
		if(e < WALL)
		{
			return nnw;
		}
		double f = e/50;
		double er = e/100;
		int end = nnw.get_word().length();
		if(end < 2)
		{
			nnw.set_word("נ" + nnw.get_word());
			W.N_n2 = TW((nnw.get_word()), W.N_n2, e);
			if(W.N_n2.delB()>=3.0)
			{
				f = e*Math.pow(2, W.N_n2.ratio());
			}
			else{
				f = e/100;
			}	
			permutate(nnw.get_word(), 2, W.N_n2.getA(), f/300, nnw.get_word().length());
			
			String hey = unfinalf(nnw.get_word()) + "ה";
			W.N_h = TW((hey), W.N_h, e);
			if(W.N_h.delB()>=3.0)
			{
				f = e*Math.pow(2, W.N_h.ratio());
			}
			else{
				f = e/100;
			}	
			permutate(hey, 2, W.N_h.getA(), f/300, hey.length());
			
			nnw.set_word(unfinalf(nnw.get_word()) + "ן");
			W.N_n2N = TW((nnw.get_word()), W.N_n2N, e);  
			
			if(W.N_n2N.delB()>=3.0)
			{
				f = e*Math.pow(2, W.N_n2N.ratio());
			}
			else{
				f = e/100;
			}	
			permutate(nnw.get_word(), 2, W.N_n2N.getA(), f/300, nnw.get_word().length());
			
			return nnw;
		}
		end = nnw.get_word().length();
		int sing = end -2;
		int gen = end -1;
		if((nnw.get_word().substring(0, 1).equals("ה"))||(nnw.get_word().substring(0, 1).equals("כ"))||(nnw.get_word().substring(0, 1).equals("ש"))||(nnw.get_word().substring(0, 1).equals("ו"))||(nnw.get_word().substring(0, 1).equals("י"))||(nnw.get_word().substring(0, 1).equals("ת")))
		{
			W_Path nnww = new W_Path(nnw);
			nnww.set_word(nnw.get_word().substring(1));
			if(nnw.get_word().substring(0, 1).equals("ה"))
			{
				nnww.set_h(true);
			}
			if(nnw.get_word().substring(0, 1).equals("ש"))
			{
				if((nnw.get_i() == true)||(nnw.get_a() == true)||(nnw.get_t() == true))
				{
					return nnw;
				}
				nnww.set_s(true);
			}
			if(nnw.get_word().substring(0, 1).equals("כ"))
			{
				if((nnw.get_i() == true)||(nnw.get_a() == true)||(nnw.get_t() == true))
				{
					return nnw;
				}
				nnww.set_c(true);
			}
			if(nnw.get_word().substring(0, 1).equals("ו"))
			{
				nnww.set_v(true);
			}
			if(nnw.get_word().substring(0, 1).equals("ת"))
			{
				nnww.set_t(true);
			}
			if(nnw.get_word().substring(0, 1).equals("י"))
			{
				nnww.set_i(true);
			}
			TW(nnw.get_word().substring(1), 6000, e);
			if((nnw.get_word().substring(0, 1).equals("ה"))||(nnw.get_word().substring(0, 1).equals("ת"))||(nnw.get_word().substring(0, 1).equals("י")))
			{
				return affix(new W_Path(nnww), e/10);
			}
			Noun(nnww, e/10);
		}
		if((nnw.get_word().substring(gen, end).equals("ה"))||(nnw.get_word().substring(gen, end).equals("ו"))||(nnw.get_word().substring(gen, end).equals("י"))||(nnw.get_word().substring(gen, end).equals("ת")))
		{
			double f2 = f;
			if(nnw.get_word().substring(gen, end).equals("ה"))
			{
				W.N_H = TW(finalf(nnw.get_word().substring(0, gen)), W.N_H, e);  
				if(W.N_H.delB()>=3.0)
				{
					f2 = e*Math.pow(2, W.N_H.ratio());
				}
				else{
					f2 = e/100;
				}	
			}
			if(nnw.get_word().substring(gen, end).equals("ו"))
			{
				W.N_V = TW(finalf(nnw.get_word().substring(0,gen)), W.N_V, e);  
				if(W.N_V.delB()>=3.0)
				{
					f2 = e*Math.pow(2, W.N_V.ratio());
				}
				else{
					f2 = e/100;
				}	
			}
			if(nnw.get_word().substring(gen, end).equals("י"))
			{
				W.N_I = TW(finalf(nnw.get_word().substring(0, gen)), W.N_I, e);  
				if(W.N_I.delB()>=3.0)
				{
					f2 = e*Math.pow(2, W.N_I.ratio());
				}
				else{
					f2 = e/100;
				}	
			}
			if(nnw.get_word().substring(gen, end).equals("ת"))
			{
				W.N_T = TW(finalf(nnw.get_word().substring(0, gen)), W.N_T, e);  
				if(W.N_T.delB()>=3.0)
				{
					f2 = e*Math.pow(2, W.N_T.ratio());
				}
				else{
					f2 = e/100;
				}	
			}
			nnw.set_word(nnw.get_word().substring(0, gen));
			TW(nnw.get_word(), W.N_T, f2);
			Noun(new W_Path(nnw), f2/5);
			end = nnw.get_word().length();
			gen = end -1;
			sing = gen -1;
		}
		if(end == 2)
		{
			nnw.set_word("נ" + nnw.get_word());
			W.N_2 = TW(nnw.get_word(), W.N_2, e);  
			if(W.N_2.delB()>=3.0)
			{
				f = e*Math.pow(2, W.N_2.ratio());
			}
			else{
				f = e/100;
			}	
			TW(nnw + "ה", W.N_2, f/20);
			return nnw;
		}
		end = nnw.get_word().length();
		gen = end -1;
		sing = gen -1;
		if(end < 2)
		{
			return nnw;
		}
		if(nnw.get_word().substring(0, 1).equals(nnw.get_word().substring(1, 2)))
		{
			String root2 =  "נ" + nnw.get_word().substring(1);
			W_Path roott2 = new W_Path(nnw);
			roott2.set_word(root2);
			W.N_N = TW(root2, W.N_N, e);  
			if(W.N_N.delB()>=3.0)
			{
				f = e*Math.pow(2, W.N_N.ratio());
			}
			else{
				f = e/100;
			}	
			TW(root2 + "ה", W.N_N, f/20); 
			roott2.set_word(roott2.get_word().substring(1));
			Noun(roott2, f/50);
		}
		end = nnw.get_word().length();
		gen = end -1;
		sing = gen -1;
		if(end < 2)
		{
			return nnw;
		}
		if((nnw.get_word().substring(0, 1).equals(nnw.get_word().substring(1, 2)))||(nnw.get_word().substring(0, 1).equals("י"))||(nnw.get_word().substring(0, 1).equals("ת")))
		{
			if(nnw.get_word().substring(0, 1).equals(nnw.get_word().substring(1, 2)))
			{
				String root =  "נ" + nnw.get_word().substring(1);
				W_Path roott = new W_Path(nnw);
				roott.set_word(root);
				TW(root, 2000, e);
				TW(root + "ה", 1000, e);
				roott.set_word(root.substring(1, end));
				Noun(roott, er);
			}
			
			TW(nnw.get_word().substring(1), 10, e);
			TW(nnw.get_word().substring(1) + "ה", 10, e);
			if(nnw.get_word().substring(0, 1).equals("י"))
			{
				TW(nnw.get_word(), 111, e);
				TW(nnw.get_word() + "ה", 100, e);
				if(nnw.get_word().substring(gen, end).equals("ה"))
				{
					TW(nnw.get_word(), 111, e);
				}
			}
			nnw.set_word( nnw.get_word().substring(1));
			
			if(nnw.get_word().substring(0, 1).equals("ת"))
			{
				nnw.set_t(true);
			}
			if(nnw.get_word().substring(0, 1).equals("י"))
			{
				nnw.set_i(true);
			}
			if(nnw.get_word().length() < 3)
			{
				return Noun(new W_Path(nnw), er/50);
			}
		}
		end = nnw.get_word().length();
		 sing = end -2;
		gen = end -1;
		if(nnw.get_word().substring(0, 2).equals("וי"))
		{
			String sl = unfinalf(nnw.get_word().substring(2, end));
			String flh = unfinalf(nnw.get_word().substring(2, end)) + "ה";
			String fflh = unfinalf(nnw.get_word().substring(1, end)) + "ה";
			String ffl = unfinalf(nnw.get_word().substring(1, end));
			 
			 TW(flh, 110, e);
			 TW(fflh, 110,e);
			 TW(ffl, 110,e);
			 TW(sl, 110, e);
			  TW("י" + flh, 110, e);
			  TW("י" + sl, 110, e);
			 TW("נ" + sl, 110, e);
			 TW("נ" + flh, 110, e);
			 if(end < 2)
			 {
			 	 return nnw;
			 }
		}
		return nnw;
	}
	public String permutate(String pwd, int p, double n, double e, int size)
	{
		e = e/117;
		if((e < WALL)&&(size > 6))
		{
			return pwd;
		}
		String wd =pwd;
		int end = wd.length();
		int gen = end -1;
		int sing = gen - 1;
		if(end == 2)
		{
			TW(wd, 500, e);
			TW(wd.substring(0,1) + "ו" + wd.substring(gen, end), W.HollowV, e);	
			TW(wd.substring(0,1) + "י" + wd.substring(gen, end), W.HollowI, e);
			return wd;
		}
		if(end < p)  //if finished (stoping condition
		{
			double nn = 4*n;
			TW(wd, nn, e); //Arceive it and return
			return wd;
		}
		int P = p+1;
		permutate(wd, P, n, e, size);
		if((wd.substring(p-1, p).equals("ו"))||(wd.substring(p-1, p).equals("י")))
		{
			String i_wd;
			String v_wd;
			String min_wd;
			double f = e;
			double g = e;
			int q = p+1;
			if(p == 0)
			{
				f = e/100;
				if(wd.substring(0, 1).equals("י"))
				{
					TW(wd, (n), e);
					min_wd = wd.substring(0, p-1) +  wd.substring(p, end);
					TW(min_wd, (n), f);
					permutate(min_wd, p, n, (f)/4, size);
				}
				else{
					min_wd = wd.substring(0, p-1) +  wd.substring(p, end);
					TW(min_wd, (n), e);
					permutate(min_wd, p, n, (g)/4, size);	
				}
			}
			else{
				if(wd.equals( "יהוה") == false)
				{
					TW(wd, (n), e);
				}
				min_wd = wd.substring(0, p-1) +  wd.substring(p, end);
				TW(min_wd, (n), e);
				permutate(min_wd, p, n, (g)/2, size);
			}
			if(end > p) 
			{
				
				if(wd.substring(p-1, p).equals("ו"))
				{
					if(wd.equals( "יהוה") == false)
					{
						TW(wd, (n), e);
					}
					i_wd = wd.substring(0, p-1) + "י" + wd.substring(p, end);
					if(i_wd.equals( "יהוה") == false)
					{
						TW(i_wd, (n), f);
					}
					permutate(i_wd, q, n, f/4, size);
				}
				else
				if(wd.substring(p-1, p).equals("י"))
				{
					if(wd.equals( "יהוה") == false)
					{
						TW(wd, (n), e);
					}
					v_wd = wd.substring(0, p-1) + "ו" + wd.substring(p, end);
					if(v_wd.equals( "יהוה") == false)
					{
						TW(v_wd, (n), f);
					}
					permutate(v_wd, q, n, f/4, size);
				}
			}
		}
		return wd;
	}
	public int K_Count(String wd)
	{
		int end = wd.length();
		int count = end;
		
		for(int i = 1; i < end; i++)
		{
			count = count*(end - i);
		}
		
		return count;
	}
				
	public String Kabbalah(String wd, int p)
	{
		int end = wd.length();
		int gen = end -1;
		int sing = gen - 1;
		char [] word = new char[end];
		
		if(p >= end - 1)  //if finished (stoping condition)
		{
			tableW(finalf(wd)); //Arceive it and return
			System.out.println(wd);
			System.out.println("\n");
			return wd;
		}
		for(int n = 0; n < end; n++)
		{
			word[n] = wd.charAt(n);
		}
		for(int i = p+1; i < end; i++)
		{
			char temp = word[p];
			word[p] = word[i];
			word[i] = temp;
			String n_wd = "";
			for(int n = 0; n < end; n++)
			{
				char chr = word[n];
				n_wd = (n_wd + chr).toString();
			}				
			Kabbalah(n_wd, p+1);
		}
		tableW(finalf(wd));
		Kabbalah(wd, p+1);
		return wd;
	}
	
	public String find_root(String wd)
	{
		double e =infinity/5;
		double f =infinity/5;
		double p = infinity/20;
		TW(wd, infinity, e);
		if(wd.equals( "יהוה"))
		{
			return wd;	
		}
		W_Path Word = new W_Path(wd);
		form(new W_Path(Word), e);
		stem(new W_Path(Word), e);
		return wd;
	}
	/**
		Finds the place in place of a given Hebrew letter in the Hebrew alphabet.
		@param the hebrew letter geven
	*/
	public int find_alf(String h)
	{
		for(int i = 0; i < 28; i++)
		{
			if(ABet[i].equalsIgnoreCase(h))
			{
				return i;
			}
		}
		return -1;
	}
	/*public int find_val(String s)
	{
		int j = find_alf(s);
		int n = AlefBet.get_value(j);
		
		return n;		
	}
	
	/**
		Calculates the numerical value of a word.
		@param the index of the word in data_map
	*/
	 public int gematria(int i)
	 {
		 int pos = 0;
		 int g = 0;
		 String s;
		 int j = 0;
		 int n = 0;
		 String w = data_map.get(i).get_val();
		 int size = w.length();
		 for(pos = 0; pos < size; pos ++)
		 {
			 if(pos < size - 1)
			 {
				 s = w.substring(pos, pos+1);
			 } 
			 else{
				 s = w.substring(pos);
			 }
			 j = find_alf(s);
			 switch (j)
			 {
				    case 1: n = 1; break;
				    case 2: n = 2; break;
				    case 3: n = 3; break;
				    case 4: n = 4; break;
				    case 5: n = 5;break;
				    case 6:n = 6; break;
				    case 7:n = 7; break;
				    case 8: n = 8; break;
				    case 9: n = 9; break;
				    case 10: n = 10; break;
				    case 11: n = 20; break;
				    case 12: n = 30; break;
				    case 13: n = 40;break; 
				    case 14: n = 50;break;
				    case 15: n = 60;break;
				    case 16: n = 70;break;
				    case 17: n = 80;break;
				    case 18: n = 90;break;
				    case 19: n = 100;break;
				    case 20: n = 200;break;
				    case 21: n = 300;break;
				    case 22: n = 400;break;
				    case 23: n = 20;break;
				    case 24: n = 40;break;
				    case 25: n = 50;break;
				    case 26: n = 80;break;
				    case 27: n = 90;break;
					    default:  n = 0; //System.out.print("*******" + s + "********");
			 }
			 g += n;
		 }
		 return g;
	 }
	 public int new_gematria(String w)
	 {
		 int pos = 0;
		 int g = 0;
		 String s;
		 int j = 0;
		 int n = 0;
		 int size = w.length();
		 for(pos = 0; pos < size; pos ++)
		 {
			 if(pos < size - 1)
			 {
				 s = w.substring(pos, pos+1);
			 } 
			 else{
				 s = w.substring(pos);
			 }
			 System.out.print(s);
			 j = find_alf(s);
			 switch (j)
			 {
				    case 1: n = 1; break;
				    case 2: n = 2; break;
				    case 3: n = 3; break;
				    case 4: n = 4; break;
				    case 5: n = 5; break;
				    case 6:n = 6; break;
				    case 7: n = 7; break;
				    case 8: n = 8; break;
				    case 9: n = 9; break;
				    case 10: n = 10; break;
				    case 11: n = 20; break;
				    case 12: n = 30; break;
				    case 13: n = 40; break; 
				    case 14: n = 50; break;
				    case 15: n = 60; break;
				    case 16: n = 70; break;
				    case 17: n = 80; break;
				    case 18: n = 90; break;
				    case 19: n = 100; break;
				    case 20: n = 200; break;
				    case 21: n = 300; break;
				    case 22: n = 400; break;
				    case 23: n = 20; break;
				    case 24: n = 40; break;
				    case 25: n = 50; break;
				    case 26: n = 80; break;
				    case 27: n = 90; break;
					    default:  n = 0; //System.out.print("*******" + s + "********");
			 }
			 g += n;
		 }
		 return g;
	 }
	 public String ReverseChar(String tok)
	 {
	 	String rev = "";
	 	int n = tok.length() - 1;
	 	for(int i  =  n; i >=  0; i--)
	 	{
	 		rev = rev + tok.charAt(i) + "";
	 	}
	 	return rev;	 
	 }
	 public void start_study()
	 {
	 	 
	 	 final JButton kabbalahButton = new JButton("Kabbalah");
		 class KabbalahButtonListener implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 try{
					 PermutateW(1);
				 }
				 catch(IOException e)
				 {
					 System.out.println("Error occurred while trying to retrieve word.");
				 }
			 }
		 };
		 ActionListener kblistener = new KabbalahButtonListener();
		 kabbalahButton .addActionListener(kblistener);
		 
		 JButton searchButton = new JButton("Search");
		 class SearchButtonListener implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 try{
					 search_words(0);
				 }
				 catch(IOException e)
				 {
					 System.out.println("Error occurred while trying to retrieve word.");
				 }
			 }
		 };
		 ActionListener listener = new SearchButtonListener();
		 searchButton .addActionListener(listener);
	 
	 
		 JButton addwButton = new JButton("Add Word");
		 class AddwButtonListener implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 try{
					 add_words();
				 }
				 catch(IOException e)
				 {
					 System.out.println("Error occurred while trying to add new word.");
				 }
			 }
		 };
		 ActionListener awlistener = new AddwButtonListener();
		 addwButton .addActionListener(awlistener);
	 
		 JButton editwButton = new JButton("Edit Word");
		 class EditwButtonListener implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 try{
					 edit_word();
				 }
				 catch(IOException e)
				 {
					 System.out.println("Error occurred while trying to change word.");
				 }
			 }
		 };
		 ActionListener ewlistener = new EditwButtonListener();
		 editwButton.addActionListener(ewlistener);

		 JButton deletewButton = new JButton("Delete Word");
		 class DeletewButtonListener implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 try{
					 delete_word();
				 }
				 catch(IOException e)
				 {
					 System.out.println("Error occurred while trying to remove word.");
				 }
			 }
		 };
		 ActionListener dwlistener = new DeletewButtonListener();
		 deletewButton.addActionListener(dwlistener);
	 
		 JButton closeButton = new JButton("Exit");
		 class CloseButtonListener implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		 };
		 ActionListener clistener = new CloseButtonListener();
		 closeButton .addActionListener(clistener);
	 
	 
		 bLabel = new JLabel("Dictionary");
		 bPanel.add(addwButton);
		 bPanel.add(bLabel);
		 bPanel.add(editwButton);
		 bPanel.add(deletewButton);
		 bPanel.add(searchButton);
		 bPanel.add(kabbalahButton);
		 bPanel.add(closeButton);
	 
		 bFrame.setContentPane(bPanel);
		 bFrame.pack();
		 bFrame.show();
	 }
	 public JButton keyboardButton(String label, final String key)
	 {
		 JButton button = new JButton(label);
	
		 class ButtonListener implements ActionListener
		 {
			 public void actionPerformed(ActionEvent event)
			 {
			 	 String prev = textField.getText();
			 	 int end = prev.length();
			 	 if(key.charAt(0) == '0')
			 	 {
			 		 if(key.equals("0clear"))
			 		 {
					 	 textField.setText("");
					 }
					
					 if(key.equals("0RevChr"))
					 {
					 	 String [] temps;
					 	 temps = new String[500];
					 	 String revC = "";
					 	 int k = 0;
					 	textField.setText(ReverseChar(prev));
					 }
					  
					 if(key.equals("0rev"))
					  {
			 		 	 String [] temps;
			 		 	 String [] revs;
			 		 	 temps = new String[500];
			 		 	 revs = new String[500];
			 		 	 String rev = "";
			 		 	 StringTokenizer tokens = new StringTokenizer(prev, "  ");
			 		 	 int k = 0;
			 		 	 while ((tokens.hasMoreTokens())&&(k<500))
			 		 	 {
			 		 	 	 String token = tokens.nextToken();
			 		 	 	 temps[k] = token;
			 		 	 	 k++;
						 }
						 k = k - 1;
						 int j = 0;
						 System.out.println( "  k= " + k + "\n");
						 while (j <= k)
			 		 	 {
			 		 	 	 revs[j] = temps[k - j];
			 		 	 	 revs[j] = rTok(revs[j]);
			 		 	 	 j++;
						 }
						 for(int i = 0; i < j; i++)
						 {
						 	 if(i < j-1)
						 	 rev = rev + revs[i] + " ";
						 	else
						 		rev = rev + revs[j-1];
						 }
					 	 textField.setText(rev);
					 }
					 
					 if(key.equals("0BkWd"))
					  {
			 		 	 String [] temps;
			 		 	 String [] bwds;
			 		 	 temps = new String[500];
			 		 	 bwds = new String[500];
			 		 	 String bwd = "";
			 		 	 StringTokenizer tokens = new StringTokenizer(prev, ", - ");
			 		 	 int k = 0;
			 		 	 while ((tokens.hasMoreTokens())&&(k<500))
			 		 	 {
			 		 	 	 String token = tokens.nextToken();
			 		 	 	 temps[k] = token;
			 		 	 	 k++;
						 }
						 k = k - 1;
						 int j = 0;
						 System.out.println( "  k= " + k + "\n");
						 while (j < k)
			 		 	 {
			 		 	 	 bwds[j] = temps[j];
			 		 	 	 j++;
						 }
						 for(int i = 0; i < j; i++)
						 {
						 	 if(i < j-1)
						 	 bwd = bwd + bwds[i] + " ";
						 	else
						 		bwd = bwd + bwds[j-1];
						 }
					 	 textField.setText(bwd);
					 }
					 if(key.equals("0U"))
					  {
			 		 	 String [] temps;
			 		 	 String [] fwds;
			 		 	 temps = new String[500];
			 		 	 fwds = new String[500];
			 		 	 String fwd = "";
			 		 	 StringTokenizer tokens = new StringTokenizer(prev, " ");
			 		 	 int k = 0;
			 		 	 while ((tokens.hasMoreTokens())&&(k<500))
			 		 	 {
			 		 	 	 String token = tokens.nextToken();
			 		 	 	 temps[k] = token;
			 		 	 	 k++;
						 }
						 int j = 0;
						 System.out.println( "  k= " + k + "\n");
						 while (j < k)
			 		 	 {
			 		 	 	 fwds[j] = finalf(temps[j]);
			 		 	 	 fwds[j] = fTok(fwds[j]);
			 		 	 	 j++;
						 }
						 for(int i = 0; i < j; i++)
						 {
						 	 if(i < j-1)
						 	fwd = fwd + fwds[i] + " ";
						 	else
						 		fwd = fwd +fwds[j-1];
						 }
					 	 textField.setText(fwd);
					 }
					  if(key.equals("0--"))
					  {
					  	  String fwd = "";
					  	  String space = " ";
					  	  String dash = "-";
					  	  if(DTok(prev))
					  	  {
					  	  	  fwd =  GTok(prev, space);
					  	  }
					  	  else{
					  	  	fwd =  GTok(prev, dash);	  
					  	  }
					 	 textField.setText(fwd);
					 }
					if(key.equals("0BkSp"))
					{
						 int l = prev.length();
						 if(l > 1)
						 {
							 textField.setText(prev.substring(0, prev.length()-1));
						 }
						 else{
							textField.setText("");
						 }
					}
				 }
				 else{
				 	 if(!((end < 1)||(key.equals(" "))||(key.equals("-"))))
				 	 {
				 	 	 prev = unfinalf(prev);
				 	 }
				 	textField.setText(prev + key);	 
				 }
			 }
		 };
		 ActionListener listener = new ButtonListener();
		 button.addActionListener(listener);
		 return button;
	 }
	 public static void main(String args[])
	 throws java.io.IOException
	 {
		 Dictionary book = new Dictionary();
		 book.start_study();
	 }
}