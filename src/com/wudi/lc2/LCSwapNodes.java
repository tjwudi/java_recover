package com.wudi.lc2;


public class LCSwapNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	class Solution {
		private ListNode getNext(ListNode node) {
			if (node == null) return null;
			return node.next;
		}
		
	    public ListNode swapPairs(ListNode head) {
	        ListNode a = null, b = head, c = getNext(b), d = getNext(c);
	        while (c != null) {
	        	c.next = b;
	        	b.next = d;
	        	if (a != null) a.next = c;
	        	a = c; b = getNext(a); c = getNext(b); d = getNext(c);
	        }
	        return head;
	    }
	}

}
