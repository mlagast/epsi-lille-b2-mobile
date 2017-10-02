package epsi.com.testapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import epsi.com.testapp.R;

public class MainActivity extends AppCompatActivity {

    protected ListView menuListView;
    protected ArrayAdapter<MainMenuItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainMenuItem[] items = new MainMenuItem[] {
                new MainMenuItem("Ex 1 - LinearLayout", MainActivity.class),
                new MainMenuItem("Ex 1 - LinearLayout", MainActivity.class),
                new MainMenuItem("Ex 1 - LinearLayout", MainActivity.class)
        };

        adapter = new MainMenuAdapter(this, items);
        menuListView = (ListView) findViewById(R.id.main_list_view);
        menuListView.setAdapter(adapter);
    }
}
