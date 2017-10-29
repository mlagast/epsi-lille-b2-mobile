package epsi.com.testapp.ex5;

import android.app.Activity;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import epsi.com.testapp.R;
import epsi.com.testapp.ex3.ShowListAdapter;
import epsi.com.testapp.ex4.model.TrendingShow;
import epsi.com.testapp.ex5.model.Task;
import epsi.com.testapp.ex5.provider.TodoDatabase;

/**
 * Created by mlagast on 28/10/2017.
 */

public class Ex5Activity extends LifecycleActivity {
    private Ex5ListAdapter adapter;
    protected ListView listView;
    protected EditText editText;

    private TodoDatabase database;
    public LiveData<List<Task>> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5);

        listView = (ListView) findViewById(R.id.ex5_list);
        adapter = new Ex5ListAdapter(this, new ArrayList<Task>());
        listView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.ex5_edit_text);
        Button validate = (Button) findViewById(R.id.ex5_button_validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask(editText.getText().toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        database = TodoDatabase.getDatabase(this.getApplication());
        tasks = database.taskProvider().getAll();
        tasks.observe(this, new Observer<List<Task>>() {

            @Override
            public void onChanged(@Nullable List<Task> tasks) {
                adapter.clear();
                adapter.addAll(tasks);
            }
        });
    }

    public void addTask(String description) {
        Task task = new Task();
        task.description = description;
        new addAsyncTask(database).execute(task);
    }

    /* Async task to update database */
    private static class addAsyncTask extends AsyncTask<Task, Void, Void> {
        private TodoDatabase db;

        addAsyncTask(TodoDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Task... params) {
            db.taskProvider().addTask(params[0]);
            return null;
        }
    }
}
