package com.kgc.appmanager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.kgc.appmanager.adapter.MyAdapter;
import com.kgc.appmanager.entity.AppInfo;
import com.kgc.appmanager.util.Utils;

import java.util.List;


public class MainActivity extends Activity {

    ListView lv;
    List<AppInfo> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //拿到ListView
        lv = (ListView) findViewById(R.id.lv_main);
        //数据源
        list = Utils.getAppList(this);
        //适配器
        adapter = new MyAdapter(this);
        adapter.setList(list);
        //关联
        lv.setAdapter(adapter);

        Log.i("spl","list="+list.toString());
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
