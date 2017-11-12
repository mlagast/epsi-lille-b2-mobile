package epsi.com.testapp.ex6;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import epsi.com.testapp.R;
import epsi.com.testapp.main.MainActivity;

/**
 * Created by mlagast on 12/11/2017.
 */

public class Ex6Activity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex6);

        Button subscribeButton = (Button) findViewById(R.id.subscribeButton);
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add a subscription to firebase
                FirebaseMessaging.getInstance().subscribeToTopic("news");

                // Log and toast
                String msg = "subscribed";
                Log.d(TAG, msg);
                Toast.makeText(Ex6Activity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button logTokenButton = (Button) findViewById(R.id.logTokenButton);
        logTokenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get FCM Token
                String token = FirebaseInstanceId.getInstance().getToken();

                // Log and toast
                Log.d(TAG, token);
                Toast.makeText(Ex6Activity.this, token, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
