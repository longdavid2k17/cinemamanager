package TicketsPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PrintTicket
{
    int ID_HALL, count1, count2, count3, count4;
    String NAME_OF_MOVIE, time;

    public PrintTicket(int ID_HALL, String NAME_OF_MOVIE, String time, int count1, int count2, int count3, int count4) throws IOException
    {
        Random generator = new Random();

        this.ID_HALL = ID_HALL;
        this.NAME_OF_MOVIE = NAME_OF_MOVIE;
        this.time = time;
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
        this.count4 = count4;

        for(int i=0; i<count1;i++)
        {
            try
            {
                int ticket_id1 = generator.nextInt(1000)+1;

                FileWriter fileWriter = new FileWriter("ticket_ulg_stud_"+ticket_id1+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write("CinemaCity");
                bufferedWriter.write("\n");
                bufferedWriter.write("Numer biletu: " + ticket_id1);
                bufferedWriter.write("\n");
                bufferedWriter.write(NAME_OF_MOVIE);
                bufferedWriter.write("\n");
                bufferedWriter.write("Numer sali: " + ID_HALL);
                bufferedWriter.write("\n");
                bufferedWriter.write("Godzina seansu: " + time);
                bufferedWriter.write("\n");
                bufferedWriter.write("Bilet ulgowy uczniowski");
                bufferedWriter.close();
            }

            catch (Exception exeption)
            {
                System.out.println(exeption);
            }
        }

        for(int i=0; i<count2;i++)
        {
            try
            {
                int ticket_id2 = generator.nextInt(1000)+1;

                FileWriter fileWriter = new FileWriter("ticket_ulg_ucz_"+ticket_id2+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write("CinemaCity");
                bufferedWriter.write("\n");
                bufferedWriter.write("Numer biletu: " + ticket_id2);
                bufferedWriter.write("\n");
                bufferedWriter.write(NAME_OF_MOVIE);
                bufferedWriter.write("\n");
                bufferedWriter.write("Numer sali: " + ID_HALL);
                bufferedWriter.write("\n");
                bufferedWriter.write("Godzina seansu: " + time);
                bufferedWriter.write("\n");
                bufferedWriter.write("Bilet ulgowy studencki");
                bufferedWriter.close();
            }

            catch (Exception exeption)
            {
                System.out.println(exeption);
            }
        }

        for(int i=0; i<count3;i++)
        {
            try
            {
                int ticket_id3 = generator.nextInt(1000)+1;

                FileWriter fileWriter = new FileWriter("ticket_normal_"+ticket_id3+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write("CinemaCity");
                bufferedWriter.write("\n");
                bufferedWriter.write("Numer biletu: " + ticket_id3);
                bufferedWriter.write("\n");
                bufferedWriter.write(NAME_OF_MOVIE);
                bufferedWriter.write("\n");
                bufferedWriter.write("Numer sali: " + ID_HALL);
                bufferedWriter.write("\n");
                bufferedWriter.write("Godzina seansu: " + time);
                bufferedWriter.write("\n");
                bufferedWriter.write("Bilet normalny");
                bufferedWriter.close();
            }

            catch (Exception exeption)
            {
                System.out.println(exeption);
            }
        }

        for(int i=0; i<count4;i++)
        {
            try
            {
                int ticket_id4 = generator.nextInt(1000)+1;

                FileWriter fileWriter = new FileWriter("ticket_senior_"+ticket_id4+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write("CinemaCity");
                bufferedWriter.write("\n");
                bufferedWriter.write("Numer biletu: " + ticket_id4);
                bufferedWriter.write("\n");
                bufferedWriter.write(NAME_OF_MOVIE);
                bufferedWriter.write("\n");
                bufferedWriter.write("Numer sali: " + ID_HALL);
                bufferedWriter.write("\n");
                bufferedWriter.write("Godzina seansu: " + time);
                bufferedWriter.write("\n");
                bufferedWriter.write("Bilet seniora");
                bufferedWriter.close();
            }

            catch (Exception exeption)
            {
                System.out.println(exeption);
            }
        }

    }
}
