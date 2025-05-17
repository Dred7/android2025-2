package com.example.a31_03_25;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    interface OnUserDBSave{
        void onSaveUser(User user);
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initDB(user -> {
            getMainExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, user.firstName, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, user.lastName, Toast.LENGTH_LONG).show();
                }
            });
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }


    private void initDB(OnUserDBSave onUserDBSave){

        AsyncTask.execute(() -> {

            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "database-name").build();

            UserDao userDao = db.userDao();
            User user1 = new User();
            user1.uid = new Random().nextInt();
            user1.firstName ="Pancho";
            user1.lastName = "Ramones";

            userDao.insertAll(user1);

            User firtsUser = null;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM){
                firtsUser = userDao.getAll().getFirst();
            }

            onUserDBSave.onSaveUser(firtsUser);
        });
    }
}