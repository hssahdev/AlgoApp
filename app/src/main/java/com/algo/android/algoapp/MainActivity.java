package com.algo.android.algoapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.algo.android.algoapp.Algos.DP_Knapsack01;
import com.algo.android.algoapp.Algos.DP_RodCutting;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner1;
    private Spinner spinner2;
    private Button button;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private String chosenAlgo = "";

    List<String> algos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startActivity(new Intent(this,DP_RodCutting.class));

        spinner1 = (Spinner) findViewById(R.id.algo_spinner);
        spinner2 = (Spinner) findViewById(R.id.algo_spinner2);
        spinner2.setEnabled(false);
        button = (Button) findViewById(R.id.button);

        spinner1.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Select a technique");
        categories.add("Dynamic Programming");
        categories.add("Greedy");
        categories.add("Divide and Conquer");



        algos = new ArrayList<String>();
        clear();

        adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,categories);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,algos);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;

                // Switch between diff Activities
                // Have seperate activity for each Algo
                switch (chosenAlgo){
                    case "Rod cutting":
                        intent = new Intent(MainActivity.this,DP_RodCutting.class);
                        break;
                    case "0-1 Knapsack":
                        intent=new Intent(MainActivity.this,DP_Knapsack01.class);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spin = (Spinner) parent;
        button.setEnabled(false);

        String item = parent.getItemAtPosition(position).toString();
        if(spin.getId() == R.id.algo_spinner){
            spinner2.setEnabled(false);
            if(item.contentEquals("Dynamic Programming")){
                clear();

                algos.add("Rod cutting");
                algos.add("0-1 Knapsack");

                spinner2.setEnabled(true);

            }
            else if(item.contentEquals("Greedy")){
                clear();
                algos.add("Fractional Kanpsack");
                spinner2.setOnItemSelectedListener(this);
                spinner2.setEnabled(true);

            }
            else if(item.contentEquals("Divide and Conquer")){
                clear();
                algos.add("Merge Sort");
                algos.add("Quick Sort");
                spinner2.setOnItemSelectedListener(this);
                spinner2.setEnabled(true);

            }

        }else {
            if(!item.contentEquals("Select an algorithm")){
                chosenAlgo = item;
                button.setEnabled(true);

            }
        }

    }

    private void clear() {
        algos.clear();
        algos.add("Select an algorithm");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
