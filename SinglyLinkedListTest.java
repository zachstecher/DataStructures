
public class SinglyLinkedListTest 
{
	//----------Nested Node Class------------
	public static class Node
	{
		private int element;
		private Node next;
		public Node(int e, Node n)
		{
			element = e;
			next = n;
		}
		public int getElement()
		{
			return element;
		}
		public Node getNext()
		{
			return next;
		}
		public void setNext(Node n)
		{
			next = n;
		}
	}
	//---------End of nested node class------------
	
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public int first() throws IllegalArgumentException
	{
		if (isEmpty())
		{
			throw new IllegalArgumentException("Nothing in the list");
		}
		return head.getElement();
	}
	public int last()
	{
		if (isEmpty())
		{
			return 0;
		}
		return tail.getElement();
	}
	public void addFirst(int e)
	{
		head = new Node(e, head);
		if (size == 0)
		{
			tail = head;
		}
		size++;
	}
	public void addLast(int e)
	{
		Node newest = new Node(e, null);
		if (isEmpty())
		{
			tail = newest;
		}
		else
		{
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	public int removeFirst() throws IllegalArgumentException
	{
		if (isEmpty())
		{
			throw new IllegalArgumentException("Nothing in the list");
		}
		int answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
		{
			tail = null;
		}
		return answer;
	}
	public void printAll()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.println(temp.getElement());
			temp = temp.getNext();
		}
	}
}
