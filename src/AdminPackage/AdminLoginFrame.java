package AdminPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame extends JFrame implements ActionListener {
    JFrame LoginFrame;
    JTextField loginField;
    JPasswordField passwordField;
    JLabel loginLabel, passwordLabel,instruction;
    JButton loginButton;
    String login, password;

    public AdminLoginFrame()
    {
        ImageIcon appIcon = new ImageIcon("icon.png");


        LoginFrame = new JFrame();
        LoginFrame.setTitle("Logowanie");
        LoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        LoginFrame.setVisible(true);
        LoginFrame.setSize(400,400);
        LoginFrame.setLocationRelativeTo(null);
        LoginFrame.setResizable(false);
        LoginFrame.setLayout(null);
        LoginFrame.getContentPane().setBackground(Color.black);
        LoginFrame.setIconImage(appIcon.getImage());

        loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setBounds(10,50,100,50);
        loginLabel.setForeground(Color.white);
        LoginFrame.add(loginLabel);

        loginField = new JTextField();
        loginField.setVisible(true);
        loginField.setText("Login");
        loginField.setBounds(120,50,250,50);
        LoginFrame.add(loginField);

        passwordLabel = new JLabel();
        passwordLabel.setText("Hasło");
        passwordLabel.setBounds(10,100,100,50);
        passwordLabel.setForeground(Color.white);
        LoginFrame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setVisible(true);
        passwordField.setText("Hasło");
        passwordField.setBounds(120,100,250,50);
        LoginFrame.add(passwordField);

        loginButton = new JButton("Zaloguj");
        loginButton.setVisible(true);
        loginButton.setBounds(150,250,100,50);
        loginButton.addActionListener(this);
        LoginFrame.add(loginButton);

        LoginFrame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == loginButton)
        {
            login = loginField.getText();
            password = passwordField.getText();

        new LoginProcedure(login, password);
        }
    }
}
