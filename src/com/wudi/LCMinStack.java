package com.wudi;

public class LCMinStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCMinStack lc = new LCMinStack();
		MinStack ms = lc.new MinStack();
		ms.push(1);
		ms.push(10);
		ms.push(-2);
		ms.push(11);
		System.out.println(ms.getMin());
		System.out.println(ms.top());
	}
	
	class MinStack {
	    int[] minRecord;
	    int[] stack;
	    final int N = 1000000;
	    
	    {
	    	minRecord = new int[N];
	    	stack = new int[N];
	    	stack[0] = minRecord[0] = 0;
	    }
	    
	    public void push(int x) {
	    	stack[ ++ stack[0] ] = x;
	    	if (minRecord[0] == 0 || minRecord[ minRecord[0] ] >= x) {
	    		minRecord[ ++ minRecord[0] ] = x;
	    	}
	    }

	    public void pop() {
	    	if (stack[0] == 0) return;
	    	int removeVal = stack[ stack[0] ];
	        stack[0]--;
	        if (removeVal == minRecord[ minRecord[0] ]) {
	        	minRecord[0]--;
	        }
	    }

	    public int top() {
	        return stack[ stack[0] ];
	    }

	    public int getMin() {
	        return minRecord[ minRecord[0] ];
	    }
	}


}
