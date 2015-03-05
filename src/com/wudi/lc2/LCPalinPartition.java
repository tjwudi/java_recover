package com.wudi.lc2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LCPalinPartition {
	public static void main(String[] args) {
		LCPalinPartition lc = new LCPalinPartition();
		Solution sl = lc.new Solution();
		List< List<String> > result = sl.partition("abcba");
		result = null;
	}
	
	public class Solution {
	    private Map< Integer, Set<Integer> > corMap = new HashMap<>();
	    private int[] dp = new int[100001];
	    private List< List<String> > result = new LinkedList<>();

	    private void feedMap(String s, int l, int r) {
	    	int n = s.length();
	        while (l >= 0 && r < n) {
	            if (s.charAt(l) == s.charAt(r)) {
	                // put l r
	                if (!corMap.containsKey(l)) corMap.put(l, new HashSet<Integer>());
	                corMap.get(l).add(r);
	                l --; r ++;
	            }
	            else {
	                break;
	            }
	        }  
	    }
	    
	    private void makeList(String s, int l, LinkedList<String> curList) {
	        if (l == s.length()) {
	            // should produce an answer
        		result.add( (List<String>) curList.clone() );
	            return;
	        }
	        if (l > s.length()) {
	        	return;
	        }
	        Iterator<Integer> iterator = corMap.get(l).iterator();
	        while (iterator.hasNext()) {
	        	int r = iterator.next();
	        	curList.add(s.substring(l, r + 1));
	        	makeList(s, r + 1, curList);
	        	curList.removeLast();
	        }
	    }
	    
	    public List<List<String>> partition(String s) {
	        int n = s.length();
	        for (int mid = 0; mid < n; mid ++) {
	            feedMap(s, mid, mid);
	            feedMap(s, mid, mid + 1);
	        }
	        makeList(s, 0, new LinkedList<String>());
	        return result;
	    }
	}
}
