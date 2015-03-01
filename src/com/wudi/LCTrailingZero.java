package com.wudi;


public class LCTrailingZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCTrailingZero lc = new  LCTrailingZero();
		Solution sl = lc.new Solution();
		System.out.println(sl.trailingZeroes(10));
	}
	
	class Solution {
		int n;
		
		private int calc(int m) {
			long i = m;
			int result = 0;
			while (i <= n) {
				result += n / i;
				i *= m;
			}
			return result;
		}
		
	    public int trailingZeroes(int n) {
	    	this.n = n;
	        return Math.min(calc(2), calc(5));
	    }
	}

}
