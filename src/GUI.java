import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.Program;

import javax.swing.*;
import java.awt.event.ActionEvent;



public class GUI extends Program
{
    private JTextField zipField;
    private JTextField cityField;
    private JTextField tempField;
    private JTextField conditionField;
    private JTextField dateField;
    private JTextField timeField;
    private GImage gIcon;

    public GUI()
    {
        start();
        setSize(390, 500);
    }
    // testing 123
    public void init()
    {
        GCanvas canvas = new GCanvas();
        add(canvas);
        //add background
        GImage weatherappgroup = new GImage("images/weatherappgroup.png");
        canvas.add(weatherappgroup,0 ,0 );


        JLabel zipLabel = new JLabel("Zip");
        JLabel cityLabel = new JLabel("City");
        JLabel tempLabel = new JLabel("Temp");
        JLabel conditionLabel = new JLabel("Condition");
        JLabel dateLabel = new JLabel("Date");
        JLabel timeLabel = new JLabel("time");


        zipField = new JTextField();
        cityField = new JTextField();
        tempField = new JTextField();
        conditionField = new JTextField();
        dateField = new JTextField();
        timeField = new JTextField();
        gIcon = new GImage("");


        JButton goButton = new JButton("Go");
        JButton clearButton = new JButton("Clear");

        canvas.add(zipLabel, 40, 20);
        canvas.add(cityLabel, 40, 70);
        canvas.add(tempLabel, 40, 120);
        canvas.add(conditionLabel, 40, 170);
        canvas.add(dateLabel, 40, 220);
        canvas.add(timeLabel, 40, 270);
        canvas.add(gIcon, 250, 145);

        canvas.add(zipField, 100, 20);
        canvas.add(cityField, 100, 70);
        canvas.add(tempField, 100, 120);
        canvas.add(conditionField, 100, 170);
        canvas.add(dateField, 100, 220);
        canvas.add(timeField, 100, 270);
        zipField.setSize(150, 20);
        cityField.setSize(150, 20);
        tempField.setSize(150, 20);
        conditionField.setSize(150, 20);
        dateField.setSize(150, 20);
        timeField.setSize(150, 20);


        canvas.add(goButton, 80,320);
        canvas.add(clearButton, 180, 320);

        addActionListeners();
    }
    ///comment
    public void actionPerformed(ActionEvent e)
    {
        String what = e.getActionCommand();

        if (what.equals("Go"))
        {
            Class b = new Class(zipField.getText());
            cityField.setText(b.getLoc());
            tempField.setText(b.getTemp());
            conditionField.setText(b.getConditions());
            gIcon.setImage(b.getIcon());

        }
        else if (what.equals("Clear"))
        {
            zipField.setText("");
            cityField.setText("");
            tempField.setText("");
            conditionField.setText("");
            gIcon.setImage("");
        }
    }

    public static void main(String[] args)
    {
        GUI g = new GUI();
    }
}