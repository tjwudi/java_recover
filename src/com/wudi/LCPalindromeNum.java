package com.wudi;

public class LCPalindromeNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCPalindromeNum lc = new LCPalindromeNum();
		Solution sl = lc.new Solution();
		System.out.println(sl.isPalindrome(1331));
	}

	class Solution {
		private int numberOfDigits(int x) {
			return (int)Math.floor(Math.log10(x)) + 1;
		}
		
		private int getDigit(int x, int index) {
			// 12345, index of 5 is 0, index of 4 is 1
			return (x / (int)Math.pow(10, index - 1)) % 10;
		}
		
	    public boolean isPalindrome(int x) {
	        if (x < 0) return false;
	        if (x == 0) return true;
	        int l = numberOfDigits(x), r = 1;
	        while (l >= r) {
	        	if (getDigit(x, l) != getDigit(x, r)) return false;
	        	l --; r ++;
	        }
	        return true;
	    }
	}
}
