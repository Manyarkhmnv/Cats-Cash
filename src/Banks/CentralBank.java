package Banks;

import Models.Account;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private List<Bank> banks;
    public CentralBank() {
        banks = new ArrayList<Bank>();
    }

    public Bank CreateBank(String name, double interestRate, double creditLimit, double comission) {
        Bank bank = new Bank(name, interestRate, creditLimit, comission, this);
        banks.add(bank);
        return bank;
    }
    public void NoticeForCommission(){
        for (Bank bank : banks) {
            bank.CommissionCalculation();
        }
    }
    public void NoticeForInterest() {
        for (Bank bank : banks) {
            bank.interestPayment();
        }
    }
    public Account FindAccount(int id) {
        for (Bank bank : banks) {
            return bank.findAccount(id);
        }
        return null;
    }


}
