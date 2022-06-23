import java.util.*;

public class Q131And132<T> {
	private Node<T> head;
	
	public class Node<T> {
		public T data;
		public Node<T> next;
	}
	
	public static void main(String[] args) {
		Q131And132<Integer> sortedList = new Q131And132<Integer>();
		sortedList.printList();
		
		System.out.println("Running Append");
		sortedList.append(1, null);
		sortedList.append(1, null);
		sortedList.append(1, null);
		sortedList.append(1, null);
		sortedList.append(1, null);

		sortedList.printList();
		
		sortedList.removeDuplicateFromSortedList();
		
		System.out.println("After removeDuplicateFromSortedList");
		sortedList.printList();
		
		// For unsorted list
		System.out.println("Creating unsorted list");
		Q131And132<Integer> unsortedList1 = getUnsortedList();

		unsortedList1.printList();
		unsortedList1.removeDuplicateFromUnsortedList1();
		System.out.println("After removeDuplicateFromSortedList1");
		unsortedList1.printList();
		
		// Commented until sorting algorithm is implemented
		/* 
		System.out.println("Creating unsorted list");
		Q131And132<Integer> unsortedList2 = getUnsortedList();

		unsortedList2.printList();
		unsortedList2.removeDuplicateFromUnsortedList2();
		System.out.println("After removeDuplicateFromSortedList2");
		unsortedList2.printList();*/
		
		System.out.println("Creating unsorted list");
		Q131And132<Integer> unsortedList3 = getUnsortedList();

		unsortedList3.printList();
		unsortedList3.removeDuplicateFromUnsortedList3();
		System.out.println("After removeDuplicateFromSortedList3");
		unsortedList3.printList();
	}
	
	private static Q131And132<Integer> getUnsortedList() {
		Q131And132<Integer> list = new Q131And132<Integer>();
		
		list.append(12, null);
		list.append(1, null);
		list.append(12, null);
		list.append(0, null);
		list.append(3, null);
		list.append(12, null);
		list.append(3, null);
		return list;
	}
	
	/*
	* Removes duplicate nodes from sorted list
	* Time complexity: O(n)
	* Space complexity: O(1)
	*/
	public void removeDuplicateFromSortedList() {
		if (null == head || null == head.next) {
			return;
		}
		
		Node<T> ptr = head;
		
		while(ptr != null && null != ptr.next) {
			if (ptr.data == ptr.next.data) {
				ptr.next = ptr.next.next;
				continue;
			}
			ptr = ptr.next;
		}
	}
	
	/*
	* Removes duplicate nodes from unsorted list using 2 pointer approach
	* Time complexity: O(n^2)
	* Space complexity: O(1)
	*/
	public void removeDuplicateFromUnsortedList1() {
		if (null == head) {
			return;
		}
		
		Node<T> master = head;
		while(null != master) {
			Node<T> chela = master;
			while(null != chela && null != chela.next) {
				if (master.data == chela.next.data) {
					chela.next = chela.next.next;
					continue;
				}
				chela = chela.next;
			}
			master = master.next;
		}
	}
	
	/*
	* Removes duplicate nodes from unsorted list using merge sort
	* Time complexity: O(nlogn)
	* Space complexity: O(n)
	*/
	public void removeDuplicateFromUnsortedList2() {
		if (null == head) {
			return;
		}
		
		this.mergeSort(); // Time complexity: O(nlogn) for both best and worst case // Space complexity: O(n)
		
		this.removeDuplicateFromSortedList(); // Time complexity: O(n)
	}
	
	/*
	* Removes duplicate nodes from unsorted list using merge sort
	* Time complexity: O(nlogn)
	* Space complexity: O(n)
	*/
	public void mergeSort() {
		return;
	}
	
	/*
	* Removes duplicate nodes from unsorted list using hashSet
	* Time complexity: O(n)
	* Space complexity: O(n)
	*/
	public void removeDuplicateFromUnsortedList3() {
		if (null == head) {
			return;
		}
		
		Set<T> visited = new HashSet<T>();
		Node<T> ptr = head;
		while(null != ptr && null != ptr.next) {
			visited.add(ptr.data); // If only kept after if statement, this would not work for cases 
									//where second last and last element are same. Hence, this is needed here
			if (visited.contains(ptr.next.data) == true) {
				ptr.next = ptr.next.next;
				continue;
			}
			ptr = ptr.next;
		}
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