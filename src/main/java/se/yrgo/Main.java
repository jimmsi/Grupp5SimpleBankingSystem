package se.yrgo;

import static se.yrgo.Transaction.transactionList;
//Test för jenkins
public class Main {
    public static void main(String[] args) {
        //Nya konton

        Account acc1 = new Account("23534643", 800);
        Account acc2 = new Account("23534642", 1000);

        Customer cust = new Customer(1, "Jimmy", "Gatan 1", "jim@gmail.com");
        cust.addAccount(acc1);
        cust.addAccount(acc2);

        //Nya transaktioner
        Transaction t1 = new Transaction("2024-02-12", "withdraw", 400, acc1);
        Transaction t2 = new Transaction("2024-02-12", "deposit", 300, acc1);
        Transaction t3 = new Transaction("2024-02-12", "transfer", 300, acc1, acc2);

        System.out.println(acc1);
        System.out.println(acc2);

        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }

        System.out.println(cust);

    }
}
