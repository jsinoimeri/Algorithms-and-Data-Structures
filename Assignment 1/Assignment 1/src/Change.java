/**
 * Sysc 2100
 * Assignment 1: Recursion Change
 * 
 * @author Jeton Sinoimeri
 * @since Jan 14, 2014
 *
 */

public class Change 
{
	// Constants
	private static final int PENNY = 1,
							 NICKEL = 5,
							 DIME = 10,
							 QUARTER = 25;
		
	private static final int [] COINS = { QUARTER, DIME, NICKEL, PENNY };
		
		
	// fields
	private int amount,
				counter;
		
		
	/**
	 * Constructor of Change
	 * 
	 * @param amount  integer amount
	 * 
	 */
		
	public Change(int amount)
	{
		int index = 0;
		
		this.set_counter(0);
		this.set_amount(amount);
			
			
		this.calculate_amount(this.get_amount(), COINS, index);	// call to recursive method
	}

	
	/**
	 * Mutator for the amount
	 * 
	 * @param amount  integer amount
	 * 
	 */
		
	private void set_amount(int amount)
	{
		this.amount = amount;
	}
		
		
	/**
	 * Gets the amount value
	 * 
	 * @return 	integer
	 * 
	 */
		
	public int get_amount()
	{
		return this.amount;
	}
	
	
	/**
	 * Mutator for the counter
	 * 
	 * @param counter  integer
	 * 
	 */
	
	private void set_counter(int counter)
	{
		this.counter = counter;
	}
	
	
	/**
	 * Gets the counter value
	 * 
	 * @return  integer
	 * 
	 */
		
	public int get_counter()
	{
		return this.counter;
	}

		
		
	/**
	 * Recursive method finds all the combinations of amount in cents that
	 * can be changed into different denominations without repetitions.
	 * 
	 * @param amount 	 integer amount
	 * @param int_array	 an array of integers
	 * @param index	 	 the index of the element to start with
	 *
	 */
		
	private void calculate_amount(int amount, int int_coin_values [], int index)
	{
		
		// base case
		if (amount == 0) 
		{ 
			this.counter ++;
			return; 
		}
			
			
		for (int i = index; i < int_coin_values.length; i++)
		{
			int amount2 = amount  - int_coin_values[i];
			
			if (amount2 >= 0) { this.calculate_amount(amount2, int_coin_values, i); }  // recursive call
		}
	}
}
