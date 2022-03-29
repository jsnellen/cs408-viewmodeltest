package edu.jsu.mcis.cs408.viewmodeltest;

public class Customer {

    private String firstname;
    private String middlename;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Customer(String[] fields) {
        this.firstname = fields[0];
        this.middlename = fields[1];
        this.lastname = fields[2];
        this.address = fields[3];
        this.city = fields[4];
        this.state = fields[5];
        this.zip = fields[6];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(firstname).append(" ").append(lastname).append("\n");
        s.append(address).append("\n");
        s.append(city).append(", ").append(state).append(" ").append(zip).append("\n\n");
        return s.toString();
    }

}