package com.example.fragmentwithnavigationcomponent.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentwithnavigationcomponent.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.fragmentwithnavigationcomponent.UI.FragmentShoppingHomeScreen.hashMap;

public class CartAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    HashMap<Integer,ShoppingItems> itemsHashMap=new HashMap<>();
    private IValue iValue;

    public CartAdpater(Context context, HashMap<Integer,ShoppingItems> itemsHashMap) {
        mContext = context;
        this.itemsHashMap =itemsHashMap;

        if (this.itemsHashMap == null) {
            this.itemsHashMap = new HashMap<>();
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
        final ShoppingItems item = itemsHashMap.get(position);
        final ItemsViewHolder itemHolder = (ItemsViewHolder) holder;
            itemHolder.itemTitle.setText(item.getName());
            itemHolder.itemPrice.setText(item.getPrice());
            itemHolder.itemImage.setImageResource(item.getImage());


    }

    @Override
    public int getItemCount() {
        return itemsHashMap.size();
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

