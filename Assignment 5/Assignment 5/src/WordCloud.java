/**
 * Reads a text document, counts the occurrence of
 * words and determines the ten most frequent used
 * words in the document.
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @since March 29, 2014
 * 
 */



import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;


public class WordCloud 
{
	
	public static void main(String[] args) 
	{	
        Data_map data_map = new Data_map();
        
        
        // creates an instance  of a treeMap and assigns it the sorted by value map
        TreeMap<String, Integer>tree_map = data_map.get_sorted_by_value_map();
		
		
		// creates an instance of a set from a TreeMap instance
		Set<Entry<String, Integer>> set_map = tree_map.entrySet();
		
		
		// creates an object array containing the elements in the set
		Object[] set_map_array = set_map.toArray();
		
		
		// print 10 most frequent words
		System.out.println("\nThe top 10 most frequent words in the document are: ");
		
		for (int i = 0; i < 10;i++)
			System.out.println(set_map_array[i]);

	}
	
}
