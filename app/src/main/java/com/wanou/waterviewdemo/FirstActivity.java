package com.wanou.waterviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wanou.testlib.base.BaseActivity;


public class FirstActivity extends BaseActivity implements View.OnClickListener {
    private TextView tvJump;

    @Override
    protected int getResId() {
        return R.layout.activity_first;
    }

    @Override
    protected void initView() {

        tvJump = findViewById(R.id.tvJump);
        tvJump.setOnClickListener(this);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void setData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvJump:
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }
}
