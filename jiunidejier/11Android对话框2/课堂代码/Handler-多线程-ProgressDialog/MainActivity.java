package com.tangcco.testapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity
        implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    ListView listView;
    MyAdapter adapter;
    List<Map<String,Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 联网

        listView = (ListView) findViewById(R.id.lv_main);
        // Data
        list = new ArrayList<Map<String, Object>>();

        adapter = new MyAdapter(this);

        listView.setAdapter(adapter);
        // 点击事件
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this,DetailActivity.class);
//        intent.putExtra("pos",position);
//        Map<String,Object> map =
//                (Map<String, Object>) parent.getItemAtPosition(position);
//        intent.putExtra("title",(String)map.get("title"));
//        startActivity(intent);
        Calendar c = Calendar.getInstance();
        // 创建一个TimePickerDialog实例，并把它显示出来。
        new TimePickerDialog(this,
                // 绑定监听器
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int hourOfDay,
                                          int minute) {
                        String text = "您选择了：" + hourOfDay + "时" + minute
                                + "分";
                        Toast.makeText(MainActivity.this, text,
                                Toast.LENGTH_LONG).show();
                    }
                }
                //设置初始时间
                , c.get(Calendar.HOUR_OF_DAY)
                , c.get(Calendar.MINUTE)
                //true表示采用24小时制
                , true).show();

    }

    ArrayList<Integer> MultiChoiceID = new ArrayList <Integer>();
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,"pos="+position,Toast.LENGTH_SHORT).show();


        // 反射出View
        final View v =
                getLayoutInflater().inflate(R.layout.layout_myself_dialog,null);
//        final Dialog dialog =  new AlertDialog.Builder(this)
//                .setView(v)
//                .create();

        pop = new PopupWindow(v, 650, 500);
        v.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();// 关闭对话
            }
        });

        //pop.showAsDropDown(view);
            pop.showAtLocation(view, Gravity.CENTER,0,0);

        return true;
    }

    PopupWindow pop;

    //1.准备进度框
    ProgressDialog pd;

    private void showProgressDialog(){
        pd = new ProgressDialog(this);
        pd.setTitle("提示消息");
        pd.setMessage("请耐心等待...");
        pd.setCancelable(true);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMax(100);

        pd.show();
    }

    //2. handler
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1) {
                // UI
                adapter.setList(list);
                adapter.notifyDataSetChanged();//原地更新
                pd.dismiss();//关闭进度框
            }
            if(msg.what == 0) {
                // UI
                pd.setProgress(msg.arg1);
            }
        }
    };

    // 3.多线程编程
    private void updateData(){
        // 1.启动子线程 --- 子线程
        new Thread(){
            @Override
            public void run() {
                // 耗时操作
                for (int i = 0; i< 100; i++){
                    Map<String,Object> map = new HashMap<String, Object>();
                    map.put("logo",R.drawable.ic_launcher);
                    map.put("title","这是标题"+(i+1));
                    try {
                        Thread.sleep(100);// 挂起2秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = Message.obtain();
                    msg.arg1 = i+1;
                    msg.what = 0;
                    handler.sendMessage(msg);

                    list.add(map);
                }

                handler.sendEmptyMessage(1);// 向主线程发送消息
            }
        }.start();
        // 2. 显示进度框 ---- UI线程 -- ANR Application Not Response
        showProgressDialog();

    }
}
