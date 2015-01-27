/**
 * Sysc 2100
 * Assignment 1: Recursion ChangeMain
 * 
 * @author Jeton Sinoimeri
 * @since Jan 14, 2014
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;


public class ChangeMain 
{
	public static void main (String args [])
	{
		Scanner input = new Scanner(System.in); 				// creates an instance of scanner class with parameter System.in
		
		boolean quit = false;
		
		
		while (!quit)
		{
			System.out.println("\nEnter an amount in cents. If the amount is not an int program will terminate: ");	
			
			try
			{
				int amount = input.nextInt();				// assigns the value of user input. If exception thrown then
															// it will go to catch statement
				
				if (amount < 0) 
				{ 
					System.out.printf("Number of ways that %d cents can be changed into coins " +
							  		  "[Quarters, Dimes, Nickles and Pennies] is %d.\n", amount, 0
							 		 );
				}
				
				else
				{
					Change change = new Change(amount);				// creates instance of Change class
					
					System.out.printf("Number of ways that %d cents can be changed into coins " +
									  "[Quarters, Dimes, Nickles and Pennies] is %d.\n", 
									  change.get_amount(), change.get_counter()
									 );
				}
			}
			
			catch (InputMismatchException e) { quit = true; } // if exception thrown then program terminates

		}
		
		input.close();											// closes the instance of scanner class		
	}
}