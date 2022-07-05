public class Q156 {
	private Node head;
	
	public class Node {
		public int data;
		public Node next;
	}
	
	public static void main(String[] args) {
		System.out.println("Creating sorted list1:");
		Q156 list1 = new Q156();
		list1.append(1, null);
		list1.append(4, null);
		list1.append(9, null);
		list1.append(12, null);
		list1.append(17, null);
		list1.append(17, null);
		list1.append(23, null);
		list1.append(28, null);

		list1.printList();
		
		System.out.println("Creating sorted list2:");
		Q156 list2 = new Q156();
		list2.append(1, null);
		list2.append(4, null);
		list2.append(7, null);
		list2.append(10, null);
		list2.append(17, null);
		list2.append(17, null);
		list2.append(23, null);
		list2.append(28, null);

		list2.printList();
		
		Q156[] listArr = new Q156[]{list1, list2};
		Q156 mergedList = new Q156();
		
		Q156 sortedList = mergeAll(listArr);
		
		System.out.println("After sorting");
		sortedList.printList();
	}
	
	/*
	* Sorting with replacing data
	* Time complexity: O(n)
	* Space complexity: O(1)
	*/
	public static Q156 mergeAll(Q156[] listArr) {
		if (listArr.length == 0) {
			return null;
		}
		
		if (listArr.length == 1) {
			return listArr[0];
		}
		
		// merge 2 lists at a time using recursion
		//int mid = (listArr.length + 1) / 2);
		return divide(listArr, 0, listArr.length-1);
	}
	
	private static Q156 divide(Q156[] listArr, int start, int end) {
		if (end-start > 1) {
			int mid = (end + start) / 2;
			divide(listArr, start, mid);
			divide(listArr, mid+1, end);
		} else if (end-start == 1) {
			return merge(listArr, start, end);
		}
		return listArr[start];
	}
	
	/*
	* 
	*/
	public static Q156 merge(Q156[] listArr, int start, int end) {
		if (listArr[start].head == null) {
			return listArr[end];
		} else if (listArr[end].head == null) {
			return listArr[start];
		}
		
		// merge 2 lists
		Node head1 = getListWithSmallerInitialValue(listArr[start], listArr[end]).head;
		Node head2 = listArr[start].head == head1 ? listArr[end].head : listArr[start].head;
		
		Node tail1 = head1;
		Node tail2 = head2;
		while(tail1.next != null && tail2 != null) {
			if (tail1.data <= tail2.data && tail1.next.data > tail2.data) {
				// insert tail2 between tail1 and tail1.next
				Node next1 = tail1.next;
				Node next2 = tail2.next;
				tail1.next = tail2;
				tail2.next = next1;
				tail2 = next2;
			} else {
				tail1 = tail1.next;
			}
		}
		
		if (tail2 != null) {
			tail1.next = tail2;
		}
			
		return listArr[start].head == head1 ? listArr[start] : listArr[end];
	}
	
	private static Q156 getListWithSmallerInitialValue(Q156 first, Q156 second) {
		Node cur1 = first.head;
		Node cur2 = second.head;
		while (cur1 != null && cur2 != null && cur1.data == cur2.data) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		
		if (cur1 == null && cur2 == null) {
			return first;
		} else if (cur1 == null) {
			return first;
		} else if (cur2 == null) {
			return second;
		}
		
		if (cur1.data < cur2.data) {
			return first;
		} else {
			return second;
		}
	}
	
	/*
	* Sorts lists based on only initial node (used next node only for tie-braker)
	*/
	
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