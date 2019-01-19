package PreviewPackage;

import Menu.MenuClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CinemaPreview extends JFrame implements ActionListener
{
    JFrame mainScreen;
    JButton hall1Button, hall2Button,hall3Button, hall4Button, backButton;
    JLabel logoLabel;

    public CinemaPreview()
    {
        ImageIcon appIcon = new ImageIcon("icon.png");
        ImageIcon imgThisImg = new ImageIcon("cinema_image.png");

        mainScreen = new JFrame();
        mainScreen.setTitle("Podgląd sal");
        mainScreen.setSize(1500,1000);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setVisible(true);
        mainScreen.setLayout(null);
        mainScreen.setResizable(false);
        mainScreen.setLocationRelativeTo(null);
        mainScreen.getContentPane().setBackground(Color.black);
        mainScreen.setIconImage(appIcon.getImage());

        hall1Button = new JButton("Sala 1");
        hall1Button.addActionListener(this);
        hall1Button.setBounds(100,200,300,150);
        mainScreen.add(hall1Button);

        hall2Button = new JButton("Sala 2");
        hall2Button.addActionListener(this);
        hall2Button.setBounds(450,200,300,150);
        mainScreen.add(hall2Button);

        hall3Button = new JButton("Sala 3");
        hall3Button.addActionListener(this);
        hall3Button.setBounds(100,500,300,150);
        mainScreen.add(hall3Button);

        hall4Button = new JButton("Sala 4");
        hall4Button.addActionListener(this);
        hall4Button.setBounds(450,500,300,150);
        mainScreen.add(hall4Button);

        backButton = new JButton("Cofnij");
        backButton.addActionListener(this);
        backButton.setBounds(1100,800,300,80);
        mainScreen.add(backButton);

        logoLabel= new JLabel();
        logoLabel.setVisible(true);
        logoLabel.setIcon(imgThisImg);
        logoLabel.setBounds(500, 100, 800,640);
        logoLabel.setForeground(Color.white);
        mainScreen.add(logoLabel);

        mainScreen.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == hall1Button)
        {
            try
            {
                new CinemaHalls(1);
            }

            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }

        else if(source == hall2Button)
        {
            try
            {
                new CinemaHalls(2);
            }

            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }

        else if(source == hall3Button)
        {
            try
            {
                new CinemaHalls(3);
            }

            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }

        else if(source == hall4Button)
        {
            try
            {
                new CinemaHalls(4);
            }

            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }

        else if(source == backButton)
        {
        mainScreen.dispose();
        new MenuClass();
        }

    }
}
