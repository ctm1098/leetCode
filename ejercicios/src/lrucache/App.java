package lrucache;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LRUCache cache;
        Scanner scan = new Scanner(System.in);

        System.out.print("Capacity: ");
        int cap = scan.nextInt();
        scan.nextLine(); //consumes "\n"
        
        cache = new LRUCache(cap);
        
        System.out.println();
        System.out.println("Supported operations (values MUST be integers):");
        System.out.println("put [k,v]");
        System.out.println("get k");
        System.out.println("print");
        System.out.println("exit");
        System.out.println("-------- START --------");
        
        String op = scan.nextLine();
        int key, value;
        while (!op.equals("exit")) {
            if (!op.matches("^put \\[[0-9]+,[0-9]+\\]$") && !op.matches("^get [0-9]+$") && !op.matches("^print$"))
                System.out.println("Excuse me, I don't understand. Try again...");

            else if (op.matches("^put .+")) {
                key = Integer.valueOf(op.split(" ")[1].split(",")[0].substring(1));
                value = Integer.valueOf(op.split(" ")[1].split(",")[1].split("]")[0]);
                cache.put(key, value);
                System.out.println("Pair ["+key+","+value+"] put into cache");
            }

            else if (op.matches("^get .+")) {
                key = Integer.valueOf(op.split(" ")[1]);
                int val = cache.get(key);
                System.out.println("Retrieved value for key: " + val);
            }

            else
                cache.print();

            System.out.println();

            op = scan.nextLine();
        }
        scan.close();
    }
}
