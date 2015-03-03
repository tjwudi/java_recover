package com.wudi.lc2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;



public class LCReversePolish {
	private static final Set<String> OPERATORS =
		      new HashSet<>(Arrays.asList("+", "-", "*", "/"));

	public static void main(String[] args) {
		LCReversePolish lc = new LCReversePolish();
		Solution sl = lc.new Solution();
		int g = sl.evalRPN(new String[] {"4","13","5","/","+"});
		System.out.println(g);
	}
	
	public class Solution {
	    public int evalRPN(String[] tokens) {
	        Stack<Integer> tokenStack = new Stack<>();
	        for (int i = 0; i < tokens.length; i ++) {
	        	String cur = tokens[i];
	        	if (OPERATORS.contains(cur)) {
	        		// op
	        		int op1 = tokenStack.pop();
	        		int op2 = tokenStack.pop();
	        		int result = 0;
	        		switch(cur.charAt(0)) {
	        		case '+':
	        			result = op2 + op1;
	        			break;
	        		case '-':
	        			result = op2 - op1;
	        			break;
	        		case '*':
	        			result = op2 * op1;
	        			break;
	        		case '/':
	        			result = op2 / op1;
	        			break;
	        		}
//	        		System.out.println(String.format("%d %s %d", op1, cur, op2));
	        		tokenStack.push(result);
	        	}
	        	else {
	        		// numeric
	        		tokenStack.push(Integer.parseInt(cur));
	        	}
	        }
	        
	        return tokenStack.pop();
	    }
	}
}
