package employees;

import java.util.Calendar;
import java.util.Date;
import java.time.*;

public class CommissionEmployee extends SalariedEmployee{

    private double comissionRate;
    private double salesTotalAmount;
    private LocalDate lastPaid;

    public CommissionEmployee(String fullName, String address, String cpf, String paymentMethod, boolean contributesToUnion,
                              int employeeID, double salary, double commissionRate) {
        super(fullName, address, cpf, paymentMethod, contributesToUnion, employeeID,salary);
        this.comissionRate = commissionRate;
        this.salesTotalAmount = 0.0;
        Date nowDate = new Date();
        this.lastPaid = LocalDate.now();

    }

    public double calculateSalary(){
        if(this.salesTotalAmount > 0.0){
            double tempSalesTotal = salesTotalAmount;
            this.salesTotalAmount = 0;
            return this.getSalary()*(comissionRate*tempSalesTotal);
        }
        else return this.getSalary();
    }

    public double getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(double comissionRate) {
        this.comissionRate = comissionRate;
    }

    public void setSalesTotalAmount(double salesTotalAmount) {
        this.salesTotalAmount = salesTotalAmount;
    }

    public void addSalesAmount(double sale) {
        this.salesTotalAmount = this.salesTotalAmount + sale;
    }

    public LocalDate getLastPaid() {
        return lastPaid;
    }

    public void setLastPaid(LocalDate lastPaid) {
        this.lastPaid = lastPaid;
    }
}
