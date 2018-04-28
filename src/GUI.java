import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.Program;
import acm.program.*;
import acm.graphics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class GUI extends Program
{
    private JTextField zip;
    private JLabel date;
    private JLabel city;
    private JLabel tempF;
    private JLabel tempC;
    private JLabel condition;
    private JLabel time;
    private GImage icon;
    private GImage radar;
    private JLabel[] days;
    private GImage[] dayIcons;
    private JLabel[] forecastHigh;
    private JLabel[] forecastLow;

    public GUI()
    {
        start();
        setSize(550, 980);
    }
    // testing 123
    public void init()
    {
        GCanvas canvas = new GCanvas();
        add(canvas);

        //Background color
        Color blueColor = new Color(66, 170, 244);
        canvas.setBackground(blueColor);

        //add background - TO BE FIXED
        GImage background = new GImage("images/appBackground.jpg");
        canvas.add(background,0 ,0 );
        background.setSize(650,1020 );

        // Fonts
        Font comicSans = new Font("Comic Sans MS", Font.BOLD, 50);
        Font planeBold = new Font( "Times New Romans", Font.BOLD, 25);

        // Border
        Border blackBorder = new LineBorder(Color.BLACK, 2);

        // Fields
        zip = new JTextField();
        canvas.add(zip,110, 20);
        zip.setSize(320, 25);
        zip.setBorder(blackBorder);

        // Buttons
        JButton goButton = new JButton("Search");
        canvas.add(goButton, 20,20);
        goButton.setBorder(blackBorder);

        JButton clearButton = new JButton("Clear");
        canvas.add(clearButton, 450, 20);
        clearButton.setBorder(blackBorder);

        // JLabel
        date = new JLabel("");
        canvas.add(date,110,70);
        date.setSize(150, 20);
        date.setFont(planeBold);

        tempF = new JLabel("");
        canvas.add(tempF,110, 110);
        tempF.setSize(150, 20);
        tempF.setSize(tempF.getPreferredSize());
        tempF.setFont(comicSans);
        tempF.setForeground(Color.WHITE);

        tempC = new JLabel("");
        canvas.add(tempC,230, 140);
        tempC.setSize(80, 20);
        tempC.setSize(tempC.getPreferredSize());
        tempC.setFont(planeBold);
        tempC.setForeground(Color.BLACK);

        city = new JLabel("");
        canvas.add(city,110, 190);
        city.setSize(150, 20);
        city.setSize(city.getPreferredSize());
        city.setFont(planeBold);

        condition = new JLabel("");
        canvas.add(condition, 380, 215);
        condition.setSize(150, 20);

        icon = new GImage("");
        canvas.add(icon,350, 110);
        icon.setSize(500, 500);

        time = new JLabel(); // commit
        canvas.add(time, 100, 270);
        time.setSize(150, 20);

        radar = new GImage("");
        canvas.add(radar, 110, 500);
        radar.setSize(200, 200);

        GRect line = new GRect(355, 0);
        canvas.add(line, 90, 230);

        GRect lineTwo = new GRect(355, 0);
        canvas.add(lineTwo, 90, 370);

        days = new JLabel[5];
        forecastHigh = new JLabel[5];
        forecastLow = new JLabel[5];
        dayIcons = new GImage[5];

        for (int i = 0; i < 5; i++)
        {
            days[i] = new JLabel("");
            days[i].setSize(69, 20);
            canvas.add(days[i], 110 + i * 69, 250);

            forecastHigh[i] = new JLabel("");
            forecastHigh[i].setSize(69, 20);
            canvas.add(forecastHigh[i], 110 + i * 69, 270);

            forecastLow[i] = new JLabel("");
            forecastLow[i].setSize(69, 20);
            canvas.add(forecastLow[i], 110 + i * 69, 290);

            dayIcons[i] = new GImage("");
            canvas.add(dayIcons[i], 97.5 + i * 69, 310);
        }

        addActionListeners();
    }

    public void actionPerformed(ActionEvent e)
    {
        String what = e.getActionCommand();

        if (what.equals("Search"))
        {
            Weather w = new Weather(zip.getText());
            date.setText(w.getLongDate());
            date.setSize(date.getPreferredSize());
            city.setText(w.getCityState());
            city.setSize(city.getPreferredSize());
            tempF.setText(Double.toString(w.getTemperatureF()));
            tempF.setSize(tempF.getPreferredSize());
            tempC.setText(Double.toString(w.getTemperatureC()));
            tempC.setSize(tempC.getPreferredSize());
            condition.setText(w.getWeather());
            condition.setSize(condition.getPreferredSize());
            icon.setImage("icons/" + w.getIcon());
            icon.setSize(100, 100);
            for (int i = 0; i < 10; i++)
            {
                days[i].setText("<html><div style='text-align: center;'>" + w.getDay(i) + "</div></html>");
                forecastHigh[i].setText("H: " + w.getHighF(i));
                forecastLow[i].setText("L: " + w.getLowF(i));
                dayIcons[i].setImage(w.getForecastIcon(i));
            }
            days[0].setText("<html><div style='text-align: center;'> Today </div></html>");
        }
        else if (what.equals("Clear"))
        {
            zip.setText("");
            date.setText("");
            city.setText("");
            tempF.setText("");
            tempC.setText("");
            condition.setText("");
            icon.setImage("");
            for(int i = 0; i < 10; i++)
            {
                days[i].setText("");
                dayIcons[i].setImage("");
                forecastHigh[i].setText("");
                forecastLow[i].setText("");
            }
        }
    }

    public static void main(String[] args)
    {
        GUI g = new GUI();
    }

}