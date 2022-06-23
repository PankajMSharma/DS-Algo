public class Q2 {
	//Time Complexity: O(n)
	
	private static void findMinMax(int[] arr, int len) {
		
		if (len == 0) {
			System.out.println("No value in array");
			return;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < len; ++i) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		System.out.println("Min: " + min + " Max: " + max);
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