package petrihannonen;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printOptions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();

                case 6:
                    printOptions();
                    break;
            }
        }
    }

    public static void startPhone() {
        System.out.println("Starting phone...");
    }

    public static void printOptions() {
        System.out.println("Options:");
        System.out.println("\t 0 - Shutdown\n" +
                            "\t 1 - Print list of contacts\n" +
                            "\t 2 - Add new contact\n" +
                            "\t 3 - Update existing contact\n" +
                            "\t 4 - Remove contact\n" +
                            "\t 5 - Find contact\n" +
                            "\t 6 - Print options\n");
        System.out.println("Choose your action: ");
    }

    private static void addNewContact() {
        System.out.print("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String phoneNumber = scanner.nextLine();

        Contacts newContact = Contacts.createContact(name, phoneNumber);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: " + name + ", phone: " + phoneNumber);
        } else {
            System.out.println("Cannot add. " + name + " is already on file.");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContact =mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String newNumber = scanner.nextLine();

        Contacts newContact = Contacts.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Contact succesfully updated");
        } else {
            System.out.println("Error updating contact");
        }
    }

    public static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContact)) {
            System.out.println("Contact succesfully removed");
        } else {
            System.out.println("Error removing contact");
        }
    }

    public static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Name: " + existingContact.getName() + ", Phone: " + existingContact.getPhoneNumber());
        }
    }
}
