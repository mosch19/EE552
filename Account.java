/*
    Java Beans require blank constructor, set/get methods, serializable?
*/
class Account {
    
    private double balance;

    Account() { this(0); }

    Account(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if(balance < amount) {
            return false;
        } else {
            return true;
        }
    }

    public double getBalance() {
        return balance;
    }
}
