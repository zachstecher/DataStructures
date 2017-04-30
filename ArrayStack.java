
public class ArrayStack<E> implements Stack<E>
{
	public static final int CAPACITY = 1000;		// default capacity
	private E[] data;
	private int t = -1;
	public ArrayStack() {this(CAPACITY);}
	public ArrayStack(int capacity)
	{
		data = (E[]) new Object[capacity];
	}
	public int size() {return t+1;}
	public boolean isEmpty() {return t == -1;}
	public void push(E e) throws IllegalArgumentException
	{
		if (size() == data.length)
		{
			throw new IllegalArgumentException("Stack is full");
		}
		data[++t] = e;
	}
	public E top()
	{
		if (isEmpty()) {return null;}
		return data[t];
	}
	public E pop()
	{
		if(isEmpty()) {return null;}
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
	public void printAll(ArrayStack<E> e)
	{
		if (!isEmpty())
		{
			System.out.println(e.pop());
			e.printAll(e);
		}
	}
	public void transfer(ArrayStack<E> e)
	{
		ArrayStack<E> temp1 = new ArrayStack<E>();
		ArrayStack<E> temp2 = new ArrayStack<E>();
		int size = e.size();
		for (int i = 0; i < size; i++)
		{
			temp1.push(e.pop());
		}
		for (int j = 0; j < size; j++)
		{
			temp2.push(temp1.pop());
		}
		for (int k = 0; k < size; k++)
		{
			e.push(temp2.pop());
		}
	}
}
