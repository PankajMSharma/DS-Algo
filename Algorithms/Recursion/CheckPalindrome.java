public class CheckPalindrome {
	public static void main(String[] args) {
		String str = "QereQ";
		
		boolean palindrome = isPalindrome(str, 0, str.length()-1);
		
		System.out.println("String: " + str + (palindrome ? " is " : " is not") + " palindrome");
	}
	
	private static boolean isPalindrome(String str, int i, int j) {
		if (i > j) {
			return true;
		}
		
		if (str.charAt(i) != str.charAt(j))
			return false;
		
		return isPalindrome(str, i+1, j-1);
	}
}