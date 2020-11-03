package accounts;

public class Account {
    private int balance = 200000;

    public int getBalance() {
        return balance;
    }
    public void withdraw(int amount) {
        balance = balance - amount;
    }
}
