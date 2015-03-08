package com.win;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	private static Map<Character, Integer> map = new HashMap<>();
	
	private static boolean isPalindrome(String s) {
		// Count number of all characters using a map
		// Because we cannot assert that all characters are from a~z
    	for (int i = 0; i < s.length(); i ++) {
    		char c = s.charAt(i);
    		if (!map.containsKey(c)) {
    			map.put(c, 1);
    		}
    		else {
    			map.put(c, map.get(c) + 1);
    		}
    	}
    	// Simply iterate through the map
    	// A valid palindrom cannot have more than one odd-times chars
    	int odd = 0;
    	for (Map.Entry<Character, Integer> entry : map.entrySet()) {
    	    int count = entry.getValue();
    	    if (count % 2 == 1) odd ++;
    	}
    	if (odd > 1) return false;
    	else return true;
	}
	
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	Scanner in = new Scanner(System.in);
    	String s = in.next();
    	System.out.println(isPalindrome(s));
    	// Make sure to close!
    	in.close();
    }
}