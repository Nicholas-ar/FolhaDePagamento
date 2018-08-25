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

        ArrayList<HourlyEmployee> hourlyEmployeeArrayList = new ArrayList();
        ArrayList<SalariedEmployee> salariedEmployeeArrayList = new ArrayList();
        ArrayList<CommissionEmployee> commissionEmployeeArrayList = new ArrayList();
        ArrayList<UnionEmployee> unionEmployeeArrayList = new ArrayList();

        while (on) {

            mainMenu.mainMenu();
            String type;
            String option = input.nextLine();
            switch (option) {
                case "1":
                    break;

                case "2":
                    break;

                case "3":
                    break;

                case "4":
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
