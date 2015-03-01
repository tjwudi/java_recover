package com.wudi;

import java.util.Arrays;
import java.util.Comparator;


public class LCLargestNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCLargestNum lc = new LCLargestNum();
		Solution s = lc.new Solution();
		System.out.println(s.largestNumber(new int[] { 128, 12 }));
	}

	
	public class Solution {
		private String[] getStrNum(int[] num) {
			String[] strNum = new String[num.length];
			for (int i = 0; i < num.length; i ++) {
				strNum[i] = new Integer(num[i]).toString();
			}
			return strNum;
		}
	
		
	    public String largestNumber(int[] num) {
	    	String[] strNum = getStrNum(num);
	    	Arrays.sort(strNum, new Comparator<String>() {
	    		@Override
	    		public int compare(String o1, String o2) {
	    			int comp = o1.compareTo(o2);
	    			if (comp == 0) return comp;
	    			if (comp == -1) {
	    				String temp = o1; o1 = o2; o2 = temp;
	    			}
	    			if (o1.startsWith(o2)) {
	    				if (o1.charAt(o2.length()) > o1.charAt(0)) {
	    					return 1;
	    				}
	    				else {
	    					return -1;
	    				}
	    			}
	    			return comp;
	    		}
			});
	    	
	    	StringBuilder sb = new StringBuilder();
	    	for (int i = strNum.length - 1; i >= 0; i --) sb.append(strNum[i]);
	    	return sb.toString();
	    }
	    
	    
	   
	}
	
	
}
