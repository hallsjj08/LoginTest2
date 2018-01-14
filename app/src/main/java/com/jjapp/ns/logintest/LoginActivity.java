package com.jjapp.ns.logintest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    //Tag for Logs during debugging.....................................................
    final private static String TAG = "ANDROID SUCKS";

//    ...
//    ..
//    .

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Variables for userID, password, and the Login/Register Buttons.
        final EditText etRacfID = (EditText) findViewById(R.id.etLogRac);
        final EditText etPword = (EditText) findViewById(R.id.etLogPass);
        Button bRegister = (Button) findViewById(R.id.bRegister);
        Button bLogin = (Button) findViewById(R.id.bLogin);

        //Debug Log
        Log.d(TAG, "Button Created");

        /*
        Action performed whe the Login button is clicked. The userID and password are formatted to a
        string and a response listener is created. These parameters are used in the LoginRequest Class.
         */
        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final String racfID = etRacfID.getText().toString();
                final String password = etPword.getText().toString();

                //An object created to listen for a successful response from the server.
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            /*
                            A short message will display welcoming the user if the login was successful.
                            Later this will be used to take the user to the locomotives in progress screen.
                             */
                            if(success){

                                String rac = jsonResponse.getString("racfID");

                                Context context = getApplicationContext();
                                CharSequence text = "Welcome " + rac;
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();

                                /*
                                Else statement to handle failed login attempts. Will need to incorporate
                                limited login attempts and be able to handle screen changes.
                                 */
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                /*
                Login request object is created. The object is added to the network transaction queue
                and executed using the Volley library. Volley currently works with
                Android 2.2 and higher.
                 */
                LoginRequest login = new LoginRequest(racfID, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(login);
            }
        });

        //Action performed when the register button is pressed. It takes the user to a RegisterActivity Screen.
        bRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActvity.class);
                LoginActivity.this.startActivity(intent);
            }
        });

    }
}
