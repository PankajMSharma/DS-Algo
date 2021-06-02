public class SinglyLinkedList<T> {
	private Node head;
	
	public class Node<T> {
		public T data;
		public Node next;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.printList(list);
		
		list.append(list, "A");
		list.append(list, "B");
		list.append(list, "C");

		list.printList(list);
	}
	
	public void append(SinglyLinkedList list, T data) {
		if (null == list.head) {
			head = createNode(data);
			return;
		}

		Node cursor = list.head;
		while(null != cursor.next) {
			cursor = cursor.next;
		}
		
		cursor.next = createNode(data);
	}

	public Node createNode(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;
		
		return node;
	}
	
	public void printList(SinglyLinkedList list) {
		Node cursor = list.head;
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