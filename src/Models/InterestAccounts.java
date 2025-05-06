package Models;

import Banks.Bank;
import Entities.Client;

public abstract class InterestAccounts extends Account {
    public InterestAccounts(Client owner, Bank bank) {
        super(owner, bank);
    }

    public abstract void interestCalculation();
}
