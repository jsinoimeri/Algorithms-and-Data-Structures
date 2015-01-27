/**
 * A linked set that implements SetInterface
 * using linked lists
 * 
 * @author Jeton Sinoimeri
 * 
 * @since Feb 1, 2014
 * 
 */


import java.lang.reflect.Array;
import java.util.LinkedList;


public class LinkedSet<T> implements SetInterface <T> 
{
	
	private static final int MAX_SIZE = Integer.MAX_VALUE; // max value of an integer
	
	private LinkedList<T> set;
	
	
	public LinkedSet()
	{
		this.set = new LinkedList<T>();
	}
	
	
	public boolean add(T newEntry) 
	{
		if (!this.contains(newEntry)) 
		{ 
			this.set.add(newEntry);
			return true;
		}
		
		return false;
	}

	
	public boolean remove(T anEntry) 
	{
		if (this.contains(anEntry))
		{
			this.set.remove(anEntry);
			return true;
		}
		
		return false;
	}


	public T remove()
	{
		if (this.set == null) { return null; }
		
		return this.set.remove(0);
	}


	public void clear() 
	{
		this.set.clear();
	}


	public boolean contains(T anEntry) 
	{
		for (T e: this.set)
		{
			if (e.equals(anEntry)) { return true; }
		}
		
		return false;
	}


	public int getCurrentSize() 
	{
		return this.set.size();
	}


	public boolean isEmpty() 
	{
		return this.set.isEmpty();
	}


	public boolean isFull() 
	{
		return this.getCurrentSize() == MAX_SIZE;
	}


	@SuppressWarnings("unchecked")
	public T[] toArray() 
	{
		
		if (this.getCurrentSize() == 0) { return null; }
		
		T[] tArray = (T[]) Array.newInstance(this.set.get(0).getClass(), this.getCurrentSize());
		
		for (int i = 0; i < this.getCurrentSize(); i++)
			tArray[i] = (T) this.set.get(i);

		return tArray;
	}


	public SetInterface<T> union(SetInterface<T> anotherSet) 
	{
		SetInterface<T> union = new LinkedSet<T>();
		
		for (T element: this.toArray())
			union.add(element);
		
		for (T element: anotherSet.toArray())
			union.add(element);
		
		return union;
	}


	public SetInterface<T> intersection(SetInterface<T> anotherSet) 
	{
		SetInterface<T> intersect = new LinkedSet<T>();
		
		for (T element: this.toArray())
		{
			if (anotherSet.contains(element)) { intersect.add(element); }
		}
		
		return intersect;
	}


	public SetInterface<T> difference(SetInterface<T> anotherSet) 
	{
		SetInterface<T> intersect = this.intersection(anotherSet),
						difference = new LinkedSet<T>();
		
		for (T element: intersect.toArray())
		{
			if (!anotherSet.contains(element)) { difference.add(element); }
		}
		
		return difference;
	}
	

}
