package com.androidsample.hibye;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.freshdesk.mobihelp.Mobihelp;
import com.freshdesk.mobihelp.MobihelpConfig;


public class MainActivity extends AppCompatActivity {

    static Button notifCount;
    static int mNotifCount = 0;
    Button button,feedBack,conversation,rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button=(Button)findViewById(R.id.button);
        feedBack=(Button)findViewById(R.id.feedback);
        conversation=(Button)findViewById(R.id.conversation);
        rating=(Button)findViewById(R.id.rating);
        MobihelpConfig config=new MobihelpConfig("https://abchi.freshdesk.com", "hibye-1-a0f3b022d493439b84ff3480440d4a87",
                "46c2b241eddde7dacb78edb813c7f5459141f7db");

        Mobihelp.init(this,config);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mobihelp.showSupport(MainActivity.this);
            }
        });

        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mobihelp.showFeedback(MainActivity.this);
            }
        });

        conversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mobihelp.showConversations(MainActivity.this);

            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mobihelp.showAppRateDialog(MainActivity.this);


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.main,menu);

/*
        View count = menu.findItem(R.id.badge).getActionView();
        notifCount = (Button) count.findViewById(R.id.notif_count);
        notifCount.setText(String.valueOf(mNotifCount));*/

        MenuItem item = menu.findItem(R.id.badge);
        MenuItemCompat.setActionView(item, R.layout.feed_update_count);
        notifCount = (Button) MenuItemCompat.getActionView(item);
        notifCount.setText(String.valueOf(mNotifCount));
        return super.onCreateOptionsMenu(menu);
    }

    private void setNotifCount(int count){
        mNotifCount = count;
        invalidateOptionsMenu();
    }


}
