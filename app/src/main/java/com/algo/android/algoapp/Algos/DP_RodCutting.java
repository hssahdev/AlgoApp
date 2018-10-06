package com.algo.android.algoapp.Algos;

public class DP_RodCutting {
    public static void main(String[] args) {
        int []price = {-1 , 1  , 5,   8,   9,  10,  17,  17,  20};
        System.out.println(cutRod(price,price.length));
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
}
