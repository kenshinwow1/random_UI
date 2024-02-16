import java.util.Scanner;

class User {
    private String pin;
    private double balance;

    public User(String pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Депозит успешно проведен. Новый баланс: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Снятие успешно проведено. Новый баланс: " + balance);
        } else {
            System.out.println("Недостаточно средств на счете.");
        }
    }

    public void showStatement() {
        System.out.println("Баланс: " + balance);
        // Добавьте здесь код для вывода выписки по операциям, если это необходимо
    }
}



