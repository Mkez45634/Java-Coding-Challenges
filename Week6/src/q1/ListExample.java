package q1;
import java.util.*;
public class ListExample {
	public static void main(String args[]) {
		//see comments at the bottom
		System.out.println(myList());
		System.out.println("2: " + myList().get(2));
		System.out.println("0: " + myList().get(0));


		System.out.println(myLinkedList());
		System.out.println(myLinkedListRemoved());
	}

	public static List<String> myList() {
		List<String> list = new ArrayList<String>();
		list.add("Bernadine");
		list.add("Elizabeth");
		list.add("Gene");
		list.add("Elizabeth");
		list.add("Clara");
		return list;
	}

	public static LinkedList<String> myLinkedList() {
		LinkedList<String> queue = new LinkedList<String>();
		queue.addFirst("Bernadine");
		queue.addFirst("Elizabeth");
		queue.addFirst("Gene");
		queue.addFirst("Elizabeth");
		queue.addFirst("Clara");
		return queue;
	}

	public static LinkedList<String> myLinkedListRemoved() {
		LinkedList<String> myQueue = new LinkedList<String>();
		myQueue = myLinkedList();
		myQueue.removeLast();
		myQueue.removeLast();
		return myQueue;
	}
}

/*

An ArrayList is an array with a dynamic size. When you add or remove an object from the array it makes a new array of the required size and moves the objects from the old one to the new one.
LinkedList is a doubly linked list. Each object has a pointer to the previous object and the next one. When you remove an object, it alters the pointers of the objects either side of the removed one to point to one another.  

*/