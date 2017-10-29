package epsi.com.testapp.ex5.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by mlagast on 28/10/2017.
 */

@Entity(tableName = "Task")
public class Task {

    @PrimaryKey
    public @NonNull
    String description;
}
