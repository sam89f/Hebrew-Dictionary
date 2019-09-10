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

/**
	W_Path stores which letters were removed from a string by creating
	an object with field representing the letters which may potentialy
	be removed from the string durring it's life time.
*/
public class W_Path
{
	/**
		Constructs a W_Path object with the word value initialized to
		a_word, and all the boolean values initialized to false.
		@param a_word string to be stored in the new W_Path object
	*/
	public W_Path(String a_word)
	{
		word = a_word;
		a = false;
		b = false;
		d = false;
		h = false;
		v = false;
		i = false;
		c = false;
		l = false;
		m = false;
		n = false;
		s = false;
		t = false;
	}
	/**
		Constructs an object with the same values as path.
		@param path the object to be cobied
	*/
	public W_Path(W_Path path)
	{
		word = path.word;
		a = path.a;
		b = path.b;
		d = path.d;
		h = path.h;
		v = path.v;
		i = path.i;
		c = path.c;
		l = path.l;
		m = path.m;
		n = path.n;
		s = path.s;
		t = path.t;
	}
	/**
		Returns the string.
		@return the string, word
	*/
	public String get_word()
	{
		return word;
	}
	/**
		Returns true if an Alef was removed from begening the word,
		and false if it was not.
		@return true/false indicating if an Alef was removed from begening or not
	*/
	public boolean get_a()
	{
		return a;
	}
	/**
		Returns true if a Bet was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Bet was removed from begening or not
	*/
	public boolean get_b()
	{
		return b;
	}
	/**
		Returns true if a Dalet was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Dalet was removed from begening or not
	*/
	public boolean get_d()
	{
		return d;
	}
	/**
		Returns true if a Hey was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Hey was removed from begening or not
	*/
	public boolean get_h()
	{
		return h;
	}
	/**
		Returns true if a Vav was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Vav was removed from begening or not
	*/
	public boolean get_v()
	{
		return v;
	}
	/**
		Returns true if an Yod was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Yod was removed from begening or not
	*/
	public boolean get_i()
	{
		return i;
	}
	/**
		Returns true if a Kaf was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Kaf was removed from begening or not
	*/
	public boolean get_c()
	{
		return c;
	}
	/**
		Returns true if a Lamed was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Lamed was removed from begening or not
	*/
	public boolean get_l()
	{
		return l;
	}
	/**
		Returns true if a Mem was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Mem was removed from begening or not
	*/
	public boolean get_m()
	{
		return m;
	}
	/**
		Returns true if a Nun was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Nun was removed from begening or not
	*/
	public boolean get_n()
	{
		return n;
	}
	/**
		Returns true if a Sin was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Sin was removed from begening or not
	*/
	public boolean get_s()
	{
		return s;
	}
	/**
		Returns true if an Tav was removed from begening the word,
		and false if it was not.
		@return true/false indicating if a Tav was removed from begening or not
	*/
	public boolean get_t()
	{
		return t;
	}
	/**
		Sets the value of word to wd;.
		@param wd value which  the variable word will be set to
	*/
	public void set_word(String wd)
	{
		word = wd;
	}
	/**
		Sets the value of a to bi;.
		@param bi value which  variable a will be set to
	*/
	public void set_a(boolean bi)
	{
		a = bi;
	}
	/**
		Sets the value of b to bi;.
		@param bi value which  variable b will be set to
	*/
	public void set_b(boolean bi)
	{
		b = bi;
	}
	/**
		Sets the value of d to bi;.
		@param bi value which  variable d will be set to
	*/
	public void set_d(boolean bi)
	{
		d = bi;
	}
	/**
		Sets the value of h to bi;.
		@param bi value which  variable h will be set to
	*/
	public void set_h(boolean bi)
	{
		h = bi;
	}
	/**
		Sets the value of v to bi;.
		@param bi value which  variable v will be set to
*/
	public void set_v(boolean bi)
	{
		v = bi;
	}
	/**
		Sets the value of i to bi;.
		@param bi value which  variable i will be set to
	*/
	public void set_i(boolean bi)
	{
		i = bi;
	}
	/**
		Sets the value of c to bi;.
		@param bi value which  variable c will be set to
	*/
	public void set_c(boolean bi)
	{
		c = bi;
	}
	/**
		Sets the value of l to bi;.
		@param bi value which  variable l will be set to
	*/
	public void set_l(boolean bi)
	{
		l = bi;
	}
	/**
	Sets the value of m to bi;.
	@param bi value which  variable m will be set to
	*/
	public void set_m(boolean bi)
	{
		m = bi;
	}
	/**
		Sets the value of n to bi;.
		@param bi value which  variable n will be set to
	*/
	public void set_n(boolean bi)
	{
		n = bi;
	}
	/**
		Sets the value of s to bi;.
		@param bi value which  variable s will be set to
	*/
	public void set_s(boolean bi)
	{
		s = bi;
	}
	/**
		Sets the value of t to bi;.
		@param bi value which  variable t will be set to
	*/
	public void set_t(boolean bi)
	{
		t = bi;
	}
	
	private String word;
	private boolean a;
	private boolean b;
	private boolean d;
	private boolean h;
	private boolean v;
	private boolean i;
	private boolean c;
	private boolean l;
	private boolean m;
	private boolean n;
	private boolean s;
	private boolean t;
}
