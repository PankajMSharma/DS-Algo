public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 4, 12, -3, 0, 5};
		
		int searchNum = 5;
		int index = search(arr, searchNum, 0);
		
		System.out.println("Index for [" + searchNum + "] is " + index);
	}
	
	private static int search(int[] arr, int searchNum, int cursor) {
		if (arr == null || arr.length == 0 || cursor == arr.length) {
			return -1;
		}
		
		if (arr[cursor] == searchNum)
			return cursor;
		
		return search(arr, searchNum, cursor+1);
	}
}