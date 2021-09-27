package sortlist;

class Solution {
    
    private int size(ListNode head) {
        int len = 0;
        ListNode aux = head;
        for(;aux!=null;len++) aux = aux.next;
        return len;
    }
    
    private ListNode cut(ListNode head, int limit) {
        ListNode aux = head, ret;
        for(int idx = 1;idx != limit;idx++) 
            aux = aux.next;
        ret = aux.next;
        aux.next = null;
        return ret;
    }
    
    private ListNode solve(ListNode head) {
        ListNode ret = head;
        if (head.next != null && head.val > head.next.val) {
            ret = head.next;
            ret.next = head;
            head.next = null;
        }
        return ret;
    }
    
    private void connect(ListNode prevLeft, ListNode left, ListNode right) {
        if (left == null && prevLeft != null) prevLeft.next = right;
        else {
            while (left != null && left.next != null) left = left.next;
            if (left != null) left.next = right;
        }
    }
    
    private ListNode combine(ListNode left, ListNode right) {
        ListNode head = left, prevLeft = null, aux;
        while (left != null && right != null) {
            if (left.val < right.val) {
                prevLeft = left;
                left = left.next;
            }
            else if (left.val == right.val) {
                aux = right.next;
                right.next = left.next;
                left.next = right;
                prevLeft = left;
                right = aux;
            }
            else {
                ListNode move = right;
                right = right.next;
                if (prevLeft == null) {
                    head = move;
                    prevLeft = head;
                }
                else {
                    prevLeft.next = move;
                    prevLeft = move;
                }
                move.next = left;
            }
        }
        connect(prevLeft,prevLeft,right);
        return head;
    }

    private ListNode sort(ListNode head, int limit) {
        if (limit <= 2)
            return solve(head);
        else {
            int odd = (limit%2==1 ? 1 : 0);
            limit /= 2;
            ListNode head2 = cut(head,limit),
                     left = sort(head,limit),
                     right = sort(head2,limit+odd);
            return combine(left,right);
        }
    }
    
    public ListNode sortList(ListNode head) {
        int len = size(head);
        if (len == 0) return null;
        return sort(head,len);
    }
}
