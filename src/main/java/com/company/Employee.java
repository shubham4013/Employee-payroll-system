package com.company;

public class Employee {
    int id;
    String name, department;
    double basicSalary, hra, allowances, deductions, netSalary;

    public Employee(String name, String department, double basicSalary) {
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public void calculateSalary() {
        this.hra = 0.2 * basicSalary;
        this.allowances = 0.1 * basicSalary;
        this.deductions = 0.05 * basicSalary;
        this.netSalary = basicSalary + hra + allowances - deductions;
    }
}
