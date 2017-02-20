package com.example.mohamed.testlink;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
/**
 * Created by taseneem 21 on 11/27/2016.
 */
public class Home extends ActionBarActivity {

    private static final String TAG = Home.class.getSimpleName();
    ListView listView;
    private static final String TAG_RESULTS="result";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "Name";
    private static final String TAG_ADD ="Address";
    private static final String TAG_BloodType="BloodType";
    private static final String TAG_Phone ="Phone";
    private static final String TAG_Email ="email";
    private static final String TAG_Post ="Post";
    private TextView nametxt;
    private TextView Phonetxt;
    private TextView Datetxt;
    private TextView Addresstxt;
    private TextView BloodTypetxt;
    private TextView Emailtxt;
    private TextView Posttxt;
    private static final String url = "http://192.168.1.6:85/tasneem/home.php";

    ArrayList<User> arrayList = new ArrayList<User>();
    private CustomListAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        listView = (ListView) findViewById(R.id.list1);


        adapter = new CustomListAdapter(arrayList, this);
        listView.setAdapter(adapter);
        nametxt= (TextView) findViewById(R.id.Name);
        Phonetxt= (TextView) findViewById(R.id.Phone);
        Datetxt= (TextView) findViewById(R.id.Date);
        Addresstxt= (TextView) findViewById(R.id.address);
        BloodTypetxt= (TextView) findViewById(R.id.blood);
        Emailtxt= (TextView) findViewById(R.id.email);
        Posttxt= (TextView) findViewById(R.id.Data);

        GetData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Intent i=new Intent(Home.this,login.class);

            startActivity(i);
            finish();

        }
        else if (id == R.id.log_out){
            logout();
        }

        else if (id == R.id.request_blood){
            Intent i=new Intent(Home.this,request_blood.class);

            startActivity(i);
            finish();
        }

        else if (id == R.id.About_us){
            Intent i=new Intent(Home.this,login.class);

            startActivity(i);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

    void logout(){
        //Creating an alert dialog to confirm logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to logout?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent i=new Intent(Home.this,login.class);

                        startActivity(i);
                        finish();
                        //   Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                        // startActivity(intent);
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    void GetData(){
        final ProgressDialog progressDialog = new ProgressDialog(Home.this,
                R.style.AppTheme_Dark_Dialog);

        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        // changing action bar color
        //getActionBar().setBackgroundDrawable(
        //      new ColorDrawable(Color.parseColor("#1b1b1b")));


        JsonArrayRequest userReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        progressDialog.dismiss();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                User user = new User();

                                user.setUsername(obj.getString("Name"));
                                user.setUserEmail(obj.getString("Email"));

//

                                user.setUserPhone(obj.getString("Phone"));

                                //user.setUserPost(obj.getString("Post"));
                                //user.setUserBirthday(obj.getString("birthDate"));

                                user.setUserBlood(obj.getString("BloodType"));
                                //  user.setUserGroupID(obj.getString("GroupID"));
                                //user.setUserAddress(obj.getString("Address"));


                                // adding movie to movies array
                                arrayList.add(user);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
//
//                        // notifying list adapter about data changes
//                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                progressDialog.dismiss();
//
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(userReq);


    }
}
