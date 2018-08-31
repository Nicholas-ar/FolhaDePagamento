package employees;

public class HourlyEmployee extends Employee {

    private double hoursWorkedThisWeek;
    private double hourlyWage;

    public HourlyEmployee(String fullName, String address, String cpf, String paymentMethod, boolean contributesToUnion,
                          int employeeID, double hourlyWage) {
        super(fullName, address, cpf, paymentMethod, contributesToUnion, employeeID);
        this.hoursWorkedThisWeek = 0;
        this.hourlyWage = hourlyWage;
    }

    public double calculateSalary(){
        double temp = hoursWorkedThisWeek;
        hoursWorkedThisWeek = 0;
        double month = this.getMonthlyCosts();
        this.setMonthlyCosts(0);
        if(temp > 40){
            return (hourlyWage * 40) + (hourlyWage * 1.5 * (temp - 40));
        }
        else return (hourlyWage * temp) - this.getServiceCosts() - month;
    }

    public double getHoursWorkedThisWeek() {
        return hoursWorkedThisWeek;
    }

    public void setHoursWorkedThisWeek(double hoursWorkedThisWeek) {
        this.hoursWorkedThisWeek = hoursWorkedThisWeek;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void addHours(double hours) {
        this.hoursWorkedThisWeek = this.hoursWorkedThisWeek+hours;
    }
}
