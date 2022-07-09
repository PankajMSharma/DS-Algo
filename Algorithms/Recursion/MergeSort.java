public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[]{5,2,8,1,-1, 7,0,8,5,7};
		
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
		
		if (cursor1 < mid) {
			int mid1 = (cursor1+mid)/2;
			sort(arr, cursor1, mid1);
			sort(arr, mid1+1, mid);
			merge(arr, cursor1, mid1, end);
		}
		if (cursor2 < end) {
			int mid2 = (cursor2+end)/2;
			sort(arr, cursor2, mid2);
			sort(arr, mid2+1, end);
			merge(arr, cursor2, mid2, end);
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