package Reservation;

import java.util.Calendar;
import java.util.Date;

public class Voucher {

    private int vouchNum;
    private double amount;
    private Date expiryDate;

    public Voucher(int vouchNum, double amount, Date expiryDate) {
        setVouchNum(vouchNum);
        setAmount(amount);
        setExpiryDate(expiryDate);
    }

    public Voucher(int vouchNum, double amount) {
        setVouchNum(vouchNum);
        setAmount(amount);
        setAYearFromTodayDate();
    }

    private void setAYearFromTodayDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        expiryDate = cal.getTime();
    }

    public void setVouchNum(int vouchNum) {
        this.vouchNum = vouchNum;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getVouchNum() {
        return vouchNum;
    }
    public double getAmount() {
        return amount;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Voucher #: " + vouchNum + ", amount $" + String.format("%.2f", amount) + ", expiry date: " + expiryDate;
    }
}
