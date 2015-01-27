/**
 * JUnit Test for the LinkedSet
 * 
 * @author Jeton Sinoimeri
 * 
 * @since Feb 1, 2014
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestSet 
{
	
	private LinkedSet <Integer> int_set;
	private LinkedSet <String> str_set;
	
	
	@Before
	public void setUp() 
	{
		this.int_set = new LinkedSet<Integer>();
		this.str_set = new LinkedSet<String>();
	}

	
	@Test
	public void testGetCurrentSize()
	{
		assertEquals(0, this.int_set.getCurrentSize());
		assertEquals(0, this.str_set.getCurrentSize());
	}

	
	@Test
	public void testAdd() 
	{
		// Add values to the set
		assertTrue(this.int_set.add(0));
		assertTrue(this.str_set.add("a"));
		
		assertTrue(this.int_set.add(1));
		assertTrue(this.str_set.add("b"));
		
		assertTrue(this.int_set.add(2));
		assertTrue(this.str_set.add("ab"));
		
		// Check that the size has increased
		assertEquals(3, this.int_set.getCurrentSize());
		assertEquals(3, this.str_set.getCurrentSize());
		
		// Add duplicates and check for false return
		assertFalse(this.int_set.add(0));
		assertFalse(this.str_set.add("a"));
		
		assertFalse(this.int_set.add(1));
		assertFalse(this.str_set.add("b"));
		
		assertFalse(this.int_set.add(2));
		assertFalse(this.str_set.add("ab"));
		
		// Rechecks the size
		assertEquals(3, this.int_set.getCurrentSize());
		assertEquals(3, this.str_set.getCurrentSize());
	}

	
	@Test
	public void testRemoveT() 
	{
		// Add values to the set
		this.int_set.add(0);
		this.str_set.add("a");
				
		this.int_set.add(1);
		this.str_set.add("b");
				
		this.int_set.add(2);
		this.str_set.add("ab");
		
		
		// Remove values from the set
		assertTrue(this.int_set.remove(0));
		assertTrue(this.str_set.remove("b"));
		
		assertFalse(this.int_set.remove(0));
		assertFalse(this.str_set.remove("b"));
		
		
		// Rechecks the size
		assertEquals(2, this.int_set.getCurrentSize());
		assertEquals(2, this.str_set.getCurrentSize());
	}

	
	@Test
	public void testRemove() 
	{
		// Add values to the set
		this.int_set.add(0);
		this.str_set.add("a");
		
		this.int_set.add(1);
		this.str_set.add("b");
		
		this.int_set.add(2);
		this.str_set.add("c");
		
		this.int_set.add(3);
		this.str_set.add("d");
		
		this.int_set.add(4);
		this.str_set.add("e");
		
		this.int_set.add(5);
		this.str_set.add("f");
				
				
		// Remove values from the set
		assertEquals(0, (int)this.int_set.remove());
		assertEquals("a", (String)this.str_set.remove());
				
		assertEquals(1, (int)this.int_set.remove());
		assertEquals("b", (String)this.str_set.remove());
		
		assertEquals(2, (int)this.int_set.remove());
		assertEquals("c", (String)this.str_set.remove());
				
		assertEquals(3, (int)this.int_set.remove());
		assertEquals("d", (String)this.str_set.remove());
		
		// Rechecks the size
		assertEquals(2, this.int_set.getCurrentSize());
		assertEquals(2, this.str_set.getCurrentSize());
	}

	
	@Test
	public void testClear()
	{
		// Add values to the set
		this.int_set.add(0);
		this.str_set.add("a");
				
		this.int_set.add(1);
		this.str_set.add("b");
				
		this.int_set.add(2);
		this.str_set.add("c");
				
		this.int_set.add(3);
		this.str_set.add("d");
				
		this.int_set.add(4);
		this.str_set.add("e");
				
		this.int_set.add(5);
		this.str_set.add("f");
		
		// Check the size
		assertEquals(6, this.int_set.getCurrentSize());
		assertEquals(6, this.str_set.getCurrentSize());
		
		
		// Clear
		this.int_set.clear();
		this.str_set.clear();
		
		
		// Check the size
		assertEquals(0, this.int_set.getCurrentSize());
		assertEquals(0, this.str_set.getCurrentSize());
	}

	
	@Test
	public void testContains() 
	{
		// array of strings
		String [] ar = {"a", "b", "c", "d"}; 
		
		// add values to int_set
		for (int i = 0; i < 10; i++)
			this.int_set.add(i);
		
		// check if int_set contains those values
		for (int i = 0; i < this.int_set.getCurrentSize(); i++)
			assertTrue(this.int_set.contains(i));
		
		// add strings to str_set from ar
		for (int i = 0; i < ar.length; i++)
			this.str_set.add(ar[i]);
		
		// Check if str_set contains those strings
		for (String s: ar)
			assertTrue(this.str_set.contains(s));
		
		// check if both sets do not contains these values
		assertFalse(this.int_set.contains(2300));
		assertFalse(this.str_set.contains("Google"));
	}


	@Test
	public void testIsEmpty() 
	{
		// Initial state of the sets
		assertTrue(this.int_set.isEmpty());
		assertTrue(this.str_set.isEmpty());
		
		// Add values to the sets
		this.int_set.add(7);
		this.str_set.add("Google");
		
		// Check if the sets are empty
		assertFalse(this.int_set.isEmpty());
		assertFalse(this.str_set.isEmpty());
			
		// Declare to new sets
		LinkedSet <Double> double_set = new LinkedSet<Double>();
		LinkedSet <Character> char_set = new LinkedSet<Character>();
		
		// Initial state of the sets
		assertTrue(double_set.isEmpty());
		assertTrue(char_set.isEmpty());
		
		// Add values
		double_set.add(0.909090);
		char_set.add('a');
		
		// Check if the sets are empty
		assertFalse(double_set.isEmpty());
		assertFalse(char_set.isEmpty());	
	}

	
	@Test
	public void testIsFull() 
	{
		// It takes too long to iterate for 0 to Integer.MAX_VALUE
		// so this test only tests up to 100 elements. The max size
		// an integer can hold is 2^31 - 1. A set has a size of infinite.
		
		
		for (int i = 0; i < 100; i ++)
		{
			this.int_set.add(i);
			assertFalse(this.int_set.isFull());
		}		
	}

	
	@Test
	public void testToArray() 
	{
		// Declares to arrays for each set
		String [] str_ar = {"ab", "bc", "cd", "de"};
		int [] int_ar = {67, 98, 87, 66, 54};
		
		// Initializes those sets with the values in the arrays
		for (String el: str_ar )
			this.str_set.add(el);
		
		for (int el: int_ar)
			this.int_set.add(el);
		
		// Calls the toArray() method for each set
		String [] str_setArray = this.str_set.toArray();
		Integer [] int_setArray = this.int_set.toArray();
		
		// checks the values
		for (int i = 0; i < str_ar.length; i++ )
			assertEquals(str_ar[i], str_setArray[i]);
		
		for (int i = 0; i < int_ar.length; i++ )
			assertEquals(int_ar[i], (int) int_setArray[i]);
	}

	
	@Test
	public void testUnion() 
	{
		// Declares to arrays
		int [] int_ar = {67, 98, 87, 66, 54},
			   union_set = { 0, 1, 2, 3, 67, 98, 87, 66, 54};
		
		// Create new instance of integer set
		LinkedSet <Integer> set1 = new LinkedSet<Integer>();
		
		// Add values to both sets
		for (int d: int_ar)
			set1.add(d);
		
		for (int i = 0; i < 4; i++)
			this.int_set.add(i);
		
		// Create new instance of SetInterface and assign the union of int_set and set1
		SetInterface<Integer> set2 = this.int_set.union(set1);
		
		// Check the results against the union_set array
		for (int i = 0; i < set2.getCurrentSize(); i++)
			assertEquals(union_set[i], (int)set2.toArray()[i]);
	}

	
	@Test
	public void testIntersection()
	{
		// Declares to arrays
		String [] str_ar = {"AB", "AC", "MB", "Hd", ":L"},
				  str_ar2 = {"ABDS", "AC", "MB", "BNME", ":L"},
				  intersect_set = { "AC", "MB", ":L"};
				
		// Create new instance of String set
		LinkedSet <String> set1 = new LinkedSet<String>();
				
		// Add values to both sets
		for (String d: str_ar)
			set1.add(d);
				
		for (String el: str_ar2)
			this.str_set.add(el);
				
		// Create new instance of SetInterface and assign the union of str_set and set1
		SetInterface<String> set2 = this.str_set.intersection(set1);
				
		// Check the results against the intersect_set array
		for (int i = 0; i < set2.getCurrentSize(); i++)
			assertEquals(intersect_set[i], set2.toArray()[i]);
	}

	
	@Test
	public void testDifference() 
	{
		// Declares to arrays
		String [] str_ar = {"AB", "AC", "MB", "Hd", ":L"},
				  str_ar2 = {"ABDS", "AC", "MB", "BNME", ":L"},
				  difference_strSet = { "ABDS", "AB", "HD", "BNME"};
						
		// Create new instance of String set
		LinkedSet <String> set1 = new LinkedSet<String>();
						
		// Add values  sets
	    for (String d: str_ar)
			set1.add(d);
						
		for (String el: str_ar2)
			this.str_set.add(el);
						
		// Create new instance of SetInterface and assign the union of str_set and set1
		SetInterface<String> set2 = this.str_set.difference(set1);
						
		// Check the results against the intersect_set array
		for (int i = 0; i < set2.getCurrentSize(); i++)
			assertEquals(difference_strSet[i], set2.toArray()[i]);
	}
}
