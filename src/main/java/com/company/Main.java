package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        PayrollService payroll = new PayrollService();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            switch(ch) {
                case 1:
                    System.out.print("Enter Employees Name: "); String name = sc.nextLine();
                    System.out.print("Department: "); String dept = sc.nextLine();
                    System.out.print("Basic Salary: "); double basic = Double.parseDouble(sc.nextLine());
                    Employee e = new Employee(name, dept, basic);
                    payroll.process(e);
                    dao.addEmployee(e);
                    System.out.println("Added ! Net Salary: " + e.netSalary);
                    System.out.println("Employee Added Successfully!");
                    break;
                case 2:
                    System.out.println("--- Employee List ---");
                    for(Employee emp: dao.getAllEmployees()) {
                        System.out.println(emp.name + " | " + emp.department + " | " + emp.netSalary);
                    }
                        
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    
            }
        }
    }
}
