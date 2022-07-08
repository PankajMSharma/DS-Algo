public class ReverseString {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("W4ewr*&^vnn");
		
		System.out.println("String: " + str);
		StringBuilder reverse = reverse(str, 0, str.length()-1);
		
		System.out.println("Reverse: " + reverse);
	}
	
	private static StringBuilder reverse(StringBuilder str, int i, int j) {
		if (i > j) {
			return str;
		}
		
		char a = str.charAt(i);
		char b = str.charAt(j);
		
		str.setCharAt(i, b);
		str.setCharAt(j, a);
		return reverse(str, i+1, j-1);
	}
}