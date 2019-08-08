package com.example.fragmentwithnavigationcomponent.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentwithnavigationcomponent.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdpator extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Item> itemsList;
    private IValue iValue;

    public ItemAdpator(Context context, List<Item> itemsList) {
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
        view = LayoutInflater.from(mContext).inflate(R.layout.card_layout, parent, false);
        return new ItemsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Item item = itemsList.get(position);
            final ItemsViewHolder itemHolder = (ItemsViewHolder) holder;
            itemHolder.itemTitle.setText(item.getName());
            itemHolder.itemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Text=itemHolder.item_info.getText().toString();

                    if (iValue != null) {
                        iValue.onTitleClicked(Text);
                    }
                }
            });
            itemHolder.itemSubTitle.setText(item.getSubTitle());
            itemHolder.itemImage.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemSubTitle;
        EditText item_info;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_name);
            itemSubTitle = itemView.findViewById(R.id.card_contact);
            item_info=itemView.findViewById(R.id.item_info);
        }
    }
    public void setValueEnteredListner(IValue iValue) {
        this.iValue = iValue;
    }
}

