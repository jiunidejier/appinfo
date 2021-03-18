package com.spl.appch5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by uilubo on 2015/9/16.
 */
public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置全屏
        setContentView(R.layout.main8);
        // 初始化控件

        String index = getIntent().getStringExtra("index");
        String title = getIntent().getStringExtra("title");

        TextView info = (TextView) findViewById(R.id.info);
        info.setText("编号:"+index + " "+ title );


    }
}
