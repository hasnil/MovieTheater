package Payment;

import java.util.Calendar;
import java.util.Date;

public class Voucher {

    private int number;
    private double amount;
    private Date expiryDate;

    public Voucher(int number, double amount) {
        setNumber(number);
        setAmount(amount);
        setDate();
    }

    public void setDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        expiryDate = cal.getTime();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
