import java.awt.Graphics2D;
import java.awt.geom.*;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.*;
import java.util.Calendar; 
import java.text.ParseException;
import java.util.Date.*;

public interface Item
{
	void setItem(String i);
	int Print();
	int Print(PrintWriter printer)throws java.io.IOException;
	int getData(BufferedReader R)throws java.io.IOException;
}
