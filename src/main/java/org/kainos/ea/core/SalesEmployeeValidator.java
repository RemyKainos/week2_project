package org.kainos.ea.core;

import org.kainos.ea.cli.SalesEmployeeRequest;

public class SalesEmployeeValidator {
    public String isValidSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) {
        if (salesEmployeeRequest.getName().length() > 70) {
            return "Name is greater than 70 characters";
        }
        if (salesEmployeeRequest.getBankAccountNumber().length() > 34) {
            return "bank account number is greater than 34 characters";
        }
        if (salesEmployeeRequest.getNationInsuranceNumber().length() > 9) {
            return "National insurance number greater than 9";
        }

        return null;
    }
}
