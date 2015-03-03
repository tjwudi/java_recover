package com.wudi;

public class LCPlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCPlusOne lc = new LCPlusOne();
		Solution sl = lc.new Solution();
		int[] arr = sl.plusOne(new int[] { 1, 9, 9 });
		int j = 0;
		j ++;
	}
	
	
	class Solution {
	    public int[] plusOne(int[] digits) {
	        int i = digits.length - 1,
	        		carry = 1;
	        while (carry > 0 && i >= 0) {
	        	digits[i] ++;
	        	if (digits[i] == 10) {
	        		digits[i] = 0;
	        		i --;
	        	}
	        	else {
	        		carry = 0;
	        	}
	        }
	        if (carry > 0) {
	        	int[] result = new int[digits.length + 1];
	        	result[0] = 1;
	        	for (int j = 1; j < digits.length + 1; j ++) result[j] = digits[j - 1];
	        	return result;
	        }
	        return digits;
	    }
	}
}
