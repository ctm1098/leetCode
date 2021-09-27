package insertionsortlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode tail = head, 
                 node = tail.next,
                 move = head,
                 aux = head;

        while (node != null) {
            if (move.val < node.val) {
                aux = move;
                move = move.next;
            }
            else {
                if (move == node) tail = node;
                else {
                    tail.next = node.next;
                    node.next = move;
                    if (move == head)
                        head = node;
                    else
                        aux.next = node;
                }
                move = head;
                node = tail.next;
            }
        }
        return head;
    }
}

