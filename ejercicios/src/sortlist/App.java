//148

package sortlist;

import java.util.Random;
import java.util.Scanner;

/**
    Given the head of a linked list, return the list after sorting it in ascending order.

    Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */

public class App {
    private static Random r;
    private static long max;

    public static int readInt(Scanner scan, String s, boolean rand) {
        System.out.print(s);
        int value;
        if (!rand) {
            value = scan.nextInt();
            scan.nextLine();
        }
        else {
            value = r.nextInt((int)max);
            if (Math.random() >= 0.7) value = 0 - value;
            System.out.println(value);
        }
        return value;
    }

    public static boolean askForRandomGeneration(Scanner scan) {
        System.out.print("Random generation? [Y/N]: ");
        boolean rand = scan.nextLine().equals("Y");
        if (rand) {
            r = new Random();
            max = readInt(scan, "Max element value (up to 2^32 - 1): ", false);
            while (max > Integer.MAX_VALUE) {
                System.out.println("Max value too big... Please try again");
                max= readInt(scan, "Max element value (up to 2^32 - 1): ", false);
            }
        }
        return rand;
    }

    private static ListNode generateList(int len, Scanner scan, boolean rand) {
        int value = readInt(scan, "Value: ",rand);
        ListNode head = new ListNode(value), node = head;

        for (int i = 1; i < len; i++) {
            value = readInt(scan, "Value: ",rand);
            node.next = new ListNode(value);
            node = node.next;
        }
        System.out.println();

        return head;
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        boolean rand = askForRandomGeneration(scan);

        int len = readInt(scan, "Integer list length: ",false);

        if (len > 0) {
            
            ListNode head = generateList(len, scan, rand);

            head.print("Original list:");

            if (len > 1) {
                Solution s = new Solution();
                head = s.sortList(head);
            }

            head.print("Sorted list");
        }

    }
}

