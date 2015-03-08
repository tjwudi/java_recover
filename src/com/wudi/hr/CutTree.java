package com.wudi.hr;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class CutTree {
	private static int result = Integer.MAX_VALUE, totalSum = 0;
	
	private static int calculateTreeSum(TreeNode node, TreeNode prev) {
		node.subTreeSum = node.val;
		Iterator<TreeNode> it = node.neighbors.iterator();
		while (it.hasNext()) {
			TreeNode neighbor = it.next();
			if (neighbor != prev) {
				int val = calculateTreeSum(neighbor, node);
				node.subTreeSum += val;
				result = Math.min(result, Math.abs( (totalSum-val) - val ));
			}
		}
		return node.subTreeSum;
	}
	
	public static void main(String[] args) throws Exception {
		int N;
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		TreeNode[] nodes = new TreeNode[N];
		for (int i = 0; i < N; i ++) {
			int val = in.nextInt();
			nodes[i] = new TreeNode(val);
			totalSum += val;
		}
		
		for (int i = 0; i < N - 1; i ++) {
			int l = in.nextInt() - 1;
			int r = in.nextInt() - 1;
			nodes[l].neighbors.add(nodes[r]);
			nodes[r].neighbors.add(nodes[l]);
		}
		calculateTreeSum(nodes[0], null);
		
		System.out.println(result);
		in.close();
	}
}

class TreeNode {
	int val;
	int subTreeSum = 0;
	List<TreeNode> neighbors = new LinkedList<>();
	TreeNode(int val) { this.val = val; }
}