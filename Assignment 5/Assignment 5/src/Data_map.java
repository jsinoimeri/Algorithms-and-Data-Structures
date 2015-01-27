/**
 * Reads two text documents, one is the stop words (common words)
 * and the other is the interested document. Creates and sorts a map
 * with words from the interested document according to the number of
 * occurrences. 
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @sinceMarch 29, 2014
 * 
 */


import java.io.*;
import java.util.*;


public class Data_map
{
	private Set<String> stopwords;
	
	private TreeMap<String, Integer> sorted_value_map,
	                                 sorted_key_map;
	
	
	
	/**
	 * Constructor for Data_map class
	 * 
	 */
	
	public Data_map()
	{
		this.stopwords = new HashSet<String>();
		this.sorted_key_map = new TreeMap<String, Integer>();
		this.sorted_value_map = new TreeMap<String, Integer>();
		
		this.make_sorted_by_value_map();
	}
	
	
	
	/**
	 * Gets all the stop words from a file and stores
	 * them in a set.
	 * 
	 */
	
	@SuppressWarnings("resource")
	private void stopWords()
	{
		
		try 
		{			
			// user input
			Scanner user_input = new Scanner(System.in);
			System.out.println("Enter stopwords file name: ");
			
			// create new file instance
			File file_name = new File(user_input.next());
			
			// create new scanner instance
			Scanner input = new Scanner(file_name);
			
			
			// Adds the lowercase version of stop words to the set
			while(input.hasNext())
			{
				String stop_word = input.next().toLowerCase();
				
				if (!this.stopwords.contains(stop_word)) { this.stopwords.add(stop_word); }
		   }
			
		} 
		
		// catch file not found exception
		catch (FileNotFoundException e) 
		{
			System.out.println("Stopwords file not found");
			System.exit(0);
		} 
	}
	
	
	
	/**
	 * Creates a treeMap object with (key, value) where key is a string representing
	 * the individual words in the document and value is an integer representing the
	 * amount of times that particular word appears in the document.
	 * 
	 * @return treeMap object that is sorted alphabetically
	 * 
	 */
	
	@SuppressWarnings("resource")
	private TreeMap<String, Integer> make_sorted_by_key_map()
	{
		this.stopWords();
		
		try 
		{	
			Scanner user_input = new Scanner(System.in);
			System.out.println("\nEnter document file name: ");

			// create new file instance
		    File file_name = new File(user_input.next());

			
			// create new scanner instance
			Scanner input = new Scanner(file_name).useDelimiter("[ ,.:;\t\n\r()1-9<>/?{}|~`!@#^&\"—“”]");
			
			
			// adds the lowercase version of the document words to the map as long as they are
			// not stop words and have a length greater than 2.
			
			while(input.hasNext())
			{
				String word = input.next().toLowerCase();

			    if (!this.stopwords.contains(word) && word.length() > 2)
				{
						
			    	// if map contains the key than update the value
					if (this.sorted_key_map.containsKey(word))
				    {
						int freq = this.sorted_key_map.get(word);
							
						freq ++;
							
						this.sorted_key_map.put(word, freq);
					}
						
					// otherwise put the key in the map and set value to 1
					else { this.sorted_key_map.put(word, 1); }
                }
                
		   }
			
		   // close scanner instances
		   user_input.close();
		   input.close();
		} 
		
		
		// catch file not found exception
		catch (FileNotFoundException e) 
		{
			System.out.println("Document file not found");
			System.exit(0);
		} 
		
		return this.sorted_key_map;

	}
	
	
	
	/**
	 * Compares the treeMap object by value and sorts it accordingly
	 * 
	 * @param tree_maps  TreeMap object to be compared
	 * @return TreeMap object that is sorted in descending order in terms of values
	 * 
	 */
	
	private static <K, V extends Comparable<V>> TreeMap<K, V> sort_by_tree_value(final TreeMap<K, V> tree_maps) 
	{
	    Comparator<K> value_comparator =  new Comparator<K>() 
	    {
	        public int compare(K key1, K key2) 
	        {
	            int compare_val = tree_maps.get(key2).compareTo(tree_maps.get(key1));
	            
	            // if the values are the same, then return 1 to ensure keys with same values still appear in map
	            if (compare_val == 0) { return 1; }
	            
	            // otherwise return the value
	            else { return compare_val; }
	        }
	    };
	    
	    // creates an instance of TreeMap object
	    TreeMap<K, V> sorted_by_values = new TreeMap<K, V>(value_comparator);
	    
	    // puts all the values into sorted_by_values variable
	    sorted_by_values.putAll(tree_maps);
	    
	    return sorted_by_values;
	}
	
	
	
	/**
	 * Creates a treeMap object with (key, value) where key is a string representing
	 * the individual words in the document and value is an integer representing the
	 * amount of times that particular word appears in the document.
	 * 
	 * @return treeMap object that is sorted in decreasing values
	 * 
	 */
	
	private void make_sorted_by_value_map()
	{
		this.sorted_value_map = sort_by_tree_value(this.make_sorted_by_key_map());
	}
	
	
	
	/**
	 * Accessor for the sorted by values map
	 * 
	 * @return TreeMap object sorted by values in descending order
	 * 
	 */
	
	public TreeMap<String, Integer> get_sorted_by_value_map()
	{
		return this.sorted_value_map;
	}
	
	
	
	/**
	 * Accessor for the sorted by key map
	 * 
	 * @return TreMap objected sorted alphabetically in ascending order
	 * 
	 */
	
	public TreeMap<String, Integer> get_sorted_by_key_map()
	{
		return this.sorted_key_map;
	}
}
