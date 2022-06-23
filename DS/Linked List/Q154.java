import java.util.*;

public class Q154 {
	private Node head;
	
	public class Node {
		public int data;
		public Node next;
	}
	
	public static void main(String[] args) {
		// For unsorted list
		System.out.println("Creating unsorted list");
		Q154 unsortedList = getUnsortedList();

		unsortedList.printList();
		unsortedList.sortReplacingData();
		System.out.println("After sorting");
		unsortedList.printList();
		
		
		System.out.println("Creating unsorted list");
		Q154 unsortedList2 = getUnsortedList();

		unsortedList2.printList();
		unsortedList2.sortByReplacingLinks();
		System.out.println("After sorting");
		unsortedList2.printList();
	}
	
	private static Q154 getUnsortedList() {
		Q154 list = new Q154();
		
		list.append(1, null);
		list.append(0, null);
		list.append(0, null);
		list.append(2, null);
		list.append(1, null);
		list.append(0, null);
		list.append(2, null);
		list.append(1, null);
		return list;
	}
	
	/*
	* Sorting with replacing data
	* Time complexity: O(n)
	* Space complexity: O(1)
	*/
	public void sortReplacingData() {
		if (null == head || null == head.next) {
			return;
		}
		
		int zeros = 0;
		int ones = 0;
		int twos = 0;
		
		Node cursor = head;
		while(null != cursor) {
			if (cursor.data == 0)
				++zeros;
			else if (cursor.data == 1)
				++ones;
			else
				++twos;
			
			cursor = cursor.next;
		}
		
		cursor = head;
		while(cursor != null) {
			if (zeros > 0) {
				setData(cursor, 0);
				--zeros;
			} else if (ones > 0) {
				setData(cursor, 1);
				--ones;
			} else {
				setData(cursor, 2);
				--twos;
			}
			cursor = cursor.next;
		}
	}
	
	/*
	* Sorting by replacing links
	* Time complexity: O(n)
	* Space complexity: O(1)
	*/
	public void sortByReplacingLinks() {
		if (null == head)
			return;
		
		// 
		Node zeroHead = null;
		Node zeroTail = null;
		Node oneHead = null;
		Node oneTail = null;
		Node twoHead = null;
		Node twoTail = null;
		
		Node cursor = head;
		while(null != cursor) {
			Node currNext = cursor.next;
			
			if (cursor.data == 0) {
				if (zeroHead == null) {
					zeroHead = cursor;
					zeroTail = cursor;
				} else {
					zeroTail.next = cursor;
					zeroTail = zeroTail.next;
					zeroTail.next = null; // without this it would add loop in this list
				}
			} else if (cursor.data == 1) {
				if (oneHead == null) {
					oneHead = cursor;
					oneTail = cursor;
				} else {
					oneTail.next = cursor;
					oneTail = oneTail.next;
					oneTail.next = null; // without this it would add loop in this list
				}
			} else {
				if (twoHead == null) {
					twoHead = cursor;
					twoTail = cursor;
				} else {
					twoTail.next = cursor;
					twoTail = twoTail.next;
					twoTail.next = null; // without this it would add loop in this list
				}
			}
			
			cursor = currNext;
		}
		
		// Join 3 lists
		if (zeroTail != null) {
			zeroTail.next = oneHead;
		}
		if (oneTail != null) {
			oneTail.next = twoHead;
		}
		
		// Choose head based upon which value is present in preference of 0, 1 and 2
		if (zeroHead != null) {
			head = zeroHead;
		} else if (oneHead != null) {
			head = oneHead;
		} else {
			head = twoHead;
		}
	}
	
	private void setData(Node node, int data) {
		node.data = data;
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