import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.*;

public class DBTest {

    public String makeGETRequest(String urlName) {
        BufferedReader rd = null;
        StringBuilder sb = null;
        String line = null;
        try {
            URL url = new URL(urlName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            sb = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                sb.append(line + '\n');
            }
            conn.disconnect();
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }

    public void parseJSON(String jsonString) {
        try {
            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++) {
                JSONObject curObject = array.getJSONObject(i);
                System.out.println("The " + curObject.getInt("id") + " group is group " + curObject.getString("GroupName") + " which enters the team at " + curObject.getString("Date") + ".");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getid(String jsonString) {
        String target_Id = " ";
        try {
            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++) {
                JSONObject curObject = array.getJSONObject(i);
                int current_id = curObject.getInt("id");
                String current_string = String.valueOf(current_id);
                target_Id = target_Id + current_string + " ";
            }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return target_Id;
    }

    public String getMaxhPa(String jsonString) {
        String target_Id = " ";
        try {
            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++) {
                JSONObject curObject = array.getJSONObject(i);
                int current_id = curObject.getInt("id");
                String current_string = String.valueOf(current_id);
                target_Id = target_Id + current_string + " ";
            }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return target_Id;
    }




    public static void main(String[] args) {
        DBTest rc = new DBTest();
        String response = rc.makeGETRequest("https://studev.groept.be/api/a23ib2c03/getId/℃" );
        rc.getid(response);
    }
}


