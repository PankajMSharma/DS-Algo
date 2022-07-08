public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[]{5,2,8,1,7,0,8,5,7};
		
		print(arr);
		sort(arr, 0);
		print(arr);
	}
	
	private static void sort(int[] arr, int pass) {
		if (arr.length == 0 || pass == arr.length) {
			return;
		}
		
		for (int j = 0; j< arr.length - pass - 1; ++j) {
			if (arr[j] > arr[j+1]) {
				arr[j] = arr[j] ^ arr[j+1];
				arr[j+1] = arr[j] ^ arr[j+1];
				arr[j] = arr[j] ^ arr[j+1];
			}
		}
		
		sort(arr, pass+1);
	}
	
	private static void print(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			System.out.print(arr[i++] + "  ");
		}
		
		System.out.println();
	}
}