public class Q126<T> {
	private Node<T> head;
	
	private class Node<T> {
		public T data;
		public Node<T> next;
	}

	public static void main(String[] args) {
		Q126<String> list = new Q126<String>();
		
		System.out.println("Running Append");
		list.append("A");
		list.append("B");
		list.append("C");
		list.append("D");

		list.printList();
		
		list.reverseIterative();
		
		System.out.println("Reversed list iteratively:");
		list.printList();
		
		list.head = list.reverseRecursively(list.head);
		
		System.out.println("Reversed list recursively:");
		list.printList();
	}
	
	/*
	* Reverses the list
	*/
	public void reverseIterative() {
		if (null == head || null == head.next) {
			return;
		}
		
		Node<T> cursor = head;
		Node<T> prev = null;
		while (cursor != null) {
			Node<T> temp = cursor.next;
			cursor.next = prev;
			prev = cursor;
			cursor = temp;
		}
		
		head = prev;
	}
	
	/*
	* Reverses list recursively
	* Time Complexity: O(n)
	*/
	public Node<T> reverseRecursively(Node<T> head) {
		if (null == head || null == head.next) {
			return head;
		}
		//A->B->C  //Below comments are to depict the values on each iteration for given linked list
		
		Node<T> newHeadNode = this.reverseRecursively(head.next); //C   //C   //C
		
		head.next.next = head; //C->B   //B->A
		head.next = null; //B->null    //A-> null
		
		return newHeadNode; //C    //C    //C
	}
	
	/*
	* Appends to the end of list
	* Time complixity: O(n)
	*/
	public void append(T data) {
		Node<T> newNode = createNode(data);
		
		// Add new node to head if head is empty
		if (null == head) {
			head = newNode;
			return;
		}
		
		Node<T> ptr = head;
		while(null != ptr.next) {
			ptr = ptr.next;
		}
		
		ptr.next = newNode;
	}
	
	/*
	* Creates new node with given value and returns it
	* Time complixity: O(1)
	*/
	private Node<T> createNode(T value) {
		Node<T> node = new Node<T>();
		node.data = value;
		return node;
	}
	
	/*
	* Prints List (and reverse list for understanding purpose)
	* Time complixity: O(n)
	*/
	public void printList() {
		Node<T> cursor = this.head;
		if (null == cursor) {
			System.out.println("Empty List");
			return;
		}
		
		while(null != cursor) {
			System.out.print(cursor.data + "  ");
			cursor = cursor.next;
		}
		
		System.out.println();
	}
}