package insertionsortlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void print(String msg) {
            System.out.println(msg);
            ListNode aux = this;
            while (aux != null) {
                    System.out.print(aux.val);
                    if (aux.next != null) System.out.print(" -> ");
                    aux = aux.next;
            }
            System.out.println();
            System.out.println();
    }
}
