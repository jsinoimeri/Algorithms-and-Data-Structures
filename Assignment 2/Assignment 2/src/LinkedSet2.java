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




public class LinkedSet2<T> implements SetInterface <T> 
{
	
	private static final int MAX_SIZE = Integer.MAX_VALUE; // max value of an integer
	
	private Node<T> set;
	private int size;
	
	
	public LinkedSet2()
	{
		this.set = new Node<T>(null);
		this.size = 0;
	}
	
	
	public boolean add(T newEntry) 
	{
		if (this.size == 0)
		{
			this.set.setData(newEntry);
			this.size++;
			return true;
		}
		
		else if (!this.contains(newEntry)) 
		{ 
			Node<T> temp = new Node <T>(newEntry);
			
			Node<T> next = this.set;
			
			while (next.getNext() != null)
				next = next.getNext();
				
			next.setNext(temp);
			
			this.size++;
			
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
		
		Node <T> next = this.set;
		Node <T> prev = next;
		
		for (int i = 0; i < this.getCurrentSize(); i++)
		{
			prev = next;
			next = next.getNext();
		}
		
		prev.setNext(null);
		
		return next.getData();
	}


	public void clear() 
	{
		this.set.setData(null);
		this.set.setNext(null);
		this.size = 0;
	}


	public boolean contains(T anEntry) 
	{
		Node<T> next = this.set;
		
		while (next.getNext() != null)
		{
			if (next.getData().equals(anEntry)) { return true; }
			
			next = next.getNext();
		}

		
		return false;
	}


	public int getCurrentSize() 
	{
		return this.size;
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
		SetInterface<T> union = new LinkedSet2<T>();
		
		for (T element: this.toArray())
			union.add(element);
		
		for (T element: anotherSet.toArray())
			union.add(element);
		
		return union;
	}


	public SetInterface<T> intersection(SetInterface<T> anotherSet) 
	{
		SetInterface<T> intersect = new LinkedSet2<T>();
		
		for (T element: this.toArray())
		{
			if (anotherSet.contains(element)) { intersect.add(element); }
		}
		
		return intersect;
	}


	public SetInterface<T> difference(SetInterface<T> anotherSet) 
	{
		SetInterface<T> intersect = this.intersection(anotherSet),
						difference = new LinkedSet2<T>();
		
		for (T element: intersect.toArray())
		{
			if (!anotherSet.contains(element)) { difference.add(element); }
		}
		
		return difference;
	}
	

}
