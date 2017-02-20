package com.example.mohamed.testlink;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by taseneem 21 on 2/4/2017.
 */
public class request_blood extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_blood);
 //ActionBar bar = getActionBar();

//for color
      //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e74c3c")));


    }

    public void Request_blood(){



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
        if (id == R.id.action_settings) {
            Intent i=new Intent(request_blood.this,Update_user_profile.class);

            startActivity(i);
            finish();

    }
  else if (id == R.id.log_out){
            Intent i=new Intent(request_blood.this,login.class);

            startActivity(i);
            finish();
        }

        else if (id == R.id.Home){
            Intent i=new Intent(request_blood.this,Home.class);

            startActivity(i);
            finish();
        }

        else if (id == R.id.About_us){
                Intent i=new Intent(request_blood.this,login.class);

                startActivity(i);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
