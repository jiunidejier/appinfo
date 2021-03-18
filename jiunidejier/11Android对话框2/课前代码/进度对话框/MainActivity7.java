package com.spl.demo.fristapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;


public class MainActivity7 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main6);

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            pd.dismiss();
        }
    };

    ProgressDialog pd;

    public void btnClick(View v){

        showProgress();
        new Thread(){
            @Override
            public void run() {
                // 耗时操作
                for (int i = 0; i<3; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(0);
            }
        }.start();

    }

    public void showProgress(){
        pd = new ProgressDialog(this);
        pd.setTitle("任务执行中");
        pd.setMessage("任务执行中,请稍候...");
        pd.setCancelable(true);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

}
