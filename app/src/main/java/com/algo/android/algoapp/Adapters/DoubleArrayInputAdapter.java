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


public class DoubleArrayInputAdapter extends RecyclerView.Adapter<DoubleArrayInputAdapter.MyViewHolder> {

    int size;
    int []arr1;
    int []arr2;

    public DoubleArrayInputAdapter(int size) {
        this.size = size;
        this.arr1 = new int[size];
        this.arr2 = new int[size];
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.double_array_input,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length()!=0)
                    arr1[i]=Integer.parseInt(editable.toString());
            }
        });

        myViewHolder.editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length()!=0)
                    arr2[i]=Integer.parseInt(editable.toString());
            }
        });

        myViewHolder.text1.setText("Value "+i);
        myViewHolder.text2.setText("Weight "+i);
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public int[] getFirstArray(){
        return arr1;
    }
    public int[] getSecondArray(){
        return arr2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text1,text2;
        EditText editText1, editText2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            editText1 = itemView.findViewById(R.id.edittext1);
            editText2 = itemView.findViewById(R.id.edittext2);

        }
    }
}
