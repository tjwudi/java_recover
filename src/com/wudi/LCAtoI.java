package com.wudi;

public class LCAtoI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCAtoI lc = new LCAtoI();
		Solution sl = lc.new Solution();
		System.out.println(sl.atoi("-1"));
	}

	class Solution {
		public int atoi(String str) {
			int result = 0;
			int i = 0, sign = 1;
			str = str.trim();
			
			if (str.length() == 0) {
				return 0;
			}
			
			char firstChar = str.charAt(0);
			if (!Character.isDigit(firstChar)) {
				switch (firstChar) {
				case '+':
					break;
				case '-':
					sign = -1;
					break;
				default:
					return 0;
				}
				i = 1;
			}
			
			int len = str.length();
			for (; i < len; i ++) {
				if (!Character.isDigit(str.charAt(i))) {
					return result * sign;
				}
				long tempResult = (long) result;
				tempResult *= 10;
				tempResult += (char)(str.charAt(i) - '0');
				if (tempResult * sign > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				else if (tempResult * sign < -Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
						
				result *= 10;
				result += (char)(str.charAt(i) - '0'); 
			}
			
			return result * sign;
		}
	}
}
