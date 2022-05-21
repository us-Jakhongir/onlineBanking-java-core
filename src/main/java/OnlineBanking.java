import java.util.Scanner;

public class OnlineBanking {

    public static String firstname;
    public static String lastname;
    public static String cardNumber;
    public static double balance;       // static
    public static String lastOperation = "";

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*
           1. Hisobni tekshirish
           2. Hisobga pul qo'yish
           3. Hisobdan pul yechish
           4. Oxirgi operatsiya
         */
        loadUserData(); // void method
        while (true) {
            showMenu();
            int index = scanner.nextInt();
            switch (index) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    addMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    lastOperation();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Incorrect operation!\n");
            }

        }

    }

    private static void lastOperation() {
        System.out.println("Last operation: " + lastOperation);
    }
    private static void setLastOperation(String lastOperationName) {
        lastOperation = lastOperationName;
    }

    private static void withdrawMoney() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        if(amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdraw!\n");
        } else {
            System.out.println("Not enough money!\n");
        }

        setLastOperation("Withdraw money: " + amount + " - Card balance: " + balance);

    }

    private static void addMoney() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Added!\n");

        setLastOperation("Add money: " + amount + " - Card balance: " + balance);
    }



    private static void checkBalance() {
        System.out.println("Your current balance $" + balance + "\n");

        setLastOperation("Check balance");
    }

    public static void showMenu() {
        System.out.println("Choose the option: ");
        System.out.println("1. Check balance");
        System.out.println("2. Add money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Last operation");
        System.out.println("5. Exit");
        System.out.print("Index: ");
    }

    public static void loadUserData() {
        System.out.print("Firstname: ");
        firstname = scanner.next();

        System.out.print("Lastname: ");
        lastname = scanner.next();

        System.out.print("Card Number: ");
        cardNumber = scanner.next();

        System.out.print("Initial balance: ");
        balance = scanner.nextDouble();
        System.out.println("Welcome to Online Banking! Mr. " + firstname + " " + lastname);
    }


}









