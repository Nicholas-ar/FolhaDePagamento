package controlMenus;

import employees.*;
import viewMenus.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;


public class MainControl {

    public void mainAll() {
        Scanner input = new Scanner(System.in);
        boolean on = true;
        MainMenus mainMenu = new MainMenus();
        PaymentControl paymentControl = new PaymentControl();
        SaleControl saleControl = new SaleControl();
        EmployeeControl employeeControl = new EmployeeControl();
        PaymentControl payControl = new PaymentControl();
        Date nowDate = new Date();
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(nowDate);

        ArrayList<HourlyEmployee> hourlyEmployeeArrayList = new ArrayList();
        ArrayList<SalariedEmployee> salariedEmployeeArrayList = new ArrayList();
        ArrayList<CommissionEmployee> commissionEmployeeArrayList = new ArrayList();
        int lastEmployeeID = 1;

        while (on) {

            mainMenu.mainMenu();
            String type;
            String option = input.nextLine();
            switch (option) {
                case "1":
                    mainMenu.employeeType();
                    type = input.nextLine();
                    switch (type){
                        case "1":
                            hourlyEmployeeArrayList = employeeControl.createHourly(hourlyEmployeeArrayList,lastEmployeeID);
                            lastEmployeeID++;
                        case "2":
                            salariedEmployeeArrayList = employeeControl.createSalaried(salariedEmployeeArrayList,lastEmployeeID);
                            lastEmployeeID++;
                        case "3":
                            commissionEmployeeArrayList = employeeControl.createComission(commissionEmployeeArrayList,lastEmployeeID);
                            lastEmployeeID++;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case "2":
                    mainMenu.employeeType();
                    type = input.nextLine();
                    switch (type){
                        case "1":
                            hourlyEmployeeArrayList = employeeControl.removeHourly(hourlyEmployeeArrayList);
                        case "2":
                            salariedEmployeeArrayList = employeeControl.removeSalaried(salariedEmployeeArrayList);
                        case "3":
                            commissionEmployeeArrayList = employeeControl.removeComission(commissionEmployeeArrayList);
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case "3":
                    hourlyEmployeeArrayList = employeeControl.addHours(hourlyEmployeeArrayList);
                    break;

                case "4":
                    commissionEmployeeArrayList = employeeControl.addSale(commissionEmployeeArrayList);
                    break;

                case "5":
                    mainMenu.employeeType();
                    type = input.nextLine();
                    switch (type){
                        case "1":
                            hourlyEmployeeArrayList = employeeControl.addCost(hourlyEmployeeArrayList);
                        case "2":
                            salariedEmployeeArrayList = employeeControl.addCostSalaried(salariedEmployeeArrayList);
                        case "3":
                            commissionEmployeeArrayList = employeeControl.addCostComissioned(commissionEmployeeArrayList);
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case "6":
                    break;

                case "7":
                    System.out.println("Paying all employees scheduled for the day");
                    if(nowCalendar.get(Calendar.DAY_OF_WEEK)== 6){
                        System.out.println("Today is friday, paying hourly employees and checking commissioned employees");
                        hourlyEmployeeArrayList = payControl.payHourly(hourlyEmployeeArrayList);
                        commissionEmployeeArrayList = payControl.payComissioned(commissionEmployeeArrayList);
                    }
                    if (payControl.getLastWorkDayOfMonth(nowCalendar).equals(nowCalendar)){
                        System.out.println("Today is the last work day of the month, paying monthly employees");
                        salariedEmployeeArrayList = payControl.paySalaried(salariedEmployeeArrayList);
                    }
                    break;

                case "8":
                    break;

                case "9":
                    break;

                case "10":
                    break;

                case "11":
                    break;

                case "12":
                    System.out.println("Goodbye!");
                    on = false;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
