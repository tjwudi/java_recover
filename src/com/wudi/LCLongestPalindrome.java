package com.wudi;

public class LCLongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCLongestPalindrome lc = new LCLongestPalindrome();
		Solution sl = lc.new Solution();
		System.out.println(sl.longestPalindrome("abacc"));
	}
	
	
	class Solution {
		private String getLongest1(String s) {
			// even length
			String result = "";
			int len = s.length();
			for (int mid = 0; mid < len - 1; mid ++) {
				int l = mid, r = mid + 1;
				if (s.charAt(l) != s.charAt(r)) continue;
				while (l > 0 && r < len - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
					l --;
					r ++;
				}
				if (r - l + 1 > result.length()) {
					result = s.substring(l, r + 1);
				}
			}
			return result;
		}
		
		private String getLongest2(String s) {
			// odd length
			String result = "";
			int len = s.length();
			for (int mid = 0; mid < len; mid ++) {
				int l = mid, r = mid;
				while (l > 0 && r < len - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
					l --;
					r ++;
				}
				if (r - l + 1 > result.length()) {
					result = s.substring(l, r + 1);
				}
			}
			return result;
		}
		
	    public String longestPalindrome(String s) {
	        String longest1 = getLongest1(s),
	        		longest2 = getLongest2(s);
	        return longest1.length() > longest2.length() ? longest1 : longest2;
	    }
	}

}
