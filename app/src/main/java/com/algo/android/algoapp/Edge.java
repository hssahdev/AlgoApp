package com.algo.android.algoapp;


public class Edge implements Comparable<Edge>  {

    public int source;
    public int dest;
    public int weight;


    public Edge(int s, int d, int w){
        source = s;
        dest = d;
        weight = w;

    }


    @Override
    public int compareTo(Edge arg0) {
        return this.weight-arg0.weight;

    }


//	public int compareTo(Edge e){
//
//		if(this.weight==e.weight)
//			return 0;
//
//		if(this.weight>e.weight)
//			return 1;
//
//		return -1;
//
//	}

}
