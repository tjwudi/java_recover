package com.wudi;

import java.util.HashMap;
import java.util.Map;

public class LCSubStrNoRep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCSubStrNoRep lc = new LCSubStrNoRep();
		Solution sl = lc.new Solution();
		System.out.println(sl.lengthOfLongestSubstring("abcxdcabcabc"));
		System.out.println(sl.lengthOfLongestSubstring(" a"));
	}

	class Solution {
		public int lengthOfLongestSubstring(String s) {
			Map<Character, Integer> map = new HashMap<>();
			int banner = 0,
				len = s.length(),
				ans = 0;
			for (int i = 0; i < len; i ++) {
				Character chr = s.charAt(i);
				if (!map.containsKey(chr)) {
					map.put(s.charAt(i), i);
					ans = Math.max(ans, i - banner + 1);
				}
				else {
					// exists before i
					int lastOccurIdx = map.get(chr);
					if (lastOccurIdx + 1 > banner) {
						banner = lastOccurIdx + 1;
					}
					// update ans
					ans = Math.max(ans, i - banner + 1);
					// update map
					map.put(chr, i);
				}
			}
			return ans;
		}
	}
}
