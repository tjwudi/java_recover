package com.wudi.lc2;

public class LCBuildTree {
	public static void main(String[] args) {
		LCBuildTree lc = new LCBuildTree();
		Solution sl = lc.new Solution();
		TreeNode nd = sl.buildTree(new int[] { 1,2} , new int[] {2,1});
		sl = null;
	}
	
	 
	public class Solution {
	    private int[] inorder, postorder;
	    private TreeNode buildTree(int inorderBegin, int inorderEnd, int postorderBegin, int postorderEnd) {
	        if (inorderBegin > inorderEnd) return null;
	        int val = postorder[postorderEnd];
	        TreeNode node = new TreeNode(val);
	        
	        int idx = inorderBegin;
	        while (inorder[idx] != val) idx ++;
	        int leftSubSize = idx - inorderBegin, rightSubSize = inorderEnd - idx;
	        
	        node.left  = buildTree(inorderBegin, idx - 1, postorderBegin, postorderBegin + leftSubSize - 1);
	        node.right = buildTree(idx + 1, inorderEnd, postorderEnd - rightSubSize, postorderEnd - 1);
	        
	        return node;
	    }
	    
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        this.inorder = inorder; 
	        this.postorder = postorder;
	        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
	    }
	}
}
