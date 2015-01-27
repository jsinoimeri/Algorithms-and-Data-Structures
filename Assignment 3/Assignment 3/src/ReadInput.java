/**
 * Read from file to find fixed
 * numbers of the Sudoku puzzle.
 * 
 * @author Jeton Sinoimeri
 * 
 * @since Feb 15, 2014
 * 
 */


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ReadInput 
{
	private int [][] fixed_array;
	
	
	public ReadInput()
	{
		try 
		{
			int entires_num;
			
			// user input
			Scanner user_input = new Scanner(System.in);
			System.out.println("Enter file name: ");
			
			// create new file instance
			File file_name = new File(user_input.next());
			
			// create new scanner instance
			Scanner input = new Scanner(file_name);
		
			// get integer in first line from file
			entires_num = input.nextInt();
			
			this.fixed_array = new int[entires_num][3];
			
			// read from file
			for (int i = 0; i < entires_num; i++)
			{
				this.fixed_array[i][0] = input.nextInt();
				this.fixed_array[i][1] = input.nextInt();
				this.fixed_array[i][2] = input.nextInt();
			}
			
			// close scanner instances
			user_input.close();
			input.close();
		} 
		
		// catch file not found exception
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			System.exit(0);
		} 
		
	}
	
	
	/**
	 * Accessor for the fixed numbers of the Sudoku puzzle
	 * 
	 * @return  a two dimensional integer array representing the fixed numbers
	 * 			of the Sudoku puzzle
	 */
	
	public int [][] getFixedNums()
	{
		return this.fixed_array;
	}
	
	
	/**
	 * Accessor for the size of the fixed numbers array
	 * 
	 * @return  integer value representing the size of fixed numbers array
	 */
	
	public int size()
	{
		return this.fixed_array.length;
	}
	
}
