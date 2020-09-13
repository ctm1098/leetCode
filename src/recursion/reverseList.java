package recursion;

public class reverseList {
	
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	/* Time -> O(n)
	 * Space -> O(1) */
	public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode last = head, node = head.next;
        while (node != null) {
            last.next = node.next;
            node.next = head;
            head = node;
            node = last.next;
        }
        return head;
    }
	
	/* Time -> O(n)
	 * Space -> O(n) */
	public ListNode recursion(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode new_head = recursion(head.next);
		head.next.next = head;
		head.next = null;
		return new_head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
