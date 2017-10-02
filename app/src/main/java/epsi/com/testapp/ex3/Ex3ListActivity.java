package epsi.com.testapp.ex3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import epsi.com.testapp.R;

/**
 * Created by mlagast on 02/10/2017.
 */

public class Ex3ListActivity extends Activity {
    private ShowListAdapter adapter;
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_listview);

        listView = (ListView) findViewById(R.id.ex3_show_list);

        String[] values = new String[] {
                "Android",
                "iPhone",
                "WindowsMobile",
                "Blackberry",
                "WebOS",
                "Ubuntu",
                "Windows7",
                "Max OS X",
                "Linux",
                "OS/2"
        }
        ;
        adapter = new ShowListAdapter(this, values);
        listView.setAdapter(adapter);
    }
}
