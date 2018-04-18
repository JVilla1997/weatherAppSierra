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
    private GImage gIcon;

    public GUI()
    {
        start();
        setSize(390, 358);
    }
    // testing 123
    public void init()
    {
        GCanvas canvas = new GCanvas();
        add(canvas);
        //add image
        GImage Fair_Weather = new GImage("images/Fair_Weather.jpg");
        canvas.add(Fair_Weather,0 ,0 );


        JLabel zipLabel = new JLabel("Zip");
        JLabel cityLabel = new JLabel("City");
        JLabel tempLabel = new JLabel("Temp");
        JLabel conditionLabel = new JLabel("Condition");


        zipField = new JTextField();
        cityField = new JTextField();
        tempField = new JTextField();
        conditionField = new JTextField();
        gIcon = new GImage("");


        JButton goButton = new JButton("Go");
        JButton clearButton = new JButton("Clear");

        canvas.add(zipLabel, 20, 20);
        canvas.add(cityLabel, 20, 70);
        canvas.add(tempLabel, 20, 120);
        canvas.add(conditionLabel, 20, 170);
        canvas.add(gIcon, 250, 145);

        canvas.add(zipField, 80, 20);
        canvas.add(cityField, 80, 70);
        canvas.add(tempField, 80, 120);
        canvas.add(conditionField, 80, 170);
        zipField.setSize(150, 20);
        cityField.setSize(150, 20);
        tempField.setSize(150, 20);
        conditionField.setSize(150, 20);


        canvas.add(goButton, 60,220);
        canvas.add(clearButton, 160, 220);

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