import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
// Written by: Daniel Villavicencio
// CS13    Spring 2018
// Weather Application

//**********PLEASE READ NOTES TO UNDERSTAND THE CODE**********
public class Weather
{
    private String city = "";
    private String state = "";
    private String zipCode = "";
    private final String API_KEY = "1655f919bbcd29ed";
    JsonElement jse;

    // Two constructors
    // One of them handles zip codes
    // The other one handles State/City
    public Weather(String zip )
    {
        zipCode = zip;
    }
    public Weather(String inputState, String inputCity)
    {
        city = inputCity;
        state = inputState;
    }

    public void fetch()
    {
        String websiteRequest = "http://api.wunderground.com/api/" + API_KEY + "/conditions/forecast10day/q/";
        // If constructor #1 is empty
        // add constructor #2 to websiteRequest
        // else add constructor #1 to websiteRequest
        if( city.equals("") && state.equals(""))
        {
            websiteRequest += zipCode + ".json";
        }
        else
        {
            websiteRequest += state + "/" + city + ".json";
        }

        try
        {
            URL weatherURL = new URL(websiteRequest);

            InputStream is = weatherURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            jse = new JsonParser().parse(br);
        }
        catch(java.net.MalformedURLException mue)
        {
            System.err.println("URL not well formed");
            mue.printStackTrace();
        }
        catch(java.io.IOException ioe)
        {
            System.err.println("Got an IOException");
            ioe.printStackTrace();
        }

    }
    // Methods for the Current Day
    // fetch -- fetches the data of a .json URL
    // getTemperatureF -- get the current temperature in fahrenheit
    // getTemperatureC -- get the current temperature in celsius
    // getWeather -- get the current conditions
    // getIcon -- get the URL of the icon used

    public String getCityState()
    {
        if(jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("display_location").getAsJsonObject().get("full").getAsString();
    }
    public Double getTemperatureF()
    {

        if(jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("temp_f").getAsDouble();
    }
    public Double getTemperatureC()
    {
        if(jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("temp_c").getAsDouble();
    }
    public String getWeather()
    {
        if(jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("weather").getAsString();
    }
    public String getIcon()
    {
        if(jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("icon").getAsString() + ".png";
    }
    public String getLongDate()
    {
        String currentDate;
        DateFormat d = new SimpleDateFormat("EEEEEEE, MMMM dd, yyyy");
        Date date = new Date();
        currentDate = d.format(date);
        return currentDate;
    }

    // Methods for forecast
    // getFArray -- returns the "forecastday" JSON Array
    // getHighF -- returns the high of the index in fahrenheit
    // getHighC -- returns the high of the index in celsius
    // getLowF -- returns the low of the index in fahrenheit
    // getLowC -- returns the low of the index in celsius
    // getForecastWeather -- returns the conditions of the index
    // getForecastIcon -- returns the URL for the icon of the index

    public JsonArray getFArray()
    {
        //put a JSON Array in "jse"
        //Got through the keys "forecast", "simpleforecast"
        //Get "forecastday" as a JSON Array
        if(jse == null) fetch();
        return jse.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject().get("forecastday").getAsJsonArray();
    }
    public String getHighF(int index)
    {
        return getFArray().get(index).getAsJsonObject().get("high").getAsJsonObject().get("fahrenheit").getAsString();
    }
    public String getHighC(int index)
    {
        return getFArray().get(index).getAsJsonObject().get("high").getAsJsonObject().get("celsius").getAsString();
    }
    public String getLowF(int index)
    {
        return getFArray().get(index).getAsJsonObject().get("low").getAsJsonObject().get("fahrenheit").getAsString();
    }
    public String getLowC(int index)
    {
        return getFArray().get(index).getAsJsonObject().get("low").getAsJsonObject().get("celsius").getAsString();
    }
    public String getForecastWeather(int index)
    {
        return getFArray().get(index).getAsJsonObject().get("conditions").getAsString();
    }
    public String getForecastIcon(int index)
    {
        return getFArray().get(index).getAsJsonObject().get("icon_url").getAsString();
    }
    public String getForecastDate(int index)
    {
        return getFArray().get(index).getAsJsonObject().get("date").getAsJsonObject().get("weekday").getAsString();
    }


    //How to use methods
    public static void main(String[]args)
    {
        Weather c = new Weather("95678");
        //Big image methods
        System.out.println(c.getWeather());
        System.out.println(c.getTemperatureF());
        System.out.println(c.getTemperatureC());
        System.out.println(c.getLongDate());
        System.out.println(c.getCityState());
        System.out.println(c.getIcon());

        //Forecast methods
        for(int i = 1; i < 6; i++)
        {
            System.out.print("\n" + c.getForecastDate(i) + " " + c.getHighF(i) + " ");
            System.out.print(c.getHighC(i) + " ");
            System.out.print(c.getLowF(i) + " ");
            System.out.print(c.getLowC(i) + " ");
            System.out.print(c.getForecastWeather(i) + " ");
            System.out.println("\n"+ c.getForecastIcon(i));
        }
    }

}
