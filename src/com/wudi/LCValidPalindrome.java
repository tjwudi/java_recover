package com.wudi;

public class LCValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCValidPalindrome lc = new LCValidPalindrome();
		Solution sl = lc.new Solution();
		System.out.println(sl.isPalindrome(""));
		System.out.println(sl.isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	public class Solution {
		private boolean validChar(char c) {
			return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
		}
		
		public boolean isPalindrome(String str) {
			str = str.toLowerCase();
			int n = str.length();
			int l = 0, r = n - 1;
			while (l <= r) {
				while (!validChar(str.charAt(l)) && l < r) l ++;
				while (!validChar(str.charAt(r)) && l < r) r --;
				if (l > r) break;
//				System.out.println(String.format("l:%d r:%d", l, r));
				if (str.charAt(l) != str.charAt(r)) return false;
				l ++;
				r --;
			}
			return true;
		}
	}

}
