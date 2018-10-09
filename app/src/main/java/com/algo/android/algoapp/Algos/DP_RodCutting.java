package com.algo.android.algoapp.Algos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.algo.android.algoapp.EnteringData;
import com.algo.android.algoapp.R;

public class DP_RodCutting extends AppCompatActivity implements EnteringData.OnFragmentInteractionListener {

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

                EnteringData ed = EnteringData.newInstance(no);
                getSupportFragmentManager().beginTransaction().add(R.id.enteringData,ed).commit();



//                AlertDialog.Builder builder = new AlertDialog.Builder(DP_RodCutting.this);
//                builder.setView(view1).setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                }).setTitle("Enter Data")
//                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                            }
//                        });
//
//
//                AlertDialog dialog = builder.create();
//
//                dialog.getWindow().setSoftInputMode (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//
//                dialog.show();

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

    @Override
    public void onFragmentInteraction(int []k) {
//        cutRod(k,k.length);
        Toast.makeText(this, "Max Price: "+cutRod(k,k.length), Toast.LENGTH_SHORT).show();
    }
}
