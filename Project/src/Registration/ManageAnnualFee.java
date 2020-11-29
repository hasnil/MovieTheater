package Registration;

import Payment.MakePaymentGUI;

public class ManageAnnualFee {

    private MakePaymentGUI makePaymentGUI;

    public ManageAnnualFee(MakePaymentGUI makePaymentGUI) {
        setMakePaymentGUI(makePaymentGUI);
    }

    public boolean payAnnualFee() {
        return makePaymentGUI.makePayment(20);
    }

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }
}
