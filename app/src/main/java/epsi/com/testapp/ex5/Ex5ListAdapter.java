package epsi.com.testapp.ex5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import epsi.com.testapp.R;
import epsi.com.testapp.ex4.model.Show;
import epsi.com.testapp.ex4.model.TrendingShow;
import epsi.com.testapp.ex5.model.Task;

/**
 * Created by mlagast on 29/10/2017.
 */

public class Ex5ListAdapter extends ArrayAdapter<Task> {
    private final Context context;
    private final ArrayList<Task> values;

    public Ex5ListAdapter(Context context, ArrayList<Task> values) {
        super(context, R.layout.list_item_ex5, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_ex5, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.list_item_ex5_title);
        Task task = values.get(position);
        if (task != null) {
            textView.setText(task.description);
        }

        return convertView;
    }
}