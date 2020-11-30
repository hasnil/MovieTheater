package Reservation;

import java.util.Calendar;
import java.util.Date;

public class StoreCredit {

    private int creditNum;
    private double amount;
    private String userName;
    private Date expiryDate;

    public StoreCredit(int creditNum, double amount, String userName) {
        setCreditNum(creditNum);
        setAmount(amount);
        setUserName(userName);
        setAYearFromTodayDate();
    }

    public void setAYearFromTodayDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        expiryDate = cal.getTime();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCreditNum(int creditNum) {
        this.creditNum = creditNum;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCreditNum() {
        return creditNum;
    }
}
