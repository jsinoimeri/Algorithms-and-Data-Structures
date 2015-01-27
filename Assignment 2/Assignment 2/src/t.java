


//import java.lang.reflect.Array;


public class t<T> 
{
	private Node<T> set;
	private int size;
	
	
	public t()
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
	
	public boolean contains(T anEntry) 
	{
		Node<T> next = this.set;
			
		for (int i = 0; i < this.size; i++)
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
	
	
	public static void main (String args[])
	{
		t<Integer> n = new t<>();
		
		n.add(0);
		
		n.add(1);
		
		n.add(2);
		
		n.add(3);
		
		n.add(0);
		
		n.add(1);
		
		n.add(2);
		
		n.add(3);
		
		System.out.println(n.getCurrentSize());
		
		System.out.println(n.contains(0));
		System.out.println(n.contains(1));
		System.out.println(n.contains(2));
		System.out.println(n.contains(3));
	}

}
