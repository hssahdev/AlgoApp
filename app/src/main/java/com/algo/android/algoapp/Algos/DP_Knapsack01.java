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

import com.algo.android.algoapp.Adapters.DoubleArrayInputAdapter;
import com.algo.android.algoapp.R;

public class DP_Knapsack01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp__knapsack01);

        final EditText editText = findViewById(R.id.knapsack_noOfTerms);
        Button button = findViewById(R.id.knapsack_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(editText.getText().toString());
                DP_RodCutting.hideKeyboardFrom(getApplicationContext(),editText);
                Log.v("check","click");
                findViewById(R.id.knapsack_entering_data).setVisibility(View.VISIBLE);

                RecyclerView recyclerView = findViewById(R.id.knapsack_recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                final DoubleArrayInputAdapter adapter  = new DoubleArrayInputAdapter(no);
                recyclerView.setAdapter(adapter);

                findViewById(R.id.knapsack_submitDataButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int []values = adapter.getFirstArray();
                        int[] weight = adapter.getSecondArray();
                        int maxWeight = Integer.parseInt(((EditText)findViewById(R.id.knapsack_maxWeight)).getText().toString());
                        getAnswer(maxWeight,values,weight,weight.length-1);
                        DP_RodCutting.hideKeyboardFrom(getApplicationContext(), view);
                    }
                });
            }
        });
    }

    private void getAnswer(int maxWeight, int[] values, int[] weight, int i) {

        int ans = knapsackDP(maxWeight,values,weight,i);
//        Toast.makeText(this, ans+"", Toast.LENGTH_SHORT).show();
        ((TextView)findViewById(R.id.knapsack_answer)).setText("Maximum Obtainable Value is "+ans);

    }

    static int knapsackDP(int W,int values[] ,int weights[], int n){

        int store[][]=new int[n+1][W+1];

        for (int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                store[i][j]=-1;
            }
        }
        int o= util(W,values,weights,n,store);

        for (int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                System.out.print(store[i][j] + " ");
            }
            System.out.println();
        }
        return o;
    }

    static int util(int W,int values[] ,int weights[], int n, int[][]store){
        if (store[n][W]!=-1)
            return store[n][W];

        if (n<=0)
        {   store[n][W]= 0;
            return 0;}

        if (weights[n]>W){
            store[n][W]=util(W,values,weights,n-1,store);
            return store[n][W];
        }

        else{
            store[n][W] = Math.max(values[n]+util(W-weights[n],values,weights,n-1,store),util(W,values,weights,n-1,store));
            return store[n][W];
        }
    }

}


