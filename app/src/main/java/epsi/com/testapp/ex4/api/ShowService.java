package epsi.com.testapp.ex4.api;

import java.util.List;

import epsi.com.testapp.ex4.model.TrendingShow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mlagast on 07/10/2017.
 */

public interface ShowService {

    @GET("shows/trending")
    Call<List<TrendingShow>> trending(
            @Query("page") Integer page,
            @Query("limit") Integer limit
    );
}
