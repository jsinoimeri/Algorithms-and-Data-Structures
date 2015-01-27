/**
 * Solving Sudoku puzzles recursively
 * with backtracking.
 * 
 * @author Jeton Sinoimeri
 * 
 * @since Feb 15, 2014
 * 
 */


public class Sudoku 
{
	private static final int ROW = 9,
							 COL = 9,
							 UNINITIALIZEDLENGTH = 10,
							 UNINITIALIZED = 0;
		
	
	private Board board,
				  solution_board;
	
	private int num_solution;
	
	
	/**
	 * Constructor for the Sudoku class
	 * 
	 */
	
	public Sudoku()
	{	
		this.solution_board = null;
		
		this.board = new Board();
		
		this.set_solution(0);
		
		this.values(this.get_board());
	}
	
	
	/**
	 * Accessor for the Board object containg the Sudoku puzzle
	 * 
	 * @return  Board object containing the Sudoku puzzle
	 * 
	 */
	
	private Board get_board()
	{
		return this.board;
	}
	
	
	/**
	 * Mutator for the number of solution found
	 * 
	 * @param num  integer value to set the number of solution found
	 * 
	 */
	
	private void set_solution(int num)
	{
		this.num_solution = num;
	}
	
	
	/**
	 * Mutator for the number of solutions found by adding
	 * the parameter to the number of solutions already found
	 * 
	 * @param num  integer value which will be added to 
	 * 			   number of solutions found
	 * 
	 */
	
	private void add_solution(int num)
	{
		this.num_solution += num;
	}
	
	
	/**
	 * Accessor for the total number of solutions found for 
	 * particular Sudoku puzzle.
	 * 
	 * @return  integer value representing the total number of
	 * 			solution found for particular Sudoku puzzle
	 * 
	 */
	
	private int get_solution()
	{
		return this.num_solution;
	}
	
	
	/**
	 * Finds the least amounts of values and calls the recursive method
	 * to solve the puzzle.
	 * 
	 * @param game  Board object containing the Sudoku puzzle
	 * 
	 */
	
	private void values(Board game)
	{
		FindPossibleValues fpv;
		
		LeastNumPossValues lnpv = new LeastNumPossValues();
		
		
		// Finds the least amount of possible values for the puzzle
		// by looping through the entire puzzle and comparing previous
		// results to current ones
		
		for (int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				if (game.get_value(i, j) == UNINITIALIZED)
				{
					fpv = new FindPossibleValues(game, i, j);
					
					if(fpv.get_size() < lnpv.get_size())
					{
						lnpv.replaced_by(fpv);
					}
				}
			}
		}
		
		
		// creates new copy of the puzzle
		Board copy_game = new Board(game);
		
		
		// for each element in the least number of possible
		// values, it sets the value at the corresponding position
		// in the copy_game variable and call the recursive method
		
		for (int v: lnpv.get_values())
		{
			if (v != UNINITIALIZED)
			{
				int row = lnpv.get_position()[0];
				int col = lnpv.get_position()[1];
				
				copy_game.set_board_value(row, col, v);
				this.sudoku_solver(copy_game);
			}
			
		}
		
		
		// output statements for either no solutions found, one solution found
		// more than one solution found
		
		if (this.get_solution() == 1)
			System.out.println("\nThis puzzle has only 1 solution.");
		
		
		else if (this.get_solution() > 1)
		{
			System.out.printf("\nThis puzzle has %d different solutions.\n", this.num_solution);
			return;
		}
		
		else	
			System.out.println("\nThis puzzle has no solutions.");
		
	}
	
	
	/**
	 * Recursive method for solving the Sudoku puzzle.
	 * 
	 * @param game  Board object containing the Sudoku puzzle
	 * 
	 */
	
	private void sudoku_solver(Board game)
	{
		FindPossibleValues fpv;
		
		LeastNumPossValues lnpv = new LeastNumPossValues();
		
		
		// Finds the least amount of possible values for the puzzle
		// by looping through the entire puzzle and comparing previous
		// results to current ones
		
		for (int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				if (game.get_value(i, j) == UNINITIALIZED)
				{
					fpv = new FindPossibleValues(game, i, j);
					
					// base case 1
					if (fpv.get_size() == UNINITIALIZED) { return; }
					
					
					if(fpv.get_size() < lnpv.get_size())
					{
						lnpv.replaced_by(fpv);
					}
				}
			}
		}
		
		
		// base case 2
		if (lnpv.get_size() == UNINITIALIZEDLENGTH)
		{
			if (this.solution_board == null)
			{
				this.solution_board = game;
			}
			
			// adds one to solution
			this.add_solution(1);
			
			return;
		}

		
		// creates new copy of the puzzle
		Board copy_game = new Board(game);
		
		
		// for each element in the least number of possible
		// values, it sets the value at the corresponding position
		// in the copy_game variable and calls itself
		
		for (int v: lnpv.get_values())
		{
			if (v != UNINITIALIZED)
			{
				int row = lnpv.get_position()[0];
				int col = lnpv.get_position()[1];
				
				copy_game.set_board_value(row, col, v);
				
				this.sudoku_solver(copy_game);
			}
		}
	}
	
	
	/**
	 * Outputs the solution to the puzzle as long as one exists. 
	 * If more than one solution is found, than it will output
	 * the first solution found only.
	 * 
	 */
	
	public void print_solution_board()
	{		
		// checks if solution board is not null than outputs result
		if (this.solution_board != null)
		{
			System.out.println();
			for (int i = 0; i < ROW; i++)
			{
				String output = "";
				
				for (int j = 0; j < COL; j++)
				{
					output += this.solution_board.get_value(i, j) + " ";
				}
				
				System.out.println(output);
			}
		}
	}

	
	public static void main(String args[])
	{
		Sudoku s = new Sudoku();
		s.print_solution_board();
	}
	
}
