package com.example.firebasenotificationbutton;

import android.content.Context;
import android.os.StrictMode;

import androidx.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class FcmSend {
    private static String BaseUrl = "https://fcm.googleapis.com/fcm/send";
    private static String ServerKey = "AAAAc2hw91g:APA91bHBRCN7Amk-OrbLz_0TTPk9Lu7fhjQLZV0QSUDgt57toSngMieWTQEKtnLn4fI4sHJ2JYKHstWriY6JbrBHj8ljvLXhW2BEXNHU3l0W4cGFPCRwxHKteYoPwoxLiJXQ6436LPrq";

    public static void pushNotification(Context context, String token,String title,String message){
        StrictMode.ThreadPolicy policy =new  StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

       RequestQueue queue = Volley.newRequestQueue(context);

       try {
           JSONObject json = new JSONObject();
           json.put("to", token);
           JSONObject notification = new JSONObject();
           notification.put("title", title);
           notification.put("body", message);
           json.put("notification", notification);

           JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, BaseUrl, json, new Response.Listener<JSONObject>() {
               @Override
               public void onResponse(JSONObject response) {
                    System.out.println("FCM"+response);
               }
           }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {

               }
           }){
               @Nullable
               @Override
               public Map<String, String> getHeaders() throws AuthFailureError {
                   Map<String,String> params = new HashMap<>();
                   params.put("Content-Type", "application/json");
                   params.put("Authorization", "key="+ServerKey);
                   return params;
               }
           };
           queue.add(jsonRequest);
       }catch (JSONException e){
           e.printStackTrace();
       }
    }
}
