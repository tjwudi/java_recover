package com.wudi;

public class LCRotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 5, 8 };
		new Solution().rotate(arr, 1);
		int i = 0; 
		i ++;
	}

}


class Solution {
    
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] orig = new int[len];
        for (int i = 0; i < len; i ++) orig[i] = nums[i];
        for (int i = 0; i < len; i ++) nums[(i + k) % len] = orig[i];
    }
}