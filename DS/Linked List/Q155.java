import java.util.*;

/**
 * Clone a list and its random pointers
 */
public class Q155 {
	private Node head;
	
	public class Node {
		public int data;
		public Node next;
		public Node random;
	}
	
	public static void main(String[] args) {
		System.out.println("Creating sorted list1:");
		Q155 list = new Q155();
		Node a = list.append(1, null);
		Node b = list.append(2, null);
		Node c = list.append(3, null);
		Node d = list.append(4, null);
		Node e = list.append(5, null);
		
		a.random = d;
		b.random = e;
		c.random = a;
		d.random = b;
		e.random = c;
		
		list.printList();
		
		System.out.println("Approach 1:");
		Q155 list1 = list.clone1();
		
		System.out.println("Cloned list 1:");
		list1.printList();
		
		System.out.println("Approach 2 using map:");
		Q155 list2 = list.clone2();
		
		System.out.println("Cloned list 2:");
		list2.printList();
		
		System.out.println("Approach 3 using link replacement:");
		Q155 list3 = list.clone3();
		
		System.out.println("Cloned list 3:");
		list3.printList();
	}
	
	/*
	* 
	* Time complexity: O(n)
	* Space complexity: O(1)
	*/
	public Q155 clone1() {
		Q155 cloneL = new Q155();
		
		// Create simple clone with only next pointer
		Node cursor = head;
		while(cursor != null) { // O(n)
			cloneL.append(cursor.data, null);
			cursor = cursor.next;
		}
		
		Node cursor1 = head;
		Node cursor2 = cloneL.head;
		while(cursor1 != null) { // O(n^2)
			int randomDistance = 1;
			Node itr1 = head;
			while(itr1 != cursor1.random) {
				itr1 = itr1.next;
				++randomDistance;
			}
			
			Node itr2 = cloneL.head;
			while(randomDistance > 1) {
				itr2 = itr2.next;
				--randomDistance;
			}
			cursor2.random = itr2;
			cursor2 = cursor2.next;
			cursor1 = cursor1.next;
		}
		
		return cloneL;
	}
	
	/*
	* Using space (map)
	* Time complexity: O(n)
	* Space complexity: O(n)
	*/
	public Q155 clone2() {
		Q155 clone = new Q155();
		
		// Copy using next pointer
		Node cursor1 = head;
		while(cursor1 != null) {
			clone.append(cursor1.data, null);
			cursor1 = cursor1.next;
		}
		
		// Map each originalNode's corresponding node in cloned list
		cursor1 = head;
		Node cursor2 = clone.head;
		Map<Object, Node> randomMap = new HashMap<>();
		while(cursor1 != null && cursor2 != null) {
			randomMap.put(cursor1, cursor2);
			cursor1 = cursor1.next;
			cursor2 = cursor2.next;
		}
		
		// Set random node using map
		cursor1 = head;
		cursor2 = clone.head;
		while(cursor1 != null && cursor2 != null) {
			cursor2.random = randomMap.get(cursor1.random);
			cursor1 = cursor1.next;
			cursor2 = cursor2.next;
		}
		
		return clone;
	}
	
	/*
	* Using link replacement and without using extra memory
	* Time complexity: O(n)
	* Space complexity: O(1)
	*/
	public Q155 clone3() {
		Q155 clone = new Q155();
		// Simple clone with next pointer
		Node cursor1 = head;
		while (cursor1 != null) {
			clone.append(cursor1.data, null);
			cursor1 = cursor1.next;
		}
		
		cursor1 = head;
		Node cursor2 = clone.head;
		// Insert each cloned node between adjecent original node and original node's next
		while(cursor1 != null && cursor2 != null) {
			Node temp1 = cursor1.next;
			Node temp2 = cursor2.next;
			cursor1.next = cursor2;
			//temp.next = cursor2.next;
			cursor2.next = temp1;
			cursor1 = temp1;
			cursor2 = temp2;
		}
				
		// Set random node from the new list for cloned nodes
		cursor1 = head;
		while(cursor1 != null && cursor1.next != null) {
			cursor1.next.random = cursor1.random.next;
			cursor1 = cursor1.next.next;
		}
		
		// Separate back back both lists
		cursor1 = head;
		cursor2 = clone.head;
		while(cursor1.next != null && cursor2.next != null) {
			cursor1.next = cursor2.next;
			cursor2.next = cursor2.next.next;
			cursor1 = cursor1.next;
			cursor2 = cursor2.next;
		}
		
		return clone;
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
			
			System.out.print(cursor.data + "[" + cursor.random.data + "] ");
			cursor = cursor.next;
		}
		
		System.out.println();
	}
}