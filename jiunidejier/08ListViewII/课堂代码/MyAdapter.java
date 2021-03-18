package com.spl.demo.fristapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 钧 on 2015/8/19.
 */
public class MyAdapter extends BaseAdapter {

    /** 数据集合 */
    List<Map<String,Object>> list;
    /** 反射器 */
    LayoutInflater inflater;
    /**
     * 构造器
     * @param context 上下文
     */
    public MyAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }
    /**
     * 传入数据集合
     * @param list
     */
    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item,null);

        ImageView logo = (ImageView) view.findViewById(R.id.logo);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView version = (TextView) view.findViewById(R.id.version);
        TextView size = (TextView) view.findViewById(R.id.size);

        logo.setImageResource((Integer) list.get(position).get("logo"));
        title.setText((String) list.get(position).get("title"));
        version.setText((String) list.get(position).get("version"));
        size.setText((String) list.get(position).get("size"));

        Button btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("spl", "点击");
            }
        });

        return view;
    }
}
