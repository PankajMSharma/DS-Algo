public class Q128And129And130<T> {
	private Node<T> head;
	
	public class Node<T> {
		public T data;
		public Node<T> next;
	}
	
	public static void main(String[] args) {
		Q128And129And130<String> list = new Q128And129And130<String>();
		list.printList();
		
		System.out.println("Running Append");
		list.append("A", null);
		list.append("B", null);
		Q128And129And130<String>.Node<String> joinNode = list.append("C", null);
		list.append("D", joinNode);

		//list.printList();
		
		boolean loopExists = list.doesLoopExists();
		System.out.println(loopExists ? "Loop exists": "No loop found");
		
		if (loopExists) {
			Q128And129And130<String>.Node<String> intersection = list.getLoopIntersection();
			System.out.println("Intersection present at: " + intersection.data);
		}
	}
	
	/*
	* Checks loop's existence using Huffman Loop Detection Technique
	* (Considers that single node is not circular. Null is circular)
	*/
	public boolean doesLoopExists() {
		if (head == null) {
			return true;
		}
		
		Node<T> fastPtr = head;
		Node<T> slowPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (fastPtr == slowPtr) { // checks after pointer increment because initially fastPtr == slowPtr
				return true;
			}
		}
		
		return false;
	}
	
	
	/*
	* Finds the intersection of loop.
	* Would return null if no intersection found
	*/
	
	public Node<T> getLoopIntersection() {
		if (null == head || null == head.next) {
			return head;
		}
		
		Node<T> fastPtr = head;
		Node<T> slowPtr = head;
		
		while(fastPtr != null && null != fastPtr.next) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if (fastPtr == slowPtr) {
				break;
			}
		}
		
		if (fastPtr != slowPtr) {
			return null;
		}
		
		slowPtr = head; // Distance required for fastPtr and slowPtr to reach intersection would now be same if both move at same speed.
		while(fastPtr != slowPtr) {
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}
		
		return fastPtr;
	}
	
	/*
	* Appends to the end of list
	*/
	public Node<T> append(T data, Node<T> nextNode) {
		Node<T> newNode = createNode(data, nextNode);
		
		// Add new node to head if head is empty
		if (null == head) {
			head = newNode;
			return newNode;
		}
		
		Node<T> ptr = head;
		while(null != ptr.next) {
			ptr = ptr.next;
		}
		
		ptr.next = newNode;
		return newNode;
	}
	
	/*
	* Creates new node with given value and returns it
	*/
	private Node<T> createNode(T value, Node<T> nextNode) {
		Node<T> node = new Node<T>();
		node.data = value;
		node.next = nextNode;
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