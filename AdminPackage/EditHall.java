package AdminPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditHall extends JFrame implements ActionListener
{
    int flag=0;
    JFrame mainScreen;
    JLabel logoLabel, deleteLabel, addLabel;
    JButton addButton, deleteButton, backButton, nextButton;
    ///for add hall
    JTextField numberOfHallToAdd;
    ///for delete hall
    JTextField numberOfHallToDelete;

    EditHall()
    {
        ImageIcon appIcon = new ImageIcon("icon.png");
        ImageIcon logo = new ImageIcon("cinema_image.png");

        mainScreen = new JFrame();
        mainScreen.setTitle("Edycja sal");
        mainScreen.setSize(1500,1000);
        mainScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainScreen.setVisible(true);
        mainScreen.setResizable(false);
        mainScreen.setLayout(null);
        mainScreen.setLocationRelativeTo(null);
        mainScreen.getContentPane().setBackground(Color.black);
        mainScreen.setIconImage(appIcon.getImage());

        addButton = new JButton("Dodaj salę");
        addButton.addActionListener(this);
        addButton.setVisible(true);
        addButton.setBounds(50,200,500,50);
        mainScreen.add(addButton);

        deleteButton = new JButton("Usuń salę");
        deleteButton.addActionListener(this);
        deleteButton.setVisible(true);
        deleteButton.setBounds(50,300,500,50);
        mainScreen.add(deleteButton);

        backButton = new JButton("Cofnij");
        backButton.addActionListener(this);
        backButton.setBounds(1200,900,200,30);
        mainScreen.add(backButton);

        logoLabel= new JLabel();
        logoLabel.setVisible(true);
        logoLabel.setIcon(logo);
        logoLabel.setBounds(600, 200, 800,640);
        logoLabel.setForeground(Color.white);
        mainScreen.add(logoLabel);

        addLabel = new JLabel();
        addLabel.setVisible(false);
        addLabel.setBounds(100,200,150,50);
        addLabel.setForeground(Color.white);
        addLabel.setText("Wpisz ID sali do dodania");
        mainScreen.add(addLabel);

        numberOfHallToAdd = new JTextField();
        numberOfHallToAdd.setVisible(false);
        numberOfHallToAdd.setText("Np. 3");
        numberOfHallToAdd.setBounds(250, 200, 250, 50);
        mainScreen.add(numberOfHallToAdd);

        deleteLabel = new JLabel();
        deleteLabel.setVisible(false);
        deleteLabel.setBounds(100,200,150,50);
        deleteLabel.setForeground(Color.white);
        deleteLabel.setText("Wpisz ID sali do usunięcia");
        mainScreen.add(deleteLabel);

        numberOfHallToDelete = new JTextField();
        numberOfHallToDelete.setVisible(false);
        numberOfHallToDelete.setText("Np. 3");
        numberOfHallToDelete.setBounds(250, 200, 250, 50);
        mainScreen.add(numberOfHallToDelete);

        nextButton = new JButton("Akceptuj");
        nextButton.setVisible(false);
        nextButton.addActionListener(this);
        nextButton.setBounds(1000,800,200,30);
        mainScreen.add(nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        SQLManagmentClass query = new SQLManagmentClass();

        if(source==backButton)
        {
            mainScreen.dispose();
            new AdminSiteManagment();
        }
        else if(source==addButton)
        {
            flag=1;
            addButton.setVisible(false);
            deleteButton.setVisible(false);

            addLabel.setVisible(true);
            numberOfHallToAdd.setVisible(true);
            nextButton.setVisible(true);
        }
        else if(source==deleteButton)
        {
            flag=2;
            addButton.setVisible(false);
            deleteButton.setVisible(false);

            deleteLabel.setVisible(true);
            numberOfHallToDelete.setVisible(true);
            nextButton.setVisible(true);
        }
        else if(source==nextButton)
        {
            switch (flag)
            {
                case 1:

                    try
                    {
                        query.addHall(numberOfHallToAdd.getText());
                    }
                    catch (Exception e1)
                    {
                        e1.printStackTrace();
                    }

                    addLabel.setVisible(false);
                    numberOfHallToAdd.setVisible(false);
                    nextButton.setVisible(false);

                    mainScreen.dispose();
                    break;

                case 2:

                    query.deleteHall(numberOfHallToDelete.getText());

                    deleteLabel.setVisible(false);
                    numberOfHallToDelete.setVisible(false);
                    nextButton.setVisible(false);

                    mainScreen.dispose();
                    break;

                default:
                    System.out.println("Wyjątek!!! Nie wykonano kwerendy!");
                     break;
            }
        }
    }
}
