package Models;

public class Cancelling {
    public int id = -1;
    public double balance = 0;
    public boolean sign = true; // - false; + true
    public Cancelling(int id, double balance, boolean sign) {
        this.id = id;
        this.balance = balance;
        this.sign = sign;
    }
}
