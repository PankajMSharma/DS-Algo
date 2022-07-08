public class Sum {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 4, 12, -3, 0, 5};
		
		System.out.println("Sum: " + getSum(arr, 0));
	}
	
	private static int getSum(int[] arr, int cursor) {
		if (arr == null || arr.length == 0 || cursor == arr.length) {
			return 0;
		}
		
		return arr[cursor] + getSum(arr, cursor+1);
	}
}