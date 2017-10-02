package epsi.com.testapp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import epsi.com.testapp.R;
import epsi.com.testapp.ex1.Ex1LinearActivity;
import epsi.com.testapp.ex1.Ex1RelativeActivity;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    protected ListView menuListView;
    protected ArrayAdapter<MainMenuItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainMenuItem[] items = new MainMenuItem[] {
                new MainMenuItem("Ex 1 - LinearLayout", Ex1LinearActivity.class),
                new MainMenuItem("Ex 1 - RelativeLayout", Ex1RelativeActivity.class)
        };

        adapter = new MainMenuAdapter(this, items);
        menuListView = (ListView) findViewById(R.id.main_list_view);
        menuListView.setAdapter(adapter);

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainMenuItem item = (MainMenuItem) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), item.destinationClass);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
