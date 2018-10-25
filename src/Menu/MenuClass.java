package Menu;

import AdminPackage.AdminLoginFrame;
import PreviewPackage.CinemaPreview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuClass extends JFrame implements ActionListener
{
    JFrame mainScreen;
    JButton PreviewButton, reservationButton, adminPanelButton;
    JLabel informationLabel;

    public MenuClass()
    {
        ImageIcon appIcon = new ImageIcon("icon.png");
        Font font1 = new Font("Myriad Pro", Font.BOLD, 20);

        mainScreen = new JFrame();
        mainScreen.setTitle("Menu");
        mainScreen.setSize(1500,1000);
        //mainScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //mainScreen.setUndecorated(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setVisible(true);
        mainScreen.setResizable(false);
        mainScreen.setLayout(null);
        mainScreen.setLocationRelativeTo(null);
        mainScreen.getContentPane().setBackground(Color.black);
        mainScreen.setIconImage(appIcon.getImage());

        PreviewButton = new JButton("Podgląd sal");
        PreviewButton.setVisible(true);
        PreviewButton.setBounds(550,350,350,100);
        mainScreen.add(PreviewButton);
        PreviewButton.addActionListener(this);

        reservationButton = new JButton("Rezerwacja");
        reservationButton.setVisible(true);
        reservationButton.setBounds(550,500,350,100);
        mainScreen.add(reservationButton);
        reservationButton.addActionListener(this);

        adminPanelButton = new JButton("Panel \n administratora");
        adminPanelButton.setVisible(true);
        adminPanelButton.setBounds(1250,750,200,200);
        mainScreen.add(adminPanelButton);
        adminPanelButton.addActionListener(this);

        informationLabel = new JLabel();
        informationLabel.setText("Software developed for Cinema City in Bytom, Silesia");
        informationLabel.setVisible(true);
        informationLabel.setFont(font1);
        informationLabel.setForeground(Color.white);
        informationLabel.setBounds(20, 920, 500,30);
        mainScreen.add(informationLabel);

        new java.util.Timer().schedule
                (
                        new java.util.TimerTask()
                        {
                            @Override
                            public void run()
                            {
                                informationLabel.setVisible(false);
                            }
                        },
                        4000
                );

        mainScreen.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == PreviewButton)
        {
            mainScreen.dispose();
            new CinemaPreview();
        }

        else if(source == reservationButton)
        {

        }

        else  if(source == adminPanelButton)
        {
            new AdminLoginFrame();
        }

    }
}
