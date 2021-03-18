package com.kgc.appmanager;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kgc.appmanager.adapter.IUninstall;
import com.kgc.appmanager.adapter.MyAdapter;
import com.kgc.appmanager.entity.AppInfo;
import com.kgc.appmanager.util.Utils;

import java.util.List;


public class MainActivity extends Activity
        implements AdapterView.OnItemClickListener,IUninstall {

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

        //适配器
        adapter = new MyAdapter(this);

        //关联
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        adapter.setUninstall(this);




        updateData();
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
        if (id == R.id.sort_name) {
            Toast.makeText(this,"名称",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.sort_date) {
            Toast.makeText(this,"日期",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.sort_size) {
            Toast.makeText(this,"大小",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //1
    ProgressDialog pd;

    public void showProgressDialog(){
        pd = new ProgressDialog(this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setTitle("刷新列表");
        pd.setMessage("请耐心等待");
        pd.show();
    }

    //2
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            adapter.setList(list);
            adapter.notifyDataSetChanged();//通知数据更新
            //Log.i("spl", "list=" + list.toString());
            Log.i("spl", "size=" + list.size());
            pd.dismiss();
        }
    };

    //3.
    private void updateData(){
        new Thread(){
            @Override
            public void run() {
                list = Utils.getAppList(MainActivity.this);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.sendEmptyMessage(1);
            }
        }.start();// 子线程
        showProgressDialog();// UI线程
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AppInfo app = (AppInfo) parent.getItemAtPosition(position);
        Utils.openPackage(this,app.packageName);
    }
    public static final int CODE_UNINSTALL = 0;

    @Override
    public void btnOnClick(int pos, String packageName) {
        Utils.uninstallApk(this,packageName,CODE_UNINSTALL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE_UNINSTALL){
            // 更新
            updateData();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
