public class SinglyLinkedList<T> {
	private Node head;
	
	public class Node<T> {
		public T data;
		public Node next;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.printList();
		
		list.append("A");
		list.append("B");
		list.append("C");

		list.printList();
	}
	
	/*
	* Appends to the end of list
	*/
	public void append(T data) {
		Node cursor = this.head;
		if (null == cursor) {
			this.head = createNode(data);
			return;
		}

		while(null != cursor.next) {
			cursor = cursor.next;
		}
		
		cursor.next = createNode(data);
	}
	
	/*
	* Create New Node with given data
	*/
	public Node createNode(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;
		
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