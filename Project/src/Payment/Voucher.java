package Payment;

import java.util.Calendar;
import java.util.Date;

public class Voucher {

    private int vouchNum;
    private double amount;
    private Date expiryDate;

    public Voucher(int vouchNum, double amount) {
        setVouchNum(vouchNum);
        setAmount(amount);
        setDate();
    }

    public void setDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        expiryDate = cal.getTime();
    }

    public void setVouchNum(int vouchNum) {
        this.vouchNum = vouchNum;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
}
