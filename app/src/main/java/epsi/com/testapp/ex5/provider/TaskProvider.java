package epsi.com.testapp.ex5.provider;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import epsi.com.testapp.ex5.model.Task;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by mlagast on 28/10/2017.
 */

@Dao
public interface TaskProvider {
    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getAll();

    @Insert(onConflict = REPLACE)
    void addTask(Task task);
}