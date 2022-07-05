// Approach 1: Copy to array and check if the array is palindrome
// Approach 2: Reverse second half of list. Check iteratively if first half and second half is similar
// Here we used only approach 2

public class Q143 {
	private Node head;
	
	public class Node {
		public int data;
		public Node next;
	}
	
	public static void main(String[] args) {
		System.out.println("Creating sorted list1:");
		Q143 list = new Q143();
		list.append(1, null);
		list.append(2, null);
		list.append(3, null);
		//list.append(3, null);
		list.append(2, null);
		list.append(1, null);
		//list.append(1, null);

		list.printList();
		
		boolean isPalindrome = list.isPalindrome();
		System.out.println("List is " + (isPalindrome ? "" : "not ")+ "a palindrome");
		
		System.out.println("Original list:");
		list.printList();
	}
	
	/*
	* Reverse second half and then compare first and second halves to find if list is palindrome
	* returns true if list is empty
	* Time complexity: O(n)
	* Space complexity: O(n) // because of recursion
	*/
	public boolean isPalindrome() {
		if (head == null || head.next == null) {
			return true;
		}
		
		// use fast and slow pointer approach to find mid node
		Node fast = head.next;
		Node slow = head;
		
		while(fast != null && fast.next != null) { // O(n)
			fast = fast.next.next;
			slow = slow.next;
		}
		
		Node reverseStart = slow.next; // node from where the list would be reversed
		
		Node reversedHead = reverseRecurr(reverseStart, reverseStart);
		slow.next = reversedHead;
		
		System.out.println("Intermidiate list");
		this.printList();
		
		// Now check palindrome
		Node cursor1 = head;
		Node cursor2 = reversedHead;
		while(cursor1 != null && cursor1 != slow) { // O(n)
			if (cursor1.data != cursor2.data) {
				return false;
			}
			cursor1 = cursor1.next;
			cursor2 = cursor2.next;
		}
		
		// Get back original list
		slow.next = reverseRecurr(slow.next, slow.next); // O(n)
		return true;
	}
	
	/*
	* Reverse using recursion
	* Returns head;
	*/
	public Node reverseRecurr(Node startHead, Node cursor) {
		if (cursor == null || cursor.next == null) {
			return startHead;
		}
		//System.out.println(startHead.data + " ==*== " + cursor.data);
		
		Node temp = cursor.next.next;
		cursor.next.next = startHead;
		startHead = cursor.next;
		cursor.next = temp;
		//System.out.println(startHead.data + " ==**== " + cursor.data);
		
		return reverseRecurr(startHead, cursor);
	}
	
	/*
	* Appends to the end of list
	*/
	public Node append(int data, Node nextNode) {
		Node newNode = createNode(data, nextNode);
		
		// Add new node to head if head is empty
		if (null == head) {
			head = newNode;
			return newNode;
		}
		
		Node ptr = head;
		while(null != ptr.next) {
			ptr = ptr.next;
		}
		
		ptr.next = newNode;
		return newNode;
	}
	
	/*
	* Creates new node with given value and returns it
	*/
	private Node createNode(int value, Node nextNode) {
		Node node = new Node();
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