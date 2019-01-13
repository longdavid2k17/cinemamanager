package PreviewPackage;

import AdminPackage.SQLManagmentClass;

import javax.swing.*;
import java.awt.*;


public class CinemaHalls extends JFrame
{
    JFrame hall, moviesSchedule;
    JLabel hallImage, scheduleLabel, timeLabel;
    int id;
    String PicURL="hall_image.jpg";
    String movie_name, timeOfShow;

    CinemaHalls(int hallID) throws Exception
    {
    ImageIcon appIcon = new ImageIcon("icon.png");
    this.id = hallID;

    SQLManagmentClass query = new SQLManagmentClass();

    query.getCinemaData("SELECT * FROM harmonogram WHERE sale_id="+id);
    movie_name = query.movieName;
    timeOfShow = query.time;

    hall = new JFrame();
    hall.setTitle("Podgląd sali "+id);
    hall.setSize(1500,1000);
    hall.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    hall.setVisible(true);
    hall.setResizable(false);
    hall.setLocationRelativeTo(null);
    hall.getContentPane().setBackground(Color.black);
    hall.setIconImage(appIcon.getImage());

    moviesSchedule = new JFrame();
    moviesSchedule.setTitle("Teraz grane na sali nr "+id);
    moviesSchedule.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    moviesSchedule.setVisible(true);
    moviesSchedule.setSize(400,900);
    moviesSchedule.setResizable(false);
    moviesSchedule.setLocationRelativeTo(hall);
    moviesSchedule.getContentPane().setBackground(Color.black);
    moviesSchedule.setIconImage(appIcon.getImage());

    scheduleLabel = new JLabel();
    scheduleLabel.setText(movie_name);
    scheduleLabel.setBounds(10,40,250,30);
    scheduleLabel.setVisible(true);
    scheduleLabel.setForeground(Color.white);
    moviesSchedule.add(scheduleLabel);

    timeLabel = new JLabel();
    timeLabel.setText("O godzinie: "+timeOfShow);
    timeLabel.setBounds(10,70,250,30);
    timeLabel.setVisible(true);
    timeLabel.setForeground(Color.white);
    moviesSchedule.add(timeLabel);



    ImageIcon imgThisImg = new ImageIcon(PicURL);
    hallImage = new JLabel();
    hallImage.setIcon(imgThisImg);
    //allImage.setBounds(500,250,1000,500);
    hallImage.setLocation(500,250);
    hall.add(hallImage);

    hall.repaint();
    hall.pack();
    moviesSchedule.repaint();
    }
}
