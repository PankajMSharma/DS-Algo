public class SelectionSort {
	
	public static int[] sort(int[] arr) {
			
		for (int i=0; i<arr.length; ++i) {
			// find minimun
			int minIdx = i;
			for (int j=i+1; j<arr.length; ++j) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}

			//swap
			if (i != minIdx) {
				arr[minIdx] = arr[i] ^ arr[minIdx];
				arr[i] = arr[i] ^ arr[minIdx];
				arr[minIdx] = arr[i] ^ arr[minIdx];
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{23, -2, 0, 12, 4, 1, 0, 43};
		
		System.out.print("Before sorting: ");
		printArray(arr, arr.length);
		
		arr = sort(arr);

		System.out.print("After sorting: ");		
		printArray(arr, arr.length);
	}
	
	private static void printArray(int[] arr, int length) {
		for (int i=0; i < length; ++i) {
			System.out.print(arr[i] + (i == length-1 ? "" :", "));
		}
		System.out.println();
	}
}