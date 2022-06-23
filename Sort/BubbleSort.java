public class BubbleSort {
	private static int[] sort(int[] arr, int len) {

		for (int pass=0; pass < len; ++pass) {
			for (int ptr = 0; ptr < len - 1 - pass; ++ptr) {
				if ( arr[ptr] > arr[ptr+1] ) {
					swap(arr, ptr, ptr+1);
				}
			}
		}
		
		return arr;
	}
	
	private static int[] swap(int[] arr, int first, int second) {
		arr[first] = arr[first] ^ arr[second];
		arr[second] = arr[first] ^ arr[second];
		arr[first] = arr[first] ^ arr[second];
		return arr;
	}
	
	private static void printArray(int[] arr) {
		for(int i=0; i<arr.length; ++i) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{21,54,52,16,0,823,1,5,98,58,1, 0,-4, 75, -85};
		System.out.println("Before Sorting");
		printArray(arr);
		
		sort(arr, arr.length);
		
		System.out.println("After Sorting");
		printArray(arr);
	}
}