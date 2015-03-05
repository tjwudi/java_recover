package com.wudi.lc2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class LCPalinPartition2 {
	public static void main(String[] args) {
		LCPalinPartition2 lc = new LCPalinPartition2();
		Solution sl = lc.new Solution();
		System.out.println(sl.minCut("aab"));
	}
	
	public class Solution {
	    private Map< Integer, List<Integer> > corMap = new HashMap<>();
	    private int[] dp = new int[10001];
	    int n;

	    private void feedMap(String s, int l, int r) {
	        while (l >= 0 && r < n) {
	            if (s.charAt(l) == s.charAt(r)) {
	                // put l r
	                if (!corMap.containsKey(l)) corMap.put(l, new LinkedList<Integer>());
	                corMap.get(l).add(r);
	                l --; r ++;
	            }
	            else {
	                break;
	            }
	        }  
	    }
	    
	    private int dynamicProgramming(String s) {
	    	Arrays.fill(dp, Integer.MAX_VALUE / 3);
	    	dp[n] = 0;
	    	for (int l = n - 1; l >= 0; l --) {
	    		Iterator<Integer> iterator = corMap.get(l).iterator();
	    		while (iterator.hasNext()) {
	    			int r = iterator.next();
	    			dp[l] = Math.min(dp[l], dp[r + 1] + 1);
	    		}
	    	}
	    	return dp[0];
	    }
	    
	    public int minCut(String s) {
	        n = s.length();
	        for (int mid = 0; mid < n; mid ++) {
	            feedMap(s, mid, mid);
	            feedMap(s, mid, mid + 1);
	        }
	        return dynamicProgramming(s) - 1;
	    }
	}
}
