package com.example.allforone_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import bean.newss;
import config.HttpSubscribe;
import netUtils.OnSuccessAndFaultListener;
import netUtils.OnSuccessAndFaultSub;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private TextView mTvGet;
    private TextView mTvPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initViews();
    }

    private void initViews() {
        mTvGet = (TextView) findViewById(R.id.tv_get);
        mTvPost = (TextView)findViewById(R.id.tv_post);

        mTvGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpSubscribe.getNews(mContext,"top","9f552a8aca577737335c7106f1236a97",new OnSuccessAndFaultSub<newss>(new OnSuccessAndFaultListener<newss>() {
                    @Override
                    public void onSuccess(newss result) {
                        mTvGet.setText(result.getResult().getData().get(0).getTitle());
                    }

                    @Override
                    public void onFault(String errorMsg) {
                        Log.e("zbf","错误信息:"+errorMsg);
                    }
                }));
            }
        });

        mTvPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpSubscribe.postNews(mContext,"top","9f552a8aca577737335c7106f1236a97",new OnSuccessAndFaultSub<newss>(new OnSuccessAndFaultListener<newss>() {
                    @Override
                    public void onSuccess(newss result) {
                        mTvPost.setText(result.getResult().getData().get(0).getTitle());
                    }

                    @Override
                    public void onFault(String errorMsg) {
                        Log.e("zbf","错误信息:"+errorMsg);
                    }
                }));
            }
        });
    }
}
