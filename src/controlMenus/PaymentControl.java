package controlMenus;

import employees.CommissionEmployee;
import employees.HourlyEmployee;
import employees.SalariedEmployee;

import java.util.ArrayList;
import java.util.Calendar;
import java.time.*;

public class PaymentControl {

    public ArrayList<HourlyEmployee> payHourly(ArrayList<HourlyEmployee> hourlyEmployeeArrayList) {
        for (int i = 0; i < hourlyEmployeeArrayList.size(); i++) {
            if (hourlyEmployeeArrayList.get(i).getHoursWorkedThisWeek()>0){
                double payment = hourlyEmployeeArrayList.get(i).calculateSalary();
                System.out.println("Paying R$" + payment +" to " + hourlyEmployeeArrayList.get(i).getFullName());
            }
        }
        System.out.println("All pending hourly employees payments have been made");
        return hourlyEmployeeArrayList;
    }

    public Calendar getLastWorkDayOfMonth(Calendar calendar) {
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE,-1);
        while(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            calendar.add(Calendar.DATE, -1);
        }
        return calendar;
    }

    public ArrayList<SalariedEmployee> paySalaried(ArrayList<SalariedEmployee> salariedEmployeeArrayList) {
        for (int i = 0; i < salariedEmployeeArrayList.size(); i++) {
                double payment = salariedEmployeeArrayList.get(i).calculateSalary();
                System.out.println("Paying R$" + payment +" to " + salariedEmployeeArrayList.get(i).getFullName());
        }
        System.out.println("All pending salaried employees payments have been made");
        return salariedEmployeeArrayList;
    }

    public ArrayList<CommissionEmployee> payComissioned(ArrayList<CommissionEmployee> commissionEmployeeArrayList) {
        LocalDate now = LocalDate.now();
        for (int i = 0; i < commissionEmployeeArrayList.size(); i++) {
            Duration duration = Duration.between(now,commissionEmployeeArrayList.get(i).getLastPaid());
            if (duration.toDays()>14) {
                double payment = commissionEmployeeArrayList.get(i).calculateSalary();
                System.out.println("Paying R$" + payment + " to " + commissionEmployeeArrayList.get(i).getFullName());
            }
        }
        System.out.println("All pending commissioned employees payments have been made");
        return commissionEmployeeArrayList;
    }
}
