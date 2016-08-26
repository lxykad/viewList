package com.lxy.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lxy.view.watch.WatchActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mTvWatch = (TextView) findViewById(R.id.watch);
        mTvWatch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.watch:
                startActivity(new Intent(MainActivity.this, WatchActivity.class));
                break;
        }
    }
}
