package AdminPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSiteManagment extends JFrame implements ActionListener
{
    JFrame managmentWindow;
    JButton changeHallButton, editTicketPriceButton, editScheduleButton;
    JLabel logoLabel;

    AdminSiteManagment()
    {
        ImageIcon appIcon = new ImageIcon("icon.png");

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

    editTicketPriceButton = new JButton("Edycja cen biletów");
    editTicketPriceButton.setVisible(true);
    editTicketPriceButton.setBounds(50,400,350,100);
    managmentWindow.add(editTicketPriceButton);
    editTicketPriceButton.addActionListener(this);

    editScheduleButton = new JButton("Edycja harmonogramu");
    editScheduleButton.setVisible(true);
    editScheduleButton.setBounds(50,600,350,100);
    managmentWindow.add(editScheduleButton);
    editScheduleButton.addActionListener(this);

        ImageIcon imgThisImg = new ImageIcon("cinema_image.png");

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

        }

        else if(source==editTicketPriceButton)
        {

        }

        else if(source==editScheduleButton)
        {

        }

    }
}
