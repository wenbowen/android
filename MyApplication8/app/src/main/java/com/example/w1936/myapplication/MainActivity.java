package com.example.w1936.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  implements View.OnClickListener {

    private SQLiteDatabase db;
    private DataBase dataBase= new DataBase(this, "/data/data/com.way.rapid.new_application/sql/firstDb.db", null, 1);
    private JavaBean javaBean;
    private dao dao1;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dataBase = new DataBase(this, "firstDb.db", null, 1);
        //db = dataBase.getWritableDatabase();
        //final EditText e=(EditText)findViewById(R.id.editText);
        // final EditText c=(EditText)findViewById(R.id.editText2);
        TextView show = (TextView) findViewById(R.id.textView);

//        Button w = (Button) findViewById(R.id.bt_add);
//        w.setOnClickListener(new View.OnClickListener() {
//
//
//            public void onClick(View v) {
//
//                Log.i("匿名内部类", "点击事件");
//                EditText e = (EditText) findViewById(R.id.editText);
//                EditText c = (EditText) findViewById(R.id.editText2);
//                e.setText("");
//                c.setText("");
//                javaBean.englishText = e.getText().toString();
//                javaBean.chinaText = c.getText().toString();
////                dao1.insert(javaBean);
//           }
//        });
//
//        //db.close();
//    }
        findViewById(R.id.bt_add).setOnClickListener(this);
        findViewById(R.id.bt_del).setOnClickListener(this);
        findViewById(R.id.bt_update).setOnClickListener(this);
        findViewById(R.id.bt_query).setOnClickListener(this);

    }

    public void onClick(View v){
//        dao dao1 = new dao(this);
//        JavaBean javaBean=new JavaBean();
//        EditText e=(EditText)findViewById(R.id.editText);
//        EditText c=(EditText)findViewById(R.id.editText2);
//        EditText show=(EditText)findViewById(R.id.textView);

//            switch (v.getId()) {
//
//                case R.id.bt_add:
                    Toast tot = Toast.makeText(
                            context,
                            "独立类实现button点击事件",
                            Toast.LENGTH_LONG);
                    tot.show();
//                    javaBean.englishText = e.getText().toString();
//                javaBean.chinaText = c.getText().toString();
//                dao1.insert(javaBean);
                //break;

//                case R.id.bt_del:
//                    dao1.delete(show);
//                    break;

//            case R.id.bt_update:
//                Infobean bean = new Infobean();
//                bean.name = "张三";
//                bean.phone = "120";
//                infoDao.update(bean);
//                break;

//                case R.id.bt_query:
//                    javaBean.chinaText = show.getText().toString();
//                    dao1.search(javaBean);
//                    break;
            }
//        }



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

