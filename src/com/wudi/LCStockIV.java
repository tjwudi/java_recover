package com.wudi;

import java.util.Arrays;



public class LCStockIV {
	private static int[] testarr;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().maxProfit(2, new int[] { 7, 1, 11, 2, 4 }));
	}

	public static class Solution {
		int[][] dp;
		int[] prices;
		
		Solution() {
			dp = new int[10000][301];
			for (int i = 0; i < 10000; i ++)
				Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		
		private int search(int n, int k) {
			if (n < 0 || k <= 0) return 0;
			if (dp[n][k] > Integer.MIN_VALUE) return dp[n][k];
			int result1 = search(n - 1, k);
			int result2 = Integer.MIN_VALUE;
			if (k % 2 == 0) {
				for (int i = k - 2; i < n; i ++) {
					result2 = Math.max(result2, search(i - 1, k - 2) + this.prices[n] - this.prices[i]);
				}
			}
			if (k % 2 == 1) {
				result2 = Math.max(result2, search(n - 1, k - 1));
			}
			dp[n][k] = Math.max(result1, result2);
			return dp[n][k];
		}
		
	    public int maxProfit(int k, int[] prices) {
	    	this.prices = prices;
	    	int result = Integer.MIN_VALUE;
	    	int n = prices.length;
	    	k = Math.min( 150, Math.min(k, n / 2) );
	    	for (int i = 1; i <= k; i ++) {
	    		result = Math.max(result, search(n - 1, 2 * i));
	    	}
	    	return result;
	    }
	}
}
