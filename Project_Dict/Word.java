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
	A Word has a String value and a definition associated with it.
*/
public class Word implements Comparable
{
	/**
		Compares the Word object with another given Word object lexicographically
		@param the other Word object to be compared to Word object
		@return negative one if Word comes before the other Word zero if they are the same and one if otherwise
	*/
	public int compareTo(Object OtherWord)
	{
		Word Other = (Word)OtherWord;
		return value.compareToIgnoreCase(Other.value);
	}
		
        private String value;
	private String def;
	
	/**
		Constructs a Word with a String value in the value field, and a definition of the word in the def field.
		@param v String to be set in the value field of the Word
		@param d String to be set in the def field of Word
	*/
	public Word(String v, String d)
	{
		value = v;
		def = d;
	}
	
	/**
		Constructs a Word with the same value field, and the same def field of a given Word.
		@param word the Word to be copied in the new constructed word
	*/
	public Word(Word word)
	{
		value = word.value;
		def = word.def;
	}
	
	/**
		Returns the value field of Word
		@return the value field of Word
	*/
	public String get_val()
	{
		return value;
	}
	
	/**
		Returns the def field of Word
		@return the def field of Word
	*/
	public String get_def()
	{
		return def;
	}
}
