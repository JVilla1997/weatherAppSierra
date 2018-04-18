import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Class
{
    String zipcode;
    final String APIKEY = "1655f919bbcd29ed";
    JsonElement jse;

    public Class(String location)
    {
        zipcode = location;
    }

    public String getCity(String key) {
        if (jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("display_location").getAsJsonObject().get(key).getAsString();
    }

    public String getLoc()
    {
        return getCity("city");
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

    public void fetch()
    {
        String weatherRequest = "http://api.wunderground.com/api/" +
                APIKEY + "/conditions/q/" + zipcode + ".json";

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
        Class b = new Class("http://api.wunderground.com/api/1655f919bbcd29ed/conditions/q/95843.json");
        System.out.println(b.getTemp());
        System.out.println(b.getConditions());
        System.out.println(b.getWind());
        System.out.println(b.getIcon());
        System.out.println(b.getLoc());
    }
}

