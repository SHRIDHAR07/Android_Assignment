package com.example.fragmentwithnavigationcomponent.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentwithnavigationcomponent.Adpater.ShoppingCartAdpater;
import com.example.fragmentwithnavigationcomponent.Model.CartItem;
import com.example.fragmentwithnavigationcomponent.Model.IValue;
import com.example.fragmentwithnavigationcomponent.Model.Product;
import com.example.fragmentwithnavigationcomponent.R;
import com.example.fragmentwithnavigationcomponent.Util.AlertBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;



public class ShoppingCartFragment extends Fragment implements IValue {
   private List<Product> productItemList = new ArrayList<>();
    private Map<Product,Integer> hashMap = new HashMap<>();
    private List<CartItem> cartItems = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        // finalProductList=getArguments().getParcelableArrayList("products");
        if (getArguments() != null) {
            productItemList = getArguments().getParcelableArrayList("products");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            View view = inflater.inflate(R.layout.fragment_cart, container, false);
            initview(view);


            return view;
        } catch (Exception ex) {
            Log.e(TAG, "onCreateView: " + ex);
            return null;
        }

    }

    private void initview(View view) {
        listToHash(productItemList);
        RecyclerView mRecyclerView = view.findViewById(R.id.recycle_cart);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        ShoppingCartAdpater mAdapter = new ShoppingCartAdpater(this.getActivity(), cartItems);
        mAdapter.setValueEnteredListner(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void listToHash(List<Product> productItemList) {
        for(int iterator=0;iterator<productItemList.size();iterator++){

            if(isItemPresent(productItemList.get(iterator))){
                int value = isMap(productItemList.get(iterator));
                hashMap.put(productItemList.get(iterator), ++value);

            }else{
                Integer value =1;
                hashMap.put(productItemList.get(iterator),value);
            }

        }
        hashMapToCartList(hashMap);
    }

    private void hashMapToCartList(Map<Product, Integer> hashMap) {
        CartItem cartItem;
        for (Map.Entry<Product, Integer> itemMap : hashMap.entrySet()) {
             cartItem = new CartItem();
            cartItem.setProduct(itemMap.getKey());
            cartItem.setQuantity(itemMap.getValue());
            cartItems.add(cartItem);

        }

    }

    private int isMap(Product items) {
        for (Map.Entry<Product, Integer> itemMap : hashMap.entrySet()) {
            if (itemMap.getKey().getName().equals(items.getName())) {
                return itemMap.getValue();
            }
        }
        return 0;
    }

    private boolean isItemPresent(Product items) {
        for (Map.Entry<Product, Integer> itemMap : hashMap.entrySet()) {
            if (itemMap.getKey().getName().equals(items.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onImageClick(Product product) {

    }
}
