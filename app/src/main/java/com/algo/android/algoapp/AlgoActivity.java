package com.algo.android.algoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AlgoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.get("data").toString();
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(data);
    }
}
