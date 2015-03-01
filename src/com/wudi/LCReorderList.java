package com.wudi;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LCReorderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		LCReorderList lc = new LCReorderList();
		lc.new Solution().reorderList(node1);
	}

	class Solution {
	    private ListNode head1, head2;
	    int len = 0;
	    
	    private void calcLen(ListNode head) {
	        ListNode now = head;
	        while (now != null) {
	            len ++;
	            now = now.next;
	        }
	    }
	    
	    private void separate(ListNode head) {
	        head1 = head;
	        ListNode now = head1;
	        for (int i = 1; i <= (len-1)/2; i ++) now = now.next;
	        head2 = now.next;
	        now.next = null;
	    }
	    
	    private void revHead2() {
	        ListNode l = head2, r = l.next;
	        l.next = null;
	        ListNode nextR = null;
	        while (r != null) {
	            nextR = r.next;
	            r.next = l;
	            l = r;
	            r = nextR;
	        }
	        head2 = l;
	    }
	    
	    private void build() {
	        ListNode now1 = head1, now2 = head2, nextNow2;
	        while (now2 != null) {
	            nextNow2 = now2.next;
	            now2.next = now1.next;
	            now1.next = now2;
	            now1 = now1.next.next;
	            now2 = nextNow2;
	        }
	    }
	    
	    public void reorderList(ListNode head) {
	        if (head == null || head.next == null) return;
	        calcLen(head);
	        separate(head);
	        revHead2();
	        build();
	    }
	}
}
