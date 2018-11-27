package com.example.w1936.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast toast= Toast.makeText(
                        MainActivity.this,"注册成功！",Toast.LENGTH_SHORT
                );
                toast.show();

                final Intent intent=new Intent(MainActivity.this,MainActivity2Activity.class);
                final Bundle bundle=new Bundle();

                EditText userName=(EditText)findViewById(R.id.editText);
                bundle.putString("username", userName.getText().toString());

                EditText userPassword=(EditText)findViewById(R.id.editText2);
                bundle.putString("userpassword", userPassword.getText().toString());

                final RadioGroup radioG=(RadioGroup)findViewById(R.id.radioGroup);
                for (int i=0;i<radioG.getChildCount();i++){
                    RadioButton radioButton=(RadioButton)radioG.getChildAt(i);
                    if (radioButton.isChecked()){
                        bundle.putString("sex", radioButton.getText().toString());
                        break;
                    }
                }

                CheckBox c1=(CheckBox)findViewById(R.id.checkBox);
                CheckBox c2=(CheckBox)findViewById(R.id.checkBox2);
                CheckBox c3=(CheckBox)findViewById(R.id.checkBox3);
                final List<CheckBox> checkBoxList= Arrays.asList(c1,c2,c3);
                String s1="";
                for (CheckBox checkBox:checkBoxList){
                    if(checkBox.isChecked()){
                        s1+=checkBox.getText()+"    ";
                    }
                }bundle.putString("habit", s1);
                intent.putExtras(bundle);
                startActivity(intent);
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
