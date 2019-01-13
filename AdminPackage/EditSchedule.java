package AdminPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditSchedule extends JFrame implements ActionListener
{
    JFrame editScheduleFrame, addFrame, deleteFrame, editFrame;
    JButton addMovieButton, deleteMovieButton, changeShowTimeButton, backButton;
    JLabel logoLabel;
    /// for add movie layout
    JLabel nameLabel, hourLabel,hallIDLabel;
    JTextField nameField, hourField, hallIDField;
    JButton submitButton;
    //for delete movie layout
    JButton hall1Button, hall2Button, hall3Button, hall4Button, movieButton;
    String buttonLabel;
    String name;
    //for change date layout
    JButton movieButton1, movieButton2, movieButton3, changeButton;
    String buttonLabel1,buttonLabel2, buttonLabel3;
    JTextField hourFieldChange;
    int flag=0;


    EditSchedule() throws Exception {

        ImageIcon appIcon = new ImageIcon("icon.png");
        ImageIcon logo = new ImageIcon("cinema_image.png");


        editScheduleFrame = new JFrame();
        editScheduleFrame.setTitle("Edycja harmonogramu");
        editScheduleFrame.setSize(1500,1000);
        editScheduleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editScheduleFrame.setVisible(true);
        editScheduleFrame.setResizable(false);
        editScheduleFrame.setLayout(null);
        editScheduleFrame.setLocationRelativeTo(null);
        editScheduleFrame.getContentPane().setBackground(Color.black);
        editScheduleFrame.setIconImage(appIcon.getImage());

        addMovieButton = new JButton("Dodaj film do harmonogramu");
        addMovieButton.addActionListener(this);
        addMovieButton.setVisible(true);
        addMovieButton.setBounds(50,200,500,50);
        editScheduleFrame.add(addMovieButton);

        deleteMovieButton = new JButton("Usuń film z harmonogramu");
        deleteMovieButton.addActionListener(this);
        deleteMovieButton.setVisible(true);
        deleteMovieButton.setBounds(50,300,500,50);
        editScheduleFrame.add(deleteMovieButton);

        changeShowTimeButton = new JButton("Zmień godzinę wyświetlania filmu");
        changeShowTimeButton.addActionListener(this);
        changeShowTimeButton.setVisible(true);
        changeShowTimeButton.setBounds(50,400,500,50);
        editScheduleFrame.add(changeShowTimeButton);

        logoLabel= new JLabel();
        logoLabel.setVisible(true);
        logoLabel.setIcon(logo);
        logoLabel.setBounds(600, 200, 800,640);
        logoLabel.setForeground(Color.white);
        editScheduleFrame.add(logoLabel);

        backButton = new JButton("Cofnij");
        backButton.addActionListener(this);
        backButton.setBounds(1200,900,200,30);
        editScheduleFrame.add(backButton);

        ////////////////////////
        /**
         * layout pod dodanie filmu
         * layout for movie adding
         */

        addFrame = new JFrame();
        addFrame.setTitle("Dodaj film");
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.setVisible(false);
        addFrame.setSize(600, 500);
        addFrame.setLocationRelativeTo(null);
        addFrame.setResizable(false);
        addFrame.setLayout(null);
        addFrame.getContentPane().setBackground(Color.black);
        addFrame.setIconImage(appIcon.getImage());

        nameLabel = new JLabel();
        nameLabel.setText("Nazwa filmu: ");
        nameLabel.setVisible(true);
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(50,50,150,50);
        addFrame.add(nameLabel);

        hourLabel = new JLabel();
        hourLabel.setText("Godzina seansu: ");
        hourLabel.setVisible(true);
        hourLabel.setForeground(Color.white);
        hourLabel.setBounds(50,120,150,50);
        addFrame.add(hourLabel);

        hallIDLabel = new JLabel();
        hallIDLabel.setText("ID sali: ");
        hallIDLabel.setVisible(true);
        hallIDLabel.setForeground(Color.white);
        hallIDLabel.setBounds(50,190,150,50);
        addFrame.add(hallIDLabel);

        nameField = new JTextField();
        nameField.setVisible(true);
        nameField.setBounds(200, 50, 250, 50);
        addFrame.add(nameField);

        hourField = new JTextField();
        hourField.setVisible(true);
        hourField.setText("HH:MM");
        hourField.setBounds(200, 120, 250, 50);
        addFrame.add(hourField);

        hallIDField = new JTextField();
        hallIDField.setVisible(true);
        hallIDField.setText("np. 2");
        hallIDField.setBounds(200, 190, 250, 50);
        addFrame.add(hallIDField);

        submitButton = new JButton("Dodaj film");
        submitButton.setVisible(true);
        submitButton.setBounds(200,400,200,50);
        addFrame.add(submitButton);
        submitButton.addActionListener(this);

        /**
         * layout pod usuwanie filmów
         * layout for deleteFrame
         */


        deleteFrame = new JFrame();
        deleteFrame.setTitle("Usuń film");
        deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteFrame.setVisible(false);
        deleteFrame.setSize(600, 500);
        deleteFrame.setLocationRelativeTo(null);
        deleteFrame.setResizable(false);
        deleteFrame.setLayout(null);
        deleteFrame.getContentPane().setBackground(Color.black);
        deleteFrame.setIconImage(appIcon.getImage());

        hall1Button = new JButton("Sala 1");
        hall1Button.setVisible(true);
        hall1Button.setBounds(200,50,200,50);
        deleteFrame.add(hall1Button);
        hall1Button.addActionListener(this);

        hall2Button = new JButton("Sala 2");
        hall2Button.setVisible(true);
        hall2Button.setBounds(200,150,200,50);
        deleteFrame.add(hall2Button);
        hall2Button.addActionListener(this);

        hall3Button = new JButton("Sala 3");
        hall3Button.setVisible(true);
        hall3Button.setBounds(200,250,200,50);
        deleteFrame.add(hall3Button);
        hall3Button.addActionListener(this);

        hall4Button = new JButton("Sala 4");
        hall4Button.setVisible(true);
        hall4Button.setBounds(200,350,200,50);
        deleteFrame.add(hall4Button);
        hall4Button.addActionListener(this);

        movieButton = new JButton();
        movieButton.setVisible(false);
        movieButton.setBounds(200,100,200,50);
        deleteFrame.add(movieButton);
        movieButton.addActionListener(this);

        deleteFrame.repaint();

        /**
         * layout pod zmiane godziny
         * layout for editFrame
         */
        SQLManagmentClass query = new SQLManagmentClass();

        editFrame = new JFrame();
        editFrame.setTitle("Zmień godzinę filmu");
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.setVisible(false);
        editFrame.setSize(600, 500);
        editFrame.setLocationRelativeTo(null);
        editFrame.setResizable(false);
        editFrame.setLayout(null);
        editFrame.getContentPane().setBackground(Color.black);
        editFrame.setIconImage(appIcon.getImage());

        query.getCinemaData("SELECT * FROM harmonogram WHERE id_filmu = 1");
        buttonLabel1 = query.movieName+" | Sala nr"+query.id_hall+" | Godzina: "+ query.time;
        String id1 = query.id_movie;
        query.getCinemaData("SELECT * FROM harmonogram WHERE id_filmu = 2");
        buttonLabel2 = query.movieName+" | Sala nr"+query.id_hall+" | Godzina: "+ query.time;
        String id2 = query.id_movie;
        query.getCinemaData("SELECT * FROM harmonogram WHERE id_filmu = 3");
        buttonLabel3 = query.movieName+" | Sala nr"+query.id_hall+" | Godzina: "+ query.time;
        String id3 = query.id_movie;

        movieButton1 = new JButton(buttonLabel1);
        movieButton1.setVisible(true);
        movieButton1.setBounds(50,100,300,50);
        editFrame.add(movieButton1);
        movieButton1.addActionListener(this);

        movieButton2 = new JButton(buttonLabel2);
        movieButton2.setVisible(true);
        movieButton2.setBounds(50,200,300,50);
        editFrame.add(movieButton2);
        movieButton2.addActionListener(this);

        movieButton3 = new JButton(buttonLabel3);
        movieButton.setVisible(true);
        movieButton3.setBounds(50,300,300,50);
        editFrame.add(movieButton3);
        movieButton3.addActionListener(this);

        hourFieldChange = new JTextField();
        hourFieldChange.setVisible(false);
        hourFieldChange.setText("HH:MM");
        hourFieldChange.setBounds(200, 120, 250, 50);
        editFrame.add(hourFieldChange);

        changeButton = new JButton("Zmień godzinę");
        changeButton.setVisible(false);
        changeButton.setBounds(200,400,200,50);
        editFrame.add(changeButton);
        changeButton.addActionListener(this);

        editScheduleFrame.repaint();
        addFrame.repaint();
        editFrame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        SQLManagmentClass query1 = new SQLManagmentClass();
        Object source = e.getSource();

        if(source==addMovieButton)
        {
            addFrame.setVisible(true);
        }

        else if(source==deleteMovieButton)
        {
            deleteFrame.setVisible(true);
        }

        else if(source==changeShowTimeButton)
        {
            editFrame.setVisible(true);
        }

        else if(source==backButton)
        {
            editScheduleFrame.dispose();
            new AdminSiteManagment();
        }
        else if(source==submitButton)
        {
            try
            {
                query1.sendNewMovie("INSERT INTO harmonogram VALUES ('"+10+"','"+nameField.getText()+"','"+hallIDField.getText()+"','"+hourField.getText()+"','"+0+"');");
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            addFrame.dispose();
        }
        else if(source==hall1Button)
        {
            hall1Button.setVisible(false);
            hall2Button.setVisible(false);
            hall3Button.setVisible(false);
            hall4Button.setVisible(false);

            try
            {
                query1.getMovieList(1);
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            buttonLabel = query1.movieName+" | Sala nr"+query1.id_hall+" | Godzina: "+ query1.time;
            movieButton.setText(buttonLabel);
            name = query1.movieName;
            movieButton.setVisible(true);

        }
        else if(source==hall2Button)
        {
            hall1Button.setVisible(false);
            hall2Button.setVisible(false);
            hall3Button.setVisible(false);
            hall4Button.setVisible(false);

            try
            {
                query1.getMovieList(2);
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            buttonLabel = query1.movieName+" | Sala nr"+query1.id_hall+" | Godzina: "+ query1.time;
            movieButton.setText(buttonLabel);
            name = query1.movieName;
            movieButton.setVisible(true);
        }
        else if(source==hall3Button)
        {
            hall1Button.setVisible(false);
            hall2Button.setVisible(false);
            hall3Button.setVisible(false);
            hall4Button.setVisible(false);

            try
            {
                query1.getMovieList(3);
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            buttonLabel = query1.movieName+" | Sala nr"+query1.id_hall+" | Godzina: "+ query1.time;
            movieButton.setText(buttonLabel);
            name = query1.movieName;
            movieButton.setVisible(true);
        }
        else if(source==hall4Button)
        {
            hall1Button.setVisible(false);
            hall2Button.setVisible(false);
            hall3Button.setVisible(false);
            hall4Button.setVisible(false);

            try
            {
                query1.getMovieList(4);
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            buttonLabel = query1.movieName+" | Sala nr"+query1.id_hall+" | Godzina: "+ query1.time;
            name = query1.movieName;
            movieButton.setText(buttonLabel);
            movieButton.setVisible(true);
        }
        else if(source==movieButton)
        {
            movieButton.setVisible(false);
            query1.deleteMovie(name);
            deleteFrame.dispose();
        }
        else if(source==movieButton1)
        {
            movieButton1.setVisible(false);
            movieButton2.setVisible(false);
            movieButton3.setVisible(false);

            flag=1;

            hourFieldChange.setVisible(true);
            changeButton.setVisible(true);
        }
        else if(source==movieButton2)
        {
            movieButton1.setVisible(false);
            movieButton2.setVisible(false);
            movieButton3.setVisible(false);

            flag=2;

            hourFieldChange.setVisible(true);
            changeButton.setVisible(true);
        }
        else if(source==movieButton3)
        {
            movieButton1.setVisible(false);
            movieButton2.setVisible(false);
            movieButton3.setVisible(false);

            flag=3;

            hourFieldChange.setVisible(true);
            changeButton.setVisible(true);
        }
        else if(source==changeButton)
        {
            hourFieldChange.setVisible(false);
            changeButton.setVisible(false);

            query1.changeDate(flag, hourFieldChange.getText());

            editFrame.dispose();
        }
    }
}
