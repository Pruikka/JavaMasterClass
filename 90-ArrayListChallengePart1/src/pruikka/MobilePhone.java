package petrihannonen;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists.");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getName() + " was not found");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not succesful.");
            return false;
        }
        this.contacts.set(position, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.contacts.remove(position);
        System.out.println(contact.getName() + " was removed");
        return true;
    }

    private int findContact(Contacts contact) {
        return contacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < this.contacts.size(); i++) {
            if (this.contacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.contacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact list:");
        for (int i = 0; i < this.contacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                                this.contacts.get(i).getName() + " -> " +
                                this.contacts.get(i).getPhoneNumber());
        }
    }
}
