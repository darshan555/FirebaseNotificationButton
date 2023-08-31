package com.example.firebasenotificationbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = findViewById(R.id.notifyBTN);
        //    implementation ("com.android.volley:volley:1.2.1") add this in dependency

        //This is for check token of the device
        /*FirebaseMessaging.getInstance().getToken()
                        .addOnCompleteListener(new OnCompleteListener<String>() {
                            @Override
                            public void onComplete(@NonNull Task<String> task) {
                                if (!task.isSuccessful()) {
                                    Log.w("TAG", "Fetching FCM registration token failed", task.getException());
                                    return;
                                }

                                // Get new FCM registration token
                                String token = task.getResult();
                                Log.d("Token",  token);
                            }
                        });
*/
        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String title = "Hello jee";
                String message = "Keise ho?";
                if(!title.equals("")&&!message.equals("")){
                    FcmSend.pushNotification(
                            MainActivity.this,
                            "fYpmSMUoSUuOrrAosJJ5QX:APA91bEOyiHgQYQvLy5usfBnqsr2Y7Kv_r0M9Hd6N7-m_hA9BvSYpF_sI9lbBes7LCQbwbUZoPzfKhiMaoH0e5C_fBXe77ExIV1dIxNwPFTxzexmObigkYN0glNZRBUBMrXRBwBmMmtr",
                            title,
                            message
                    );
                }
            }
        });
        //token =  fYpmSMUoSUuOrrAosJJ5QX:APA91bEOyiHgQYQvLy5usfBnqsr2Y7Kv_r0M9Hd6N7-m_hA9BvSYpF_sI9lbBes7LCQbwbUZoPzfKhiMaoH0e5C_fBXe77ExIV1dIxNwPFTxzexmObigkYN0glNZRBUBMrXRBwBmMmtr
    }
}