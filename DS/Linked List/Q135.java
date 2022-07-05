// Approach: Reverse both lists. Add both list. Reverse the resultant list.

public class Q135 {
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
		System.out.println("Creating sorted list1:");
		Q135 list1 = new Q135();
		list1.append(8, null);
		list1.append(6, null);
		list1.append(3, null);
		
		Q135 list2 = new Q135();
		list2.append(4, null);
		list2.append(5, null);
		list2.append(1, null);

		list1.printList();
		list2.printList();
		
		Q135 result = list1.addTwoList(list2);
		
		System.out.println("Result list:");
		result.printList();
	}
	
	/*
	* Time complexity: O(n)
	* Space complexity: O(n) // because of recursion
	*/
	public Q135 addTwoList(Q135 list) {
		// reverse both lists
		this.reverse(head, head);
		list.reverse(list.head, list.head);
		
		Q135 resultList = add(list);
		
		resultList.reverse(resultList.head, resultList.head);
		
		// Change back original lists
		this.reverse(head, head);
		list.reverse(list.head, list.head);
		
		return resultList;
	}
	
	/*
	* Add the list
	*/
	public Q135 add(Q135 list) {
		Node cursor1 = head;
		Node cursor2 = list.head;
		Q135 resultList = new Q135();
		resultList.append(0, null);
		Node resultCursor = resultList.head;
		
		int carry = 0;
		while(!(cursor1 == null && cursor2 == null)) {
			int num1 = cursor1 == null ? 0 : cursor1.data;
			int num2 = cursor2 == null ? 0 : cursor2.data;
			int sum = num1 + num2 + carry;
			resultCursor.data = sum % 10;
			carry = sum / 10;
			
			System.out.println(carry + "===" + resultCursor.data + "===" + num1 + "===" + num2 + "===" + sum);
			
			System.out.println(cursor1.data + "**" + cursor2.data + "***" + cursor1.next.data + "***" + cursor2.next.data);
			cursor1 = cursor1.next;
			cursor2 = cursor2.next;
			
			if (!(cursor1 == null && cursor2 == null)) {
				Node newNode = new Node(0, null);
				resultCursor.next = newNode;
				resultCursor = resultCursor.next;
			}
		}
		
		return resultList;
	}
	
	/*
	* Reverses the list
	*/
	public void reverse(Node head, Node cursor) {
		if (cursor == null || cursor.next == null || cursor.next.next == null) {
			return;
		}
		
		Node temp = cursor.next.next;
		cursor.next.next = cursor;
		head = cursor.next;
		cursor.next = temp;
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