package employees;

public class CommissionEmployee extends SalariedEmployee{

    private double comissionRate;
    private double salesTotalAmount;

    public CommissionEmployee(String fullName, String address, String cpf, String paymentMethod, boolean contributesToUnion,
                              int employeeID, double salary, double commissionRate) {
        super(fullName, address, cpf, paymentMethod, contributesToUnion, employeeID,salary);
        this.comissionRate = commissionRate;
        this.salesTotalAmount = 0.0;
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

}
