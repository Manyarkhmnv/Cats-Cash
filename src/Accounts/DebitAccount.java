package Accounts;

import Banks.Bank;
import Entities.Client;
import Models.Cancelling;
import Models.InterestAccounts;

public class DebitAccount extends InterestAccounts {
    private Cancelling cancelling;

    public DebitAccount(Client owner, double interestRate, Bank bank) {
        super(owner, bank);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        cancelling = new Cancelling(-1, this.balance, true);
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            cancelling = new Cancelling(-1, this.balance, false);
            balance -= amount;
        } else {
            System.out.println("Not enough money to withdraw");
        }
    }
    public void interestCalculation(){
        this.monthlyInterest = balance * (1 + interestRate/365);
    }
    @Override
    public void sendMoney(int id, double amount) {
        if (balance-amount  < 0) {
            System.out.println("Not enough money to withdraw");
            return;
        }
        cancelling = new Cancelling(id, this.balance, false);
        bank.findAccount(id).getMoney(this.id, amount);
        balance -= amount;
    }
    @Override
    public void getMoney(int id, double amount) {
        cancelling = new Cancelling(id, this.balance, true);
        balance += amount;
    }
    public void Cancelling() {
        if (cancelling.id != -1) {
            if (cancelling.sign) {
                bank.findAccount(cancelling.id).balance += balance-cancelling.balance;
                balance -= balance-cancelling.balance;
            }
            else {
                bank.findAccount(cancelling.id).balance -= balance-cancelling.balance;
                balance += balance-cancelling.balance;            }
        }
        balance = cancelling.balance;
    }
}
