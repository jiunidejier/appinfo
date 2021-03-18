package com.spl.demo.fristapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;


public class MainActivity7 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main6);

        LayoutInflater inflater = LayoutInflater.from(this);

        View myView = inflater.inflate(R.layout.layout_myself_dialog, null);

        popup = new PopupWindow(myView,600,450);//设置宽高

        myView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();//关闭窗口
            }
        });
    }
    PopupWindow popup;//声明PopupWindow
    public void btnClick(View v){
        popup.showAtLocation(findViewById(R.id.btn_open), Gravity.CENTER,0,0);
    }

}
