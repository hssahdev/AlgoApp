package com.algo.android.algoapp.Algos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.algo.android.algoapp.R;

public class Greedy_Prims extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greedy__prims);
    }
}



public class PrimsAlgorithm{

    public static void makeMST(int[][]edges, int parent[], int weight[], int start, boolean[] visited){
        int n = edges.length;

        while(true){

            int small = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0; j<n ;++j){
                if(weight[j]<small&&!visited[j]){
                    small = weight[j];
                    index = j;
                }
            }
            if(index==-1)
                return;
            //if(!visited[p])
            makeMST2(edges, parent, weight, index, visited);
            //System.out.println(index +"c");
        }
    }

    public static void makeMST2(int[][]edges, int parent[], int weight[], int i, boolean[] visited){
        //System.out.println(i);
        visited[i] = true;
        int n = edges.length;
        for(int j = 0; j<n; ++j){
            if(edges[i][j]>0&&!visited[j]&&edges[i][j]<weight[j]){
                weight[j] = edges[i][j];
                parent[j] = i;
            }
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int p = 0;
        int [][]edges = new int[V][V];
        boolean visited[] = new boolean[V];
        for(int i = 0; i<E; ++i){
            int x = s.nextInt();
            int y = s.nextInt();
            int z = s.nextInt();
            edges[x][y] = z;
            edges[y][x] = z;
            p=x;
        }
        p = 0 ;
        int parent[] = new int[V];
        int weight[] = new int[V];
        parent[p] = -1;
        weight[p] = 0;
        for(int i = 0; i<V; ++i){
            if(i==p)
                continue;
            parent[i] = -1;
            weight[i] = Integer.MAX_VALUE;
        }
        makeMST(edges, parent, weight, p, visited);
        for(int i = 0; i<V; ++i){
            if(i==p)
                continue;
            if(i<parent[i]){
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
            else{
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }
        }
        s.close();
    }

}
