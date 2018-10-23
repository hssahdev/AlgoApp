package com.algo.android.algoapp.Algos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.algo.android.algoapp.Adapters.SingleArrayInputAdapter;
import com.algo.android.algoapp.R;

public class DP_RodCutting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp__rod_cuttings);

        final EditText editText = findViewById(R.id.noOfTerms);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(editText.getText().toString());

                hideKeyboardFrom(DP_RodCutting.this,editText);

//                EnteringData ed = EnteringData.newInstance(no);
//                getSupportFragmentManager().beginTransaction().replace(R.id.enteringData,ed).commit();

                findViewById(R.id.rodcutting_entering_data).setVisibility(View.VISIBLE);

                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                final SingleArrayInputAdapter adapter  = new SingleArrayInputAdapter(no);
                recyclerView.setAdapter(adapter);

                findViewById(R.id.submitDataButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int []k = adapter.getEnteredData();
                        onButtonPressed(k);
                        hideKeyboardFrom(getApplicationContext(),view);
                    }
                });
            }
        });
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    static int cutRod(int[]price,int n){
        int[] arr = new int[n];
        for (int i=0;i<n;i++)
            arr[i]=-1;
        return cutRodUtility(price,n,arr);
    }

    static int cutRodUtility(int []price, int n, int[]arr){
        if(arr[n-1]!=-1)
            return arr[n-1];

        if (n<=0)
        {
            arr[n-1]= 0;
            return 0;
        }
        int maxCost=0;
        for(int i=1;i<n;i++){
            maxCost= Math.max(maxCost, price[i]+cutRodUtility(price,n-i,arr));
        }

        arr[n-1]= maxCost;
        return maxCost;
    }

    public void onButtonPressed(int []k) {
        int a[]= new int[k.length+1];
        a[0]=-1;
        for(int i=1;i<a.length;i++)
            a[i]=k[i-1];
        ((TextView)findViewById(R.id.rodcutting_answer)).setText("Maximum Obtainable Value is "+cutRod(a,a.length));
    }
}
