public class Q140<T> {
	private Node<T> head;
	
	private class Node<T> {
		public T data;
		public Node<T> next;
	}

	public static void main(String[] args) {
		Q140<String> list = new Q140<String>();
		
		System.out.println("Running Append");
		list.append("A");
		list.append("B");
		list.append("C");
		list.append("D");
		list.append("E");
		list.append("F");

		list.printList();
		
		String middle1 = list.findMiddle1();
		
		System.out.println("Middle 1: " + middle1);
		
		String middle2 = list.findMiddle2();
		
		System.out.println("Middle 2: " + middle2);
	}
	
	/*
	* Reverses the list (using length of list)
	*/
	public T findMiddle1() {
		int length = this.length();
		int middleIdx = length / 2; //for both odd and even length

		int itr = 0;
		Node<T> ptr = head;
		while(itr < middleIdx) {
			ptr = ptr.next;
			++itr;
		}
		
		return ptr.data;
	}
	
	/*
	* Reverses the list (Using 2 pointer approach)
	*/
	public T findMiddle2() {
		if(null == head) {
			return null;
		}
		
		if (null == head.next) {
			return head.data;
		}
		
		Node<T> ptrFast = head;
		Node<T> ptrSlow = head;
		//A->B->C->
		
		while(ptrFast != null && ptrFast.next != null) { //before: A, A after: A, B // before: A, B  after: B, C
			ptrSlow = ptrSlow.next;
			ptrFast = ptrFast.next.next;
		}
		
		return ptrSlow.data;
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
	* Returns length of list
	*/
	public int length() {
		if (null == head) {
			return 0;
		}
		
		int length = 0;
		Node<T> ptr = head;
		while(ptr != null) {
			ptr = ptr.next;
			++length;
		}
		
		return length;
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