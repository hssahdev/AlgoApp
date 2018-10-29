
package com.algo.android.algoapp.Adapters;

        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import com.algo.android.algoapp.Edge;
        import com.algo.android.algoapp.R;


public class GraphOutputAdapter extends RecyclerView.Adapter<GraphOutputAdapter.MyViewHolder> {

    int size;
    Edge[] arr;

    public GraphOutputAdapter(int size,Edge arr[]){
        this.size = size;
        this.arr = arr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.graph_output_adapter,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if(i==size-1){
            Edge e = arr[i];
            myViewHolder.mTextView.setText(e.source+" " + e.dest + " " + e.weight);
        }
        else{
            Edge e = arr[i];
            myViewHolder.mTextView.setText(e.source+" " + e.dest + " " + e.weight+" -> ");
        }

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
