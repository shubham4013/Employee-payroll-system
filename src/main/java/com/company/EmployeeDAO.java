package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee e) throws Exception {
        String sql = "INSERT INTO employees(name, department, basic_salary, hra, allowances, deductions, net_salary) VALUES(?,?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.name);
            ps.setString(2, e.department);
            ps.setDouble(3, e.basicSalary);
            ps.setDouble(4, e.hra);
            ps.setDouble(5, e.allowances);
            ps.setDouble(6, e.deductions);
            ps.setDouble(7, e.netSalary);
            ps.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee e = new Employee(rs.getString("name"), rs.getString("department"), rs.getDouble("basic_salary"));
                e.hra = rs.getDouble("hra");
                e.allowances = rs.getDouble("allowances");
                e.deductions = rs.getDouble("deductions");
                e.netSalary = rs.getDouble("net_salary");
                list.add(e);
            }
        }
        return list;
    }
}
