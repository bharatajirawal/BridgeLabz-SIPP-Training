class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println(accountHolder + "'s Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Alice", "1234567890", 5000);
        acc.deposit(2000);
        acc.withdraw(1000);
        acc.displayBalance();
    }
}
