package com.example.w1936.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;



public class MainActivity2Activity extends Activity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        textView = (TextView)findViewById(R.id.textView5);
        Intent intent = getIntent();
        String name=intent.getStringExtra("username");
        String pwd=intent.getStringExtra("userpassword");
        String sex=intent.getStringExtra("sex");
        String h=intent.getStringExtra("habit");

        String s="用户名："+name+"\n"+"密码："+pwd+"\n"+
                "性别："+sex+"\n"+"爱好："+h;
        textView.setText(s);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
