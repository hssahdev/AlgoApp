package com.algo.android.algoapp.Algos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.algo.android.algoapp.Adapters.GraphOutputAdapter;

import com.algo.android.algoapp.Adapters.TrippleArrayInputAdapter;
import com.algo.android.algoapp.Edge;
import com.algo.android.algoapp.R;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_Kruskal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greedy__kruskal);

        final EditText editText = findViewById(R.id.kruskal_noOfEdges);
        final EditText editText1 = findViewById(R.id.kruskal_noOfVertices);
        Button button = findViewById(R.id.kruskal_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int E = Integer.parseInt(editText.getText().toString());
                final int V = Integer.parseInt(editText1.getText().toString());
                DP_RodCutting.hideKeyboardFrom(getApplicationContext(),editText);
                Log.v("check","click");
                findViewById(R.id.kruskal_entering_data).setVisibility(View.VISIBLE);

                RecyclerView recyclerView = findViewById(R.id.kruskal_recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                final TrippleArrayInputAdapter adapter  = new TrippleArrayInputAdapter(E);
                recyclerView.setAdapter(adapter);


                findViewById(R.id.kruskal_submitDataButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Edge []input = adapter.getInputArr();
                        getAnswer(input,E,V);
                        DP_RodCutting.hideKeyboardFrom(getApplicationContext(), view);
                    }
                });
            }
        });
    }

    private void getAnswer(Edge[] input,int E,int V) {

        Edge output[] = new Edge[V-1];
        int parent[]  = new int[V];

        for(int i = 0; i<V; ++i){
            parent[i] = i;
        }

        Arrays.sort(input);
//		for(int i = 0 ;i<E; ++i){
//			Edge e = input[i];
//			System.out.println(e.source + " " + e.dest + " " + e.weight);
//		}
        output = makeMST(input,output,parent);

        RecyclerView recyclerViewans = (RecyclerView) findViewById(R.id.kruskal_answer_recyclerView);

        recyclerViewans.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final GraphOutputAdapter adapter  = new GraphOutputAdapter(E,output);
        recyclerViewans.setAdapter(adapter);
    }

    public static Edge[] makeMST(Edge[] input, Edge[] output, int[] parent) {
        int k = 0;
        for(int i = 0; i<input.length; ++i){
            Edge e = input[i];

            int p1 = findParent(e.source,parent);
            int p2 = findParent(e.dest,parent);
            if(p1!=p2)
            {
                output[k] = e;
                ++k;
                parent[p2] = parent[p1];
            }
        }


        return output;
    }

    private static int findParent(int i, int[] parent) {
        if(i==parent[i])
            return i;
        int k = i;
        while(i!=parent[i]){
            i = parent[i];
        }
        parent[k] = i;
        return i;
    }



}
