package org.kainos.ea.cli;

public class DeliveryEmployeeRequest {
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
