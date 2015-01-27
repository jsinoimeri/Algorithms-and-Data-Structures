/**
 * Holds a record of the least amount of
 * possible values that can be inserted
 * at a specific row and column.
 * 
 * @author Jeton Sinoimeri
 * 
 * @since Feb 15, 2014
 * 
 */


import java.util.ArrayList;


public class LeastNumPossValues 
{
	private static final int UNINITIALIZEDLENGTH = 10,
			                 UNINITIALIZEDINT = 10;
	
	
    private int [] position;
	
	private int size;
	
	private ArrayList<Integer> poss_values;
	
	
	/**
	 * Constructor of LeastNumPossValues object
	 * 
	 */
	
	public LeastNumPossValues()
	{
		this.size = UNINITIALIZEDLENGTH;
		
		this.poss_values = new ArrayList<Integer>();
		
		this.position = new int[2];
		
		this.position[0] = UNINITIALIZEDINT;
		this.position[1] = UNINITIALIZEDINT;
		
	}
	
	
	/**
	 * Mutator for size of least number of 
	 * possible values array
	 * 
	 * @param size  integer representing the size of the array
	 * 
	 */
	
	private void set_size(int size)
	{
		this.size = size;
	}
	
	
	/**
	 * Accessor for the size of least number of possible
	 * values array
	 * 
	 * @return integer value representing the size of the array
	 * 
	 */
	
	public int get_size()
	{
		return this.size;
	}
	
	
	/**
	 * Mutator for the position of the possible values relative
	 * to the Sudoku puzzle
	 * 
	 * @param pos  integer array of two elements containing row and column
	 * 
	 */
	
	private void set_position(int pos[])
	{
		this.position = pos;
	}
	
	
	/**
	 * Accessor for the position of the possible values relative
	 * to the Sudoku puzzle
	 * 
	 * @return an integer array of two elements containing row and column
	 * 
	 */
	
	public int[] get_position()
	{
		return this.position;
	}
	
	
	/**
	 * Mutator for the least number of values array
	 * 
	 * @param values  ArrayList of integers containing the values that can be
	 * 				  inserted into the Sudoku puzzle
	 * 
	 */
	
	private void set_values(ArrayList<Integer> values)
	{
		this.poss_values = values;
	}
	
	
	/**
	 * Accessor for the least number of values array
	 * 
	 * @return  ArrayList of integers containing the least amount of values
	 * 
	 */
	
	public ArrayList<Integer> get_values()
	{
		return this.poss_values;
	}
	
	
	/**
	 * Replaces all the current attributes of LeastNumPossValues object
	 * with the parameter fpv attributes.
	 * 
	 * @param fpv  FindPossibleValues object
	 * 
	 */
	
	public void replaced_by(FindPossibleValues fpv)
	{
		this.set_size(fpv.get_size());
		this.set_position(fpv.get_postion());
		this.set_values(fpv.get_poss_values());
	}
}
