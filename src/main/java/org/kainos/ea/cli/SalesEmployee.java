package org.kainos.ea.cli;

public class SalesEmployee extends Employee {

    private double commissionRate;

    public SalesEmployee(int id, String name, double salary, String bankAccountNumber, String nationInsuranceNumber, double commissionRate) {
        super(id, name, salary, bankAccountNumber, nationInsuranceNumber);
        setCommissionRate(commissionRate);
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
