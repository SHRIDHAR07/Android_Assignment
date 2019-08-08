package com.example.fragmentwithnavigationcomponent.Adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fragmentwithnavigationcomponent.Model.IValue;
import com.example.fragmentwithnavigationcomponent.Model.Product;
import com.example.fragmentwithnavigationcomponent.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<Product> itemsList;
    private IValue iValue;

    public ProductsAdpater(Context context, List<Product> itemsList) {
        mContext = context;

        this.itemsList = itemsList;

        if (this.itemsList == null) {
            this.itemsList = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.cart_items, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Product product = itemsList.get(position);
        final ItemsViewHolder itemHolder = (ItemsViewHolder) holder;

        itemHolder.itemName.setText(product.getName());
        itemHolder.itemPrice.setText(product.getPrice());
        itemHolder.itemImage.setImageResource(product.getImage());
        itemHolder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iValue != null) {
                   iValue.onImageClick(product);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.cart_item_image);
            itemName = itemView.findViewById(R.id.cart_item_name);
            itemPrice = itemView.findViewById(R.id.cart_item_price);

        }
    }

        public void setValueEnteredListner(IValue iValue) {
        this.iValue = iValue;
    }
}


