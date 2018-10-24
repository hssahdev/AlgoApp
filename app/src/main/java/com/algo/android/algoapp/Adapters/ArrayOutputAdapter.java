package com.algo.android.algoapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.algo.android.algoapp.R;


public class ArrayOutputAdapter extends RecyclerView.Adapter<ArrayOutputAdapter.MyViewHolder> {

    int size;
    int []arr;

    public ArrayOutputAdapter(int size,int arr[]){
        this.size = size;
        this.arr = arr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_array_output_adapter,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if(i==size-1){
            myViewHolder.mTextView.setText(arr[i]);
        }
        else
        myViewHolder.mTextView.setText(arr[i]+" -> ");
    }




    @Override
    public int getItemCount() {
        return size;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.index);

        }
    }
}
