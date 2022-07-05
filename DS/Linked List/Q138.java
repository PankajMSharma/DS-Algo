// Approach: Merge Sort on linked list

public class Q138 {
	private Node head;
	
	public class Node {
		public int data;
		public Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Creating unsorted list:");
		Q138 list = new Q138();
		list.append(8, null);
		list.append(6, null);
		list.append(3, null);
		list.append(4, null);
		list.append(5, null);
		list.append(1, null);

		list.printList();
		
		list.head = list.mergeSort(list.head);
		
		System.out.println("Sorted list:");
		list.printList();
	}
	
	/*
	* Time complexity: O(nlogn)
	* Space complexity: O(n) // because of recursion
	*/
	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		// get mid
		Node mid = findMid(head);
		
		Node left = head;
		Node right = mid.next;
		mid.next = null;
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		// merge
		head = merge(left, right);
		return head;
	}
	
	private Node findMid(Node head) {
		Node slow = head;
		Node fast = head.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	private Node merge(Node left, Node right) {
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		
		Node result = new Node(-1, null);
		Node temp = result;
		while(left != null && right != null) {
			if (left.data < right.data) {
				temp.next = left;
				left = left.next;
				temp = temp.next;
			} else {
				temp.next = right;
				right = right.next;
				temp = temp.next;
			}
		}
		
		if (left != null) {
			temp.next = left;
		}
		
		if (right != null) {
			temp.next = right;
		}
		
		return result.next;
	}
	
	/*
	* Appends to the end of list
	*/
	public Node append(int data, Node nextNode) {
		Node newNode = new Node(data, nextNode);
		
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