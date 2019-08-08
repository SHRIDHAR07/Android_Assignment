package com.example.fragmentwithnavigationcomponent.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentwithnavigationcomponent.Model.CartAdpater;
import com.example.fragmentwithnavigationcomponent.Model.IValue;
import com.example.fragmentwithnavigationcomponent.Model.ShoppingItems;
import com.example.fragmentwithnavigationcomponent.R;
import com.example.fragmentwithnavigationcomponent.Util.AlertBox;

import java.util.HashMap;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.example.fragmentwithnavigationcomponent.UI.FragmentShoppingHomeScreen.hashMap;
import static com.example.fragmentwithnavigationcomponent.UI.FragmentShoppingHomeScreen.shoppingItems;


public class Fragment_Cart extends Fragment implements IValue {

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            View view = inflater.inflate(R.layout.fragment_cart, container, false);
            RecyclerView mRecyclerView = view.findViewById(R.id.recycle_cart);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
            CartAdpater mAdapter = new CartAdpater(this.getActivity(), hashMap);
            mAdapter.setValueEnteredListner(this);
            mRecyclerView.setAdapter(mAdapter);

            return view;
        } catch (Exception ex) {
            Log.e(TAG, "onCreateView: " + ex);
            return null;
        }

    }


    @Override
    public void onTitleClicked(ShoppingItems text) {

        AlertBox alertBox = new AlertBox();
        try {
            alertBox.showAlert(this.getActivity(), "" + text.getName());

        } catch (Exception ex) {
            Log.e(TAG, "onTitleClicked: " + ex);
        }


    }
}
