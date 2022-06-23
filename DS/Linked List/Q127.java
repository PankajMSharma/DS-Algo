/*
* Reverse list in pair of K nodes
*/

public class Q127<T> {
	private Node<T> head;
	
	public class Node<T> {
		public T data;
		public Node<T> next;
	}
	
	public static void main(String[] args) {
		Q127<String> list = new Q127<String>();
		list.printList();
		
		System.out.println("Running Append");
		list.append("A");
		list.append("B");
		list.append("C");
		list.append("D");
		list.append("E");

		list.printList();
		
		System.out.println("Reversed Linked List");
		list.head = list.reverse(2, list.head);
		list.printList();
	}
	
	/*
	* Reverse list in pair of K nodes
	* Time complexity: O(n) // each node is visited only one time
	* Space complexity: O(n) because N/k recursive calls would be made and each recursion would save some space. So, in total N/k constant space would be required.
	*/
	public Node<T> reverse(int k, Node<T> head) { // each time head would be start of the pair
		if (null == head || null == head.next) {
			return head;
		}
		
		// 1. Reverse k nods by iteration
		Node<T> cursor = head;
		Node<T> prev = null;
		Node<T> nextNode = null;
		int itr = 0;
		
		while(cursor != null && itr < k) {
			nextNode = cursor.next;
			cursor.next = prev;
			prev = cursor;
			cursor = nextNode;
			++itr;
		}
		
		// 2. Recursively call this method for all k pairs
		if (nextNode != null) {
			head.next = reverse(k, nextNode); //head.next would point to next pair, nextNode would specify where to start in next recursion call
		}
		
		return prev;
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