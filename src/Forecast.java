import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Forecast
{
    String condition;
    String high;
    String low;
    String icon;
    String date;
    String today;
    String highC;
    String lowC;
    JsonElement jse;

    Class c = new Class("95747");
    Class a = new Class("Rocklin", "CA");

    public Forecast(int index)
    {
        condition = getConditions(index);
        high = getHigh(index);
        low = getLow(index);
        icon = getFIcon(index);
        date = getFDate(index);
        today = getToday(index);
        highC = getHighC(index);
        lowC = getLowC(index);
    }

    public JsonArray getFArray(){
        if(jse == null && a.zip) {
            fetch(a.zipcode);
        }
        else{
            fetch(a.city, a.state);
        }
        return jse.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject().
                get("forecastday").getAsJsonArray();
    }

    public String getConditions(int index){
        return getFArray().get(index).getAsJsonObject().get("conditions").getAsString();
    }

    public String getFDate(int index){
        String fDate = getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("weekday_short").getAsString();
        //fDate += " " + getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("monthname").getAsString();
        fDate += " " + getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("day").getAsInt();
        //fDate += ", " + getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("year").getAsInt();
        return fDate;
    }

    public String getToday(int index){
        String today = getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("weekday").getAsString();
        today += " , " + getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("monthname").getAsString();
        today += " " + getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("day").getAsInt();
        //today += ", " + getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("year").getAsInt();
        return today;
    }

    public String getLow(int index){
        return getFArray().get(index).getAsJsonObject().get("low").getAsJsonObject().get("fahrenheit").getAsString();
    }

    public String getLowC(int index){
        return getFArray().get(index).getAsJsonObject().get("low").getAsJsonObject().get("celsius").getAsString();
    }

    public String getHighC(int index){
        return getFArray().get(index).getAsJsonObject().get("high").getAsJsonObject().get("celsius").getAsString();
    }

    public String getHigh(int index){
        return getFArray().get(index).getAsJsonObject().get("high").getAsJsonObject().get("fahrenheit").getAsString();
    }

    public String getFIcon(int index){
        return getFArray().get(index).getAsJsonObject().get("icon_url").getAsString();
    }

    public void fetch(String zipcode) {
        String weatherRequest = "http://api.wunderground.com/api/" +
                "1655f919bbcd29ed" + "/conditions/forecast10day/q/" + zipcode + ".json";

        try {
            URL weatherURL = new URL(weatherRequest);

            InputStream is = weatherURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            jse = new JsonParser().parse(br);

        } catch (java.net.MalformedURLException mue) {
            System.out.println("Zipcode not well formed");
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("Got IO Exception");
            ioe.printStackTrace();
        }
    }
    public void fetch(String c, String s) {
        String weatherRequest = "http://api.wunderground.com/api/" +
                "1655f919bbcd29ed" + "/conditions/forecast10day/q/" + s + "/" + c + ".json";

        try {
            URL weatherURL = new URL(weatherRequest);

            InputStream is = weatherURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            jse = new JsonParser().parse(br);

        } catch (java.net.MalformedURLException mue) {
            System.out.println("Zipcode not well formed");
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("Got IO Exception");
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args){
        Forecast f = new Forecast(1);
        System.out.println(f.getHigh(1));
        System.out.println(f.getLow(1));
        System.out.println(f.getConditions(1));
        System.out.println(f.getFIcon(1));
        System.out.println(f.getFDate(1));
        System.out.println(f.getLowC(1));
        System.out.println(f.getHighC(1));
        System.out.println(f.getToday(0));
    }
}