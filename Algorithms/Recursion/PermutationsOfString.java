import java.util.*;

/* IMP Question to unerstand Permutation
* This would not use extra space. This would swap charcters in original string to get permutations
*/

public class PermutationsOfString {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("abb");
		List<String> result = new ArrayList<>();
		getPermutations(str, 0, result);
		
		result.stream().forEach(a -> System.out.println(a));
	}
	
	/*
	* Gives all permutations of string in lexical order.
	* outputPosition here means the position in output which next needs to be filled
	* Time complixity: O(n*n!) // n to get one output string and n! for all the outputs
	*/
	private static void getPermutations(StringBuilder str, int position, List<String>result) {
		if (position >= str.length()) {
			if (result.contains(str.toString()) == false) // to only add unique duplicates (useful when original string has repeated chars)
				result.add(str.toString());
			return;
		}
		
		// Fill each char(which is not already present in output) to the output at position and call getPermutations for it
		for (int i=position; i < str.length(); ++i) {
			swap(str, i, position);
			getPermutations(str, position+1, result);
			// swap back string to original
			swap(str, i, position);
		}
	}
	
	private static void swap(StringBuilder str, int first, int second) {
		char temp = str.charAt(first);
		str.setCharAt(first, str.charAt(second));
		str.setCharAt(second, temp);
	}
}