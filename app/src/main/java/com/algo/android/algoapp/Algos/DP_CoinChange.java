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

        import com.algo.android.algoapp.Adapters.SingleArrayInputAdapter;
        import com.algo.android.algoapp.R;

        import java.util.Arrays;

public class DP_CoinChange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp__coin_change);

        final EditText editText = findViewById(R.id.coinchange_noOfTerms);
        Button button = findViewById(R.id.coinchange_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(editText.getText().toString());
                DP_RodCutting.hideKeyboardFrom(getApplicationContext(),editText);
                Log.v("check","click");
                findViewById(R.id.coinchange_entering_data).setVisibility(View.VISIBLE);

                RecyclerView recyclerView = findViewById(R.id.coinchange_recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                final SingleArrayInputAdapter adapter  = new SingleArrayInputAdapter(no);
                recyclerView.setAdapter(adapter);

                findViewById(R.id.coinchange_submitDataButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int []denomination = adapter.getEnteredData();

                        int value = Integer.parseInt(((EditText)findViewById(R.id.coinchange_value)).getText().toString());
                        getAnswer(denomination,value);
                        DP_RodCutting.hideKeyboardFrom(getApplicationContext(), view);
                    }
                });
            }
        });
    }

    private void getAnswer(int[] denomination, int value) {
        long ans = countWays(denomination,denomination.length,value);
        Log.i("hello","coin change ans = "+ans);
        if(ans == 0){
            ((TextView)findViewById(R.id.coinchange_answer)).setText("Sorry no ways to make "+value);
        }
        else if(ans==1){
            ((TextView)findViewById(R.id.coinchange_answer)).setText("Only one possible way :) ");
        }
        else
        ((TextView)findViewById(R.id.coinchange_answer)).setText("Total number of ways are  "+ans);
    }



    static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }





}


