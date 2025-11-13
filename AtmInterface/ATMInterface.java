package AtmInterface;


public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}