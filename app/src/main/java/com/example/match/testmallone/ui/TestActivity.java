package com.example.match.testmallone.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.match.testmallone.R;
import com.example.match.testmallone.weiget.MToolBar;

public class TestActivity extends AppCompatActivity {

    private MToolBar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mToolBar= (MToolBar) this.findViewById(R.id.toolbar);
    }
}
