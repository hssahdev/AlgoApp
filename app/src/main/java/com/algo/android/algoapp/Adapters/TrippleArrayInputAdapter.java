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

        import com.algo.android.algoapp.Edge;
        import com.algo.android.algoapp.R;


public class TrippleArrayInputAdapter extends RecyclerView.Adapter<com.algo.android.algoapp.Adapters.TrippleArrayInputAdapter.MyViewHolder> {

    int size;
    int []arr1;
    int []arr2;
    int []arr3;
    Edge arr[];

    public TrippleArrayInputAdapter(int size) {
        this.size = size;
        this.arr1 = new int[size];
        this.arr2 = new int[size];
        this.arr3 = new int[size];
        this.arr = new Edge[size];
    }

    @NonNull
    @Override
    public com.algo.android.algoapp.Adapters.TrippleArrayInputAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tripple_array_input_adapter,viewGroup,false);
        return new com.algo.android.algoapp.Adapters.TrippleArrayInputAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.algo.android.algoapp.Adapters.TrippleArrayInputAdapter.MyViewHolder myViewHolder, final int i) {

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

        myViewHolder.editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length()!=0)
                    arr3[i]=Integer.parseInt(editable.toString());
            }
        });

        myViewHolder.text1.setText("Source "+i);
        myViewHolder.text2.setText("Dest "+i);
        myViewHolder.text3.setText("Weight "+i);
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
    public int[] getThirdArray(){
        return arr3;
    }

    public Edge[] getInputArr() {

        for(int i = 0; i<size; ++i){
            Edge e = new Edge(arr1[i],arr2[i],arr3[i]);
            arr[i] = e;
        }

        return arr;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text1,text2,text3;
        EditText editText1, editText2, editText3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
            editText1 = itemView.findViewById(R.id.edittext1);
            editText2 = itemView.findViewById(R.id.edittext2);
            editText3 = itemView.findViewById(R.id.edittext3);
        }
    }
}
