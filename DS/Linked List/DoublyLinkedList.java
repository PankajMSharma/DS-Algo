/*
Insertion 
A node can be added in four ways 
1) At the front of the DLL 
2) After a given node. 
3) At the end of the DLL 
4) Before a given node.
5) Deletion at index
6) Search and get index
*/

public class DoublyLinkedList<T> {
	private Node<T> head;
	
	public class Node<T> {
		public T data;
		public Node<T> prev;
		public Node<T> next;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.printList();
		
		System.out.println("Running Append");
		list.append("A");
		list.append("B");
		list.append("C");
		list.append("D");

		list.printList();
		
		System.out.println("########## Running InsertAtFront ##########");
		list.insertAtFront("*");
		
		list.printList();
		
		System.out.println("########## Running InsertAt ##########");
		list.insertAt("Z", 0);
		
		list.printList();
		
		System.out.println("########## Running SearchText ##########");
		String searchText = "D";
		int index = list.findIndex(searchText);
		
		if (index >= 0) {
			System.out.println("\"" + searchText + "\" found at: " + index);
		} else {
			System.out.println("Couldn't find the text \"" + searchText + "\"");
		}
		
		System.out.println("########## Running Delete ##########");
		System.out.println("Original list: ");
		list.printList();

		int deleteIndex = -1;
		System.out.println("Deleting at index: " + deleteIndex);
		Boolean deleted = list.deleteByIndex(deleteIndex);
		
		System.out.println(deleted ? "Deleted!" : "Index " + deleteIndex + " not found in list");
		
		list.printList();
	}
	
	/*
	* Deletes matched node from list
	* Time complixity: O(n)
	*/
	public boolean deleteByIndex(int index) {
		if (null == head || index < 0) {
			return false;
		}
		
		// If head neads to be deleted, just move head ahead by one pointer
		if(index == 0) {
			head = head.next;
			head.prev = null;
			return true;
		}
		
		Node<T> ptr = head;
		int i = 0;
		while (i < index-1 && null != ptr) {
			ptr = ptr.next;
			++i;
		}
		
		if (null == ptr.next) {
			return false;
		}
		
		ptr.next = ptr.next.next;
		if (null != ptr.next) {
			ptr.next.prev = ptr;
		}
		return true;
	}
	
	/*
	* Finds the argument within the list
	* Time complixity: 0(n)
	*/
	public int findIndex(T data) {
		Node<T> ptr = head;
		int i = 0;
		while(null != ptr) {
			if (data.equals(ptr.data)) {
				return i;
			}
			
			ptr = ptr.next;
			++i;
		}
		
		return -1;
	}
	
	/*
	* Insert new node in begining
	* Time complixity: O(1)
	*/
	public void insertAtFront(T data) {
		Node<T> newNode = createNode(data);
		
		if (null == head) {
			head = newNode;
			return;
		}
		
		Node<T> ptr = head;
		head.prev = newNode; // changed from SLL
		head = newNode;
		newNode.next = ptr;
	}
	
	/*
	* Insert new node in middle
	* Time complixity: O(n)
	*/
	public void insertAt(T data, int index) {
		if (index < 0) {
			System.out.println("Invalid index. Try positive index");
			return;
		}
		
		Node<T> newNode = createNode(data);
		
		if (null == head) {
			head.prev = newNode; // changed from SLL
			head = newNode;
			return;
		}
		
		int i = 1; // i starts from 1 because ptr in next line would already point to first node before starting while loop
		Node<T> ptr = head;
		while(i <= index && null != ptr.next) {
			ptr = ptr.next;
			++i;
		}
		
		newNode.next = ptr.next;
		newNode.prev = ptr; // changed from SLL
		ptr.next = newNode;
		newNode.next.prev = newNode; // changed from SLL
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
		newNode.prev = ptr; // changed from SLL
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
		Node<T> reverseCursor = null;
		if (null == cursor) {
			System.out.println("Empty List");
			return;
		}
		
		System.out.println("Straight");
		while(null != cursor) {
			System.out.print(cursor.data + "  ");
			if (null != cursor.next) {
				reverseCursor = cursor.next;
			}
			cursor = cursor.next;
		}
		System.out.println("\n Reverse");
		while(null != reverseCursor) {
			System.out.print(reverseCursor.data + "  ");
			reverseCursor = reverseCursor.prev;
		}
		
		System.out.println();
	}
}