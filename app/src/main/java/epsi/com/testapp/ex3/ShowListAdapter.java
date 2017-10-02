package epsi.com.testapp.ex3;

import android.widget.ArrayAdapter;;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import epsi.com.testapp.R;
import epsi.com.testapp.main.MainMenuItem;

/**
 * Created by mlagast on 02/10/2017.
 */

public class ShowListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public ShowListAdapter(Context context, String[] values) {
        super(context, R.layout.list_item_ex3_show, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_ex3_show, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.list_item_show_title);
        textView.setText(values[position]);

        return convertView;
    }
}
