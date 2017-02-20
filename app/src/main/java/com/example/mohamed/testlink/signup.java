package com.example.mohamed.testlink;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taseneem 21 on 2/4/2017.
 */
public class signup extends ActionBarActivity {
    Button signupbtn;
    EditText userEt,passEt,emailE;
    Spinner bloodtype;
    Spinner city;
    Spinner zipcode;
    TextView loginTv;
    public static final String REGISTER_URL = "http://192.168.1.6:85/tasneem/signup.php";

    public static final String KEY_USERNAME="Name";
    public static final String KEY_PASSWORD="password";
    public static final String KEY_Email="Email";
    public static final String KEY_Bloodtype="BloodType";
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    private String Blood;
    private String Zipcode;
    private String City;

    public static final String KEY_EMAIL = "Email";
    // `phone`, `GroupID`, `Blood`, `birthDate`, `healthCondition`
    public static final String KEY_PHONE = "Phone";
    public static final String KEY_GROUPID = "GroupID";
    public static final String KEY_Blood = "BloodType";
    public static final String KEY_BIRTHDATE = "birthDate";
    public static final String KEY_HealthDate = "healthCondition";
    public static final String KEY_City = "City";
    public static final String KEY_ZipCode = "zipCode";
    public static final String KEY_Age = "Age";

    private EditText editTextPhone;
    private EditText editTextConfirmPass;
    private EditText editTextBlood;
    private EditText ageNumber;
    private EditText editTextbirthdate;
    private EditText editTexthealthCondition;


    private EditText editTextEmail;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Intent i = new Intent(signup.this,login.class);
        //startActivity(i);
        //finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        signupbtn = (Button) findViewById(R.id.btn_signup);
        userEt = (EditText) findViewById(R.id.input_name);
        bloodtype=(Spinner) findViewById(R.id.input_bloodtype);
        city=(Spinner) findViewById(R.id.city);
        zipcode=(Spinner) findViewById(R.id.zipcode);
        passEt = (EditText) findViewById(R.id.input_password);
        emailE = (EditText) findViewById(R.id.input_email);
        loginTv = (TextView) findViewById(R.id.link_login);
        editTextUsername = (EditText) findViewById(R.id.input_name);
        editTextPassword = (EditText) findViewById(R.id.input_password);
        editTextEmail= (EditText) findViewById(R.id.input_email);
        ageNumber = (EditText) findViewById(R.id.Age);

        //editTextBlood= (EditText) findViewById(R.id.blood);
        editTextbirthdate= (EditText) findViewById(R.id.BirthDate);

        editTexthealthCondition= (EditText) findViewById(R.id.Healthcondition);
        editTextPhone= (EditText) findViewById(R.id.phone);
        editTextConfirmPass=(EditText) findViewById(R.id.confirm_password);
        bloodtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Change the selected item's text color
                ((TextView) view).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });


        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Change the selected item's text color
                ((TextView) view).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });

        zipcode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Change the selected item's text color
                ((TextView) view).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });

        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.BloodType_array,
                        android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                .createFromResource(this, R.array.city_array,
                        android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter
                .createFromResource(this, R.array.zipcode_array,
                        android.R.layout.simple_spinner_item);

        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        bloodtype.setAdapter(staticAdapter);
        city.setAdapter(staticAdapter1);
        zipcode.setAdapter(staticAdapter2);

        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(signup.this,login.class);
                startActivity(intent);
                finish();

            }
        });




        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (editTextUsername.getText().toString().equalsIgnoreCase("")) {
                    //  Toast.makeText(signup.this, "Please Complete the required Fields", Toast.LENGTH_SHORT).show();
                    editTextUsername.setError("Name is required");
                }

                else if ( editTextEmail.getText().toString().equalsIgnoreCase("")){
                    editTextEmail.setError("Email is required");

                }
                else if ( editTextPassword.getText().toString().equalsIgnoreCase("")){
                    editTextPassword.setError("Password is required");

                }
                else if ( editTextbirthdate.getText().toString().equalsIgnoreCase("")){
                    editTextbirthdate.setError("Birth Date is required");

                }

                else if ( editTextPhone.getText().toString().equalsIgnoreCase("")){
                    editTextPhone.setError("Health Condition is required");

                }
                else if ( editTexthealthCondition.getText().toString().equalsIgnoreCase("")){
                    editTexthealthCondition.setError("Phone is required");

                } else {

                    // registerUser();

                    //Intent i=new Intent(signup.this,Home.class);

                    //startActivity(i);
                   try {
                       registerUser();
                       //registerUser2();
                       //signup();
                   }
                   catch(Exception e){
                       Log.e("log_tag", "Error in http connection "+e.toString());
                   }

            /*        final ParseUser parseUser = new ParseUser();
                    parseUser.setUsername(userEt.getText().toString());
                    parseUser.setPassword(passEt.getText().toString());
                    parseUser.setEmail(emailE.getText().toString());

                    parseUser.put("BloodType",bloodtype.getText().toString());

                    parseUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(signup_activity.this, "Successful Registeration", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(signup_activity.this, Home.class);
                                i.putExtra("user", parseUser.getUsername());

                                startActivity(i);
                                progressDialog.dismiss();
                            } else {
                                Toast.makeText(signup_activity.this, "Failed", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();

                            }
                        }
                    }

                    );

*/
                }
           /*     new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onLoginSuccess or onLoginFailed
                                signupbtn.setEnabled(true);
                                finish();
                                // onLoginFailed();
                                progressDialog.dismiss();
                            }
                        }, 100000);*/

            }   });

    }




    private void registerUser() throws JSONException {
        final ProgressDialog progressDialog = new ProgressDialog(signup.this,
                R.style.AppTheme_Dark_Dialog);


        final String username1 = editTextUsername.getText().toString().trim();
        final String password1 = editTextPassword.getText().toString().trim();
        final String email1 = editTextEmail.getText().toString().trim();

        final String Age2 = ageNumber.getText().toString().trim();
        final String phone1 = editTextPhone.getText().toString().trim();
       // final String blood1 = editTextBlood.getText().toString().trim();
        final String birthdate1 = editTextbirthdate.getText().toString().trim();
        final String healthcondition1 = editTexthealthCondition.getText().toString().trim();
        final String passconfirm1 = editTextConfirmPass.getText().toString().trim();
       Blood = bloodtype.getSelectedItem().toString();
        Zipcode=zipcode.getSelectedItem().toString();
        City=city.getSelectedItem().toString();
        if (!passconfirm1.equalsIgnoreCase(password1)) {
            editTextConfirmPass.setError("The password doesn't match");
        } else {

            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Processing...");
            progressDialog.show();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(signup.this, response, Toast.LENGTH_LONG).show();
                            Log.d("Response", response);
                            Intent i = new Intent(signup.this,Home.class);
                            startActivity(i);
                            finish();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(signup.this, error.toString(), Toast.LENGTH_LONG).show();
                            Log.d("Error.Response", error.toString());
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put(KEY_USERNAME, username1);
                    params.put(KEY_PASSWORD, password1);
                    params.put(KEY_EMAIL, email1);
                    params.put(KEY_Blood, Blood);
                    params.put(KEY_Age,Age2);
                    params.put(KEY_PHONE, phone1);
                    params.put(KEY_City, City);
                    params.put(KEY_ZipCode, Zipcode);
                    params.put(KEY_BIRTHDATE, birthdate1);
                    params.put(KEY_HealthDate, healthcondition1);
                    // params.put(KEY_GROUPID, GroupId);
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


            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.start();
            requestQueue.add(stringRequest);
            progressDialog.dismiss();
            //  AppController.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
        }

    }


}
