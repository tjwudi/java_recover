package com.wudi;

import java.util.HashMap;
import java.util.Map;

public class LCTwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i ++) {
				int x = nums[i];
				if (map.containsKey(target - x)) {
					return new int[] { map.get(target - x) + 1, i + 1  };
				}
				map.put(x, i);
			}
			throw new IllegalArgumentException("No solution");
		}
	}

}
