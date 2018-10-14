package com.algo.android.algoapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    int size;
    int []arr;

    public MyAdapter(int size){
        this.size=size;
        arr=new int[size];
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.enteringdataview,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        if(i==0)
            myViewHolder.mTextView.setText("Price for "+(i+1)+"st piece:");
        else if(i==1)
            myViewHolder.mTextView.setText("Price for "+(i+1)+"nd piece:");
        else if(i==2)
            myViewHolder.mTextView.setText("Price for "+(i+1)+"rd piece:");
        else
            myViewHolder.mTextView.setText("Price for "+(i+1)+"th piece:");


        myViewHolder.mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                arr[i]=Integer.parseInt(editable.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public int[] getEnteredData(){
        return arr;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        EditText mEditText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.index);
            mEditText=itemView.findViewById(R.id.noToEnter);
        }
    }
}
