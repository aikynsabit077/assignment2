import java.util.*;

class BankAccount {
    int id;
    String name;
    double balance;

    BankAccount(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
}

public class Main {

    static LinkedList<BankAccount> list = new LinkedList<>();
    static Stack<String> stack = new Stack<>();
    static Queue<String> queue = new LinkedList<>();
    static Queue<BankAccount> req = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BankAccount[] arr = {
                new BankAccount(1, "Kyttysh", 100000),
                new BankAccount(2, "Aikyn", 200000),
                new BankAccount(3, "Dimash", 150000)
        };

        for (BankAccount a : arr) {
            System.out.println(a.name + " " + a.balance);
        }

        while (true) {
            System.out.println("1.Bank 2.ATM 3.Admin 4.Exit");
            int c = sc.nextInt();

            if (c == 1) bank();
            else if (c == 2) atm();
            else if (c == 3) admin();
            else break;
        }
    }

    static void bank() {
        System.out.println("1.add req 2.deposit 3.withdraw");
        int c = sc.nextInt(); sc.nextLine();

        if (c == 1) {
            System.out.print("name: ");
            String n = sc.nextLine();
            req.add(new BankAccount(0, n, 0));
        }
        else if (c == 2) {
            BankAccount a = find();
            if (a != null) {
                double x = sc.nextDouble();
                a.balance += x;
                stack.push("dep " + x);
            }
        }
        else if (c == 3) {
            BankAccount a = find();
            if (a != null) {
                double x = sc.nextDouble();
                if (a.balance >= x) {
                    a.balance -= x;
                    stack.push("with " + x);
                }
            }
        }
    }

    static void atm() {
        BankAccount a = find();
        if (a != null) {
            System.out.println("1.balance 2.withdraw");
            int c = sc.nextInt();
            if (c == 1) System.out.println(a.balance);
            else {
                double x = sc.nextDouble();
                if (a.balance >= x) a.balance -= x;
            }
        }
    }

    static void admin() {
        System.out.println("1.process req 2.queue 3.add bill 4.process bill 5.history");
        int c = sc.nextInt(); sc.nextLine();

        if (c == 1 && !req.isEmpty()) {
            BankAccount a = req.poll();
            a.id = list.size() + 1;
            list.add(a);
        }
        else if (c == 2) System.out.println(queue);
        else if (c == 3) queue.add(sc.nextLine());
        else if (c == 4 && !queue.isEmpty()) System.out.println(queue.poll());
        else if (c == 5 && !stack.isEmpty()) System.out.println(stack.peek());
    }

    static BankAccount find() {
        System.out.print("name: ");
        String n = sc.next();
        for (BankAccount a : list) {
            if (a.name.equals(n)) return a;
        }
        System.out.println("not found");
        return null;
    }
}
