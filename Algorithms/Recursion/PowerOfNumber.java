public class PowerOfNumber {
	public static void main(String[] args) {
		int base = 2;
		int exponent = 8;
		
		int result = powerOf(base, exponent);
		System.out.println(base + "^" + exponent + " = " + result);
	}
	
	private static int powerOf(int base, int exponent) {
		if (base == 0)
			return 0;
		
		if (exponent == 0) {
			return 1;
		}
		
		return base * powerOf(base, exponent-1);
	}
}