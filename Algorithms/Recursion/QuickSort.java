public class QuickSort {
	public static void main(String[] args) {
		//int[] arr = new int[]{5,2,8,1,-1, 7,0,8, -1, -5, -324324, 2873642, 5,7};
		int[] arr = new int[]{5,5,2,5,5,2,5,2,5};
		
		print(arr);
		sort(arr, 0, arr.length-1);
		print(arr);
	}
	
	/*
	* Quick sort
	*/
	private static void sort(int[] arr, int start, int end) { // O(nlogn)
		if (start >= end) {
			return;
		}
		
		// Set pivot to correct position, move smaller to left and larger to right of pivot and then return pivot's index
		int pivotIndex = partition(arr, start, end);
		
		// sort left part
		sort(arr, start, pivotIndex-1);
		// sort right part
		sort(arr, pivotIndex+1, end);
	}
	
	/*
	* 
	*/
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		
		// find pivot's correct position by calculating elements less tha pivot
		int lessThanPivotCount = 0;
		for (int i=start+1; i <= end; ++i) {
			if (arr[i] <= pivot)
				++lessThanPivotCount;
		}
		
		int pivotIndex = lessThanPivotCount+start;
		// Move pivot to correct position
		int temp = arr[start];
		arr[start] = arr[pivotIndex];
		arr[pivotIndex] = temp;
 
		// segregate smaller than pivot to left and larger than pivot to right of pivot
		int i = start;
		int j = end;
		while(i < pivotIndex && j > pivotIndex) {
			while(arr[i] <= pivot)// move right until element greater than pivot is found
				++i;
			
			while(arr[j] > pivot)// move left until element lesser than pivot is found
				--j;
			
			// swap both if indexes are correct
			if (i < pivotIndex && j > pivotIndex) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				++i;
				--j;
			}
		}
		
		return pivotIndex;
	}
	
	private static void print(int[] arr) { // O(n)
		int i = 0;
		while(i < arr.length) {
			System.out.print(arr[i++] + "  ");
		}
		
		System.out.println();
	}
}