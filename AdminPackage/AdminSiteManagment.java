package AdminPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSiteManagment extends JFrame implements ActionListener
{
    JFrame managmentWindow;
    JButton changeHallButton, backButton, editScheduleButton;
    JLabel logoLabel;

    AdminSiteManagment()
    {
        ImageIcon appIcon = new ImageIcon("icon.png");
        ImageIcon imgThisImg = new ImageIcon("cinema_image.png");

    managmentWindow = new JFrame();
    managmentWindow.setTitle("Strona administratora");
    managmentWindow.setSize(1500,1000);
    managmentWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    managmentWindow.setVisible(true);
    managmentWindow.setResizable(false);
    managmentWindow.setLayout(null);
    managmentWindow.setLocationRelativeTo(null);
    managmentWindow.getContentPane().setBackground(Color.black);
    managmentWindow.setIconImage(appIcon.getImage());

    changeHallButton = new JButton("Edycja sal");
    changeHallButton.setVisible(true);
    changeHallButton.setBounds(50,200,350,100);
    managmentWindow.add(changeHallButton);
    changeHallButton.addActionListener(this);

    editScheduleButton = new JButton("Edycja harmonogramu");
    editScheduleButton.setVisible(true);
    editScheduleButton.setBounds(50,400,350,100);
    managmentWindow.add(editScheduleButton);
    editScheduleButton.addActionListener(this);

    backButton = new JButton("Cofnij");
    backButton.addActionListener(this);
    backButton.setBounds(1200,900,200,50);
    managmentWindow.add(backButton);

    logoLabel= new JLabel();
    logoLabel.setVisible(true);
    logoLabel.setIcon(imgThisImg);
    logoLabel.setBounds(500, 100, 800,640);
    logoLabel.setForeground(Color.white);
    managmentWindow.add(logoLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source==changeHallButton)
        {
            managmentWindow.dispose();
            new EditHall();
        }

        else if(source==backButton)
        {
            managmentWindow.dispose();
        }

        else if(source==editScheduleButton)
        {
            managmentWindow.dispose();

            try
            {
                new EditSchedule();
            }

            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }

    }
}
