package com.algo.android.algoapp.Algos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.algo.android.algoapp.Edge;
import com.algo.android.algoapp.R;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_Kruskal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greedy__kruskal);
    }
}





//class weightComparator implements Comparator<Edge> {
//
//	@Override
//	public int compare(Edge o1, Edge o2) {
//
//		return o1.weight-o2.weight;
//	}
//
//}
 class KruskalAlgorithm {

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

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        Edge input[]  = new Edge[E];
        Edge output[] = new Edge[V-1];
        int parent[]  = new int[V];
        //boolean visited[] = new boolean[V];

        for(int i = 0; i<V; ++i){
            parent[i] = i;
        }

        for(int i = 0; i<E; ++i){
            int x = s.nextInt();
            int y = s.nextInt();
            int z = s.nextInt();
            Edge e = new Edge(x,y,z);
            input[i] = e;
        }

        Arrays.sort(input);
//		for(int i = 0 ;i<E; ++i){
//			Edge e = input[i];
//			System.out.println(e.source + " " + e.dest + " " + e.weight);
//		}
        output = makeMST(input,output,parent);
        for(int i = 0 ;i<V-1; ++i){
            Edge e = output[i];
            System.out.println(e.source + " " + e.dest + " " + e.weight);
        }
        s.close();
    }



}
