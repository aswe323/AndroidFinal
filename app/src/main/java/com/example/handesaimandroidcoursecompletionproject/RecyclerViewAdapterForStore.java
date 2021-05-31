package com.example.handesaimandroidcoursecompletionproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterForStore extends RecyclerView.Adapter<RecyclerViewAdapterForStore.ViewHolder> {

    LiveData<List<Item>> data = new LiveData<List<Item>>;

    public void setData(List<Item> data) {
        this.data = data;
    }

    // FIXME: 31/05/2021 changes in qty of items passed as data to the adapter need to also update the Database UserWithItems table
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    public void onBindViewHolder(@NonNull RecyclerViewAdapterForStore.ViewHolder holder, int position) {

    }

    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView itemQty;
        Button subtract;
        Button add;

        public ViewHolder(View view) {
            super(view);

            itemName = view.findViewById(R.id.itemName);
            itemQty = view.findViewById(R.id.qty);



            subtract = view.findViewById(R.id.subtract);
            add = view.findViewById(R.id.add);

            add.setOnClickListener(v -> itemQty.setText(Integer.parseInt(itemQty.getText().toString()) + 1));

            subtract.setOnClickListener(v -> itemQty.setText(Integer.parseInt(itemQty.getText().toString()) - 1));


        }
    }
}
