package org.kainos.ea.cli;

public class Employee {
    public Employee(String name, int id, double salary, String bankAccountNumber, String nationInsuranceNumber) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nationInsuranceNumber = nationInsuranceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getNationInsuranceNumber() {
        return nationInsuranceNumber;
    }

    public void setNationInsuranceNumber(String nationInsuranceNumber) {
        this.nationInsuranceNumber = nationInsuranceNumber;
    }

    private String name;
    private int id;
    private double salary;
    private String bankAccountNumber;
    private String nationInsuranceNumber;
}
