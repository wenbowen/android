package com.example.w1936.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button w=(Button)findViewById(R.id.button);
        Button r=(Button)findViewById(R.id.button2);

        w.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    int type;
                    if(((CheckBox)findViewById(R.id.checkBox)).isChecked()){
                        type=Context.MODE_APPEND;
                    }else {
                        type=Context.MODE_PRIVATE;
                    }
                    FileOutputStream fos=openFileOutput("wfd.txt",type);
                    EditText text=(EditText)findViewById(R.id.editText);
                    fos.write(text.getText().toString().getBytes());
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                    ((EditText)findViewById(R.id.editText)).setText("");
                    fos.flush();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {

                }

            }
        });

        r.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {

                    FileInputStream fis=openFileInput("wfd.txt");
                    byte[]rb=new byte[fis.available()];
                    while(fis.read(rb)!=-1){
                        ((TextView)findViewById(R.id.textView)).setText(new String(rb));
                    }
                    fis.close();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }
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
