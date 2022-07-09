import java.util.*;


public class SubsequencesOfString {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("Asd");
		List<StringBuilder> ans = new ArrayList<>();
		
		getSubsequence(str, 0, new StringBuilder(), ans);
		
		// print ans
		for(StringBuilder s: ans) {
			System.out.println(s);
		}
	}
	/*
	* Time cmplexity: O(2^n) // for every char in string, 2 recursive calls are made
	* Space complexity: O(n)
	*/
	private static void getSubsequence(StringBuilder str, int index, StringBuilder output, List<StringBuilder> ans) {
		if (index >= str.length()) {
			if (output.length() > 0) // would not include empty string
				ans.add(output);
			return;
		}
				
		// Exclude str.charAt(index)
		getSubsequence(str, index+1, (new StringBuilder()).append(output), ans);
		
		// Include str.charAt(index)
		output.append(str.charAt(index));
		getSubsequence(str, index+1, (new StringBuilder()).append(output), ans);
	}
}