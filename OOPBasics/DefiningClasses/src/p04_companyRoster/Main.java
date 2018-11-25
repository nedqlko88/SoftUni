package p04_companyRoster;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> employees = new ArrayList<>();

        int countEmployee = Integer.parseInt(reader.readLine());

        while (countEmployee-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee = null;
            switch (input.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (input[4].matches("\\d+")) {
                        int age = Integer.parseInt(input[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = input[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = input[4];
                    int age = Integer.parseInt(input[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
        employees.add(employee);
        }


        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet()
                .stream()
                .sorted((e1,e2) -> Double.compare(
                        e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    StringBuilder result = new StringBuilder();
                    result.append(String.format("Highest Average Salary: %s", d.getKey())).append(System.lineSeparator());
                    d.getValue().stream()
                            //.sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(employee -> result.append(employee.toString()).append(System.lineSeparator()));
                    System.out.print(result.toString());
                });




        }
    }

