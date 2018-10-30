package com.algo.android.algoapp.Algos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.algo.android.algoapp.Adapters.TrippleArrayInputAdapter;
import com.algo.android.algoapp.Edge;
import com.algo.android.algoapp.R;

public class Greedy_Djaktra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greedy__djaktra);


        findViewById(R.id.dijkstra_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.dijstra_noOfTerms);
                int noOfEdges = Integer.parseInt(editText.getText().toString());
                final TrippleArrayInputAdapter adapter = new TrippleArrayInputAdapter(noOfEdges);
                RecyclerView recyclerView = findViewById(R.id.dijkstra_recycler);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);

                findViewById(R.id.dijkstra_submitDataButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        int noOfVertices = Integer.parseInt(((EditText)findViewById(R.id.dijstra_noOfVertices)).toString().trim());
                        Edge edges[]= adapter.getInputArr();

                        int a[][] = new int[edges.length][2];
                        int weight[] = new int[edges.length];
                        for(int i=0;i<edges.length;i++){
                            a[i][0] = edges[i].source;
                            a[i][1] = edges[i].dest;
                            weight[i] = edges[i].weight;
                        }

                        DijkstrasAlgorithm.makeMST(a,weight, new boolean[edges.length]);

                    }
                });
            }
        });



    }
}


 class DijkstrasAlgorithm {


    public static void makeMST(int[][] edges, int[] distance, boolean[] visited) {

        int n = edges.length;

        while(true){

            int small = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0; j<n ;++j){
                if(distance[j]<small&&!visited[j]){
                    small = distance[j];
                    index = j;
                }
            }
            if(index==-1)
                return;
            //if(!visited[p])
            makeMST2(edges,  distance, index, visited);
            //System.out.println(index +"c");
        }
    }


    private static void makeMST2(int[][] edges, int[] distance, int i, boolean[] visited) {

        visited[i] = true;
        int n = edges.length;
        for(int j = 0; j<n; ++j){
            int cDist = distance[i] + edges[i][j];
            if(edges[i][j]>0&&!visited[j]&&cDist<distance[j]){
                distance[j] = cDist;

            }
        }

    }


//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        Scanner s = new Scanner(System.in);
//        int V = s.nextInt();
//        int E = s.nextInt();
//        int p = 0;
//        int [][]edges = new int[V][V];
//        boolean visited[] = new boolean[V];
//        for(int i = 0; i<E; ++i){
//            int x = s.nextInt();
//            int y = s.nextInt();
//            int z = s.nextInt();
//            edges[x][y] = z;
//            edges[y][x] = z;
//            p=x;
//        }
//        p = 0 ;
//
//        int distance[] = new int[V];
//        distance[0] = 0;
//        for(int i = 0; i<V; ++i){
//            if(i==p)
//                continue;
//
//            distance[i] = Integer.MAX_VALUE;
//        }
//        makeMST(edges, distance, visited);
//        for(int i = 0; i<V; ++i){
//            System.out.println(i + " " + distance[i]);
//        }
//        s.close();
//    }


}
