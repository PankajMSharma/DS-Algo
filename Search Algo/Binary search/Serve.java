import java.io.*;

public class Serve {
	
	private static int search(int[] sourceArr, int searchKey, int startIdx, int endIdx) throws IOException {
		
		if (startIdx > endIdx) {
			return -1;
		}
		
		int mid = (endIdx + startIdx)/2;

		if (sourceArr[mid] == searchKey) {
			return mid;
		} else if (sourceArr[mid] > searchKey) {
			return search(sourceArr, searchKey, startIdx, mid-1);
		} else {
			return search(sourceArr, searchKey, mid+1, endIdx);
		}
	}
	
	public static void main(String args[]) throws IOException {
		int[] sourceArr = new int[]{1,20,23,45,52,64,85,89,91,102,208,1000};
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("What you need to search?");
		int searchKey = Integer.parseInt(reader.readLine());
		
		int index = search(sourceArr, searchKey, 0, sourceArr.length - 1);
		
		if (index >= 0) {
			System.out.println("Found at: " + index);
			return;
		}
		
		System.out.println("No such number exists");
	}
}