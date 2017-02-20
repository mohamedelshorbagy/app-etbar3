package com.example.mohamed.testlink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by taseneem 21 on 2/4/2017.
 */
public class Update_user_profile extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_user_profile);



    }

    public void Update_user_profile(){



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.request_blood) {
            Intent i=new Intent(Update_user_profile.this,request_blood.class);

            startActivity(i);
            finish();

        }
        else if (id == R.id.log_out){
            Intent i=new Intent(Update_user_profile.this,login.class);

            startActivity(i);
            finish();
        }

        else if (id == R.id.Home){
            Intent i=new Intent(Update_user_profile.this,Home.class);

            startActivity(i);
            finish();
        }

        else if (id == R.id.About_us){
            Intent i=new Intent(Update_user_profile.this,login.class);

            startActivity(i);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
