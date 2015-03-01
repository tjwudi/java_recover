package com.wudi;

public class LCReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCReverseInteger lc = new LCReverseInteger();
		Solution sl = lc.new Solution();
		System.out.println(sl.reverse(-123));
	}
	
	class Solution {
		public int reverse(int x) {
			int sign = x >= 0 ? 1 : -1;
			long result = 0;
			x = Math.abs(x);
			while (x > 0) {
				int digit = x % 10;
				x /= 10;
				result *= 10;
				result += digit;
			}
			if (result * sign > Integer.MAX_VALUE || result * sign < Integer.MIN_VALUE) return 0;
			return (int)(result * sign);
		}
	}

}
