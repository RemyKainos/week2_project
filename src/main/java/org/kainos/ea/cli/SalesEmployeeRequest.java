package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest {
    private String name;
    private Double salary;
    private String bankAccountNumber;
    private String nationInsuranceNumber;

    public double getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(double commission_rate) {
        this.commission_rate = commission_rate;
    }

    private double commission_rate;


    @JsonCreator
    public SalesEmployeeRequest(
            @JsonProperty("name") String name,
            @JsonProperty("salary") double salary,
            @JsonProperty("bankAccountNumber") String bankAccountNumber,
            @JsonProperty("nationInsuranceNumber") String nationInsuranceNumber,
            @JsonProperty("commission_rate") double commission_rate
    ) {

        this.name = name;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nationInsuranceNumber = nationInsuranceNumber;
        this.commission_rate = commission_rate;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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
}
