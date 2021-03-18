package com.spl.demo.fristapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);//加载布局文件

        //1. 获取ListView对象
        ListView listview = (ListView) findViewById(R.id.lv_main);

        //2. 准备数据源
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_10);
        map.put("title", "千千静听");
        map.put("version", "版本: 8.4.0");
        map.put("size", "大小: 32.81M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_2);
        map.put("title", "时空猎人");
        map.put("version", "版本: 2.4.1");
        map.put("size", "大小: 84.24M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_4);
        map.put("title", "360新闻");
        map.put("version", "版本: 6.2.0");
        map.put("size", "大小: 11.74M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_15);
        map.put("title", "捕鱼达人2");
        map.put("version", "版本: 2.3.0");
        map.put("size", "大小: 45.53M");
        list.add(map);

        // 第2次测试数据
        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_10);
        map.put("title", "千千静听");
        map.put("version", "版本: 8.4.0");
        map.put("size", "大小: 32.81M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_2);
        map.put("title", "时空猎人");
        map.put("version", "版本: 2.4.1");
        map.put("size", "大小: 84.24M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_4);
        map.put("title", "360新闻");
        map.put("version", "版本: 6.2.0");
        map.put("size", "大小: 11.74M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_15);
        map.put("title", "捕鱼达人2");
        map.put("version", "版本: 2.3.0");
        map.put("size", "大小: 45.53M");
        list.add(map);

        // 第2次测试数据
        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_10);
        map.put("title", "千千静听");
        map.put("version", "版本: 8.4.0");
        map.put("size", "大小: 32.81M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_2);
        map.put("title", "时空猎人");
        map.put("version", "版本: 2.4.1");
        map.put("size", "大小: 84.24M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_4);
        map.put("title", "360新闻");
        map.put("version", "版本: 6.2.0");
        map.put("size", "大小: 11.74M");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_15);
        map.put("title", "捕鱼达人2");
        map.put("version", "版本: 2.3.0");
        map.put("size", "大小: 45.53M");
        list.add(map);

        //3. 准备适配器Adapter
        MyAdapter adapter = new MyAdapter(this);
        adapter.setList(list);

        //4. 将适配器关联到ListView
        listview.setAdapter(adapter);

        //5. 监听item事件
        listview.setOnItemClickListener(this);
        listview.setOnItemLongClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"点击item"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"长按item"+position,Toast.LENGTH_SHORT).show();
        return false;
    }
}
