public class MergeSort {
	
	public static int[] merge(int[] arr, int startIdx, int mid, int endIdx) {
		int[] left = new int[mid-startIdx+1];
		int[] right = new int[endIdx-mid];
		
		//copy
		for (int i=0; i<= left.length-1; ++i)
			left[i] = arr[startIdx+i];
		for (int i=0; i<= right.length-1; ++i)
			right[i] = arr[mid+1+i];
		
		// merge
		int i = 0;
		int j = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[startIdx++] = left[i++];
			} else {
				arr[startIdx++] = right[j++];
			}
		}
		
		// copy remaining elements from left or right
		while (i < left.length) {
			arr[startIdx++] = left[i++];
		}
		
		while (j < right.length) {
			arr[startIdx++] = right[j++];
		}
		
		return arr;
	}
	
	public static int[] mergeSort(int[] arr, int startIdx, int endIdx) {
		while (startIdx < endIdx) {
			int mid = (endIdx+startIdx) / 2;
			mergeSort(arr, startIdx, mid);
			mergeSort(arr, mid+1, endIdx);
			
			merge(arr, startIdx, mid, endIdx);
			++startIdx;
			--endIdx;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{23, -2, 0, 12, 4, 1, 0, 43};
		
		System.out.print("Before sorting: ");
		printArray(arr, arr.length);
		
		arr = mergeSort(arr, 0, arr.length-1);

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