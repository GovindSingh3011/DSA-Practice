package linkedList.circular;

import linkedList.doubly.IntegerDoublyLinkedList;
import linkedList.doubly.DoublyNode;

public class IntegerCircularLinkedList extends IntegerDoublyLinkedList {

	// make doubly list into circular list
	public void makeCircular() {
		if (head != null) {
			tail.next = head;
			head.previous = tail;
		}
	}

	// for add node in list
	@Override
	public void add(int data) {
		super.add(data);
		makeCircular();
	}

	// for remove data from list
	@Override
	public int remove(int data) {
		int removed = super.remove(data);
		makeCircular();
		return removed;
	}

	// for print list
	@Override
	public void print() {
		DoublyNode currentNode = head;
		if (currentNode != null) {
			do {
				System.out.print(currentNode);
				currentNode = currentNode.next;
			} while (currentNode != head);
		}
	}
	// for search list
	@Override
	public DoublyNode search(int data) {
		DoublyNode currentNode = head;
		if (currentNode != null) {
			do {
				if (currentNode.data == data) {
					return currentNode;
				}
				currentNode = currentNode.next;
			} while (currentNode != head);
		}
		return null;
	}
}
