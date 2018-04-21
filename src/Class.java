import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Class
{
    String zipcode;
    boolean zip;
    String city;
    String state;
    final String APIKEY = "1655f919bbcd29ed";
    JsonElement jse;

    public Class(String location)
    {
        zip = true;
        zipcode = location;
    }
    public Class(String c, String s){
        city = c;
        state = s;
        zip = false;
    }

    public String getCity(String key) {
        if (jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("display_location").getAsJsonObject().get(key).getAsString();
    }

    public String getLoc()
    {
        return getCity("full");
    }

    public String getData(String key) {
        if (jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get(key).getAsString();
    }

    public String getTemp()
    {
        return getData("temp_f");
    }

    public String getConditions()
    {
        return getData("weather");
    }

    public String getWind()
    {
        return getData("wind_string");
    }

    public String getIcon()
    {
        return getData("icon_url");
    }

    public Forecast[] get5Day()
    {
        Forecast[] fArray = new Forecast[6];
        for(int i = 0; i < 6; i++)
        {
            fArray[i] = new Forecast(i);
        }

        return fArray;
    }

    public void fetch()
    {
        String weatherRequest;
        if(zip) {
            weatherRequest = "http://api.wunderground.com/api/" +
                    APIKEY + "/conditions/forecast10day/q/" + zipcode + ".json";
        }
        else{
            weatherRequest = "http://api.wunderground.com/api/" + APIKEY + "/conditions/forecast10day/q/" +
                    state + "/" + city + ".json";
        }
        try
        {
            URL weatherURL = new URL(weatherRequest);

            InputStream is = weatherURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            jse = new JsonParser().parse(br);

        }
        catch (java.net.MalformedURLException mue)
        {
            System.out.println("Zipcode not well formed");
            mue.printStackTrace();
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("Got IO Exception");
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Class b = new Class("Rocklin", "CA");
        System.out.println(b.getTemp());
        System.out.println(b.getConditions());
        System.out.println(b.getWind());
        System.out.println(b.getIcon());
        System.out.println(b.getLoc());

        Forecast[] test;
        test = b.get5Day();
        System.out.println(test[3].low);
    }
}

