package epsi.com.testapp.ex4.ui;

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

/**
 * Created by mlagast on 07/10/2017.
 */

public class ShowListAdapter extends ArrayAdapter<TrendingShow> {
    private final Context context;
    private final ArrayList<TrendingShow> values;

    public ShowListAdapter(Context context, ArrayList<TrendingShow> values) {
        super(context, R.layout.list_item_ex3_show, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_ex3_show, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.list_item_show_title);
        Show show = values.get(position).show;
        if (show != null) {
            textView.setText(show.title);
        }

        return convertView;
    }
}
