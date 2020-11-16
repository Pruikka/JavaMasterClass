package petrihannonen;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

        if (bank.addNewBranch("Adelaide")) {
            System.out.println("Adelaide branch created");
        }

        bank.addNewBranch("Adelaide");
        bank.addNewCustomerToBranch("Petri", "Adelaide", 50.05);
        bank.addNewCustomerToBranch("Mike", "Adelaide", 175.34);
        bank.addNewCustomerToBranch("Percy", "Adelaide", 220.12);

        bank.addNewBranch("Sydney");
        bank.addNewCustomerToBranch("Piia", "Sydney", 150.54);

        bank.addCustomerTransaction("Adelaide", "Petri", 44.22);
        bank.addCustomerTransaction("Adelaide", "Petri", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
        bank.listCustomers("Sydney", true);

        bank.addNewBranch("Melbourne");
        if (!bank.addNewCustomerToBranch("Brian", "Melbourne", 5.53)) {
            System.out.println("Error Melbourne branch does not exist");
        }

        if (!bank.addNewBranch("Adelaide")) {
            System.out.println("Adelaide branch already exists");
        }

        if (!bank.addCustomerTransaction("Adelaide", "Fergus", 52.44)) {
            System.out.println("Customer Fergus does not exist");
        }

        if (!bank.addNewCustomerToBranch("Petri", "Adelaide", 12.21)) {
            System.out.println("Customer Petri already exists");
        }

    }
}
