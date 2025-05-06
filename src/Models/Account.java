package Models;
import Banks.Bank;
import Entities.Client;

public abstract class Account {
    protected Client owner;
    public double balance;
    protected double interestRate = 0; // процентная ставка
    protected double monthlyInterest = 0; //все, что накапало за месяц
    public int id;
    protected Bank bank;
    static int currentID;
    private Cancelling cancelling;

    public Account(Client owner, Bank bank) {
        this.owner = owner;
        this.balance = 0;
        this.id = Account.currentID++;
        this.bank = bank;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    public abstract void deposit(double amount); //внесение
    public abstract void withdraw(double amount); //изъятие
    public abstract void sendMoney(int id, double amount);
    public abstract void getMoney(int id, double amount);
}


