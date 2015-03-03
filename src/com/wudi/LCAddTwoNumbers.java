package com.wudi;

public class LCAddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(6);
		l1.next = l2; l2.next = l3; l3.next = null;
		
		ListNode l4 = new ListNode(0);
		l4.next = null;
		
		LCAddTwoNumbers lc = new LCAddTwoNumbers();
		Solution sl = lc.new Solution();
		ListNode result = sl.addTwoNumbers(l1, l4);
		lc = null;
	}
	

	 
	class Solution {
	   private void addNode(ListNode p, int val) {
		   ListNode nextNode = new ListNode(val);
		   p.next = nextNode;
	   }
		
	   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		    if (l1 == null || l2 == null) return null;
	        ListNode p1 = l1, p2 = l2, result = new ListNode(0), resultP = result; // result dummy head
	        int carry = 0;
	        while (p1 != null && p2 != null) {
	        	int val = p1.val + p2.val + carry;
	        	carry = val / 10;
	        	val = val % 10;
	        	addNode(resultP, val);
	        	p1 = p1.next;
	        	p2 = p2.next;
	        	resultP = resultP.next;
	        }
	        
	        ListNode remainP = p1 != null ? p1 : (p2 != null ? p2 : null);
	        if (remainP != null) {
	        	int val = remainP.val + carry;
	        	carry = val / 10;
	        	val = val % 10;
	        	addNode(resultP, val);
	        	remainP = remainP.next;
	        	resultP = resultP.next;
	        }
	        
	        if (carry > 0) {
	        	addNode(resultP, carry);
	        }
	        
	        return result.next;
	   }
	}
}

