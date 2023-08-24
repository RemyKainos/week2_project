package org.kainos.ea.cli;

public class DeliveryEmployee extends Employee {

    public DeliveryEmployee(int id, String name, double salary, String bankAccountNumber, String nationInsuranceNumber) {
        super(id, name, salary, bankAccountNumber, nationInsuranceNumber);

    public DeliveryEmployee(String name, int id, double salary, String bankAccountNumber, String nationInsuranceNumber) {
        super(name, id, salary, bankAccountNumber, nationInsuranceNumber);

    }
}
