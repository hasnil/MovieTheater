package GUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainGUI extends JPanel {

    private JPanel frame;
    private JButton browseTheaterButton;
    private JButton cancelReservationButton;
    private JButton browseMoviesButton;
    private JButton manageAnnualFeeButton;
    private JButton registerButton;
    private JButton showtimesButton;
    private JButton loginButton;



    public MainGUI() {

        frame = new JPanel();
        frame.setBounds(0, 0, 1000, 650);
        frame.setBackground(new Color(176, 196, 222));
        frame.setLayout(null);

        browseTheaterButton = new JButton("Browse Theaters");
        browseTheaterButton.setBounds(102, 128, 200, 40);
        frame.add(browseTheaterButton);

        JLabel lblNewLabel = new JLabel("Thank you for using our application! Please select one of the following options:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setBounds(75, 21, 844, 84);
        frame.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        panel.setBackground(new Color(176, 196, 222));
        panel.setBounds(10, 11, 961, 588);
        frame.add(panel);
        panel.setLayout(null);

        cancelReservationButton = new JButton("Cancel Reservations");
        cancelReservationButton.setBounds(94, 302, 200, 40);
        panel.add(cancelReservationButton);

        browseMoviesButton = new JButton("Browse Movies");
        browseMoviesButton.setBounds(94, 178, 200, 40);
        panel.add(browseMoviesButton);

        manageAnnualFeeButton = new JButton("Manage Annual Fee");
        manageAnnualFeeButton.setBounds(94, 492, 200, 40);
        panel.add(manageAnnualFeeButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(94, 367, 200, 40);
        panel.add(registerButton);

        showtimesButton = new JButton("View Showtimes");
        showtimesButton.setBounds(94, 242, 200, 40);
        panel.add(showtimesButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(94, 429, 200, 40);
        panel.add(loginButton);

        add(frame);
    }

    public JButton getBrowseTheaterButton() {
        return browseTheaterButton;
    }


    public JButton getCancelReservationButton() {
        return cancelReservationButton;
    }


    public JButton getBrowseMoviesButton() {
        return browseMoviesButton;
    }


    public JButton getManageAnnualFeeButton() {
        return manageAnnualFeeButton;
    }


    public JButton getRegisterButton() {
        return registerButton;
    }


    public JButton getShowtimesButton() {
        return showtimesButton;
    }


    public JButton getLoginButton() {
        return loginButton;
    }

}



