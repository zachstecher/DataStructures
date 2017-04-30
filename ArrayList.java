import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Cloneable
{
	
	public static void main(String[] args) throws CloneNotSupportedException
	{
		ArrayList<Integer> test = new ArrayList<Integer>(3);
		
		test.add(0, 2);
		test.add(0, 3);
		test.add(0, 2);
		System.out.println(test.size());
		test.add(0, 1);
		test.add(0, 12);
		System.out.println(test.size());
		
		
		// Modification to implement clone()
		ArrayList<Integer> test2=(ArrayList<Integer>)test.clone();
		
		if (test.contains(12)) 
		{ 
			System.out.println("The element was found.");
		}
		else
		{
			System.out.println("The element was not found.");
		}
		if (test2.contains(5)) 
		{ 
			System.out.println("The element was found.");
		}
		else
		{
			System.out.println("The element was not found.");
		}
	}
	
	private class ArrayIterator implements Iterator<E>
	{
		private int j = 0;
		private boolean removable = false;
		
		public boolean hasNext() {return j < size;}
		
		public E next() throws NoSuchElementException
		{
			if (j == size)
			{
				throw new NoSuchElementException("No next element");
			}
			removable = true;
			return data[j++];
		}
		public void remove() throws IllegalStateException
		{
			if (!removable) throw new IllegalStateException("nothing to remove");
		ArrayList.this.remove(j-1);
		j--;
		removable = false;
		}
	}
	
	public Iterator<E> iterator()
	{
		return new ArrayIterator();
	}
	
	public static final int CAPACITY = 16;				// default array capacity
	private E[] data;									// generic array used for storage
	private int size = 0;								// current number of elements
	
	// constructors
	
	public ArrayList() {this(CAPACITY);}				// constructs list with default capacity
	public ArrayList(int capacity)						// constructs list with given capacity
	{
		data = (E[]) new Object[capacity];
	}
	
	// public methods
	
	public int size() {return size;}					// returns the number of elements in the array list
	public boolean isEmpty() {return size == 0;}		// returns whether the array list is empty
	public E get(int i) throws IndexOutOfBoundsException// returns(but does not remove) the element at index i
	{
		checkIndex(i, size);
		return data[i];
	}
														// replaces the element at index i with e, and returns
														// the replaced element
	public E set(int i, E e) throws IndexOutOfBoundsException
	{
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	
	//Inserts element e to be at index i, shifting all subsequent elements later
	public void add(int i, E e) throws IndexOutOfBoundsException
	{
		checkIndex(i, size+1);
		if (size == data.length)
		{
			E[] temp = (E[]) new Object[2*data.length];
			for(int k=0; k < size; k++)
			{
				if (k >= i)											// if we're beyond the entry location, copy one space over
				{
					temp[k+1] = data[k];
				}
				else
				{
					temp[k] = data[k];								// start using new array
				}
			}
			data = temp;
		}
		for (int k = size-1; k >= i; k--)
		{
			data[k+1] = data[k];
		}
		data[i] = e;
		size++;
	}
	
	// removes and returns the element at index i, shifting subsequent elements earlier
	public E remove(int i) throws IndexOutOfBoundsException
	{
		checkIndex(i, size);
		E temp = data[i];
		for(int k=i; k < size; k++)							// shift elements to fill hole
		{
			data[k] = data[k+1];
		}
		data[size-1] = null;								// help garbage collection
		size--;
		return temp;
	}
	
	// utility methods
	
	// checks whether the given index is in the range[0, n-1]
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException
	{
		if (i < 0 || i >= n)
		{
			throw new IndexOutOfBoundsException("Illegal index: " + i);
		}
	}
	
	// resizes internal array to have given capacity >= size
	protected void resize(int capacity)
	{
		E[] temp = (E[]) new Object[capacity];
		for(int k=0; k < size; k++)
		{
			temp[k] = data[k];								// start using new array
		}
		data = temp;
	}
	public boolean contains(Object o)
	{
		for (int i = 0; i < size; i++)
		{
			if (o == data[i])
			{
				return true;
			}
		}
		return false;
	}
	
	// Modification to implement clone()
	public Object clone() throws CloneNotSupportedException 
	{
		return super.clone(); 
	}
}
