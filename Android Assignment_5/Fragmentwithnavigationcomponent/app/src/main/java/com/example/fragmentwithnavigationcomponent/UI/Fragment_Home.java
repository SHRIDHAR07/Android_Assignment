package com.example.fragmentwithnavigationcomponent.UI;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentwithnavigationcomponent.Model.Item;
import com.example.fragmentwithnavigationcomponent.Model.ItemAdpator;
import com.example.fragmentwithnavigationcomponent.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Home extends Fragment {
    public Fragment_Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Replace 'android.R.id.list' with the 'id' of your RecyclerView
        RecyclerView mRecyclerView =view.findViewById(R.id.items_list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        ItemAdpator mAdapter = new ItemAdpator(this.getActivity(),getDummyItemsList());
        mRecyclerView.setAdapter(mAdapter);
        return view;

    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
    private List<Item> getDummyItemsList() {
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

    }


}
