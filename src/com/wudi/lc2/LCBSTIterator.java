package com.wudi.lc2;

import java.util.Stack;


public class LCBSTIterator {
	public static void main(String[] args) {
		LCBSTIterator lc = new LCBSTIterator();
		
		TreeNode tm100 = new TreeNode(-100);
		TreeNode tm3 = new TreeNode(-3);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.right = t2;
		t1.left = tm3;
		tm3.left = tm100;
		
		BSTIterator sl = lc.new BSTIterator(null);
		sl.hasNext();
		System.out.println(sl.next());
		System.out.println(sl.next());
		System.out.println(sl.next());
		System.out.println(sl.next());
	}
	
	public class BSTIterator {
	    private Stack<TreeNode> parentStack = new Stack<>();
	    private TreeNode currentNode = null;
	    private TreeNode dummyRoot = new TreeNode(Integer.MAX_VALUE);
	    
	    public BSTIterator(TreeNode root) {
	        dummyRoot.left = root;
	        currentNode = dummyRoot;
        	leftShift();
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return currentNode == dummyRoot;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        if (currentNode == dummyRoot) return -1;
	        int result = currentNode.val;
	        rightShift();
	        return result;
	    }
	    
	    private void rightShift() {
	        if (currentNode.right != null) {
	            currentNode = currentNode.right;
	            leftShift();
	        }
	        else {
	            currentNode = parentStack.pop();
	        }
	    }
	    
	    private void leftShift() {
	        while (currentNode.left != null) {
	            parentStack.push(currentNode);
	            currentNode = currentNode.left;
	        } 
	    }
	}
}
