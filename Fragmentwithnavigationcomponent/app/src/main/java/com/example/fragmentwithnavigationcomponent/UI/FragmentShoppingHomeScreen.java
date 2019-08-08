package com.example.fragmentwithnavigationcomponent.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.fragmentwithnavigationcomponent.Model.IValue;
import com.example.fragmentwithnavigationcomponent.Model.ShoppingItemAdpater;
import com.example.fragmentwithnavigationcomponent.Model.ShoppingItems;
import com.example.fragmentwithnavigationcomponent.R;
import com.example.fragmentwithnavigationcomponent.Util.AlertBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FragmentShoppingHomeScreen extends Fragment implements IValue, View.OnClickListener {
    ImageButton mCart;
    public static HashMap<Integer, ShoppingItems> hashMap = new HashMap<>();
    int i = 0;
    int counter = 0;
    public static List<ShoppingItems> shoppingItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {


            View view = inflater.inflate(R.layout.fragment_shopping_home_screen, container, false);
            initView(view);
            // Replace 'android.R.id.list' with the 'id' of your RecyclerView
            RecyclerView mRecyclerView = view.findViewById(R.id.Recycle_view_shopping);
            GridLayoutManager mLayoutManager = new GridLayoutManager(this.getActivity(), 2);
            mRecyclerView.setLayoutManager(mLayoutManager);
            ShoppingItemAdpater mAdapter = new ShoppingItemAdpater(this.getActivity(), getDummyItemsList());
            mAdapter.setValueEnteredListner(this);
            mRecyclerView.setAdapter(mAdapter);

            return view;
        } catch (Exception ex) {
            Log.e(TAG, "onCreateView: " + ex);
            return null;
        }

    }

    public void initView(View view) {
        mCart = view.findViewById(R.id.cart);
        mCart.setOnClickListener(this);
    }

    private List<ShoppingItems> getDummyItemsList() {

        List<ShoppingItems> itemList = new ArrayList<>();

        ShoppingItems item;

        item = new ShoppingItems();
        item.setName("Orange");
        item.setPrice("₹20");
        item.setImage(R.drawable.orange);
        itemList.add(item);

        item = new ShoppingItems();
        item.setName("Apple");
        item.setPrice("₹50");
        item.setImage(R.drawable.apple);
        itemList.add(item);

        item = new ShoppingItems();
        item.setName("Mango");
        item.setPrice("₹80");
        item.setImage(R.drawable.mango);
        itemList.add(item);

        item = new ShoppingItems();
        item.setName("Strawberry");
        item.setPrice("₹40");
        item.setImage(R.drawable.strawberry);
        itemList.add(item);

        item = new ShoppingItems();
        item.setName("WaterMellon");
        item.setPrice("₹60");
        item.setImage(R.drawable.watermellon);
        itemList.add(item);


        item = new ShoppingItems();
        item.setName("Kiwi");
        item.setPrice("₹100");
        item.setImage(R.drawable.kiwi);
        itemList.add(item);


        item = new ShoppingItems();
        item.setName("Grapes");
        item.setPrice("₹80");
        item.setImage(R.drawable.grapes);
        itemList.add(item);


        return itemList;
    }

    @Override
    public void onTitleClicked(ShoppingItems items) {
        shoppingItems.add(items);
        if (counter == 0) {
            hashMap.put(i, items);
            counter++;
        }
        else {
            int j = isMap(items);
            if (j == 0) {
                hashMap.put(i++, items);
            } else if (j >= 1) {
                hashMap.put(j, items);
            }
            AlertBox alertBox = new AlertBox();
            try {
                alertBox.showAlert(this.getActivity(), "Added \t" + hashMap.get(0) + "\t To Cart" + j + "Value of i" + i);

            } catch (Exception ex) {
                Log.e(TAG, "onTitleClicked: " + ex);
            }
        }
    }


    private int isMap(ShoppingItems items) {
        for (Map.Entry item : hashMap.entrySet()) {
            ShoppingItems cartItem = (ShoppingItems) item.getValue();
            Toast.makeText(getActivity(), "" + cartItem.getName() + "\n" + items.getName() + "\n" + item.getKey(), Toast.LENGTH_LONG).show();
            if (cartItem.getName().equalsIgnoreCase(items.getName())) {
                return (int) item.getKey();
            }
        }
        return 0;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cart:
                NavController navController = Navigation.findNavController(getActivity(), R.id.shopping_nav_host_fragment);
                navController.navigate(R.id.action_fragmentShoppingHomeScreen_to_fragment_Cart);
                break;
        }
    }

}
