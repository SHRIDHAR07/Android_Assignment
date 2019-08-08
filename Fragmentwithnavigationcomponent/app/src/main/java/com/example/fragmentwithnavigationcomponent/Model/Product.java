package com.example.fragmentwithnavigationcomponent.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    protected int image;
    protected String name;
    protected String price;

    public Product(Parcel in) {
        image = in.readInt();
        name = in.readString();
        price = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public Product() {
        image =0;
        name =null;
        price =null;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(name);
        parcel.writeString(price);
    }
}
