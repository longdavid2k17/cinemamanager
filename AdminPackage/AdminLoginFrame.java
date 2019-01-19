package AdminPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdminLoginFrame extends JFrame implements ActionListener
{
    JFrame LoginFrame;
    JTextField loginField;
    JPasswordField passwordField;
    JLabel loginLabel, passwordLabel,instruction;
    JButton loginButton;
    String login, password;
    int flag=0;

    String getLogin, getPassword;
    String fileLogin, filePassword;
    String[] strings= new String[3];

    public AdminLoginFrame() throws IOException, ClassNotFoundException
    {
        ImageIcon appIcon = new ImageIcon("icon.png");


        LoginFrame = new JFrame();
        LoginFrame.setTitle("Logowanie");
        LoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        LoginFrame.setVisible(true);
        LoginFrame.setSize(400, 400);
        LoginFrame.setLocationRelativeTo(null);
        LoginFrame.setResizable(false);
        LoginFrame.setLayout(null);
        LoginFrame.getContentPane().setBackground(Color.black);
        LoginFrame.setIconImage(appIcon.getImage());

        loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setBounds(10, 50, 100, 50);
        loginLabel.setForeground(Color.white);
        LoginFrame.add(loginLabel);

        loginField = new JTextField();
        loginField.setVisible(true);
        loginField.setText("Login");
        loginField.setBounds(120, 50, 250, 50);
        LoginFrame.add(loginField);

        passwordLabel = new JLabel();
        passwordLabel.setText("Hasło");
        passwordLabel.setBounds(10, 100, 100, 50);
        passwordLabel.setForeground(Color.white);
        LoginFrame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setVisible(true);
        passwordField.setText("Hasło");
        passwordField.setBounds(120, 100, 250, 50);
        LoginFrame.add(passwordField);

        loginButton = new JButton("Zaloguj");
        loginButton.setVisible(true);
        loginButton.setBounds(150, 250, 100, 50);
        loginButton.addActionListener(this);
        LoginFrame.add(loginButton);

        instruction = new JLabel();
        instruction.setText("Nie zalogowano");
        instruction.setBounds(150, 300, 100, 50);
        instruction.setForeground(Color.white);
        instruction.setVisible(false);
        LoginFrame.add(instruction);

        FileReader fr = new FileReader("adminIndex.txt");
        try
        {
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i <= 2; i++)
            {
                strings[i] = br.readLine();
            }
            fileLogin = strings[1];
            filePassword = strings[2];
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        LoginFrame.repaint();
    }
    void procedure(String login, String password) throws FileNotFoundException
    {
        this.getLogin = login;
        this.getPassword = password;

            if(login.equals(fileLogin))
            {
                if(password.equals(filePassword))
                {
                    LoginFrame.dispose();
                    new AdminSiteManagment();
                }

                else
                {
                    instruction.setText("Nie zalogowałeś się");
                    instruction.setVisible(true);
                }
            }

            else
            {
                instruction.setText("Nie zalogowałeś się");
                instruction.setVisible(true);
            }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == loginButton)
        {
            login = loginField.getText();
            password = passwordField.getText();

            try
            {
                procedure(login, password);
            }
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            }
            LoginFrame.dispose();
            new AdminSiteManagment();

        }
    }
}
