public class InsertionSort {
	
	private static int[] sort(int[] arr, int length) {
		// marker == length - 1 return -1
		// arr[marker] > arr[marker+1]
			// place(marker+1)
		// marker++;
		
		for (int i = 1; i < length; ++i) {
			int element = arr[i];
			int j = i-1;
			while (j >= 0 && arr[j] > element) {
				arr[j+1] = arr[j];
				--j;
			}
			
			arr[j+1] = element;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{23, -2, 0, 12, 4, 1, 0, 43};
		
		System.out.print("Before sorting: ");
		printArray(arr, arr.length);
		
		arr = sort(arr, arr.length);

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