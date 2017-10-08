package epsi.com.testapp.ex4.model;

import java.util.List;

/**
 * Created by mlagast on 07/10/2017.
 */

public class Show {

    public Integer year;
    public String title;

    // extended info
    public Integer runtime;
    public String certification;
    public String network;
    public String country;
    public String trailer;
    public String homepage;
    public String language;
    public List<String> genres;

    public Show() {
    }

    public Show(Integer year, String title) {
        this.year = year;
        this.title = title;
    }
}
