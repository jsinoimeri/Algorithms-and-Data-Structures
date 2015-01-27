/**
 * The Sudoku board class
 * 
 * @author Jeton Sinoimeri
 * 
 * @since Feb 15, 2014
 * 
 */


public class Board 
{
	private static final int ROW = 9,
			 				 COL = 9,
			 				 UNINITIALIZED = 0;
	
	
	private int [][] board;
	
	
	/**
	 * Default constructor of the Sudoku board.
	 * 
	 */
	
	public Board()
	{
		// read from file
		ReadInput input = new ReadInput();  
		
		
		// get all fixed numbers from file
		int [][] fixed = input.getFixedNums();  

		
		// initialize board with number of rows and columns
		this.initialize_board(ROW, COL);  
		
		
		// Set all entries of board to 0		
		for (int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				this.set_board_value(i, j, UNINITIALIZED);
			}
		}
		
		
		// Copy each value from file to the corresponding position
		for (int i = 0; i < input.size(); i++)
		{		
			this.set_board_value(fixed[i][0], fixed[i][1], fixed[i][2]);
		}
	}
	
	
	/**
	 * Constructor which copies all values of argument to
	 * a new instance of the board class.
	 * 
	 * @param original_board  Board object that will have its values copied
	 * 						  to the new Board instance
	 * 						  
	 */
	
	public Board(Board original_board)
	{
		// initialize board with number of rows and columns
		this.initialize_board(ROW, COL);
		
		
		// Copy all the values from original_board to new board
		for(int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				this.set_board_value(i, j, original_board.get_value(i, j));
			}
		}
	}
	
	
	/**
	 * Assessor for sudoku board
	 * 
	 * @return the sudoku board
	 * 
	 */
	
	public int [][] get_board()
	{
		return this.board;
	}
	
	
	/**
	 * Sets the board up
	 * 
	 * @param col  integer representing the total number of columns
	 * @param row  integer representing the total number of rows
	 * 
	 */
	
	private void initialize_board(int row, int col)
	{
		this.board = new int[row][col];
	}
	
	
	/**
	 * Assigns a value to the board at corresponding column and row
	 * 
	 * @param col  integer representing the total number of columns
	 * @param row  integer representing the total number of row
	 * @param value  integer representing the value to be assigned
	 * 
	 */
	
	public void set_board_value(int row, int col, int value)
	{
		this.board[row][col] = value;
	}
	
	
	/**
	 * Gets a specific value dictated by row and column
	 * 
	 * @param row  integer specifying the row number
	 * @param col  integer specifying the column number
	 * 
	 * @return  integer value corresponding to that row and column
	 * 
	 */
	
	public int get_value(int row, int col)
	{
		return this.board[row][col];
	}
	
}
