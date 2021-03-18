package com.spl.demo.fristapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity7 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main6);
    }



    public void btnClick(View v){

        Intent intent = new Intent(this,DialogActivity.class);
        startActivity(intent);

    }

}
