package epsi.com.testapp.main;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import epsi.com.testapp.R;

/**
 * Created by mlagast on 02/10/2017.
 */

public class MainMenuAdapter extends ArrayAdapter<MainMenuItem> {

    public MainMenuAdapter(@NonNull Context context, @NonNull MainMenuItem[] objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        MainMenuItem item = getItem(position);
        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(item.title);

        return convertView;
    }
}
