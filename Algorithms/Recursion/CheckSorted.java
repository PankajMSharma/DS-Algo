public class CheckSorted {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 3, 3, 5, 7, 9, 12, 34};
		
		boolean sorted = isSorted(arr, 0, arr.length);
		System.out.println("Array is : " + (sorted ? "sorted" : "unsorted"));
	}
	
	private static boolean isSorted(int[] arr, int cursor, int length) {
		if (length == 0 || length == 1 || cursor == length-1) {
			return true;
		}
		
		if (arr[cursor] <= arr[cursor+1]) {
			return isSorted(arr, cursor+1, length);
		} else {
			return false;
		}
	}
}