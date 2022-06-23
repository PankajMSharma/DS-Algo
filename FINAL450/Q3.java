public class Q3 {
	//Time Complexity: O(n)
	// Sol 1: Use bubble sort but number of passes shall be equal to K. (Issue: When K==N, time complexity = O(n^2))
	// Sol 2: MaxHeap
	
	private static void findMinMax(int[] arr, int len) {
		
		if (len == 0) {
			System.out.println("No value in array");
			return;
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{23, -2, 0, 12, 22342423, -2147483648, 67, -1};
		
		print(arr);
		
		findMinMax(arr, arr.length);		
	}

	private static void print(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			System.out.print(arr[i] + (i < (arr.length-1) ? ", " : ""));
			++i;
		}
		System.out.println();
	}
}