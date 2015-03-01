package com.wudi;

public class LCReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCReverseWords lc = new LCReverseWords();
		Solution sl = lc.new Solution();
		System.out.println(sl.reverseWords(" Hello   world   "));
		System.out.println(sl.reverseWords(" Hello   world   "));
	}

	
	public class Solution {
		public String reverseWords(String str) {
			StringBuilder sb = new StringBuilder();
			int n = str.length();
			int i = 0;
			while (i < n) {
				int j = i;
				if (str.charAt(i) == ' ') {
					// spaces
					while (j < n - 1 && str.charAt(j + 1) == ' ') j ++;
					sb.append(" ");
				}
				else {
					// word
					while (j < n - 1 && str.charAt(j + 1) != ' ') j ++;
					for (int p = j; p >= i; p --) {
						sb.append(str.charAt(p));
					}
				}	
				i = j + 1;
			}
			return sb.toString().trim();
		}
	}
}
