public class Q1 {
	// Time Complxity: O(n)
	
	private static void reverse(int[] arr) {
		int length = arr.length;
		int i = 0;
		int j = length -1;
		while(i < j) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
			++i;
			--j;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{23, -2, 0, 12, 67, -1};
		
		print(arr);
		
		reverse(arr);
		
		print(arr);
		
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