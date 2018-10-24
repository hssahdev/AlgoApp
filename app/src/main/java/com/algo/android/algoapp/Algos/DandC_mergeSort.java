package com.algo.android.algoapp.Algos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.algo.android.algoapp.Adapters.ArrayOutputAdapter;
import com.algo.android.algoapp.Adapters.DoubleArrayInputAdapter;
import com.algo.android.algoapp.Adapters.SingleArrayInputAdapter;
import com.algo.android.algoapp.R;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DandC_mergeSort extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dand_c_merge_sort);

        final EditText editText = findViewById(R.id.mergeSort_noOfTerms);
        Button button = findViewById(R.id.mergeSort_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final int no = Integer.parseInt(editText.getText().toString());
                DP_RodCutting.hideKeyboardFrom(getApplicationContext(),editText);
                Log.v("check","click");
                findViewById(R.id.mergeSort_entering_data).setVisibility(View.VISIBLE);

                RecyclerView recyclerView = findViewById(R.id.mergeSort_recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                final SingleArrayInputAdapter adapter  = new SingleArrayInputAdapter(no);
                recyclerView.setAdapter(adapter);

                findViewById(R.id.mergeSort_submitDataButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int []elements = adapter.getEnteredData();

                       // int value = Integer.parseInt(((EditText)findViewById(R.id.coinchange_value)).getText().toString());
                        getAnswer(no,elements);
                        DP_RodCutting.hideKeyboardFrom(getApplicationContext(), view);
                    }
                });
            }
        });
    }

    private void getAnswer(int no,int []arr){
        Arrays.sort(arr);

        RecyclerView recyclerView = findViewById(R.id.mergeSort_answer_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final ArrayOutputAdapter adapter  = new ArrayOutputAdapter(no,arr);
        recyclerView.setAdapter(adapter);
    }

}


