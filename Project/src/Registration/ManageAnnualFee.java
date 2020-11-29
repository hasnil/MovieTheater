package Registration;

import Payment.MakePayment;
import Payment.MakePaymentGUI;
import Payment.PaymentSystem;

public class ManageAnnualFee {

    private MakePaymentGUI makePaymentGUI;

    public ManageAnnualFee(MakePaymentGUI makePaymentGUI) {
        setMakePaymentGUI(makePaymentGUI);
    }

    public boolean payAnnualFee() {
        // TODO call make payment
        makePaymentGUI.makePayment(20);
        return true;
    }

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }
}
