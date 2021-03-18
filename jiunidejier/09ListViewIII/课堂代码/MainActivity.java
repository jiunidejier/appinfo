package com.spl.appch5;

import android.app.Activity;
import android.content.Intent;
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

        setContentView(R.layout.main7);

        //1.拿到listview对象
        ListView lv = (ListView) this.findViewById(R.id.lv_main);

        //2.数据源
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String, Object>();
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

        //3.设置适配器
//        SimpleAdapter adapter = new SimpleAdapter(
//                this,
//                list,
//                R.layout.item,
//                new String[]{"logo","title","version","size"},
//                new int[]{R.id.logo,R.id.title,R.id.version,R.id.size}
//        );

        MyAdapter adapter = new MyAdapter(this);
        adapter.setList(list);


        //4.关联适配器
        lv.setAdapter(adapter);

        //5
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,"点击"+position,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(this,DetailActivity.class);

        //1.获得所点击行的数据(Map)
        HashMap<String, Object> itemMap
                = (HashMap<String, Object>) parent.getItemAtPosition(position);
        intent.putExtra("index", ""+position);
        intent.putExtra("title", ""+itemMap.get("title"));
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"长按"+position,Toast.LENGTH_SHORT).show();
        return true;
    }
}
