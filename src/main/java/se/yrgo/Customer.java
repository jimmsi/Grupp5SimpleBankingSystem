package se.yrgo;

import java.util.ArrayList;

public class Customer {

    private int customerID;
    private String name;
    private String adress;
    private String email;
    private ArrayList<Account> accountList;

    public Customer(int customerID, String name, String adress, String email) {
        this.customerID = customerID;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.accountList = null;
    }
    /**
     * Adds an {@link Account} to this customer's list of accounts. If the customer's
     * account list is null, a new list is created and the account is added to it.
     *
     * @param account the {@link Account} to be added to the customer's account list
     */
    public void addAccount (Account account) {
        if (this.accountList == null) {
            this.accountList = new ArrayList<>();
        }
        this.accountList.add(account);
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    /**
     * Returns a string representation of the customer, including customer ID, name, address, email,
     * and a list of accounts associated with the customer. Each account in the list is represented by
     * its string representation.
     *
     * @return a string representation of the customer and their accounts
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer {");
        sb.append("customerID = ").append(customerID);
        sb.append(", name = '").append(name).append('\'');
        sb.append(", adress = '").append(adress).append('\'');
        sb.append(", email = '").append(email).append('\'');
        sb.append(", accountList = [");

        for (int i = 0; i < accountList.size(); i++) {
            sb.append(accountList.get(i).toString());
            if (i < accountList.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]}");
        return sb.toString();
    }

}


