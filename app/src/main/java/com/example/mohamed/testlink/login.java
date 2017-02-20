package com.example.mohamed.testlink;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taseneem 21 on 2/4/2017.
 */
public class login extends ActionBarActivity {
    public static boolean first = true;
    Button loginbutton;
    TextView signup;
    String email;
    String passwordtxt;
    EditText password;
    EditText Email;
    public static final String KEY_EMAIL = "email";

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    public static final String LOGIN_URL = "http://192.168.1.6:85/tasneem/login.php";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        Email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.input_password);
        loginbutton = (Button) findViewById(R.id.btn_login);
        signup=(TextView) findViewById(R.id.link_signup);

        loginbutton.setOnClickListener(new View.OnClickListener() {

                                           public void onClick(View arg0) {



                                               // Retrieve the text entered from the EditText
                                              email = Email.getText().toString().trim();
                                               passwordtxt = password.getText().toString().trim();

                                               //    userLogin();

                                               if (email.equalsIgnoreCase("") || passwordtxt.equalsIgnoreCase("") ) {
                                                   Toast.makeText(login.this, "Please Complete the required Fields", Toast.LENGTH_SHORT).show();
                                               } else {

                                                   //Intent i = new Intent(login.this, Home.class);
                                                  // startActivity(i);
                                                  // finish();
                                                   userLogin();
                                               }


                                               }

                                       }

        );

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this, signup.class);

                startActivity(intent);
                finish();
            }
        });

    }







    private void userLogin() {


        final ProgressDialog progressDialog = new ProgressDialog(login.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST,LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(response.trim().equals("success")){
                            //Creating a shared preference
                          //  SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            //Creating editor to store values to shared preferences
                            //SharedPreferences.Editor editor = sharedPreferences.edit();

                            //Adding values to editor
                            //editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true);
                            //editor.putString(Config.EMAIL_SHARED_PREF, email);

                            //Saving values to editor
                            //editor.commit();

                            //Starting profile activity
                            Intent intent = new Intent(login.this, Home.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                        }else{
                            //If the server response is not success
                            //Displaying an error message on toast
                            Toast.makeText(login.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                params.put(KEY_EMAIL, email);
                params.put(KEY_PASSWORD, passwordtxt);

                //returning parameter

                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Content-Type","application/x-www-form-urlencoded");
                headers.put("User-agent", "My useragent");
                return headers;

            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
       // progressDialog.dismiss();

    }



    private void openProfile(){
        Intent intent = new Intent(this, Home.class);
       // intent.putExtra(KEY_USERNAME, usernametxt);
        startActivity(intent);
    }
}
