package Bank;
// EXECUTION:
// C:\>java BankApp
public class BankApp {

    public static void main(String[] args) {
        // OBJECTS:
        // records are usually represented 
        // by objects of an appropriate class.
        // object contains both methods and variables. 
        Account test = new Account(10.00);
        test.withdraw(5);
    }
}
