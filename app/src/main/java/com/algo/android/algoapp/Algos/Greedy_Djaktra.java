package com.algo.android.algoapp.Algos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.algo.android.algoapp.R;

import java.util.Scanner;

public class Greedy_Djaktra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greedy__djaktra);
    }
}


 class DijkstrasAlgorithm {


    private static void makeMST(int[][] edges, int[] distance, int p, boolean[] visited) {

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

        int distance[] = new int[V];
        distance[0] = 0;
        for(int i = 0; i<V; ++i){
            if(i==p)
                continue;

            distance[i] = Integer.MAX_VALUE;
        }
        makeMST(edges, distance, p, visited);
        for(int i = 0; i<V; ++i){
            System.out.println(i + " " + distance[i]);
        }
        s.close();
    }


}
