package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    List<Employee> employeeList = new ArrayList<>();

    System.out.print("How many employees? ");
    int employeesNumber = sc.nextInt();
    System.out.println();

    for (int i = 0; i < employeesNumber; i++ ) {
      System.out.print("Employee #" + (i + 1) + ": ");
      System.out.print("ID: ");
      int id = sc.nextInt();
      sc.nextLine();
      System.out.print("Name: ");
      String name = sc.nextLine();
      System.out.print("Salary: ");
      Double salary = sc.nextDouble();
      System.out.println();

      employeeList.add(new Employee(id, name, salary));
    }

    System.out.print("Enter the ID of an employee: ");
    int raiseId = sc.nextInt();

    Employee emp = employeeList.stream().filter(e -> e.getId() == raiseId).findFirst().orElse(null);

    if (emp != null) {
      System.out.print("Enter the raise percentage to increase his/her salary: ");
      Double percentage = sc.nextDouble();
      emp.giveRaise(percentage);
    } else {
      System.out.println("Invalid ID");
    }

    System.out.println();
    for (Employee e : employeeList) {
      System.out.println(e);
    }
  }
}