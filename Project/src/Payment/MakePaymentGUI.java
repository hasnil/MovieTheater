package Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakePaymentGUI {

    private BufferedReader reader;
    private MakePayment makePayment;

    public MakePaymentGUI(MakePayment makePayment) {
        setMakePayment(makePayment);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean makePayment(int amount) {
        int option = 0;
        System.out.println("Select 1 to pay with credit card or 2 te pay with a voucher");
        try {
            option = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (option == 1) {
            String cc = "";
            int cvv = 0;
            try {
                System.out.println("Enter your credit card number");
                cc = reader.readLine();
                System.out.println("Enter the CVV number of your card");
                cvv = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return makePayment.payWithCreditCard(cc, cvv, amount);
        }
        else if (option == 2) {
            int voucher = 0;
            try {
                System.out.println("Enter your voucher number");
                voucher = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            makePayment.payWithVoucher(voucher, amount);
        }
        else
            System.out.println("ERROR");
    return false;
    }

    public void setMakePayment(MakePayment makePayment) {
        this.makePayment = makePayment;
    }
}
