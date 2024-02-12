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

    public void addAccount (Account account) {
        if (this.accountList == null) {
            this.accountList = new ArrayList<>(); // Skapa listan första gången ett konto läggs till
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


