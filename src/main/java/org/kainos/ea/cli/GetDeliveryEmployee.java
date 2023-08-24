package org.kainos.ea.cli;

public class GetDeliveryEmployee {
    public GetDeliveryEmployee(String name, double salary, String bankAccountNumber, String nationInsuranceNumber) {
        this.name = name;
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
    private double salary;
    private String bankAccountNumber;
    private String nationInsuranceNumber;
}
