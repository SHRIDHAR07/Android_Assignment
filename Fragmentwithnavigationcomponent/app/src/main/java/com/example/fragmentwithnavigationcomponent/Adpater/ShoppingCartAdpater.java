package com.example.fragmentwithnavigationcomponent.Adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentwithnavigationcomponent.Model.CartItem;
import com.example.fragmentwithnavigationcomponent.Model.IValue;
import com.example.fragmentwithnavigationcomponent.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ShoppingCartAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    List<CartItem> itemsList;

    private IValue iValue;

    public ShoppingCartAdpater(Context context, List<CartItem> cartItems) {
        mContext = context;
        this.itemsList =cartItems;

        if (this.itemsList == null) {
            this.itemsList = new ArrayList<>();

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.cart_item_list, parent, false);
        return new ItemsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

            final CartItem cartItem= itemsList.get(position);
            final ItemsViewHolder itemHolder = (ItemsViewHolder) holder;
            itemHolder.itemQuantity.setText( String.valueOf(cartItem.getQuantity()));
            itemHolder.itemTitle.setText(cartItem.getProduct().getName());
            itemHolder.itemPrice.setText(cartItem.getProduct().getPrice());
            itemHolder.itemImage.setImageResource(cartItem.getProduct().getImage());
        }


    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemPrice;
        TextView itemQuantity;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.cart_item_image_list);
            itemTitle = itemView.findViewById(R.id.cart_item_name_list);
            itemPrice = itemView.findViewById(R.id.cart_item_price_list);
            itemQuantity=itemView.findViewById(R.id.cart_item_Quantity_list);
        }
    }
    public void setValueEnteredListner(IValue iValue) {
        this.iValue = iValue;
    }

}

