import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.Program;

import javax.swing.*;
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

        //add background - TO BE FIXED
        /*GImage background = new GImage("images/appBackground");
        canvas.add(background,0 ,0 );
        canvas.setSize(650, 850);*/


        //JLabel zipLabel = new JLabel("Zip");
        JLabel cityLabel = new JLabel("City");
        JLabel tempLabel = new JLabel("Temp");
        JLabel conditionLabel = new JLabel("Condition");
        JLabel dateLabel = new JLabel("Date");
        JLabel timeLabel = new JLabel("time");

        // Fields
        zip = new JTextField();
        canvas.add(zip, 100, 25);
        zip.setSize(150, 20);

        date = new JLabel();
        canvas.add(date, 100, 70);
        date.setSize(150, 20);

        city = new JLabel();
        canvas.add(city, 100, 220);
        city.setSize(150, 20);

        temp = new JLabel();
        canvas.add(temp, 100, 120);
        temp.setSize(150, 20);

        condition = new JLabel();
        canvas.add(condition, 100, 170);
        condition.setSize(150, 20);

        time = new JLabel();
        canvas.add(time, 100, 270);
        time.setSize(150, 20);

        icon = new GImage("");
        canvas.add(icon,250, 120);
        icon.setSize(500, 500);


        // Buttons
        JButton goButton = new JButton("Go");
        canvas.add(goButton, 40,20);

        JButton clearButton = new JButton("Clear");
        canvas.add(clearButton, 260, 20);

        addActionListeners();
    }
    ///comment
    public void actionPerformed(ActionEvent e)
    {
        String what = e.getActionCommand();

        if (what.equals("Go"))
        {
            Class b = new Class(zip.getText());
            city.setText(b.getLoc());
            temp.setText(b.getTemp());
            condition.setText(b.getConditions());
            icon.setImage(b.getIcon());


        }
        else if (what.equals("Clear"))
        {
            zip.setText("");
            city.setText("");
            temp.setText("");
            condition.setText("");
            icon.setImage("");
        }
    }

    public static void main(String[] args)
    {
        GUI g = new GUI();
    }
}