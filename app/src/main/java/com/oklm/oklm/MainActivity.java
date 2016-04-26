package com.oklm.oklm;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView Chrono = (TextView)findViewById(R.id.textView);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                Chrono.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Chrono.setText("done!");
            }
        }.start();

        /*** Gestion du bouton GO***/
        Button Go = (Button) findViewById(R.id.goBoutton);
       //initialisation Timer
       final CountDownTimer  Test=  new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                Chrono.setText("seconds remaining: " + millisUntilFinished / 1000);

            }

            public void onFinish() {
                Chrono.setText("done!");
            }
        };


        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Test.start();



            }
        });



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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
