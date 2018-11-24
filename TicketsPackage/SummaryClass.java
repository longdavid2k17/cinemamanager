package TicketsPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SummaryClass extends JFrame implements ActionListener
{
    JFrame summaryWindow;
    JLabel summaryLabel, timeLabel;
    JLabel movieNameLabel, movieNameLabe2;
    JLabel id_hall, id_hallLabel;
    JLabel ticketCountLabel, ticket1Label1, ticket1Label2,ticket1Label3,ticket1Label4;


    ImageIcon appIcon = new ImageIcon("icon.png");
    int ID_HALL, count1, count2, count3, count4;
    String NAME_OF_MOVIE, time;
    JButton backButton, nextButton;

    SummaryClass(int ID_HALL, String NAME_OF_MOVIE, String time, int count1, int count2, int count3, int count4)
    {
        Font font1 = new Font("Myriad Pro", Font.BOLD, 60);
        Font font2 = new Font("Myriad Pro", Font.BOLD, 30);
        Font font3 = new Font("Myriad Pro", Font.BOLD, 20);

        summaryWindow = new JFrame();
        summaryWindow.setTitle("Rezerwacja biletów");
        summaryWindow.setSize(1500,1000);
        summaryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        summaryWindow.setVisible(true);
        summaryWindow.setResizable(false);
        summaryWindow.setLayout(null);
        summaryWindow.setLocationRelativeTo(null);
        summaryWindow.getContentPane().setBackground(Color.black);
        summaryWindow.setIconImage(appIcon.getImage());

        this.ID_HALL = ID_HALL;
        this.NAME_OF_MOVIE = NAME_OF_MOVIE;
        this.time = time;
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
        this.count4 = count4;

        // poprawić czytelność

        backButton = new JButton("Cofnij");
        backButton.setVisible(true);
        backButton.setBounds(600,900,150,50);
        summaryWindow.add(backButton);
        backButton.addActionListener(this);

        nextButton = new JButton("Akceptuj");
        nextButton.setVisible(true);
        nextButton.setBounds(800,900,150,50);
        summaryWindow.add(nextButton);
        nextButton.addActionListener(this);

        summaryLabel = new JLabel();
        summaryLabel.setText("Podsumowanie");
        summaryLabel.setVisible(true);
        summaryLabel.setFont(font1);
        summaryLabel.setForeground(Color.white);
        summaryLabel.setBounds(200,100,400,50);
        summaryWindow.add(summaryLabel);

        movieNameLabel = new JLabel();
        movieNameLabel.setText("Nazwa filmu: ");
        movieNameLabel.setVisible(true);
        movieNameLabel.setFont(font2);
        movieNameLabel.setForeground(Color.white);
        movieNameLabel.setBounds(200,200,250,50);
        summaryWindow.add(movieNameLabel);

        movieNameLabe2 = new JLabel();
        movieNameLabe2.setText(NAME_OF_MOVIE);
        movieNameLabe2.setVisible(true);
        movieNameLabe2.setFont(font2);
        movieNameLabe2.setForeground(Color.white);
        movieNameLabe2.setBounds(400,200,350,50);
        summaryWindow.add(movieNameLabe2);

        id_hall = new JLabel();
        id_hall.setText("Numer sali: ");
        id_hall.setVisible(true);
        id_hall.setFont(font2);
        id_hall.setForeground(Color.white);
        id_hall.setBounds(200,300,200,50);
        summaryWindow.add(id_hall);

        id_hallLabel = new JLabel();
        id_hallLabel.setText(String.valueOf(ID_HALL));
        id_hallLabel.setVisible(true);
        id_hallLabel.setFont(font2);
        id_hallLabel.setForeground(Color.white);
        id_hallLabel.setBounds(400,300,350,50);
        summaryWindow.add(id_hallLabel);

        timeLabel = new JLabel();
        timeLabel.setText("Godzina seansu: "+time);
        timeLabel.setVisible(true);
        timeLabel.setFont(font2);
        timeLabel.setForeground(Color.white);
        timeLabel.setBounds(200,400,350,50);
        summaryWindow.add(timeLabel);

        ticketCountLabel = new JLabel();
        ticketCountLabel.setText("Rodzaje biletów:");
        ticketCountLabel.setVisible(true);
        ticketCountLabel.setFont(font2);
        ticketCountLabel.setForeground(Color.white);
        ticketCountLabel.setBounds(200,500,300,50);
        summaryWindow.add(ticketCountLabel);

        ticket1Label1 = new JLabel();
        ticket1Label1.setText("Bilet ulgowy uczniowski: "+count1);
        ticket1Label1.setVisible(true);
        ticket1Label1.setFont(font3);
        ticket1Label1.setForeground(Color.white);
        ticket1Label1.setBounds(500,500,300,50);
        summaryWindow.add(ticket1Label1);

        ticket1Label2 = new JLabel();
        ticket1Label2.setText("Bilet ulgowy studencki: "+count2);
        ticket1Label2.setVisible(true);
        ticket1Label2.setFont(font3);
        ticket1Label2.setForeground(Color.white);
        ticket1Label2.setBounds(800,500,300,50);
        summaryWindow.add(ticket1Label2);

        ticket1Label3 = new JLabel();
        ticket1Label3.setText("Bilet normalny: "+count3);
        ticket1Label3.setVisible(true);
        ticket1Label3.setFont(font3);
        ticket1Label3.setForeground(Color.white);
        ticket1Label3.setBounds(500,600,300,50);
        summaryWindow.add(ticket1Label3);

        ticket1Label4 = new JLabel();
        ticket1Label4.setText("Bilet seniora: "+count4);
        ticket1Label4.setVisible(true);
        ticket1Label4.setFont(font3);
        ticket1Label4.setForeground(Color.white);
        ticket1Label4.setBounds(800,600,300,50);
        summaryWindow.add(ticket1Label4);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source==backButton)
        {
            summaryWindow.dispose();
            new ReservationProcessClass(ID_HALL, NAME_OF_MOVIE, time);
        }

        else if(source==nextButton)
        {
            summaryWindow.dispose();
            try
            {
                new PrintTicket(ID_HALL, NAME_OF_MOVIE, time,count1,count2, count3, count4);
            }

            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
    }
}
