package Accounts;

import Banks.Bank;
import Entities.Client;
import Models.Cancelling;
import Models.ComissionAccounts;

public class CreditAccount extends ComissionAccounts {
    private double creditLimit; // кредитный лимит, в рамках которого можно уходить в минус
    private double commission; // фиксированная комиссия за использование, если клиент в минусе
    private Cancelling cancelling;

    public CreditAccount(Client owner, double creditLimit, double commission, Bank bank) {
        super(owner, bank);
        this.creditLimit = creditLimit;
        this.commission = commission;
    }

    @Override
    public void deposit(double amount) {
        cancelling = new Cancelling(-1, this.balance, true);
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + creditLimit >= amount) {
            cancelling = new Cancelling(-1, this.balance, false);
            balance -= amount;
        }
        else {
            System.out.println("Exceeds credit limit");
        }
    }

    public void sendMoney(int id, double amount) {
        if (balance + creditLimit < amount) {
            System.out.println("Exceeds credit limit");
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

    public void CommissionCalculation() {
        if (balance < 0) {
            balance -= commission;
        }
    }
    public void Cancelling() {
        if (cancelling.id != -1) {
            if (cancelling.sign) {
                sendMoney(cancelling.id, balance-cancelling.balance);
            }
            else {
                bank.findAccount(cancelling.id).sendMoney(this.id, cancelling.balance-balance);
            }
        }
        balance = cancelling.balance;
    }
}
