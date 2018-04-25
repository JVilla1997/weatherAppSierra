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
    private GImage icon1;
    private GImage icon2;
    private GImage icon3;
    private GImage icon4;
    private GImage icon5;

    public GUI()
    {
        start();
        setSize(650, 840);
    }
    // testing 123
    public void init()
    {
        GCanvas canvas = new GCanvas();
        add(canvas);

        //Background color
        Color blueColor = new Color(66, 170, 244);
        Color darkBlue = new Color(20,20,100);
        canvas.setBackground(blueColor);

        //Forecast f = new Forecast(0);

        //add background - TO BE FIXED
        /*GImage background = new GImage("images/appBackground");
        canvas.add(background,0 ,0 );
        canvas.setSize(650, 850);*/

        //JLabel cityLabel = new JLabel("City");
        //JLabel tempLabel = new JLabel("Temp");
        //JLabel conditionLabel = new JLabel("Condition");
        //JLabel dateLabel = new JLabel("Date");
        //JLabel timeLabel = new JLabel("time");
        //Fonts
        Font boldLine = new Font("Times New Romans", Font.BOLD, 12);
        Font comicSans = new Font("Comic Sans MS", Font.BOLD, 50);
        Font plainBold = new Font("Times New Romans", Font.BOLD, 25);
        Font plainBold2 = new Font("Times New Romans", Font.BOLD, 18);
        Font nums = new Font("Times New Romans", Font.BOLD, 50);
        Font nums1 = new Font("Times New Romans", Font.BOLD, 35);

        JLabel divLn1 = new JLabel("___________________________________________________________");
        canvas.add(divLn1,0,250);
        divLn1.setSize(300,5);
        divLn1.setSize(divLn1.getPreferredSize());
        divLn1.setFont(boldLine);
        divLn1.setForeground(darkBlue);

        JLabel divLn2 = new JLabel("___________________________________________________________");
        canvas.add(divLn2,0,350);
        divLn2.setSize(300,5);
        divLn2.setSize(divLn2.getPreferredSize());
        divLn2.setFont(boldLine);
        divLn2.setForeground(darkBlue);

        JLabel divLn3 = new JLabel("___________________________________________________________");
        canvas.add(divLn3,0,450);
        divLn3.setSize(300,5);
        divLn3.setSize(divLn3.getPreferredSize());
        divLn3.setFont(boldLine);
        divLn3.setForeground(darkBlue);

        JLabel divLn4 = new JLabel("___________________________________________________________");
        canvas.add(divLn4,0,550);
        divLn4.setSize(300,5);
        divLn4.setSize(divLn4.getPreferredSize());
        divLn4.setFont(boldLine);
        divLn4.setForeground(darkBlue);

        JLabel divLn5 = new JLabel("___________________________________________________________");
        canvas.add(divLn5,0,650);
        divLn5.setSize(300,5);
        divLn5.setSize(divLn5.getPreferredSize());
        divLn5.setFont(boldLine);
        divLn5.setForeground(darkBlue);

        // Fields
        zip = new JTextField();
        canvas.add(zip,75, 0);
        zip.setSize(275, 25);

        date = new JLabel("");
        canvas.add(date,110,75);
        date.setSize(date.getPreferredSize());
        date.setFont(plainBold);

        temp = new JLabel("");
        canvas.add(temp,110, 110);
        //temp.setSize(150, 20);
        temp.setSize(temp.getPreferredSize());
        temp.setFont(comicSans);
        temp.setForeground(Color.WHITE);

        city = new JLabel("");
        canvas.add(city,110, 185);
        //city.setSize(150, 20);
        city.setSize(city.getPreferredSize());
        city.setFont(plainBold);

        condition = new JLabel("");
        canvas.add(condition, 260, 170);
        //condition.setSize(150, 20);
        condition.setSize(condition.getPreferredSize());

        time = new JLabel();
        canvas.add(time, 100, 270);
        time.setSize(150, 20);

        icon = new GImage("");
        canvas.add(icon,250, 120);
        icon.setSize(500, 500);

        //tomarrow
        JLabel nextDay1 = new JLabel("THUR");
        canvas.add(nextDay1, 20, 45);
        nextDay1.setSize(getPreferredSize());
        nextDay1.setFont(plainBold2);

        JLabel dy1num = new JLabel("26");
        canvas.add(dy1num, 20, 75);
        dy1num.setSize(getPreferredSize());
        dy1num.setFont(nums);

        icon1 = new GImage("");
        canvas.add(icon1, 90, 275);
        icon1.setSize(500, 500);

        JLabel forecast1 = new JLabel("mostly sunny");
        canvas.add(forecast1, 110, 90);
        forecast1.setSize(getPreferredSize());

        JLabel highLow1 = new JLabel("85.1°- 63.4°");
        canvas.add(highLow1, 150, 50);
        highLow1.setSize(getPreferredSize());
        highLow1.setFont(nums1);

        //next day 2
        JLabel nextDay2 = new JLabel("FRI");
        canvas.add(nextDay2, 20, 145);
        nextDay2.setSize(getPreferredSize());
        nextDay2.setFont(plainBold2);

        JLabel dy2num = new JLabel("27");
        canvas.add(dy2num, 20, 175);
        dy2num.setSize(getPreferredSize());
        dy2num.setFont(nums);

        icon2 = new GImage("");
        canvas.add(icon2, 90, 375);
        icon2.setSize(500, 500);

        JLabel forecast2 = new JLabel("mostly sunny");
        canvas.add(forecast2, 110, 190);
        forecast2.setSize(getPreferredSize());

        JLabel highLow2 = new JLabel("85.1°- 63.4°");
        canvas.add(highLow2, 150, 150);
        highLow2.setSize(getPreferredSize());
        highLow2.setFont(nums1);

        //next day 3
        JLabel nextDay3 = new JLabel("SAT");
        canvas.add(nextDay3, 20, 245);
        nextDay3.setSize(getPreferredSize());
        nextDay3.setFont(plainBold2);

        JLabel dy3num = new JLabel("28");
        canvas.add(dy3num, 20, 275);
        dy3num.setSize(getPreferredSize());
        dy3num.setFont(nums);

        icon3 = new GImage("");
        canvas.add(icon3, 90, 475);
        icon3.setSize(500, 500);

        JLabel forecast3 = new JLabel("mostly sunny");
        canvas.add(forecast3, 110, 290);
        forecast3.setSize(getPreferredSize());

        JLabel highLow3 = new JLabel("85.1°- 63.4°");
        canvas.add(highLow3, 150, 250);
        highLow3.setSize(getPreferredSize());
        highLow3.setFont(nums1);

        //next day 4
        JLabel nextDay4 = new JLabel("SUN");
        canvas.add(nextDay4, 20, 345);
        nextDay4.setSize(getPreferredSize());
        nextDay4.setFont(plainBold2);

        JLabel dy4num = new JLabel("29");
        canvas.add(dy4num, 20, 375);
        dy4num.setSize(getPreferredSize());
        dy4num.setFont(nums);

        icon4 = new GImage("");
        canvas.add(icon4, 90, 575);
        icon4.setSize(500, 500);

        JLabel forecast4 = new JLabel("mostly sunny");
        canvas.add(forecast4, 110, 390);
        forecast4.setSize(getPreferredSize());

        JLabel highLow4 = new JLabel("85.1°- 63.4°");
        canvas.add(highLow4, 150, 350);
        highLow4.setSize(getPreferredSize());
        highLow4.setFont(nums1);

        //next day 5
        JLabel nextDay5 = new JLabel("MON");
        canvas.add(nextDay5, 20, 445);
        nextDay5.setSize(getPreferredSize());
        nextDay5.setFont(plainBold2);

        JLabel dy5num = new JLabel("30");
        canvas.add(dy5num, 20, 475);
        dy5num.setSize(getPreferredSize());
        dy5num.setFont(nums);

        icon5 = new GImage("");
        canvas.add(icon5, 90, 675);
        icon5.setSize(500, 500);

        JLabel forecast5 = new JLabel("mostly sunny");
        canvas.add(forecast5, 110, 490);
        forecast5.setSize(getPreferredSize());

        JLabel highLow5 = new JLabel("85.1°- 63.4°");
        canvas.add(highLow5, 150, 450);
        highLow5.setSize(getPreferredSize());
        highLow5.setFont(nums1);

        // Buttons
        JButton goButton = new JButton("Search");
        canvas.add(goButton, 0,0);

        JButton clearButton = new JButton("Clear");
        canvas.add(clearButton, 350, 0);

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
            temp.setText(b.getTemp()+"°");
            temp.setSize(temp.getPreferredSize());
            date.setText(f.getToday(0));
            date.setSize(date.getPreferredSize());
            condition.setText(b.getConditions());
            condition.setSize(condition.getPreferredSize());
            icon.setImage(b.getIcon());
            icon1.setImage(b.getIcon());
            icon2.setImage(b.getIcon());
            icon3.setImage(b.getIcon());
            icon4.setImage(b.getIcon());
            icon5.setImage(b.getIcon());

        }
        else if (what.equals("Clear"))
        {
            zip.setText("");
            city.setText("City,State");
            temp.setText("0.0°");
            condition.setText("Forcast");
            condition.setSize(condition.getPreferredSize());
            icon.setImage("");
        }
    }

    public static void main(String[] args)
    {
        GUI g = new GUI();
    }
}