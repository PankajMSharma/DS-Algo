import java.util.*;
import java.util.stream.*;

public class PhoneKeypadProblem {
	
	public static void main(String[] args) {
		String combo = "29";
		int resultSize = (int)Math.pow(2, combo.length());
		List<String> result = new ArrayList<String>();
		
		System.out.println("Possible combinations for key combo \"" + combo + "\" are : ");
		
		getCombinations(combo, 0, "", result);
		
		// print
		for (int i=0; i < result.size(); ++i) {
			System.out.println(result.get(i));
		}
	}
	
	private static void getCombinations(String combo, int index, String output, List<String> result) {
		if (index >= combo.length()) {
			if (output.length() > 0) {
				result.add(output);
			}
			return;
		}
		
		String keyString = getMappedCharsForKey(Character.getNumericValue(combo.charAt(index)));
		for (int i = 0; i < keyString.length(); ++i) {
			// Include
			String newOutput = output + Character.toString(keyString.charAt(i));
			getCombinations(combo, index+1, newOutput, result);	
		}
	}
	
	// Return mapped chars list using ascii
	private static String getMappedCharsForKey(int key) {
		String[] mappedChars = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		return mappedChars[key];
	}
}