package epsi.com.testapp.ex4.api;

import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import epsi.com.testapp.ex4.model.Show;
import epsi.com.testapp.ex4.model.TrendingShow;

/**
 * Created by mlagast on 07/10/2017.
 */

public class HTTPShowRequest {

    public List<TrendingShow> fetchTrending() {
        try {
            URL endpoint = new URL("https://api.trakt.tv/shows/trending");
            HttpsURLConnection connection = (HttpsURLConnection) endpoint.openConnection();
            connection.setRequestProperty("trakt-api-key",
                    "f45ba41514e3d5c19baa61759bbddd62a291160210ecb4888d9dc5e2707a1b7c");
            connection.setRequestProperty("trakt-api-version",
                    "2");

            if (connection.getResponseCode() == 200) {

                InputStream responseBody = connection.getInputStream();
                String response = convert(responseBody);
                List<TrendingShow> shows = parse(response);
                connection.disconnect();
                return shows;
            } else {
                // Error handling code goes here
                return null;
            }
        }catch (Exception e) {
            // Should catch exception & make something with it
            return null;
        }
    }

    public String convert(InputStream response) {
        try {
            StringBuilder sb = new StringBuilder();
            String line;

            BufferedReader br = new BufferedReader(new InputStreamReader(response));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();
        }catch (Exception e) {
            // Should catch exception & make something with it
            return "";
        }
    }

    public List<TrendingShow> parse(String response) {
        List<TrendingShow> results = new ArrayList<TrendingShow>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                TrendingShow trending = new TrendingShow();

                JSONObject jsonShow = json.getJSONObject("show");
                if (jsonShow != null) {
                    trending.show = new Show();
                    trending.show.title = jsonShow.getString("title");
                }

                results.add(trending);
            }

            return results;
        }catch (Exception e) {
            // Should catch exception & make something with it
            return results;
        }
    }
}
