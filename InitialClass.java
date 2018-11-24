import javax.swing.*;
import java.awt.*;

import Menu.MenuClass;

public class InitialClass extends JFrame
{
    JFrame welcomeBanner;
    JLabel logoLabel, informationLabel;

    InitialClass()
    {
        ImageIcon appIcon = new ImageIcon("icon.png");

        welcomeBanner = new JFrame();
        welcomeBanner.setTitle("CinemaCity Bytom");
        welcomeBanner.setLayout(null);
        welcomeBanner.setSize(1500,1000);
        //welcomeBanner.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //welcomeBanner.setUndecorated(true);
        welcomeBanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeBanner.setVisible(true);
        //welcomeBanner.setResizable(false);
        welcomeBanner.setLocationRelativeTo(null);
        welcomeBanner.getContentPane().setBackground(Color.black);
        welcomeBanner.setIconImage(appIcon.getImage());

        Font font = new Font("Myriad Pro", Font.BOLD, 50);
        Font font1 = new Font("Myriad Pro", Font.BOLD, 20);

        logoLabel= new JLabel();
        logoLabel.setText("CinemaCity BYTOM");
        logoLabel.setVisible(true);
        logoLabel.setBounds(500, 400, 500,100);
        logoLabel.setFont(font);
        logoLabel.setForeground(Color.white);
        welcomeBanner.add(logoLabel);

        informationLabel = new JLabel();
        informationLabel.setText("Software developed for Cinema City in Bytom, Silesia");
        informationLabel.setVisible(true);
        informationLabel.setFont(font1);
        informationLabel.setForeground(Color.white);
        informationLabel.setBounds(20, 920, 500,30);
        welcomeBanner.add(informationLabel);

        welcomeBanner.repaint();

        new java.util.Timer().schedule
                (
                        new java.util.TimerTask()
                        {
                            @Override
                            public void run()
                            {
                                welcomeBanner.dispose();
                                new MenuClass();
                            }
                        },
                        1000
                );

    }


    public static void main(String[] args)
    {
        new InitialClass();
    }
}
