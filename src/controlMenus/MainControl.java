package controlMenus;

import employees.*;
import union.*;
import viewMenus.*;

import java.util.ArrayList;
import java.util.Scanner;


public class MainControl {

    public void mainAll() {
        Scanner input = new Scanner(System.in);
        boolean on = true;
        MainMenus mainMenu = new MainMenus();
        PaymentControl paymentControl = new PaymentControl();
        SaleControl saleControl = new SaleControl();
        EmployeeControl employeeControl = new EmployeeControl();

        ArrayList<HourlyEmployee> hourlyEmployeeArrayList = new ArrayList();
        ArrayList<SalariedEmployee> salariedEmployeeArrayList = new ArrayList();
        ArrayList<CommissionEmployee> commissionEmployeeArrayList = new ArrayList();
        ArrayList<UnionEmployee> unionEmployeeArrayList = new ArrayList();
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
                    break;

                case "6":
                    break;

                case "7":
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
