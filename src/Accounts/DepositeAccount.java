package Accounts;

import Banks.Bank;
import Entities.Client;
import Models.Cancelling;
import Models.InterestAccounts;

public class DepositeAccount extends InterestAccounts {
    private double interestRate; // процентная ставка
    private Cancelling cancelling;
    private int period;


    public DepositeAccount(Client owner, double initialAmount, Bank bank, int period) {
        super(owner, bank);
        balance = initialAmount;
        this.period = period;
        if (initialAmount <= 50000){
            interestRate = 3;
        }
        if (initialAmount <= 100000 && initialAmount > 50000){
            interestRate = 3.5;
        }
        if (initialAmount > 100000){
            interestRate = 4;
        }
    }
    public int getPeriod() {
        return period;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Cannot withdraw from Deposit Models.Account");
    }
    @Override
    public void sendMoney(int id, double amount) {
        if (period != 0) {
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
    public void ReduceThePeriod(){
        period--;
    }

    public void interestCalculation() {
        this.monthlyInterest = balance * (1 + interestRate/365);
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

