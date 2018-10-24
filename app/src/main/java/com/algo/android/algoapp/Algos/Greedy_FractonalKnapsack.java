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

import java.util.Arrays;
import java.util.Comparator;

public class Greedy_FractonalKnapsack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greedy__fractonal_knapsack);

        final EditText editText = findViewById(R.id.greedy__fractonal_knapsack_noOfTerms);
        Button button = findViewById(R.id.greedy__fractonal_knapsack_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(editText.getText().toString());
                DP_RodCutting.hideKeyboardFrom(getApplicationContext(), editText);
                Log.v("check", "click");
                findViewById(R.id.greedy__fractonal_knapsack_entering_data).setVisibility(View.VISIBLE);

                RecyclerView recyclerView = findViewById(R.id.greedy__fractonal_knapsack_recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                final DoubleArrayInputAdapter adapter = new DoubleArrayInputAdapter(no);
                recyclerView.setAdapter(adapter);

                findViewById(R.id.greedy__fractonal_knapsack_submitDataButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int[] values = adapter.getFirstArray();
                        int[] weight = adapter.getSecondArray();
                        int maxWeight = Integer.parseInt(((EditText) findViewById(R.id.greedy__fractonal_knapsack_maxWeight)).getText().toString());
                        getAnswer(maxWeight, values, weight);
                        DP_RodCutting.hideKeyboardFrom(getApplicationContext(), view);
                    }
                });
            }
        });
    }

    private void getAnswer(int maxWeight, int[] values, int[] weight) {

        double ans = getMaxValue(weight,values,maxWeight);
         ((TextView)findViewById(R.id.greedy__fractonal_knapsack_answer)).setText("Maximum Obtainable Value is "+ans);

    }

    private static double getMaxValue(int[] wt, int[] val, int capacity) {
        ItemValue[] iVal = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }

        //sorting items by value;
        Arrays.sort(iVal, new Comparator<ItemValue>() {

            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });


        double totalValue = 0d;

        for (ItemValue i : iVal) {

            int curWt = (int) i.wt;
            int curVal = (int) i.val;

            if (capacity - curWt >= 0) {//this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;

            } else {//item cant be picked whole

                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }


        }

        return totalValue;

    }

    // item value class
    static class ItemValue {
        Double cost;
        double wt, val, ind;

        // item value function
        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double(val / wt);
        }

    }

}
