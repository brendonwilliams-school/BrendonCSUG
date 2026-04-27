
public class TestBankAccount {
    public static void main(String[] args) {

        CheckingAccount checking = new CheckingAccount();

        checking.setFirstName("Brendon");
        checking.setLastName("Williams");
        checking.setAccountID(123456);
        checking.setInterestRate(2.5);

        checking.deposit(500.00);

        System.out.println("Initial Account Information:");
        checking.displayAccount();

        System.out.println();

        System.out.println("Processing withdrawal of $600.00...");
        checking.processWithdrawal(600.00);

        System.out.println();

        System.out.println("Updated Account Information:");
        checking.displayAccount();
    }
}