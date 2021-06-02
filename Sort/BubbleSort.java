public class BubbleSort {
	private static int[] sort(int[] arr, int len) {
		for(int i=0; i<len-1; ++i) {
			for(int j=0; j < len - i - 1; ++j) {
				if (arr[j] > arr[j+1]) {
					
					System.out.println(i + "=" + j); // to debug
					printArray(arr); // to debug
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
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