

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[]{5,2,8,1,-1, 7,0,8, -1, -5, -324324, 2873642, 5,7};
		
		print(arr);
		sort(arr, 0, arr.length-1);
		print(arr);
	}
	
	private static void sort(int[] arr, int start, int end) {
		if (arr.length == 0 || start >= end) {
			return;
		}
		
		int mid = (end+start)/2;
		
		// divide by mid
		sort(arr, start, mid);
		sort(arr, mid+1, end);
		// merge both array
		merge(arr, start, mid, end);
	}
	
	private static void merge(int[] arr, int start, int mid, int end) {
		if (start > end) {
			return;
		} 
		int cursor1 = start;
		int cursor2 = mid+1;
		
		while (cursor1 <= mid && cursor2 <= end) {
			if (arr[cursor1] > arr[cursor2]) {
				int temp = arr[cursor1];
				arr[cursor1] = arr[cursor2];
				arr[cursor2] = temp;
				++cursor1;
			} else {
				++cursor2;
			}
		}
		
		// Apply shell/gap algorithm to sort unsorted part
		int gap = (end-start)/2;
		
		while(gap >= 1) {
			cursor1 = start;
			cursor2 = start+gap;
			while(cursor2 <= end) {
				if (arr[cursor1] > arr[cursor2]) {
					int temp = arr[cursor1];
					arr[cursor1] = arr[cursor2];
					arr[cursor2] = temp;
				}
				++cursor1;
				++cursor2;
			}
			gap = gap/2;
		}
	}
	
	private static void print(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			System.out.print(arr[i++] + "  ");
		}
		
		System.out.println();
	}
}