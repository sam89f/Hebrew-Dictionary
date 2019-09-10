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

public class Numbers
{
   private String name;
	private int value;
   public void Numbers()
	{
		value = 0;
		name = "zero";
	}
	public void set_val(int n)
	{
		value = n;
	}
	public void set_name(String n)
	{
		name = n;
	}
		public int get_val()
	{
		return value;
	}
	public String get_name()
	{
		return name;
	}
}
