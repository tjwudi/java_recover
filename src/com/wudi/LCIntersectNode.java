package com.wudi;

public class LCIntersectNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCIntersectNode lc = new LCIntersectNode();
		Solution sl = lc.new Solution();
		System.out.println(sl.findMin(new int[] { 1,2,3,4,5,6 }));
	}
	
	public class Solution {
	    public int findMin(int[] num) {
	    	
	    	int l = 0, r = num.length - 1, ans = Integer.MAX_VALUE;
	    	while (l <= r) {
	    		int mid = (l + r) / 2;
	    		ans = Math.min(ans, num[mid]);
	    		if ((num[l]>=num[mid]&&num[r]>=num[mid])||(num[r]<=num[mid]&&num[l]<=num[mid])) {
		    		if (Math.abs(num[l] - num[mid]) >= Math.abs(num[r] - num[mid])) {
		    			r = mid - 1;
		    		}
		    		else {
		    			l = mid + 1;
		    		}
	    		}
	    		else {
	    			ans = Math.min(ans, num[l]);
	    			ans = Math.min(ans, num[r]);
	    			l = 1; r = 0;
	    		}
	    	}
	        return ans;
	    }
	}
}

