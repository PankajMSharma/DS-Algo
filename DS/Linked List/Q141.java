/*
* Check if list is circular
*/

import java.util.*;

public class Q141<T> {
	private Node<T> head;
	
	public class Node<T> {
		public T data;
		public Node<T> next;
	}
	
	public static void main(String[] args) {
		Q141<String> list = new Q141<String>();
		list.printList();
		
		System.out.println("Running Append");
		list.append("A", null);
		list.append("B", null);
		list.append("C", null);
		list.append("D", list.head);

		list.printList();
		
		boolean isCircular1 = list.isCircular();
		
		System.out.println(isCircular1 ? "List is circular" : "List is non-circular");
		
		boolean isCircular2 = list.isCircularUsingSet();
		
		System.out.println(isCircular2 ? "List is circular using set" : "List is non-circular using set");
	}
	
	/*
	* Checks if list is circular using pointer
	*/
	public boolean isCircular() {
		if (head == null || head.next == null) {
			return true;
		}
		
		Node<T> pointer = head.next;
		
		while(pointer != head && pointer != null) {
			pointer = pointer.next;
		}
		
		if (pointer == null) {
			return false;
		}
		
		return true;
	}
	
	/*
	* Checks if list is circular using set // This also check for duplicacy using set // Set would store all visited nodes
	*/
	public boolean isCircularUsingSet() {
		if (head == null || head.next == null) {
			return true;
		}
		
		Node<T> pointer = head.next;
		Set<Node<T>> setOfNodes = new HashSet<>();
		
		while(pointer != null) {
			if (setOfNodes.contains(pointer) == true) {
				return true;
			} else {
				setOfNodes.add(pointer);
			}
			pointer = pointer.next;
		}
		
		if (pointer == null) {
			return false;
		}
		
		return true;
	}

	/*
	* Appends to the end of list
	*/
	public void append(T data, Node<T> nextNode) {
		Node<T> newNode = createNode(data, nextNode);
		
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
		
		do {
			System.out.print(cursor.data + "  ");
			cursor = cursor.next;
		} while(null != cursor && cursor != head);
		
		System.out.println();
	}
}