/**
 * Finds an object in a 2D array where data in
 * each row and in each column is sorted in 
 * increasing order.
 * 
 * @author Jeton Sinoimeri
 * 
 * @since March 18, 2014
 * 
 */

public class SearchArray <T extends Comparable<? super T>>
{
	
	/**
	 * Searches the 2D array using Linear search until desired item is found
	 * 
	 * @param data  generic 2D array
	 * @param desiredItem  the item which is trying to be searched in 2D array
	 * @return true if the desired item is found in the array
	 * 
	 */
	
	public static <T extends Comparable<? super T>> boolean bruteForceSearch(T[][] data, T desiredItem)
	{
		int row = data.length;
		int col = data[0].length;
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (data[i][j].compareTo(desiredItem) == 0)
					return true;

		return false;
	}
	
	
	/**
	 * Searches the 2D array using Binary search by calling
	 * itself recursively until desired item is found
	 * 
	 * @param data  generic 2D array
	 * @param desiredItem  the item which is trying to be searched in 2D array
	 * @return true if the desired item is found in the array
	 * 
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Comparable <? super T>> boolean search(T[][] data, T desiredItem)
	{
		int row = data.length - 1;
		int col = data[0].length - 1;
		
		// base case if its a 1x1 array
		if (row == 0 && col == 0)
		{
			if (data[0][0].compareTo(desiredItem) == 0)
				return true;
			
			return false;
		}
		
		
		int new_row = row;
		int new_col = col;
		
		
		if (new_row > 0)
		    new_row /= 2;
		
		if (new_col > 0)
		    new_col /= 2;
		
		
		
		// compares the middle element to desiredItem
		if (data[new_row][new_col].compareTo(desiredItem) == 0)
			return true;
		
		
		
		// if the middle element is less than desireItem, than check the
		// upper left, lower left and top right subarray
		
		if (desiredItem.compareTo(data[new_row][new_col]) < 0)
		{
			
			boolean found;
			
			// top left
			if (new_row > 0 && new_col > 0)
			{
				
			    Comparable[][] half_data = new Comparable[new_row][new_col];
			
			    for (int i = 0; i < new_row; i++)	
				    for (int j = 0; j < new_col; j++)
					    half_data[i][j] = data[i][j];
			
			     found = search(half_data, desiredItem); // call method recursively
			     
			     if (found)
			    	 return found;
			}
			
			// bottom left
			if (new_col > 0)
			{
				Comparable[][] half_data = new Comparable[row - new_row + 1][new_col];
				
			    for (int i = 0; i < row - new_row + 1; i++)	
				    for (int j = 0; j < new_col; j++)
					    half_data[i][j] = data[i + new_row][j];
			
			     found = search(half_data, desiredItem); // call method recursively
			     
			     if (found)
			    	 return found;
			}
			
			
			// top right
			if (new_row > 0)
			{
			    Comparable[][] half_data = new Comparable[new_row][col - new_col + 1];
							
				for (int i = 0; i < new_row; i++)	
					for (int j = 0; j < col - new_col + 1; j++)
						half_data[i][j] = data[i][j + new_col];
						
				return search(half_data, desiredItem); // call method recursively
			}
			 
			 
		}
		
		
		
		// if the middle element is greater than desiredItem, than check the
		// upper right, lower left and lower right subarrays if exist
		
		if (desiredItem.compareTo(data[new_row][new_col]) > 0)
		{
						
			boolean found;
			
			
			if (col - new_col > 0)
			{
			    // top right subarray
			    Comparable[][] half_data = new Comparable[new_row + 1][col - new_col];

			    for (int i = 0; i < new_row + 1; i++)
				    for (int j = 0; j < col - new_col; j++)
				   	   half_data[i][j] = data[i][j + new_col + 1];
			
			    found = search(half_data, desiredItem); // call method recursively
			
			    if (found) 
				    return found;
			}
			
			
			if (row - new_row > 0)
			{
			    // bottom left subarray
			    Comparable[][] half_data = new Comparable[row - new_row][new_col + 1];
			
			    for (int i = 0; i < row - new_row; i++)
				    for (int j = 0; j < new_col + 1; j++)
				 	    half_data[i][j] = data[i + new_row + 1][j];
			
			    found = search(half_data, desiredItem); // call method recursively
			
			    if (found) 
				    return found;
			}
			
			
			if (row - new_row > 0 && col - new_col > 0)
			{
			    // bottom right subarray
			    Comparable[][] half_data = new Comparable[row - new_row][col - new_col];
			
			    for (int i = 0; i < row - new_row; i++)
				    for (int j = 0; j < col - new_col; j++)
					    half_data[i][j] = data[i + new_row + 1][j + new_col + 1];
			
			    return search(half_data, desiredItem); //call method recursively
			}
			
		}
		
		return false;
	}
	
}
