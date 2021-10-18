package com.example.zakupy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ProductViewHolder> {
    private final LinkedList<String> shoppingList;
    private LayoutInflater inflater;
    int kupione = 0;
    //konstruktor
    public ShoppingAdapter(Context context, LinkedList<String> shoppingList ){
        inflater = LayoutInflater.from(context);
        this.shoppingList = shoppingList;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflater.inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
      holder.productItemView.setText(shoppingList.get(position));

    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView productItemView;
        final ShoppingAdapter shoppingAdapter;

        public ProductViewHolder(@NonNull View itemView, ShoppingAdapter adapter) {
            super(itemView);
            productItemView = itemView.findViewById(R.id.textView);
            this.shoppingAdapter = adapter;
            itemView.setOnClickListener(this); //łączymy kliknięcie z adapterem
        }

        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            String tekst = shoppingList.get(itemPosition);

            if (kupione == 0){
                shoppingList.set(itemPosition, tekst + " kupione");
                kupione = 1;
            }
            else{
                tekst = tekst.substring(0,tekst.indexOf(" "));
                shoppingList.set(itemPosition, tekst);
                kupione = 0;
                }

            shoppingAdapter.notifyDataSetChanged();
        }
    }
}
