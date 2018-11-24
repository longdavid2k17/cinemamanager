package TicketsPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.valueOf;

public class ReservationProcessClass extends JFrame implements ActionListener
{
    JFrame processFrame;
    JLabel ticketYStudent, ticketAStudent, ticketNormall, ticketRetire;
    JTextField countTicketYStudent, countTicketAStudent, countTicketNormall, countTicketRetire;
    JButton backButton, nextButton;
    int count1, count2, count3, count4;

    int id_hall;
    String name_of_movie, time;

    public ReservationProcessClass(int ID_HALL, String NAME_OF_MOVIE, String time)
    {
        ImageIcon appIcon = new ImageIcon("icon.png");
        Font font1 = new Font("Myriad Pro", Font.BOLD, 20);

        this.id_hall = ID_HALL;
        this.name_of_movie = NAME_OF_MOVIE;
        this.time = time;

        processFrame = new JFrame();
        processFrame.setTitle("Rezerwacja biletów");
        processFrame.setSize(1500,1000);
        processFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        processFrame.setVisible(true);
        processFrame.setResizable(false);
        processFrame.setLayout(null);
        processFrame.setLocationRelativeTo(null);
        processFrame.getContentPane().setBackground(Color.black);
        processFrame.setIconImage(appIcon.getImage());

        ticketYStudent = new JLabel();
        ticketYStudent.setText("Bilet ulgowy uczniowski: ");
        ticketYStudent.setVisible(true);
        ticketYStudent.setFont(font1);
        ticketYStudent.setForeground(Color.white);
        ticketYStudent.setBounds(100, 100, 400,30);
        processFrame.add(ticketYStudent);

        countTicketYStudent = new JTextField();
        countTicketYStudent.setVisible(true);
        countTicketYStudent.setText("0");
        countTicketYStudent.setBounds(520, 100, 100, 30);
        processFrame.add(countTicketYStudent);

        ticketAStudent = new JLabel();
        ticketAStudent.setText("Bilet ulgowy studencki: ");
        ticketAStudent.setVisible(true);
        ticketAStudent.setFont(font1);
        ticketAStudent.setForeground(Color.white);
        ticketAStudent.setBounds(100, 200, 400,30);
        processFrame.add(ticketAStudent);

        countTicketAStudent = new JTextField();
        countTicketAStudent.setVisible(true);
        countTicketAStudent.setText("0");
        countTicketAStudent.setBounds(520, 200, 100, 30);
        processFrame.add(countTicketAStudent);

        ticketNormall = new JLabel();
        ticketNormall.setText("Bilet normalny: ");
        ticketNormall.setVisible(true);
        ticketNormall.setFont(font1);
        ticketNormall.setForeground(Color.white);
        ticketNormall.setBounds(100, 300, 400,30);
        processFrame.add(ticketNormall);

        countTicketNormall = new JTextField();
        countTicketNormall.setVisible(true);
        countTicketNormall.setText("0");
        countTicketNormall.setBounds(520, 300, 100, 30);
        processFrame.add(countTicketNormall);

        ticketRetire = new JLabel();
        ticketRetire.setText("Bilet seniora: ");
        ticketRetire.setVisible(true);
        ticketRetire.setFont(font1);
        ticketRetire.setForeground(Color.white);
        ticketRetire.setBounds(100, 400, 400,30);
        processFrame.add(ticketRetire);

        countTicketRetire = new JTextField();
        countTicketRetire.setVisible(true);
        countTicketRetire.setText("0");
        countTicketRetire.setBounds(520, 400, 100, 30);
        processFrame.add(countTicketRetire);

        backButton = new JButton("Cofnij");
        backButton.setVisible(true);
        backButton.setBounds(600,900,150,50);
        processFrame.add(backButton);
        backButton.addActionListener(this);

        nextButton = new JButton("Dalej");
        nextButton.setVisible(true);
        nextButton.setBounds(800,900,150,50);
        processFrame.add(nextButton);
        nextButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source==backButton)
        {
            processFrame.dispose();
            try
            {
                new Schedule();
            }

            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }

        else if(source==nextButton)
        {
            count1 = valueOf(countTicketYStudent.getText());
            count2 = valueOf(countTicketAStudent.getText());
            count3 = valueOf(countTicketNormall.getText());
            count4 = valueOf(countTicketRetire.getText());

            processFrame.dispose();
            new SummaryClass(id_hall, name_of_movie, time,count1,count2, count3, count4);

        }
    }
}
