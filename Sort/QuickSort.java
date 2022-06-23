public class QuickSort {
		
		// A utility function to swap two elements
static void swap(int[] arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
	static int partition(int[] arr, int low, int high)
{
     
    // pivot
    int pivot = arr[high];
     
    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
    int i = (low - 1);
 
    for(int j = low; j <= high - 1; j++)
    {
         
        // If current element is smaller
        // than the pivot
        if (arr[j] < pivot)
        {
             
            // Increment index of
            // smaller element
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
}
		
	private static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int pivotIdx = partition(arr, left, right);
			
			sort(arr, left, pivotIdx-1);
			sort(arr, pivotIdx+1, right);
		}
	}
		
	public static void main(String[] args) {
		int[] arr = new int[]{23, -2, 0, 12, 4, 1, 0, 43};
		
		System.out.print("Before sorting: ");
		printArray(arr, arr.length);
		
		sort(arr, 0, arr.length-1);

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