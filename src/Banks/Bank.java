package Banks;

import Accounts.CreditAccount;
import Accounts.DebitAccount;
import Accounts.DepositeAccount;
import Entities.Client;
import Models.Account;
import Models.InterestAccounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;
    private HashMap<Integer, Account> accountMap;
    private List<CreditAccount> creditAccounts;
    private List<InterestAccounts> interestAccounts;
    private double interestRate; // процентная ставка
    private double creditLimit; // кредитный лимит для кредитных счетов
    private double comission; // комиссия за использование для кредитных счетов
    private List<Client> subscribers;
    private CentralBank centralBank;


    public Bank(String name, double interestRate, double creditLimit, double comission, CentralBank centralBank) {
        this.interestRate = interestRate;
        accounts = new ArrayList<>();
        this.creditLimit = creditLimit;
        this.comission = comission;
        this.name = name;
        this.subscribers = new ArrayList<>();
        this.accountMap = new HashMap<>();
        this.creditAccounts = new ArrayList<>();
        this.interestAccounts = new ArrayList<>();
        this.centralBank = centralBank;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
        notifySubscribers("Interest rate was updated \n");
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
        notifySubscribers("Credit limit was updated \n");
    }

    public String getName(){
        return this.name;
    }
    public List<Account> getAccounts(){
        return this.accounts;
    }
    public void subscribe(Client client){
        this.subscribers.add(client);
    }
    public void unsubscribe(Client client){
        this.subscribers.remove(client);
    }
    public void notifySubscribers(String message){
        for(Client client : subscribers){
            client.notifyClient(message);
        }
    }
    public Account findAccount(int id) {
        if(!accountMap.containsKey(id)) {
            return centralBank.FindAccount(id);
        }
        else {
            return accountMap.get(id);
        }
    }

    public DebitAccount createDebitAccount(Client client) {
        DebitAccount account = new DebitAccount(client, interestRate, this);
        accounts.add(account);
        interestAccounts.add(account);
        accountMap.put(account.id, account);
        return account;
    }

    public DepositeAccount createDepositAccount(Client client, double initialAmount, int period) {
        DepositeAccount account = new DepositeAccount(client, initialAmount, this, period);
        accounts.add(account);
        interestAccounts.add(account);
        accountMap.put(account.id, account);
        return account;
    }

    public CreditAccount createCreditAccount(Client client) {
        CreditAccount account = new CreditAccount(client, creditLimit, comission, this);
        accounts.add(account);
        creditAccounts.add(account);
        accountMap.put(account.id, account);
        return account;
    }

    public void interestPayment() {
        for (InterestAccounts account : interestAccounts) {
            account.balance = account.getMonthlyInterest();
        }
    }
    public void CommissionCalculation() {
        for (CreditAccount account : creditAccounts) {
            account.CommissionCalculation();
        }
    }
}

