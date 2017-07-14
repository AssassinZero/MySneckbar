package com.example.administrator.mysneckbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.rxjavaretrofit.entity.Subject;
import com.example.rxjavaretrofit.subscribers.SubscriberOnNextListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(List<Subject> subjects) {

            }
        };
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
//                Snackbar.make(view, "这是message", Snackbar.LENGTH_LONG)
//                        .setAction("这是Action", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Toast.makeText(MainActivity.this,"你点击了action",Toast.LENGTH_SHORT).show();
//                            }
//                        }).show();
                SnackbarUtil.ShortSnackbar(view,"妹子向你发来一条消息",SnackbarUtil.Info).show();
                Snackbar snackbar= SnackbarUtil.ShortSnackbar(view,"妹子删了你发出的消息",SnackbarUtil.Warning).setActionTextColor(Color.RED).setAction("再次发送", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SnackbarUtil.LongSnackbar(view,"妹子已将你拉黑",SnackbarUtil.Alert).setActionTextColor(Color.WHITE).show();
                    }
                });

                SnackbarUtil.SnackbarAddView(snackbar,R.layout.snackbar_addview,0);

                SnackbarUtil.SnackbarAddView(snackbar,R.layout.snackbar_addview2,2);

                snackbar.show();
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
