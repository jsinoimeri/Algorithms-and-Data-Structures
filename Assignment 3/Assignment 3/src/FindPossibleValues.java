/**
 * Finds all the possible values that
 * can be inserted at a specific row
 * and column.
 * 
 * @author Jeton Sinoimeri
 * 
 * @since Feb 15, 2014
 * 
 */


import java.util.ArrayList;


public class FindPossibleValues 
{
	private static final int VALUES [] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	private static final int ROW = 9,
							 COL = 9,
							 UNINITIALIZED = 0;
	
	
	private int [] position;
	
	private int size;
	
	private ArrayList<Integer> poss_values;
	
	
	/**
	 * Constructor for the FindPossibleValues object
	 * 
	 * @param board  Board object representing the Sudoku board
	 * @param row    integer value representing the row number
	 * @param col    integer value representing the column number
	 * 
	 */
	
	public FindPossibleValues(Board board, int row, int col)
	{
		this.position = new int[2];
		
		this.position[0] = row;
		this.position[1] = col;
		
		this.poss_values = new ArrayList<Integer>();
		this.size = 0;
		
		
		// Add values to poss_values array
		for (int i: VALUES)
			this.poss_values.add(i);
		
		
		// get all the possible values
		this.possible_values(board, row, col);
	}
	
	
	/**
	 * Finds all the possible values at a specific row and column number
	 * that can be inserted at that position on the Sudoku board
	 * 
	 * @param board  Board object representing the Sudoku board
	 * @param row    integer value representing the row number
	 * @param col    integer value representing the column number
	 * 
	 */
	
	private void possible_values(Board board, int row, int col)
	{
		// Eliminates all non-zero values that are on the board
		// from the array by keeping the row number constant 
		// and changing the column number
		
		for (int j = 0; j < COL; j++)
		{
			if (board.get_value(row, j) != UNINITIALIZED)
				this.poss_values.set(board.get_value(row, j) - 1, UNINITIALIZED);
		}
		
		
		// Eliminates all non-zero values that are on the board
		// from the array by keeping the column number constant
		// and changing the row number
		
		for (int i = 0; i < ROW; i++)
		{
			if (board.get_value(i, col) != UNINITIALIZED)
			{
				this.poss_values.set(board.get_value(i, col) - 1, UNINITIALIZED);
			}
		}
		
		
		// Calculate the start of the corresponding 3x3 matrix
		// which holds that particular row and column 
		
		int start_row = (row / 3) * 3;
		int start_col = (col / 3) * 3;
		
		
		// Calculate the end of the corresponding 3x3 matrix
		// which holds that particular row and column
		
		int end_row = start_row + 3;
		int end_col = start_col + 3;
		
		
		// Eliminate all non-zero values that are inside the 3x3
		// matrix from the array
		
		for (int i = start_row; i < end_row; i++)
		{
			for (int j = start_col; j < end_col; j++)
				if (board.get_value(i, j) != UNINITIALIZED)
					this.poss_values.set(board.get_value(i, j) - 1, UNINITIALIZED);
		}
		
		
		// assign length field the size of array
		for (int val: this.poss_values)
		{
			if (val != UNINITIALIZED) { this.size ++; }
		}
	}
	
	
	/**
	 * Accessor for the size of the possible values array.
	 * 
	 * @return  integer value representing the length of array
	 * 
	 */
	
	public int get_size()
	{
		return this.size;
	}
	
	
	/**
	 * Accessor of the position where each possible value can be
	 * inserted.
	 * 
	 * @return  an integer array of two elements [row, column]
	 * 
	 */
	
	public int[] get_postion()
	{
		return this.position;
	}
	
	
	/**
	 * Accessor for the possible values array
	 * 
	 * @return  an ArrayList object containing all the possible
	 * 			values that can be inserted at a specific location
	 * 
	 */
	
	public ArrayList<Integer> get_poss_values()
	{
		return this.poss_values;
	}

}
