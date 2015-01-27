/**
 * Reads a text document, counts the occurrence of
 * words and displays them in html format with different
 * sizes depending on the frequency of the words.
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @since March 30, 2014
 * 
 */



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Set;
import java.util.TreeMap;


public class HTML_writer 
{
	private static final int NUMOFTAGS = 5;
	
	private TreeMap<String, Integer>alpha_sorted_map;
	
	private int smallest_tag_limit,
	            small_tag_limit,
	            medium_tag_limit,
	            large_tag_limit;
	
	
	
	/**
	 * Constructor for HTML_writer
	 * 
	 */
	
	public HTML_writer()
	{
		Data_map data_map = new Data_map();
		
		this.alpha_sorted_map = data_map.get_sorted_by_key_map();
		
		this.smallest_tag_limit = data_map.get_sorted_by_value_map().pollFirstEntry().getValue() / NUMOFTAGS;
		
		this.small_tag_limit = this.smallest_tag_limit * 2;
		
		this.medium_tag_limit = this.smallest_tag_limit * 3;
		
		this.large_tag_limit = this.smallest_tag_limit * 4;
	}
	
	
	
	/**
	 * Writes to a html file the data from the treeMap and finds
	 * appropriate font sizes depending on the frequency of the
	 * words.
	 * 
	 */
	
	public void write_to_file()
	{
		int freq,
		    number;
		
		Set<String> set_key = this.alpha_sorted_map.keySet();
		
		String [] set_key_array = (String[]) Array.newInstance(set_key.toArray()[0].getClass(), set_key.size());
		
		for (int i = 0; i < set_key.size(); i++)
			set_key_array[i] = (String) set_key.toArray()[i];
		
		
		try
		{
			
			// Create file 
			FileWriter fstream = new FileWriter("html_output.html");
			BufferedWriter out = new BufferedWriter(fstream);
			 
			 
			 
			// write html headers and body
			out.write("<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n<title>html_output</title>\n</head>\n<body>");
			  
			// write style
			out.write("<style type=\"text/css\">\n.smallestTag {font-size: xx-small;}\n.smallTag {font-size: small;}\n.mediumTag {font-size: medium;}\n.largeTag {font-size: large;}\n.largestTag {font-size: xx-large;}\n</style>");
			  
			number = 0;
			
			// for each word find corresponding tag and write to file
			for (String str: set_key_array)
			{
				number ++;
				
				freq = this.alpha_sorted_map.get(str);
				
				if (freq <= this.smallest_tag_limit)
					out.write("<span class=\"smallestTag\"> " + str + " </span>");

				
				else if (freq > this.smallest_tag_limit && freq <= this.small_tag_limit)
					out.write("<span class=\"smallTag\"> " + str + " </span>");

					
				else if (freq > this.small_tag_limit && freq <= this.medium_tag_limit)
					out.write("<span class=\"mediumTag\"> " + str + " </span>");

				
				else if (freq > this.medium_tag_limit && freq <= this.large_tag_limit)
					out.write("<span class=\"largeTag\"> " + str + " </span>");
				
				
				else { out.write("<span class=\"largestTag\"> " + str + " </span>"); }
				
				
				if (number == 54)
				{
					number = 0;
					out.write("\n");
				}
				
			}
			
			// write closing html tags and body
			out.write("</body>\n</html>");
			
			// close out
			out.close();
			
		}
		
		catch (Exception e){ System.out.println("Error cannot create file.");  }
		
	}
	

	public static void main(String[] args) 
	{	
		HTML_writer html_writer = new HTML_writer();
		
		html_writer.write_to_file();
		
		System.out.println("The file is named html_output.html");
	}
	
}
