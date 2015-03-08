package com.wudi.lc2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LCBackOrder {
	public static void main(String[] args) {
		LCBackOrder lc = new LCBackOrder();
		Solution sl = lc.new Solution();
		
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		l1.left = l2;
		l2.right = l3;
		
		List<Integer> result = sl.postorderTraversal(l1);
		
		sl = null;
	}
	
	public class Solution {
	    public List<Integer> postorderTraversal(TreeNode root)  {
	        List<Integer> result = new LinkedList<Integer>();
	        if (root == null) return result;
	        
	        Stack<TreeNode> stack = new Stack<>();
	        Set<TreeNode> visited = new HashSet<>();
	        stack.push(root);
	        
	        while (!stack.empty()) {
	            TreeNode current = stack.peek();
	            if (!visited.contains(current)) {
	                visited.add(current);
	                if (current.right != null) stack.push(current.right);
	                if (current.left != null) stack.push(current.left);
	                if (current.left == null && current.right == null) {
	                    result.add(current.val);
	                    stack.pop();
	                }
	            }
	            else {
	                result.add(current.val);
	                stack.pop();
	            }
	        }
	        return result;
	    }
	}
}
