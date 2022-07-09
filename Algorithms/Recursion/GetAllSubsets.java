import java.util.*;

public class GetAllSubsets {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 4, 1};
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		// get all subsets
		getAllSubsets(arr, 0, new ArrayList<Integer>(), ans);
		
		// Print all subsets
		for(List<Integer> set: ans) { // Time complixity: O(n)
			for(Integer value: set) {
				System.out.print(Integer.valueOf(value) + " ");
			}
			System.out.println();
		}
	}
	
	/*
	* Gets all subset of set
	* Time complexity: O(2^n) // because for each element in arr, 2 calls would be made to getAllSubsets()
	* Space complexity: O(n)
	*/
	// Note: We can get rid on "ans" if we do not require to store result and if we only need to directly print it. In that case print loop can be put under base case
	private static void getAllSubsets(int[] arr, int index, List<Integer> output, List<List<Integer>> ans) {
		if (index >= arr.length) {
			ans.add(output); // Only leaf nodes of recursion tree will execute this.
			return;
		}
		
		//Exclude arr[index]
		getAllSubsets(arr, index+1, new ArrayList<Integer>(output), ans); // IMP to pass new output list because we want to pick only leave node outputs
		
		// Include arr[index]
		output.add(arr[index]);
		getAllSubsets(arr, index+1, new ArrayList<Integer>(output), ans); // IMP to pass new output list because we want to pick only leave node outputs
	}
}