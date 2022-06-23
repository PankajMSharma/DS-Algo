public class SinglyLinkedList<T> {
	private Node<T> head;
	
	public class Node<T> {
		public T data;
		public Node<T> next;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
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
		int deleteIndex = 6;
		System.out.println("Deleting at index: " + deleteIndex);
		Boolean deleted = list.deleteByIndex(deleteIndex);
		
		System.out.println(deleted ? "Deleted!" : "Index " + deleteIndex + " not found in list");
		
		list.printList();
	}
	
	/*
	* Deletes matched node from list 
	*/
	public boolean deleteByIndex(int index) {
		if (null == head) {
			return false;
		}
		
		// If head neads to be deleted, just move head ahead by one pointer
		if(index == 0) {
			head = head.next;
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
		return true;
	}
	
	/*
	* Finds the argument within the list
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
	*/
	public void insertAtFront(T data) {
		Node<T> newNode = createNode(data);
		
		if (null == head) {
			head = newNode;
			return;
		}
		
		Node<T> ptr = head;
		head = newNode;
		newNode.next = ptr;
	}
	
	/*
	* Insert new node in middle
	*/
	public void insertAt(T data, int index) {
		if (index < 0) {
			System.out.println("Invalid index. Try positive index");
			return;
		}
		
		Node<T> newNode = createNode(data);
		
		if (null == head) {
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
		ptr.next = newNode;
	}
	
	/*
	* Appends to the end of list
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
	*/
	private Node<T> createNode(T value) {
		Node<T> node = new Node<T>();
		node.data = value;
		return node;
	}
	
	/*
	* Prints List
	*/
	public void printList() {
		Node cursor = this.head;
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