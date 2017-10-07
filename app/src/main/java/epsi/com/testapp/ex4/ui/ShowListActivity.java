package epsi.com.testapp.ex4.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import epsi.com.testapp.R;
import epsi.com.testapp.ex4.api.ShowService;
import epsi.com.testapp.ex4.manager.ServiceManager;
import epsi.com.testapp.ex4.model.Show;
import epsi.com.testapp.ex4.model.TrendingShow;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.VERSION_CODES.N;

/**
 * Created by mlagast on 07/10/2017.
 */

public class ShowListActivity extends Activity {
    private ShowListAdapter adapter;
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_listview);

        listView = (ListView) findViewById(R.id.ex3_show_list);
        adapter = new ShowListAdapter(this, new ArrayList<TrendingShow>());
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    public void loadData() {
        Callback<List<TrendingShow>> serviceCallback = new Callback<List<TrendingShow>>() {
            @Override
            public void onResponse(Call<List<TrendingShow>> call, Response<List<TrendingShow>> response) {
                List<TrendingShow> objects = response.body();
                adapter.clear();
                adapter.addAll(objects);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<TrendingShow>> call, Throwable t) {
                Log.e("SynchroManager", "Load Medias", t);
            }
        };

        ShowService service = ServiceManager.createService(ShowService.class);
        Call<List<TrendingShow>> call = service.trending(0, 10);
        call.enqueue(serviceCallback);
    }
}
