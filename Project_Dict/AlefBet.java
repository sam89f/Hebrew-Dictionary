import java.io.IOException;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.Calendar; 
import java.text.ParseException;
import java.util.Date.*;
import java.io.Console.*;
import java.math.*;

public class AlefBet
{
	public Map<String, Numbers>alef_bet;
	public Map<String, String>phonic;
   private Numbers[] values;
   public void AlefBet()
	{
		values = new Numbers[100];
		 alef_bet =  new HashMap<String, Numbers>();
		 phonic = new HashMap<String, String>();
		set_numbers();
		alef_bet.put("0", values[0]);	 
		alef_bet.put("א", values[1]);
		alef_bet.put("ב", values[2]);	  
		alef_bet.put("ג", values[3]);	   
		alef_bet.put("ד", values[4]);
		alef_bet.put("ה", values[5]);	   
		alef_bet.put("ו", values[6]);	  
		alef_bet.put("ז", values[7]);	   
		alef_bet.put("ח", values[8]);	
		alef_bet.put("ט", values[9]);	   
		alef_bet.put("י", values[10]);	  
		alef_bet.put("כ", values[11]);	   
		alef_bet.put("ל", values[12]);
		alef_bet.put("מ", values[13]);	   
		alef_bet.put("נ", values[14]);	  
		alef_bet.put("ס", values[15]);	   
		alef_bet.put("ע", values[16]);	
		alef_bet.put("פ", values[17]);	   
		alef_bet.put("צ", values[18]);	  
		alef_bet.put("ק", values[19]);	   
		alef_bet.put("ר", values[20]);
		alef_bet.put("ש", values[21]);	   
		alef_bet.put("ת", values[22]);	  
		alef_bet.put("ך", values[23]);	   
		alef_bet.put("ם", values[24]);
		alef_bet.put("ן", values[25]);	   
		alef_bet.put("ף", values[26]);	  
		alef_bet.put("ץ", values[27]);	   
}
public int get_value(int n)
{
	return values[n].get_val();	
}
public void set_numbers()
{
   for(int i = 0; i < 11; i++)
	{
		values[i].set_val(i);
	}
	 values[11].set_val(20);
    values[12].set_val(30);
	 values[13].set_val(40);
	 values[14].set_val(50);
	 values[15].set_val(60);
	 values[16].set_val(70);
	 values[17].set_val(80);
    values[18].set_val(90);
	 values[19].set_val(100);
	 values[20].set_val(200);
	 values[21].set_val(300);
    values[22].set_val(400);
	 values[23].set_val(500);
	 values[24].set_val(600);
	 values[25].set_val(700);
	 values[26].set_val(800);
    values[27].set_val(900);
 	 
	 values[1].set_name("one"); 
	 values[2].set_name("two");
	 values[3].set_name("three");
    values[4].set_name("four");
	 values[5].set_name("five");
	 values[6].set_name("six");
	 values[7].set_name("seven");
    values[8].set_name("eight");
	 values[9].set_name("nine"); 
	 values[10].set_name("ten");
	 values[11].set_name("twenty");
    values[12].set_name("thirty");
	 values[13].set_name("forty");
	 values[14].set_name("fifty");
	 values[15].set_name("sixty");
    values[16].set_name("seventy");
	 values[17].set_name("eighty");
    values[18].set_name("ninety");
	 values[19].set_name("oneHundred");
	 values[20].set_name("twoHundred");
	 values[21].set_name("threeHundred");
    values[22].set_name("fourHundred");
	 values[23].set_name("fiveHundred");
	 values[24].set_name("sixHundred");
	 values[25].set_name("sevenHundred");
	 values[26].set_name("eightHundred");
    values[27].set_name("nineHundred");
   }
}
