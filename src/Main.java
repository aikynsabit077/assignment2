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

        // Task 6 (array)
        BankAccount[] arr = {
                new BankAccount(1, "Kyttysh", 100000),
                new BankAccount(2, "Aikyn", 200000),
                new BankAccount(3, "Dimash", 150000)
        };
        for (BankAccount a : arr) {
            list.add(a);
            System.out.println(a.name + " " + a.balance);
        }
        // Main menu
        while (true) {
            System.out.println("1.Bank 2.ATM 3.Admin 4.Exit");
            int c = sc.nextInt();

            if (c == 1) bank();
            else if (c == 2) atm();
            else if (c == 3) admin();
            else break;
        }
    }
    // Task 1 (LinkedList Accounts)
    static void showAccounts() {
        for (BankAccount a : list) {
            System.out.println(a.id + ". " + a.name + " - " + a.balance);
        }
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
    // Task 2 (Deposit & Withdraw)
    static void deposit() {
        BankAccount a = find();
        if (a != null) {
            double x = sc.nextDouble();
            a.balance += x;
            stack.push("Deposit " + x + " to " + a.name);
        }
    }
    static void withdraw() {
        BankAccount a = find();
        if (a != null) {
            double x = sc.nextDouble();
            if (a.balance >= x) {
                a.balance -= x;
                stack.push("Withdraw " + x + " from " + a.name);
            }
        }
    }
    //Task 3 (Stack - History)
    static void showLastTransaction() {
        if (!stack.isEmpty())
            System.out.println(stack.peek());
    }
    static void undoTransaction() {
        if (!stack.isEmpty())
            System.out.println("Undo: " + stack.pop());
    }
    //Task 4 (Queue - Bills)
    static void addBill() {
        String bill = sc.nextLine();
        queue.add(bill);
    }
    static void processBill() {
        if (!queue.isEmpty())
            System.out.println(queue.poll());
    }
    static void showBills() {
        for (String q : queue) {
            System.out.println(q);
        }
    }
    // Task 5 (Account Requests Queue)
    static void addRequest() {
        System.out.print("name: ");
        String n = sc.nextLine();
        req.add(new BankAccount(0, n, 0));
    }
    static void processRequest() {
        if (!req.isEmpty()) {
            BankAccount a = req.poll();
            a.id = list.size() + 1;
            list.add(a);
        }
    }
    static void bank() {
        System.out.println("1.add req 2.deposit 3.withdraw 4.show");
        int c = sc.nextInt(); sc.nextLine();

        if (c == 1) addRequest();
        else if (c == 2) deposit();
        else if (c == 3) withdraw();
        else if (c == 4) showAccounts();
    }
    static void atm() {
        BankAccount a = find();
        if (a != null) {
            System.out.println("1.balance 2.withdraw");
            int c = sc.nextInt();

            if (c == 1) System.out.println(a.balance);
            else {
                double x = sc.nextDouble();
                if (a.balance >= x) {
                    a.balance -= x;
                    stack.push("ATM Withdraw " + x + " from " + a.name);
                }
            }
        }
    }
    static void admin() {
        System.out.println("1.process req 2.queue 3.add bill 4.process bill 5.history 6.undo");
        int c = sc.nextInt(); sc.nextLine();

        if (c == 1) processRequest();
        else if (c == 2) showBills();
        else if (c == 3) addBill();
        else if (c == 4) processBill();
        else if (c == 5) showLastTransaction();
        else if (c == 6) undoTransaction();
    }
}