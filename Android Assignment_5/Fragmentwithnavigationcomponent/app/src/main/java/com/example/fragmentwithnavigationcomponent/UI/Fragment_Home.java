package com.example.fragmentwithnavigationcomponent.UI;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentwithnavigationcomponent.Model.IValue;
import com.example.fragmentwithnavigationcomponent.Model.Item;
import com.example.fragmentwithnavigationcomponent.Model.ItemAdpator;
import com.example.fragmentwithnavigationcomponent.R;
import com.example.fragmentwithnavigationcomponent.Util.AlertBox;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class Fragment_Home extends Fragment implements IValue {
    public Fragment_Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        try {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Replace 'android.R.id.list' with the 'id' of your RecyclerView
        RecyclerView mRecyclerView =view.findViewById(R.id.items_list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        ItemAdpator mAdapter = new ItemAdpator(this.getActivity(),getDummyItemsList());
        mAdapter.setValueEnteredListner(this);
        mRecyclerView.setAdapter(mAdapter);
            return view;
    }catch (Exception ex){
            Log.e(TAG, "onCreateView: "+ex );
            return null;
        }

    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
    private List<Item> getDummyItemsList() {
        try {


        List<Item> itemList = new ArrayList<>();
        Item item;

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Mahesh Sharma");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Shridhar Gaikwad");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Apurva Shepal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Hemakant G");
        item.setSubTitle("React Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.contacts);
        itemList.add(item);

        return itemList;
        }catch (Exception ex){
            Log.e(TAG, "getDummyItemsList: "+ex);
            return null;
        }
    }


    @Override
    public void onTitleClicked(String text) {
        AlertBox alertBox =new AlertBox();
        try {
            alertBox.showAlert(this.getActivity(),""+text);
        }catch (Exception ex){
            Log.e(TAG, "onTitleClicked: "+ex);
        }


    }
}
