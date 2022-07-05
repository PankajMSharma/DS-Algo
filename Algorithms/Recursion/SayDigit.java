public class SayDigit {
	public static void main(String[] args) {
		String[] arr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		int num = 410972432;
		System.out.println(num);
		
		say(num, arr);
	}
	
	public static void say(int n, String[] arr) {
		if (n == 0) {
			return;
		}
		
		int digit = n % 10;
		n = n / 10;
		
		say(n, arr);
		
		System.out.print(arr[digit] + " ");
	}
}