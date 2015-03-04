package com.wudi.lc2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LCValidParanthesis {
	
	public static void main(String[] args) {
		LCValidParanthesis lc = new LCValidParanthesis();
		Solution sl = lc.new Solution();
		System.out.println(sl.isValid("{()}[]"));
	}
	
	public class Solution {
		public final Map<Character,Character> corMap = 
				new HashMap<Character, Character>() {{
					put('}', '{');
					put(')', '(');
					put(']', '[');
				}};
				
	    public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<>();
	        int n = s.length();
	        for (int i = 0; i < n; i ++) {
	        	Character c = s.charAt(i);
	        	if (!stack.isEmpty() && corMap.get(c) == stack.peek()) {
	        		stack.pop();
	        	}
	        	else {
	        		stack.push(c);
	        	}
	        }
	        return stack.isEmpty();
	    }
	}
}
