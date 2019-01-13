package TicketsPackage;

import Menu.MenuClass;
import AdminPackage.SQLManagmentClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Schedule extends JFrame implements ActionListener
{
    JFrame scheduleWindow;
    JButton movie1Button,movie1Button2,movie1Button3, backButton;
    String buttonLabel,buttonLabel2, buttonLabel3;

    SQLManagmentClass query = new SQLManagmentClass();
    SQLManagmentClass query1 = new SQLManagmentClass();
    SQLManagmentClass query2 = new SQLManagmentClass();

    public Schedule() throws Exception

    {
        ImageIcon appIcon = new ImageIcon("icon.png");

        scheduleWindow = new JFrame();
        scheduleWindow.setTitle("Wybierz film");
        scheduleWindow.setSize(1500,1000);
        scheduleWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scheduleWindow.setVisible(true);
        scheduleWindow.setResizable(false);
        scheduleWindow.setLayout(null);
        scheduleWindow.setLocationRelativeTo(null);
        scheduleWindow.getContentPane().setBackground(Color.black);
        scheduleWindow.setIconImage(appIcon.getImage());


        query.getCinemaData("SELECT * FROM harmonogram WHERE id_filmu = 1");
        buttonLabel = query.movieName+" | Sala nr"+query.id_hall+" | Godzina: "+ query.time;
        query1.getCinemaData("SELECT * FROM harmonogram WHERE id_filmu = 2");
        buttonLabel2 = query1.movieName+" | Sala nr"+query1.id_hall+" | Godzina: "+ query1.time;
        query2.getCinemaData("SELECT * FROM harmonogram WHERE id_filmu = 3");
        buttonLabel3 = query2.movieName+" | Sala nr"+query2.id_hall+" | Godzina: "+ query2.time;

        movie1Button = new JButton(buttonLabel);
        movie1Button.setVisible(true);
        movie1Button.setBounds(100,100,800,150);
        scheduleWindow.add(movie1Button);
        movie1Button.addActionListener(this);

        movie1Button2 = new JButton(buttonLabel2);
        movie1Button2.setVisible(true);
        movie1Button2.setBounds(100,300,800,150);
        scheduleWindow.add(movie1Button2);
        movie1Button2.addActionListener(this);

        movie1Button3 = new JButton(buttonLabel3);
        movie1Button3.setVisible(true);
        movie1Button3.setBounds(100,500,800,150);
        scheduleWindow.add(movie1Button3);
        movie1Button3.addActionListener(this);

        backButton= new JButton();
        backButton.setText("Cofnij");
        backButton.setVisible(true);
        backButton.setBounds(1200,800,200,125);
        scheduleWindow.add(backButton);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source==movie1Button)
        {
            scheduleWindow.dispose();
            new ReservationProcessClass(query.id_hall, query.movieName,  query.time);
        }

        else if(source==movie1Button2)
        {
            scheduleWindow.dispose();
            new ReservationProcessClass(query1.id_hall, query1.movieName,  query1.time);
        }

        else if(source==movie1Button3)
        {
            scheduleWindow.dispose();
            new ReservationProcessClass(query2.id_hall, query2.movieName,  query2.time);
        }

        else if(source==backButton)
        {
            scheduleWindow.dispose();
            new MenuClass();
        }
    }
}
