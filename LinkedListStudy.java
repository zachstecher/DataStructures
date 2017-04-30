
public class LinkedListStudy 
{
	public static void main(String[] args)
	{
		SinglyLinkedList<Integer> study = new SinglyLinkedList<Integer>();
		CircularlyLinkedList<String> study1 = new CircularlyLinkedList<String>();
		DoublyLinkedList<String> study2 = new DoublyLinkedList<String>();
		SinglyLinkedListTest study3 = new SinglyLinkedListTest();
		
	// Test area for SinglyLinkedList
		study.addFirst(5);
		study.addFirst(12);
		study.addLast(7);
		study.addLast(8);
		study.addFirst(10);
		
		study.secondToLast();
		study.printAll();
		study.rotate();
		study.secondToLast();
		study.printAll();
	// End test area for SinglyLinkedList
		
	// Test area for CircularlyLinkedList
		study1.addFirst("Why");
		study1.addFirst("I don't");
		study1.addFirst("Even");
		study1.addFirst("Know");
		study1.addFirst("What");
		study1.addFirst("To");
		study1.addFirst("Say");
	// End test area for CircularlyLinkedList
		
	// Test area for SinglyLinkedListTest
		study3.addFirst(5);
		study3.addFirst(2);
		study3.addLast(13);
		study3.addLast(8);
		study3.addFirst(15);
		study3.addFirst(6);
		study3.printAll();
	// End test area for SinglyLinkedListTest
		
	}
}
