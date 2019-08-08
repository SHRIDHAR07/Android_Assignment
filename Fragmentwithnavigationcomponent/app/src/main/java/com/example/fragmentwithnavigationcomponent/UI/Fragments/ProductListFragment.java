package com.example.fragmentwithnavigationcomponent.UI.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.fragmentwithnavigationcomponent.Model.CartItem;
import com.example.fragmentwithnavigationcomponent.Model.IValue;
import com.example.fragmentwithnavigationcomponent.Adpater.ProductsAdpater;
import com.example.fragmentwithnavigationcomponent.Model.Product;
import com.example.fragmentwithnavigationcomponent.R;
import com.example.fragmentwithnavigationcomponent.Util.AlertBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ProductListFragment extends Fragment implements IValue, View.OnClickListener {
    private List<Product> productsList = new ArrayList<>();
    private List<Product> uniquePorductList =new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            View view = inflater.inflate(R.layout.fragment_shopping_home_screen, container, false);
            initView(view);
            return view;
        } catch (Exception ex) {
            Log.e(TAG, "onCreateView: " + ex);
            View view = inflater.inflate(R.layout.fragment_shopping_home_screen, container, false);
            return view;
        }
    }

    public void initView(View view) {
        ImageButton mCart = view.findViewById(R.id.cart);
        mCart.setOnClickListener(this);
        RecyclerView mRecyclerView = view.findViewById(R.id.Recycle_view_shopping);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this.getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ProductsAdpater mAdapter = new ProductsAdpater(this.getActivity(), getProductsListList());
        mAdapter.setValueEnteredListner(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Product> getProductsListList() {

        Product product;

        product = new Product();
        product.setName("Orange");
        product.setPrice("₹20");
        product.setImage(R.drawable.orange);
        productsList.add(product);

        product = new Product();
        product.setName("Apple");
        product.setPrice("₹50");
        product.setImage(R.drawable.apple);
        productsList.add(product);

        product = new Product();
        product.setName("Mango");
        product.setPrice("₹80");
        product.setImage(R.drawable.mango);
        productsList.add(product);

        product = new Product();
        product.setName("Strawberry");
        product.setPrice("₹40");
        product.setImage(R.drawable.strawberry);
        productsList.add(product);

        product = new Product();
        product.setName("WaterMellon");
        product.setPrice("₹60");
        product.setImage(R.drawable.watermellon);
        productsList.add(product);


        product = new Product();
        product.setName("Kiwi");
        product.setPrice("₹100");
        product.setImage(R.drawable.kiwi);
        productsList.add(product);


        product = new Product();
        product.setName("Grapes");
        product.setPrice("₹80");
        product.setImage(R.drawable.grapes);
        productsList.add(product);


        return productsList;
    }


  /*  private int isMap(Product items) {
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
    }*/

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cart:
                ShoppingCartFragment shoppingCartFragment = new ShoppingCartFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("products", (ArrayList<? extends Parcelable>) uniquePorductList);
                shoppingCartFragment.setArguments(bundle);
                NavController navController = Navigation.findNavController(getActivity(), R.id.shopping_nav_host_fragment);
                navController.navigate(R.id.action_fragmentShoppingHomeScreen_to_fragment_Cart,bundle);
                break;
        }
    }

    @Override
    public void onImageClick(Product product) {
        uniquePorductList.add(product);
        AlertBox alertBox=new AlertBox();
        alertBox.showAlert(getActivity(),"");

    }
}
