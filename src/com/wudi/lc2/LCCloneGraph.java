package com.wudi.lc2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LCCloneGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCCloneGraph lc = new LCCloneGraph();
		Solution sl = lc.new Solution();
		
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(-1);
		node1.neighbors.add(node2);
		node2.neighbors.add(node1);
		
		UndirectedGraphNode nodeResult = sl.cloneGraph(node2);
		sl = null;
	}
	
	public class Solution {
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        Queue<UndirectedGraphNode> queue = new LinkedList<>();
	        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
	        queue.add(node);
	        
	        UndirectedGraphNode newNode, curNode, tempNode, lastNewNode = null;
	        while (queue.peek() != null) {
	            curNode = queue.poll();
	            newNode = new UndirectedGraphNode(curNode.label);
	            map.put(curNode, newNode);
	            
	            int neighborCount = curNode.neighbors.size();
	            for (int i = 0; i < neighborCount; i ++) {
	                tempNode = curNode.neighbors.get(i);
	                if (map.containsKey(tempNode)) {
	                    newNode.neighbors.add(map.get(tempNode));
	                    if (map.get(tempNode) != newNode)
	                        map.get(tempNode).neighbors.add(newNode);
	                }
	                else {
	                    queue.add(tempNode);
	                }
	            }
	            lastNewNode = newNode;
	        }
	        return lastNewNode;
	    }
	}

}
