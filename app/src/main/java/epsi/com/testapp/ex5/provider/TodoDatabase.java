package epsi.com.testapp.ex5.provider;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import epsi.com.testapp.ex5.model.Task;

/**
 * Created by mlagast on 28/10/2017.
 */

@Database(entities = {Task.class}, version = 1)
public abstract class TodoDatabase extends RoomDatabase {
    private static TodoDatabase INSTANCE;

    public static TodoDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TodoDatabase.class, "todo_db").build();
        }
        return INSTANCE;
    }

    public abstract TaskProvider taskProvider();

}
