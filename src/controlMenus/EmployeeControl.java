package controlMenus;

import employees.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeControl {

    Scanner input = new Scanner(System.in);

    public Employee createGenericEmployee(int id){
        Scanner input = new Scanner(System.in);
        System.out.println("Type the following information for the employee");
        System.out.println("Full name:");
        String name = input.nextLine();
        System.out.println("Address:");
        String address = input.nextLine();
        System.out.println("CPF:");
        String cpf = input.nextLine();
        System.out.println("Preferred payment method:");
        System.out.println("(1)Mail check");
        System.out.println("(2)Hand delivered check");
        System.out.println("(3)Bank account deposit");
        String paymentMethod = input.nextLine();
        if (!paymentMethod.equals("1") && !paymentMethod.equals("2") && !paymentMethod.equals("3")){
            throw new IllegalArgumentException("Invalid option");
        }
        System.out.println("Does this employee contributes to the union?");
        String answer = input.nextLine();
        boolean contributes;
        if(answer.toLowerCase().contains("y")) {
            contributes = true;
        }
        else{
            contributes = false;
        }
        Employee temp = new Employee(name,address,cpf,paymentMethod,contributes,id);
        return temp;
    }

    public ArrayList<HourlyEmployee> createHourly(ArrayList<HourlyEmployee> hourlyEmployeeArrayList, int id) {
        Employee temp = createGenericEmployee(id);
        System.out.println("Hourly wage:");
        double wage = 0;
        try {
            wage = input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid entry");
            return hourlyEmployeeArrayList;
        }
        HourlyEmployee tempHourly = new HourlyEmployee(temp.getFullName(),temp.getAddress(),temp.getCpf(),
                temp.getPaymentMethod(),temp.isContributesToUnion(),temp.getEmployeeID(),wage);
        hourlyEmployeeArrayList.add(tempHourly);
        return hourlyEmployeeArrayList;
    }

    public ArrayList<SalariedEmployee> createSalaried(ArrayList<SalariedEmployee> salariedEmployeeArrayList, int id) {
        Employee temp = createGenericEmployee(id);
        System.out.println("Salary:");
        double salary = 0;
        try {
            salary = input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid entry");
            return salariedEmployeeArrayList;
        }
        SalariedEmployee tempSalaried = new SalariedEmployee(temp.getFullName(),temp.getAddress(),temp.getCpf(),
                temp.getPaymentMethod(),temp.isContributesToUnion(),temp.getEmployeeID(),salary);
        salariedEmployeeArrayList.add(tempSalaried);
        return salariedEmployeeArrayList;
    }

    public ArrayList<CommissionEmployee> createComission(ArrayList<CommissionEmployee> commissionEmployeeArrayList, int id) {
        Employee temp = createGenericEmployee(id);
        System.out.println("Salary:");
        double salary = 0;
        try {
            salary = input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid entry");
            return commissionEmployeeArrayList;
        }
        System.out.println("Comission rate:");
        double comissionRate = 0.0;
        try {
            comissionRate = input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid entry");
            return commissionEmployeeArrayList;
        }
        CommissionEmployee tempComission = new CommissionEmployee(temp.getFullName(),temp.getAddress(),temp.getCpf(),
                temp.getPaymentMethod(),temp.isContributesToUnion(),temp.getEmployeeID(),salary,comissionRate);
        commissionEmployeeArrayList.add(tempComission);
        return commissionEmployeeArrayList;
    }

    public ArrayList<HourlyEmployee> removeHourly(ArrayList<HourlyEmployee> hourlyEmployeeArrayList) {
        System.out.println("Type the CPF of the employee you wish to remove");
        String searchCPF = input.nextLine();
        for (int i = 0; i < hourlyEmployeeArrayList.size(); i++) {
            if (hourlyEmployeeArrayList.get(i).getCpf().equals(searchCPF)) {
                hourlyEmployeeArrayList.remove(i);
                System.out.println("Employee successfully removed.");
                return hourlyEmployeeArrayList;
            }
        }
        System.out.println("Employee not found.");
        return hourlyEmployeeArrayList;
    }


    public ArrayList<SalariedEmployee> removeSalaried(ArrayList<SalariedEmployee> salariedEmployeeArrayList) {
        System.out.println("Type the CPF of the employee you wish to remove");
        String searchCPF = input.nextLine();
        for (int i = 0; i < salariedEmployeeArrayList.size(); i++){
            if (salariedEmployeeArrayList.get(i).getCpf().equals(searchCPF)) {
                salariedEmployeeArrayList.remove(i);
                System.out.println("Employee successfully removed.");
                return salariedEmployeeArrayList;
            }
        }
        System.out.println("Employee not found.");
        return salariedEmployeeArrayList;
    }


    public ArrayList<CommissionEmployee> removeComission(ArrayList<CommissionEmployee> commissionEmployeeArrayList) {
        System.out.println("Type the CPF of the employee you wish to remove");
        String searchCPF = input.nextLine();
        for (int i = 0; i < commissionEmployeeArrayList.size(); i++) {
            if (commissionEmployeeArrayList.get(i).getCpf().equals(searchCPF)) {
                commissionEmployeeArrayList.remove(i);
                System.out.println("Employee successfully removed.");
                return commissionEmployeeArrayList;
            }
        }
        System.out.println("Employee not found.");
        return commissionEmployeeArrayList;
    }

    public ArrayList<HourlyEmployee> addHours(ArrayList<HourlyEmployee> hourlyEmployeeArrayList) {
        System.out.println("Type the CPF of the employee you wish to add worked hours to:");
        String searchCPF = input.nextLine();
        for (int i = 0; i < hourlyEmployeeArrayList.size(); i++) {
            if (hourlyEmployeeArrayList.get(i).getCpf().equals(searchCPF)) {
                System.out.println("Employee found, type the amount of hours to add.");
                double hours = input.nextDouble();
                hourlyEmployeeArrayList.get(i).addHours(hours);
                System.out.println("Hours added successfully.");
                return hourlyEmployeeArrayList;
            }
        }
        System.out.println("Employee not found.");
        return hourlyEmployeeArrayList;
    }

    public ArrayList<CommissionEmployee> addSale(ArrayList<CommissionEmployee> commissionEmployeeArrayList) {

    }
}
