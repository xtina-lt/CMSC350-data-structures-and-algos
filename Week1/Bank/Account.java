package Bank;

// CLASS: is a specification—a blueprint—for one or more objects. 
public class Account {
    private double balance;

    // Constructor
    // which is a special method that’s called automatically 
    // whenever a new object is created. 
    public Account(double balance){
        this.balance = balance;
    }

    // MUTATORS = setters
    public double deposit(double amount){
        return this.balance += amount;
    }
    public double withdraw(double amount){
        this.getBalance();
    if (balance > amount) {
        this.balance -= amount;
        System.out.println("Successfull withdrawl");
    } else {
        System.out.println("Insufficient funds.");
    }
        this.getBalance();
        return this.balance;
    }

    // ACCESSORS = getters
    public double getBalance(){
        System.out.printf("Balance: $%.2f\n", balance);
        return balance;
    }

}
