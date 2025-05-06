package Models;

import Banks.Bank;
import Entities.Client;

public abstract class ComissionAccounts extends Account {
    public ComissionAccounts(Client owner, Bank bank) {
        super(owner, bank);
    }
    public abstract void CommissionCalculation();
}
