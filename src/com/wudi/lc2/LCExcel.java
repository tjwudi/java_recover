package com.wudi.lc2;

import java.util.Scanner;

public class LCExcel {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LCExcel lc = new LCExcel();
		Solution sl = lc.new Solution();
		
		while (true) {
			String s = in.next();
			
			System.out.println(sl.titleToNumber(s));
		}
	}
	
	public class Solution {
	    public int titleToNumber(String s) {
	        int mul = 1, result = 0;
	        for (int i = s.length() - 1; i >= 0; i --) {
	        	int code = (int)s.charAt(i) - 'A' + 1;
	        	result += mul * code;
	        	mul *= 26;
	        }
	        return result;
	    }
	}
}
