package PreviewPackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CinemaHalls extends JFrame
{
    JFrame hall, moviesSchedule;
    JLabel hallImage;
    int id;
    String PicURL="hall_image.jpg";

    CinemaHalls(int hallID) throws IOException
    {

    ImageIcon appIcon = new ImageIcon("icon.png");
    this.id = hallID;

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
    moviesSchedule.setLocationRelativeTo(null);
    moviesSchedule.getContentPane().setBackground(Color.black);
    moviesSchedule.setIconImage(appIcon.getImage());


    ImageIcon imgThisImg = new ImageIcon(PicURL);
    hallImage = new JLabel();
    hallImage.setIcon(imgThisImg);
    //allImage.setBounds(500,250,1000,500);
    hallImage.setLocation(500,250);
    hall.add(hallImage);

    hall.repaint();
    hall.pack();
    }
}
