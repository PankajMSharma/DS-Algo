public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 4, 6, 6, 8, 9, 23};
		
		int searchNum = 3;
		int index = search(arr, searchNum, 0, arr.length-1);
		
		System.out.println(searchNum + " found at: " + index);
	}
	
	private static int search(int[] arr, int searchNum, int start, int end) {
		if (start > end) {
			return -1;
		}
		
		int mid = (end+start)/2;
		
		if (arr[mid] == searchNum)
			return mid;
		
		if (searchNum < arr[mid]) {
			return search(arr, searchNum, start, mid-1);
		} else {
			return search(arr, searchNum, mid+1, end);
		}
	}
}