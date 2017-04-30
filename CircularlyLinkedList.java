
public class CircularlyLinkedList<E> 
{
	private static class Node<E>
	{
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n)
		{
			element = e;
			next = n;
		}
		public E getElement()
		{
			return element;
		}
		public Node<E> getNext()
		{
			return next;
		}
		public void setNext(Node<E> n)
		{
			next = n;
		}
	}
	
	private Node<E> tail = null;					// we store tail(but not head)
	private int size = 0;							// number of nodes in the list
	public CircularlyLinkedList() {}				// construct an initial empty list
	
	// access methods
	
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public E first()								// returns(but does not remove) the first element
	{
		if (isEmpty())
		{
			return null;
		}
		return tail.getNext().getElement();			// the "head" is *after* the tail
	}
	public E last()									// returns(but does not remove) the last element
	{
		if (isEmpty())
		{
			return null;
		}
		return tail.getElement();
	}
	public void rotate()							// rotate the first element to the back of the list
	{
		if (tail != null)							// if empty, do nothing
		{
			tail = tail.getNext();					// the old head becomes the new tail
		}											// I.E. Circularly Linked Lists rotate "in reverse"
	}
	
	public void addFirst(E e)						// adds a new element to the front of the list
	{
		if (isEmpty())
		{
			tail = new Node<E>(e, null);			// if empty, create a new tail and link to itself circularly
			tail.setNext(tail);
		}
		else
		{
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}
	public void addLast(E e)						// adds element to the end of the list
	{
		addFirst(e);								// insert new element at the front of the list
		rotate();									// now new element becomes the tail
	}
	public E removeFirst()							// removes and returns the first element
	{
		if(isEmpty())
		{
			return null;							// nothing to remove
		}
		Node<E> head = tail.getNext();				// finds the "head"(*after* the tail)
		if (head == tail)
		{
			tail = null;							// must be the only node left
		}
		else
		{
			tail.setNext(head.getNext());			// removes "head" from the list
		}
		size--;
		return head.getElement();
	}
}
