package com.wudi.lc2;

public class LCSortList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(19);
		ListNode l3 = new ListNode(14);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(-3);
		ListNode l6 = new ListNode(1);
		ListNode l7 = new ListNode(8);
		ListNode l8 = new ListNode(5);
		ListNode l9 = new ListNode(11);
		ListNode l10 = new ListNode(15);
		
		l1.next = l2; l2.next = l3; l3.next = l4;
		l4.next = l5;
		
		LCSortList lc = new LCSortList();
		Solution sl = lc.new Solution();
		ListNode result = sl.sortList(l1);
	}
	
	public class Solution {
	    private int getLen(ListNode head) {
	        ListNode p = head;
	        int result = 0;
	        while (p != null) {
	            result ++;
	            p = p.next;
	        }
	        return result;
	    }
	    
	    private ListNode sortList(ListNode head, int len) {
	        if (head == null || head.next == null) return head;
	        int leftLen = (len + 1) / 2;
	        ListNode leftHead = head, leftTail = head, rightHead;
	        for (int i = 0; i < leftLen - 1; i ++) {
	            leftTail = leftTail.next;
	        }
	        rightHead = leftTail.next;
	        leftTail.next = null;
	        leftHead = sortList(leftHead, leftLen);
	        rightHead = sortList(rightHead, len - leftLen);
	        
	        ListNode dummyHead = new ListNode(0), p = dummyHead;
	        while (rightHead != null || leftHead != null) {
	            if (leftHead == null || (leftHead != null && rightHead != null && leftHead.val >= rightHead.val)) {
	                p.next = rightHead;
	                p = p.next;
	                rightHead = rightHead.next;
	            }
	            else if (rightHead == null || (leftHead != null && rightHead != null && leftHead.val <= rightHead.val)) {
	                p.next = leftHead;
	                p = p.next;
	                leftHead = leftHead.next;
	            }
	        }
	        return dummyHead.next;
	    }
	    
	    public ListNode sortList(ListNode head) {
	        int len = getLen(head);
	        return sortList(head, len);

	    }
	}
}
