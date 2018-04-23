import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;



public class GUI extends Program
{
    private JTextField zip;
    private JLabel date;
    private JLabel city;
    private JLabel temp;
    private JLabel condition;
    private JLabel time;
    private GImage icon;

    public GUI()
    {
        start();
        setSize(650, 850);
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
        /*GImage background = new GImage("images/appBackground");
        canvas.add(background,0 ,0 );
        canvas.setSize(650, 850);*/


        //JLabel zipLabel = new JLabel("Zip");
        //JLabel cityLabel = new JLabel("City");
        //JLabel tempLabel = new JLabel("Temp");
        //JLabel conditionLabel = new JLabel("Condition");
        //JLabel dateLabel = new JLabel("Date");
        //JLabel timeLabel = new JLabel("time");

        //Fonts
        Font comicSans = new Font("Comic Sans MS", Font.BOLD, 50);
        Font planeBold = new Font( "Times New Romans", Font.BOLD, 25);

        // Fields
        zip = new JTextField();
        canvas.add(zip,75, 0);
        zip.setSize(225, 25);

        date = new JLabel("");
        canvas.add(date,110,30);
        date.setSize(150, 20);
        date.setFont(planeBold);

        temp = new JLabel("");
        canvas.add(temp,110, 70);
        temp.setSize(150, 20);
        temp.setSize(temp.getPreferredSize());
        temp.setFont(comicSans);
        temp.setForeground(Color.WHITE);

        city = new JLabel("");
        canvas.add(city,110, 150);
        city.setSize(150, 20);
        city.setSize(city.getPreferredSize());
        city.setFont(planeBold);

        condition = new JLabel("");
        canvas.add(condition, 30, 120);
        condition.setSize(150, 20);

        time = new JLabel();
        canvas.add(time, 100, 270);
        time.setSize(150, 20);

        icon = new GImage("");
        canvas.add(icon,30, 60);
        icon.setSize(500, 500);


        // Buttons
        JButton goButton = new JButton("Search");
        canvas.add(goButton, 0,0);

        JButton clearButton = new JButton("Clear");
        canvas.add(clearButton, 300, 0);

        addActionListeners();
    }
    ///comment
    public void actionPerformed(ActionEvent e)
    {
        String what = e.getActionCommand();

        if (what.equals("Search"))
        {
            Class b = new Class(zip.getText());
            Forecast f = new Forecast(0);
            city.setText(b.getLoc());
            city.setSize(city.getPreferredSize());
            temp.setText(b.getTemp());
            temp.setSize(temp.getPreferredSize());
            date.setText(f.getToday(0));
            date.setSize(date.getPreferredSize());
            condition.setText(b.getConditions());
            condition.setSize(condition.getPreferredSize());
            icon.setImage(b.getIcon());


        }
        else if (what.equals("Clear"))
        {
            zip.setText("");
            city.setText("City,State");
            temp.setText("0.0F");
            condition.setText("Forcast");
            icon.setImage("");
        }
    }

    public static void main(String[] args)
    {
        GUI g = new GUI();
    }
}